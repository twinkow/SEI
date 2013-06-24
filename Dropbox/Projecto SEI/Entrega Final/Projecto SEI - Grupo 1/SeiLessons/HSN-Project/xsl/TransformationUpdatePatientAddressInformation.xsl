<?xml version="1.0" encoding="UTF-8" ?>
<?oracle-xsl-mapper
  <!-- SPECIFICATION OF MAP SOURCES AND TARGETS, DO NOT MODIFY. -->
  <mapSources>
    <source type="WSDL">
      <schema location="../ReceivePatientReportFileAdapter.wsdl"/>
      <rootElement name="relatorio" namespace="http://saude365.pt"/>
    </source>
    <source type="WSDL">
      <schema location="../ValidateAddressCTTService.wsdl"/>
      <rootElement name="validateAddressCTTResponse" namespace="http://saude365.pt/"/>
      <param name="validateAddressProcessOutputVariable.payload" />
    </source>
  </mapSources>
  <mapTargets>
    <target type="WSDL">
      <schema location="../UpdatePatientAddressInformationDBAdapter.wsdl"/>
      <rootElement name="DoenteCollection" namespace="http://xmlns.oracle.com/pcbpel/adapter/db/top/UpdatePatientAddressInformationDBAdapter"/>
    </target>
  </mapTargets>
  <!-- GENERATED BY ORACLE XSL MAPPER 11.1.1.6.0(build 111214.0600.1553) AT [MON APR 29 14:19:36 PDT 2013]. -->
?>
<xsl:stylesheet version="1.0" xmlns:top="http://xmlns.oracle.com/pcbpel/adapter/db/top/UpdatePatientAddressInformationDBAdapter"
                xmlns:xp20="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.Xpath20" xmlns:bpws="http://schemas.xmlsoap.org/ws/2003/03/business-process/"
                xmlns:bpel="http://docs.oasis-open.org/wsbpel/2.0/process/executable" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:pc="http://xmlns.oracle.com/pcbpel/"
                xmlns:bpm="http://xmlns.oracle.com/bpmn20/extensions" xmlns:soap12="http://schemas.xmlsoap.org/wsdl/soap12/" xmlns:ns0="http://saude365.pt/"
                xmlns:plt="http://schemas.xmlsoap.org/ws/2003/05/partner-link/" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/"
                xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" xmlns:ora="http://schemas.oracle.com/xpath/extension"
                xmlns:socket="http://www.oracle.com/XSL/Transform/java/oracle.tip.adapter.socket.ProtocolTranslator"
                xmlns:mhdr="http://www.oracle.com/XSL/Transform/java/oracle.tip.mediator.service.common.functions.MediatorExtnFunction"
                xmlns:oraext="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.ExtFunc" xmlns:dvm="http://www.oracle.com/XSL/Transform/java/oracle.tip.dvm.LookupValue"
                xmlns:hwf="http://xmlns.oracle.com/bpel/workflow/xpath" xmlns:tns="http://xmlns.oracle.com/pcbpel/adapter/file/SeiLessons/HSN-Project/ReceivePatientReportFileAdapter"
                xmlns:med="http://schemas.oracle.com/mediator/xpath" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:jca="http://xmlns.oracle.com/pcbpel/wsdl/jca/"
                xmlns:ids="http://xmlns.oracle.com/bpel/services/IdentityService/xpath" xmlns:xdk="http://schemas.oracle.com/bpel/extension/xpath/function/xdk"
                xmlns:xref="http://www.oracle.com/XSL/Transform/java/oracle.tip.xref.xpath.XRefXPathFunctions" xmlns:xsd="http://www.w3.org/2001/XMLSchema"
                xmlns:ns1="http://xmlns.oracle.com/pcbpel/adapter/db/SeiLessons/HSN-Project/UpdatePatientAddressInformationDBAdapter" xmlns:bpmn="http://schemas.oracle.com/bpm/xpath"
                xmlns:imp1="http://saude365.pt" xmlns:ldap="http://schemas.oracle.com/xpath/extension/ldap"
                exclude-result-prefixes="xsi xsl pc soap12 ns0 plt soap mime wsdl tns jca xsd imp1 top ns1 xp20 bpws bpel bpm ora socket mhdr oraext dvm hwf med ids xdk xref bpmn ldap">
  <xsl:param name="validateAddressProcessOutputVariable.payload"/>
  <xsl:template match="/">
    <top:DoenteCollection>
      <top:Doente>
        <top:id>
          <xsl:value-of select="/imp1:relatorio/imp1:doente/imp1:id"/>
        </top:id>
        <top:freguesia>
          <xsl:value-of select='substring-after(substring-after(substring-after($validateAddressProcessOutputVariable.payload/ns0:validateAddressCTTResponse/return,"1$"),"$"),"$")'/>
        </top:freguesia>
        <top:concelho>
          <xsl:value-of select='substring-before(substring-after(substring-after($validateAddressProcessOutputVariable.payload/ns0:validateAddressCTTResponse/return,"1$"),"$"),"$")'/>
        </top:concelho>
        <top:distrito>
          <xsl:value-of select='substring-before(substring-after($validateAddressProcessOutputVariable.payload/ns0:validateAddressCTTResponse/return,"1$"),"$")'/>
        </top:distrito>
      </top:Doente>
    </top:DoenteCollection>
  </xsl:template>
</xsl:stylesheet>
