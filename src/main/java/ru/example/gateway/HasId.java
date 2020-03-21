package ru.example.gateway;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public interface HasId {
    Long getId();

    void setId(Long id);

    default boolean isNew() {
        return (getId() == null);
    }
}
