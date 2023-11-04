package desafiopicpay.com.br.picpaysimplificado.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import desafiopicpay.com.br.picpaysimplificado.domain.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    
    
}
