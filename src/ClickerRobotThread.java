import java.awt.*;
import java.awt.event.InputEvent;

/**
 * Project: hClicker
 * Author: KaitoHH
 * Create Date: 2016/10/2
 * Description:
 * All rights reserved.
 */
public class ClickerRobotThread extends Thread {
	int cps;

	ClickerRobotThread(int cps) {
		this.cps = cps;
	}

	@Override
	public void run() {
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		while (true) {
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
			try {
				Thread.sleep(1000 / cps);
			} catch (InterruptedException e) {
				break;
			}
		}
	}

}
