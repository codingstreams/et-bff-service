package in.codingstreams.etbffservice.controller;

import in.codingstreams.etbffservice.controller.mapper.*;
import in.codingstreams.etbffservice.controller.model.*;
import in.codingstreams.etbffservice.service.auth.AuthService;
import in.codingstreams.etbffservice.service.auth.VerifyTokenRequest;
import in.codingstreams.etbffservice.service.expense.ExpenseService;
import in.codingstreams.etbffservice.service.expensecategory.ExpenseCategoryService;
import in.codingstreams.etbffservice.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static in.codingstreams.etbffservice.constant.LoggingConstant.METHOD_LOG_END;
import static in.codingstreams.etbffservice.constant.LoggingConstant.METHOD_LOG_START;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class V1ApiController {
  private final AuthService authService;
  private final UserService userService;
  private final ExpenseService expenseService;
  private final ExpenseCategoryService expenseCategoryService;

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

  @PostMapping("/verify-token")
  public ResponseEntity<VerifyTokenResponseDto> verifyToken(@RequestBody VerifyTokenRequestDto verifyTokenRequestDto){
    log.info(METHOD_LOG_START, "verifyToken");
    var verifyTokenResponse = authService.verifyToken(VerifyTokenRequestMapper.INSTANCE.toVerifyTokenRequest(verifyTokenRequestDto));

    log.info(METHOD_LOG_END, "verifyToken");

    return ResponseEntity
        .status(HttpStatus.OK)
        .body(VerifyTokenResponseMapper.INSTANCE.toVerifyTokenResponseDto(verifyTokenResponse));
  }

  @GetMapping("/users/info")
  public ResponseEntity<UserInfoDto> getUserInfo(@RequestHeader("Authorization") String token){
    // token => Bearer <token>
    log.info(METHOD_LOG_START, "getUserInfo");
    var verifyTokenResponse = authService.verifyToken(
        VerifyTokenRequest.builder()
            .accessToken(token.substring(7))
            .build()
    );

    var userInfo = userService
        .getUserInfo(verifyTokenResponse.getUserId());

    log.info(METHOD_LOG_END, "getUserInfo");

    return ResponseEntity
        .status(HttpStatus.OK)
        .body(UserInfoMapper.INSTANCE.toUserInfoDto(userInfo));
  }

  @PostMapping("/expenses/")
  public ResponseEntity<ExpenseDto> addExpense(
      @RequestBody ExpenseRequestDto expenseRequestDto
  ) {

    var expense = expenseService.addExpense(
        ExpenseMapper.INSTANCE.toExpenseRequest(expenseRequestDto)
    );

    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(
            ExpenseMapper.INSTANCE.toExpenseDto(expense)
        );
  }

  @DeleteMapping("/expenses/{id}")
  public ResponseEntity<ExpenseDto> deleteExpense(
      @PathVariable String id,
      @RequestBody ExpenseRequestDto expenseRequestDto
  ) {
    var expense = expenseService.deleteExpense(
        ExpenseMapper.INSTANCE.toExpenseRequest(expenseRequestDto)
    );

    return ResponseEntity
        .status(HttpStatus.OK)
        .body(
            ExpenseMapper.INSTANCE.toExpenseDto(expense)
        );
  }

  @PostMapping("/categories/")
  public ResponseEntity<ExpenseCategoryDto> addExpenseCategory(
      @RequestBody ExpenseCategoryRequestDto expenseCategoryRequestDto
  ) {
    var expenseCategory = expenseCategoryService.addExpenseCategory(
        ExpenseCategoryMapper.INSTANCE.toExpenseCategoryRequest(expenseCategoryRequestDto)
    );

    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(
            ExpenseCategoryMapper.INSTANCE.toExpenseCategoryDto(expenseCategory)
        );
  }

  @DeleteMapping("/categories/{id}")
  public ResponseEntity<ExpenseCategoryDto> deleteExpenseCategory(
      @PathVariable String id,
      @RequestBody ExpenseCategoryRequestDto expenseCategoryRequestDto
  ) {
    var expenseCategory = expenseCategoryService.deleteExpenseCategory(
        ExpenseCategoryMapper.INSTANCE.toExpenseCategoryRequest(expenseCategoryRequestDto)
    );

    return ResponseEntity
        .status(HttpStatus.OK)
        .body(
            ExpenseCategoryMapper.INSTANCE.toExpenseCategoryDto(expenseCategory)
        );
  }
}
