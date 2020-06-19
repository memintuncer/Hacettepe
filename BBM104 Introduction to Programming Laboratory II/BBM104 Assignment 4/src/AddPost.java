import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddPost extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPost frame = new AddPost();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddPost() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		
		comboBox.setBounds(141, 26, 149, 20);
		comboBox.addItem("TextPost");
		comboBox.addItem("ImagePost");
		comboBox.addItem("VideoPost");
		
		contentPane.add(comboBox);
		
		JButton btnAddPost = new JButton("Add Post");
		
		btnAddPost.setBounds(451, 25, 89, 23);
		contentPane.add(btnAddPost);
		
		JLabel lblPostType = new JLabel("Post Type");
		lblPostType.setBounds(32, 29, 99, 14);
		contentPane.add(lblPostType);
		
		JLabel lblNewLabel = new JLabel("Text");
		lblNewLabel.setBounds(32, 83, 46, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(141, 80, 424, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Latitude");
		lblNewLabel_1.setBounds(32, 128, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setText("");
		textField_1.setBounds(141, 125, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblLongtitude = new JLabel("Longtitude");
		lblLongtitude.setBounds(272, 128, 86, 14);
		contentPane.add(lblLongtitude);
		
		textField_2 = new JTextField();
		textField_2.setBounds(368, 125, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblFilename = new JLabel("Filename");
		lblFilename.setBounds(32, 176, 99, 14);
		contentPane.add(lblFilename);
		
		textField_3 = new JTextField();
		textField_3.setBounds(141, 173, 165, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(32, 219, 99, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_4 = new JTextField();
		textField_4.setBounds(141, 216, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(272, 219, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_5 = new JTextField();
		textField_5.setBounds(368, 216, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		lblFilename.setVisible(false);
		textField_3.setVisible(false);
		lblNewLabel_2.setVisible(false);
		textField_4.setVisible(false);
		lblNewLabel_3.setVisible(false);
		textField_5.setVisible(false);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String post=(String) comboBox.getSelectedItem();
				if(post.equals("TextPost")){
					lblFilename.setVisible(false);
					textField_3.setVisible(false);
					lblNewLabel_2.setVisible(false);
					textField_4.setVisible(false);
					lblNewLabel_3.setVisible(false);
					textField_5.setVisible(false);
					
					
				}
				else if(post.equals("ImagePost")){
					lblFilename.setVisible(true);
					textField_3.setVisible(true);
					lblNewLabel_2.setVisible(true);
					lblNewLabel_2.setText("Width");
					textField_4.setVisible(true);
					lblNewLabel_3.setVisible(true);
					lblNewLabel_3.setText("Heigth");
					textField_5.setVisible(true);
					
				}
				
				else if (post.equals("VideoPost")){
					lblFilename.setVisible(true);
					textField_3.setVisible(true);
					lblNewLabel_2.setVisible(true);
					lblNewLabel_2.setText("Duration");
					textField_4.setVisible(true);
					lblNewLabel_3.setVisible(false);
					textField_5.setVisible(false);
				}
			}
		});
		
		btnAddPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				String text=textField.getText();
				String lat=textField_1.getText();
				String lon=textField_2.getText();
				String filename=textField_3.getText();
				String w=textField_4.getText();
				String h=textField_5.getText();
				String res=w+"X"+h;
				String duration=textField_4.getText();
				for(User user:UserCollection.userList){
					if(user.getLogin().equals(true)){
						if(comboBox.getSelectedItem().equals("TextPost")){
							user.addText1(user, text, lon, lat);
						}
						else if(comboBox.getSelectedItem().equals("ImagePost")){
							user.addImage1(user, text, lon, lat,filename, res);
						}
						else if(comboBox.getSelectedItem().equals("VideoPost")){
							user.addVideo1(user, text, lon, lat, filename, duration);
						}
						
					}
					
			
				}
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ProfilePage frame = new ProfilePage();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			
		});
		
	}
}
