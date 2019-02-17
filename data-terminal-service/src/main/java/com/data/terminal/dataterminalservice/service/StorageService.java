package com.data.terminal.dataterminalservice.service;

import com.data.terminal.dataterminalservice.helper.TerminalHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class StorageService {

    public final Path rootLocation = Paths.get(TerminalHelper.PATH);

    public void store(MultipartFile file) {
        try {
            Files.createDirectory(rootLocation);
            Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
            System.out.println("file stored in local drive");
        } catch (Exception e) {
            throw new RuntimeException("FAIL!");
        }
    }
}
