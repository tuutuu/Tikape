package tikape;


public class Viesti {
    private String nimi;
    private int avaus_id;
    private String sisalto;
    private String aikaleima;
    private Avaus avaus;

    public Viesti(String nimi, String sisalto, String aikaleima) {
        this.nimi = nimi;
        this.sisalto = sisalto;
        this.aikaleima = aikaleima;
        
    }
    
    public Avaus getAvaus() {
    return this.avaus;
    }
    
    public void setAvaus(Avaus avaus){
    this.avaus = avaus;
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
