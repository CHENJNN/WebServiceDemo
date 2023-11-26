//
// 此檔案是由 JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 所產生 
// 請參閱 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 一旦重新編譯來源綱要, 對此檔案所做的任何修改都將會遺失. 
// 產生時間: 2023.11.26 於 09:13:36 PM CST 
//


package com.example.pen;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.pen package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.pen
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetPenResponse }
     * 
     */
    public GetPenResponse createGetPenResponse() {
        return new GetPenResponse();
    }

    /**
     * Create an instance of {@link Pen }
     * 
     */
    public Pen createPen() {
        return new Pen();
    }

    /**
     * Create an instance of {@link GetPenRequest }
     * 
     */
    public GetPenRequest createGetPenRequest() {
        return new GetPenRequest();
    }

}
