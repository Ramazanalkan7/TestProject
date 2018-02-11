package com.example.myapplication;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.ClientConnector.AttachEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
public class MyUI extends UI {

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		final VerticalLayout layout = new VerticalLayout();
		

		MenuBar barmenu = new MenuBar();
	
		layout.addComponent(barmenu);

		final Label selection = new Label("-");
		layout.addComponent(selection);
		MenuBar.Command mycommand = new MenuBar.Command() {
			private static final long serialVersionUID = 4483012525105015694L;

			public void menuSelected(MenuItem selectedItem) {
				selection.setValue("Ordered a " + selectedItem.getText() + " from menu.");
			}
		};
	
		MenuBar.MenuItem anasayfa = barmenu.addItem("Anasayfa", mycommand);
		MenuBar.MenuItem galeri = barmenu.addItem("Galeri", null);
		galeri.addItem("Hayvanlar", mycommand);
		galeri.addItem("Manzara", mycommand);
		MenuBar.MenuItem hakkimizda = barmenu.addItem("Hakkımızda", mycommand);
		MenuBar.MenuItem iletisim = barmenu.addItem("İletişim", mycommand);
		
		HorizontalLayout hr = new HorizontalLayout();
		layout.addComponent(hr);

		VerticalLayout vl = new VerticalLayout();
		hr.addComponent(vl);
		
		Label lbl = new Label("ad");
		vl.addComponent(lbl);
		Label soyad = new Label("Soyad");
		vl.addComponent(soyad);
		
		VerticalLayout vl1 = new VerticalLayout();
		hr.addComponent(vl1);
		
		TextField ad = new TextField();
		vl1.addComponent(ad);
		
		TextField soyadtext = new TextField();
		vl1.addComponent(soyadtext);
		
		VerticalLayout vl2 = new VerticalLayout();
		
		Button btnbas = new Button("selam");
		vl2.addComponent(btnbas);
		
		
		
	
		
		
		
		Button btn = new Button("Tıkla bana");
		hr.addComponent(btn);
		btn.addAttachListener(new AttachListener() {
			
			@Override
			public void attach(AttachEvent event) {
				
			
				
			}
		});
		
		final TextField name = new TextField();
		name.setCaption("Type your name here:");
		

	Button button = new Button("Click Me");button.addClickListener(e->
	{
		layout.addComponent(new Label("Thanks " + name.getValue() + ", it works!"));
	});

	layout.addComponents(name,button);layout.setMargin(true);layout.setSpacing(true);

	setContent(layout);
	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}
}
