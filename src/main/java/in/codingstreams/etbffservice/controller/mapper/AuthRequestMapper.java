package in.codingstreams.etbffservice.controller.mapper;


import in.codingstreams.etbffservice.controller.model.AuthRequestDto;
import in.codingstreams.etbffservice.service.model.AuthRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthRequestMapper {
  AuthRequestMapper INSTANCE = Mappers.getMapper(AuthRequestMapper.class);

  // Return type -> Target
  // Parameter -> Source
  AuthRequest toAuthRequest(AuthRequestDto authRequestDto);
}
