package mod;

import java.util.ArrayList;

public class Overseer {
	
	//These are the instance variables for the class
	private ArrayList<String> results = new ArrayList<String>();
	private int counter = 0;
	
	//This is the constructor which sends a welcome message to the user
	public Overseer() {
		Msg.msg("WELCOME TO MATH GENERATOR!");
		options();
	}
	
	
	//this is the method that holds the different options the user can pick from (how many problems to solve and the type of problems they want to solve)
	public void options() {
		String s = Msg.in("How many questions would you like to answer? \n(input a number)");
		int totAmt = Integer.parseInt(s);
		String[] options = {"addition", "subtraction", "multiplication", "division", "add/sub", "multi/div", "all randomized", "mixed", "exit"};
		int opts = Msg.opt(options, "What type of problems would you like to solve:", "MATH GENERATOR");
		if (opts == 0) {
			additionOpt(totAmt);
		}
		else if (opts == 1) {
			subtractionOpt(totAmt);
		}
		else if (opts == 2) {
			multiplicationOpt(totAmt);
		}
		else if (opts == 3) {
			divisionOpt(totAmt);
		}
		else if (opts == 4) {
			addAndSubOpt(totAmt);
		}
		else if (opts == 5) {
			multiAndDivOpt(totAmt);
		}
		else if (opts == 6) {
			allProbOpt(totAmt);
		}
		else if (opts == 7) {
			mixedOpt(totAmt);
		}
		else if (opts == 8) {
			Msg.msg("THANK YOU FOR PLAYING MATH GENERATOR");
		}
	}
	
	//This method is used for all the addition problems
	public void additionOpt(int totAmt) {
		int cnt = 1;
		int corCnt = 0;
		int[] userA = new int[totAmt];
		int[] corA = new int[totAmt];
		String[] questions = new String[totAmt];
		int ind = 0;
		while (cnt <= totAmt) {
			int num1 = (int) (100 * Math.random());
			int num2 = (int) (100 * Math.random());
			String s = Msg.in("Question: " + cnt + "\n\n What is the answer to the equation: \n\n        " + num1 + " + " + num2 + " =");
			int user = Integer.parseInt(s);
			int correct = add(num1, num2);
			if (check(user, correct)) {
				corCnt++;
			}
			userA[ind] = user;
			corA[ind] = correct;
			questions[ind] = num1 + " + " + num2;
			ind++;
			cnt++;
		}
		Msg.msg("YOU HAVE FINISHED!! \nclick 'OK' to view your results");
		results(userA, corA, questions, corCnt, totAmt);
		
	}
	
	//This method is used for all the subtraction problems
	public void subtractionOpt(int totAmt) {
		int cnt = 1;
		int corCnt = 0;
		int[] userA = new int[totAmt];
		int[] corA = new int[totAmt];
		String[] questions = new String[totAmt];
		int ind = 0;
		while (cnt <= totAmt) {
			int num1 = (int) (100 * Math.random());
			int num2 = 1001; 
			while (num2 > num1) {
				num2 = (int) (100 * Math.random());
			}
			String s = Msg.in("Question: " + cnt + "\n\n What is the answer to the equation: \n\n        " + num1 + " - " + num2 + " =");
			int user = Integer.parseInt(s);
			int correct = sub(num1, num2);
			if (check(user, correct)) {
				corCnt++;
			}
			userA[ind] = user;
			corA[ind] = correct;
			questions[ind] = num1 + " - " + num2;
			ind++;
			cnt++;
		}
		Msg.msg("YOU HAVE FINISHED!! \nclick 'OK' to view your results");
		results(userA, corA, questions, corCnt, totAmt);
		
	}
	
	//This method is used for all the multiplication problems
	public void multiplicationOpt(int totAmt) {
		int cnt = 1;
		int corCnt = 0;
		int[] userA = new int[totAmt];
		int[] corA = new int[totAmt];
		String[] questions = new String[totAmt];
		int ind = 0;
		while (cnt <= totAmt) {
			int num1 = (int) (100 * Math.random());
			int num2 = (int) (100 * Math.random());
			String s = Msg.in("Question: " + cnt + "\n\n What is the answer to the equation: \n\n        " + num1 + " x " + num2 + " =");
			int user = Integer.parseInt(s);
			int correct = multiply(num1, num2);
			if (check(user, correct)) {
				corCnt++;
			}
			userA[ind] = user;
			corA[ind] = correct;
			questions[ind] = num1 + " x " + num2;
			ind++;
			cnt++;
		}
		Msg.msg("YOU HAVE FINISHED!! \nclick 'OK' to view your results");
		results(userA, corA, questions, corCnt, totAmt);
		
	}
	
