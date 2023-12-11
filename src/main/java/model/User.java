package model;
//DBのuser表と連動
//ユーザー情報用
public class User {
private int userId;
private String userName;
private String hash;
private String isexsit="1";







public String getIsexsit() {
	return isexsit;
}
public void setIsexsit(String isexsit) {
	this.isexsit = isexsit;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getHash() {
	return hash;
}
public void setHash(String hash) {
	this.hash = hash;
}



}
