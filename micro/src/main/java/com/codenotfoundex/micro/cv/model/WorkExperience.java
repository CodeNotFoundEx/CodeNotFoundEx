package com.codenotfoundex.micro.cv.model;

import java.util.List;

public record WorkExperience(
        String company,
        String client,
        String role,
        String location,
        String startDate,
        String endDate,
        List<String> achievements
) {}
