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

    <comp:outputConnectionStatus style="float:right; clear:none;" />

    <comp:outputText>Just testing ICEFaces Configuration:</comp:outputText>
    <br />
    <comp:outputLabel value="#{testCtrl.label}" />
    <br />
    <comp:outputLabel value="#{testCtrl.value}" />

    <h:form id="dataTable">

        <comp:dataTable value="#{testCtrl.list}" var="item" id="testList">
            <h:column>
                <f:facet name="header">
                    <comp:outputText value="id #" />
                </f:facet>
                <comp:outputText value="#{item.id}" />
            </h:column>
            <h:column>
                <f:facet name="header">
                    <comp:outputText value="name" />
                </f:facet>
                <comp:outputText value="#{item.name}" />
            </h:column>
        </comp:dataTable>

        <!-- Display counts about the table and the currently displayed page -->
        <comp:dataPaginator id="dataScroll_2" for="testList"
            rowsCountVar="rowsCount" displayedRowsCountVar="displayedRowsCount"
            firstRowIndexVar="firstRowIndex" lastRowIndexVar="lastRowIndex"
            pageCountVar="pageCount" pageIndexVar="pageIndex">
            <comp:outputFormat styleClass="standard"
                value="{0} tests found, displaying {1} test(s), from {2} to {3}. Page {4} / {5}.">
                <f:param value="#{rowsCount}" />
                <f:param value="#{displayedRowsCount}" />
                <f:param value="#{firstRowIndex}" />
                <f:param value="#{lastRowIndex}" />
                <f:param value="#{pageIndex}" />
                <f:param value="#{pageCount}" />
            </comp:outputFormat>
        </comp:dataPaginator>

        <!-- Paginator with page controls -->
        <comp:dataPaginator id="dataScroll_3" for="testList" paginator="true"
            fastStep="3" paginatorMaxPages="4">
            <f:facet name="first">
                <comp:graphicImage
                    url="./xmlhttp/css/xp/css-images/arrow-first.gif"
                    style="border:none;" title="First Page" />
            </f:facet>
            <f:facet name="last">
                <comp:graphicImage
                    url="./xmlhttp/css/xp/css-images/arrow-last.gif"
                    style="border:none;" title="Last Page" />
            </f:facet>
            <f:facet name="previous">
                <comp:graphicImage
                    url="./xmlhttp/css/xp/css-images/arrow-previous.gif"
                    style="border:none;" title="Previous Page" />
            </f:facet>
            <f:facet name="next">
                <comp:graphicImage
                    url="./xmlhttp/css/xp/css-images/arrow-next.gif"
                    style="border:none;" title="Next Page" />
            </f:facet>
            <f:facet name="fastforward">
                <comp:graphicImage
                    url="./xmlhttp/css/xp/css-images/arrow-ff.gif"
                    style="border:none;" title="Fast Forward" />
            </f:facet>
            <f:facet name="fastrewind">
                <comp:graphicImage
                    url="./xmlhttp/css/xp/css-images/arrow-fr.gif"
                    style="border:none;" title="Fast Backwards" />
            </f:facet>
        </comp:dataPaginator>
    </h:form>

    <br />

    <h:form id="timeBean">
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