	//This method is used for all the division problems
	public void divisionOpt(int totAmt) {
		int cnt = 1;
		int corCnt = 0;
		int[] userA = new int[totAmt];
		int[] corA = new int[totAmt];
		String[] questions = new String[totAmt];
		int ind = 0;
		while (cnt <= totAmt) {
			int num1 = (int) (100 * Math.random());
			int num2 = (int) (100 * Math.random());
			while (num2 == 0 || num1 % num2 != 0) {
				num2 = (int) (100 * Math.random());
			}
			String s = Msg.in("Question: " + cnt + "\n\n What is the answer to the equation: \n\n        " + num1 + " / " + num2 + " =");
			int user = Integer.parseInt(s);
			int correct = divide(num1, num2);
			if (check(user, correct)) {
				corCnt++;
			}
			userA[ind] = user;
			corA[ind] = correct;
			questions[ind] = num1 + " / " + num2;
			ind++;
			cnt++;
		}
		Msg.msg("YOU HAVE FINISHED!! \nclick 'OK' to view your results");
		results(userA, corA, questions, corCnt, totAmt);
		
	}
	
	//This method is used for a random mixture of addition and subtraction problems
	public void addAndSubOpt(int totAmt) {
		int cnt = 1;
		int corCnt = 0;
		int[] userA = new int[totAmt];
		int[] corA = new int[totAmt];
		String[] questions = new String[totAmt];
		int ind = 0;
		while (cnt <= totAmt) {
			int num1 = (int) (100 * Math.random());
			int num2 = 1001; 
			while (num2 > num1) {
				num2 = (int) (100 * Math.random());
			}
			int x = (int) (100 * Math.random());
			if (x > 50) {
				String s = Msg.in("Question: " + cnt + "\n\n What is the answer to the equation: \n\n        " + num1 + " - " + num2 + " =");
				int user = Integer.parseInt(s);
				int correct = sub(num1, num2);
				if (check(user, correct)) {
					corCnt++;
				}
				userA[ind] = user;
				corA[ind] = correct;
				questions[ind] = num1 + " - " + num2;
				ind++;
				cnt++;
			}
			else {
				String s = Msg.in("Question: " + cnt + "\n\n What is the answer to the equation: \n\n        " + num1 + " + " + num2 + " =");
				int user = Integer.parseInt(s);
				int correct = add(num1, num2);
				if (check(user, correct)) {
					corCnt++;
				}
				userA[ind] = user;
				corA[ind] = correct;
				questions[ind] = num1 + " + " + num2;
				ind++;
				cnt++;
			}
		}
		Msg.msg("YOU HAVE FINISHED!! \nclick 'OK' to view your results");
		results(userA, corA, questions, corCnt, totAmt);
	}
	
	//This method is used for a random mixture of multiplication and division problems
	public void multiAndDivOpt(int totAmt) {
		int cnt = 1;
		int corCnt = 0;
		int[] userA = new int[totAmt];
		int[] corA = new int[totAmt];
		String[] questions = new String[totAmt];
		int ind = 0;
		while (cnt <= totAmt) {
			int num1 = (int) (100 * Math.random());
			int num2 = (int) (100 * Math.random());
			int x = (int) (100 * Math.random());
			if (x > 50) {
				while (num2 == 0 || num1 % num2 != 0) {
					num2 = (int) (100 * Math.random());
				}
				String s = Msg.in("Question: " + cnt + "\n\n What is the answer to the equation: \n\n        " + num1 + " / " + num2 + " =");
				int user = Integer.parseInt(s);
				int correct = divide(num1, num2);
				if (check(user, correct)) {
					corCnt++;
				}
				userA[ind] = user;
				corA[ind] = correct;
				questions[ind] = num1 + " / " + num2;
				ind++;
				cnt++;
			}
			else {
				String s = Msg.in("Question: " + cnt + "\n\n What is the answer to the equation: \n\n        " + num1 + " x " + num2 + " =");
				int user = Integer.parseInt(s);
				int correct = multiply(num1, num2);
				if (check(user, correct)) {
					corCnt++;
				}
				userA[ind] = user;
				corA[ind] = correct;
				questions[ind] = num1 + " x " + num2;
				ind++;
				cnt++;
			}
		}
		Msg.msg("YOU HAVE FINISHED!! \nclick 'OK' to view your results");
		results(userA, corA, questions, corCnt, totAmt);
		
	}
	
