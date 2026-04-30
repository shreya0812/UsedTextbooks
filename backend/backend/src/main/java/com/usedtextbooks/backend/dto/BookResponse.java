package com.usedtextbooks.backend.dto;

import com.usedtextbooks.backend.enums.BookCondition;
import com.usedtextbooks.backend.enums.BookStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class BookResponse {
    private Long id;
    private String isbn;
    private String title;
    private String author;
    private String edition;
    private BigDecimal price;
    private BookCondition bookCondition;
    private BookStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
