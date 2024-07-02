package theraven.service;

import java.util.List;
import theraven.dto.request.CreateCustomerRequestDto;
import theraven.dto.request.UpdateCustomerRequestDto;
import theraven.dto.response.CustomerResponseDto;

public interface CustomerService {

    CustomerResponseDto createCustomer(CreateCustomerRequestDto requestDto);

    List<CustomerResponseDto> getAllCustomers();

    CustomerResponseDto getCustomerById(Long id);

    CustomerResponseDto updateCustomer(UpdateCustomerRequestDto updateDto, Long id);

    void deleteCustomerById(Long id);
}
