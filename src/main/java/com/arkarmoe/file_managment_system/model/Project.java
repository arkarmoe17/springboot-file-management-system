package com.arkarmoe.file_managment_system.model;

import java.util.Date;

/**
 * Created by Arkar Moe
 * 11-Sept-2019
 * **/
public class Project {
    private String siteCode;
    private String region;
    private String towerType;
    private String towerHight;
    private String partner;
    private Date rfiDate;
    private double rentalPrice;

    public Project() {
    }

    public Project(String siteCode, String region, String towerType, String towerHight, String partner, Date rfiDate, double rentalPrice) {
        this.siteCode = siteCode;
        this.region = region;
        this.towerType = towerType;
        this.towerHight = towerHight;
        this.partner = partner;
        this.rfiDate = rfiDate;
        this.rentalPrice = rentalPrice;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTowerType() {
        return towerType;
    }

    public void setTowerType(String towerType) {
        this.towerType = towerType;
    }

    public String getTowerHight() {
        return towerHight;
    }

    public void setTowerHight(String towerHight) {
        this.towerHight = towerHight;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public Date getRfiDate() {
        return rfiDate;
    }

    public void setRfiDate(Date rfiDate) {
        this.rfiDate = rfiDate;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }
}
