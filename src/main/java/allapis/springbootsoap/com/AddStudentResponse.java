//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.05.13 at 11:24:15 AM GMT+01:00 
//


package allapis.springbootsoap.com;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="serviceStatusStudent" type="{http://com.springbootsoap.allapis}serviceStatusStudent"/>
 *         &lt;element name="studentInfo" type="{http://com.springbootsoap.allapis}studentInfo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "serviceStatusStudent",
    "studentInfo"
})
@XmlRootElement(name = "addStudentResponse")
public class AddStudentResponse {

    @XmlElement(required = true)
    protected ServiceStatusStudent serviceStatusStudent;
    @XmlElement(required = true)
    protected StudentInfo studentInfo;

    /**
     * Gets the value of the serviceStatusStudent property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceStatusStudent }
     *     
     */
    public ServiceStatusStudent getServiceStatusStudent() {
        return serviceStatusStudent;
    }

    /**
     * Sets the value of the serviceStatusStudent property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceStatusStudent }
     *     
     */
    public void setServiceStatusStudent(ServiceStatusStudent value) {
        this.serviceStatusStudent = value;
    }

    /**
     * Gets the value of the studentInfo property.
     * 
     * @return
     *     possible object is
     *     {@link StudentInfo }
     *     
     */
    public StudentInfo getStudentInfo() {
        return studentInfo;
    }

    /**
     * Sets the value of the studentInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link StudentInfo }
     *     
     */
    public void setStudentInfo(StudentInfo value) {
        this.studentInfo = value;
    }

}
