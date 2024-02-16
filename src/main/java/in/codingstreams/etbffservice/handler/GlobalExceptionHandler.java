package in.codingstreams.etbffservice.handler;

import in.codingstreams.etbffservice.controller.model.ErrorResponseDto;
import in.codingstreams.etbffservice.exception.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(ApiException.class)
  public ResponseEntity<ErrorResponseDto> handleApiException(ApiException e) {
    return ResponseEntity
        .status(
            HttpStatus.valueOf(Integer.parseInt(e.getErrorStatusCode()))
        )
        .body(
            ErrorResponseDto.builder()
                .errorStatusCode(e.getErrorStatusCode())
                .errorMessage(e.getMessage())
                .build()
        );
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponseDto> handleException(Exception e) {
    var httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    return ResponseEntity
        .status(
            httpStatus
        )
        .body(
            ErrorResponseDto.builder()
                .errorStatusCode(String.valueOf(httpStatus.value()))
                .errorMessage("Something went wrong!")
                .build()
        );
  }
}
