import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MealPlanBuilder {

	// The window's frame
	private JFrame frame;
	
	// The main course DefaultListModel
	private DefaultListModel mainCourseListModel;
	
	// The side dish DefaultListModel
	private DefaultListModel sideDishListModel;
	
	// The user's selected Day
	private JList selectedDay;
	
	// The selected day's ListModel
	private DefaultListModel selectedListModel;
	
	// The selected day's border
	private EtchedBorder selectedBorder;
	
	// The non-selected days' border
	private EtchedBorder normalBorder;
	
	// Labels for the dishes on the graphic
	private JLabel sideDishLbl1;
	private JLabel sideDishLbl2;
	private JLabel mainCourseLbl;
	
	// List of all ListModels from all days
	private List<DefaultListModel> allDayLists;
	
	// List of all main courses
	private List<String> allMainCourses;
	
	// List of all side dishes
	private List<String> allSideDishes;

	// Create the application and initialize values
	public MealPlanBuilder(List<String> mc, List<String> sd) {
		
		mainCourseListModel = new DefaultListModel();
		mainCourseListModel.addAll(mc);
		sideDishListModel = new DefaultListModel();
		sideDishListModel.addAll(sd);
		selectedBorder = new EtchedBorder(EtchedBorder.LOWERED, Color.GREEN, null);
		normalBorder = new EtchedBorder(EtchedBorder.LOWERED, null, null);
		selectedDay = new JList();
		sideDishLbl1 = new JLabel();
		sideDishLbl2 = new JLabel();
		mainCourseLbl = new JLabel();
		allDayLists = new ArrayList<DefaultListModel>();
		allMainCourses = new ArrayList<String>();
		allSideDishes = new ArrayList<String>();
		initialize();
		frame.setVisible(true);

	}
	
	// Getters and setters
	public DefaultListModel GetMCListModel() {
		
		return mainCourseListModel;
	}
	
	public DefaultListModel GetSDListModel() {
		
		return sideDishListModel;
	}
	
	public List<String> GetAllMainCourses() {
		
		return allMainCourses;
	}
	
	public List<String> GetAllSideDishes() {
		
		return allSideDishes;
	}

	// Initialize contents of the frame
	private void initialize() {
		
		// List models for listboxes
		DefaultListModel sunList = new DefaultListModel();
		DefaultListModel monList = new DefaultListModel();
		DefaultListModel tueList = new DefaultListModel();
		DefaultListModel wedList = new DefaultListModel();
		DefaultListModel thuList = new DefaultListModel();
		DefaultListModel friList = new DefaultListModel();
		DefaultListModel satList = new DefaultListModel();
		
		// Add all ListModels to master list
		allDayLists.add(sunList);
		allDayLists.add(monList);
		allDayLists.add(tueList);
		allDayLists.add(wedList);
		allDayLists.add(thuList);
		allDayLists.add(friList);
		allDayLists.add(satList);
		
		// Frame component
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1050, 850);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// Labels for header
		JLabel label = new JLabel("Builder");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.DARK_GRAY);
		label.setFont(new Font("Tw Cen MT", Font.BOLD, 50));
		label.setBounds(504, 29, 164, 54);
		frame.getContentPane().add(label);
		
		JLabel mealLbl = new JLabel("MealPlan");
		mealLbl.setHorizontalAlignment(SwingConstants.CENTER);
		mealLbl.setForeground(Color.ORANGE);
		mealLbl.setFont(new Font("Tw Cen MT", Font.BOLD, 50));
		mealLbl.setBounds(307, 29, 218, 54);
		frame.getContentPane().add(mealLbl);
		
		// Panel to display dish graphic
		JPanel imgPanel = new DishJPanel();
		imgPanel.setBounds(243, 113, 517, 281);
		frame.getContentPane().add(imgPanel);
		imgPanel.setLayout(null);
		
		// Labels for Side Dishes
		sideDishLbl1 = new JLabel("Side Dish");
		sideDishLbl1.setBackground(Color.LIGHT_GRAY);
		sideDishLbl1.setHorizontalAlignment(SwingConstants.RIGHT);
		sideDishLbl1.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		sideDishLbl1.setBounds(99, 78, 137, 22);
		imgPanel.add(sideDishLbl1);
		
		sideDishLbl2 = new JLabel("Side Dish");
		sideDishLbl2.setHorizontalAlignment(SwingConstants.LEFT);
		sideDishLbl2.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		sideDishLbl2.setBackground(Color.LIGHT_GRAY);
		sideDishLbl2.setBounds(274, 78, 137, 22);
		imgPanel.add(sideDishLbl2);
		
		// Labels for Main Course
		mainCourseLbl = new JLabel("Main Course");
		mainCourseLbl.setHorizontalAlignment(SwingConstants.CENTER);
		mainCourseLbl.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		mainCourseLbl.setBackground(Color.LIGHT_GRAY);
		mainCourseLbl.setBounds(189, 177, 137, 22);
		imgPanel.add(mainCourseLbl);
		
		// Listbox for Main Courses
		JList mainCourseList = new JList(mainCourseListModel);
		mainCourseList.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		mainCourseList.setBounds(25, 113, 176, 281);
		frame.getContentPane().add(mainCourseList);
		
		// Listbox for Side Dishes
		JList sideDishList = new JList(sideDishListModel);
		sideDishList.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		sideDishList.setBounds(802, 113, 176, 281);
		frame.getContentPane().add(sideDishList);
		
		// Labels for under listboxes
		JLabel mcLbl = new JLabel("Main Courses");
		mcLbl.setHorizontalAlignment(SwingConstants.CENTER);
		mcLbl.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		mcLbl.setBounds(25, 85, 176, 22);
		frame.getContentPane().add(mcLbl);
		
		JLabel sdLbl = new JLabel("Side Dishes");
		sdLbl.setHorizontalAlignment(SwingConstants.CENTER);
		sdLbl.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		sdLbl.setBounds(802, 85, 176, 22);
		frame.getContentPane().add(sdLbl);
		
		// The button to add a main course
		JButton mainCourseAddBtn = new JButton("Add");
		mainCourseAddBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Call method to add dish
				addDishToDay(mainCourseList.getSelectedValue().toString(), selectedListModel);
				
				// Call method to update Main Course label
				updateMainCourseLabel(mainCourseList.getSelectedValue().toString());
				
			}
		});
		mainCourseAddBtn.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		mainCourseAddBtn.setBackground(SystemColor.menu);
		mainCourseAddBtn.setBounds(69, 400, 80, 29);
		frame.getContentPane().add(mainCourseAddBtn);
		
		// The button to add a side dish
		JButton sideDishAddBtn = new JButton("Add");
		sideDishAddBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Call method to add dish
				addDishToDay(sideDishList.getSelectedValue().toString(), selectedListModel);
				
				// Call method to update Side Dish label
				updateSideDishLabel(sideDishList.getSelectedValue().toString());
			}
		});
		sideDishAddBtn.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		sideDishAddBtn.setBackground(SystemColor.menu);
		sideDishAddBtn.setBounds(853, 400, 80, 29);
		frame.getContentPane().add(sideDishAddBtn);
		
		// Sunday ListBox control
		JList sundayListBox = new JList(sunList);
		sundayListBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Call the method to set the selected listbox
				selectThisDay(sundayListBox);
				
				// Set selectedListModel
				selectedListModel = sunList;
			}
		});
		sundayListBox.setBorder(selectedBorder);
		sundayListBox.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		sundayListBox.setBounds(43, 479, 125, 150);
		frame.getContentPane().add(sundayListBox);
		
		// Monday ListBox control
		JList mondayListBox = new JList(monList);
		mondayListBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Call the method to set the selected listbox
				selectThisDay(mondayListBox);
				
				// Set selectedListModel
				selectedListModel = monList;
			}
		});
		mondayListBox.setBorder(normalBorder);
		mondayListBox.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		mondayListBox.setBounds(174, 479, 125, 150);
		frame.getContentPane().add(mondayListBox);
		
		// Tuesday ListBox control
		JList tuesdayListBox = new JList(tueList);
		tuesdayListBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Call the method to set the selected listbox
				selectThisDay(tuesdayListBox);
				
				// Set selectedListModel
				selectedListModel = tueList;
			}
		});
		tuesdayListBox.setBorder(normalBorder);
		tuesdayListBox.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		tuesdayListBox.setBounds(305, 479, 125, 150);
		frame.getContentPane().add(tuesdayListBox);
		
		// Wednesday ListBox control
		JList wednesdayListBox = new JList(wedList);
		wednesdayListBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Call the method to set the selected listbox
				selectThisDay(wednesdayListBox);
				
				// Set selectedListModel
				selectedListModel = wedList;
			}
		});
		wednesdayListBox.setBorder(normalBorder);
		wednesdayListBox.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		wednesdayListBox.setBounds(437, 479, 125, 150);
		frame.getContentPane().add(wednesdayListBox);
		
		// Thursday ListBox control
		JList thursdayListBox = new JList(thuList);
		thursdayListBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Call the method to set the selected listbox
				selectThisDay(thursdayListBox);
				
				// Set selectedListModel
				selectedListModel = thuList;
			}
		});
		thursdayListBox.setBorder(normalBorder);
		thursdayListBox.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		thursdayListBox.setBounds(568, 479, 125, 150);
		frame.getContentPane().add(thursdayListBox);
		
		// Friday ListBox control
		JList fridayListBox = new JList(friList);
		fridayListBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Call the method to set the selected listbox
				selectThisDay(fridayListBox);
				
				// Set selectedListModel
				selectedListModel = friList;
			}
		});
		fridayListBox.setBorder(normalBorder);
		fridayListBox.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		fridayListBox.setBounds(699, 479, 125, 150);
		frame.getContentPane().add(fridayListBox);
		
		// Saturday ListBox control
		JList saturdayListBox = new JList(satList);
		saturdayListBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Call the method to set the selected listbox
				selectThisDay(saturdayListBox);
				
				// Set selectedListModel
				selectedListModel = satList;
			}
		});
		saturdayListBox.setBorder(normalBorder);
		saturdayListBox.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		saturdayListBox.setBounds(830, 479, 125, 150);
		frame.getContentPane().add(saturdayListBox);
		
		// Sunday Label
		JLabel sundayLbl = new JLabel("Sunday");
		sundayLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Call the method to set the selected listbox
				selectThisDay(sundayListBox);
				
				// Set selectedListModel
				selectedListModel = sunList;
			}
		});
		sundayLbl.setHorizontalAlignment(SwingConstants.CENTER);
		sundayLbl.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		sundayLbl.setBounds(43, 459, 125, 22);
		frame.getContentPane().add(sundayLbl);
		
		// Monday Label
		JLabel lblMonday = new JLabel("Monday");
		lblMonday.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Call the method to set the selected listbox
				selectThisDay(mondayListBox);
				
				// Set selectedListModel
				selectedListModel = monList;
			}
		});
		lblMonday.setForeground(Color.BLACK);
		lblMonday.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonday.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		lblMonday.setBounds(174, 459, 125, 22);
		frame.getContentPane().add(lblMonday);
		
		// Tuesday Label
		JLabel lblTuesday = new JLabel("Tuesday");
		lblTuesday.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Call the method to set the selected listbox
				selectThisDay(tuesdayListBox);
				
				// Set selectedListModel
				selectedListModel = tueList;
			}
		});
		lblTuesday.setHorizontalAlignment(SwingConstants.CENTER);
		lblTuesday.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		lblTuesday.setBounds(305, 459, 125, 22);
		frame.getContentPane().add(lblTuesday);
		
		// Wednesday Label
		JLabel lblWednesday = new JLabel("Wednesday");
		lblWednesday.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Call the method to set the selected listbox
				selectThisDay(wednesdayListBox);
				
				// Set selectedListModel
				selectedListModel = wedList;
			}
		});
		lblWednesday.setHorizontalAlignment(SwingConstants.CENTER);
		lblWednesday.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		lblWednesday.setBounds(437, 459, 125, 22);
		frame.getContentPane().add(lblWednesday);
		
		// Thursday Label
		JLabel lblThursday = new JLabel("Thursday");
		lblThursday.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Call the method to set the selected listbox
				selectThisDay(thursdayListBox);
				
				// Set selectedListModel
				selectedListModel = thuList;
			}
		});
		lblThursday.setHorizontalAlignment(SwingConstants.CENTER);
		lblThursday.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		lblThursday.setBounds(568, 459, 125, 22);
		frame.getContentPane().add(lblThursday);
		
		// Friday Label
		JLabel lblFriday = new JLabel("Friday");
		lblFriday.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Call the method to set the selected listbox
				selectThisDay(fridayListBox);
				
				// Set selectedListModel
				selectedListModel = friList;
			}
		});
		lblFriday.setHorizontalAlignment(SwingConstants.CENTER);
		lblFriday.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		lblFriday.setBounds(699, 459, 125, 22);
		frame.getContentPane().add(lblFriday);
		
		// Saturday Label
		JLabel lblSaturday = new JLabel("Saturday");
		lblSaturday.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Call the method to set the selected listbox
				selectThisDay(saturdayListBox);
				
				// Set selectedListModel
				selectedListModel = satList;
			}
		});
		lblSaturday.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaturday.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		lblSaturday.setBounds(830, 459, 125, 22);
		frame.getContentPane().add(lblSaturday);
		
		// Save Meal Plan Button
		JButton saveMealPlanButton = new JButton("Save Meal Plan");
		saveMealPlanButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Call SaveMealPlan method
				saveMealPlan();
			}
		});
		saveMealPlanButton.setForeground(Color.BLACK);
		saveMealPlanButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		saveMealPlanButton.setBackground(SystemColor.menu);
		saveMealPlanButton.setBounds(405, 655, 215, 29);
		frame.getContentPane().add(saveMealPlanButton);
		
		// Set default selectedDay and selectedListModel
		selectedListModel = sunList;
		selectedDay = sundayListBox;
		
		// Main Menu button
		JButton mainMenuButton = new JButton("Main Menu");
		mainMenuButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Close the frame
				frame.dispose();
			}
		});
		mainMenuButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		mainMenuButton.setBackground(SystemColor.menu);
		mainMenuButton.setBounds(830, 750, 125, 29);
		frame.getContentPane().add(mainMenuButton);
	}
	
	// Method to set the selected day if the label or JListBox is clicked
	private void selectThisDay(JList thisBox) {
		
		// Reset previous border
		selectedDay.setBorder(normalBorder);
		
		// Reset dish graphic labels
		resetDishLabels();
		
		// Set the selectedDay list and change border
		selectedDay = thisBox;
		selectedDay.setBorder(selectedBorder);
		
		// Repaint frame
		frame.repaint();
		
	}
	
	// Method to add dish to selected day
	private void addDishToDay(String dish, DefaultListModel thisList) {
		
		// Add selected dish to selected listmodel
		thisList.add(thisList.getSize(), dish);
		
		// Repaint frame
		frame.repaint();
	}
	
	// Method to update Main Course label
	private void updateMainCourseLabel(String mc) {
		
		// Check to see if Main Course Label has been filled
		if (mainCourseLbl.getText() == "Main Course") {
			
			// Set text to Main Course text
			mainCourseLbl.setText(mc);
		}
	}
	
	// Method to update Side Dish labels
	private void updateSideDishLabel(String sd) {
		
		// Check to see if first Side Dish Label has been filled
		if (sideDishLbl1.getText() == "Side Dish") {
			
			// Set text to Side Dish text
			sideDishLbl1.setText(sd);
		}
		else {
			
			// Check to see if second Side Dish Label has been filled
			if (sideDishLbl2.getText() == "Side Dish") {
				
				// Set text to Side Dish text
				sideDishLbl2.setText(sd);
			}
		}
	}
	
	// Method to reset dish graphic labels
	private void resetDishLabels() {
		
		// Reset all three labels
		mainCourseLbl.setText("Main Course");
		sideDishLbl1.setText("Side Dish");
		sideDishLbl2.setText("Side Dish");
	}
	
	// Method to save the meal plan
	private void saveMealPlan() {
		
		// Variable to store current item
		Object current;
		
		// Get all items from listboxes
		// Loop through the day lists
		for (int i = 0; i < allDayLists.size(); i++) {
			
			// Loop through each item in list
			for (int j = 0; j < allDayLists.get(i).getSize(); j++) {
				
				// Set current item variable
				current = allDayLists.get(i).get(j);
				
				// Check to see if dish is a main course
				if (mainCourseListModel.contains(current)) {
					
					// Add it to the all main courses list
					allMainCourses.add(current.toString());
					
				} else {
					
					// Add it to the all side dishes list
					allSideDishes.add(current.toString());
				}
			}
		}
		
		// Add Meal Plan Saved labels to frame
		JLabel mealPlanSavedLabel = new JLabel("Meal Plan Saved!");
		mealPlanSavedLabel.setForeground(Color.RED);
		mealPlanSavedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mealPlanSavedLabel.setFont(new Font("Tw Cen MT", Font.ITALIC, 16));
		mealPlanSavedLabel.setBounds(410, 690, 215, 22);
		frame.getContentPane().add(mealPlanSavedLabel);
		
		JLabel groceryListLabel = new JLabel("Go to the Main Menu to view your Grocery List");
		groceryListLabel.setForeground(Color.RED);
		groceryListLabel.setHorizontalAlignment(SwingConstants.CENTER);
		groceryListLabel.setFont(new Font("Tw Cen MT", Font.ITALIC, 16));
		groceryListLabel.setBounds(375, 715, 300, 22);
		frame.getContentPane().add(groceryListLabel);
		
		// Repaint the frame
		frame.repaint();
	}
}
