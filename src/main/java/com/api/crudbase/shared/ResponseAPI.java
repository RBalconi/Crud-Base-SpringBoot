package com.api.crudbase.shared;

import com.api.crudbase.shared.enumerations.SituationResponseAPI;
import lombok.Data;

import java.util.List;

@Data
public class ResponseAPI {

    private Object object;
    private List<Object> listObject;
    private SituationResponseAPI situation;
    private String message;

    public ResponseAPI(Object object, List<Object> listObject, SituationResponseAPI situation, String message) {
        this.object = object;
        this.listObject = listObject;
        this.situation = situation;
        this.message = message;
    }

    public ResponseAPI(Object object, SituationResponseAPI situation, String message) {
        this.object = object;
        this.situation = situation;
        this.message = message;
    }

    public ResponseAPI(List<Object> listObject, SituationResponseAPI situation, String message) {
        this.listObject = listObject;
        this.situation = situation;
        this.message = message;
    }

    public ResponseAPI(SituationResponseAPI situation, String message) {
        this.situation = situation;
        this.message = message;
    }

    public ResponseAPI() {
    }

    @Override
    public String toString() {
        return  "Object: " + object +
                "| situation: '" + situation.name() + '\'' +
                "| message: '" + message;
    }
}
