package muyi;

public class HelloContent{

    private String content;

    public HelloContent(){
        
    }
    public HelloContent(String content){
        this.content = content;
    }

    
    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

}