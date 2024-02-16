package in.codingstreams.etbffservice.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseCategory {
  private String expenseCategoryId;
  private String name;
  private String date;
  private String errorMessage;
}
