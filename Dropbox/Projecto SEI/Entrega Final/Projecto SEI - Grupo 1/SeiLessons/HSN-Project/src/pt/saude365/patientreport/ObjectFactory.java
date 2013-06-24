
package pt.saude365.patientreport;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the pt.saude365.patientreport package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Relatorio_QNAME =
        new QName("http://saude365.pt", "relatorio");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pt.saude365.patientreport
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RelatorioType }
     *
     */
    public RelatorioType createRelatorioType() {
        return new RelatorioType();
    }

    /**
     * Create an instance of {@link TriagemType }
     *
     */
    public TriagemType createTriagemType() {
        return new TriagemType();
    }

    /**
     * Create an instance of {@link MoradaType }
     *
     */
    public MoradaType createMoradaType() {
        return new MoradaType();
    }

    /**
     * Create an instance of {@link DoenteType }
     *
     */
    public DoenteType createDoenteType() {
        return new DoenteType();
    }

    /**
     * Create an instance of {@link MedicamentoType }
     *
     */
    public MedicamentoType createMedicamentoType() {
        return new MedicamentoType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RelatorioType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://saude365.pt", name = "relatorio")
    public JAXBElement<RelatorioType> createRelatorio(RelatorioType value) {
        return new JAXBElement<RelatorioType>(_Relatorio_QNAME,
                                              RelatorioType.class, null,
                                              value);
    }

}
