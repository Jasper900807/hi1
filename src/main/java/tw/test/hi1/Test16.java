package tw.test.hi1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import tw.test.dao.SCDao;
import tw.test.entity.Course;
import tw.test.entity.Student;

public class Test16 extends JFrame {
	private SCDao dao;
	private Student s;
	private JButton add;
	private JLabel name;
	private CourseMenu menu;
	
	
	public Test16() {
		super("選課");
		
		dao = new SCDao();
		s = dao.getById((long)5);
		
		setLayout(new FlowLayout());
		name = new JLabel(s.getSname());
		menu = new CourseMenu();
		add = new JButton("選課");
		
		add(name); add(menu); add(add);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Course course = menu.getSelectedCourse();
				s.addCourse(course);
				s = dao.update(s);
			}
		});
	}
	
	public static void main(String[] args) {
		new Test16();

	}

}
