package com.sinaukoding21.tugas6.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthRequestDTO {
    private String username;
    private String password;
}