package br.com.marques.payrollapi.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class User {

    private Long id;
    private String name;
    private String email;
    private String password;
    private Double hourlyPrice;
}
