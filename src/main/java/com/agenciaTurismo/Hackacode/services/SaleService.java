package com.agenciaTurismo.Hackacode.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.agenciaTurismo.Hackacode.entities.Client;
import com.agenciaTurismo.Hackacode.entities.Employee;
import com.agenciaTurismo.Hackacode.entities.Sale;
import com.agenciaTurismo.Hackacode.entities.TouristPackage;
import com.agenciaTurismo.Hackacode.enums.PaymentType;
import com.agenciaTurismo.Hackacode.exceptions.MyException;
import com.agenciaTurismo.Hackacode.repositories.ClientRepository;
import com.agenciaTurismo.Hackacode.repositories.EmployeeRepository;
import com.agenciaTurismo.Hackacode.repositories.SaleRepository;
import com.agenciaTurismo.Hackacode.repositories.TouristPackageRepository;
import jakarta.transaction.Transactional;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private TouristPackageRepository touristPackageRepository;

    @Transactional
    public void crateSale(String clientId, String employeeId, PaymentType paymentType, String productCode)
            throws MyException {
        if (clientId == null || clientId.isEmpty()) {
            throw new MyException("El id del cliente no puede ser nulo");
        }
        if (employeeId == null || employeeId.isEmpty()) {
            throw new MyException("El id del empleado no puede ser nulo");
        }
        if (paymentType == null) {
            throw new MyException("La forma de pago no puede ser nula");
        }
        if (productCode == null || productCode.isEmpty()) {
            throw new MyException("El codigo de producto no puede ser nulo");
        }

        Sale sale = new Sale();
        Client client = clientRepository.findById(clientId).get();
        Employee employee = employeeRepository.findById(employeeId).get();
        TouristPackage touristPackage = touristPackageRepository.findById(productCode).get();

        sale.setSaleDate(new Date());
        sale.setPaymentType(paymentType);
        sale.setClient(client);
        sale.setEmployee(employee);
        sale.setProductPackage(touristPackage);
        sale.setStatus(true);

        saleRepository.save(sale);

    }

    public List<Sale> ListSales() {
        List<Sale> sales = new ArrayList<>();

        sales = saleRepository.findByStatus(true);

        return sales;
    }

    public void modifySale(Long saleNumber, String clientId, String employeeId, PaymentType paymentType,
            String productCode) throws MyException {
        if (saleNumber == null) {
            throw new MyException("El codigo de producto no puede ser nulo");
        }
        if (clientId == null || clientId.isEmpty()) {
            throw new MyException("El id del cliente no puede ser nulo");
        }
        if (employeeId == null || employeeId.isEmpty()) {
            throw new MyException("El id del empleado no puede ser nulo");
        }
        if (paymentType == null) {
            throw new MyException("La forma de pago no puede ser nula");
        }
        if (productCode == null || productCode.isEmpty()) {
            throw new MyException("El codigo de producto no puede ser nulo");
        }
        Optional<Sale> ans = saleRepository.findById(saleNumber);
        Optional<Client> ansCl = clientRepository.findById(clientId);
        Optional<Employee> ansEmp = employeeRepository.findById(employeeId);
        Optional<TouristPackage> ansPck = touristPackageRepository.findById(productCode);

        Client client = new Client();
        Employee employee = new Employee();
        TouristPackage touristPackage = new TouristPackage();

        if (ansCl.isPresent()) {
            client = ansCl.get();
        }
        if (ansEmp.isPresent()) {
            employee = ansEmp.get();
        }
        if (ansPck.isPresent()) {
            touristPackage = ansPck.get();
        }
        if (ans.isPresent()) {
            Sale sale = ans.get();
            if (sale.getStatus()) {
                sale.setClient(client);
                sale.setEmployee(employee);
                sale.setPaymentType(paymentType);
                sale.setProductPackage(touristPackage);

                saleRepository.save(sale);
            } else {
                throw new MyException("No hay registro de esa venta");
            }

        }
    }

}
