package com.plg.spring_file_upload.controller;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@RestController
public class TestController {

  private static final Logger logger = Logger.getLogger(TestController.class.getName());

  @PostMapping("upload")
  public void upload(@RequestParam("file") MultipartFile file) throws Exception {
    logger.info("File Upload");

    double size = file.getSize() / 1048576;
    System.out.println("Name : " + file.getName());
    System.out.println("Size : " + size);
    System.out.println("Bytes : " + file.getBytes());
    System.out.println("Original name : " + file.getOriginalFilename());
    System.out.println("Content type : " + file.getContentType());
  }

  @PostMapping("upload-image")
  public void upload2(@RequestBody TestDto testDto) throws Exception {
    logger.info("Img Upload");
    System.out.println(testDto);
  }
}

@Data
class TestDto {
  private String userImage;
  private String userId;
}
