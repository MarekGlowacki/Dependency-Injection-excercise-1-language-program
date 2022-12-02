package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
class FileService {
    private final String fileName;
    private final FileHandler fileHandler;

    FileService(@Value("${app.message.filename}") String fileName, FileHandler fileHandler) {
        this.fileName = fileName;
        this.fileHandler = fileHandler;
    }

    List<Entry> readAllFile() throws IOException {
        return fileHandler.readAllFile(fileName);
    }

    void saveEntries(List<Entry> entries) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (Entry entry : entries) {
            String encryptedEntry = fileHandler.encryptEntry(entry.toString());
            writer.write(encryptedEntry);
            writer.newLine();
        }
        writer.close();
    }

    static class CsvEntryConverter {
        static Entry parse(String text) {
            String[] split = text.split(";");
            return new Entry(split[0], split[1]);
        }
    }
}
