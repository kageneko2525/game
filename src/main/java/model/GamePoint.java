package model;

public class GamePoint {
	private int userId;
	private int gameId;
	private int maxGamePoint;

	public int getUserId() {
		return userId;
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
