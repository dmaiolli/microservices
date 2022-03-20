package br.com.denys.customer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {

    private Long id;
    private String firstName;
    private String lastname;
    private String email;

}
