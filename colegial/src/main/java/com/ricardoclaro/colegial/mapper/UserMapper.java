package com.ricardoclaro.colegial.mapper;

import com.ricardoclaro.colegial.dto.UserDto;
import com.ricardoclaro.colegial.entity.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserModel toModel(UserDto dto);

    UserDto toDto(UserModel model);
}
