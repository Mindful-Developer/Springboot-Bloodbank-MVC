package com.busse.chriscomp303assignment3.model;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;


public class BloodBank {
    @Getter @Setter
    private Long id;

    @Getter @Setter
    @NotBlank(message = "Blood bank name is required")
    private String bloodbankName;

    @Getter @Setter
    @NotBlank(message = "Address is required")
    private String address;

    @Getter @Setter
    @NotBlank(message = "City is required")
    private String city;

    @Getter @Setter
    @NotBlank(message = "Phone is required")
    @Pattern(regexp = "\\d{10}", message = "Phone must be 10 digits")
    private String phone;

    @Getter @Setter
    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;
}