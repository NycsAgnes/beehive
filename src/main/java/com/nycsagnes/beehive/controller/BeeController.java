package com.nycsagnes.beehive.controller;

import com.nycsagnes.beehive.dto.incoming.BeeCreateUpdateCommand;
import com.nycsagnes.beehive.dto.outgoing.BeeInfo;
import com.nycsagnes.beehive.service.BeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bees")
@Slf4j
public class BeeController {

    private final BeeService beeService;

    public BeeController(BeeService beeService) {
        this.beeService = beeService;
    }

    @PostMapping
    public ResponseEntity<BeeInfo> save (@Valid @RequestBody BeeCreateUpdateCommand command){
        log.info("Http Request, POST /api/bees, body: " + command.toString());
        BeeInfo beeInfo = beeService.save(command);
        return new ResponseEntity<>(beeInfo, HttpStatus.CREATED);
    }
}
