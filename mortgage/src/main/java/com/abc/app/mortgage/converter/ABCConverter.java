package com.abc.app.mortgage.converter;

import com.abc.app.mortgage.dto.ABCPagedResponse;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ABCConverter<T, U> {
    private final Function<T, U> fromDto;
    private final Function<U, T> fromEntity;

    public ABCConverter(final Function<T, U> fromDto, final Function<U, T> fromEntity) {
        this.fromDto = fromDto;
        this.fromEntity = fromEntity;
    }

    public final U convertFromDto(final T dto) {
        return fromDto.apply(dto);
    }

    public final T convertFromEntity(final U entity) {
        return fromEntity.apply(entity);
    }

    public final List<U> createFromDtos(final Collection<T> dtos) {
        return dtos.stream().map(this::convertFromDto).collect(Collectors.toList());
    }

    public final List<T> createFromEntities(final Collection<U> entities) {
        return entities.stream().map(this::convertFromEntity).collect(Collectors.toList());
    }

    public final ABCPagedResponse<T> createFromEntities(final ABCPagedResponse<U> entities) {
        return ABCPagedResponse.<T>builder().data(createFromEntities(entities.getData())).totalItems(entities.getTotalItems()).totalPages(entities.getTotalPages()).build();
    }
}
