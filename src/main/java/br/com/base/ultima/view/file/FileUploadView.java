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
package br.com.base.ultima.view.file;

import java.io.Serializable;

//import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@Named
@ViewScoped
//@SessionScoped
public class FileUploadView implements Serializable {
	private static final long serialVersionUID = 1L;

	private UploadedFile file;

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public void upload() {
		if (file != null) {
			FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public void handleFileUpload(FileUploadEvent event) {
		FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}
