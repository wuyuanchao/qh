package com.chic.qh.controller.enquiry;

import lombok.Data;

@Data
public class Inquiry {
    private String name;
    private String customer;
    private String createdAt;

    public Inquiry() {
    }

    public Inquiry(String name, String customer, String createdAt) {
        this.name = name;
        this.customer = customer;
        this.createdAt = createdAt;
    }
}
