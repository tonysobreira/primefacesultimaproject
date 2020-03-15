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
package br.com.base.ultima.view.data.datatable;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
//import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import br.com.base.ultima.domain.Car;
import br.com.base.ultima.service.CarService;

@Named("dtSelectionView")
@ViewScoped
//@SessionScoped
public class SelectionView implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Car> cars1;
	private List<Car> cars2;
	private Car selectedCar;

	@Inject
	private CarService carService;

	@PostConstruct
	public void init() {
		cars1 = carService.createCars(50);
		cars2 = carService.createCars(10);
	}

	public List<Car> getCars1() {
		return cars1;
	}

	public void setService(CarService service) {
		this.carService = service;
	}

	public List<Car> getCars2() {
		return cars2;
	}

	public void setCars2(List<Car> cars2) {
		this.cars2 = cars2;
	}

	public Car getSelectedCar() {
		return selectedCar;
	}

	public void setSelectedCar(Car selectedCar) {
		this.selectedCar = selectedCar;
	}

	public void onRowSelect(SelectEvent event) {
		FacesMessage msg = new FacesMessage("Car Selected", ((Car) event.getObject()).getId());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowUnselect(UnselectEvent event) {
		FacesMessage msg = new FacesMessage("Car Unselected", ((Car) event.getObject()).getId());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}
