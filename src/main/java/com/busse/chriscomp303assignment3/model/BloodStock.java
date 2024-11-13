package com.busse.chriscomp303assignment3.model;

import jakarta.validation.constraints.*;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;


public class BloodStock {
    @Getter @Setter
    private Long id;

    @Getter @Setter
    @NotBlank(message = "Blood group is required")
    private String bloodGroup;

    @Getter @Setter
    @NotNull(message = "Quantity is required")
    @Min(value = 0, message = "Quantity must be greater than or equal to 0")
    private Integer quantity;

    @Getter @Setter
    @NotNull(message = "Best before date is required")
    @Future(message = "Best before date must be in the future")
    private LocalDate bestBefore;

    @Getter @Setter
    @NotNull(message = "Status is required")
    private Status status;

    public enum Status {
        AVAILABLE, LOW, CRITICAL, EXPIRED
    }
}