package com.organization.portal.exception;

import java.util.function.Supplier;

public class EmployNotFoundException extends RuntimeException {
    public EmployNotFoundException() {
    }

    public EmployNotFoundException(String message) {
        super(message);
    }
}
