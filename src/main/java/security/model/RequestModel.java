/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Size;

/** 
 * @author Martijn
 */

@Entity
@Table(name = "VacationRequests")
public class RequestModel implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idRequest")
    private Long idRequest;
    
    @Size(min = 4, message = "The reason needs to be at least 4 characters long")
    @Column(name = "reason")
    private String reason;
    
    @Column(name = "startDate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date startDate;
    
    @Column(name = "endDate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date endDate;
    
    @ManyToOne
    @JoinColumn(name = "idUser")
    private LoginModel requestor;
    
    @Transient
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    
    public RequestModel() {
        // Empty Constructor
    }
    
    public RequestModel(String reason, Date fromDate, Date tillDate) {
        this.reason = reason;
        this.startDate = fromDate;
        this.endDate = tillDate;
    }
    
    public LoginModel getRequestor() {
        return requestor;
    }

    public void setRequestor(LoginModel requestor) {
        this.requestor = requestor;
    }
    
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) throws ParseException {
        this.startDate = formatter.parse(startDate);
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) throws ParseException {        
        this.endDate = formatter.parse(endDate);
    }
    
}
