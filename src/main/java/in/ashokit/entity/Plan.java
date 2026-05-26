
package in.ashokit.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "PLAN_MASTER")
public class Plan {
	
@Id
@GeneratedValue
@Column(name="PLAN_ID")
private Integer planId;
	
@Column(name="PLAN_NAME")
private String planName;
	
@Column(name="PLAN_START_DATE")
private LocalDate planStartDate;
	
@Column(name="PLAN_END_DATE")
private LocalDate planEndDate;
	
@Column(name = "Active_SW")
private String activesw;	

@Column(name = "CREATED_BY") 		               
private String createdBy;

@Column(name = "UPDATED_BY") 		               
private String updatedBy;

@Column(name = "CREATED_DATE" , updatable = false ) 	
@CreationTimestamp
private LocalDate createDate;


@Column(name = "UPDATED_DATE", insertable=false) 
@UpdateTimestamp
private LocalDate updateDate;


public Integer getPlanId() {
	return planId;
}


public void setPlanId(Integer planId) {
	this.planId = planId;
}


public String getPlanName() {
	return planName;
}


public void setPlanName(String planName) {
	this.planName = planName;
}


public LocalDate getPlanStartDate() {
	return planStartDate;
}


public void setPlanStartDate(LocalDate planStartDate) {
	this.planStartDate = planStartDate;
}


public LocalDate getPlanEndDate() {
	return planEndDate;
}


public void setPlanEndDate(LocalDate planEndDate) {
	this.planEndDate = planEndDate;
}


public String getActivesw() {
	return activesw;
}


public void setActivesw(String activesw) {
	this.activesw = activesw;
}


public String getCreatedBy() {
	return createdBy;
}


public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
}


public String getUpdatedBy() {
	return updatedBy;
}


public void setUpdatedBy(String updatedBy) {
	this.updatedBy = updatedBy;
}


public LocalDate getCreateDate() {
	return createDate;
}


public void setCreateDate(LocalDate createDate) {
	this.createDate = createDate;
}


public LocalDate getUpdateDate() {
	return updateDate;
}


public void setUpdateDate(LocalDate updateDate) {
	this.updateDate = updateDate;
}

//
//public boolean getPlanId() {
//	// TODO Auto-generated method stub
//	return false;
//}

	

}
