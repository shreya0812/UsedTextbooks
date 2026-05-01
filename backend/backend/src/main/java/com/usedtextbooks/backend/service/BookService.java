package com.usedtextbooks.backend.service;

import com.usedtextbooks.backend.dto.BookPatchRequest;
import com.usedtextbooks.backend.dto.BookRequest;
import com.usedtextbooks.backend.dto.BookResponse;
import com.usedtextbooks.backend.entity.Book;
import com.usedtextbooks.backend.mapper.BookMapper;
import com.usedtextbooks.backend.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    //Get All Books
    public List<BookResponse> getAllBooks(){
        return bookRepository.findAll()
                                .stream()
                                .map(bookMapper::toResponse)
                                .toList();
    }

    //Get Book By Id
    public BookResponse getBookById(Long id){
        Book book =  bookRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Book Not Found with id: " + id));
        return bookMapper.toResponse(book);
    }

    //Create Book
    public BookResponse createBook(BookRequest bookRequest){
        Book savedBook = bookRepository.save(bookMapper.toEntity(bookRequest));
        return bookMapper.toResponse(savedBook);
    }

    //Update Book Put
    public BookResponse updateBook(Long id, BookRequest bookRequest){
       Book book =  bookRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Book Not Found with id: " + id));
       book.setIsbn(bookRequest.getIsbn());
       book.setTitle(bookRequest.getTitle());
       book.setAuthor(bookRequest.getAuthor());
       book.setEdition(bookRequest.getEdition());
       book.setPrice(bookRequest.getPrice());
       book.setBookCondition(bookRequest.getBookCondition());

       Book updatedBook = bookRepository.save(book);
       return bookMapper.toResponse(updatedBook);
    }

    //Update Book Patch
    public BookResponse patchBook(Long id, BookPatchRequest bookPatchRequest){
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Book Not Found with id: " + id));
        bookMapper.toPatchEntity(book, bookPatchRequest);
        Book updatedBook = bookRepository.save(book);
        return bookMapper.toResponse(updatedBook);
    }


    //Delete Book
    public void deleteBook(Long id){
        Book book =  bookRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Book Not Found with id: " + id));
        bookRepository.delete(book);
    }

}
