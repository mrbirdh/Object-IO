package ObjectPractice.UI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Counter extends JFrame implements ActionListener {
	public static final int PLUS = 1;
	public static final int MINUS= -1;
	private JButton btnPlus;
	private JButton btnMinus;
	private JLabel lblNum;
	
	public Counter () {
		init();
		setDisplay();
		addListener();
		showFrame();
	}
	
	private void init () {
		btnPlus = new JButton("+");	
		btnMinus = new JButton("-");	
		lblNum = new JLabel("0", JLabel.CENTER);
		lblNum.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
	}
	
	private void setDisplay () {
		JPanel pnlBtn = new JPanel();
		pnlBtn.add(btnPlus);
		pnlBtn.add(btnMinus);
		
		add(lblNum, BorderLayout.CENTER);
		add(pnlBtn, BorderLayout.SOUTH);
	}
	
	private void addListener () {
		btnPlus.addActionListener(this);
		btnMinus.addActionListener(this);
	}
	
	@Override
	public void actionPerformed (ActionEvent ae) {
		Object src = ae.getSource();
		if (src == btnPlus) {
			calculation(PLUS);
		} else {
			calculation(MINUS);
		}
	}
	
	private void calculation (int computation) {
		int num = Integer.parseInt(lblNum.getText());
		if (computation == PLUS) {
			num++;
			lblNum.setText(String.valueOf(num));
		} else {
			num--;
			lblNum.setText(String.valueOf(num));
		}
	}
	
	private void showFrame () {
		setTitle("Counter Practice");
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
//	public static void main(String[] args) {
//		new Counter();
//	}
}
