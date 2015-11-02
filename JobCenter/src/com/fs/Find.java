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

public class Find extends org.eclipse.swt.widgets.Shell {
	static Shell shell;
	
	public Find(Shell shell) {
		Display display = new Display();
		Shell s = new Shell(display);
		s.setText("Find (GridLayout)");

		Label label = new Label(s, SWT.NONE);
		label.setText("Find what:");

		Text text = new Text(s, SWT.BORDER);

		Button findButton = new Button(s, SWT.PUSH);
		findButton.setText("Find Next");

		Group group = new Group(s, SWT.NONE);
		group.setLayout(new RowLayout());
		group.setText("Direction");

		Button upButton = new Button(group, SWT.RADIO);
		Button downButton = new Button(group, SWT.RADIO);
		upButton.setText("Up");
		downButton.setText("Down");
		downButton.setSelection(true);

		Button cancelButton = new Button(s, SWT.PUSH);
		cancelButton.setText("Cancel");

		/* Use a GridLayout to position the controls */

		GridLayout layout = new GridLayout(3, false);
		layout.marginWidth = layout.marginHeight = 14;// layout leave's the
		s.setLayout(layout);

		Monitor monitor = s.getMonitor();
		int width = monitor.getClientArea().width / 10;
		GridData textData = new GridData(SWT.FILL, SWT.CENTER, true, false);
		textData.widthHint = width;

		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		text.setLayoutData(textData);

		group.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 2, 1));
		findButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		cancelButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

		s.pack();
		new Label(s, SWT.NONE);
		new Label(s, SWT.NONE);
		new Label(s, SWT.NONE);
		new Label(s, SWT.NONE);
		s.open();
		while (!s.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	public static void main(String[] args) {
//		Find find = new Find(shell);

	}
}