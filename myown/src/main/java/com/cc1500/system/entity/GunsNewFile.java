package com.cc1500.system.entity;
import java.io.Serializable;

/**
 * (GunsNewFile)实体类
 *
 * @author makejava
 * @since 2020-01-14 15:22:28
 */
public class GunsNewFile implements Serializable {
    private static final long serialVersionUID = -48697162619276977L;
    //id
    private Integer id;
    //唯一ID
    private String fid;
    //文件名
    private String fileName;
    //文件大小
    private Integer fileSize;
    //文件类型
    private String fileType;
    //文件路径
    private String filePath;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

}