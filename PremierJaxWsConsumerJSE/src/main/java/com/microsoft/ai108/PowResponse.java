
package com.microsoft.ai108;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour powResponse complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="powResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="powResult" type="{http://www.w3.org/2001/XMLSchema}double" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "powResponse", propOrder = {
    "powResult"
})
public class PowResponse {

    @XmlElement(namespace = "http://ai108.microsoft.com")
    protected double powResult;

    /**
     * Obtient la valeur de la propriété powResult.
     * 
     */
    public double getPowResult() {
        return powResult;
    }

    /**
     * Définit la valeur de la propriété powResult.
     * 
     */
    public void setPowResult(double value) {
        this.powResult = value;
    }

}
