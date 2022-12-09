package com.employee.management.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EMResponseEntity {
    int code;
    String message;
    Object data;
}
