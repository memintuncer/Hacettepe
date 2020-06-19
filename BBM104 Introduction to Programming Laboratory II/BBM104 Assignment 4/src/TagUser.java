import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TagUser extends JFrame {

	private JPanel contentPane;
	public static String friendName;
	 public static String tagF;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	
	/**
	 * Create the frame.
	 */
	public TagUser() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 342, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTagg = new JLabel("Taggable Friends");
		lblTagg.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTagg.setBounds(37, 23, 176, 33);
		contentPane.add(lblTagg);
		
		JList<String> list= new JList<String>(new DefaultListModel<String>());
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tagF=(String)list.getSelectedValue();
				//ProfilePage.TagField().setText((String)list.getSelectedValue());
				System.out.println(tagF);
			}
		});
		list.setBounds(37, 52, 214, 215);
		contentPane.add(list);
		
		for(User user:UserCollection.userList){
			if(user.getLogin().equals(true)){
				for(User friend:user.getFriendList()){
					((DefaultListModel<String>)list.getModel()).addElement(friend.getName());
				}
			}
		}
		
		JButton btnNewButton = new JButton("Tag Friend");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						
						try {
							ProfilePage frame = new ProfilePage();
							frame.TagField().setText((String)list.getSelectedValue());
							frame.setVisible(true);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
			
		});
		btnNewButton.setBounds(37, 294, 220, 23);
		contentPane.add(btnNewButton);
		list.removeAll();
	}
	public static String tag(){
		return friendName;
	}
}
