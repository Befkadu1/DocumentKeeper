package documentkeeper.model;

import java.util.ArrayList;

public class Folder {
    private int id;
    private String name;
    private String description;
    private ArrayList<Category> categoryList;
    private ArrayList<File> fileList;

    public Folder() {
    }

    public Folder(int id, String name, String description, ArrayList<Category> categoryList, ArrayList<File> fileList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.categoryList = categoryList;
        this.fileList = fileList;
    }
    
    public Folder(int id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
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

    public ArrayList<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(ArrayList<Category> newList) {
        this.categoryList = newList;
    }

    public ArrayList<File> getFileList() {
        return fileList;
    }

    public void setFileList(ArrayList<File> fileList) {
        this.fileList = fileList;
    }  
}
