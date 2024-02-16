package in.codingstreams.etbffservice.service.expensecategory;


import in.codingstreams.etbffservice.service.model.ExpenseCategory;
import in.codingstreams.etbffservice.service.model.ExpenseCategoryRequest;

public interface ExpenseCategoryService {
  ExpenseCategory addExpenseCategory(ExpenseCategoryRequest expenseCategoryRequest);
  ExpenseCategory deleteExpenseCategory(ExpenseCategoryRequest expenseCategoryRequest);
}
