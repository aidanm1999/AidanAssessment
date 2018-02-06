/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package views;

import java.util.HashMap;
import javax.swing.ButtonGroup;
import models.Clothing;
import models.DBManager;
import models.Footwear;
import models.Product;
import models.Staff;

/**
 *
 * @author 30207717
 */
public class StaffAddProduct extends javax.swing.JFrame {

    
    private Staff loggedInStaff;
    private HashMap<Integer, Product> products; 
    private Product selectedProduct;
    
    /** Creates new form StaffAddProduct */
    public StaffAddProduct(Staff staff) {
        initComponents();
        ButtonGroup btnGrp = new ButtonGroup();
        btnGrp.add(rbClothing);
        btnGrp.add(rbFootwear);
        DBManager db = new DBManager();
        products = db.loadProducts();
        loggedInStaff = staff;
        
    }

    /** This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rbClothing = new javax.swing.JRadioButton();
        rbFootwear = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtStockLevel = new javax.swing.JTextField();
        btnReturn = new javax.swing.JButton();
        btnRegister = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        lblAdditional = new javax.swing.JLabel();
        txtAdditional = new javax.swing.JTextField();
        lblMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Add Product");

        jLabel2.setText("Type:");

        rbClothing.setText("Clothing");
        rbClothing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbClothingActionPerformed(evt);
            }
        });

        rbFootwear.setText("Footwear");
        rbFootwear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFootwearActionPerformed(evt);
            }
        });

        jLabel3.setText("Name:");

        jLabel4.setText("Price:");

        jLabel5.setText("Stock Level:");

        btnReturn.setText("< Return");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        btnRegister.setText("Add Product");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        lblAdditional.setText("Measurement/Size:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblMessage)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(165, 165, 165)
                                    .addComponent(jLabel1))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(42, 42, 42)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rbClothing))))
                        .addGap(18, 18, 18)
                        .addComponent(rbFootwear)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnReturn)
                        .addGap(83, 83, 83)
                        .addComponent(btnRegister)
                        .addGap(100, 100, 100)
                        .addComponent(btnClear)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(lblAdditional))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtName)
                    .addComponent(txtPrice)
                    .addComponent(txtStockLevel)
                    .addComponent(txtAdditional, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(rbClothing)
                    .addComponent(rbFootwear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtStockLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdditional)
                    .addComponent(txtAdditional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegister)
                    .addComponent(btnClear)
                    .addComponent(btnReturn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbFootwearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFootwearActionPerformed
        lblAdditional.setText("Size: ");
    }//GEN-LAST:event_rbFootwearActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        StaffViewProducts staffViewProducts = new StaffViewProducts(loggedInStaff);
        this.dispose();
        staffViewProducts.setVisible(true);
    }//GEN-LAST:event_btnReturnActionPerformed

    
    
    
    
    
    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed

        if(!txtName.getText().isEmpty() && !txtPrice.getText().isEmpty() && !txtStockLevel.getText().isEmpty() && !txtAdditional.getText().isEmpty())
        {
            int productID = 0;
            String name = txtName.getText();
            double price = Double.parseDouble(txtPrice.getText());
            int stockLevel = Integer.parseInt(txtStockLevel.getText());
            String additional = txtAdditional.getText();
            

            

            DBManager db = new DBManager();

            if (rbClothing.isSelected())
            {
                try
                {
                    Clothing newClothing = new Clothing(productID, name, price, stockLevel, additional);
                    db.registerClothing(newClothing);
                    lblMessage.setText("New clothing product added");
                }
                catch(Exception e)
                {
                    lblMessage.setText("Error");
                }
            }
            else if (rbFootwear.isSelected())
            {
                try
                {
                    int convAdditional = Integer.parseInt(additional);
                    Footwear newFootwear = new Footwear(productID, name, price, stockLevel, convAdditional);
                    db.registerFootwear(newFootwear);
                    lblMessage.setText("New footwear product added.");
                }
                catch(Exception e)
                {
                    lblMessage.setText("Please put size as a number.");
                }
            }
            else
            {
                lblMessage.setText("No type selected.");
            }
            
        }
        else
        {
            lblMessage.setText("Please complete all fields");
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

    
    
    
    
    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtName.setText("");
        txtPrice.setText("");
        txtStockLevel.setText("");
        txtAdditional.setText("");
        lblMessage.setText("");
        lblAdditional.setText("Measurement/Size:");
        
    }//GEN-LAST:event_btnClearActionPerformed

    private void rbClothingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbClothingActionPerformed
        lblAdditional.setText("Measurement: ");
    }//GEN-LAST:event_rbClothingActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StaffAddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffAddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffAddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffAddProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Staff staff = null;
                new StaffAddProduct(staff).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnReturn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblAdditional;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JRadioButton rbClothing;
    private javax.swing.JRadioButton rbFootwear;
    private javax.swing.JTextField txtAdditional;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtStockLevel;
    // End of variables declaration//GEN-END:variables

}
