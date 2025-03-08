package com.tcaputi.back.caccorporationserver.service;

import com.tcaputi.back.caccorporationserver.dto.ClientDTO;
import com.tcaputi.back.caccorporationserver.entity.Client;
import com.tcaputi.back.caccorporationserver.repository.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientDTO create(ClientDTO clientDTO) {
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
