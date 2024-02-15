package in.codingstreams.etbffservice.controller.mapper;


import in.codingstreams.etbffservice.controller.model.UserInfoDto;
import in.codingstreams.etbffservice.controller.model.VerifyTokenResponseDto;
import in.codingstreams.etbffservice.service.auth.VerifyTokenResponse;
import in.codingstreams.etbffservice.service.model.UserInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Mapper
public interface UserInfoMapper {
  UserInfoMapper INSTANCE = Mappers.getMapper(UserInfoMapper.class);

  @Mapping(target = "createdAt", source = "createdAt", qualifiedByName = "dateConversion")
  UserInfoDto toUserInfoDto(UserInfo userInfo);

  @Named("dateConversion")
  static String dateConversion(LocalDateTime createdAt){
    return createdAt.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
  }
}
