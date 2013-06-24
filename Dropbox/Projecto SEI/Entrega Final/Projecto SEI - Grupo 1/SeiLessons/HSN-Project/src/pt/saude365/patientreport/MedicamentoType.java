
package pt.saude365.patientreport;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MedicamentoType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="MedicamentoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="substancia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nome" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dose" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MedicamentoType",
         propOrder = { "substancia", "nome", "dose" })
public class MedicamentoType {

    @XmlElement(required = true)
    protected String substancia;
    @XmlElement(required = true)
    protected String nome;
    @XmlElement(required = true)
    protected String dose;

    /**
     * Gets the value of the substancia property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSubstancia() {
        return substancia;
    }

    /**
     * Sets the value of the substancia property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSubstancia(String value) {
        this.substancia = value;
    }

    /**
     * Gets the value of the nome property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets the value of the nome property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNome(String value) {
        this.nome = value;
    }

    /**
     * Gets the value of the dose property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDose() {
        return dose;
    }

    /**
     * Sets the value of the dose property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDose(String value) {
        this.dose = value;
    }

}
