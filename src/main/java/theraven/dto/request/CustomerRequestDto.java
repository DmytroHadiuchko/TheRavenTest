package theraven.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class CustomerRequestDto {
    @Length(min = 2, max = 50, message = "Full name must be between 2 and 50 characters")
    private String fullName;
    @Email(message = "Email should be valid and correctly formatted")
    @Length(min = 2, max = 100, message = "Email must be between 2 and 100 characters")
    private String email;
    @Pattern(regexp = "^\\+\\d{6,14}$", message = "Phone number must start with '+' and contain 6 to 14 digits")
    private String phone;
}
