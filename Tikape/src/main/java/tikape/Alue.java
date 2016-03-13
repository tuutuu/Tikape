
package tikape;

public class Alue {
    private int alue_id;
    private String alueennimi;
    
    public Alue(int alue_id, String alueennimi) {
        this.alue_id = alue_id;
        this.alueennimi = alueennimi;
    }    

    public int getAlue_id() {
        return alue_id;
    }

    public void setAlue_id(int alue_id) {
        this.alue_id = alue_id;
    }

    public String getAlueennimi() {
        return alueennimi;
    }

    public void setAlueennimi(String alueennimi) {
        this.alueennimi = alueennimi;
    }
    
 
}
