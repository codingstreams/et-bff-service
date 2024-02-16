package in.codingstreams.etbffservice.controller.mapper;


import in.codingstreams.etbffservice.controller.model.ExpenseCategoryDto;
import in.codingstreams.etbffservice.controller.model.ExpenseCategoryRequestDto;
import in.codingstreams.etbffservice.service.model.ExpenseCategory;
import in.codingstreams.etbffservice.service.model.ExpenseCategoryRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExpenseCategoryMapper {
  ExpenseCategoryMapper INSTANCE = Mappers.getMapper(ExpenseCategoryMapper.class);

  ExpenseCategoryRequest toExpenseCategoryRequest(ExpenseCategoryRequestDto expenseCategoryRequestDto);
  ExpenseCategoryDto toExpenseCategoryDto(ExpenseCategory expenseCategory);
}
