package ObjectPractice.UI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ObjectPractice.Util.MyUtil;

public class Controller extends JFrame{
	private JButton btnNew;
	private JButton btnSave;
	private JButton btnLoad;
	private Counter counter;
	
	public static final String FILE = "counter.dat";
	public Controller () {
		init();
		setDisplay();
		addListener();
		showFrame();
	}
	
	private void init () {
		btnNew = new JButton("New");
		btnSave = new JButton("Save");
		btnLoad = new JButton("Load");
	}
	
	private void setDisplay () {
		setLayout(new GridLayout(1,0));
		add(btnNew);
		add(btnSave);
		add(btnLoad);
	}
	
	private void addListener () {
		ActionListener aListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				Object src = ae.getSource();
				if (src == btnNew) {
					if (counter != null) {
						counter.dispose();
						counter = null;
					}
					counter = new Counter();
				}else if (src == btnSave) {
					if (counter != null) {
						FileOutputStream fos = null;
						ObjectOutputStream oos = null;
						
						try {
							fos = new FileOutputStream(FILE);
							oos = new ObjectOutputStream(fos);
							oos.writeObject(counter);
							oos.flush();
							oos.reset();
							
							counter.dispose();
							counter = null;
						} catch (IOException e) {
							e.printStackTrace();
						} finally {
							MyUtil.closeAll(oos, fos);
						}
					} else {
						JOptionPane.showMessageDialog(
								Controller.this, 
								"저장할 대상이 존재하지 않습니다."
							);
					}
				} else {
					FileInputStream fis = null;
					ObjectInputStream ois = null;
					
					try {
						fis = new FileInputStream(FILE);
						ois = new ObjectInputStream(fis);
						if (counter != null) {
							counter.dispose();
							counter = null;
						}
						counter = (Counter) ois.readObject(); 
						counter.setVisible(true);
					} catch (IOException e) {
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} finally {
						MyUtil.closeAll(ois, fis);
					}
				}
			}
		};
		btnNew.addActionListener(aListener);
		btnLoad.addActionListener(aListener);
		btnSave.addActionListener(aListener);
	}
	
	private void showFrame () {
		setTitle("controller");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Controller();
	}
	
	
}
