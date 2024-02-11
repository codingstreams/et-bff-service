package in.codingstreams.etbffservice.service.external;

import in.codingstreams.etbffservice.service.auth.VerifyTokenRequest;
import in.codingstreams.etbffservice.service.auth.VerifyTokenResponse;
import in.codingstreams.etbffservice.service.model.AuthRequest;
import in.codingstreams.etbffservice.service.model.AuthResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "et-use-auth-service", url = "http://localhost:8081/api/auth")
public interface UserAuthService {
  @PostMapping("/sign-up")
  ResponseEntity<AuthResponse> signUp(AuthRequest authRequest);

  @PostMapping("/login")
  ResponseEntity<AuthResponse> login(AuthRequest authRequest);

  @PostMapping("/verify-token")
  ResponseEntity<VerifyTokenResponse> verifyToken(VerifyTokenRequest verifyTokenRequest);
}
