package in.codingstreams.etbffservice.controller.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ExpenseDto {
  private String expenseId;
  private String title;
  private String amount;
  private String expenseCategoryId;
  private String date;
  private String errorMessage;
}
