package com.swalab.backend;

import com.swalab.backend.database.TechnicianDatabase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.*;

@SpringBootApplication
public class SwalabBackendApplication {

    public static void main(String[] args) {
        writingProcessID();


        SpringApplication.run(SwalabBackendApplication.class, args);
    }

    private static void writingProcessID() {
        long pid = ProcessHandle.current().pid();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("pid.info"))) {
            bw.write(pid + "");
            bw.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Bean
    public TechnicianDatabase database() {
        return new TechnicianDatabase();
    }
}
