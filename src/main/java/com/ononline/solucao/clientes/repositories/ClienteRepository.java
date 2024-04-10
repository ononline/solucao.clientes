package com.ononline.solucao.clientes.repositories;

import com.ononline.solucao.clientes.data.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByCpfCnpj(String cpfCnpj);
}
