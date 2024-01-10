package com.devproblems.grpc.client.controller;

import com.devproblems.grpc.client.service.BookAuthorClientService;
import com.google.protobuf.Descriptors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
public class BookAuthorController {

    @Autowired
    private BookAuthorClientService bookAuthorClientService;

    @QueryMapping("getAuthor")
    public Map<Descriptors.FieldDescriptor, Object> getAuthor(@Argument int authorId) {
        return bookAuthorClientService.getAuthor(authorId);
    }

    @QueryMapping("getBooks")
    public List<Map<Descriptors.FieldDescriptor, Object>> getBookByAuthor(@Argument String id) throws InterruptedException {
        return bookAuthorClientService.getBooksByAuthor(Integer.parseInt(id));
    }

    @QueryMapping("allBooks")
    public Map<String, Map<Descriptors.FieldDescriptor, Object>> getExpensiveBook() throws InterruptedException {
        return bookAuthorClientService.getExpensiveBook();
    }

    @QueryMapping("getBooksByGender")
    public List<Map<Descriptors.FieldDescriptor, Object>> getBookByGender(@Argument String gender) throws InterruptedException {
        return bookAuthorClientService.getBooksByGender(gender);
    }
}
