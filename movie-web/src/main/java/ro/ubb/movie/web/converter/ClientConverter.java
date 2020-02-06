package ro.ubb.movie.web.converter;

import org.springframework.stereotype.Component;
import ro.ubb.movie.core.model.Client;
import ro.ubb.movie.web.dto.ClientDto;

@Component
public class ClientConverter extends BaseConverter<Client, ClientDto> {
    @Override
    public Client convertDtoToModel(ClientDto clientDto){
        Client client = new Client(clientDto.getCnp(), clientDto.getFirstName(), clientDto.getLastName(), clientDto.getAge());
        client.setId(clientDto.getId());
        return client;
    }
    @Override
    public ClientDto convertModelToDto(Client client){
        ClientDto dto = new ClientDto(client.getCnp(), client.getFirstName(), client.getLastName(), client.getAge());
        dto.setId(client.getId());
        return dto;
    }
}
