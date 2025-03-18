package Test;

public class PassengerTrain extends Train{

	private int passengerCount;
	
	
	
	public PassengerTrain(String trainNumber, String departureStation, String arrivalStation, boolean isStart,
			int passengerCount) {
		super(trainNumber, departureStation, arrivalStation, isStart);
		this.passengerCount = passengerCount;
	}

	@Override
	public void accelerate() {
		System.out.println("여객 열차가 천천히 가속합니다!");
	}

	@Override
	public void stop() {
		System.out.println("여객 열차가 천천히 정차합니다!");
	}

	@Override
	public void setStart() {
		setStart(!isStart());
	}

}
