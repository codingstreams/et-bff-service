package in.codingstreams.etbffservice.exception;

public class ApiException extends RuntimeException{
  private String errorStatusCode;

  public ApiException(String message, String errorStatusCode) {
    super(message);
    this.errorStatusCode = errorStatusCode;
  }

  public String getErrorStatusCode() {
    return errorStatusCode;
  }
}
