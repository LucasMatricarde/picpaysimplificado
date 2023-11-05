package desafiopicpay.com.br.picpaysimplificado.Dtos;

import java.math.BigDecimal;

import desafiopicpay.com.br.picpaysimplificado.user.UserType;

public record UserDTO(String firstName, String lastName, String Document, BigDecimal balance, String email, String password, UserType userType, String document) {

}
