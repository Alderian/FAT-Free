<!DOCTYPE html
    PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="ice" uri="http://www.icesoft.com/icefaces"%>
<%@ taglib prefix="comp" uri="http://www.icesoft.com/icefaces/component"%>
<f:view>
    <html>
    <head>
    <title>Simple ICEFaces Test</title>
    <comp:outputStyle href="./xmlhttp/css/rime/rime.css" />
    </head>
    <body>

    <comp:outputConnectionStatus style="float:right;" />

    <comp:outputText>Just testing ICEFaces Configurtation:</comp:outputText>
    <br />
    <comp:outputLabel value="#{testCtrl.label}" />
    <br />
    <comp:outputLabel value="#{testCtrl.value}" />

    <!-- Datagrid -->

    <h:form>
        <br />
        Time: <comp:outputText value="#{timebean.now}" />
        <br />
        Refresh Count: <comp:outputText value="#{timebean.refreshCount}" />
        <br />
        <comp:commandLink value="Click here to increment refresh value"
            action="#{timebean.refresh}" />
    </h:form>

    </body>
    </html>
</f:view>
