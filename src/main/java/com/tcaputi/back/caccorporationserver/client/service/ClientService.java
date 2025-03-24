package com.tcaputi.back.caccorporationserver.client.service;

import com.tcaputi.back.caccorporationserver.client.dto.ClientDTO;
import com.tcaputi.back.caccorporationserver.client.entity.Client;
import com.tcaputi.back.caccorporationserver.common.exception.ClientNotFoundException;
import com.tcaputi.back.caccorporationserver.client.repository.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Data
@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    private static final String CLIENT_WITH_ID_NOT_FOUND = "Client with id %s not found";

    public ClientDTO getClientById(UUID id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(String.format(CLIENT_WITH_ID_NOT_FOUND, id)));
        return convertToDTO(client);
    }

    public List<ClientDTO> getAllClients(Pageable pageable) {
        Page<Client> clients = clientRepository.findAll(pageable);
        return clients.stream()
                .map(this::convertToDTO)
                .toList();
    }

    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = convertToEntity(clientDTO);
        Client savedClient = clientRepository.save(client);
        return convertToDTO(savedClient);
    }

    public ClientDTO updateClient(UUID id, ClientDTO clientDTO) {
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(String.format(CLIENT_WITH_ID_NOT_FOUND, id)));

        existingClient.setName(clientDTO.name());
        existingClient.setEmail(clientDTO.email());
        existingClient.setPhone(clientDTO.phone());
        existingClient.setAddress(clientDTO.address());
        existingClient.setCity(clientDTO.city());
        existingClient.setState(clientDTO.state());
        existingClient.setZip(clientDTO.zip());

        Client updatedClient = clientRepository.save(existingClient);
        return convertToDTO(updatedClient);
    }

    public List<ClientDTO> searchClientsByName(String name) {
        return clientRepository.findByNameContainingIgnoreCase(name).stream()
                .map(this::convertToDTO)
                .toList();
    }

    public void deleteClient(UUID id) {
        if (!clientRepository.existsById(id)) {
            throw new ClientNotFoundException(String.format(CLIENT_WITH_ID_NOT_FOUND, id));
        }
        clientRepository.deleteById(id);
    }

    private ClientDTO convertToDTO(Client client) {
        return new ClientDTO(client.getId(), client.getName(), client.getEmail(), client.getPhone(),
                client.getAddress(), client.getCity(), client.getState(), client.getZip());
    }

    private Client convertToEntity(ClientDTO clientDTO) {
        return new Client(clientDTO.name(), clientDTO.email(), clientDTO.phone(),
                clientDTO.address(), clientDTO.city(), clientDTO.state(), clientDTO.zip());
    }

}
