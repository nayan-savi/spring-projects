package com.data.terminal.dataterminalservice.service;

import com.data.terminal.dataterminalservice.helper.TerminalHelper;
import com.data.terminal.dataterminalservice.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/rest")
public class DataUploadService {


    @Autowired
    private StorageService storageService;

    @Autowired
    private TerminalHelper terminalHelper;


    @PostMapping(value = "/upload", produces = "application/json")
    public ResponseEntity<List<Student>> uploadData(@RequestParam("file") MultipartFile file) throws IOException {
        storageService.store(file);
        Resource resource = file.getResource();
        System.out.println(resource.getFilename());
        List<Student> students = terminalHelper.getStudents(resource.getFilename());
        students.forEach(student -> System.out.println(student));
        return ResponseEntity.ok(students);
    }


}
