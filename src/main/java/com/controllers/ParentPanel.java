package com.controllers;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.Spring;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

public abstract class ParentPanel extends JPanel{
   
   public void adjustColumn(TableColumn tc,int alignment,int preferredWidth) {
		DefaultTableCellRenderer dtcr=new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(alignment);
		tc.setPreferredWidth(preferredWidth);
		tc.setCellRenderer(dtcr);
	}
    
    public void adjustComponent(int x,int y,int width,int height,Component component,SpringLayout springLayout,SpringLayout.Constraints slc1){
    	if(slc1!=null){
    	}
    	SpringLayout.Constraints slc;
    	slc=springLayout.getConstraints(component);
    	slc.setY(Spring.constant(y));
		slc.setX(Spring.constant(x));
		slc.setWidth(Spring.constant(width));
		slc.setHeight(Spring.constant(height));
    }
 
    public abstract void clearData();

    
}