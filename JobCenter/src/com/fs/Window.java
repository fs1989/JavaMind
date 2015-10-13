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
        //1.一个窗口  
        final Shell shell = new Shell(display);  
        shell.setSize(250, 300);  
        shell.setText("Hello SWT");  
        //2.一个按钮  
        Button button = new Button(shell, SWT.NONE);  
        button.setText("!点^.^我!");  
        button.setLocation(70, 150);  
        button.setSize(100,25);  
  
        //3.按钮的选中事件：按钮添加事件  
        button.addSelectionListener(new SelectionListener() {  
            @Override  
            public void widgetSelected(SelectionEvent event) {  
                MessageDialog.openInformation(shell, "你好", "青年");  
            }  
              
            @Override  
            public void widgetDefaultSelected(SelectionEvent e) {}  
        });  
          
        //4.设置显示  
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
