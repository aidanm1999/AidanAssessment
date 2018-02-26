/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import models.Customer;
import models.DBManager;
import models.Order;
import models.OrderLine;
import models.Product;

/**
 *
 * @author Aidan Marshall
 */
public class CustomerBasket extends javax.swing.JFrame {

    private Customer loggedInCustomer;
    private Order customerOrder;
    private HashMap<Integer, OrderLine> customerOrderLines;
    
    public CustomerBasket(Customer customer, Order order) {
        initComponents();
        
        loggedInCustomer = customer;
        customerOrder = order;
        double totalCost = customerOrder.getOrderTotal();
        
        
        DBManager db = new DBManager();
        HashMap<Integer, Product> products = db.loadProducts();
        
        customerOrderLines = db.loadCustomerOrderLines(loggedInCustomer, customerOrder);
        
        customerOrder.setOrderLines(customerOrderLines);
        
        for(Map.Entry<Integer, OrderLine> entry : customerOrder.getOrderLines().entrySet())
        {
            Product orderedProduct = entry.getValue().getProduct();
            DefaultTableModel model = (DefaultTableModel)tblCustomerProducts.getModel();
            model.addRow(new Object[] 
            {
                orderedProduct.getProductName(),
                orderedProduct.getPrice(),
                entry.getValue().getQuantity(),
                orderedProduct.getPrice() * entry.getValue().getQuantity(),
            });
        }
        
        
        lblTotalCost.setText("£" + Double.toString(customerOrder.getOrderTotal()));
    }
        
        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTotalCost = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustomerProducts = new javax.swing.JTable();
        btnRemoveProduct = new javax.swing.JButton();
        btnPurchase = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTotalCost.setText("£0");

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tblCustomerProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product", "Cost per unit", "Quantity", "Subtotal Cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCustomerProducts);

        btnRemoveProduct.setText("Remove Product");
        btnRemoveProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveProductActionPerformed(evt);
            }
        });

        btnPurchase.setText("Purchase");
        btnPurchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPurchaseActionPerformed(evt);
            }
        });

        jLabel1.setText("Total Cost: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(lblMessage))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnBack)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnRemoveProduct)
                                .addComponent(jLabel1))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(btnPurchase))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblTotalCost)
                                    .addGap(0, 0, Short.MAX_VALUE)))))
                    .addContainerGap(192, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(lblMessage)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(btnBack)
                    .addGap(183, 183, 183)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(lblTotalCost))
                    .addGap(17, 17, 17)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRemoveProduct)
                        .addComponent(btnPurchase))
                    .addContainerGap(35, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        CustomerViewProducts viewProducts = new CustomerViewProducts(loggedInCustomer);
        this.dispose();
        viewProducts.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRemoveProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveProductActionPerformed

        if(tblCustomerProducts.getSelectedRow() == -1)
        {
            lblMessage.setText("Select Product First");
        }
        else
        {
            DefaultTableModel model = (DefaultTableModel)tblCustomerProducts.getModel();
            int animalId = Integer.parseInt(String.valueOf(model.getValueAt(tblCustomerProducts.getSelectedRow(), 0)));

            loggedInCustomer.findLatestOrder().removeOrderLine(animalId);

            model.removeRow(tblCustomerProducts.getSelectedRow());

            lblMessage.setText("Product Has Been Removed");
            lblTotalCost.setText("£" + String.format("%.02f",loggedInCustomer.findLatestOrder().getOrderTotal()));
        }
    }//GEN-LAST:event_btnRemoveProductActionPerformed

    private void btnPurchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPurchaseActionPerformed
        DBManager db = new DBManager();
        for(Map.Entry<Integer, OrderLine> olEntry : loggedInCustomer.findLatestOrder().getOrderLines().entrySet())
        {
            OrderLine actualOrderLine = olEntry.getValue();
            Product orderedProduct = actualOrderLine.getProduct();

//            orderedProduct.setIsAvailable(false);
//            db.updateProductAvailablility(orderedProduct);
        }

        loggedInCustomer.findLatestOrder().setStatus("Not complete");
        db.completeOrder(customerOrder.getOrderId());

        CustomerConfirmation confirmation = new CustomerConfirmation (loggedInCustomer, customerOrder.getOrderId());
        this.dispose();
        confirmation.setVisible(true);
    }//GEN-LAST:event_btnPurchaseActionPerformed


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
            java.util.logging.Logger.getLogger(CustomerBasket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerBasket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerBasket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerBasket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Customer customer = null;
                Order order = null;
                new CustomerBasket(customer, order).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnPurchase;
    private javax.swing.JButton btnRemoveProduct;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblTotalCost;
    private javax.swing.JTable tblCustomerProducts;
    // End of variables declaration//GEN-END:variables
}
