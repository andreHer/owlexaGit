
package com.ametis.cms.datamodel;


import java.sql.*;
import java.util.*;
import javax.persistence.*;
import org.hibernate.annotations.Generated;


@Entity
@Table(name="member_group_provider_diagnosis")
public class MemberGroupProviderDiagnosis implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

	//Fields
		
	/**data for the column :
	
 --------- member_group_provider_diagnosis.member_group_provider_diagnosis_id --------- 
 schema        = null
 tableName     = member_group_provider_diagnosis
 foreignCol    = 
 foreignTab    = 
 catalog       = mp-new
 remarks       = auto_increment
 defaultValue  = null
 decDigits     = 0
 radix         = 10
 nullable      = 0
 ordinal       = 1
 size          = 15
 type          = 4 
 isPrimaryKey  = true

=========================================


*/
	private Integer memberGroupProviderDiagnosisId;
									
	/**data for the column :
	
 --------- member_group_provider_diagnosis.exclusion_status --------- 
 schema        = null
 tableName     = member_group_provider_diagnosis
 foreignCol    = 
 foreignTab    = 
 catalog       = mp-new
 remarks       = 
 defaultValue  = null
 decDigits     = 0
 radix         = 10
 nullable      = 1
 ordinal       = 4
 size          = 2
 type          = 4 
 isPrimaryKey  = false

=========================================


*/
	private Integer exclusionStatus;
			
	/**data for the column :
	
 --------- member_group_provider_diagnosis.created_time --------- 
 schema        = null
 tableName     = member_group_provider_diagnosis
 foreignCol    = 
 foreignTab    = 
 catalog       = mp-new
 remarks       = on update CURRENT_TIMESTAMP
 defaultValue  = CURRENT_TIMESTAMP
 decDigits     = 0
 radix         = 10
 nullable      = 0
 ordinal       = 5
 size          = 19
 type          = 93 
 isPrimaryKey  = false

=========================================


*/
	private java.sql.Timestamp createdTime;
			
	/**data for the column :
	
 --------- member_group_provider_diagnosis.created_by --------- 
 schema        = null
 tableName     = member_group_provider_diagnosis
 foreignCol    = 
 foreignTab    = 
 catalog       = mp-new
 remarks       = 
 defaultValue  = null
 decDigits     = 0
 radix         = 10
 nullable      = 1
 ordinal       = 6
 size          = 50
 type          = 12 
 isPrimaryKey  = false

=========================================


*/
	private String createdBy;
			
	/**data for the column :
	
 --------- member_group_provider_diagnosis.modified_time --------- 
 schema        = null
 tableName     = member_group_provider_diagnosis
 foreignCol    = 
 foreignTab    = 
 catalog       = mp-new
 remarks       = 
 defaultValue  = 0000-00-00 00:00:00
 decDigits     = 0
 radix         = 10
 nullable      = 0
 ordinal       = 7
 size          = 19
 type          = 93 
 isPrimaryKey  = false

=========================================


*/
	private java.sql.Timestamp modifiedTime;
			
	/**data for the column :
	
 --------- member_group_provider_diagnosis.modified_by --------- 
 schema        = null
 tableName     = member_group_provider_diagnosis
 foreignCol    = 
 foreignTab    = 
 catalog       = mp-new
 remarks       = 
 defaultValue  = null
 decDigits     = 0
 radix         = 10
 nullable      = 1
 ordinal       = 8
 size          = 50
 type          = 12 
 isPrimaryKey  = false

=========================================


*/
	private String modifiedBy;
			
	/**data for the column :
	
 --------- member_group_provider_diagnosis.deleted_time --------- 
 schema        = null
 tableName     = member_group_provider_diagnosis
 foreignCol    = 
 foreignTab    = 
 catalog       = mp-new
 remarks       = 
 defaultValue  = 0000-00-00 00:00:00
 decDigits     = 0
 radix         = 10
 nullable      = 0
 ordinal       = 9
 size          = 19
 type          = 93 
 isPrimaryKey  = false

=========================================


*/
	private java.sql.Timestamp deletedTime;
			
	/**data for the column :
	
 --------- member_group_provider_diagnosis.deleted_by --------- 
 schema        = null
 tableName     = member_group_provider_diagnosis
 foreignCol    = 
 foreignTab    = 
 catalog       = mp-new
 remarks       = 
 defaultValue  = null
 decDigits     = 0
 radix         = 10
 nullable      = 1
 ordinal       = 10
 size          = 50
 type          = 12 
 isPrimaryKey  = false

=========================================


*/
	private String deletedBy;
			
	/**data for the column :
	
 --------- member_group_provider_diagnosis.deleted_status --------- 
 schema        = null
 tableName     = member_group_provider_diagnosis
 foreignCol    = 
 foreignTab    = 
 catalog       = mp-new
 remarks       = 
 defaultValue  = null
 decDigits     = 0
 radix         = 10
 nullable      = 1
 ordinal       = 11
 size          = 2
 type          = 4 
 isPrimaryKey  = false

=========================================


*/
	private Integer deletedStatus;
		
	// foreign affairs
	
			/** Diagnosis
	data for the foreign class :
	
 --------- diagnosis.diagnosis_id --------- 
 schema        = null
 tableName     = diagnosis
 foreignCol    = diagnosis_id
 foreignTab    = member_group_provider_diagnosis
 catalog       = mp-new
 remarks       = auto_increment
 defaultValue  = null
 decDigits     = 0
 radix         = 10
 nullable      = 0
 ordinal       = 1
 size          = 11
 type          = 4 
 isPrimaryKey  = true

=========================================



	 */
	private Diagnosis diagnosisId;
				/** MemberGroupProvider
	data for the foreign class :
	
 --------- member_group_provider.member_group_provider_id --------- 
 schema        = null
 tableName     = member_group_provider
 foreignCol    = member_group_provider_id
 foreignTab    = member_group_provider_diagnosis
 catalog       = mp-new
 remarks       = auto_increment
 defaultValue  = null
 decDigits     = 0
 radix         = 10
 nullable      = 0
 ordinal       = 1
 size          = 11
 type          = 4 
 isPrimaryKey  = true

=========================================



	 */
	private MemberGroupProvider memberGroupProviderId;
			
	// -- foreign affairs end

	// -- exported key

	
		
	// -- exported key end

	// Fields End


	// PK GETTER SETTER
			@Id
	@Column(name="member_group_provider_diagnosis_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public java.lang.Integer getMemberGroupProviderDiagnosisId(){
		return memberGroupProviderDiagnosisId;
	}
	public void setMemberGroupProviderDiagnosisId(java.lang.Integer value){
		memberGroupProviderDiagnosisId = value;
	}
			// PK GETTER SETTER END

												@Column(name="exclusion_status")
	public java.lang.Integer getExclusionStatus(){
		return exclusionStatus;
	}
	public void setExclusionStatus(java.lang.Integer value){
		exclusionStatus = value;
	}
				@Column(name="created_time")
	public java.sql.Timestamp getCreatedTime(){
		return createdTime;
	}
	public void setCreatedTime(java.sql.Timestamp value){
		createdTime = value;
	}
				@Column(name="created_by")
	public java.lang.String getCreatedBy(){
		return createdBy;
	}
	public void setCreatedBy(java.lang.String value){
		createdBy = value;
	}
				@Column(name="modified_time")
	public java.sql.Timestamp getModifiedTime(){
		return modifiedTime;
	}
	public void setModifiedTime(java.sql.Timestamp value){
		modifiedTime = value;
	}
				@Column(name="modified_by")
	public java.lang.String getModifiedBy(){
		return modifiedBy;
	}
	public void setModifiedBy(java.lang.String value){
		modifiedBy = value;
	}
				@Column(name="deleted_time")
	public java.sql.Timestamp getDeletedTime(){
		return deletedTime;
	}
	public void setDeletedTime(java.sql.Timestamp value){
		deletedTime = value;
	}
				@Column(name="deleted_by")
	public java.lang.String getDeletedBy(){
		return deletedBy;
	}
	public void setDeletedBy(java.lang.String value){
		deletedBy = value;
	}
				@Column(name="deleted_status")
	public java.lang.Integer getDeletedStatus(){
		return deletedStatus;
	}
	public void setDeletedStatus(java.lang.Integer value){
		deletedStatus = value;
	}
		
	// foreign affairs
	
			/** Diagnosis */
	@ManyToOne
	@JoinColumn(name="diagnosis_id")
	public Diagnosis getDiagnosisId(){
		return this.diagnosisId;
	}

	/** Diagnosis */
	public void setDiagnosisId(Diagnosis obj){
		this.diagnosisId = obj;
	}
				/** MemberGroupProvider */
	@ManyToOne
	@JoinColumn(name="member_group_provider_id")
	public MemberGroupProvider getMemberGroupProviderId(){
		return this.memberGroupProviderId;
	}

	/** MemberGroupProvider */
	public void setMemberGroupProviderId(MemberGroupProvider obj){
		this.memberGroupProviderId = obj;
	}
			
	// foreign affairs end

// exported key

	
		
	//exported key end



}