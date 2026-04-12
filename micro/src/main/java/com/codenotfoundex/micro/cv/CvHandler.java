package com.codenotfoundex.micro.cv;

import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class CvHandler {

    private final CvParserService cvParserService;

    public CvHandler(CvParserService cvParserService) {
        this.cvParserService = cvParserService;
    }

    public Mono<ServerResponse> parse(ServerRequest request) {
        return request.multipartData()
                .map(parts -> parts.getFirst("file"))
                .cast(FilePart.class)
                .flatMap(filePart -> DataBufferUtils.join(filePart.content())
                        .map(dataBuffer -> {
                            byte[] bytes = new byte[dataBuffer.readableByteCount()];
                            dataBuffer.read(bytes);
                            DataBufferUtils.release(dataBuffer);
                            return bytes;
                        })
                )
                .flatMap(cvParserService::parse)
                .flatMap(cvData -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(cvData));
    }
}
