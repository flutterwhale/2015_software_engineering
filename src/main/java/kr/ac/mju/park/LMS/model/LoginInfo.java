package kr.ac.mju.park.LMS.model;

public class LoginInfo {

	private String ID;
	private String PW;
	private int Code;
	private String ErrorMsg;
	private String Name;
	private String Cat;
	
	public LoginInfo(String ID, String PW ) {
		// TODO Auto-generated constructor stub

			this.ID = ID;
			this.PW = PW;
		
			
		
	}


	public String getID() {
		return ID;
	}


	public void setID(String iD) {
		ID = iD;
	}


	public String getPW() {
		return PW;
	}


	public void setPW(String pW) {
		PW = pW;
	}


	public int getCode() {
		return Code;
	}


	public void setCode(int code) {
		Code = code;
	}


	public String getErrorMsg() {
		return ErrorMsg;
	}


	public void setErrorMsg(String errorMsg) {
		ErrorMsg = errorMsg;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getCat() {
		return Cat;
	}


	public void setCat(String cat) {
		Cat = cat;
	}



	


}