	//This method is used for a random mixture of all 4 types of problems
	public void allProbOpt(int totAmt) {
		int cnt = 1;
		int corCnt = 0;
		int[] userA = new int[totAmt];
		int[] corA = new int[totAmt];
		String[] questions = new String[totAmt];
		int ind = 0;
		while (cnt <= totAmt) {
			int x = (int) (100 * Math.random());
			if (x < 24) {
				int num1 = (int) (100 * Math.random());
				int num2 = (int) (100 * Math.random());
				String s = Msg.in("Question: " + cnt + "\n\n What is the answer to the equation: \n\n        " + num1 + " + " + num2 + " =");
				int user = Integer.parseInt(s);
				int correct = add(num1, num2);
				if (check(user, correct)) {
					corCnt++;
				}
				userA[ind] = user;
				corA[ind] = correct;
				questions[ind] = num1 + " + " + num2;
				ind++;
				cnt++;
			}
			else if (x < 50) {
				int num1 = (int) (100 * Math.random());
				int num2 = 1001; 
				while (num2 > num1) {
					num2 = (int) (100 * Math.random());
				}
				String s = Msg.in("Question: " + cnt + "\n\n What is the answer to the equation: \n\n        " + num1 + " - " + num2 + " =");
				int user = Integer.parseInt(s);
				int correct = sub(num1, num2);
				if (check(user, correct)) {
					corCnt++;
				}
				userA[ind] = user;
				corA[ind] = correct;
				questions[ind] = num1 + " - " + num2;
				ind++;
				cnt++;
			}
			else if (x < 75) {
				int num1 = (int) (100 * Math.random());
				int num2 = (int) (100 * Math.random());
				String s = Msg.in("Question: " + cnt + "\n\n What is the answer to the equation: \n\n        " + num1 + " x " + num2 + " =");
				int user = Integer.parseInt(s);
				int correct = multiply(num1, num2);
				if (check(user, correct)) {
					corCnt++;
				}
				userA[ind] = user;
				corA[ind] = correct;
				questions[ind] = num1 + " x " + num2;
				ind++;
				cnt++;
			}
			else  {
				int num1 = (int) (100 * Math.random());
				int num2 = (int) (100 * Math.random());
				while (num2 == 0 || num1 % num2 != 0) {
					num2 = (int) (100 * Math.random());
				}
				String s = Msg.in("Question: " + cnt + "\n\n What is the answer to the equation: \n\n        " + num1 + " / " + num2 + " =");
				int user = Integer.parseInt(s);
				int correct = divide(num1, num2);
				if (check(user, correct)) {
					corCnt++;
				}
				userA[ind] = user;
				corA[ind] = correct;
				questions[ind] = num1 + " / " + num2;
				ind++;
				cnt++;
			}
		}
		Msg.msg("YOU HAVE FINISHED!! \nclick 'OK' to view your results");
		results(userA, corA, questions, corCnt, totAmt);
		
	}
	
	////This method is used for a random mixture of combined expressions (expressions that contain more than just addition or just division, etc..)
	public void mixedOpt(int totAmt) {
		int cnt = 1;
		int corCnt = 0;
		int[] userA = new int[totAmt];
		int[] corA = new int[totAmt];
		String[] questions = new String[totAmt];
		int ind = 0;
		while (cnt <= totAmt) {
			int x = (int) (100 * Math.random());
			if (x < 20) {
				int num1 = (int) (100 * Math.random());
				int num2 = (int) (100 * Math.random());
				int num3 = (int) (100 * Math.random());
				String s = Msg.in("Question: " + cnt + "\n\n What is the answer to the equation: \n\n        (" + num1 + " x " + num2 + ") + " + num3 + " = ");
				int user = Integer.parseInt(s);
				int c = multiply(num1, num2);
				int correct = c + num3;
				if (check(user, correct)) {
					corCnt++;
				}
				userA[ind] = user;
				corA[ind] = correct;
				questions[ind] = "(" + num1 + " x " + num2 + ") + " + num3;
				ind++;
				cnt++;
			}
			else if (x < 40) {
				int num1 = (int) (100 * Math.random());
				int num2 = (int) (100 * Math.random());
				int num3 = (int) (100 * Math.random());
				String s = Msg.in("Question: " + cnt + "\n\n What is the answer to the equation: \n\n        " + num3 + "(" + num1 + " + " + num2 + ") = ");
				int user = Integer.parseInt(s);
				int c = add(num1, num2);
				int correct = c * num3;
				if (check(user, correct)) {
					corCnt++;
				}
				userA[ind] = user;
				corA[ind] = correct;
				questions[ind] = num3 + "(" + num1 + " + " + num2 + ")";
				ind++;
				cnt++;
			}
			else if (x < 60) {
				int num1 = (int) (100 * Math.random());
				int num2 = (int) (100 * Math.random()); 
				while (num2 > num1) {
					num2 = (int) (100 * Math.random());
				}
				int num3 = (int) (100 * Math.random());
				String s = Msg.in("Question: " + cnt + "\n\n What is the answer to the equation: \n\n        " + num3 + "(" + num1 + " - " + num2 + ") = ");
				int user = Integer.parseInt(s);
				int c = sub(num1, num2);
				int correct = c * num3;
				if (check(user, correct)) {
					corCnt++;
				}
				userA[ind] = user;
				corA[ind] = correct;
				questions[ind] = num3 + "(" + num1 + " - " + num2 + ")";
				ind++;
				cnt++;
			}
			else if (x < 80){
				int num1 = (int) (100 * Math.random());
				int num2 = (int) (100 * Math.random()); 
				while (num2 > num1) {
					num2 = (int) (100 * Math.random());
				}
				int c = sub(num1, num2);
				int num3 = (int) (100 * Math.random());
			
				while (num3 == 0 || c % num3 != 0) {
					num3 = (int) (100 * Math.random());
				}
				
				String s = Msg.in("Question: " + cnt + "\n\n What is the answer to the equation: \n\n        (" + num1 + " - " + num2 + ") / " + num3 + " = ");
				int user = Integer.parseInt(s);
				int correct = c / num3;
				if (check(user, correct)) {
					corCnt++;
				}
				userA[ind] = user;
				corA[ind] = correct;
				questions[ind] = "(" + num1 + " - " + num2 + ") / " + num3;
				ind++;
				cnt++;
			}
			else {
				int num1 = (int) (100 * Math.random());
				int num2 = (int) (100 * Math.random());
				while (num2 == 0 || num1 % num2 != 0) {
					num2 = (int) (100 * Math.random());
				}
				int num3 = (int) (100 * Math.random());
				String s = Msg.in("Question: " + cnt + "\n\n What is the answer to the equation: \n\n        (" + num1 + " / " + num2 + ") + " + num3 + " = ");
				int user = Integer.parseInt(s);
				int c = divide(num1, num2);
				int correct = c + num3;
				if (check(user, correct)) {
					corCnt++;
				}
				userA[ind] = user;
				corA[ind] = correct;
				questions[ind] = "(" + num1 + " / " + num2 + ") + " + num3;
				ind++;
				cnt++;
			}
		}
		Msg.msg("YOU HAVE FINISHED!! \nclick 'OK' to view your results");
		results(userA, corA, questions, corCnt, totAmt);
		
	}
	
	
	
