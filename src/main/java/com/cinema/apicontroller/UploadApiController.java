package com.cinema.apicontroller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.cinema.classGeneric.Page;
import com.cinema.form.UploadForm;
import com.cinema.form.UploadedFiles;
import com.cinema.models.Visitors;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/upload")
@CrossOrigin(origins = "")
@RequiredArgsConstructor
public class UploadApiController {

    String absolutePath = new FileSystemResource("").getFile().getAbsolutePath();
    private static String UPLOAD_DIR = "";
    private String descripion = "";

    @PostMapping("/add")
    public ResponseEntity<?> uploadFile(@ModelAttribute UploadForm form) throws Exception {
        UPLOAD_DIR = absolutePath + "/src/main/resources/static/pictures/" + form.getDescription();
        descripion = form.getDescription() ;

        String result = null;
        try {

            result = this.saveUploadedFile(form.getFiles());

        }
        // Here Catch IOException only.
        // Other Exceptions catch by RestGlobalExceptionHandler class.
        catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<String>(result, HttpStatus.OK);
    }

    @PostMapping("/add-multi")
    public ResponseEntity<List<UploadedFiles>> uploadMultiFiles(@ModelAttribute UploadForm form) throws Exception {
        UPLOAD_DIR = absolutePath + "/src/main/resources/static/pictures/" + form.getDescription();
        descripion = form.getDescription() ;

        List<UploadedFiles> result = null;

        result = this.saveUploadedFiles(form.getFiles());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // Save Files
    private List<UploadedFiles> saveUploadedFiles(MultipartFile[] files) throws IOException {
        List<UploadedFiles> urls = new ArrayList<>();

        // Make sure directory exists!
        File uploadDir = new File(UPLOAD_DIR);
        uploadDir.mkdirs();

        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                continue;
            }
            int randomNumber = (int)(Math.random()*10000);
            String uploadFilePath = UPLOAD_DIR + "/" + randomNumber + file.getOriginalFilename().replaceAll(" ", "");
            byte[] bytes = file.getBytes();
            Path path = Paths.get(uploadFilePath);
            Files.write(path, bytes);
            urls.add(new UploadedFiles(descripion + "/"+randomNumber+file.getOriginalFilename().replaceAll(" ", "")));
        }
        return urls;
    }
    // Save Files
    private String saveUploadedFile(MultipartFile[] files) throws IOException {

        // Make sure directory exists!
        File uploadDir = new File(UPLOAD_DIR);
        uploadDir.mkdirs();

        for (MultipartFile file : files) {

            if (file.isEmpty()) {
                continue;
            }
            int randomNumber = (int)(Math.random()*10000);
            String uploadFilePath = UPLOAD_DIR + "/" + randomNumber + file.getOriginalFilename().replaceAll(" ", "");
            byte[] bytes = file.getBytes();
            Path path = Paths.get(uploadFilePath);
            Files.write(path, bytes);
            descripion  += "/"+randomNumber+file.getOriginalFilename().replaceAll(" ", "");
        }
        return descripion;
    }
}
