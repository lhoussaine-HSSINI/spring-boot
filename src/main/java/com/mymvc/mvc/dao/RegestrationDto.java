package com.mymvc.mvc.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class RegestrationDto {
    private String username;
    private String password;
    private String email;
}
