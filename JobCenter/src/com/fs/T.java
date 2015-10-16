package com.fs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class T {
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Find (GridLayout)");
		
		Label label = new Label(shell, SWT.NONE);
			label.setText("Find what:");
		
		Text text = new Text(shell, SWT.BORDER);
		
		Button findButton = new Button(shell, SWT.PUSH);
		findButton.setText("Find Next");
		
		Group group = new Group(shell, SWT.NONE);
			group.setLayout(new RowLayout());
			group.setText("Direction");
		
		Button upButton = new Button(group, SWT.RADIO);
		Button downButton = new Button(group, SWT.RADIO);
			upButton.setText("Up");
			downButton.setText("Down");
			downButton.setSelection(true);
			
		
		Button cancelButton = new Button(shell, SWT.PUSH);
			cancelButton.setText("Cancel");
			
		/* Use a GridLayout to position the controls */
		
		
		GridLayout layout = new GridLayout(3, false);
		layout.marginWidth = layout.marginHeight = 14;// layout leave's the
		shell.setLayout(layout);
		
		Monitor monitor = shell.getMonitor();
		int width = monitor.getClientArea().width / 10;
		GridData textData = new GridData(SWT.FILL, SWT.CENTER, true, false);
		textData.widthHint = width;
		
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		text.setLayoutData(textData);
		
		group.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 2, 1));
		findButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		cancelButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		
		shell.pack();
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}