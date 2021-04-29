package pro_Library.dto;

public class BookInformation {
	private int bNo;
	private String bName;
	private String bDivision;
	private String bRental;

	public BookInformation(int bNo, String bName, String bDivision, String bRental) {
		this.bNo = bNo;
		this.bName = bName;
		this.bDivision = bDivision;
		this.bRental = bRental;
	}

	public BookInformation(int bNo2) {
		// TODO Auto-generated constructor stub
	}

	
	public BookInformation(String string) { 
		
	}


	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbDivision() {
		return bDivision;
	}

	public void setbDivision(String bDivision) {
		this.bDivision = bDivision;
	}

	public String getbRental() {
		return bRental;
	}

	public void setbRental(String bRental) {
		this.bRental = bRental;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bDivision == null) ? 0 : bDivision.hashCode());
		result = prime * result + ((bName == null) ? 0 : bName.hashCode());
		result = prime * result + bNo;
		result = prime * result + ((bRental == null) ? 0 : bRental.hashCode());
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
		BookInformation other = (BookInformation) obj;
		if (bDivision == null) {
			if (other.bDivision != null)
				return false;
		} else if (!bDivision.equals(other.bDivision))
			return false;
		if (bName == null) {
			if (other.bName != null)
				return false;
		} else if (!bName.equals(other.bName))
			return false;
		if (bNo != other.bNo)
			return false;
		if (bRental == null) {
			if (other.bRental != null)
				return false;
		} else if (!bRental.equals(other.bRental))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Book_Information [bNo=%s, bName=%s, bDivision=%s, bRental=%s]", bNo, bName, bDivision,
				bRental);

	}

}
