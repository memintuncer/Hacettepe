import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CreateUser extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField nameSurnameField;
	private JTextField schoolField;
	private JTextField birthField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateUser frame = new CreateUser();
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
	public CreateUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 398, 502);
		contentPane = new JPanel();
		setContentPane(contentPane);	
		JPanel panel = new JPanel();
		panel.setBorder(null);	
		JPanel panel_2 = new JPanel();		
		JPanel panel_1 = new JPanel();		
		JPanel panel_3 = new JPanel();		
		JPanel panel_4 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
				.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(19))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		JLabel lblNewLabel_2 = new JLabel("Username");		
		usernameField = new JTextField();
		usernameField.setColumns(10);		
		JLabel lblNewLabel_3 = new JLabel("Password");		
		passwordField = new JPasswordField();		
		JLabel lblPasswordretype = new JLabel("Password(re-type)");		
		passwordField_1 = new JPasswordField();		
		JLabel lblNewLabel_1 = new JLabel("Name Surname");		
		nameSurnameField = new JTextField();
		nameSurnameField.setColumns(10);		
		JLabel lblSchoolGraduated = new JLabel("School graduated");		
		schoolField = new JTextField();
		schoolField.setColumns(10);		
		JLabel lblBirthDate = new JLabel("Birth Date");	
		birthField = new JTextField();
		birthField.setColumns(10);		
		JLabel lblRealtionshipStatus = new JLabel("Realtionship Status");	
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Single");
		comboBox.addItem("In relationship");
		comboBox.addItem("Complicated");
		comboBox.addItem("Divorced");
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ArrayList<String> blankList=new ArrayList<>();
				UserCollection uc=new UserCollection();
				String[] Userinfo=new String[7];				
				Userinfo[0]=nameSurnameField.getText();
				Userinfo[1]=usernameField.getText();
				Userinfo[2]=passwordField.getText();
				Userinfo[3]=passwordField_1.getText();
				Userinfo[4]=schoolField.getText();
				Userinfo[5]=birthField.getText();
				Userinfo[6]=(String)comboBox.getSelectedItem();
				for(int i=0;i<7;i++){
					if(!Userinfo[i].equals("")){
						blankList.add(Userinfo[i]);
					}		
				}
				if(blankList.size()<7){
					JOptionPane.showMessageDialog(null, "Please fill all the blanks");
				}
				else if(blankList.size()==7){
					if(passwordField.getText().equals(passwordField_1.getText())){
						uc.addUser(Userinfo);
						JOptionPane.showMessageDialog(null, "Well done! We have a new user named  "+usernameField.getText());
					}
					else if(!passwordField.getText().equals(passwordField_1.getText())){
						
						JOptionPane.showMessageDialog(null, "Passwords is not match");
					}
				}				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Main frame = new Main();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_1)
								.addComponent(lblSchoolGraduated)
								.addComponent(lblBirthDate)
								.addComponent(lblPasswordretype))
							.addGap(21)
							.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_4.createSequentialGroup()
									.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING, false)
										.addComponent(passwordField)
										.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
									.addContainerGap(72, Short.MAX_VALUE))
								.addComponent(nameSurnameField, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
								.addComponent(schoolField, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
								.addComponent(passwordField_1, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
								.addGroup(gl_panel_4.createSequentialGroup()
									.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(birthField, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
									.addContainerGap())))
						.addComponent(lblRealtionshipStatus)))
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(105)
					.addComponent(btnCreate)
					.addContainerGap(108, Short.MAX_VALUE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPasswordretype)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(nameSurnameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSchoolGraduated)
						.addComponent(schoolField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBirthDate)
						.addComponent(birthField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(lblRealtionshipStatus)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCreate)
					.addContainerGap(82, Short.MAX_VALUE))
		);
		panel_4.setLayout(gl_panel_4);
		
		JLabel lblCreateUser = new JLabel("Create User");
		lblCreateUser.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_2.add(lblCreateUser);
		
		JLabel lblNewLabel = new JLabel("");
		try{
			String path = "Facebooklogo1.png";
	        File file = new File(path);
	        BufferedImage image = ImageIO.read(file);
			lblNewLabel.setIcon(new ImageIcon(image));
		}
		catch(Exception h){
			
		}
		panel.add(lblNewLabel);
		contentPane.setLayout(gl_contentPane);
	}
}
