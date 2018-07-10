package muyi;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class UserBean{

    private String name;
    private String blog;

    /**
     * @return the blog
     */
    public String getBlog() {
        return blog;
    }
    /**
     * @param blog the blog to set
     */
    public void setBlog(String blog) {
        this.blog = blog;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "User [name=" + name + ", blog=" + blog + "]";
    }



}