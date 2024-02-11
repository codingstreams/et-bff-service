package in.codingstreams.etbffservice.controller.mapper;


import in.codingstreams.etbffservice.controller.model.VerifyTokenResponseDto;
import in.codingstreams.etbffservice.service.auth.VerifyTokenResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VerifyTokenResponseMapper {
  VerifyTokenResponseMapper INSTANCE = Mappers.getMapper(VerifyTokenResponseMapper.class);

  VerifyTokenResponseDto toVerifyTokenResponseDto(VerifyTokenResponse tokenResponse);
}
