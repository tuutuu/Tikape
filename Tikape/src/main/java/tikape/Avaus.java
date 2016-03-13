package tikape;

public class Avaus {

    private int avaus_id;
    private int alue_id;
    private String avausnimi;
    private String avausteksti;
    private String aloitusaika;
    private Alue a;

    public Avaus(int avaus_id, int alue_id, String avausnimi, String avausteksti, String aloitusaika) {
        this.avaus_id = avaus_id;
        this.alue_id = alue_id;
        this.avausnimi = avausnimi;
        this.avausteksti = avausteksti;
        this.aloitusaika = aloitusaika;
    }

    public int getAvaus_id() {
        return avaus_id;
    }

    public void setAvaus_id(int avaus_id) {
        this.avaus_id = avaus_id;
    }

    //  public int getAlue_id() {
    //      return alue_id;
    //   }
    public void setAlue(Alue a) {
        this.a = a;
    }

    public Alue getAlue() {
        return this.a;
    }

    public void setAlue_id(int alue_id) {
        this.alue_id = alue_id;
    }

    public String getAvausnimi() {
        return avausnimi;
    }

    public void setAvausnimi(String avausnimi) {
        this.avausnimi = avausnimi;
    }

    public String getAvausteksti() {
        return avausteksti;
    }

    public void setAvausteksti(String avausteksti) {
        this.avausteksti = avausteksti;
    }

    public String getAloitusaika() {
        return aloitusaika;
    }

    public void setAloitusaika(String aloitusaika) {
        this.aloitusaika = aloitusaika;
    }

}
