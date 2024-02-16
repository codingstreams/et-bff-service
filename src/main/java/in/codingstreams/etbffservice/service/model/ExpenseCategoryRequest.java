package in.codingstreams.etbffservice.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseCategoryRequest {
  private String userId;
  private String expenseCategoryId;
  private String name;
}
