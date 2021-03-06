<?xml version="1.0" encoding="UTF-8" ?>
<?oracle-xsl-mapper
  <!-- SPECIFICATION OF MAP SOURCES AND TARGETS, DO NOT MODIFY. -->
  <mapSources>
    <source type="WSDL">
      <schema location="../MedicineStockMedicineIDDBAdapter.wsdl"/>
      <rootElement name="MedicamentosstockCollection" namespace="http://xmlns.oracle.com/pcbpel/adapter/db/top/MedicineStockMedicineIDDBAdapter"/>
    </source>
  </mapSources>
  <mapTargets>
    <target type="WSDL">
      <schema location="../ReexecuteTriageBPELProcess.wsdl"/>
      <rootElement name="medicinesCollectionWithID" namespace="http://saude365.pt"/>
    </target>
  </mapTargets>
  <!-- GENERATED BY ORACLE XSL MAPPER 11.1.1.6.0(build 111214.0600.1553) AT [FRI APR 26 11:46:50 WEST 2013]. -->
?>
<xsl:stylesheet version="1.0"
                xmlns:xp20="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.Xpath20"
                xmlns:bpws="http://schemas.xmlsoap.org/ws/2003/03/business-process/"
                xmlns:bpel="http://docs.oasis-open.org/wsbpel/2.0/process/executable"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xmlns:bpm="http://xmlns.oracle.com/bpmn20/extensions"
                xmlns:tns="http://xmlns.oracle.com/pcbpel/adapter/db/SeiLessons/HSN-Project/MedicineStockMedicineIDDBAdapter"
                xmlns:top="http://xmlns.oracle.com/pcbpel/adapter/db/top/MedicineStockMedicineIDDBAdapter"
                xmlns:plt="http://schemas.xmlsoap.org/ws/2003/05/partner-link/"
                xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"
                xmlns:ora="http://schemas.oracle.com/xpath/extension"
                xmlns:socket="http://www.oracle.com/XSL/Transform/java/oracle.tip.adapter.socket.ProtocolTranslator"
                xmlns:ns1="http://xmlns.oracle.com/pcbpel/adapter/db/SeiLessons/HSN-Project/PatientTriageDBAdapter"
                xmlns:mhdr="http://www.oracle.com/XSL/Transform/java/oracle.tip.mediator.service.common.functions.MediatorExtnFunction"
                xmlns:oraext="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.ExtFunc"
                xmlns:dvm="http://www.oracle.com/XSL/Transform/java/oracle.tip.dvm.LookupValue"
                xmlns:hwf="http://xmlns.oracle.com/bpel/workflow/xpath"
                xmlns:med="http://schemas.oracle.com/mediator/xpath"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:ids="http://xmlns.oracle.com/bpel/services/IdentityService/xpath"
                xmlns:xdk="http://schemas.oracle.com/bpel/extension/xpath/function/xdk"
                xmlns:xref="http://www.oracle.com/XSL/Transform/java/oracle.tip.xref.xpath.XRefXPathFunctions"
                xmlns:xsd="http://www.w3.org/2001/XMLSchema"
                xmlns:client="http://xmlns.oracle.com/SeiLessons/HSN_Project/ReexecuteTriageBPELProcess"
                xmlns:bpmn="http://schemas.oracle.com/bpm/xpath"
                xmlns:ns2="http://saude365.pt"
                xmlns:ldap="http://schemas.oracle.com/xpath/extension/ldap"
                exclude-result-prefixes="xsi xsl tns top plt wsdl xsd ns1 client ns2 xp20 bpws bpel bpm ora socket mhdr oraext dvm hwf med ids xdk xref bpmn ldap">
  <xsl:template match="/">
    <ns2:medicinesCollectionWithID>
      <ns2:medicinesCollectionWithIDType>
        <ns2:id>
          <xsl:value-of select="/top:MedicamentosstockCollection/top:Medicamentosstock/top:medicamentoid"/>
        </ns2:id>
        <ns2:substance>
          <xsl:value-of select="/top:MedicamentosstockCollection/top:Medicamentosstock/top:substancia"/>
        </ns2:substance>
        <ns2:name>
          <xsl:value-of select="/top:MedicamentosstockCollection/top:Medicamentosstock/top:nome"/>
        </ns2:name>
        <ns2:dosage>
          <xsl:value-of select="/top:MedicamentosstockCollection/top:Medicamentosstock/top:dose"/>
        </ns2:dosage>
      </ns2:medicinesCollectionWithIDType>
    </ns2:medicinesCollectionWithID>
  </xsl:template>
</xsl:stylesheet>