	//These are methods that take in their two parameters and adds, subtracts, multiplies, or divides them (each method is labeled accordingly)
	public int add(int num1, int num2) {return num1 + num2;}
	public int sub(int num1, int num2) {return num1 - num2;}
	public int multiply(int num1, int num2) {return num1 * num2;}
	public int divide(int num1, int num2) {return num1 / num2;}
	
	//this method is used to check whether the two parameters are equal
	public boolean check(int userA, int correctA) {
		if (userA == correctA) {
			return true;
		}
		return false;
	}
	
	
	//this method is used to show the user their results for the questions they answered
	public void results(int[] userA, int[] corA, String[] questions, int corCnt, int totAmt) {
		int incorCnt = totAmt - corCnt;
		String RESULTS = "";
		RESULTS += "Your Results: \n\n";
		int cnt = 1;
		for (int i = 0; i < totAmt; i++) {
			RESULTS += "Question " + cnt + ": " + questions[i] + " = "+ corA[i] + "\n";
			RESULTS += "      your answer: " + userA[i] + "\n\n";
			cnt++;
		}
		double percent = 100.0 * corCnt / totAmt;
		RESULTS += "answers correct: " + corCnt + "\n";
		RESULTS += "answers incorrect: " + incorCnt + "\n";
		RESULTS += "percentage correct: " + percent + "% \n\n";
		counter++;
		results.add("Attempt " + counter + ": " + corCnt + "/" + totAmt + "  ("+ percent +"%)");
		
		
		Msg.msg(RESULTS + "click 'OK' to continue:");
		nextPg();
	}
	
	//this method is used to let the user choose what they would like to do after they finish answering the questions
	public void nextPg() {
		String[] options = {"try again", "see previous results", "exit"};
		int opts = Msg.opt(options, "What would you like do to next?", "MATH GENERATOR");
		if (opts == 0) {
			options();
		}
		else if (opts == 1) {
			String RESULTS = "";
			for (int i = 0; i < results.size(); i++) {
				RESULTS += results.get(i) + "\n\n";
				
			}
			Msg.msg(RESULTS);
			nextPg();
		}
		else if (opts == 2) {
			Msg.msg("THANK YOU FOR PLAYING MATH GENERATOR");
		}
	}
	
	//this method is used to show the user their results for the previous math problems they answered
	public void prevResults() {
		String RESULTS = "";
	for (int i = 0; i < results.size(); i++) {
		RESULTS += results.get(i) + "\n\n";
		
	}
	Msg.msg(RESULTS);
	nextPg();
		
	}
}