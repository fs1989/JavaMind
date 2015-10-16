package com.fs;

import java.io.File;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;

public class Shell extends org.eclipse.swt.widgets.Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			Shell shell = new Shell(display);
			shell.open();
			shell.layout();
			
			
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	/**
	 * Create the shell.
	 * @param display
	 */
	public Shell(Display display) {
		super(display, SWT.SHELL_TRIM | SWT.PRIMARY_MODAL | SWT.BORDER);
//		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridLayout layout = new GridLayout(2, false);
		setLayout(layout);
		
		
		Button btnNewApp = new Button(this, SWT.NONE);
//		Label labelSeparator = new Label(this, SWT.SEPARATOR | SWT.VERTICAL);
		Label labelUserList = new Label(this, SWT.NONE);
		List list = new List(this, SWT.NONE);
		Text textResult = new Text(this, SWT.NONE);
		Button btnUpdate = new Button(this, SWT.NONE);
		Label lableStatus = new Label(this, SWT.NONE);
		
		GridData gd_text = new GridData(GridData.FILL_BOTH);
		gd_text.widthHint = 300;
		textResult.setLayoutData(gd_text);
		
		btnNewApp.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false));
//		labelSeparator.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 2));
		list.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		labelUserList.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		btnUpdate.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		lableStatus.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		
		list.add("Petrel");
		list.add("Techlog");
		list.add("ArcGIS");
		list.add("EDM");
		
		labelUserList.setText("Application User List");
		
		StringBuffer sb = new StringBuffer();
		sb.append("123" + "\n");
		sb.append("123" + "\n");
		System.out.println(sb.toString());
		textResult.setText(sb.toString());
		lableStatus.setText(sb.toString());
		
		btnNewApp.setText("Add New Applicaiton");
		new Label(this, SWT.NONE);
		btnNewApp.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		
		btnUpdate.setText("Update User List");
		new Label(this, SWT.NONE);
		btnUpdate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});

		list.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				File file = new File("C:\\apps\\UserList\\result-" + list.getSelection() + ".csv");
				
				textResult.setText(string);
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SSW Application Support");
		setSize(800, 600);
		
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
