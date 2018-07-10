package hello;

public class Email{
    private String to;
    private String body;

    public Email(){
        
    }

    public Email(String to ,String body){
        this.body = body;
        this.to = to;
    }

    /**
     * @param body the body to set
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * @return the to
     */
    public String getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return String.format("Email{to=%s,body=%s}", getTo(),getBody());
    }




}