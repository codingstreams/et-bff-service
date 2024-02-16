package in.codingstreams.etbffservice.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseRequest {
  private String userId;
  private String expenseId;
  private String title;
  private String amount;
  private String expenseCategoryId;
}
