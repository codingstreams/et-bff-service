package in.codingstreams.etbffservice.service.expense;

import in.codingstreams.etbffservice.service.model.Expense;
import in.codingstreams.etbffservice.service.model.ExpenseRequest;

public interface ExpenseService {
  Expense addExpense(ExpenseRequest expenseRequest);
  Expense deleteExpense(ExpenseRequest expenseRequest);
}
