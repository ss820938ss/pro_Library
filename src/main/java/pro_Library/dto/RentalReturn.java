package pro_Library.dto;

import java.util.Date;

public class RentalReturn {
	private int pNo;
	private int bNo;
	private java.sql.Date brDate;
	private java.sql.Date bReturn;
	private java.sql.Date bOverdue;
	
	public RentalReturn(int pNo2, int bNo2, Date brDate2, Date bReturn2, Date bOverdue2) {}

	public RentalReturn(int pNo, int bNo, java.sql.Date brDate, java.sql.Date bReturn, java.sql.Date bOverdue) {
		this.pNo = pNo;
		this.bNo = bNo;
		this.brDate = brDate;
		this.bReturn = bReturn;
		this.bOverdue = bOverdue;
	}

	public RentalReturn(int i) {
		// TODO Auto-generated constructor stub
	}

	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public java.sql.Date getBrDate() {
		return brDate;
	}

	public void setBrDate(java.sql.Date brDate) {
		this.brDate = brDate;
	}

	public java.sql.Date getbReturn() {
		return bReturn;
	}

	public void setbReturn(java.sql.Date bReturn) {
		this.bReturn = bReturn;
	}

	public java.sql.Date getbOverdue() {
		return bOverdue;
	}

	public void setbOverdue(java.sql.Date bOverdue) {
		this.bOverdue = bOverdue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bNo;
		result = prime * result + ((bOverdue == null) ? 0 : bOverdue.hashCode());
		result = prime * result + ((bReturn == null) ? 0 : bReturn.hashCode());
		result = prime * result + ((brDate == null) ? 0 : brDate.hashCode());
		result = prime * result + pNo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RentalReturn other = (RentalReturn) obj;
		if (bNo != other.bNo)
			return false;
		if (bOverdue == null) {
			if (other.bOverdue != null)
				return false;
		} else if (!bOverdue.equals(other.bOverdue))
			return false;
		if (bReturn == null) {
			if (other.bReturn != null)
				return false;
		} else if (!bReturn.equals(other.bReturn))
			return false;
		if (brDate == null) {
			if (other.brDate != null)
				return false;
		} else if (!brDate.equals(other.brDate))
			return false;
		if (pNo != other.pNo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("RENTAL_RETURN [pNo=%s, bNo=%s, brDate=%s, bReturn=%s, bOverdue=%s", 
							  pNo, bNo, brDate, bReturn, bOverdue);

	}
	
	

}
