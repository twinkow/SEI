
package pt.saude365.patientreport;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TriagemType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TriagemType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tipo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nivel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="medicamento" type="{http://saude365.pt}MedicamentoType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TriagemType", propOrder = { "tipo", "nivel", "medicamento" })
public class TriagemType {

    @XmlElement(required = true)
    protected String tipo;
    @XmlElement(required = true)
    protected String nivel;
    protected List<MedicamentoType> medicamento;

    /**
     * Gets the value of the tipo property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Sets the value of the tipo property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTipo(String value) {
        this.tipo = value;
    }

    /**
     * Gets the value of the nivel property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNivel() {
        return nivel;
    }

    /**
     * Sets the value of the nivel property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNivel(String value) {
        this.nivel = value;
    }

    /**
     * Gets the value of the medicamento property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the medicamento property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMedicamento().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MedicamentoType }
     *
     *
     */
    public List<MedicamentoType> getMedicamento() {
        if (medicamento == null) {
            medicamento = new ArrayList<MedicamentoType>();
        }
        return this.medicamento;
    }

}
