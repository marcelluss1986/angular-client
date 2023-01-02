package com.mdss.client.controllers;

import com.mdss.client.model.Client;
import com.mdss.client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManagerFactory;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/clients")
public class ClientController {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client saveClient(@RequestBody @Valid Client client) {
        return repository.save(client);
    }

    @GetMapping
    public List<Client> getAll(){
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Client findClientById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found!!"));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable Long id) {
        repository.findById(id)
                .map(client -> {
                    repository.delete(client);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found!"));
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)

    public void updateClientData(@Valid @PathVariable Long id, @RequestBody Client entity) {
        repository.findById(id).map(client -> {
                    client.setName(entity.getName());
                    client.setCpf(entity.getCpf());
                    return repository.save(entity);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found!"));

    }
}
