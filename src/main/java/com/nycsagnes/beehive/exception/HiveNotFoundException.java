package com.nycsagnes.beehive.exception;

public class HiveNotFoundException extends RuntimeException {

    public HiveNotFoundException(Long hiveId) {
        super("Hive not found with id: " + hiveId);
    }
}
