package ru.aston.khramov_vo.task_1;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@AllArgsConstructor
public class City {
	private String name;
	private Long users = 0L;

	@Override
	public String toString() {
		return "name= " + name + " users= " + users;
	}
}
