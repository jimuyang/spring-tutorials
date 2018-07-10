package muyi;

public class HelloMessage{


    private String name;

    public HelloMessage(){
        
    }

    public HelloMessage(String name){
        this.name = name;
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


}