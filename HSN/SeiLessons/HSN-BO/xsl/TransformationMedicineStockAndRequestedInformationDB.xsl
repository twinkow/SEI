<?xml version="1.0" encoding="UTF-8" ?>
<?oracle-xsl-mapper
  <!-- SPECIFICATION OF MAP SOURCES AND TARGETS, DO NOT MODIFY. -->
  <mapSources>
    <source type="WSDL">
      <schema location="../MedicinesStockManagementBPELProcess.wsdl"/>
      <rootElement name="process" namespace="http://xmlns.oracle.com/SeiLessons/HSN_BO/MedicinesStockManagementBPELProcess"/>
    </source>
  </mapSources>
  <mapTargets>
    <target type="WSDL">
      <schema location="../GetMedicineStockAndRequestedInformationDBAdapter.wsdl"/>
      <rootElement name="GetMedicineStockAndRequestedInformationDBAdapterInput" namespace="http://xmlns.oracle.com/pcbpel/adapter/db/GetMedicineStockAndRequestedInformationDBAdapter"/>
    </target>
  </mapTargets>
  <!-- GENERATED BY ORACLE XSL MAPPER 11.1.1.6.0(build 111214.0600.1553) AT [TUE MAY 07 14:52:38 PDT 2013]. -->
?>
<xsl:stylesheet version="1.0"
                xmlns:bpws="http://schemas.xmlsoap.org/ws/2003/03/business-process/"
                xmlns:xp20="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.Xpath20"
                xmlns:client="http://xmlns.oracle.com/SeiLessons/HSN_BO/MedicinesStockManagementBPELProcess"
                xmlns:mhdr="http://www.oracle.com/XSL/Transform/java/oracle.tip.mediator.service.common.functions.MediatorExtnFunction"
                xmlns:bpel="http://docs.oasis-open.org/wsbpel/2.0/process/executable"
                xmlns:oraext="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.ExtFunc"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xmlns:dvm="http://www.oracle.com/XSL/Transform/java/oracle.tip.dvm.LookupValue"
                xmlns:hwf="http://xmlns.oracle.com/bpel/workflow/xpath"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:med="http://schemas.oracle.com/mediator/xpath"
                xmlns:ids="http://xmlns.oracle.com/bpel/services/IdentityService/xpath"
                xmlns:bpm="http://xmlns.oracle.com/bpmn20/extensions"
                xmlns:xdk="http://schemas.oracle.com/bpel/extension/xpath/function/xdk"
                xmlns:xref="http://www.oracle.com/XSL/Transform/java/oracle.tip.xref.xpath.XRefXPathFunctions"
                xmlns:plnk="http://schemas.xmlsoap.org/ws/2003/05/partner-link/"
                xmlns:xsd="http://www.w3.org/2001/XMLSchema"
                xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"
                xmlns:bpmn="http://schemas.oracle.com/bpm/xpath"
                xmlns:ora="http://schemas.oracle.com/xpath/extension"
                xmlns:tns="http://xmlns.oracle.com/pcbpel/adapter/db/SeiLessons/HSN-BO/GetMedicineStockAndRequestedInformationDBAdapter"
                xmlns:socket="http://www.oracle.com/XSL/Transform/java/oracle.tip.adapter.socket.ProtocolTranslator"
                xmlns:db="http://xmlns.oracle.com/pcbpel/adapter/db/GetMedicineStockAndRequestedInformationDBAdapter"
                xmlns:ldap="http://schemas.oracle.com/xpath/extension/ldap"
                exclude-result-prefixes="xsi xsl client plnk xsd wsdl tns db bpws xp20 mhdr bpel oraext dvm hwf med ids bpm xdk xref bpmn ora socket ldap">
  <xsl:template match="/">
    <db:GetMedicineStockAndRequestedInformationDBAdapterInput>
      <db:doenteid>
        <xsl:value-of select="/client:process/client:patientID"/>
      </db:doenteid>
      <db:triagemid>
        <xsl:value-of select="/client:process/client:triageID"/>
      </db:triagemid>
    </db:GetMedicineStockAndRequestedInformationDBAdapterInput>
  </xsl:template>
</xsl:stylesheet>
