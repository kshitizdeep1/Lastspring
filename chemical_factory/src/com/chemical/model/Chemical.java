package com.chemical.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Chemical {

	@Id
	private Double atomicWeight;
	private String chemicalName;	
	private String chemicalSymbol;
	public Double getAtomicWeight() {
		return atomicWeight;
	}
	public void setAtomicWeight(Double atomicWeight) {
		this.atomicWeight = atomicWeight;
	}
	public String getChemicalName() {
		return chemicalName;
	}
	public void setChemicalName(String chemicalName) {
		this.chemicalName = chemicalName;
	}
	public String getChemicalSymbol() {
		return chemicalSymbol;
	}
	public void setChemicalSymbol(String chemicalSymbol) {
		this.chemicalSymbol = chemicalSymbol;
	}
	public Chemical(double atomicWeight, String chemicalName, String chemicalSymbol) {
		super();
		this.atomicWeight = atomicWeight;
		this.chemicalName = chemicalName;
		this.chemicalSymbol = chemicalSymbol;
	}
	public Chemical() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

