package muyi.spring.rest;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Jimu Yang.
 */

/**
 *
 */
public class Greeting {

    /**
     * id
     */
    private final long id;

    /**
     * 内容
     */
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }


    
}
