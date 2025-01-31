package theraven.mapper;

import theraven.config.MapperConfig;
import theraven.dto.request.CreateCustomerRequestDto;
import theraven.dto.response.CustomerResponseDto;
import theraven.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface CustomerMapper {
    CustomerResponseDto toDto(Customer customer);

    Customer toEntity(CreateCustomerRequestDto requestDto);
}
