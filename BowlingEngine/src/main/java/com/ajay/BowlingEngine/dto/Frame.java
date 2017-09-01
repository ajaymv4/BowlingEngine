package com.ajay.BowlingEngine.dto;

public class Frame {
	
	private boolean isSpare;
	private boolean isStrike;
	private int frameScore;
	private int chance1Score;
	private int chance2Score;
	private boolean isNormal;
	
	
	public Frame(){
		
	}
	public Frame(boolean isSpare, boolean isStrike,boolean isNormal, int chance1Score, int chance2Score) {
		super();
		this.isSpare = isSpare;
		this.isStrike = isStrike;
		this.chance1Score = chance1Score;
		this.chance2Score = chance2Score;
		this.isNormal = isNormal;
	}
	
	public boolean isNormal() {
		return isNormal;
	}
	public void setNormal(boolean isNormal) {
		this.isNormal = isNormal;
	}
	
	
	/**
	 * @return the isSpare
	 */
	public boolean isSpare() {
		return isSpare;
	}
	/**
	 * @param isSpare the isSpare to set
	 */
	public void setSpare(boolean isSpare) {
		this.isSpare = isSpare;
	}
	/**
	 * @return the isStrike
	 */
	public boolean isStrike() {
		return isStrike;
	}
	/**
	 * @param isStrike the isStrike to set
	 */
	public void setStrike(boolean isStrike) {
		this.isStrike = isStrike;
	}
	/**
	 * @return the frameScore
	 */
	public int getFrameScore() {
		return frameScore;
	}
	/**
	 * @param frameScore the frameScore to set
	 */
	public void setFrameScore(int frameScore) {
		this.frameScore = frameScore;
	}
	/**
	 * @return the chance1Score
	 */
	public int getChance1Score() {
		return chance1Score;
	}
	/**
	 * @param chance1Score the chance1Score to set
	 */
	public void setChance1Score(int chance1Score) {
		this.chance1Score = chance1Score;
	}
	/**
	 * @return the chance2Score
	 */
	public int getChance2Score() {
		return chance2Score;
	}
	/**
	 * @param chance2Score the chance2Score to set
	 */
	public void setChance2Score(int chance2Score) {
		this.chance2Score = chance2Score;
	}
	
	public String toString(){
		return this.getChance1Score()+" "+this.getChance2Score();
	}
	

}

