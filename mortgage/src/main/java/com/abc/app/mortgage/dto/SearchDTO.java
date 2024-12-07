package com.abc.app.mortgage.dto;

import com.abc.app.mortgage.util.FilterOperatorEnum;
import com.abc.app.mortgage.validation.ValueOfEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter since lombok Getter and setter not getting enabled in Intellij after added plugin also, temporarily commenting
public class SearchDTO {
    private String columnName;
    private String columnValue;
    private String entityName;
    @ValueOfEnum(enumClass = FilterOperatorEnum.class)
    private String filterOperator;

    public SearchDTO() {
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnValue() {
        return columnValue;
    }

    public void setColumnValue(String columnValue) {
        this.columnValue = columnValue;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getFilterOperator() {
        return filterOperator;
    }

    public void setFilterOperator(String filterOperator) {
        this.filterOperator = filterOperator;
    }
}
