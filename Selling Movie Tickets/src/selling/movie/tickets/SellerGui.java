package selling.movie.tickets;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author samar
 */
class SellerGui extends JFrame {
    
        private Seller Agent;
        
        private JTextField titleField, priceField;
        
            SellerGui(Seller a) {
            super(a.getLocalName());
            Agent = a;
     
            
            JPanel p = new JPanel();
	p.setLayout(new GridLayout(2, 2));
	p.add(new JLabel("Movie Name :"));
	titleField = new JTextField(15);
	p.add(titleField);
        titleField.setBackground(Color.YELLOW);
	p.add(new JLabel("Ticket Price:"));
	priceField = new JTextField(15);
        priceField.setBackground(Color.YELLOW);
	p.add(priceField);
	getContentPane().add(p, BorderLayout.CENTER);
		
	JButton addButton = new JButton("Book");
          
                  addButton.setBackground(Color.pink);
	addButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent ev) {
                                try {
		String title = titleField.getText().trim();
		String price = priceField.getText().trim();
		Agent.updateTicketWindow(title, Integer.parseInt(price));
		titleField.setText("");
		priceField.setText("");
                                          }
                                                    catch (Exception e) {
			JOptionPane.showMessageDialog(SellerGui.this, "Invalid values. "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
			}
			}
		} );
        
                		p = new JPanel();
		p.add(addButton);
		getContentPane().add(p, BorderLayout.SOUTH);
		
		// Make the agent terminate when the user closes 
		// the GUI using the button on the upper right corner	
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Agent.doDelete();
			}
		} );
		
		setResizable(true);
	}
            public void show() {
		pack();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = (int)screenSize.getWidth() / 2;
		int centerY = (int)screenSize.getHeight() / 2;
		setLocation(centerX - getWidth() / 2, centerY - getHeight() / 2);
		super.show();
        }
	}	

        
        
        
        
    

    

                

