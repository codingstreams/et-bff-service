package in.codingstreams.etbffservice.controller.mapper;


import in.codingstreams.etbffservice.controller.model.ExpenseDto;
import in.codingstreams.etbffservice.controller.model.ExpenseRequestDto;
import in.codingstreams.etbffservice.service.model.Expense;
import in.codingstreams.etbffservice.service.model.ExpenseRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExpenseMapper {
  ExpenseMapper INSTANCE = Mappers.getMapper(ExpenseMapper.class);

  ExpenseRequest toExpenseRequest(ExpenseRequestDto expenseRequestDto);
  ExpenseDto toExpenseDto(Expense expense);
}
