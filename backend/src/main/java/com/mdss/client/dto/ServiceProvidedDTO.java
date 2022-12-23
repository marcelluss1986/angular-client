package com.mdss.client.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ServiceProvidedDTO implements Serializable {
    private static final long serialVersionUID = 6286160737590563266L;

    @NotBlank(message = "{field.description.required}")
    private String description;

    @NotBlank(message = "{field.price.required}")
    private String value;

    @NotNull(message = "{field.client.required}")
    private Long clientId;

    @NotBlank(message = "{field.description.required}")
    private String dateServiceProv;

    public ServiceProvidedDTO() {
    }

    public ServiceProvidedDTO(String description, String value, Long clientId, String dateServiceProv) {
        this.description = description;
        this.value = value;
        this.clientId = clientId;
        this.dateServiceProv = dateServiceProv;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getDateServiceProv() {
        return dateServiceProv;
    }

    public void setDateServiceProv(String dateServiceProv) {
        this.dateServiceProv = dateServiceProv;
    }
}
