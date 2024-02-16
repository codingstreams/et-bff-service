package in.codingstreams.etbffservice.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseCategoryDto {
  private String expenseCategoryId;
  private String name;
  private String date;
  private String errorMessage;
}
