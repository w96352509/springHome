package com.spring.core.session03.beans;

import org.springframework.beans.factory.FactoryBean;

public class CarFactory implements FactoryBean<Car>  {

	@Override
	public Car getObject() throws Exception {
		
		return new Car();
	}

	@Override
	public Class<?> getObjectType() {
		
		return Car.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

}
