package com.api.innovation.infra.commands.database;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.api.innovation.application.clients.dto.requests.ClientCreateDTO;
import com.api.innovation.application.clients.usecases.CreateClientUseCase;
import com.api.innovation.application.clients.usecases.GetClientByEmailUseCase;
import com.api.innovation.application.users.dto.requests.UserCreateDTO;
import com.api.innovation.application.users.services.GetUserByEmailService;
import com.api.innovation.application.users.usecases.CreateUserUseCase;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private CreateUserUseCase createUserUseCase;
    private CreateClientUseCase createClientUseCase;
    private GetUserByEmailService getUserByEmailUseCase;
    private GetClientByEmailUseCase getClientByEmailUseCase;

    public DatabaseInitializer(
        CreateUserUseCase createUserUseCase,
        CreateClientUseCase createClientUseCase,
        GetUserByEmailService getUserByEmailUseCase,
        GetClientByEmailUseCase getClientByEmailUseCase
    ) {
        this.createUserUseCase = createUserUseCase;
        this.getUserByEmailUseCase = getUserByEmailUseCase;
        this.getClientByEmailUseCase = getClientByEmailUseCase;
        this.createClientUseCase = createClientUseCase;
    }

    @Override
    public void run(String... args) throws Exception {
        this.createUserAdmin();
        this.createExampleClient();
    }

    private void createUserAdmin() {
        String email = "admin@innovation.com.br";

        try {
            getUserByEmailUseCase.execute(email);
            
        } catch (Exception e) {
            UserCreateDTO userCreateDTO = new UserCreateDTO();

            userCreateDTO.setName("Admin");
            userCreateDTO.setLastname("Innovation");
            userCreateDTO.setEmail(email);
            userCreateDTO.setPassword("password");
            
            createUserUseCase.execute(userCreateDTO);
        }
    }

    private void createExampleClient() {
        String email = "cliente-de-teste@innovation.com.br";

        try {
            getClientByEmailUseCase.execute(email);
            
        } catch (Exception e) {
            ClientCreateDTO clientCreateDTO = new ClientCreateDTO();

            clientCreateDTO.setName("Cliente");
            clientCreateDTO.setLastname("Teste");
            clientCreateDTO.setEmail(email);
            clientCreateDTO.setPhone("00-000000000");
            clientCreateDTO.setCpf("00123456789");
            clientCreateDTO.setAddress("Rua de teste n° 123");
            
            createClientUseCase.execute(clientCreateDTO);
        }
    }
}