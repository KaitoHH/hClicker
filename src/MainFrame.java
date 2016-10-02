import javax.swing.*;
import java.awt.*;

/**
 * Project: hClicker
 * Author: KaitoHH
 * Create Date: 2016/10/2
 * Description:
 * All rights reserved.
 */
public class MainFrame extends JFrame {
	volatile Thread robotThread;
	int cps = 1;

	public MainFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("hClicker V1.0");
		this.setSize(164, 100);
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		this.setResizable(false);
		JButton button = new JButton("start");
		button.addActionListener(e -> {
			if (robotThread == null) {
				robotThread = new ClickerRobotThread(cps);
				robotThread.start();
			}
		});
		JButton button2 = new JButton("stop");
		button2.addActionListener(e -> {
			if (robotThread != null) {
				robotThread.interrupt();
				robotThread = null;
			}
		});
		SpinnerModel spinnerModel = new SpinnerNumberModel(1, 1, 20, 1);
		JTextField textField = new JTextField(2);
		textField.setEditable(false);
		textField.setText("1");
		JSpinner spinner = new JSpinner(spinnerModel);
		spinner.setEditor(textField);
		spinner.addChangeListener(e -> {
			cps = (int) spinner.getValue();
			textField.setText(spinner.getValue().toString());
		});
		JLabel label = new JLabel("speed:(per sec.)");
		this.getContentPane().add(button);
		this.getContentPane().add(button2);
		this.getContentPane().add(label);
		this.getContentPane().add(spinner);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
	}
}
