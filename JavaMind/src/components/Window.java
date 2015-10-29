package components;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Window {

	public static void main(String[] args) {
		Display display = new Display();
		Image image = display.getSystemImage(SWT.ICON_QUESTION);
		Shell shell = new Shell(display);
		
		shell.setLayout (new FillLayout(2));
		Button button1 = new Button(shell, SWT.PUSH);
		Button button2 = new Button(shell, SWT.PUSH);
		Button button3 = new Button(shell, SWT.PUSH);
		Button button4 = new Button(shell, SWT.PUSH);
		Button button5 = new Button(shell, SWT.PUSH);
		Button button6 = new Button(shell, SWT.PUSH);
		
		button1.setImage(image);
		button1.setText("Button");
		
		button1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Cancel");
			}
		});
		
		shell.setSize(800, 600);
		shell.open();
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();
	}
}