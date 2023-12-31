package desafiopicpay.com.br.picpaysimplificado.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desafiopicpay.com.br.picpaysimplificado.Dtos.UserDTO;
import desafiopicpay.com.br.picpaysimplificado.repositories.UserRepository;
import desafiopicpay.com.br.picpaysimplificado.user.User;
import desafiopicpay.com.br.picpaysimplificado.user.UserType;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception{
        if(sender.getUserType() == UserType.MERCHANT){
            throw new Exception("Usuario do tipo Lojista não esta autorizado a realizar transação");
        }

        if(sender.getBalance().compareTo(amount) < 0){
            throw new Exception("Saldo insuficiente");
        }
    }

    public User findUserById(Long id) throws Exception{
       return this.repository.findUserById(id).orElseThrow(() -> new Exception("Usuario não encontrado"));
    }

    public void saveUser (User user){
        this.repository.save(user);
    }

    public User createUser(UserDTO data) {
        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;
    }

    public List<User> getAllUsers(){
       return this.repository.findAll();
    }
}
