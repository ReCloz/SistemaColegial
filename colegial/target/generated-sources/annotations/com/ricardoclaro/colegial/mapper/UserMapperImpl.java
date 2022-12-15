package com.ricardoclaro.colegial.mapper;

import com.ricardoclaro.colegial.dto.UserDto;
import com.ricardoclaro.colegial.entity.UserModel;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-11T02:46:03-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserModel toModel(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setUsername( dto.getUsername() );
        userModel.setPassword( dto.getPassword() );

        return userModel;
    }

    @Override
    public UserDto toDto(UserModel model) {
        if ( model == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setUsername( model.getUsername() );
        userDto.setPassword( model.getPassword() );

        return userDto;
    }
}
