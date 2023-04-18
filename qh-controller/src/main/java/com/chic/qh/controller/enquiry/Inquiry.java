package com.chic.qh.controller.enquiry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inquiry {
    private Integer id;
    private String name;
    private String customer;
    private String createdAt;
}
