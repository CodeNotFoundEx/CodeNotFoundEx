package com.codenotfoundex.micro.cv.model;

import java.util.List;

public record Skills(
        List<String> primaryLanguages,
        List<String> frameworks,
        List<String> techStack,
        List<String> packageManagement,
        List<String> versionControl,
        List<String> databases,
        List<String> containerization,
        List<String> orchestration,
        List<String> otherLanguages
) {}
