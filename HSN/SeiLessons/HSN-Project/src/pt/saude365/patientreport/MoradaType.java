
package pt.saude365.patientreport;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MoradaType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="MoradaType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigoPostal" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rua" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="num" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="andar" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="apartamento" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MoradaType",
         propOrder = { "codigoPostal", "rua", "num", "andar", "apartamento" })
public class MoradaType {

    @XmlElement(required = true)
    protected String codigoPostal;
    @XmlElement(required = true)
    protected String rua;
    @XmlElement(required = true)
    protected String num;
    @XmlElement(required = true)
    protected String andar;
    @XmlElement(required = true)
    protected String apartamento;

    /**
     * Gets the value of the codigoPostal property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Sets the value of the codigoPostal property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCodigoPostal(String value) {
        this.codigoPostal = value;
    }

    /**
     * Gets the value of the rua property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRua() {
        return rua;
    }

    /**
     * Sets the value of the rua property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRua(String value) {
        this.rua = value;
    }

    /**
     * Gets the value of the num property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNum() {
        return num;
    }

    /**
     * Sets the value of the num property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNum(String value) {
        this.num = value;
    }

    /**
     * Gets the value of the andar property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAndar() {
        return andar;
    }

    /**
     * Sets the value of the andar property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAndar(String value) {
        this.andar = value;
    }

    /**
     * Gets the value of the apartamento property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getApartamento() {
        return apartamento;
    }

    /**
     * Sets the value of the apartamento property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setApartamento(String value) {
        this.apartamento = value;
    }

}
