package com.scry.assignment.model;

public enum Halls {
	A("A", 50), B("B", 100), C("C", 200), D("D", 350), E("E", 500), F("F", 1000);

	private final String name;
	private final int capacity;

	Halls(final String name, final int capacity) {
		this.name = name;
		this.capacity = capacity;
	}

	public String getName() {
		return name;
	}

	public int getCapacity() {
		return capacity;
	}

}