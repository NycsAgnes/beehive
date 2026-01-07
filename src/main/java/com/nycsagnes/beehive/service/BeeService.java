package com.nycsagnes.beehive.service;


import com.nycsagnes.beehive.domain.Bee;
import com.nycsagnes.beehive.domain.Hive;
import com.nycsagnes.beehive.dto.incoming.BeeCreateUpdateCommand;
import com.nycsagnes.beehive.dto.outgoing.BeeInfo;
import com.nycsagnes.beehive.repository.BeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BeeService {

    private final ModelMapper modelMapper;
    private final BeeRepository beeRepository;
    private final HiveService hiveService;

    public BeeService (ModelMapper modelMapper, BeeRepository beeRepository, HiveService hiveService){
        this.modelMapper = modelMapper;
        this.beeRepository = beeRepository;
        this.hiveService = hiveService;
    }

    public BeeInfo save(BeeCreateUpdateCommand command){
        Bee bee = modelMapper.map(command, Bee.class);
        Hive hive = hiveService.findById(command.getHive());
        bee.setHive(hive);
        beeRepository.save(bee);
        return modelMapper.map(bee, BeeInfo.class);
    }
}
