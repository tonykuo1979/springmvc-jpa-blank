package org.tonykuo.service.dto;

import lombok.Data;

public @Data class DemoDTO {
    
    public DemoDTO(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
    
    private Long id;
    private String name;

}
