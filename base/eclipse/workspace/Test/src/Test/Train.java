package Test;

public abstract class Train implements Vehicle{
	private String trainNumber;
	private String departureStation;
	private String arrivalStation;
	private boolean isStart;
	
	public Train(String trainNumber, String departureStation, String arrivalStation, boolean isStart) {
		super();
		this.trainNumber = trainNumber;
		this.departureStation = departureStation;
		this.arrivalStation = arrivalStation;
		this.isStart = isStart;
	}

	public boolean isStart() {
		return isStart;
	}

	public void setStart(boolean isStart) {
		this.isStart = isStart;
	}
}
