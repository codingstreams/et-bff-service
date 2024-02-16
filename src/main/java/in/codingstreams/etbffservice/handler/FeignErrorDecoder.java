package in.codingstreams.etbffservice.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import in.codingstreams.etbffservice.exception.ApiException;
import in.codingstreams.etbffservice.service.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
@Slf4j
public class FeignErrorDecoder implements ErrorDecoder {
  @Override
  public Exception decode(String methodKey, Response response) {
    // methodKey => <Feign Client Name>:<Method name>

    var errorResponse = Optional.ofNullable(response.body())
        .map(body -> {
          try {
            return new String(body.asInputStream().readAllBytes());
          } catch (IOException e) {
            return null;
          }
        })
        .map(json -> {
          try {
            return new ObjectMapper().readValue(json, ErrorResponse.class);
          } catch (JsonProcessingException e) {
            return null;
          }
        })
        .orElse(
            ErrorResponse.builder()
                .errorStatusCode("500")
                .errorMessage("Something went wrong!")
                .build()
        );

    return new ApiException(errorResponse.getErrorMessage(), errorResponse.getErrorStatusCode());
  }
}
