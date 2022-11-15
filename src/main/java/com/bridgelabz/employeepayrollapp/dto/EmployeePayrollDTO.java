package com.bridgelabz.employeepayrollapp.dto;

import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;

//Using @Data is equivalent to using @code @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
//Using various annotations like @pattern @min to put validations on the class
public @Data class EmployeePayrollDTO {
// @NotNull: The CharSequence, Collection, Map or Array object is not null, but can be empty.
// @NotEmpty: The CharSequence, Collection, Map or Array object is not null and size > 0.
// @NotBlank: The string is not null and the trimmed length is greater than zero.


// @NotEmpty(message = "First name cannot be null and must have size greater than 0",means we cannot use
//without giving something to firstname there must be something but in case of not null can use empty string.

    @NotEmpty
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "Employee First Name Invalid")
    public String firstName;

    // @NotNull(message = "Second name must not be null, empty value/space can be considered")
    @NotNull
    public String lastName;

// @NotBlank(message = "Profile must not be null and must contain 1 or more characters")
    @NotBlank
    public String profilePic;

    @FutureOrPresent
    LocalDate date;

    @NotNull
    @Min(value = 2000000, message = "Minimum wage should be more than 20 lac")
    public Long salary;

}

