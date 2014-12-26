package pl.iui.ui.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Utils used in user interface
 * 
 */

public class UiUtils implements Serializable {
	private static final long serialVersionUID = 1L;
	
	 private ArrayList<String> years=new ArrayList<String>(); 
	 
	 private ArrayList<String> rates=new ArrayList<String>();
	 
	 public UiUtils (){
		 for(int i=1900;i<1995;i++){
			 years.add(Integer.toString(i));
			 //System.out.println(years.get(i-1900));
		 }
		 
		 
		for(int i=1;i<=6;i++){
			rates.add(Integer.toString(i));
			System.out.println(i);
		}
	 }

	public ArrayList<String> getYears() {
		return years;
	}

	public void setYears(ArrayList<String> years) {
		this.years = years;
	}

	public ArrayList<String> getRates() {
		return rates;
	}

	public void setRates(ArrayList<String> rates) {
		this.rates = rates;
	}

}
