package in.codingstreams.etbffservice.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseCategoryRequestDto {
  private String userId;
  private String expenseCategoryId;
  private String name;
}
