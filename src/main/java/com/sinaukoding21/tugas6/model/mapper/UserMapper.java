package com.sinaukoding21.tugas6.model.mapper;

import com.sinaukoding21.tugas6.model.dto.RegistrationDTO;
import com.sinaukoding21.tugas6.model.dto.UserDTO;
import com.sinaukoding21.tugas6.model.user;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "name", target = "profileName")
    user toEntity(UserDTO dto);

    @Mapping(source = "profileName", target = "name")
    UserDTO toDto(user data);

    List<UserDTO> toListDTO(List<user> list);

    List<user> toListEntity(List<UserDTO> data);

    RegistrationDTO toRegistrationDto(user data);

    user toUserFromRegistationDTO(RegistrationDTO dto);
}
