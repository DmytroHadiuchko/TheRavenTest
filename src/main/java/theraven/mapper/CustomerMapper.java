package theraven.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import theraven.dto.request.CustomerRequestDto;
import theraven.dto.response.CustomerResponseDto;
import theraven.entity.Customer;

@Mapper(config = MapperConfig.class)
public interface CustomerMapper {
    CustomerResponseDto toDto(Customer customer);

    Customer toEntity(CustomerRequestDto requestDto);
}
