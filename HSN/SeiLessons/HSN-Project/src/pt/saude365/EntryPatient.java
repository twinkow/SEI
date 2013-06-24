package pt.saude365;

import java.io.File;

import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import javax.xml.datatype.XMLGregorianCalendar;

import pt.saude365.entryregister.DoenteTipo;
import pt.saude365.entryregister.MoradaTipo;
import pt.saude365.entryregister.ObjectFactory;
import pt.saude365.entryregister.RegistoEntradaTipo;
import pt.saude365.entryregister.Registoentrada;

public class EntryPatient {
    
    public EntryPatient() {
        super();
    }
    
    public static void generateEntryPatient(int id, XMLGregorianCalendar dataNasc, String nome, String seguro){

        try {
            Thread.sleep(60000);
            ObjectFactory regentradaFactory = new ObjectFactory();
            RegistoEntradaTipo regentradaTipo = regentradaFactory.createRegistoEntradaTipo();
            
            MoradaTipo morada = new MoradaTipo();
            morada.setCodigoPostal("2790-180");
            morada.setRua("Rua Sertório do Monte Pereira");
            morada.setApartamento("A");
            morada.setAndar("1");
            morada.setNum("7");
            morada.setConcelho("Oeiras");
            morada.setDistrito("Lisboa");
            morada.setFreguesia("Carnaxide");
            
            DoenteTipo doente = new DoenteTipo();
            doente.setId("" + id);            
            doente.setDataNasc(dataNasc);
            doente.setMorada(morada);
            doente.setNome(nome);
            doente.setSeguroSaude(seguro);
            regentradaTipo.setDoente(doente);
            
            GregorianCalendar gcal = new GregorianCalendar();
            XMLGregorianCalendar xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
            
            regentradaTipo.setDataHora(xgcal);

            JAXBElement regentrada = regentradaFactory.createRegistoentrada(regentradaTipo);

            JAXBContext contextReg = JAXBContext.newInstance("pt.saude365.entryregister");
            Marshaller marshallerReg = contextReg.createMarshaller();
            marshallerReg.setProperty("jaxb.formatted.output", Boolean.TRUE);
            marshallerReg.marshal(regentrada, new File(
                        "files/entrypatient/entrypatient.xml"));
            
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        } catch (DatatypeConfigurationException e) {
            System.err.println(e.getMessage());
        } catch (JAXBException e) {
            System.err.println(e.getMessage());
        }
    }
}
