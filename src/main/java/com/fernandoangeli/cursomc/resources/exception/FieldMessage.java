package com.fernandoangeli.cursomc.resources.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FieldMessage {

    private String fieldName;
    private String message;

    public FieldMessage(){
    }

    public FieldMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }
}
