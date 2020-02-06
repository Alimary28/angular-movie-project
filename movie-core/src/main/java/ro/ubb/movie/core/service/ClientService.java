package ro.ubb.movie.core.service;

import ro.ubb.movie.core.model.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients();

    Client updateClient(Long id, String cnp, String firstName, String lastName, Integer age);

    Client addClient(String cnp, String firstName, String lastName, Integer age);

    void delete(Long id);
}
