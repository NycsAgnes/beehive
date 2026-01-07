package com.nycsagnes.beehive.controller;

import com.nycsagnes.beehive.dto.incoming.BeeCreateUpdateCommand;
import com.nycsagnes.beehive.dto.incoming.HiveCreateUpdateCommand;
import com.nycsagnes.beehive.dto.outgoing.BeeInfo;
import com.nycsagnes.beehive.dto.outgoing.HiveInfo;
import com.nycsagnes.beehive.service.HiveService;
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
@RequestMapping("/api/hives")
@Slf4j
public class HiveController {

    private final HiveService hiveService;

    public HiveController(HiveService hiveService) {
        this.hiveService = hiveService;
    }

    @PostMapping
    public ResponseEntity<HiveInfo> save (@Valid @RequestBody HiveCreateUpdateCommand command){
        log.info("Http Request, POST /api/hives, body: " + command.toString());
        HiveInfo hiveInfo= hiveService.save(command);
        return new ResponseEntity<>(hiveInfo, HttpStatus.CREATED);
    }
}
