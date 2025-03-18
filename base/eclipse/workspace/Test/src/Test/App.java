package Test;

public class App {
	public static void main(String[] args) {
		Vehicle manualCar = new ManualCar("10가1234", "blue", false, 0);
		Vehicle automaticCar = new AutomaticCar("10가1234", "blue", false);
		Vehicle passengerTrain = new PassengerTrain("KTX001", "서울", "부산", false, 200);
		Vehicle FreightTrain = new FreightTrain("Cargo001", "부산", "구미", true, 100.0);

		
	}
}
