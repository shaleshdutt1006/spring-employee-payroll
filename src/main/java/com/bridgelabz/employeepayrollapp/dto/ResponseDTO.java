package com.bridgelabz.employeepayrollapp.dto;

import lombok.Data;

//Using @Data is equivalent to using @code @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
//- Generates getters for all fields, a useful toString method, and hashCode and equals
@Data
public class ResponseDTO {
    private String message;
    private Object EmployeePayrollData;

    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.EmployeePayrollData = data;
    }

}
