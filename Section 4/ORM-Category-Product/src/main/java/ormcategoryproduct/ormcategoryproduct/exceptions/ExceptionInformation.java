package ormcategoryproduct.ormcategoryproduct.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionInformation {
    private String exception_message;
    private String exception_code;
}
