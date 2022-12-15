package com.ricardoclaro.colegial.service.user;

import com.ricardoclaro.colegial.dto.MessageResponseDto;
import com.ricardoclaro.colegial.dto.UserDto;
import com.ricardoclaro.colegial.entity.RoleModel;
import com.ricardoclaro.colegial.enums.RoleName;
import com.ricardoclaro.colegial.mapper.UserMapper;
import com.ricardoclaro.colegial.repository.RoleModelRepository;
import com.ricardoclaro.colegial.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final RoleModelRepository roleModelRepository;
    private final UserMapper userMapper = UserMapper.INSTANCE;
    private final PasswordEncoder passwordEncoder; //Importação do password encoder



    @Override
    public MessageResponseDto create(UserDto dto) { //Método responsável pela criação do nosso usuário no banco
        var isSamePassword = dto.getPassword().equals(dto.getRetypePassword());

        if (!isSamePassword) {
            return MessageResponseDto.builder()
                    .message("Senhas não são iguais.")
                    .build();
        }

        var exists = userRepository.findByUsername(dto.getUsername()).isPresent();
        if (exists) {
            return MessageResponseDto.builder()
                    .message("Usuário já cadastrado.")
                    .build();
        }

        dto.setPassword(passwordEncoder.encode(dto.getPassword())); //Faz a criptografia da senha

        var userToSave = userMapper.toModel(dto);

        var role = new RoleModel();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        boolean logIsAdm = (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN")));

        if(dto.isAdmin()){
            if(logIsAdm){
                role.setRoleName(RoleName.ROLE_ADMIN);
            }else{
                return MessageResponseDto.builder().message("Você não tem permissão para criar um Administrador").build();
            }
        }else{
            role.setRoleName(RoleName.ROLE_USER);
        }

        userRepository.save(userToSave);

        role.setUserModel(userToSave);

        roleModelRepository.save(role);

        return MessageResponseDto.builder().message("Usuário cadastrado com sucesso.").build();
    }


}