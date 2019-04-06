package sda.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.sql.Date;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "OsobaUPO{" +
                "imieUpoI='" + imieUpoI + '\'' +
                ", nazwiskoUpoI='" + nazwiskoUpoI + '\'' +
                ", nrDowoduUpoI='" + nrDowoduUpoI + '\'' +
                ", dataDodaniaUpoI=" + dataDodaniaUpoI +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OsobaUPO osobaUPO = (OsobaUPO) o;
        return Objects.equals(imieUpoI, osobaUPO.imieUpoI) &&
                Objects.equals(nazwiskoUpoI, osobaUPO.nazwiskoUpoI) &&
                Objects.equals(nrDowoduUpoI, osobaUPO.nrDowoduUpoI);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imieUpoI, nazwiskoUpoI, nrDowoduUpoI);
    }
}
