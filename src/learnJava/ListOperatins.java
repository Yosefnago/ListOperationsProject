package learnJava;


import java.util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ListOperatins extends JFrame implements ActionListener{
	
	// Lists to store the numbers from the files
    private static LinkedList<Integer> numbersList1 = new LinkedList<>();
    private static LinkedList<Integer> numbersList2 = new LinkedList<>();

    // File paths for sorted and unsorted lists
    private static File listAsorted = new File("C:\\Users\\user\\Desktop\\sortedA.txt");
    private static File listBsorted = new File("C:\\Users\\user\\Desktop\\sortedB.txt");
    private static File listAunsorted = new File("C:\\Users\\user\\Desktop\\unsortedA.txt");
    private static File listBunsorted = new File("C:\\Users\\user\\Desktop\\unsortedB.txt");
    
    private static Scanner scan; 
    private static String input;
	
    private static JLabel listsText; 
    private static JLabel listAtext;
    private static JLabel listBtext;
    private static JLabel operationText;
    
    private static JTextField textField;
    
	private static JFrame frame;
	private static JLabel label,title,goodBye;
	private static JPanel panel;
	private static JButton Insert,ExtractMin,Min,Union,Reset,Import,Exit,Ok;
	private static Font myFont = new Font("Arial",Font.BOLD,14);
	
	public ListOperatins() {
		frame = new JFrame("List Operations");
		frame.setSize(800,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		title = new JLabel();
		title.setText("Maman 13");
		title.setFont(new Font("Arial",Font.BOLD,23));
		title.setForeground(Color.BLACK);
		title.setBounds(200,5,410,50);
		title.setOpaque(true);
		
		goodBye = new JLabel();
		goodBye.setText("GoodBye !");
		goodBye.setFont(new Font("Arial",Font.BOLD,23));
		goodBye.setForeground(Color.BLACK);
		goodBye.setBounds(90,15,320,50);
		goodBye.setOpaque(true);
		
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(5,5,775,545);
		
		
		Insert = new JButton("Insert");
		Insert.setBackground(Color.LIGHT_GRAY);
		Insert.setBounds(10,45,115,25);
		Insert.setFocusable(false);
		Insert.setFont(myFont);
		
		
		ExtractMin = new JButton("Extract-Min");
		ExtractMin.setBackground(Color.LIGHT_GRAY);
		ExtractMin.setBounds(10,80,115,25);
		ExtractMin.setFocusable(false);
		ExtractMin.setFont(myFont);
		
		
		Min = new JButton("Min");
		Min.setBackground(Color.LIGHT_GRAY);
		Min.setBounds(10,115,115,25);
		Min.setFocusable(false);
		Min.setFont(myFont);
		
		
		Union = new JButton("Union");
		Union.setBackground(Color.LIGHT_GRAY);
		Union.setBounds(10,150,115,25);
		Union.setFocusable(false);
		Union.setFont(myFont);
		
		Reset = new JButton("Reset");
		Reset.setBackground(Color.LIGHT_GRAY);
		Reset.setBounds(10,185,115,25);
		Reset.setFocusable(false);
		Reset.setFont(myFont);
		
		
		Import = new JButton("Import");
		Import.setBackground(Color.LIGHT_GRAY);
		Import.setBounds(10,10,115,25);
		Import.setFocusable(false);
		Import.setFont(myFont);
		
		Exit = new JButton("Exit");
		Exit.setBackground(Color.LIGHT_GRAY);
		Exit.setBounds(10,220,115,25);
		Exit.setFocusable(false);
		Exit.setFont(myFont);
		
		Insert.addActionListener(this);
		ExtractMin.addActionListener(this);
		Min.addActionListener(this);
		Union.addActionListener(this);
		Reset.addActionListener(this);
		Import.addActionListener(this);
		Exit.addActionListener(this);
		
		sorted = new JButton("sorted");
		sorted.setBounds(210,80,115,25);
		sorted.setFocusable(false);
		sorted.setFont(myFont);
		sorted.setBackground(Color.LIGHT_GRAY);
		
		unsorted = new JButton("unsorted");
		unsorted.setBounds(345,80,115,25);
		unsorted.setFocusable(false);
		unsorted.setFont(myFont);
		unsorted.setBackground(Color.LIGHT_GRAY);
		
		
		
		listsText = new JLabel();
		listsText.setBounds(250,200,410,50);
		listsText.setForeground(Color.BLUE);
		listsText.setFont(myFont);
		
		listAtext = new JLabel();
		listAtext.setBounds(250,220,410,50);
		listAtext.setForeground(Color.black);
		listAtext.setFont(myFont);
		
		listBtext = new JLabel();
		listBtext.setBounds(250,240,410,50);
		listBtext.setForeground(Color.black);
		listBtext.setFont(myFont);
		
		operationText = new JLabel();
		operationText.setBounds(360,140,410,50); 
		operationText.setForeground(Color.black);
		operationText.setFont(myFont);
		
		textField = new JTextField();
		textField.setBounds(250,370,80,25);
		
		Ok = new JButton("Ok");
		Ok.setBounds(340,370,55,25);
		Ok.setFocusable(false);
		Ok.setForeground(Color.black);
		Ok.setFont(myFont);
		
		
		operationText.setText("Enter number");
		operationText.setBounds(250,320,100,60);
		
		
		
		panel.add(listsText);
		panel.add(listAtext);
		panel.add(listBtext);
		panel.add(title);
		panel.add(Insert);
		panel.add(ExtractMin);
		panel.add(Min);
		panel.add(Union);
		panel.add(Reset);
		panel.add(Import);
		panel.add(Exit);
		
		// Add action listeners to the sorted and unsorted buttons
		////////////////////////////////////////////////////////////////////////
		sorted.addActionListener(new ActionListener() {						////			
            @Override														////	
            public void actionPerformed(ActionEvent e) {					////
                try {														////	
                    readFile(listAsorted, listBsorted);						////		
                } catch (Exception e1) {									////
                    e1.printStackTrace();									////
                }															////
            }																////	
        });																	////		
																			////
        unsorted.addActionListener(new ActionListener() {					////
            @Override														////	
            public void actionPerformed(ActionEvent e) {					////
                try {														////
                    readFile(listAunsorted, listBunsorted);					////
                } catch (Exception e1) {									////
                    e1.printStackTrace();									////
                }															////
            }																////	
        });																	////	
        Exit.addActionListener(new ActionListener() {						////
            @Override														////				
            public void actionPerformed(ActionEvent e) {					////	
                if (e.getSource() == Exit) {								////	
                	
                	
                }															////
            }																////
        });
        Ok.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		try {
        			insert(numbersList1,numbersList2);
        		} catch (Exception e1) {									////
                    e1.printStackTrace();									////
                }
        	}
        });
        ////
        ////																////				
        ////////////////////////////////////////////////////////////////////////
		
		
		frame.add(panel);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		
		new ListOperatins();
		
	}


	private static JButton sorted,unsorted;
	@Override
	public void actionPerformed(ActionEvent e) {
		
		 if(e.getSource() == Import) {
			 title.revalidate();
			 title.setText("Choose sorted/unsorted list");
			 
			 panel.add(sorted);
			 panel.add(unsorted);
			 panel.revalidate(); // Refresh the panel to show the new buttons
		     panel.repaint();
		     
		   
		 }
		 
		if(e.getSource() == Insert) {
			 
		     panel.remove(sorted);
			 panel.remove(unsorted);
		     panel.add(operationText);
			 panel.add(textField);
			 panel.add(Ok);
			 title.revalidate();
			 title.setText("Enter number to insert it to the list");
			 panel.revalidate(); // Refresh the panel to show the new buttons
		     panel.repaint();
			
		}
		if(e.getSource() == ExtractMin) {
			panel.remove(Ok);
			panel.remove(operationText);
			panel.remove(textField);
			panel.remove(sorted);
			panel.remove(unsorted);
			title.revalidate();
			title.setText("Removing the minimum number");
			panel.revalidate(); // Refresh the panel to show the new buttons
		    panel.repaint();
			
			extract(numbersList1,numbersList2);
		}
		if(e.getSource() == Min) {
			panel.remove(Ok);
			panel.remove(operationText);
			panel.remove(textField);
			panel.remove(sorted);
			panel.remove(unsorted);
			title.revalidate();
			title.setText("Return the minimum number");
			panel.revalidate(); // Refresh the panel to show the new buttons
		    panel.repaint();
			
			min(numbersList1,numbersList2);
		}
		if(e.getSource() == Union) {
			panel.remove(Ok);
			panel.remove(operationText);
			panel.remove(textField);
			panel.remove(sorted);
			panel.remove(unsorted);
			title.revalidate();
			title.setText("Return merged list");
			panel.revalidate(); // Refresh the panel to show the new buttons
		    panel.repaint();
		    
			union(numbersList1,numbersList2);
		}
		if(e.getSource() == Reset) {
			panel.remove(Ok);
			panel.remove(operationText);
			panel.remove(textField);
			panel.remove(sorted);
			panel.remove(unsorted);
			title.revalidate();
			title.setText("Choose any option");
			panel.revalidate(); // Refresh the panel to show the new buttons
		    panel.repaint();
			
			numbersList1.clear();
            numbersList2.clear();
            listAtext.setText("List A : " +numbersList1.toString());
        	listBtext.setText("List B : " +numbersList2.toString());
		}
		if(e.getSource() == Exit) {
			panel.remove(Ok);
			panel.remove(operationText);
			panel.remove(textField);
			panel.remove(sorted);
			panel.remove(unsorted);
			panel.remove(Insert);
			panel.remove(ExtractMin);
			panel.remove(Min);
			panel.remove(Union);
			panel.remove(Reset);
			panel.remove(Exit);
			panel.remove(Import);
			title.setText("");
			
			goodBye.revalidate();
			goodBye.setText("GoodBye");
			panel.add(goodBye);
			panel.revalidate(); // Refresh the panel to show the new buttons
		    panel.repaint();
			
		}
		
	}
	public static void readFile(File fileName1,File fileName2) throws Exception {
		
    	try (BufferedReader br1 = new BufferedReader(new FileReader(fileName1));
                BufferedReader br2 = new BufferedReader(new FileReader(fileName2))) {
    		String line;
    		
    		// Read numbers from the first file into numbersList1
    		while ((line = br1.readLine()) != null) {
    		    
    		    String[] numbers = line.split("\\s+"); // Split the line into individual numbers

    		    for (String number : numbers) {
    		        try {
    		            int num = Integer.parseInt(number.trim()); // Parse each number
    		            numbersList1.add(num);
    		        } catch (NumberFormatException e) {
    		        	listsText.setText("Failed to parse number as integer: " + number);
    		            // Handle the error as needed, such as skipping the number or logging it
    		        }
    		    }
    		}
    		
    		// Read numbers from the second file into numbersList2
    		while ((line = br2.readLine()) != null) {
    		    
    		    String[] numbers = line.split("\\s+"); // Split the line into individual numbers

    		    for (String number : numbers) {
    		        try {
    		            int num = Integer.parseInt(number.trim()); // Parse each number
    		            numbersList2.add(num);
    		        } catch (NumberFormatException e) {
    		        	listsText.setText("Failed to parse number as integer: " + number);
    		            // Handle the error as needed, such as skipping the number or logging it
    		        }
    		    }
    		}   
           }
    	
    	listsText.setText("Your Lists :");
    	
    	listAtext.setText("List A : " +numbersList1.toString());
    	listBtext.setText("List B : " +numbersList2.toString());
    
    	
    }
	public static void insert(LinkedList<Integer> list1,LinkedList<Integer> list2 ) {
		
    	//Scanner s = new Scanner(System.in);
    	
    	String cmd = textField.getText();
    	
    	try {
    	int num = Integer.parseInt(cmd); 
    	
    	list1.addLast(num);
    	list2.addLast(num);
    	
    	}catch(NumberFormatException e) {
    		
    		listAtext.setText("List A : " +list1.toString());
    		listBtext.setText("List B : " +list2.toString());
    		return;
    	}
    	
    		Collections.sort(list1);
    		Collections.sort(list2);
    	
    	
    	listAtext.setText("List A : " +list1.toString());
    	listBtext.setText("List B : " +list2.toString());
    
    }
	public static void extract(LinkedList<Integer> list1,LinkedList<Integer> list2) {
		
		
    	if(list1.isEmpty()) {
    		listAtext.setText("List A : " + "List is empty");	
    	}
    	if(list2.isEmpty()) {
    		listBtext.setText("List A : " + "List is empty");	
    	}
    	list1.removeFirst();// Remove the first element of list1
    	list2.removeFirst();// Remove the first element of list2
    	
    	listAtext.setText("List A : " +list1.toString());
    	listBtext.setText("List B : " +list2.toString());
    }
	public static void min(LinkedList<Integer> list1,LinkedList<Integer> list2) {
		
    	
    	int num1 = list1.getFirst(); // Get the first (minimum) element of list1
    	int num2 = list2.getFirst(); // Get the first (minimum) element of list2
    	
    	listAtext.setText("Minimum of A : " +num1);
    	listBtext.setText("Minimum of B : " +num2);
    
    }
	public static void union(LinkedList<Integer> list1, LinkedList<Integer> list2) {
    	
		
        LinkedList<Integer> unionList = new LinkedList<>();
        
        Iterator<Integer> iter1 = list1.iterator();
        Iterator<Integer> iter2 = list2.iterator();

        Integer current1 = iter1.hasNext() ? iter1.next() : null;
        Integer current2 = iter2.hasNext() ? iter2.next() : null;

        while (current1 != null && current2 != null) {
            if (current1.equals(current2)) {
                unionList.add(current1);
                current1 = iter1.hasNext() ? iter1.next() : null;
                current2 = iter2.hasNext() ? iter2.next() : null;
            } else if (current1 < current2) {
                unionList.add(current1);
                current1 = iter1.hasNext() ? iter1.next() : null;
            } else {
                unionList.add(current2);
                current2 = iter2.hasNext() ? iter2.next() : null;
            }
        }

        // Add remaining elements from list1
        while (current1 != null) {
            unionList.add(current1);
            current1 = iter1.hasNext() ? iter1.next() : null;
        }

        // Add remaining elements from list2
        while (current2 != null) {
            unionList.add(current2);
            current2 = iter2.hasNext() ? iter2.next() : null;
        }
        
        // Sort the final union list
        Collections.sort(unionList);
        listAtext.setText(unionList.toString());
        listBtext.setText("");
    }
    

}
