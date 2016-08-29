package servlets;

/**
 * Created by mrahbari on 09/09/2015.
 */
public class UserBean {

    String id;
    String name = "mojitoBEAN";
    String family = "rahbaritoBEAN";
    Boolean status =false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
