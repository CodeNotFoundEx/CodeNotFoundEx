package com.codenotfoundex.micro.cv;

import com.codenotfoundex.micro.cv.model.CvData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Base64;
import java.util.List;
import java.util.Map;

@Service
public class CvParserService {

    private static final String PROMPT = """
            Extract all information from this software engineering CV/resume.
            Return ONLY a JSON object — no markdown, no explanation — matching exactly this structure:
            {
              "name": "full name",
              "title": "job title",
              "contact": {
                "phones": ["phone1"],
                "email": "email@example.com",
                "stackOverflow": "url or null"
              },
              "skills": {
                "primaryLanguages": ["lang1"],
                "frameworks": ["fw1"],
                "techStack": ["tech1"],
                "packageManagement": ["tool1"],
                "versionControl": ["tool1"],
                "databases": ["db1"],
                "containerization": ["tool1"],
                "orchestration": ["tool1"],
                "otherLanguages": ["lang1"]
              },
              "summary": ["bullet point 1"],
              "experience": [
                {
                  "company": "company name",
                  "client": "client name or null",
                  "role": "role title",
                  "location": "location",
                  "startDate": "Mon YYYY",
                  "endDate": "Mon YYYY or null if current position",
                  "achievements": ["achievement1"]
                }
              ],
              "education": [
                {
                  "institution": "university name",
                  "degree": "degree type",
                  "field": "field of study",
                  "period": "years or null",
                  "thesis": "thesis title or null"
                }
              ],
              "publications": [
                {
                  "title": "paper title",
                  "journal": "journal or conference name",
                  "year": "YYYY",
                  "isbn": "ISBN or null"
                }
              ]
            }
            """;

    private final WebClient webClient;
    private final ObjectMapper objectMapper;

    @Value("${anthropic.api-key}")
    private String apiKey;

    @Value("${anthropic.model:claude-sonnet-4-6}")
    private String model;

    public CvParserService() {
        this.webClient = WebClient.builder().baseUrl("https://api.anthropic.com").build();
        this.objectMapper = new ObjectMapper();
    }

    public Mono<CvData> parse(byte[] pdfBytes) {
        String base64Pdf = Base64.getEncoder().encodeToString(pdfBytes);

//        var request = Map.of(
//                "model", model,
//                "max_tokens", 4096,
//                "messages", List.of(Map.of(
//                        "role", "user",
//                        "content", List.of(
//                                Map.of(
//                                        "type", "document",
//                                        "source", Map.of(
//                                                "type", "base64",
//                                                "media_type", "application/pdf",
//                                                "data", base64Pdf
//                                        )
//                                ),
//                                Map.of("type", "text", "text", PROMPT)
//                        )
//                ))
//        );

//        return webClient.post()
//                .uri("/v1/messages")
//                .header("x-api-key", apiKey)
//                .header("anthropic-version", "2023-06-01")
//                .contentType(MediaType.APPLICATION_JSON)
//                .bodyValue(request)
//                .retrieve()
//                .bodyToMono(AnthropicResponse.class)
//                .map(response -> toCvData(stripMarkdown(response.content().getFirst().text())));
        return Mono.empty();
    }

    private String stripMarkdown(String text) {
        return text.replaceAll("(?s)^```(?:json)?\\s*", "").replaceAll("\\s*```$", "").strip();
    }

    private CvData toCvData(String json) {
        try {
            return objectMapper.readValue(json, CvData.class);
        } catch (JsonProcessingException e) {
            throw new CvParseException("Failed to parse CV data from AI response: " + e.getMessage(), e);
        }
    }

    private record AnthropicResponse(List<ContentBlock> content) {}
    private record ContentBlock(String type, String text) {}
}
