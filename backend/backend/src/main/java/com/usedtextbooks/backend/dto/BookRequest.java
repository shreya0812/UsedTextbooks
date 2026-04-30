package com.usedtextbooks.backend.dto;

import com.usedtextbooks.backend.enums.BookCondition;
import com.usedtextbooks.backend.enums.BookStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BookRequest {

    @NotBlank(message = "ISBN is required")
    private String isbn;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Author is required")
    private String author;

    private String edition;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.1", message = "Price must be greater than zero")
    private BigDecimal price;

    @NotNull(message = "Book condition is required")
    private BookCondition bookCondition;

}
