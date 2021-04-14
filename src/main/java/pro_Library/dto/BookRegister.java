package pro_Library.dto;

public class BookRegister {
	private int bNo;
	private String bName;
	private String bDivision;

	public BookRegister() {
	}

	public BookRegister(int bNo, String bName, String bDivision) {
		super();
		this.bNo = bNo;
		this.bName = bName;
		this.bDivision = bDivision;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bDivision == null) ? 0 : bDivision.hashCode());
		result = prime * result + ((bName == null) ? 0 : bName.hashCode());
		result = prime * result + bNo;
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
		BookRegister other = (BookRegister) obj;
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
		return true;
	}

	@Override
	public String toString() {
		return String.format("BookRegister [bNo=%s, bName=%s, bDivision=%s]", bNo, bName, bDivision);

	}

}
