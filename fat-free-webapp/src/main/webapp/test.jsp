<?xml version="1.0" encoding="utf-8" ?>
<f:view xmlns:h="http://java.sun.com/jsf/html" xmlns:f="http://java.sun.com/jsf/core"
    xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">

    <ice:outputDeclaration doctypeRoot="HTML" doctypePublic="-//W3C//DTD HTML 4.01 Transitional//EN"
        doctypeSystem="http://www.w3.org/TR/html4/loose.dtd" />
    <html>
    <head>
    <title>Simple ICEFaces Test</title>
    <ice:outputStyle href="./xmlhttp/css/rime/rime.css" />
    </head>
    <body>
    <ice:outputText>Just testing ICEFaces Configurtation:</ice:outputText>
    <br />
    <ice:outputLabel for="" value="#{testCtrl.label}"></ice:outputLabel>

    </body>
    </html>
</f:view>
