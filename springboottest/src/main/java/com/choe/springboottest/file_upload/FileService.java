package com.choe.springboottest.file_upload;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cyk
 * @date 2018/7/11/011 10:45
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */

@Service
public class FileService {

    @Value("${file_upload_path}")
    private String filepath;

    @Value("${file_download_url}")
    private String downloadurl;

    /**
     * 表单上传文件
     * @param request
     * @param file
     * @return
     */
    public String upload(HttpServletRequest request,MultipartFile file){

        try {
            // 获取源文件名称
            String originalFilename = file.getOriginalFilename();

            File fileDir = new File(filepath);
            if (!fileDir.exists()){
                fileDir.mkdirs();
            }
            File destFile = new File(fileDir,originalFilename);
            file.transferTo(destFile);
            String webUrl = downloadurl+"load?fileName="+originalFilename;
            return webUrl;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /***
     * 根据url上传图片
     * @param urlString
     * @return
     */
    public String uploadImageByUrl(String urlString){
        try {
            String fileName = urlString.substring(urlString.lastIndexOf("/")+1);
            fileName = fileName.substring(0,fileName.lastIndexOf("."));
            URL url = new URL(urlString);
            BufferedImage bi = ImageIO.read(url);
            ImageIO.write(bi,"png",new File(filepath,fileName+".png"));
            return downloadurl+"load?fileName="+fileName+".png";
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
        return null;
    }

    /**
     * 下载图片
     * @param fileName
     * @param response
     */
    public void download(String fileName , HttpServletResponse response){
        FileInputStream fin = null;
        try {
            File file = new File(filepath,fileName);
            // 下载提示保存的文件名
            response.setHeader("content-disposition", "attachment; filename=" + fileName);
            OutputStream out = response.getOutputStream();
            fin = new FileInputStream(file);
            byte[] bts = new byte[1024];
            int length = 0;
            while ((length = fin.read(bts)) != -1) {
                out.write(bts, 0, length);
            }
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
