
package com.microsoft.ai108;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour serialTestResponse complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="serialTestResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="personResult" type="{http://ai108.microsoft.com}personne" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "serialTestResponse", propOrder = {
    "personResult"
})
public class SerialTestResponse {

    protected Personne personResult;

    /**
     * Obtient la valeur de la propriété personResult.
     * 
     * @return
     *     possible object is
     *     {@link Personne }
     *     
     */
    public Personne getPersonResult() {
        return personResult;
    }

    /**
     * Définit la valeur de la propriété personResult.
     * 
     * @param value
     *     allowed object is
     *     {@link Personne }
     *     
     */
    public void setPersonResult(Personne value) {
        this.personResult = value;
    }

}
