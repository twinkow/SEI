package pt.saude365;

import java.io.IOException;

import java.text.Normalizer;

import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


@WebService(portName = "InfarmedServiceSoap12HttpPort")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class InfarmedService {
    public InfarmedService() {
        super();
    }

    /* @WebMethod
    public int validateMeds(@WebParam(name = "substancia")
        String subsMed, @WebParam(name = "nome")
        String nomeMed, @WebParam(name = "dose")
        String doseMed) {

        try {
            Connection.Response test =
                Jsoup.connect("http://www.infarmed.pt/infomed/login.php").data("u_nome",
                                                                               "infomed",
                                                                               "u_pass",
                                                                               "infomed").userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_2) AppleWebKit/536.26.17 (KHTML, like Gecko) Version/6.0.2 Safari/536.26.17").method(Method.POST).execute();

            // This will get you cookies
            Map<String, String> cookies = test.cookies();

            String dci =
                Normalizer.normalize(subsMed, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]",
                                                                              "");

            String nome_comer =
                Normalizer.normalize(nomeMed, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]",
                                                                              "");

            String dosagem =
                Normalizer.normalize(doseMed, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]",
                                                                              "");

            test =
Jsoup.connect("http://www.infarmed.pt/infomed/lista.php").data("Submit_.x",
                                                               "0").data("Submit_.y",
                                                                         "0").data("lim_sup",
                                                                                   "100").data("nome_comer",
                                                                                               nome_comer).data("dci",
                                                                                                                dci).data("dosagem",
                                                                                                                          dosagem).cookies(cookies).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_2) AppleWebKit/536.26.17 (KHTML, like Gecko) Version/6.0.2 Safari/536.26.17").method(Method.POST).execute();

            Document doc =
                Jsoup.parse(new String(test.bodyAsBytes(), "ISO-8859-1"));

            int nrPag = 1;
            while (true) {

                Element body = doc.body();

                Elements elms =
                    (body.select("body > table").eq(1)).select("tbody > tr:gt(0)");

                for (int i = 0; i < elms.size(); i++) {
                    Elements cell = elms.get(i).getElementsByTag("td");

                    String subst =
                        Normalizer.normalize(cell.get(0).text(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]",
                                                                                                 "");
                    String nome =
                        Normalizer.normalize(cell.get(1).text(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]",
                                                                                                 "");
                    String dose =
                        Normalizer.normalize(cell.get(3).text(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]",
                                                                                                 "");

                    if (subst.equalsIgnoreCase(dci) &&
                        nome.equalsIgnoreCase(nome_comer) &&
                        dose.equalsIgnoreCase(dosagem)) {
                        String autorizacao = cell.get(5).text();
                        if (autorizacao.equals("Autorizado")) {
                            System.out.println("MEDICAMENTO VALIDO");
                            return 1;
                        }
                    }
                }

                System.out.println(doc.select("form[name=mais]").html());
                if (doc.select("form[name=mais]").html().isEmpty())
                    break;

                nrPag++;
                String pagina = "" + nrPag;

                test =
Jsoup.connect("http://www.infarmed.pt/infomed/login.php").data("u_nome",
                                                               "infomed",
                                                               "u_pass",
                                                               "infomed").userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_2) AppleWebKit/536.26.17 (KHTML, like Gecko) Version/6.0.2 Safari/536.26.17").method(Method.POST).execute();

                // This will get you cookies
                cookies = test.cookies();


                Thread.sleep(500);

                test =
Jsoup.connect("http://www.infarmed.pt/infomed/lista.php").data("Submit_.x",
                                                               "0").data("Submit_.y",
                                                                         "0").data("lim_sup",
                                                                                   "100").data("pagina",
                                                                                               pagina).data("nome_comer",
                                                                                                            nome_comer).data("dci",
                                                                                                                             dci).data("dosagem",
                                                                                                                                       dosagem).cookies(test.cookies()).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_2) AppleWebKit/536.26.17 (KHTML, like Gecko) Version/6.0.2 Safari/536.26.17").method(Method.POST).execute();

                doc =
 Jsoup.parse(new String(test.bodyAsBytes(), "ISO-8859-1"));

            }

            System.out.println("MEDICAMENTO INVÁLIDO");
            return 0;
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
            return 0;
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return 0;
        }
    } */

    @WebMethod
    public DetalhesMedicamento getMedsInfo(@WebParam(name="dci") String dciInput, @WebParam(name="nome") String nomeInput,
                                           @WebParam(name="dosagem") String doseInput) {

        try {

            // Criar uma nova instancia do Web Driver
            WebDriver driver = new HtmlUnitDriver(true);

            // Visitar a página das farmacias portuguesas
            driver.get("http://www.infarmed.pt:80/infomed/pesquisa.php");

            WebElement login = driver.findElement(By.id("button_"));

            login.click();

            Thread.sleep(1000);

            WebElement dci = driver.findElement(By.name("dci"));
            ((JavascriptExecutor)driver).executeScript("document.getElementsByName(\"dci\")[0].setAttribute(\"value\", \"" +
                                                       dciInput + "\");", dci);

            Thread.sleep(1000);

            WebElement nome = driver.findElement(By.name("nome_comer"));
            ((JavascriptExecutor)driver).executeScript("document.getElementsByName(\"nome_comer\")[0].setAttribute(\"value\", \"" +
                                                       nomeInput + "\");",
                                                       nome);

            Thread.sleep(1000);

            WebElement dose = driver.findElement(By.name("dosagem"));
            ((JavascriptExecutor)driver).executeScript("document.getElementsByName(\"dosagem\")[0].setAttribute(\"value\", \"" +
                                                       doseInput + "\");",
                                                       dose);

            Thread.sleep(1000);

            WebElement pesquisar = driver.findElement(By.name("Submit_"));
            pesquisar.click();

            Thread.sleep(1000);

            List<WebElement> tableLine =
                driver.findElements(By.className("sub_titulo"));

            boolean flag = false;
            for (int i = 1; i < tableLine.size(); i++) {
                List<WebElement> tdElements =
                    tableLine.get(i).findElements(By.tagName("td"));
                String subs = tdElements.get(0).getText();
                String name = tdElements.get(1).getText();
                String dosage = tdElements.get(3).getText();
                String autorizacao = tdElements.get(5).getText();
                subs = subs.substring(0, subs.length() - 1);
                if (subs.equalsIgnoreCase(dciInput) &&
                    name.equalsIgnoreCase(nomeInput) &&
                    dosage.equalsIgnoreCase(doseInput) &&
                    autorizacao.equals("Autorizado")) {
                    flag = true;
                    tdElements.get(6).findElement(By.tagName("a")).click();
                    break;
                }
            }

            // Detalhes Medicamento
            DetalhesMedicamento detalhesMedicamentos =
                new DetalhesMedicamento();
            
            if (!flag){
                detalhesMedicamentos.setNome("null");
                return detalhesMedicamentos;
            }

            Thread.sleep(1000);

            List<WebElement> tabelaDetalhes =
                driver.findElement(By.className("tabela_detalhes")).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));

            for (WebElement linhaTabela : tabelaDetalhes) {
                List<WebElement> detalhes =
                    linhaTabela.findElements(By.tagName("td"));

                if (detalhes.get(0).getText().equalsIgnoreCase("DCI"))
                    detalhesMedicamentos.setDci(detalhes.get(1).getText());
                else if (detalhes.get(0).getText().equalsIgnoreCase("Nome do Medicamento"))
                    detalhesMedicamentos.setNome(detalhes.get(1).getText());
                else if (detalhes.get(0).getText().equalsIgnoreCase("Dosagem"))
                    detalhesMedicamentos.setDose(detalhes.get(1).getText());
                else if (detalhes.get(0).getText().equalsIgnoreCase("Forma Farmacêutica"))
                    detalhesMedicamentos.setFormaFarmaceutica(detalhes.get(1).getText());
                else if (detalhes.get(0).getText().equalsIgnoreCase("Genérico"))
                    detalhesMedicamentos.setGenerico(detalhes.get(1).getText());
                else if (detalhes.get(0).getText().equalsIgnoreCase("Titular"))
                    detalhesMedicamentos.setTitular(detalhes.get(1).getText());
                else if (detalhes.get(0).getText().equalsIgnoreCase("Data de Autorização"))
                    detalhesMedicamentos.setDataAutorizacao(detalhes.get(1).getText());
                else if (detalhes.get(0).getText().equalsIgnoreCase("Estado de Autorização"))
                    detalhesMedicamentos.setEstadoAutorizacao(detalhes.get(1).getText());
                else if (detalhes.get(0).getText().equalsIgnoreCase("Classificação Quanto à Dispensa"))
                    detalhesMedicamentos.setClassificacaoDispensa(detalhes.get(1).getText());
                else if (detalhes.get(0).getText().equalsIgnoreCase("Classificação Estupefaciente"))
                    detalhesMedicamentos.setClassificacaoEstupefaciente(detalhes.get(1).getText());
                else if (detalhes.get(0).getText().equalsIgnoreCase("Anatomical Therapeutical Chemical (ATC) classification(s)"))
                    detalhesMedicamentos.setAnatomicalClassification(detalhes.get(1).getText());
                else if (detalhes.get(0).getText().equalsIgnoreCase("Classificação Farmacoterapêutica"))
                    detalhesMedicamentos.setClassificacaoFarmacoterapeutica(detalhes.get(1).getText());
                else if (detalhes.get(0).getText().equalsIgnoreCase("Via(s) de Administração"))
                    detalhesMedicamentos.setViaAdministracao(detalhes.get(1).getText());
                else if (detalhes.get(0).getText().equalsIgnoreCase("Grupo de Produto"))
                    detalhesMedicamentos.setGrupoProduto(detalhes.get(1).getText());
                else if (detalhes.get(0).getText().equalsIgnoreCase("Número de Processo"))
                    detalhesMedicamentos.setNumeroProcesso(detalhes.get(1).getText());
                else if (detalhes.get(0).getText().equalsIgnoreCase("Margem terapêutica estreita"))
                    detalhesMedicamentos.setMargemTerapeutica(detalhes.get(1).getText());
            }

            return detalhesMedicamentos;
        }

        catch (Exception e) {
            System.out.println(e.getCause());
            System.out.println(e.getLocalizedMessage());
        }
        
        return null;
    }
}
