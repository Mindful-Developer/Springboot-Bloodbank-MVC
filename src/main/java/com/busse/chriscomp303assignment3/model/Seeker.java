package com.busse.chriscomp303assignment3.model;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;


public class Seeker {
    @Getter @Setter
    private Long id;

    @Getter @Setter
    @NotBlank(message = "First name is required")
    private String firstName;

    @Getter @Setter
    @NotBlank(message = "Last name is required")
    private String lastName;

    @Getter @Setter
    @NotNull(message = "Age is required")
    @Min(value = 0, message = "Age must be greater than 0")
    @Max(value = 150, message = "Age must be less than 150")
    private Integer age;

    @Getter @Setter
    @NotBlank(message = "Blood group is required")
    private String bloodGroup;

    @Getter @Setter
    @NotBlank(message = "City is required")
    private String city;

    @Getter @Setter
    @NotBlank(message = "Phone is required")
    @Pattern(regexp = "\\d{10}", message = "Phone must be 10 digits")
    private String phone;
}