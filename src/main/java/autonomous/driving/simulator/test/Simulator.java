package autonomous.driving.simulator.test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Simulator
 *
 */

public class Simulator {

	/**
	 * This is a Action method.
	 * @return String output
	 */
	public String action () {
		String drivingMode = "";
		int sensorEventNumbers = 0;

		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter Driving Mode : ");
			drivingMode = sc.nextLine();

			System.out.println("Sensor Event Numbers : ");
			sensorEventNumbers = sc.nextInt();

			BigDecimal speed = getSpeed(drivingMode, sensorEventNumbers);
			System.out.println("Speed : " + speed);
			return speed + "";
		} catch (IllegalArgumentException ex) {
			System.out.println("Invalid Drive mode...available options are " + Arrays.asList(DriveModes.values()));
			return "Invalid Drive mode...available options are " + Arrays.asList(DriveModes.values());
		} catch (InputMismatchException ex) {
			System.out.println("Invalid Sensor event, it should be number");
			return "Invalid Sensor event, it should be number";
		} finally {
			sc.close();
		}
	}

	/**
	 * This is getSpeed method.
	 * @param driveMode String - accepts Driving Modes 
	 * @param sensorEventNum int - accepts Sensor Event Numbers
	 * @return int - speed
	 * @throws IllegalArgumentException
	 */
	private BigDecimal getSpeed (String driveMode, int sensorEventNum) throws IllegalArgumentException {
		double acceleration = 0;
		switch (DriveModes.valueOf(driveMode.toUpperCase())) {
		case A:
			acceleration = Acceleration.A;
			break;
		case B:
			acceleration = Acceleration.B;
			break;
		case C:
			acceleration = Acceleration.C;
			break;
		case D:
			acceleration = Acceleration.D;
			break;
		}
		return speedCalculator(acceleration, sensorEventNum);
	}

	/**
	 * This is speedCalculator method.
	 * @param acceleration double - accepts acceleration input
	 * @param sensorEventNum int - accepts sensor event number
	 * @return int - speed
	 */
	private BigDecimal speedCalculator (double acceleration, int sensorEventNum) {
		double gravity = 9.8;
		gravity = sensorEventNum * (gravity - acceleration);
		BigDecimal bDecimal = new BigDecimal(gravity);
		DecimalFormat df = new DecimalFormat("#.##"); 
		bDecimal = new BigDecimal(df.format(bDecimal));
		bDecimal = bDecimal.intValue() < 0 ? BigDecimal.ZERO : bDecimal;
		return round(bDecimal);
	}

	/**
	 * Round up the decimal.
	 * @param decimal - accepts BigDecimal
	 * @return BigDecimal
	 */
	private static BigDecimal round(BigDecimal decimal) {
		return decimal.setScale(0, BigDecimal.ROUND_UP);
	}
}