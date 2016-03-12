package tikape;


public class Viesti {
    private String nimi;
    private int avaus_id;
    private String sisalto;
    private String aikaleima;

    public Viesti(String nimi, int avaus_id, String sisalto, String aikaleima) {
        this.nimi = nimi;
        this.avaus_id = avaus_id;
        this.sisalto = sisalto;
        this.aikaleima = aikaleima;
    }
    
    public String getAikaleima() {
        return aikaleima;
    }

    public void setAikaleima(String aikaleima) {
        this.aikaleima = aikaleima;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public int getAvaus_id() {
        return avaus_id;
    }

    public void setAvaus_id(int avaus_id) {
        this.avaus_id = avaus_id;
    }

    public String getSisalto() {
        return sisalto;
    }

    public void setSisalto(String sisalto) {
        this.sisalto = sisalto;
    }
}
