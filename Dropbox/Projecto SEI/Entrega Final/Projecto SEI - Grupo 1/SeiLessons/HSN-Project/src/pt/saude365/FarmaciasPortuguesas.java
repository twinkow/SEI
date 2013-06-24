package pt.saude365;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.*;

@WebService(portName = "FarmaciasPortuguesasSoap12HttpPort")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class FarmaciasPortuguesas {

    @WebMethod
    public List<FarmaciasInformation> getFarmaciasProximas(@WebParam(name="distrito")String distritoInput,@WebParam(name="concelho") String concelhoInput, @WebParam(name="freguesia") String freguesiaInput ) throws InterruptedException {

        // Criar uma nova instancia do Web Driver
        WebDriver driver = new HtmlUnitDriver(true);

        // Visitar a página das farmacias portuguesas
        driver.get("http://www.farmaciasportuguesas.pt:80/indexFarmaciasAderentes.jsf");

        // Clicar na selection box dos distritos
        WebElement selectDistrito =
            driver.findElement(By.id("pf_FarmaciasAderentes3:form1:drop_distrito1"));
        List<WebElement> distritosOptions =
            selectDistrito.findElements(By.tagName("option"));
        for (WebElement distrito : distritosOptions) {
            if (distrito.getText().equals(distritoInput)) {
                distrito.click();
                // System.out.println(distrito.getText());
                break;
            }
        }

        // Clicar na selection box dos concelhos
        Thread.sleep(1000);

        WebElement selectConcelho =
            driver.findElement(By.id("pf_FarmaciasAderentes3:form1:drop_concelho1"));
        List<WebElement> concelhosOptions =
            selectConcelho.findElements(By.tagName("option"));
        for (WebElement concelho : concelhosOptions) {
            if (concelho.getText().equals(concelhoInput)) {
                concelho.click();
                // System.out.println(concelho.getText());
                break;
            }
        }

        Thread.sleep(1000);

        // Clicar na selection box das freguesias
        WebElement selectFreguesia =
            driver.findElement(By.id("pf_FarmaciasAderentes3:form1:drop_freguesia1"));
        List<WebElement> freguesiasOptions =
            selectFreguesia.findElements(By.tagName("option"));
        for (WebElement freguesia : freguesiasOptions) {
            if (freguesia.getText().equals(freguesiaInput)) {
                freguesia.click();
                // System.out.println(freguesia.getText());
                break;
            }
        }

        // Clicar no botão de pesquisa
        WebElement pesquisar =
            driver.findElement(By.id("pf_FarmaciasAderentes3:form1:linkPesquisar2"));
        pesquisar.click();

        Thread.sleep(1000);

        // Obter a informação das farmacias
        List<WebElement> listaNomesFarmacias =
            driver.findElement(By.id("pf_FarmaciasAderentes3:form1:listaTXT")).findElements(By.className("lista-farmaciasbold"));
        List<WebElement> listaInfoFarmacias =
            driver.findElement(By.id("pf_FarmaciasAderentes3:form1:listaTXT")).findElements(By.className("lista-farmacias"));

        List<FarmaciasInformation> list = new ArrayList<FarmaciasInformation>();
        
        boolean flag = true;
        for (int i = 0;
             i < listaNomesFarmacias.size() && i < listaInfoFarmacias.size();
             i++) {
            FarmaciasInformation farmaciaInformation = new FarmaciasInformation();
            farmaciaInformation.setFarmaciaName(listaNomesFarmacias.get(i).getText());
            String[] txt = listaInfoFarmacias.get(i).getText().split("\n");
            farmaciaInformation.setDirectorTecnico(txt[0]);
            farmaciaInformation.setMorada(txt[1]);
            farmaciaInformation.setDistrito(txt[2]);
            farmaciaInformation.setConcelho(txt[3]);
            farmaciaInformation.setFreguesia(txt[4]);
            farmaciaInformation.setTelefone(txt[5]);
            list.add(farmaciaInformation);
            flag = false;
        }
         
        
       /*  FarmaciasInformation farmaciaInformation = new FarmaciasInformation();
        
        boolean flag = true;
        for (int i = 0;
             i < listaNomesFarmacias.size() && i < listaInfoFarmacias.size();
             i++) {
            farmaciaInformation.setFarmaciaName(listaNomesFarmacias.get(i).getText());
            String[] txt = listaInfoFarmacias.get(i).getText().split("\n");
            farmaciaInformation.setDirectorTecnico(txt[0]);
            farmaciaInformation.setMorada(txt[1]);
            farmaciaInformation.setDistrito(txt[2]);
            farmaciaInformation.setConcelho(txt[3]);
            farmaciaInformation.setFreguesia(txt[4]);
            farmaciaInformation.setTelefone(txt[5]);
            flag = false;
        }
        
        if(flag)
            farmaciaInformation.setFarmaciaName("null"); */
        
        return list;
    }
}

