package com.api.crudbase.shared.enumerations;

import java.util.Arrays;

public enum SituationResponseAPI {
    ERROR(0, "Erro"),
    SUCCESS(1, "Sucesso");

    private int id;
    private String description;

    SituationResponseAPI(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public static SituationResponseAPI getSituationResponseAPI(int id) {
        SituationResponseAPI[] situationResponseAPIS = values();
        return Arrays.stream(situationResponseAPIS)
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
