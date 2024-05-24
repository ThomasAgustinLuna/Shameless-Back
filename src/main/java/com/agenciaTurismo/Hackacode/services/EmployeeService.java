package com.agenciaTurismo.Hackacode.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.agenciaTurismo.Hackacode.entities.Employee;
import com.agenciaTurismo.Hackacode.enums.PositionType;
import com.agenciaTurismo.Hackacode.exceptions.MyException;
import com.agenciaTurismo.Hackacode.repositories.EmployeeRepository;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void createEmployee(String name, String surname, String adress, Integer dni, Date birthDate,
            String nationality, String phoneNumber, String email, PositionType position, Double salary)
            throws MyException {

        validate(name, surname, adress, dni, birthDate, nationality, phoneNumber, email);

        Employee employee = new Employee();

        employee.setName(name);
        employee.setSurname(surname);
        employee.setAdress(adress);
        employee.setDni(dni);
        employee.setBirthDate(birthDate);
        employee.setNationality(nationality);
        employee.setPhoneNumb(phoneNumber);
        employee.setEmail(email);
        employee.setPosition(position);
        employee.setSalary(salary);
        employee.setStatus(true);

        employeeRepository.save(employee);

    }

    public List<Employee> ListEmployees() {
        List<Employee> employees = new ArrayList<>();

        employees = employeeRepository.findByStatus(true);

        return employees;
    }

    public Employee GetEmployee(String id) {

        Optional<Employee> employee = employeeRepository.findById(id);

        employee = employeeRepository.findById(id);

        return employee.orElse(null);
    }

    public void modifyEmployee(String employeeId, String name, String surname, String adress, Integer dni,
            Date bithDate, String nationality, String phoneNumber, String email, PositionType position, Double salary)
            throws MyException {

        if (employeeId == null) {
            throw new MyException("El codigo de producto no puede ser nulo");
        }
        validate(name, surname, adress, dni, bithDate, nationality, phoneNumber, email);
        Optional<Employee> ans = employeeRepository.findById(employeeId);

        if (ans.isPresent()) {
            Employee employee = ans.get();
            if (employee.getStatus()) {
                employee.setName(name);
                employee.setSurname(surname);
                employee.setAdress(adress);
                employee.setDni(dni);
                employee.setBirthDate(bithDate);
                employee.setNationality(nationality);
                employee.setPhoneNumb(phoneNumber);
                employee.setEmail(email);
                employee.setPosition(position);
                employee.setSalary(salary);

                employeeRepository.save(employee);
            } else {
                throw new MyException("No hay registro de ese empleado");
            }

        }

    }

    public void deleteEmployee(String employeeId) throws MyException {
        if (employeeId == null) {
            throw new MyException("El Id no puede ser nulo");
        }
        Optional<Employee> ans = employeeRepository.findById(employeeId);

        if (ans.isPresent()) {
            Employee employee= ans.get();
            if (employee.isStatus()) {
                employee.setStatus(false);
            }
        }

    }

    private void validate(String name, String surname, String adress, Integer dni, Date birthDate, String nationality,
            String phoneNumber, String email) throws MyException {

        if (name == null || name.isEmpty()) {
            throw new MyException("El nombre no puede ser nulo");
        }
        if (surname == null || surname.isEmpty()) {
            throw new MyException("El apellido no puede ser nulo");
        }
        if (adress == null || adress.isEmpty()) {
            throw new MyException("La direccion no puede ser nula");
        }
        if (dni == null) {
            throw new MyException("El dni no puede ser nulo");
        }
        if (birthDate == null) {
            throw new MyException("La fecha de nacimiento no puede ser nula");
        }
        if (nationality == null || nationality.isEmpty()) {
            throw new MyException("La Nacionalidad no puede ser nula");
        }
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            throw new MyException("El numero de telefono no puede ser nulo");
        }
        if (email == null || email.isEmpty()) {
            throw new MyException("El email no puede ser nulo");
        }
                                           

    }

}
