package com.stackroute.keepnote.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
 * The class "Reminder" will be acting as the data model for the Reminder Table in the database. 
 * Please note that this class is annotated with @Entity annotation. 
 * Hibernate will scan all package for any Java objects annotated with the @Entity annotation. 
 * If it finds any, then it will begin the process of looking through that particular 
 * Java object to recreate it as a table in your database.
 */
@Entity
public class Reminder {
	/*
	 * This class should have seven fields
	 * (reminderId,reminderName,reminderDescription,reminderType,
	 * reminderCreatedBy,reminderCreationDate,notes). Out of these seven fields, the
	 * field reminderId should be primary key and auto-generated. This class should
	 * also contain the getters and setters for the fields along with the no-arg ,
	 * parameterized constructor and toString method. The value of
	 * reminderCreationDate should not be accepted from the user but should be
	 * always initialized with the system date. annotate notes field with @OneToMany
	 * and @JsonIgnore
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int reminderId;

	public List<Note> getNotes() {
		return notes;
	}

	private String reminderName;
	private String reminderDescription;
	private String reminderType;
	private String reminderCreatedBy;
	private Date reminderCreationDate; 
	
	@OneToMany
	@JsonIgnore
	private List<Note> notes;
	

	public Reminder(int reminderId, String reminderName, String reminderDescription, String reminderType,
			String reminderCreatedBy,List<Note> notesDate ,Date reminderCreationDate) {
		super();
		this.reminderId = reminderId;
		this.reminderName = reminderName;
		this.reminderDescription = reminderDescription;
		this.reminderType = reminderType;
		this.reminderCreatedBy = reminderCreatedBy;
		this.reminderCreationDate = reminderCreationDate;
		this.notes = notes;
	}


	public Reminder() {

	}


	/**
	 * @return the reminderId
	 */
	public int getReminderId() {
		return reminderId;
	}


	/**
	 * @param reminderId the reminderId to set
	 */
	public void setReminderId(int reminderId) {
		this.reminderId = reminderId;
	}


	/**
	 * @return the reminderName
	 */
	public String getReminderName() {
		return reminderName;
	}


	/**
	 * @param reminderName the reminderName to set
	 */
	public void setReminderName(String reminderName) {
		this.reminderName = reminderName;
	}


	/**
	 * @return the reminderDescription
	 */
	public String getReminderDescription() {
		return reminderDescription;
	}


	/**
	 * @param reminderDescription the reminderDescription to set
	 */
	public void setReminderDescription(String reminderDescription) {
		this.reminderDescription = reminderDescription;
	}


	/**
	 * @return the reminderType
	 */
	public String getReminderType() {
		return reminderType;
	}


	/**
	 * @param reminderType the reminderType to set
	 */
	public void setReminderType(String reminderType) {
		this.reminderType = reminderType;
	}


	/**
	 * @return the reminderCreatedBy
	 */
	public String getReminderCreatedBy() {
		return reminderCreatedBy;
	}


	/**
	 * @param reminderCreatedBy the reminderCreatedBy to set
	 */
	public void setReminderCreatedBy(String reminderCreatedBy) {
		this.reminderCreatedBy = reminderCreatedBy;
	}


	/**
	 * @return the reminderCreationDate
	 */
	public Date getReminderCreationDate() {
		return reminderCreationDate;
	}


	/**
	 * @param reminderCreationDate the reminderCreationDate to set
	 */
	public void setReminderCreationDate(Date reminderCreationDate) {
		this.reminderCreationDate = reminderCreationDate;
	}


	/**
	 * @param notes the notes to set
	 */
	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Reminder [reminderId=" + reminderId + ", reminderName=" + reminderName + ", reminderDescription="
				+ reminderDescription + ", reminderType=" + reminderType + ", reminderCreatedBy=" + reminderCreatedBy
				+ ", reminderCreationDate=" + reminderCreationDate + ", notes=" + notes + "]";
	}

	}
