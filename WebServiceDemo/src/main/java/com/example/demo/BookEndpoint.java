package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.example.book.Book;
import com.example.book.GetBookRequest;
import com.example.book.GetBookResponse;

@Endpoint
public class BookEndpoint {

    private static final String NAMESPACE_URI = "http://www.example.com/book";

    @Autowired
    BookRepository bookRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBookRequest")
    public @ResponsePayload GetBookResponse getBookByIsbn(@RequestPayload GetBookRequest request)
            throws InterruptedException {
        GetBookResponse response = new GetBookResponse();
        Book book = bookRepository.findBookByIsbn(request.getIsbn());
        response.setBook(book);
        return response;
    }
}