package com.usedtextbooks.backend.controller;

import com.usedtextbooks.backend.dto.BookPatchRequest;
import com.usedtextbooks.backend.dto.BookRequest;
import com.usedtextbooks.backend.dto.BookResponse;
import com.usedtextbooks.backend.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //Get All Books
    @GetMapping
    public ResponseEntity<List<BookResponse>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    //Get Book By Id
    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable Long id){
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    //Create Book
    @PostMapping
    public ResponseEntity<BookResponse> createBook(@RequestBody BookRequest bookRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(bookService.createBook(bookRequest));
    }
    //Update Book Put
    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> updateBook(@PathVariable Long id,@Valid @RequestBody BookRequest bookRequest){
        return ResponseEntity.ok(bookService.updateBook(id, bookRequest));
    }

    //Update Book Patch
    @PatchMapping("/{id}")
    public ResponseEntity<BookResponse> patchBook(@PathVariable Long id, @RequestBody BookPatchRequest bookPatchRequest){
        return ResponseEntity.ok(bookService.patchBook(id,bookPatchRequest));
    }

    //Delete Book
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
