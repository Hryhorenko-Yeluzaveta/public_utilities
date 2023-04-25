package ua.com.public_utilities.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.public_utilities.entity.Client;
import ua.com.public_utilities.entity.User;
import ua.com.public_utilities.repository.ClientRepository;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client getClientByUser(User user) {
        return clientRepository.findByUser(user);
    }
}
