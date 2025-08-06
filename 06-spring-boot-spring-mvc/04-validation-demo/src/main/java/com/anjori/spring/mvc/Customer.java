package com.anjori.spring.mvc;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Customer {

    private String firstName;

    @NotNull(message= "is required")
    @Size(min=1, message= "is required")
    private String lastName;

    @Min(value=0, message="Must be greater than or equal to Zero")
    @Max(value=10, message="Must be less than or equal to Ten")
    private int freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message= "Only 5 chars/digits")
    private String postalCode;
}
