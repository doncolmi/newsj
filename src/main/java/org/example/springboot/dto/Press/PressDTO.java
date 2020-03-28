package org.example.springboot.dto.Press;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.springboot.domain.Press.Press;

@Getter
@ToString
@NoArgsConstructor
public class PressDTO {
    private String name;

    public Press toEntity() {
        return Press.builder()
                .name(name)
                .build();
    }

    @Builder
    public PressDTO(String name) {
        this.name = name;
    }
}
