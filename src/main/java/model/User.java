package model;
//DBのuser表と連動
//ユーザー情報用
public class User {
private int userId;
private String mail;
private String userName;
private String hash;
private int isExsit=1;
private int isBan=1;


public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
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
public int getIsExsit() {
	return isExsit;
}
public void setIsExsit(int isExsit) {
	this.isExsit = isExsit;
}
public int getIsBan() {
	return isBan;
}
public void setIsBan(int isBan) {
	this.isBan = isBan;
}







}
