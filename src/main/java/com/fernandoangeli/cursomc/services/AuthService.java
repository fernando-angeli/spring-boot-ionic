package com.fernandoangeli.cursomc.services;

import com.fernandoangeli.cursomc.domain.Cliente;
import com.fernandoangeli.cursomc.repository.ClienteRepository;
import com.fernandoangeli.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AuthService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private BCryptPasswordEncoder pe;

    @Autowired
    private EmailService emailService;

    private Random rand = new Random();

    public void sendNewPassword(String email){
        Cliente cliente = clienteRepository.findByEmail(email);
        if(cliente == null){
            throw new ObjectNotFoundException("E-mail não encontrado");
        }
        String newPass = newPassword();
        cliente.setSenha(pe.encode(newPass));
        clienteRepository.save(cliente);
        emailService.sendNewPasswordEmail(cliente, newPass);
    }

    private String newPassword() {
        char[] vet = new char[10];
        for(int i = 0; i < 10; i++){
            vet[i] = randomChar();
        }
        return new String(vet);
    }

    private char randomChar() {
        int opt = rand.nextInt(3);
        if(opt == 0){
            // gera numero
            return (char) (rand.nextInt(10) + 48);
        }
        else if(opt == 1){
            // gera letra minuscula
            return (char) (rand.nextInt(26) + 65);
        }
        else{
            //gera letra maiuscula
            return (char) (rand.nextInt(26) + 97);
        }
    }
}
