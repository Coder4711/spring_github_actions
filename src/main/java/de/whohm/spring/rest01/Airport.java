package de.whohm.spring.rest01;

import javax.validation.constraints.Min;

import org.springframework.lang.NonNull;

public class Airport {
	
	@NonNull
	private Integer id;
	
	@Min(10)
	private String name;

	public Airport() {
	}

	public Airport(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Airport [id=" + id + ", name=" + name + "]";
	}

}
