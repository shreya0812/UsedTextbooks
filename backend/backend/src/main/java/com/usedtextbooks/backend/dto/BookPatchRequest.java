package com.usedtextbooks.backend.dto;

import com.usedtextbooks.backend.enums.BookCondition;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BookPatchRequest {

    private String isbn;

    private String title;

    private String author;

    private String edition;

    @DecimalMin(value = "0.1", message = "Price must be greater than zero")
    private BigDecimal price;

    private BookCondition bookCondition;
}
