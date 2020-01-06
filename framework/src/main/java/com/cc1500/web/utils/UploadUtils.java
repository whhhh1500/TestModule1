package com.cc1500.web.utils;

import com.cc1500.web.utils.platform.OperationSystem;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

/**
 * 上传模块文件
 * @Author 明建新
 * @Create 2019/9/20 11:35
 * @Version 1.0
 */
public class UploadUtils {
    public static String uploadFile(MultipartFile file,String templateFileName) throws IOException{
        //这里就可以获取里面的上传过来的数据了
        String path = null;
        Calendar currTime = Calendar.getInstance();
        String time = String.valueOf(currTime.get(Calendar.YEAR)) + String.valueOf((currTime.get(Calendar.MONTH) + 1));
        if (OperationSystem.isWindos()) {
            path = System.getProperty("user.dir")+"//ibms-admin//src//main//resources//static//"+templateFileName;
            System.out.println("上传的系统是Windows");
        }
        if (OperationSystem.isLinux()) {
            path = "home"+System.getProperty("file.separator")+"xingcloud"+System.getProperty("file.separator")+"ibmsMusic"+System.getProperty("file.separator")+templateFileName;
            System.out.println("上传的系统是Linux");
        }
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        suffix = suffix.toLowerCase();
        String fileName = UUID.randomUUID().toString().replaceAll("-", "") + suffix;
        File targetFile = new File(path, fileName);
        //注意，判断父级路径是否存在
        if (!targetFile.getParentFile().exists()) {
            targetFile.getParentFile().mkdirs();
        }
        long size = 0;
        file.transferTo(targetFile);
        if (OperationSystem.isLinux()) {
            String tmpFile = "/usr/local/yealink/data/version-manager/work/Tomcat/localhost/ROOT/home/xingcloud/ibmsmusic/musicfile/" + fileName;
            System.out.println("移动文件：从路径 " + tmpFile + " 移动到路径 " + path);
            File musicFile = new File(tmpFile);
            if (musicFile.isFile()) {
                File toFile = new File(path + System.getProperty("file.separator") + file.getName());
                if (toFile.exists()) {
                    System.out.println("文件已存在");
                } else {
                    musicFile.renameTo(toFile);
                    System.out.println("移动文件成功");
                }
            }
        }
        return fileName;
    }
}
