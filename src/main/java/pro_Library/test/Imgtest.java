package pro_Library.test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Imgtest extends JFrame {

	private String imgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator;
	private JLabel lblNewLabel;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Imgtest frame = new Imgtest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Imgtest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		lblNewLabel.setIcon(new ImageIcon(imgPath+"lgb.jpg"));
		contentPane.add(lblNewLabel);
	}

}
