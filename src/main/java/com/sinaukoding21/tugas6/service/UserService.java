package com.sinaukoding21.tugas6.service;

import com.sinaukoding21.tugas6.config.JwtTokenUtil;
import com.sinaukoding21.tugas6.model.dto.AuthRequestDTO;
import com.sinaukoding21.tugas6.model.dto.RegistrationDTO;
import com.sinaukoding21.tugas6.model.dto.UserDTO;
import com.sinaukoding21.tugas6.model.mapper.UserMapper;
import com.sinaukoding21.tugas6.model.user;
import com.sinaukoding21.tugas6.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public List<UserDTO> findAlluser() {
        return UserMapper.INSTANCE.toListDTO(repository.findAll());
    }

    @Transactional
    public UserDTO createuser(UserDTO param) {
        user user = UserMapper.INSTANCE.toEntity(param);
        user = repository.save(user);

        return UserMapper.INSTANCE.toDto(user);
    }

    public boolean deleteuser(int id) {
        user data = repository.findById(id).orElseThrow(null);

        try {
            repository.delete(data);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public user updateuser(int id, user user) {
        user data = repository.findById(id).orElseThrow(null);
        data.setUsername(user.getUsername() != null ? user.getUsername() : data.getUsername());
        data.setAddress(user.getAddress() != null ? user.getAddress() : data.getAddress());
        data.setProfileName(user.getProfileName() != null ? user.getProfileName() : data.getProfileName());
        data.setPhone(user.getPhone() != null ? user.getPhone() : data.getPhone());

        return repository.save(data);
    }

    public UserDTO findById(Integer id){
        return UserMapper.INSTANCE.toDto(repository.findById(id).orElseThrow(null));
    }

    public UserDTO doLogin(AuthRequestDTO user){
        user currentUser = repository.findByUsername(user.getUsername());

        //mengecek apakan user kosong, jika kosong maka akan mengembalikan data null
        if (currentUser == null){
            return UserMapper.INSTANCE.toDto(currentUser);
        }else if (currentUser.getPassword() != null && BCrypt.checkpw(user.getPassword(), currentUser.getPassword())){ //mengecek value password dari currentUser apakah tidak sama dengan null, dan membandingkan passwod dari param dan current user menggunakan BCrypt
            UserDetails userDetails = new org.springframework.security.core.userdetails.User(currentUser.getUsername(), currentUser.getPassword(), new ArrayList<>());

            currentUser.setToken(jwtTokenUtil.doGenerateToken(userDetails));

            return UserMapper.INSTANCE.toDto(currentUser);
        }

        return null;
    }

    public RegistrationDTO doRegister(RegistrationDTO param){
        user user = repository.findByUsername(param.getUsername());

        if (user != null){
            return null;
        }

        //menyimpan value dari encripsi password dari parameter menggunakan BCrypt
        param.setPassword(BCrypt.hashpw(param.getPassword(), BCrypt.gensalt()));

        user = repository.save(UserMapper.INSTANCE.toUserFromRegistationDTO(param));

        return UserMapper.INSTANCE.toRegistrationDto(user);
    }
}
