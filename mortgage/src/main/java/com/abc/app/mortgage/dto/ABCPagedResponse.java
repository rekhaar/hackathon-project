package com.abc.app.mortgage.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Collection;

@Data
@Builder
@AllArgsConstructor
public class ABCPagedResponse<T>{
    @JsonProperty("total_items")
    private Long totalItems;
    @JsonProperty("total_pages")
    private Long totalPages;
    @JsonProperty("data")
    private Collection<T> data;
}
