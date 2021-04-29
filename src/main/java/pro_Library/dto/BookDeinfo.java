package pro_Library.dto;

public class BookDeinfo {
	private int bNo;
	private String bName;
	private String bDivision;
	private String bImg;
	
	public BookDeinfo(int bNo) {}
	
	public BookDeinfo(int bNo, String bName, String bDivision, String bImg) {
		super();
		this.bNo = bNo;
		this.bName = bName;
		this.bDivision = bDivision;
		this.bImg = bImg;
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

	public String getbImg() {
		return bImg;
	}

	public void setbImg(String bImg) {
		this.bImg = bImg;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bDivision == null) ? 0 : bDivision.hashCode());
		result = prime * result + ((bImg == null) ? 0 : bImg.hashCode());
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
		BookDeinfo other = (BookDeinfo) obj;
		if (bDivision == null) {
			if (other.bDivision != null)
				return false;
		} else if (!bDivision.equals(other.bDivision))
			return false;
		if (bImg == null) {
			if (other.bImg != null)
				return false;
		} else if (!bImg.equals(other.bImg))
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
		return String.format("BookDeinfo [bNo=%s, bName=%s, bDivision=%s, bImg=%s]", bNo, bName, bDivision, bImg);
	}
	
	
	

}