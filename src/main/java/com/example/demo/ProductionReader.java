package com.example.demo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Profile("prod")
class ProductionReader implements FileHandler {
    @Override
    public List<Entry> readAllFile(String fileName) throws IOException {
        return Files.readAllLines(Paths.get(fileName))
                .stream()
                .map(Encryption::decrypt)
                .map(FileService.CsvEntryConverter::parse)
                .collect(Collectors.toList());
    }

    public String encryptEntry(String entry) {
        return Encryption.encrypt(entry);
    }
}
