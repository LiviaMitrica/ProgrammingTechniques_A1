package view;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import model.Polynomial;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.Font;


@SuppressWarnings("serial")
public class CView extends JFrame {
	@SuppressWarnings("unused")
	private Polynomial m_model;

	private JEditorPane poly1 = new JEditorPane();
	private JEditorPane poly2 = new JEditorPane();
	private JButton clear1 = new JButton("Clear");
	private JButton clear2 = new JButton("Clear");
	private JLabel polynom1 = new JLabel("Polynom1");
	private JLabel polynom2 = new JLabel("Polynom2");
	private JButton add = new JButton("+");
	private JButton sub = new JButton("-");
	private JButton mul = new JButton("x");
	private JButton quot = new JButton("/");
	private JButton rem = new JButton("%");
	private JButton deriv = new JButton("f'");
	private JButton integ = new JButton("∫");
	private JTextField result = new JTextField();
	private final JPanel bigPanel = new JPanel();


	public CView( Polynomial model) {
		
		JFrame frmCview;
		m_model = model;

		frmCview = new JFrame();
		frmCview.setResizable(false);
		frmCview.setBackground(Color.LIGHT_GRAY);
		frmCview.setTitle("CView");
		frmCview.setBounds(100, 100, 299, 450);
		frmCview.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCview.getContentPane().setLayout(null);

		poly1.setBounds(17, 76, 257, 28);
		frmCview.getContentPane().add(poly1);		
		poly2.setBounds(17, 148, 257, 30);
		frmCview.getContentPane().add(poly2);

		clear1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		clear1.setBounds(89, 47, 57, 19);
		frmCview.getContentPane().add(clear1);

		clear2.setFont(new Font("Tahoma", Font.PLAIN, 8));	
		clear2.setBounds(89, 119, 57, 19);
		frmCview.getContentPane().add(clear2);

		polynom1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		polynom1.setBounds(17, 39, 62, 30);
		frmCview.getContentPane().add(polynom1);

		polynom2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		polynom2.setBounds(17, 110, 57, 34);
		frmCview.getContentPane().add(polynom2);

		JPanel panel = new JPanel();
		panel.setBounds(17, 234, 257, 47);
		frmCview.getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		panel.add(add);
		panel.add(sub);
		panel.add(mul);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(17, 291, 257, 47);
		frmCview.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));

		panel_1.add(quot);
		panel_1.add(rem);
		rem.setFont(new Font("Tahoma", Font.PLAIN, 9));

		panel_1.add(deriv);
		integ.setBounds(104, 348, 83, 47);
		frmCview.getContentPane().add(integ);

		JLabel polyCalculator = new JLabel("Polynomial Calculator");
		polyCalculator.setHorizontalAlignment(SwingConstants.CENTER);
		polyCalculator.setFont(new Font("Verdana Pro Cond", Font.PLAIN, 14));
		polyCalculator.setBounds(17, 10, 246, 19);
		frmCview.getContentPane().add(polyCalculator);

		result.setBounds(17, 194, 257, 30);
		frmCview.getContentPane().add(result);
		frmCview.setVisible(true);
        frmCview.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
      
	}

	
	public void reset1() {
		poly1.setText("");
		result.setText("");
	}
	
	public void reset2() {
		poly2.setText("");
		result.setText("");
	}

	public String getPoly1() {
		return poly1.getText();
	}

	public String getPoly2() {
		return poly2.getText();
	}

	public void setResult(String newTotal) {
		result.setText(newTotal);
	}

	public void addAdditionListener(ActionListener mal) {
		add.addActionListener(mal);
	}

	public void addSubtractionListener(ActionListener mal) {
		sub.addActionListener(mal);
	}

	public void addMultiplyListener(ActionListener mal) {
		mul.addActionListener(mal);
	}

	public void addRemainderListener(ActionListener mal) {
		rem.addActionListener(mal);
	}

	public void addQuotListener(ActionListener mal) {
		quot.addActionListener(mal);
	}

	public void addDifferentiationListener(ActionListener mal) {
		deriv.addActionListener(mal);
	}

	public void addIntegrationListener(ActionListener mal) {
		integ.addActionListener(mal);
	}

	public void addClear1Listener(ActionListener cal) {
		clear1.addActionListener(cal);
	}

	public void addClear2Listener(ActionListener cal) {
		clear2.addActionListener(cal);
	}

	public void showError(String errMessage) {
		JOptionPane.showMessageDialog(bigPanel, errMessage);
	}
}
