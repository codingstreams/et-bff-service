package in.codingstreams.etbffservice.controller.mapper;


import in.codingstreams.etbffservice.controller.model.VerifyTokenRequestDto;
import in.codingstreams.etbffservice.service.auth.VerifyTokenRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VerifyTokenRequestMapper {
  VerifyTokenRequestMapper INSTANCE = Mappers.getMapper(VerifyTokenRequestMapper.class);

  VerifyTokenRequest toVerifyTokenRequest(VerifyTokenRequestDto dto);
}
