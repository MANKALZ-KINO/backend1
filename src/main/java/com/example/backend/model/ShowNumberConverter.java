package com.example.backend.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ShowNumberConverter implements AttributeConverter<ShowNumber, String> {
    @Override
    public String convertToDatabaseColumn(ShowNumber showNumber) {
        return (showNumber != null) ? showNumber.name() : null;
    }

    @Override
    public ShowNumber convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return null;
        }
        try {
            return ShowNumber.valueOf(dbData);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Unknown show_number value: " + dbData);
        }
    }
}
