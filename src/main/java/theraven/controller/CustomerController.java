package theraven.controller;

import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import theraven.dto.request.CreateCustomerRequestDto;
import theraven.dto.request.UpdateCustomerRequestDto;
import theraven.dto.response.CustomerResponseDto;
import theraven.service.CustomerService;

@RestController
@RequestMapping(value = "/api/customers")
@RequiredArgsConstructor
@Tag(name = "Customer management",  description = "Endpoints for managing customers")
public class CustomerController {
    private final CustomerService customerService;

    @Operation(summary = "Create new customer", description = "Add new customer to DB")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponseDto createCustomer(@Valid @RequestBody
                                                  CreateCustomerRequestDto customerRequestDto) {
        return customerService.createCustomer(customerRequestDto);
    }

    @Operation(summary = "Return list of customers",
            description = "Retrieve a list of all customers")
    @GetMapping
    public List<CustomerResponseDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @Operation(summary = "Get customer by ID",
            description = "Retrieve a customer's details by their ID")
    @GetMapping("/{id}")
    public CustomerResponseDto getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @Operation(summary = "Update customer by ID",
            description = "Update the details of an existing customer by their ID")
    @PutMapping("/{id}")
    public CustomerResponseDto updateCustomerById(@Valid @RequestBody
                                                      UpdateCustomerRequestDto updateDto,
                                                  @PathVariable Long id) {
        return customerService.updateCustomer(updateDto, id);
    }

    @Operation(summary = "Delete customer by ID",
            description = "Mark a customer as deleted by their ID, "
                    + "but keep their data in the database")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomerById(id);
    }
}
