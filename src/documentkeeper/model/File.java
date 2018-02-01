package documentkeeper.model;

public class File {
    private int id;
    private String url;
    private String name;
    private String text;
    
    public File(){}

    public File(int id, String url, String name, String text) {
        this.id = id;
        this.url = url;
        this.name = name;
        this.text = text;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
