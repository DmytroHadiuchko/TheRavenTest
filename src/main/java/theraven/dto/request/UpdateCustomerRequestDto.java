package theraven.dto.request;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateCustomerRequestDto {
    private Long id;
    @Size(min = 2, max = 50, message = "Full name must be between 2 and 50 characters")
    private String fullName;
    @Pattern(regexp = "^\\+\\d{6,14}$", message = "Phone number must start with '+' and contain 6 to 14 digits")
    private String phone;
    private String email;
}
