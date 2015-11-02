package com.fs;

import java.io.BufferedReader;
import java.io.FileReader;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class MainShell extends org.eclipse.swt.widgets.Shell {

	static Shell shell;
	Button btnNewApp = new Button(this, SWT.NONE);
	Label labelUserList = new Label(this, SWT.NONE);
	List list = new List(this, SWT.NONE);
	Text textResult = new Text(this, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
	Button btnUpdate = new Button(this, SWT.NONE);
	Label lableStatus = new Label(this, SWT.NONE);

	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			shell = new MainShell(display);
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

	public MainShell(Display display) {
		super(display, SWT.SHELL_TRIM | SWT.PRIMARY_MODAL | SWT.BORDER);
		// setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridLayout layout = new GridLayout(2, false);
		setLayout(layout);

		GridData gd_text = new GridData(GridData.FILL_BOTH);
		gd_text.widthHint = 10;
		gd_text.heightHint = 60;
		textResult.setLayoutData(gd_text);

		btnNewApp.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false));
		list.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		labelUserList.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		btnUpdate.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		lableStatus.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

		list.add("Petrel");
		list.add("Techlog");
		list.add("ArcGIS");
		list.add("EDM");

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
				Find find = new Find(shell);

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
				String fileName = "C:\\apps\\UserList\\000result-" + list.getSelection()[0] + ".csv";
				textResult.setText(getFileString(fileName));
				labelUserList.setText(list.getSelection()[0] + " User List");

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

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

	String getFileString(String fileName) {
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();
		try {
			br = new BufferedReader(new FileReader(fileName));
			String tempString;
			while ((tempString = br.readLine()) != null) {
				sb.append(tempString + "\r\n");
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("getFileString√ª”–÷¥––");
		}

		return sb.toString();
	}

}
