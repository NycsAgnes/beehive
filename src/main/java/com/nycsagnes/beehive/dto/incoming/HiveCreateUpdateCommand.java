package com.nycsagnes.beehive.dto.incoming;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HiveCreateUpdateCommand {

    @NotNull
    @Min(value=10)
    private Integer capacity;

    @NotBlank
    private String hiveName;

}
