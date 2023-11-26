package com.example.demo;

import com.example.pen.GetPenRequest;
import com.example.pen.GetPenResponse;
import com.example.pen.Pen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PenEndpoint {

    private static final String NAMESPACE_URI = "http://www.example.com/pen";

    @Autowired
    TestRepository testRepository;

    @PostMapping("/penService")
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPenRequest")
    public @ResponsePayload GetPenResponse getBookByIsbn(@RequestPayload GetPenRequest request)
            throws InterruptedException {
        GetPenResponse response = new GetPenResponse();
        Pen pen = testRepository.findPenByIsbn(request.getId());
        response.setPen(pen);
        return response;
    }
}