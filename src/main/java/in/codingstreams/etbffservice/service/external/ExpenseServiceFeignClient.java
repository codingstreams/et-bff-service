package in.codingstreams.etbffservice.service.external;

import in.codingstreams.etbffservice.controller.model.ExpenseCategoryDto;
import in.codingstreams.etbffservice.service.model.Expense;
import in.codingstreams.etbffservice.service.model.ExpenseCategoryRequest;
import in.codingstreams.etbffservice.service.model.ExpenseRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "et-expense-service", url = "http://localhost:8082/api")
public interface ExpenseServiceFeignClient {
  @PostMapping("/expenses/")
  public ResponseEntity<Expense> addExpense(
      @RequestBody ExpenseRequest expenseRequest
  );

  @DeleteMapping("/expenses/{id}")
  public ResponseEntity<Expense> deleteExpense(
      @PathVariable String id,
      @RequestBody ExpenseRequest expenseRequest
  );

  @PostMapping("/categories/")
  public ResponseEntity<ExpenseCategoryDto> addExpenseCategory(
      @RequestBody ExpenseCategoryRequest expenseCategoryRequest
  );

  @DeleteMapping("/categories/{id}")
  public ResponseEntity<ExpenseCategoryDto> deleteExpenseCategory(
      @PathVariable String id,
      @RequestBody ExpenseCategoryRequest expenseCategoryRequest
  );
}
