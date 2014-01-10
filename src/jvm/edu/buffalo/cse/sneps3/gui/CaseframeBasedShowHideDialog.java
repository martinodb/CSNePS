/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GlobalGraphFilter.java
 *
 * Created on Dec 2, 2011, 6:16:43 PM
 */

package edu.buffalo.cse.sneps3.gui;

import edu.buffalo.cse.sneps3.gui.business.Caseframe;
import edu.buffalo.cse.sneps3.gui.business.Slot;
import edu.buffalo.cse.sneps3.gui.business.SemanticType;
import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class CaseframeBasedShowHideDialog extends javax.swing.JDialog {

    CaseframeBasedShowHide panel;

    public CaseframeBasedShowHideDialog(Frame f, ArrayList<Caseframe> cflist){
        super(f, true);
        setTitle("Local Graph Filter");
        setSize(265, 400);
        panel = new CaseframeBasedShowHide(cflist);

        panel.getOKButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                panel.perfomOK();
            }
        });

        panel.getCancelButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        add(panel);
    }

    public ArrayList<Caseframe> getResult(){
        return panel.result;
    }

    public void setHelpText(String s){
        panel.setHelpText(s);
    }

}

/**
 *
 * @author dan
 */
class CaseframeBasedShowHide extends javax.swing.JPanel{

    static GlobalGraphFilter instance;

    DefaultListModel<Caseframe> listModel;

    ArrayList<Caseframe> result = new ArrayList<Caseframe>();

    /** Creates new form GlobalGraphFilter */
    public CaseframeBasedShowHide(ArrayList<Caseframe> cflist) {
        initComponents();
        listModel = new DefaultListModel<Caseframe>();
        jList1.setSelectionModel(new CBListSelectionModel());

        for(Caseframe cf : cflist)
            listModel.addElement(cf);

        jList1.setModel(listModel);
    }

    protected JButton getOKButton(){
        return jButton_ok;
    }

    protected JButton getCancelButton(){
        return jButton_cancel;
    }

    protected void setHelpText(String s){
        jTextArea1.setText(s);
    }

    protected void perfomOK(){

        for(Object o : jList1.getSelectedValuesList()){
            result.add((Caseframe)o);
        }
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_cancel = new javax.swing.JButton();
        jButton_ok = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<Caseframe>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jButton_cancel.setText("Cancel");

        jButton_ok.setText("OK");

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jTextArea1.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background"));
        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setFont(new java.awt.Font("Dialog", 1, 12));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(2);
        jTextArea1.setText("  Select the Caseframes you do    not wish to show in the graph.");
        jTextArea1.setWrapStyleWord(true);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton_ok)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_cancel))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_cancel)
                    .addComponent(jButton_ok))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_cancel;
    private javax.swing.JButton jButton_ok;
    private javax.swing.JList<Caseframe> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

}

class CBListSelectionModel extends DefaultListSelectionModel {

    public CBListSelectionModel(){
        super();
    }

    @Override
    public void setSelectionInterval(int index0, int index1) {
        if(super.isSelectedIndex(index0)) {
            super.removeSelectionInterval(index0, index1);
        }
        else {
            super.addSelectionInterval(index0, index1);
        }
    }

    @Override
    public void addSelectionInterval(int index0, int index1) {
        if (index0 == index1) {
            if (isSelectedIndex(index0)) {
                removeSelectionInterval(index0, index0);
                return;
            }
            super.addSelectionInterval(index0, index1);
        }
    }
}
