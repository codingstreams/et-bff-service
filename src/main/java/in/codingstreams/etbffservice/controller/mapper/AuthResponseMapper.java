package in.codingstreams.etbffservice.controller.mapper;


import in.codingstreams.etbffservice.controller.model.AuthResponseDto;
import in.codingstreams.etbffservice.service.model.AuthResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthResponseMapper {
  AuthResponseMapper INSTANCE = Mappers.getMapper(AuthResponseMapper.class);

  // Return type -> Target
  // Parameter -> Source
  AuthResponseDto toAuthResponseDto(AuthResponse authResponse);
}
