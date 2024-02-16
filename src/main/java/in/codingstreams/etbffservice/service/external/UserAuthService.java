package in.codingstreams.etbffservice.service.external;

import in.codingstreams.etbffservice.service.auth.VerifyTokenRequest;
import in.codingstreams.etbffservice.service.auth.VerifyTokenResponse;
import in.codingstreams.etbffservice.service.model.AuthRequest;
import in.codingstreams.etbffservice.service.model.AuthResponse;
import in.codingstreams.etbffservice.service.model.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "et-use-auth-service", url = "http://localhost:8081/api")
public interface UserAuthService {
  @PostMapping("/auth/sign-up")
  ResponseEntity<AuthResponse> signUp(AuthRequest authRequest);

  @PostMapping("/auth/login")
  ResponseEntity<AuthResponse> login(AuthRequest authRequest);

  @PostMapping("/auth/verify-token")
  ResponseEntity<VerifyTokenResponse> verifyToken(VerifyTokenRequest verifyTokenRequest);

  @GetMapping("/users/{userId}")
  ResponseEntity<UserInfo> getUserInfo(@PathVariable String userId);
}
