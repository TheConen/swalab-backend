package com.swalab.backend.database;

public class IdGenerator {

    private static Long lastId = 0L;

    public static Long getNewId() {
        lastId += 1;
        return lastId;
    }
}
