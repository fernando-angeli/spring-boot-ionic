package com.fernandoangeli.cursomc.resources.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FildMessage {

    private String fildName;
    private String message;

    public FildMessage(){
    }

    public FildMessage(String fildName, String message) {
        this.fildName = fildName;
        this.message = message;
    }
}
