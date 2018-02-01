package documentkeeper.model;

public class File {
    private int id;
    private int doc_id;
    private String url;
    private String name;
    private String text;
    
    public File(){}

    public File(int id, int doc_id, String url, String name, String text) {
        this.id = id;
        this.doc_id = doc_id;
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

    public int getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(int doc_id) {
        this.doc_id = doc_id;
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
