package com.love2code.springdemo.utils;

import org.dom4j.Document;
import org.dom4j.io.DOMReader;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

public class XmlUtils {

    private static final DocumentBuilderFactory DOCUMENT_BUILDER_FACTORY;

    static {
        DOCUMENT_BUILDER_FACTORY = DocumentBuilderFactory.newInstance();
        DOCUMENT_BUILDER_FACTORY.setValidating(false);
    }

    public static Document parseXml(String xml) {
        try {
            return new DOMReader().read(builder().parse(new InputSource(new StringReader(xml))));
        } catch (SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized DocumentBuilder builder() {
        try {
            return DOCUMENT_BUILDER_FACTORY.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }
}
