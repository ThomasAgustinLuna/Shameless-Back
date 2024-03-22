package com.agenciaTurismo.Hackacode.dtos;

public class TouristPackageDto {
    private String name;
    private String descript;
    private String startDate;
    private Double price;
    private String pc1;
    private String pc2;
    private String pc3;
    private String pc4;
    private String pc5;



    public TouristPackageDto() {
    }


    public TouristPackageDto(String name, String descript, String startDate, Double price, String pc1, String pc2, String pc3, String pc4, String pc5) {
        this.name = name;
        this.descript = descript;
        this.startDate = startDate;
        this.price = price;
        this.pc1 = pc1;
        this.pc2 = pc2;
        this.pc3 = pc3;
        this.pc4 = pc4;
        this.pc5 = pc5;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescript() {
        return this.descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPc1() {
        return this.pc1;
    }

    public void setPc1(String pc1) {
        this.pc1 = pc1;
    }

    public String getPc2() {
        return this.pc2;
    }

    public void setPc2(String pc2) {
        this.pc2 = pc2;
    }

    public String getPc3() {
        return this.pc3;
    }

    public void setPc3(String pc3) {
        this.pc3 = pc3;
    }

    public String getPc4() {
        return this.pc4;
    }

    public void setPc4(String pc4) {
        this.pc4 = pc4;
    }

    public String getPc5() {
        return this.pc5;
    }

    public void setPc5(String pc5) {
        this.pc5 = pc5;
    }
    
}
