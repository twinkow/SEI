
package pt.saude365.patientreport;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for RelatorioType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="RelatorioType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dataHora" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="doente" type="{http://saude365.pt}DoenteType"/>
 *         &lt;element name="triagem" type="{http://saude365.pt}TriagemType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RelatorioType",
         propOrder = { "dataHora", "doente", "triagem" })
public class RelatorioType {

    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataHora;
    @XmlElement(required = true)
    protected DoenteType doente;
    @XmlElement(required = true)
    protected TriagemType triagem;

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
     *     {@link DoenteType }
     *
     */
    public DoenteType getDoente() {
        return doente;
    }

    /**
     * Sets the value of the doente property.
     *
     * @param value
     *     allowed object is
     *     {@link DoenteType }
     *
     */
    public void setDoente(DoenteType value) {
        this.doente = value;
    }

    /**
     * Gets the value of the triagem property.
     *
     * @return
     *     possible object is
     *     {@link TriagemType }
     *
     */
    public TriagemType getTriagem() {
        return triagem;
    }

    /**
     * Sets the value of the triagem property.
     *
     * @param value
     *     allowed object is
     *     {@link TriagemType }
     *
     */
    public void setTriagem(TriagemType value) {
        this.triagem = value;
    }

}
