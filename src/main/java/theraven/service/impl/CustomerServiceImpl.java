package theraven.service.impl;

import java.util.List;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import theraven.dto.request.CustomerRequestDto;
import theraven.dto.response.CustomerResponseDto;
import theraven.entity.Customer;
import theraven.mapper.CustomerMapper;
import theraven.repository.CustomerRepository;
import theraven.service.CustomerService;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerResponseDto createCustomer(CustomerRequestDto requestDto) {
        Customer customer = customerMapper.toEntity(requestDto);
        customer.setCreated(System.currentTimeMillis());
        return customerMapper.toDto(customerRepository.save(customer));
    }

    @Override
    public List<CustomerResponseDto> getAllCustomer() {
        return customerRepository.findAll().stream()
                .map(customerMapper::toDto)
                .toList();
    }

    @Override
    public CustomerResponseDto getCustomerById(Long id) {
        return customerRepository.findById(id)
                .map(customerMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Can't find customer by id: " + id));
    }

    @Override
    public CustomerResponseDto updateCustomer(CustomerRequestDto updateDto, Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find customer by id: " + id));
        customer.setFullName(updateDto.getFullName());
        customer.setPhone(updateDto.getPhone());
        customer.setEmail(updateDto.getEmail());
        customer.setUpdated(System.currentTimeMillis());
        return customerMapper.toDto(customerRepository.save(customer));
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }
}
