package in.codingstreams.etbffservice.service.auth;

import in.codingstreams.etbffservice.service.model.AuthRequest;
import in.codingstreams.etbffservice.service.model.AuthResponse;

public interface AuthService {
  AuthResponse signUp(AuthRequest authRequest);

  AuthResponse login(AuthRequest authRequest);
}
