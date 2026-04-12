package com.codenotfoundex.micro.cv.model;

import java.util.List;

public record ContactInfo(
        List<String> phones,
        String email,
        String stackOverflow
) {}
