package org.tonykuo.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Generated 2016/6/23 下午 03:34:34 by Hibernate Tools 4.3.1.Final
 * HanksMasterUserId generated by hbm2java
 * @author tonykuo
 *
 */
@Embeddable
public class HanksMasterUserId  implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private String masterUserId;
    private String msisdn;

    public HanksMasterUserId() {
    }

    public HanksMasterUserId(String masterUserId, String msisdn) {
       this.masterUserId = masterUserId;
       this.msisdn = msisdn;
    }
   

    @Column(name="master_user_id", nullable=false, length=60)
    public String getMasterUserId() {
        return this.masterUserId;
    }
    
    public void setMasterUserId(String masterUserId) {
        this.masterUserId = masterUserId;
    }

    @Column(name="msisdn", nullable=false, length=60)
    public String getMsisdn() {
        return this.msisdn;
    }
    
    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    /**
     * toString
     * @return String
     */
     public String toString() {
	     StringBuffer buffer = new StringBuffer();
         buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
         buffer.append("]");
         return buffer.toString();
     }

}

