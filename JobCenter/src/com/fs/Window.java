package com.fs;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class Window {
	
	Application petrel = new Application("petrel", "FGG-GLOBAL-ZZ-SCHL-Shell_Petrel-GS");
	Application techlog = new Application("techlog", "FGG-EP-GLOBAL-ZZ-THSA-Techlog-AllVersions-GS");
	Application arcgis = new Application("arcgis", "FGG-GLOBAL-ZZ-ARCGIS-GS");
	Application fme = new Application("fme", "FGR-SCEPCO-BEJ-ZZ-SAFE-FME-2013_SP3-GS");
	Application ofm = new Application("ofm", "FGG-GLOBAL-ZZ-SCHL-OFM-GS");
	Application edm = new Application("edm", "FGO-SUKEP-ABE-ZZ-EDM R5000 SCEPCO-GS");
	Application ecrin = new Application("ecrin", "FGG-EP-GLOBAL-ZZ-KAEN-Ecrin-GS");
	
	public static void main(String[] args) {  
		
        Display display = new Display();  
        Shell shell = new Shell(display);  
        shell.setSize(1024, 600);  
        shell.setLayout(new FillLayout());
        shell.setText("SSW Application Support");
        
        //2.һ����ť  
        Button button = new Button(shell,SWT.NONE);  
        button.setText("!��^.^��!"); 
        button.setLocation(70, 150);  
        button.setSize(100,25);  
  
        //3.��ť��ѡ���¼�����ť����¼�  
        button.addSelectionListener(new SelectionListener() {  
            @Override  
            public void widgetSelected(SelectionEvent event) {  
            }  
              
            @Override  
            public void widgetDefaultSelected(SelectionEvent e) {}  
        });  
        
        Text text = new Text (shell, SWT.BORDER);
        text.setText ("button0");
		
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
	
	
	
	
	void updateAllApps() throws Exception {
		petrel.update_user_list();
		techlog.update_user_list();
		arcgis.update_user_list();
		fme.update_user_list();
		ofm.update_user_list();
		edm.update_user_list();
		ecrin.update_user_list();
	}

}
