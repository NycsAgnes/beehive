package com.nycsagnes.beehive.dto.outgoing;

import com.nycsagnes.beehive.domain.Bee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HiveInfo {

    private Long id;

    private String hiveName;

    private List<Bee> bees;

}
