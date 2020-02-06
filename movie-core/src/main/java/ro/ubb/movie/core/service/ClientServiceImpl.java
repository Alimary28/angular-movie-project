package ro.ubb.movie.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.movie.core.model.Client;
import ro.ubb.movie.core.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    private static final Logger log = LoggerFactory.getLogger(ClientServiceImpl.class);
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients(){
        log.trace("getAllClients---method entered");
        List<Client> clients = clientRepository.findAll();
        log.trace("getAllClients: clients={}", clients);
        return clients;
    }


    @Override
    @Transactional
    public Client updateClient(Long id, String cnp, String firstname, String lastname, Integer age) {
        log.trace("updateClient: cnp={}, firstname={}, lastname={}, age={}", cnp, firstname, lastname, age);

        Optional<Client> client = clientRepository.findById(id);

        client.ifPresent(c->{
            c.setCnp(cnp);
            c.setFirstName(firstname);
            c.setLastName(lastname);
            c.setAge(age);
        });

        log.trace("updateClient: client={}", client.get());

        return client.orElse(null);
    }

    @Override
    public Client addClient(String cnp, String firstname, String lastname, Integer age) {
        log.trace("addClient: cnp={}, firstname={}, lastname={}, age={}", cnp, firstname, lastname, age);

        Client client = clientRepository.save(new Client(cnp, firstname, lastname, age));

        log.trace("addClient: client={}", client);

        return client;
    }

    @Override
    public void delete(Long id) {
        log.trace("deleteClient---method entered");

        clientRepository.deleteById(id);
        log.trace("deleteClient=");
    }
}
