package com.tcaputi.back.caccorporationserver.service;

import com.tcaputi.back.caccorporationserver.dto.ClientDTO;
import com.tcaputi.back.caccorporationserver.entity.Client;
import com.tcaputi.back.caccorporationserver.repository.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Data
@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Optional<ClientDTO> getClientById(UUID id) {
        return clientRepository.findById(id)
                .map(this::getClientDTO);
    }

    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll().stream()
                .map(this::getClientDTO)
                .toList();
    }

    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = new Client(
                clientDTO.name(),
                clientDTO.email(),
                clientDTO.phone(),
                clientDTO.address(),
                clientDTO.city(),
                clientDTO.state(),
                clientDTO.zip()
                );
        clientRepository.save(client);
        return getClientDTO(client);
    }

    public Optional<ClientDTO> updateClient(UUID id, ClientDTO clientDTO) {
        return clientRepository.findById(id).map(client -> {
            client.setName(clientDTO.name());
            client.setEmail(clientDTO.email());
            client.setPhone(clientDTO.phone());
            client.setAddress(clientDTO.address());
            client.setCity(clientDTO.city());
            client.setState(clientDTO.state());
            client.setZip(clientDTO.zip());
            Client updatedClient = clientRepository.save(client);
            return getClientDTO(updatedClient);
        });
    }

    public void deleteClient(UUID id) {
        clientRepository.deleteById(id);
    }

    @NotNull
    private ClientDTO getClientDTO(Client client) {
        return new ClientDTO(client.getId(),
                client.getName(),
                client.getEmail(),
                client.getPhone(),
                client.getAddress(),
                client.getCity(),
                client.getState(),
                client.getZip()
        );
    }

}
