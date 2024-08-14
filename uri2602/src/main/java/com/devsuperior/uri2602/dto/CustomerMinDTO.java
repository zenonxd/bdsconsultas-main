package com.devsuperior.uri2602.dto;

import com.devsuperior.uri2602.projections.CustomerMinProjection;

public class CustomerMinDTO {

    private String name;

    public CustomerMinDTO() {

    }

    public CustomerMinDTO(String name) {
        this.name = name;
    }

    //outro construtor convertendo de Projection para DTO
    public CustomerMinDTO(CustomerMinProjection projection) {
        name = projection.getname();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CustomerMinDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
