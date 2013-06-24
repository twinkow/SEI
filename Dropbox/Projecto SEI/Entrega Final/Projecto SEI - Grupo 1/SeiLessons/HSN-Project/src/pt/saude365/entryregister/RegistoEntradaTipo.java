
package pt.saude365.entryregister;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for registoEntradaTipo complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="registoEntradaTipo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dataHora" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="doente" type="{http://saude365.pt/registoentrada}doenteTipo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "registoEntradaTipo", propOrder = { "dataHora", "doente" })
public class RegistoEntradaTipo {

    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataHora;
    @XmlElement(required = true)
    protected DoenteTipo doente;

    /**
     * Gets the value of the dataHora property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getDataHora() {
        return dataHora;
    }

    /**
     * Sets the value of the dataHora property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setDataHora(XMLGregorianCalendar value) {
        this.dataHora = value;
    }

    /**
     * Gets the value of the doente property.
     *
     * @return
     *     possible object is
     *     {@link DoenteTipo }
     *
     */
    public DoenteTipo getDoente() {
        return doente;
    }

    /**
     * Sets the value of the doente property.
     *
     * @param value
     *     allowed object is
     *     {@link DoenteTipo }
     *
     */
    public void setDoente(DoenteTipo value) {
        this.doente = value;
    }

}
