package in.codingstreams.etbffservice.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseRequestDto {
  private String userId;
  private String expenseId;
  private String title;
  private String amount;
  private String expenseCategoryId;
  private RequestType requestType;
}
