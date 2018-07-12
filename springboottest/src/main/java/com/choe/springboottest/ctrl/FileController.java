package com.choe.springboottest.ctrl;

import com.choe.springboottest.file_upload.FileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cyk
 * @date 2018/7/11/011 10:47
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */

@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    @RequestMapping("/upload")
    public Object upload(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "file") MultipartFile[] files){

        try {
            if (files == null || files.length == 0) {
                System.out.println("上传文件不存在");
                return null;
            }
            List<String> webUrlList = new ArrayList<String>();
            for (MultipartFile file : files) {
                if (file == null || file.isEmpty() || file.getBytes().length == 0) {
                    System.out.println("文件组中发现空文件");
                }
                String webUrl = fileService.upload(request, file);
                webUrlList.add(webUrl);
            }
            Map<String, Object> map = new HashMap<String, Object>();
            if(webUrlList != null) {
                if(webUrlList.size() == 1) {
                    map.put("url", webUrlList.get(0));
                    return map;
                } else if(webUrlList.size() > 1) {
                    map.put("url", webUrlList);
                    return map;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Object();
    }

    @RequestMapping("/load")
    public void download(HttpServletRequest request, HttpServletResponse response, String fileName){
        fileService.download(fileName,response);
    }

    @RequestMapping(value = "/uploadByUrl" ,method = RequestMethod.GET)
    public String uploadByUrl(String url){
        return fileService.uploadImageByUrl(url);
    }
}
