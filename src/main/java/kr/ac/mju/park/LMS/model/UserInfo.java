package kr.ac.mju.park.LMS.model;

public class UserInfo {

	private User myUser;
	private int Code;

	public UserInfo() {

	}

	public User getMyUser() {
		return myUser;
	}

	public void setMyUser(User myUser) {
		this.myUser = myUser;
	}


	public int getErrorCode() {
		return Code;
	}

	public void setErrorCode(int errorCode) {
		this.Code = errorCode;
	}

}
