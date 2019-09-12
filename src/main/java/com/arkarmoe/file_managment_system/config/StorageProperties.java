package com.arkarmoe.file_managment_system.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
/**
 * Created by Arkar
 * Sept-10-2019
 * **/
@ConfigurationProperties(prefix = "storage")
public class StorageProperties {
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}