package com.usedtextbooks.backend.mapper;

import com.usedtextbooks.backend.dto.BookPatchRequest;
import com.usedtextbooks.backend.dto.BookRequest;
import com.usedtextbooks.backend.dto.BookResponse;
import com.usedtextbooks.backend.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public Book toEntity(BookRequest request){
        return Book.builder()
                .isbn(request.getIsbn())
                .title(request.getTitle())
                .author(request.getAuthor())
                .edition(request.getEdition())
                .price(request.getPrice())
                .bookCondition(request.getBookCondition())
                .build();
    }

    public BookResponse toResponse(Book book){
        return BookResponse.builder()
                .id(book.getId())
                .isbn(book.getIsbn())
                .title(book.getTitle())
                .author(book.getAuthor())
                .edition(book.getEdition())
                .price(book.getPrice())
                .bookCondition(book.getBookCondition())
                .status(book.getStatus())
                .createdAt(book.getCreatedAt())
                .updatedAt(book.getUpdatedAt())
                .build();
    }

    public void toPatchEntity(Book book, BookPatchRequest request) {
        if( request.getIsbn() != null){
            book.setIsbn(request.getIsbn());
        }
        if( request.getTitle() != null) {
            book.setTitle(request.getTitle());
        }
        if( request.getAuthor() != null) {
            book.setAuthor(request.getAuthor());
        }
        if( request.getEdition() != null) {
            book.setEdition(request.getEdition());
        }
        if( request.getPrice() != null) {
            book.setPrice(request.getPrice());
        }
        if( request.getBookCondition() != null){
            book.setBookCondition(request.getBookCondition());
        }
    }

}
