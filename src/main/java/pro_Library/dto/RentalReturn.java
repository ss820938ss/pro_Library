package pro_Library.dto;

import java.util.Date;

public class RentalReturn {
	private int pNo;
	private int bNo;
	private Date brDate;
	private Date bReturn;
	private Date bOverdue;
	
	public RentalReturn() {}

	public RentalReturn(int pNo, int bNo, Date brDate, Date bReturn, Date bOverdue) {
		this.pNo = pNo;
		this.bNo = bNo;
		this.brDate = brDate;
		this.bReturn = bReturn;
		this.bOverdue = bOverdue;
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

	public Date getBrDate() {
		return brDate;
	}

	public void setBrDate(Date brDate) {
		this.brDate = brDate;
	}

	public Date getbReturn() {
		return bReturn;
	}

	public void setbReturn(Date bReturn) {
		this.bReturn = bReturn;
	}

	public Date getbOverdue() {
		return bOverdue;
	}

	public void setbOverdue(Date bOverdue) {
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
