package com.fs;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Window {

	public static void main(String[] args) {  
        Display display = new Display();  
        //1.һ������  
        final Shell shell = new Shell(display);  
        shell.setSize(250, 300);  
        shell.setText("Hello SWT");  
        //2.һ����ť  
        Button button = new Button(shell, SWT.NONE);  
        button.setText("!��^.^��!");  
        button.setLocation(70, 150);  
        button.setSize(100,25);  
  
        //3.��ť��ѡ���¼�����ť����¼�  
        button.addSelectionListener(new SelectionListener() {  
            @Override  
            public void widgetSelected(SelectionEvent event) {  
                MessageDialog.openInformation(shell, "���", "����");  
            }  
              
            @Override  
            public void widgetDefaultSelected(SelectionEvent e) {}  
        });  
          
        //4.������ʾ  
        shell.layout();  
        shell.open();  
        while(!shell.isDisposed()){  
            if(!display.readAndDispatch()){  
                display.sleep();  
            }  
        }  
        display.dispose();  
    }  

}
