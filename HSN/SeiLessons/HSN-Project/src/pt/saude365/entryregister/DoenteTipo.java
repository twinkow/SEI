
package pt.saude365.entryregister;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for doenteTipo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="doenteTipo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nome" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dataNasc" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="seguroSaude" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="morada" type="{http://saude365.pt/registoentrada}moradaTipo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "doenteTipo", propOrder = {
    "nome",
    "dataNasc",
    "id",
    "seguroSaude",
    "morada"
})
public class DoenteTipo {

    @XmlElement(required = true)
    protected String nome;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dataNasc;
    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String seguroSaude;
    @XmlElement(required = true)
    protected MoradaTipo morada;

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
     * Gets the value of the dataNasc property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataNasc() {
        return dataNasc;
    }

    /**
     * Sets the value of the dataNasc property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataNasc(XMLGregorianCalendar value) {
        this.dataNasc = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the seguroSaude property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeguroSaude() {
        return seguroSaude;
    }

    /**
     * Sets the value of the seguroSaude property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeguroSaude(String value) {
        this.seguroSaude = value;
    }

    /**
     * Gets the value of the morada property.
     * 
     * @return
     *     possible object is
     *     {@link MoradaTipo }
     *     
     */
    public MoradaTipo getMorada() {
        return morada;
    }

    /**
     * Sets the value of the morada property.
     * 
     * @param value
     *     allowed object is
     *     {@link MoradaTipo }
     *     
     */
    public void setMorada(MoradaTipo value) {
        this.morada = value;
    }

}
