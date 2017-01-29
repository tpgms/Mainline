package main.java;
import java.util.ArrayList;
import java.util.Scanner;

public class RPNCalculator {
	
	private String rpnExpression;
	private String[] rpnSplitArray;
	
	public String getRpnExpression() {
		return rpnExpression;
	}

	public void setRpnExpression(String rpnExpression) {
		this.rpnExpression = rpnExpression;
	}  

	public String[] getRpnSplitArray() {
		return rpnSplitArray;
	}

	public void setRpnSplitArray(String rpnExpression) {
		this.rpnSplitArray = rpnExpression.split(",");
	}

	public String calculateSum(String rpnExpression) {

		setRpnExpression(rpnExpression);
		setRpnSplitArray(rpnExpression);
		
		if(isValidRPN()){
			return add();

		}else{
			return "false";
		}
		
	}
	
	public String add() {		
		ArrayList rpnSplitAL = new ArrayList();
		int countExp = 0;
		
		for(int i=0; i< rpnSplitArray.length; i++){
			rpnSplitAL.add(rpnSplitArray[i]);
			if(rpnSplitAL.get(i).toString().equalsIgnoreCase("+")){
				countExp++;
			}
		}
		
		for(int j=0;j<countExp;j++){
			for(int i=0; i< rpnSplitAL.size(); i++){
				int sum = 0;
				if(rpnSplitAL.get(i).toString().equalsIgnoreCase("+")){
					sum = Integer.parseInt(rpnSplitAL.get(i-1).toString()) 
							+ Integer.parseInt(rpnSplitAL.get(i-2).toString());
					
					rpnSplitAL.remove(i);
					rpnSplitAL.remove(i-1);
					rpnSplitAL.remove(i-2);
					
					rpnSplitAL.add(i-2, sum);
				}
			}
		}
		
		
		return (rpnSplitAL.get(0).toString());
	}

	private boolean isValidRPN() {
		boolean validate = true;
		
		for(int i =0; i<rpnSplitArray.length; i++){
			if(!(rpnSplitArray[i].matches("^-?\\d+$")) ){
				System.out.println("not number" + rpnSplitArray[i]);
				if(!(rpnSplitArray[i].equalsIgnoreCase("+"))){
					System.out.println("not +" + rpnSplitArray[i]);
					return false;
				}
			}
		}
		
		return validate;
	}

}
