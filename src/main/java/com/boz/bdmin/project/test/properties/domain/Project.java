package com.boz.bdmin.project.test.properties.domain;

/**
 * @author boz
 * @date 2019/6/5
 */
public class Project {

    private String name;
    private String version;
    private String imgUploadUrl;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getImgUploadUrl() {
        return imgUploadUrl;
    }

    public void setImgUploadUrl(String imgUploadUrl) {
        this.imgUploadUrl = imgUploadUrl;
    }


    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", imgUploadUrl='" + imgUploadUrl + '\'' +
                '}';
    }
}
