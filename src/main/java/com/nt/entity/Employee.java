package com.nt.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="new_employee_tab")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Employee {
	
	@Id
	@SequenceGenerator(name="gen1", sequenceName = "seq_gen", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.AUTO)
	@Column(name = "eno")
	private Integer eno;
	@Nonnull
	@Column(name = "deptno")
	private Integer deptno;
	@Nonnull
	@Column(name = "ename")
	private String ename;
	@Nonnull
	@Column(name = "salary")
	private Double salary;
	
}
