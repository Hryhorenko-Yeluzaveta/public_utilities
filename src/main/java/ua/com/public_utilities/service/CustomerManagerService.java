package ua.com.public_utilities.service;
import org.springframework.stereotype.Service;
import ua.com.public_utilities.entity.Client;
import ua.com.public_utilities.repository.ClientRepository;


@Service
public class CustomerManagerService {
    private final ClientRepository clientRepository;

    public CustomerManagerService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void saveCustomerToDB(Client client){
        clientRepository.save(client);
    }

    public Client getClientById (Long id) {
        return clientRepository.getClientById(id);
    }
}
