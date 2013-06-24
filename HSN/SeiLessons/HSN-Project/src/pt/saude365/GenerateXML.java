package pt.saude365;

import java.io.File;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import pt.saude365.randomgenerators.RandomMedicamentoGenerator;
import pt.saude365.randomgenerators.RandomMoradaGenerator;
import pt.saude365.randomgenerators.RandomNameGenerator;
import pt.saude365.randomgenerators.RandomTriagemGenerator;
import pt.saude365.patientreport.*;

public class GenerateXML
{
	public static void main(String[] args) throws JAXBException,
			DatatypeConfigurationException {

        while(true){
            
            
            try {
               
                ObjectFactory factory = new ObjectFactory(); 
		RandomMoradaGenerator moradaGen = new RandomMoradaGenerator(
				"files/moradas.txt", new Random());
		RandomNameGenerator nameGen = new RandomNameGenerator("files/nomes.utf8.txt",
				"files/apelidos.utf8.txt", new Random());
		RandomTriagemGenerator triagemGen = new RandomTriagemGenerator(
				"files/tipotriagem.txt", "files/niveltriagem.txt", new Random());
		RandomMedicamentoGenerator medicamentosGen = new RandomMedicamentoGenerator(
				"files/medicamentos.txt", new Random());

		String moradaString = moradaGen.nextMorada();
		String[] morada = moradaString.split("\\$");
		MoradaType moradaType = factory.createMoradaType();
		moradaType.setCodigoPostal(morada[0]);
		moradaType.setRua(morada[1]);
		moradaType.setNum("" + new Random().nextInt(500));
		moradaType.setAndar("" + new Random().nextInt(20));
		moradaType.setApartamento("" + new Random().nextInt(1200));

		Random randomCal = new Random();
		GregorianCalendar gcal = new GregorianCalendar();
		int year = randomCal.nextInt(2013 - 1920 + 1) + 1920;
		int month = randomCal.nextInt(Calendar.DECEMBER) + 1;
		int day = randomCal.nextInt(31) + 1;
		
                DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
                Date dob;

                dob = df.parse(year + "/" + month + "/" + day);

                gcal.setTime(dob);
                
                XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance()
				.newXMLGregorianCalendarDate(gcal.get(Calendar.YEAR), gcal.get(Calendar.MONTH) + 1, gcal.get(Calendar.DAY_OF_MONTH), DatatypeConstants.FIELD_UNDEFINED);
                
		DoenteType doente = factory.createDoenteType();
                int id = new Random().nextInt(999999);
		doente.setId("" + id);
		String name = nameGen.nextName();
                doente.setNome(name);
		doente.setDataNasc(xmlDate);
                String seguro = new Random().nextBoolean() ? "Sim" : "Não";
		doente.setSeguroSaude(seguro);
		doente.setMorada(moradaType);

		String triagemString = triagemGen.nextTriagem();
		String[] triagem = triagemString.split("\\$");
		TriagemType triagemType = factory.createTriagemType();
		triagemType.setTipo(triagem[0]);
		triagemType.setNivel(triagem[1]);
    
                int stop = new Random().nextInt(5) + 1;
		for (int i = 0; i < stop; i++) {
			String medicamentoString = medicamentosGen.nextMedicamento();
			String[] medicamento = medicamentoString.split("\\$");
			MedicamentoType medicamentoType = factory.createMedicamentoType();
			medicamentoType.setSubstancia(medicamento[1]);
			medicamentoType.setNome(medicamento[0]);
			medicamentoType.setDose(medicamento[2]);
			triagemType.getMedicamento().add(medicamentoType);
		}

		RelatorioType relatorio = factory.createRelatorioType();
		relatorio.setDoente(doente);
		relatorio.setTriagem(triagemType);

		gcal = new GregorianCalendar();
		XMLGregorianCalendar xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);

		relatorio.setDataHora(xgcal);

		JAXBContext context = JAXBContext.newInstance("pt.saude365.patientreport");
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
		marshaller.marshal(factory.createRelatorio(relatorio), new File(
				"files/reportinput/patient.xml"));
                
                EntryPatient.generateEntryPatient(id,xmlDate,name,seguro);
    
        }
        catch (ParseException e) {
            System.err.println(e.getMessage());
        }

            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
            }
        }
            }
        
}
