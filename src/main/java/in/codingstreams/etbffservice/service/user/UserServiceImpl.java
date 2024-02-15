package in.codingstreams.etbffservice.service.user;

import in.codingstreams.etbffservice.service.external.UserAuthService;
import in.codingstreams.etbffservice.service.model.UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{
  private final UserAuthService userAuthService;
  @Override
  public UserInfo getUserInfo(String userId) {
    var responseEntity = userAuthService.getUserInfo(userId);
    return responseEntity.getBody();
  }
}
