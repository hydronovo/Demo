package com.example.hibernate;

import java.util.ArrayList;

public class Node {

	private long				id;
	private ArrayList<Integer>	attrTypes	= new ArrayList<Integer>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ArrayList<Integer> getAttrTypes() {
		return attrTypes;
	}

	public void setAttrTypes(ArrayList<Integer> attrTypes) {
		this.attrTypes = attrTypes;
	}
}
