package controllers;

import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Button;
import org.zkoss.zul.Window;

public class IndexController extends SelectorComposer<Window> {

	private static final long serialVersionUID = 1L;
	@Wire
	Textbox txtNuevaTarea;
	@Wire
	Listbox lbTareas;

	@Listen(Events.ON_CLICK +"=#btnAgregarTarea")
	public void agregarTarea(){
		if(txtNuevaTarea.getValue().trim().isEmpty()) {
			Clients.showNotification("El campo Tarea no puede estar vacio");
			return;
		}
		Listitem item = new Listitem();
		
		Listcell cellTarea = new Listcell();
		Textbox txtTarea = new Textbox();
		txtTarea.setInplace(true);
		txtTarea.setDisabled(true);
		txtTarea.setWidth("100%");
		txtTarea.setValue(txtNuevaTarea.getValue());
		txtTarea.setParent(cellTarea);
		cellTarea.setParent(item);
		
		Listcell cellBtnModificar = new Listcell();
		Button btnModificar = new Button("Modificar");
		btnModificar.setClass("btn btn-warning");
		btnModificar.setParent(cellBtnModificar);
		cellBtnModificar.setParent(item);
		
		Listcell cellBtnEliminar = new Listcell();
		Button btnEliminar = new Button("Eliminar");
		btnEliminar.setClass("btn btn-danger");
		btnEliminar.setParent(cellBtnEliminar);
		cellBtnEliminar.setParent(item);
		
		item.setParent(lbTareas);
		
	}
}
