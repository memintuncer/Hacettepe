import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

public class ProfilePage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtV;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField postText;
	private static JTextField tagField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public ProfilePage() {
		JEditorPane NameLabel = new JEditorPane();
		NameLabel.setBounds(211, 103, 165, 34);
		setTitle("Profile Page");
		try{
			String path = "personicon8.png";
	        File file = new File(path);
	        setIconImage(Toolkit.getDefaultToolkit().getImage(path));
		}
		catch(Exception h){
			
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 818, 695);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 802, 39);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(SystemColor.textHighlight);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(6, 183, 246, 483);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(325, 158, 467, 487);
		panel_7.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 11, 467, 476);
		panel_7.add(tabbedPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		tabbedPane.addTab("Post", null, scrollPane_1, null);
		
		JPanel panel_8 = new JPanel();
		scrollPane_1.setViewportView(panel_8);
		panel_8.setLayout(null);
		panel_8.setPreferredSize(getPreferredSize());
		
		int x = 0;
		int y=0;
		int z=443;
		int t=42;
		
		for(User user:UserCollection.userList){
			if(user.getLogin().equals(true)){
				for(Post post :user.getPostList()){
					JButton tagButton = new JButton("Tag Friends");
					tagButton.setBounds(344, 11, 89, 23);
					tagButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
					JPanel panel_10= new JPanel();
					panel_10.setBounds(x, y, z, t);
					panel_10.setLayout(null);
					panel_10.add(tagButton);
					y+=t;
					
					
					
					panel_8.add(panel_10);
					
					if(post.getClass().getName().equals("TextPost")){
						
						txtV = new JTextField();
						txtV.setHorizontalAlignment(SwingConstants.LEFT);
						txtV.setText("T");
						txtV.setFont(new Font("Tahoma", Font.BOLD, 34));
						txtV.setBounds(0, 0, 20, 42);
						txtV.setBorder(BorderFactory.createEmptyBorder());
						panel_10.add(txtV);
						txtV.setColumns(10);
						txtV.setBackground(UIManager.getColor("Button.background"));
						postText = new JTextField();
						postText.setHorizontalAlignment(SwingConstants.LEFT);
						JLabel lblNewLabel_1 = new JLabel("New label");
						lblNewLabel_1.setBounds(30, -6, 300, 42);
						lblNewLabel_1.setText("<html><font color=blue>"+post.getTextContent()+"<font color=black><br>Tagged Users:	"+post.getTagf()+"<html>");
						lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
						lblNewLabel_1.setBounds(30, -6, 300, 42);
						lblNewLabel_1.setBorder(BorderFactory.createEmptyBorder());
						panel_10.add(lblNewLabel_1);
						lblNewLabel_1.setBackground(UIManager.getColor("Button.background"));
						tagButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								dispose();
								
								//String tags=TagUser.tagF;
								//tagField.setText(TagUser.tagF);
								
								
								
								
								EventQueue.invokeLater(new Runnable() {
									public void run() {
										try {
											TagUser frame = new TagUser();
											frame.setVisible(true);
											post.setTagList(tagField.getText());
											post.setTagf(post.getTaglist());
											
										} catch (Exception e) {
											e.printStackTrace();
										}
									}
								});
								
							}
						});
						
						
					}
					else if(post.getClass().getName().equals("VideoPost")){
						txtV = new JTextField();
						txtV.setHorizontalAlignment(SwingConstants.LEFT);
						txtV.setText("V");
						txtV.setFont(new Font("Tahoma", Font.BOLD, 34));
						txtV.setBounds(0, 0, 24, 41);
						txtV.setBorder(BorderFactory.createEmptyBorder());
						panel_10.add(txtV);
						txtV.setColumns(10);
						txtV.setBackground(UIManager.getColor("Button.background"));
						JLabel lblNewLabel_1 = new JLabel("New label");
						lblNewLabel_1.setBounds(30, -6, 300, 42);
						lblNewLabel_1.setText("<html><font color=blue>"+post.getTextContent()+"<font color=black><br>Tagged Users:	"+post.getTagf()+"<html>");
						lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
						lblNewLabel_1.setBounds(30, -6, 300, 42);
						lblNewLabel_1.setBorder(BorderFactory.createEmptyBorder());
						panel_10.add(lblNewLabel_1);
						lblNewLabel_1.setBackground(UIManager.getColor("Button.background"));
						tagButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								dispose();
								
								String tags=TagUser.tag();
								post.setTagList(tags);
								post.setTagf(post.getTaglist());
								
								
								EventQueue.invokeLater(new Runnable() {
									public void run() {
										try {
											TagUser frame = new TagUser();
											frame.setVisible(true);
										} catch (Exception e) {
											e.printStackTrace();
										}
									}
								});
							}
						});
						
						
						
					}
					else if(post.getClass().getName().equals("ImagePost")){
						txtV = new JTextField();
						txtV.setHorizontalAlignment(SwingConstants.LEFT);
						txtV.setText("I");
						txtV.setFont(new Font("Tahoma", Font.BOLD, 34));
						txtV.setBounds(0, 0, 19, 42);
						txtV.setBorder(BorderFactory.createEmptyBorder());
						panel_10.add(txtV);
						txtV.setColumns(10);
						txtV.setBackground(UIManager.getColor("Button.background"));
						JLabel lblNewLabel_1 = new JLabel("New label");
						lblNewLabel_1.setBounds(30, -6, 300, 30);
						lblNewLabel_1.setText("<html><font color=blue>"+post.getTextContent()+"<font color=black><br>Tagged Users:	"+post.getTagf()+"<html>");
						lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
						lblNewLabel_1.setBounds(30, -6, 300, 42);
						lblNewLabel_1.setBorder(BorderFactory.createEmptyBorder());
						panel_10.add(lblNewLabel_1);
						lblNewLabel_1.setBackground(UIManager.getColor("Button.background"));
						tagButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								dispose();
								
								
								
								EventQueue.invokeLater(new Runnable() {
									public void run() {
										try {
											TagUser frame = new TagUser();
											frame.setVisible(true);
										} catch (Exception e) {
											e.printStackTrace();
										}
									}
								});

								String tags=TagUser.tag();
								post.setTagList(tags);
								post.setTagf(post.getTaglist());
							}
						});
						
					}
					
					
					
				}
				
				
			}
		}
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		tabbedPane.addTab("Friends's Posts", null, scrollPane_2, null);
		
		JPanel panel_9 = new JPanel();
		scrollPane_2.setViewportView(panel_9);
		ArrayList<JPanel> panels = new ArrayList<>();
		
		for(User user:UserCollection.userList){
			if(user.getLogin().equals(true)){
				for(Post post:user.getPostList()){
					JPanel tagPanel = new JPanel();
					tagPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
					tagPanel.setBackground(Color.WHITE);
					tagPanel.setBounds(0, 0, 447, 51);
					JPanel tagPanel1 = new JPanel();
					tagPanel1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
					tagPanel1.setBackground(Color.WHITE);
					tagPanel1.setBounds(0, 0, 500, 51);
	
				}
			}
		}
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 11, 236, 199);
		panel_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel lblFriends = new JLabel("Friends");
		lblFriends.setBounds(10, 221, 65, 14);
		JList<String> list_1= new JList<String>(new DefaultListModel<String>());
		JRadioButton rdbtnNormal = new JRadioButton("Normal");
		rdbtnNormal.setBounds(81, 217, 87, 23);
		rdbtnNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==rdbtnNormal) {
			        DefaultListModel listModel = (DefaultListModel) list_1.getModel();
			        listModel.removeAllElements();
			    }
				for(User user:UserCollection.userList){
					if(user.getLogin().equals(true)){
						for(User friend:user.getFriendList()){
							((DefaultListModel<String>)list_1.getModel()).addElement(friend.getUsername());
						}
					}
				}
			}
		});
		
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Blocked");
		rdbtnNewRadioButton.setBounds(170, 217, 97, 23);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==rdbtnNewRadioButton) {
			        DefaultListModel listModel = (DefaultListModel) list_1.getModel();
			        listModel.removeAllElements();
			    }
				for(User user:UserCollection.userList){
					if(user.getLogin().equals(true)){
						for(User friend:user.getBlockedList()){
							((DefaultListModel<String>)list_1.getModel()).addElement(friend.getUsername());
						}
					}
				}
				
			}
		});
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNormal);
		JList list = new JList();
		list.setBounds(367, 497, 1, 1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(10, 247, 212, 205);
		panel_6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JButton btnRemove = new JButton("Remove  Selected User");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				String selectedText = (String)list_1.getSelectedValue();
				int yesNo=JOptionPane.showConfirmDialog(null, "Are you sure to remove selected user?","remove User", JOptionPane.YES_NO_OPTION);
				if(yesNo==0){
					for(User user:UserCollection.userList){
						if(user.getLogin().equals(true)){
							Iterator itr=user.getFriendList().iterator();
							Iterator itr1=user.getBlockedList().iterator();
							
							try{
								User blocked=(User) itr1.next();
								 if(blocked.getUsername().equals(selectedText)){
										itr1.remove();
									}
							}
							catch(Exception NoSuchElementException ){
								continue;
							}
							try{
								User friend=(User) itr.next();
								if(friend.getUsername().equals(selectedText)){
									itr.remove();
								}
							}
							catch(Exception NoSuchElementException){
								continue;
							}
							
							
							
						}
			//		UserCollection.removeUser(selectedText);
					
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
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_6.createSequentialGroup()
							.addContainerGap()
							.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_6.createSequentialGroup()
							.addGap(46)
							.addComponent(btnRemove)))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_6.createSequentialGroup()
							.addGap(11)
							.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE))
						.addGroup(gl_panel_6.createSequentialGroup()
							.addGap(44)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addComponent(btnRemove))
		);
		panel_6.setLayout(gl_panel_6);
		
		JLabel lblInformation = new JLabel("Information");
		lblInformation.setBounds(12, 2, 92, 14);
		
		JLabel lblBirthdate = new JLabel("BirthDate");
		lblBirthdate.setBounds(12, 22, 59, 15);
		lblBirthdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblSchoolGraduated = new JLabel("School Graduated");
		lblSchoolGraduated.setBounds(12, 69, 109, 15);
		lblSchoolGraduated.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblRelationshipStatus = new JLabel("Relationship Status");
		lblRelationshipStatus.setBounds(12, 116, 121, 15);
		lblRelationshipStatus.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(12, 137, 121, 20);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(12, 163, 104, 23);
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBounds(12, 43, 106, 20);
		JEditorPane s_text = new JEditorPane();
		s_text.setBounds(12, 90, 214, 20);
		s_text.setEditable(false);
		s_text.setBackground(UIManager.getColor("Button.background"));
		editorPane_1.setBackground(UIManager.getColor("Button.background"));
		editorPane_1.setEditable(false);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(btnUpdate.getText().equals("Update")){
					
					
					btnUpdate.setText("Save");
					s_text.setEditable(true);
					editorPane_1.setEditable(true);
					NameLabel.setEditable(true);
					comboBox.removeAllItems();
					comboBox.addItem("Complicated");
					comboBox.addItem("Single");
					comboBox.addItem("In relationship ");
					comboBox.addItem("Divorced");
					
					
				}
				else if(btnUpdate.getText().equals("Save")){
					btnUpdate.setText("Update");
					String date=editorPane_1.getText();
					String school=s_text.getText();
					String name=NameLabel.getText();
					for(User user:UserCollection.userList){
						if(user.getLogin().equals(true)){
							String relationship=(String) comboBox.getSelectedItem();
							//btnUpdate.setText("Update");
							user.setSchool(school);
							user.setDate(date);
							user.setName(name);
							comboBox.removeAllItems();
							s_text.setEditable(false);
							editorPane_1.setEditable(false);
							NameLabel.setEditable(false);
							user.setRelationship(relationship);
							comboBox.addItem(user.getRelationship());
							
						}
					}}}
		});
		panel_5.setLayout(null);
		panel_5.add(lblInformation);
		panel_5.add(lblBirthdate);
		panel_5.add(lblSchoolGraduated);
		panel_5.add(comboBox);
		panel_5.add(lblRelationshipStatus);
		panel_5.add(btnUpdate);
		panel_5.add(editorPane_1);
		panel_5.add(s_text);
		for(User user:UserCollection.userList){
			if(user.getLogin().equals(true)){
				NameLabel.setText(user.getName());
				editorPane_1.setText(user.getDate());
				s_text.setText(user.getSchool());
				comboBox.addItem(user.getRelationship());
				
			}
		}
		
		JLabel lblSearchFriend = new JLabel("Search Friend");
		lblSearchFriend.setBounds(103, 16, 104, 14);
		lblSearchFriend.setForeground(Color.WHITE);
		
		textField = new JTextField();
		textField.setBounds(217, 13, 123, 20);
		textField.setColumns(10);
		
		JButton btnCreatePost = new JButton("Create Post");
		btnCreatePost.setBounds(504, 12, 140, 23);
		btnCreatePost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
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
		});
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(672, 11, 103, 23);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String selectedText = (String)list_1.getSelectedValue();
				dispose();
				for(User user:UserCollection.userList){
					if(user.getLogin().equals(true)){
						user.setLogin(false);
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
		contentPane.setLayout(null);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		panel_4.add(panel_5);
		panel_4.add(list);
		panel_4.add(lblFriends);
		panel_4.add(rdbtnNormal);
		panel_4.add(rdbtnNewRadioButton);
		panel_4.add(panel_6);
		contentPane.add(panel_7);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.add(lblSearchFriend);
		panel.add(textField);
		panel.add(btnCreatePost);
		panel.add(btnLogout);
		
		contentPane.add(NameLabel);
		NameLabel.setBackground(UIManager.getColor("Button.background"));
		
		
		NameLabel.setEditable(false);
		NameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		JLabel lblNewLabel = new JLabel("");
		try{
			String path = "personicon8.png";
	        File file = new File(path);
	        BufferedImage image = ImageIO.read(file);
			lblNewLabel.setIcon(new ImageIcon(image));
		}
		catch(Exception h){
			
		}
		lblNewLabel.setBounds(0, 38, 158, 144);
		contentPane.add(lblNewLabel);
		
		tagField = new JTextField();
		tagField.setBounds(579, 103, 109, 34);
		contentPane.add(tagField);
		tagField.setColumns(10);
		tagField.setVisible(false);
	}
	public static   JTextField TagField(){
		return tagField;
		
	}
}
