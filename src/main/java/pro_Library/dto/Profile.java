package pro_Library.dto;

import java.util.Date;

public class Profile {
	private int pNo;
	private String pName;
	private Date pBirth;
	private String pPhone;
	private String pCellphone;
	private String pAddress;

	public Profile() {
	}
	
	public Profile(int pNo, String pName, Date pBirth, String pPhone, String pCellphone, String pAddress) {
		this.pNo = pNo;
		this.pName = pName;
		this.pBirth = pBirth;
		this.pPhone = pPhone;
		this.pCellphone = pCellphone;
		this.pAddress = pAddress;
	}

	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public Date getpBirth() {
		return pBirth;
	}

	public void setpBirth(Date pBirth) {
		this.pBirth = pBirth;
	}

	public String getpPhone() {
		return pPhone;
	}

	public void setpPhone(String pPhone) {
		this.pPhone = pPhone;
	}

	public String getpCellphone() {
		return pCellphone;
	}

	public void setpCellphone(String pCellphone) {
		this.pCellphone = pCellphone;
	}

	public String getpAddress() {
		return pAddress;
	}

	public void setpAddress(String pAddress) {
		this.pAddress = pAddress;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pAddress == null) ? 0 : pAddress.hashCode());
		result = prime * result + ((pBirth == null) ? 0 : pBirth.hashCode());
		result = prime * result + ((pCellphone == null) ? 0 : pCellphone.hashCode());
		result = prime * result + ((pName == null) ? 0 : pName.hashCode());
		result = prime * result + pNo;
		result = prime * result + ((pPhone == null) ? 0 : pPhone.hashCode());
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
		Profile other = (Profile) obj;
		if (pAddress == null) {
			if (other.pAddress != null)
				return false;
		} else if (!pAddress.equals(other.pAddress))
			return false;
		if (pBirth == null) {
			if (other.pBirth != null)
				return false;
		} else if (!pBirth.equals(other.pBirth))
			return false;
		if (pCellphone == null) {
			if (other.pCellphone != null)
				return false;
		} else if (!pCellphone.equals(other.pCellphone))
			return false;
		if (pName == null) {
			if (other.pName != null)
				return false;
		} else if (!pName.equals(other.pName))
			return false;
		if (pNo != other.pNo)
			return false;
		if (pPhone == null) {
			if (other.pPhone != null)
				return false;
		} else if (!pPhone.equals(other.pPhone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Profile [pNo=%s, pName=%s, pBirth=%s, pPhone=%s, pCellphone=%s, pAddress=%s]", 
				   		      pNo, pName, pBirth, pPhone, pCellphone, pAddress);
	}
	
	

}
