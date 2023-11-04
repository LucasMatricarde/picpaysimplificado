package desafiopicpay.com.br.picpaysimplificado.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import desafiopicpay.com.br.picpaysimplificado.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
   Optional<User> findUserByDocument(String document);

   Optional<User> findUserById(Long id);
}
