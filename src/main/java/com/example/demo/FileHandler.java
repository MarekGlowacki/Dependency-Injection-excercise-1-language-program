package com.example.demo;

import java.io.IOException;
import java.util.List;

public interface FileHandler {
    List<Entry> readAllFile(String fileName) throws IOException;

     String encryptEntry(String entry);
}
