package com.codenotfoundex.micro.cv.model;

import java.util.List;

public record CvData(
        String name,
        String title,
        ContactInfo contact,
        Skills skills,
        List<String> summary,
        List<WorkExperience> experience,
        List<Education> education,
        List<Publication> publications
) {}
