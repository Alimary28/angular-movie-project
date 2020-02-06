package ro.ubb.movie.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.movie.core.model.Client;
import ro.ubb.movie.core.service.ClientService;
import ro.ubb.movie.web.converter.ClientConverter;
import ro.ubb.movie.web.dto.ClientDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class ClientController {
    public static final Logger log = LoggerFactory.getLogger(ClientController.class);
    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientConverter clientConverter;

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public List<ClientDto> getClients() {
        log.trace("getClients --- method entered");

        List<Client> clients = clientService.getAllClients();

        log.trace("getClients={}", clients);

        return new ArrayList<>(clientConverter.convertModelsToDtos(clients));
    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.PUT)
    public ClientDto updateClient(@PathVariable final Long id,
                                @RequestBody final ClientDto clientDto) {
        log.trace("updateClient: id={}, clientDtoMap={}", id, clientDto);
        Client client = clientService.updateClient(id, clientDto.getCnp(),
                clientDto.getFirstName(), clientDto.getLastName(), clientDto.getAge());

        ClientDto result = clientConverter.convertModelToDto(client);
        log.trace("updateClient: result={}", result);
        return result;
    }

    @RequestMapping(value = "/clients", method = RequestMethod.POST)
    public ClientDto addClient(
            @RequestBody final ClientDto clientDto) {
        log.trace("addClient: clientDto={}", clientDto);

        Client client = clientService.addClient(clientDto.getCnp(), clientDto.getFirstName(),
                clientDto.getLastName(), clientDto.getAge());

        ClientDto result = clientConverter.convertModelToDto(client);

        log.trace("addClient: result={}", result);

        return result;
    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteClient(@PathVariable final Long id) {
        log.trace("deleteClient: id={}", id);

        clientService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
