package documentkeeper.model;

import java.util.ArrayList;

public class Folder {
    private int id;
    private String name;
    private String description;
    private int category_id;
    private ArrayList<File> fileList;

    public Folder() {
    }

    public Folder(int id, String name, String description, int category_id, ArrayList<File> fileList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category_id = category_id;
        this.fileList = fileList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public ArrayList<File> getFileList() {
        return fileList;
    }

    public void setFileList(ArrayList<File> fileList) {
        this.fileList = fileList;
    }  
}
