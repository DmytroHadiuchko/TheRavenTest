package theraven.service.impl;

import java.util.List;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import theraven.dto.request.CreateCustomerRequestDto;
import theraven.dto.request.UpdateCustomerRequestDto;
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
    public CustomerResponseDto createCustomer(CreateCustomerRequestDto requestDto) {
        Customer customer = customerMapper.toEntity(requestDto);
        customer.setCreated(System.currentTimeMillis());
        return customerMapper.toDto(customerRepository.save(customer));
    }

    @Override
    public List<CustomerResponseDto> getAllCustomers() {
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
    public CustomerResponseDto updateCustomer(UpdateCustomerRequestDto updateDto, Long id) {
        Customer customer = findCustomerById(id);
        customer.setFullName(updateDto.getFullName());
        customer.setPhone(updateDto.getPhone());
        customer.setUpdated(System.currentTimeMillis());
        return customerMapper.toDto(customerRepository.save(customer));
    }

    @Override
    public void deleteCustomerById(Long id) {
        findCustomerById(id);
        customerRepository.deleteById(id);
    }

    private Customer findCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Can't find customer by id: " + id));
    }
}
