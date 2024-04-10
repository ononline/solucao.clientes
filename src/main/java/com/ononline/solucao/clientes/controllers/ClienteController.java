package com.ononline.solucao.clientes.controllers;

import com.ononline.solucao.clientes.data.Cliente;
import com.ononline.solucao.clientes.repositories.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ClienteController {
    
    private final ClienteRepository clienteRepository;
    
    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    
    @PostMapping("/cliente")
    public ResponseEntity<Cliente> postCliente(@RequestBody Cliente newCliente){
        List<Cliente> findCliente = clienteRepository.findByCpfCnpj(newCliente.getCpfCnpj());
        if (!findCliente.isEmpty())
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        Cliente savedCliente = clienteRepository.save(newCliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCliente);
    }
    
    @GetMapping("/cliente/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable("id") Long id){
        try {
            Cliente cliente = clienteRepository.findById(id).orElseThrow(NullPointerException::new);
            return ResponseEntity.status(HttpStatus.OK).body(cliente);
        }
        catch (NullPointerException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
    @GetMapping("/cliente")
    public ResponseEntity<ArrayList<Cliente>> getAllClientes(){
        ArrayList<Cliente> listClientes = (ArrayList<Cliente>) clienteRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listClientes);
    }
}
