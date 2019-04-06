package sda.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.sql.Date;

@Embeddable
public class OsobaUPO {
    @Column
    private String imieUpoI;
    @Column
    private String nazwiskoUpoI;
    @Column
    private String nrDowoduUpoI;
    @Column
    private Date dataDodaniaUpoI;

    public String getImieUpoI() {
        return imieUpoI;
    }

    public void setImieUpoI(String imieUpoI) {
        this.imieUpoI = imieUpoI;
    }

    public String getNazwiskoUpoI() {
        return nazwiskoUpoI;
    }

    public void setNazwiskoUpoI(String nazwiskoUpoI) {
        this.nazwiskoUpoI = nazwiskoUpoI;
    }

    public String getNrDowoduUpoI() {
        return nrDowoduUpoI;
    }

    public void setNrDowoduUpoI(String nrDowoduUpoI) {
        this.nrDowoduUpoI = nrDowoduUpoI;
    }

    public Date getDataDodaniaUpoI() {
        return dataDodaniaUpoI;
    }

    public void setDataDodaniaUpoI(Date dataDodaniaUpoI) {
        this.dataDodaniaUpoI = dataDodaniaUpoI;
    }
}
