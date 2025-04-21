package com.demo.reservationapp.mapper;

import com.demo.reservationapp.dtos.request.CategoryAdminRequest;
import com.demo.reservationapp.dtos.response.CategoryAdminResponse;
import com.demo.reservationapp.entity.CategoryAdmin;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public abstract class CategoryAdminMapper {
    public static final CategoryAdminMapper INSTANCE = Mappers.getMapper(CategoryAdminMapper.class);

    public abstract CategoryAdmin requestToEntity(CategoryAdminRequest categoryAdminRequest);

    public abstract CategoryAdminResponse entityToResponse(CategoryAdmin categoryAdmin);
}
