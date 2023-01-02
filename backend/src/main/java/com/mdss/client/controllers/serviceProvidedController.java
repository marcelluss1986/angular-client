package com.mdss.client.controllers;

import com.mdss.client.dto.*;
import com.mdss.client.model.Client;
import com.mdss.client.model.ServiceProvided;
import com.mdss.client.repositories.ClientRepository;
import com.mdss.client.repositories.ServiceProvidedRepository;
import com.mdss.client.util.BigDecimalConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping(value = "/api/services-provided")
public class serviceProvidedController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ServiceProvidedRepository serviceProvidedRepository;

    @Autowired
    private BigDecimalConverter bigDecimalConverter;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServiceProvided save(@RequestBody @Valid ServiceProvidedDTO dto){
        LocalDate date= LocalDate.parse(dto.getDateServiceProv(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        ServiceProvided serviceProvided= new ServiceProvided();
        Long clientId = dto.getClientId();
        Client client = clientRepository
                .findById(clientId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Non-existent custumer"));
        serviceProvided.setDescription(dto.getDescription());
        serviceProvided.setDateServiceProv(date);
        serviceProvided.setClient(client);
        serviceProvided.setPrice(bigDecimalConverter.converter(dto.getValue()));

        return serviceProvidedRepository.save(serviceProvided);

    }

    @GetMapping
    public List<ServiceProvided> search(
            @RequestParam(value = "name", required = false, defaultValue = "")
            String name,
            @RequestParam(value = "month", required = false) Integer month
    ){
        return serviceProvidedRepository.findByClientNameAndMonth("%" + name + "%", month);
    }
}
