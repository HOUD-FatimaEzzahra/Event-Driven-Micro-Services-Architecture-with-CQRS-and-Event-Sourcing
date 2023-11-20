package com.houd.comptecqrs.commands.controllers;

import com.houd.comptecqrs.common_api.api_commands.CreateAccountCommand;
import com.houd.comptecqrs.common_api.dtos.CreateAccountRequestDTO;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(path = "/commands/account")
@AllArgsConstructor
public class AccountCommandController {
    private CommandGateway commandGateway;
    @PostMapping(path = "/create")
    public String createAccount(@RequestBody CreateAccountRequestDTO request){
        commandGateway.send(new CreateAccountCommand(
                UUID.randomUUID().toString(),
               
        ))
    }
}
