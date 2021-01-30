package com.cognateapps.entity.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString; 

@Entity
@Table(name = "order")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Order implements Serializable {

	private static final long serialVersionUID = 3443328912867463209L;

	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer orderId;
	
	@Column(name = "order_Name")
	private String orderName;
}
