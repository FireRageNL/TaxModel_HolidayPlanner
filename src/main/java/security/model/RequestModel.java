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
    
    @Column(name = "idUser")
    private Long idUser;
    
    @Size(min = 4, message = "The reason needs to be at least 4 characters long")
    @Column(name = "reason")
    private String reason;
    
    @Column(name = "startDate", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date startDate;
    
    @Column(name = "endDate", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date endDate;
    
    SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
    
    public RequestModel() {
        // Empty Constructor
    }
    
    public RequestModel(Long idUser, String reason, Date fromDate, Date tillDate) {
        this.idUser = idUser;
        this.reason = reason;
        this.startDate = fromDate;
        this.endDate = tillDate;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
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
