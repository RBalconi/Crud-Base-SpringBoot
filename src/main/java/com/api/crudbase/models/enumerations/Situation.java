package com.api.crudbase.models.enumerations;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Situation {
    ALL(0, "Todos"),
    ACTIVE(1, "Ativo"),
    INACTIVE(2, "Inativo"),
    DELETED(3, "Excluído");

    private int id;
    private String description;

    Situation(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public static Situation getSituation(int id) {
        Situation[] situation = values();
        return Arrays.stream(situation)
                .filter(obj -> obj.getId() == id)
                .toList().get(0);
//        for (Situation situation : values()) {
//            if (situation.getId() == id) {
//                return situation;
//            }
//        }
//        return null;
    }
}
