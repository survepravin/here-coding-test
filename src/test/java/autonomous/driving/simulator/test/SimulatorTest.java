package autonomous.driving.simulator.test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class SimulatorTest {
	
	Simulator simulator;
	InputStream sysInBackup;
	
	@Before
	public void before() {
		simulator = new Simulator();
		sysInBackup = System.in;
	}
	
	@Test
	public void testValidA() {
		String driveMode = "A";
		int sensorNumber = 25;
		System.setIn(getByteArrayInputStream(driveMode + "\n"+ sensorNumber));
		Assert.assertEquals("70", simulator.action());
	}
	
	@Test
	public void testValidB() {
		String driveMode = "B";
		int sensorNumber = 25;
		System.setIn(getByteArrayInputStream(driveMode + "\n"+ sensorNumber));
		Assert.assertEquals("108", simulator.action());
	}
	
	@Test
	public void testValidC() {
		String driveMode = "C";
		int sensorNumber = 25;
		System.setIn(getByteArrayInputStream(driveMode + "\n"+ sensorNumber));
		Assert.assertEquals("170", simulator.action());
	}
	
	@Test
	public void testValidD() {
		String driveMode = "D";
		int sensorNumber = 25;
		System.setIn(getByteArrayInputStream(driveMode + "\n"+ sensorNumber));
		Assert.assertEquals("225", simulator.action());
	}
	
	@Test
	public void testInvalidDriveMode() {
		String driveMode = "Q";
		int sensorNumber = 25;
		System.setIn(getByteArrayInputStream(driveMode + "\n"+ sensorNumber));
		assertThat(simulator.action(), containsString("Invalid Drive mode"));
	}
	
	@Test
	public void testInvalidSensorNumber() {
		String driveMode = "A";
		String sensorNumber = "q";
		System.setIn(getByteArrayInputStream(driveMode + "\n"+ sensorNumber));
		assertThat(simulator.action(), containsString("Invalid Sensor event"));
	}
	
	@Test
	public void testNegativeSensorNumber() {
		String driveMode = "A";
		int sensorNumber = -88;
		System.setIn(getByteArrayInputStream(driveMode + "\n"+ sensorNumber));
		assertThat(simulator.action(), containsString("0"));
	}
	
	@Test
	public void testBlankDriveMode() {
		String driveMode = "";
		int sensorNumber = 25;
		System.setIn(getByteArrayInputStream(driveMode + "\n"+ sensorNumber));
		assertThat(simulator.action(), containsString("Invalid Drive mode"));
	}
	
	@Test (expected = NoSuchElementException.class)
	public void testBlankSensorNumber() {
		String driveMode = "A";
		System.setIn(getByteArrayInputStream(driveMode + "\n"+ ""));
		simulator.action();
	}
	
	@Test
	public void testRangeSensorEventNumber() {
		String driveMode = "A";
		int sensorNumber = 1111111111;
		System.setIn(getByteArrayInputStream(driveMode + "\n"+ sensorNumber));
		Assert.assertEquals("0", simulator.action());
	}
	
	@After
	public void after() {
		System.setIn(sysInBackup);
	}
	
	private ByteArrayInputStream getByteArrayInputStream(String data) {
		return new ByteArrayInputStream(data.getBytes());
	}
}
