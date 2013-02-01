package com.refactoring.restaurant.domain;

public class DeliveryStatus {

	public enum STATUS {
		NOT_YET_STARTED, ON_THE_WAY, DELIVERED, NOT_ACCEPTED
	}

	public enum CommuteMode {
		BIKE, CYCLE, VAN
	}

	private STATUS status;
	private long timeTaken;
	private CommuteMode commuteMode;

	public STATUS getStatus() {
		return status;
	}

	public void setStatus(STATUS status) {
		this.status = status;
	}

	public long getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(long timeTaken) {
		this.timeTaken = timeTaken;
	}

	public CommuteMode getCommuteMode() {
		return commuteMode;
	}

	public void setCommuteMode(CommuteMode commuteMode) {
		this.commuteMode = commuteMode;
	}
}
