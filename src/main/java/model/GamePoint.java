package model;

public class GamePoint {
	private int userId;
	private int gameId;
	private int levelId;
	private int maxGamePoint;
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}

	public int getLevelId() {
		return levelId;
	}

	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public int getMaxGamePoint() {
		return maxGamePoint;
	}

	public void setMaxGamePoint(int maxGamePoint) {
		this.maxGamePoint = maxGamePoint;
	}
}
