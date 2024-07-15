package com.tigmaminds.jithu.demo.model;

public class Images {
    private String id;
    private String fileName;
    private byte[] data;
    private String contentType;
    public Images(String id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getData() {
        return data;
    }

    public Images(String fileName){
        this.fileName = fileName;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Images() {
    }

    public String getId() {
        return id;
    }
//    public byte[] getData{
//        return data;
//    }

    public void setId(String it) {
        this.id = it;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }
}
