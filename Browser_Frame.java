import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

import java.awt.event.*;

class Browser_Frame extends JFrame{
	
	private JTextField sitetext;
	private JEditorPane window;
	
	public Browser_Frame(){
		super("Basic Browser");
		sitetext= new JTextField("Enter website");
		sitetext.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						loadsite(event.getActionCommand());
						
					}});
		
		window = new JEditorPane();
		window.setEditable(false);
		window.setBackground(Color.WHITE);
		window.addHyperlinkListener(
				new HyperlinkListener(){

					public void hyperlinkUpdate(HyperlinkEvent e) {
						if(e.getEventType()==HyperlinkEvent.EventType.ACTIVATED)
							loadsite(e.getURL().toString());
					}});
		add(sitetext,BorderLayout.NORTH);
		add (new JScrollPane(window),BorderLayout.CENTER);
		sitetext.setBackground(Color.PINK);
		window.setVisible(true);
	}
	public void loadsite(String text){
		try{
			window.setPage("http://"+text);
			sitetext.setText(text);
		}catch(Exception e){
			System.out.print("failed");
		}
		
		
		
	}
}