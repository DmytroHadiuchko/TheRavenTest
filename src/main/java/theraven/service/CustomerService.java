package theraven.service;

import java.util.List;
import theraven.dto.request.CustomerRequestDto;
import theraven.dto.response.CustomerResponseDto;

public interface CustomerService {

    CustomerResponseDto createCustomer(CustomerRequestDto requestDto);

    List<CustomerResponseDto> getAllCustomer();

    CustomerResponseDto getCustomerById(Long id);

    CustomerResponseDto updateCustomer(CustomerRequestDto updateDto, Long id);

    void deleteCustomerById(Long id);
}
