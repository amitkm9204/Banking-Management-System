package com.BankingManagementSystem.Pojo;

import java.io.Serializable;

public class CustomerDetails implements Serializable
{
	
	private String cname;
	private String cdob;
	private String cemailid;
	private String cpanid;
	private String caadharid;
	private String cvoterid;
	private String caddress;
	private String cphone;
	private String csex;
	private String cfathername;
	private String cmothername;
	private String cguardianname;
	
	
	public CustomerDetails(String cname, String cdob, String cemailid, String cpanid, String caadharid, String cvoterid,
			String caddress, String cphone, String csex, String cfathername, String cmothername, String cguardianname) 
	{
		super();
		this.cname = cname;
		this.cdob = cdob;
		this.cemailid = cemailid;
		this.cpanid = cpanid;
		this.caadharid = caadharid;
		this.cvoterid = cvoterid;
		this.caddress = caddress;
		this.cphone = cphone;
		this.csex = csex;
		this.cfathername = cfathername;
		this.cmothername = cmothername;
		this.cguardianname = cguardianname;
		
	}
		
		public CustomerDetails() {
			//super();
		}

		public String getCname() {
			return cname;
		}

		public void setCname(String cname) {
			this.cname = cname;
		}

		public String getCdob() {
			return cdob;
		}

		public void setCdob(String cdob) {
			this.cdob = cdob;
		}

		public String getCemailid() {
			return cemailid;
		}

		public void setCemailid(String cemailid) {
			this.cemailid = cemailid;
		}

		public String getCpanid() {
			return cpanid;
		}

		public void setCpanid(String cpanid) {
			this.cpanid = cpanid;
		}

		public String getCaadharid() {
			return caadharid;
		}

		public void setCaadharid(String caadharid) {
			this.caadharid = caadharid;
		}

		public String getCvoterid() {
			return cvoterid;
		}

		public void setCvoterid(String cvoterid) {
			this.cvoterid = cvoterid;
		}

		public String getCaddress() {
			return caddress;
		}

		public void setCaddress(String caddress) {
			this.caddress = caddress;
		}

		public String getCphone() {
			return cphone;
		}

		public void setCphone(String cphone) {
			this.cphone = cphone;
		}

		public String getCsex() {
			return csex;
		}

		public void setCsex(String csex) {
			this.csex = csex;
		}

		public String getCfathername() {
			return cfathername;
		}

		public void setCfathername(String cfathername) {
			this.cfathername = cfathername;
		}

		public String getCmothername() {
			return cmothername;
		}

		public void setCmothername(String cmothername) {
			this.cmothername = cmothername;
		}

		public String getCguardianname() {
			return cguardianname;
		}

		public void setCguardianname(String cguardianname) {
			this.cguardianname = cguardianname;
		}
		
		
}

	