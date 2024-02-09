package in.codingstreams.etbffservice.service.auth;

import in.codingstreams.etbffservice.service.external.UserAuthService;
import in.codingstreams.etbffservice.service.model.AuthRequest;
import in.codingstreams.etbffservice.service.model.AuthResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static in.codingstreams.etbffservice.constant.LoggingConstant.METHOD_LOG_END;
import static in.codingstreams.etbffservice.constant.LoggingConstant.METHOD_LOG_START;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService{
  private final UserAuthService userAuthService;
  @Override
  public AuthResponse signUp(AuthRequest authRequest) {
    log.info(METHOD_LOG_START, "signUp");
    var responseEntity = userAuthService.signUp(authRequest);
    log.info(METHOD_LOG_END, "signUp");
    return responseEntity.getBody();
  }

  @Override
  public AuthResponse login(AuthRequest authRequest) {
    log.info(METHOD_LOG_START, "login");
    var responseEntity = userAuthService.login(authRequest);
    log.info(METHOD_LOG_END, "login");
    return responseEntity.getBody();
  }
}
