package com.csc.data.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PHONE_NUMBER")
public class PhoneNumber {

	@EmbeddedId
	private PhoneNumberPK pk;
	
	@Column(name="PHONE_TYPE")
	private String phoneType;
	
	@ManyToOne
	@JoinColumn(name="contact_id")
	private SmsContact smsContact;

	public PhoneNumberPK getPk() {
		return pk;
	}

	public void setPk(PhoneNumberPK pk) {
		this.pk = pk;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public SmsContact getSmsContact() {
		return smsContact;
	}

	public void setSmsContact(SmsContact smsContact) {
		this.smsContact = smsContact;
	}
	
	
}
