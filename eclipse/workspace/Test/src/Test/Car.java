package Test;

public abstract class Car implements Vehicle{

	private String vin;
	private String color;
	private boolean isStart;
	
	public Car(String vin, String color, boolean isStart) {
		super();
		this.vin = vin;
		this.color = color;
		this.isStart = isStart;
	}

	public boolean isStart() {
		return isStart;
	}

	public void setStart(boolean isStart) {
		this.isStart = isStart;
	}
	
	
	
}
