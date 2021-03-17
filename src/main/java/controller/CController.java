package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Polynomial;
import view.CView;

public class CController {

	private String MESSAGE = "Bad input. One of the fields might be empty or data has incorrect format!";
	private String MESSAGE0 = "You are attempting to do division by 0!";
	private CView  m_view;

	public CController(Polynomial model, CView view) {
		m_view  = view;

		view.addAdditionListener(new AdditionListener());
		view.addSubtractionListener(new SubtractionListener());
		view.addMultiplyListener(new MultiplyListener());
		view.addQuotListener(new QuotientListener());
		view.addRemainderListener(new RemainderListener());
		view.addIntegrationListener(new IntegrationListener());
		view.addDifferentiationListener(new DifferentiationListener());
		view.addClear1Listener(new Clear1Listener());
		view.addClear2Listener(new Clear2Listener());
	}

	class AdditionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String polynom1 = "";
			String polynom2 = "";
			polynom1 = m_view.getPoly1();				
			polynom2 = m_view.getPoly2();
			Polynomial poly1 = new Polynomial();
			Polynomial poly2 = new Polynomial(); 	
			if( !polynom1.equals("") && !polynom2.equals("") &&  poly1.isPolynomial(polynom1) && poly2.isPolynomial(polynom2) ) {
				poly1 = poly1.toPolynomial(polynom1);
				poly2 = poly2.toPolynomial(polynom2);
				m_view.setResult(poly1.add(poly2).toString());
			}					
			else
				m_view.showError(MESSAGE);
		}
	}

	class SubtractionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String polynom1 = "";
			String polynom2 = "";
			polynom1 = m_view.getPoly1();				
			polynom2 = m_view.getPoly2();
			Polynomial poly1 = new Polynomial();
			Polynomial poly2 = new Polynomial(); 
			if( !polynom1.equals("") && !polynom2.equals("") && poly1.isPolynomial(polynom1) && poly2.isPolynomial(polynom2)) {
				poly1 = poly1.toPolynomial(polynom1);
				poly2 = poly2.toPolynomial(polynom2);
				m_view.setResult(poly1.sub(poly2).toString());					
			}
			else
				m_view.showError(MESSAGE);
		}
	}

	class MultiplyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String polynom1 = "";
			String polynom2 = "";
			polynom1 = m_view.getPoly1();				
			polynom2 = m_view.getPoly2();
			Polynomial poly1 = new Polynomial();
			Polynomial poly2 = new Polynomial();
			if( !polynom1.equals("") && !polynom2.equals("") && poly1.isPolynomial(polynom1) && poly2.isPolynomial(polynom2)) {
				poly1 = poly1.toPolynomial(polynom1);
				poly2 = poly2.toPolynomial(polynom2);
				m_view.setResult(poly1.mul(poly2).toString());
			}					
			else
				m_view.showError(MESSAGE);
		}
	}

	class RemainderListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String polynom1 = "";
			String polynom2 = "";
			polynom1 = m_view.getPoly1();				
			polynom2 = m_view.getPoly2();
			Polynomial poly1 = new Polynomial();
			Polynomial poly2 = new Polynomial(); 
			if( !polynom1.equals("") && !polynom2.equals("") && poly1.isPolynomial(polynom1) && poly2.isPolynomial(polynom2)) {
				if( polynom2.equals("0") )
					m_view.showError(MESSAGE0);
				else{
				poly1 = poly1.toPolynomial(polynom1);
				poly2 = poly2.toPolynomial(polynom2);
				Polynomial[] result = poly1.div(poly2);
				m_view.setResult(result[1].toString());	
				}
			}
			else
				m_view.showError(MESSAGE);
		}
	}

	class QuotientListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String polynom1 = "";
			String polynom2 = "";
			polynom1 = m_view.getPoly1();				
			polynom2 = m_view.getPoly2();
			Polynomial poly1 = new Polynomial();
			Polynomial poly2 = new Polynomial();
			if( !polynom1.equals("") && !polynom2.equals("") && poly1.isPolynomial(polynom1) && poly2.isPolynomial(polynom2)) {
				if( polynom2.equals("0") )
					m_view.showError(MESSAGE0);
				else {
				poly1 = poly1.toPolynomial(polynom1);
				poly2 = poly2.toPolynomial(polynom2);
				Polynomial[] result = poly1.div(poly2);
				m_view.setResult(result[0].toString());		
				}
			}
			else
				m_view.showError(MESSAGE);
		}
	}

	class DifferentiationListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String polynom1 = "";
			polynom1 = m_view.getPoly1();
			Polynomial poly1 = new Polynomial();
			if( !polynom1.equals("") && poly1.isPolynomial(polynom1)) {
					poly1 = poly1.toPolynomial(polynom1);
					m_view.setResult(poly1.deriv().toString());					
			}
			else
				m_view.showError(MESSAGE);
		}
	}

	class IntegrationListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String polynom1 = "";
			polynom1 = m_view.getPoly1();
			Polynomial poly1 = new Polynomial();				
			if( !polynom1.equals("") && poly1.isPolynomial(polynom1)) {
					poly1 = poly1.toPolynomial(polynom1);
					m_view.setResult(poly1.integ().toString());					
			}
			else
				m_view.showError(MESSAGE);
		}
	}


	public class Clear1Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			m_view.reset1();
		}
	}

	public class Clear2Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			m_view.reset2();
		}
	}
}
