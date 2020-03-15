/*
 * Copyright 2009-2015 PrimeTek.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.base.ultima.view.data;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
//import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import br.com.base.ultima.domain.Car;
import br.com.base.ultima.service.CarService;

@Named
@ViewScoped
//@SessionScoped
public class DataGridView implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Car> cars;

	private Car selectedCar;

	@Inject
	private CarService service;

	@PostConstruct
	public void init() {
//        System.out.println("Debug: DataGridView.init()");
		cars = service.createCars(45);
	}

	@PreDestroy
	public void destroy() {
//        System.out.println("Debug: DataGridView.destroy()");
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setService(CarService service) {
		this.service = service;
	}

	public Car getSelectedCar() {
		return selectedCar;
	}

	public void setSelectedCar(Car selectedCar) {
		this.selectedCar = selectedCar;
	}
}
