package com.swalab.backend.database;

public class IdGenerator {

    private static long lastId = 0L;

    public static long getNewId() {
        lastId += 1;
        return lastId;
    }
}
