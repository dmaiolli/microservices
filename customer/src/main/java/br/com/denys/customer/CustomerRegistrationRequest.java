package br.com.denys.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {


}
