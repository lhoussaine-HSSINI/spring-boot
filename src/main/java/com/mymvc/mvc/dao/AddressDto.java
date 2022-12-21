package com.mymvc.mvc.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class AddressDto {
    private String country;
    private String city;
    private String street;

}
