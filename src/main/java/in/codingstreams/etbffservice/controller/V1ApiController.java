package in.codingstreams.etbffservice.controller;

import in.codingstreams.etbffservice.controller.mapper.AuthRequestMapper;
import in.codingstreams.etbffservice.controller.mapper.AuthResponseMapper;
import in.codingstreams.etbffservice.controller.model.AuthRequestDto;
import in.codingstreams.etbffservice.controller.model.AuthResponseDto;
import in.codingstreams.etbffservice.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static in.codingstreams.etbffservice.constant.LoggingConstant.METHOD_LOG_END;
import static in.codingstreams.etbffservice.constant.LoggingConstant.METHOD_LOG_START;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class V1ApiController {
  private final AuthService authService;

  @PostMapping("/sign-up")
  public ResponseEntity<AuthResponseDto> signUp(@RequestBody AuthRequestDto authRequestDto){
    log.info(METHOD_LOG_START, "signUp");
    var authResponse = authService.signUp(AuthRequestMapper.INSTANCE.toAuthRequest(authRequestDto));

    log.info(METHOD_LOG_END, "signUp");

    return ResponseEntity
        .status(HttpStatus.OK)
        .body(AuthResponseMapper.INSTANCE.toAuthResponseDto(authResponse));
  }

  @PostMapping("/login")
  public ResponseEntity<AuthResponseDto> login(@RequestBody AuthRequestDto authRequestDto){
    log.info(METHOD_LOG_START, "login");
    var authResponse = authService.login(AuthRequestMapper.INSTANCE.toAuthRequest(authRequestDto));

    log.info(METHOD_LOG_END, "login");

    return ResponseEntity
        .status(HttpStatus.OK)
        .body(AuthResponseMapper.INSTANCE.toAuthResponseDto(authResponse));
  }
}
