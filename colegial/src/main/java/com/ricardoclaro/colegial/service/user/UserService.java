package com.ricardoclaro.colegial.service.user;

import com.ricardoclaro.colegial.dto.MessageResponseDto;
import com.ricardoclaro.colegial.dto.UserDto;

public interface UserService {

    MessageResponseDto create(UserDto dto);
}