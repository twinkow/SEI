package pt.saude365;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


@WebService(portName = "ValidateAddressCTTSoap12HttpPort")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class ValidateAddressCTT {
    public ValidateAddressCTT() {
        super();
    }

    @WebMethod
    public String validateAddressCTT(@WebParam(name = "postCode")
        String postcode, @WebParam(name = "street")
        String street, @WebParam(name = "number")
        String numb, @WebParam(name = "floor")
        String floor, @WebParam(name = "apartment")
        String apartment) {

        try {
            String[] split = street.split(" ", 2);
            String codpostal =
                URLEncoder.encode("incodpos", "UTF-8") + "=" + URLEncoder.encode(postcode,
                                                                                 "UTF-8");

            // Send data
            URL url = new URL("http://www.ctt.pt/pdcp/xml_pdcp?");
            URLConnection conn = url.openConnection();

            // use post mode
            conn.setDoOutput(true);
            conn.setAllowUserInteraction(false);

            OutputStreamWriter wr =
                new OutputStreamWriter(conn.getOutputStream());
            wr.write(codpostal);
            wr.flush();

            String content = conn.getContentType();

            // get result
            BufferedReader br =
                new BufferedReader(new InputStreamReader(conn.getInputStream(),
                                                         content.substring(content.indexOf("=") +
                                                                           1)));

            String result = null;
            String resultXML = "";
            while ((result = br.readLine()) != null) {
                resultXML += result;
            }
            br.close();
            wr.close();
            
            if(!resultXML.contains("OK"))
                return "0$";
            
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(resultXML));
            Document doc = db.parse(is);

            String distrito =
                doc.getElementsByTagName("Distrito").item(0).getTextContent();
            String concelho =
                doc.getElementsByTagName("Concelho").item(0).getTextContent();
            NodeList tipoList = doc.getElementsByTagName("Tipo");
            NodeList nomeList = doc.getElementsByTagName("Nome");
            for (int i = 0;
                 i < tipoList.getLength() && i < nomeList.getLength(); i++) {
                if (tipoList.item(i).getTextContent().equals(split[0]) &&
                    nomeList.item(i).getTextContent().equals(split[1])) {
                    String freguesia =
                        doc.getElementsByTagName("Freguesia").item(i +
                                                                   1).getTextContent();
                    String ret =
                        1 + "$" + distrito + "$" + concelho + "$" +
                        freguesia;
                    System.out.println("MORADA SUPER FOUND!");
                    return ret;
                }
            }
            
            NodeList nodeCodPosList = doc.getElementsByTagName("CodPos");
            NodeList nodeRuaList =  doc.getElementsByTagName("Rua");
            
            for(int i=0; i < nodeRuaList.getLength(); i++){
                Node node = nodeCodPosList.item(i).getParentNode();
                node.removeChild(nodeCodPosList.item(i));
            }
            
            NodeList nodeList = doc.getElementsByTagName("Designacao");
            for (int i = 0; i < nodeList.getLength(); i++) {
                String node = nodeList.item(i).getTextContent();
                if (node.contains(street)) {
                    String freguesia =
                        doc.getElementsByTagName("Freguesia").item(i).getTextContent();
                    String ret =
                        1 + "$" + distrito + "$" + concelho + "$" +
                        freguesia;
                    System.out.println("MORADA FOUND!");
                    return ret;
                }
            }

            System.out.println("MORADA NOT FOUND");
            return "0$";

        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ParserConfigurationException e) {
            System.out.println(e.getMessage());
        } catch (SAXException e) {
            System.out.println(e.getMessage());
        }

        return "0$";
    }

}
