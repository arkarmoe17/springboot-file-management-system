package com.arkarmoe.file_managment_system.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.io.File;

public class ContentDispositionHeader {
    //header allow
    public static HttpHeaders getHeader(File file){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/vnd.ms-excel"));
        headers.add("Access-Control-Allow-Headers", "Content-Type");
        headers.add("Access-Control-Expose-Headers", "Content-Disposition");
        headers.add("Content-disposition", "attachment; filename=" + file.getName());
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        return headers;
    }
}
