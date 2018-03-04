/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import DBManagers.CustomerDBManager;
import DBManagers.OrderDBManager;
import DBManagers.OrderLineDBManager;
import DBManagers.ProductDBManager;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import models.Customer;
import models.Order;
import models.OrderLine;

/**
 *
 * @author Aidan Marshall
 */
public class CustomerBasket extends javax.swing.JFrame {

    private Customer loggedInCustomer;

    
    public CustomerBasket(Customer customer) {
        initComponents();
        
        loggedInCustomer = customer;

        //Populates the table
        for(Map.Entry<Integer, OrderLine> entry : loggedInCustomer.findLatestOrder(loggedInCustomer).getOrderLines().entrySet())
        {
            DefaultTableModel model = (DefaultTableModel)tblCustomerProducts.getModel();
            model.addRow(new Object[] 
            {
                entry.getValue().getProduct().getProductId(),
                entry.getValue().getProduct().getProductName(),
                entry.getValue().getProduct().getPrice(),
                entry.getValue().getQuantity(),
                entry.getValue().getProduct().getPrice() * entry.getValue().getQuantity(),
            });
        }
        
        
        lblTotalCost.setText("£" + Double.toString(loggedInCustomer.findLatestOrder(loggedInCustomer).getOrderTotal()));
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
                "Product Id", "Product", "Cost per unit", "Quantity", "Subtotal Cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCustomerProducts);
        if (tblCustomerProducts.getColumnModel().getColumnCount() > 0) {
            tblCustomerProducts.getColumnModel().getColumn(0).setResizable(false);
            tblCustomerProducts.getColumnModel().getColumn(1).setResizable(false);
            tblCustomerProducts.getColumnModel().getColumn(2).setResizable(false);
            tblCustomerProducts.getColumnModel().getColumn(3).setResizable(false);
            tblCustomerProducts.getColumnModel().getColumn(4).setResizable(false);
        }

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
                .addGap(143, 143, 143)
                .addComponent(lblMessage)
                .addContainerGap(278, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
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
            //Selects the product id
            DefaultTableModel model = (DefaultTableModel)tblCustomerProducts.getModel();
            int productId = Integer.valueOf(String.valueOf(model.getValueAt(tblCustomerProducts.getSelectedRow(), 0)));
            
            //Selects the orderLine from the product id
            OrderLine selectedOrderLine = new OrderLine();
            for(Map.Entry<Integer, OrderLine> olEntry : loggedInCustomer.findLatestOrder(loggedInCustomer).getOrderLines().entrySet())
            {
                if(productId == olEntry.getValue().getProduct().getProductId())
                {
                    selectedOrderLine = olEntry.getValue();
                }
            }
            
            //Deletes the selected orderline from the database
            OrderLineDBManager oldb = new OrderLineDBManager();
            oldb.deleteOrderLine(selectedOrderLine.getOrderLineId());
            
            
            //Gets the lineTotal
            double lineTotal = selectedOrderLine.getLineTotal();
            
            
            //Update the orderTotal in the program
            loggedInCustomer.findLatestOrder(loggedInCustomer).setOrderTotal(loggedInCustomer.findLatestOrder(loggedInCustomer).getOrderTotal()-lineTotal);
            
            //Delete the selected orderLine from the program
            loggedInCustomer.findLatestOrder(loggedInCustomer).getOrderLines().remove(selectedOrderLine.getOrderLineId());
            
            //Update the orderTotal in the database
            OrderDBManager odb = new OrderDBManager();
            odb.updateOrder(loggedInCustomer.findLatestOrder(loggedInCustomer));
            
            //Removes row from the table
            model.removeRow(tblCustomerProducts.getSelectedRow());

            //Sends feedback to user
            lblMessage.setText("Product Has Been Removed");
            lblTotalCost.setText("£" + String.format("%.02f",loggedInCustomer.findLatestOrder(loggedInCustomer).getOrderTotal()));
            
        }
    }//GEN-LAST:event_btnRemoveProductActionPerformed

    private void btnPurchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPurchaseActionPerformed
        OrderDBManager odb = new OrderDBManager();
        ProductDBManager pdb = new ProductDBManager();
        
        //Update stock level in database 
        pdb.updateProducts(loggedInCustomer.findLatestOrder(loggedInCustomer));
        
        
        //Changes the status of the order to complete
        Order order = loggedInCustomer.findLatestOrder(loggedInCustomer);
        order.setStatus("Complete");
        odb.updateOrder(order);
        
        //Reloads the customer to update the updated changes
        String username = loggedInCustomer.getUsername();
        CustomerDBManager cdb = new CustomerDBManager();
        loggedInCustomer = cdb.selectCustomer(username);
        
        CustomerConfirmation confirmation = new CustomerConfirmation (loggedInCustomer, order.getOrderId());
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
                new CustomerBasket(customer).setVisible(true);
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
