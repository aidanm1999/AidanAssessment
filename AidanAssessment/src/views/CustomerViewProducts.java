package views;

import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListModel;
import models.Customer;
import models.DBManager;
import models.Order;
import models.OrderLine;
import models.Product;

//@author Aidan Marshall
public class CustomerViewProducts extends javax.swing.JFrame {

    private Customer loggedInCustomer;
    private HashMap<Integer, Product> products; 
    private HashMap<Integer, Integer> customerProductQuantities; 
    private Product selectedProduct;
    
    
    public CustomerViewProducts(Customer customer) {
        initComponents();
        DBManager db = new DBManager();
        products = db.loadProducts();
        customerProductQuantities = db.loadCustomerProductQuantities(customer);
        loggedInCustomer = customer;
        
        
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        spCategories = new javax.swing.JScrollPane();
        lstCategory = new javax.swing.JList<>();
        spProducts = new javax.swing.JScrollPane();
        lstProducts = new javax.swing.JList<>();
        lblMessage = new javax.swing.JLabel();
        btnViewBasket = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnAddToBasket = new javax.swing.JButton();
        comboBoxQuantity = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBack.setText("< Return");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel1.setText("Products");

        jLabel2.setText("Categories");

        jLabel3.setText("Products");

        lstCategory.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Clothing", "Footwear" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstCategory.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstCategoryValueChanged(evt);
            }
        });
        spCategories.setViewportView(lstCategory);

        lstProducts.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstProductsValueChanged(evt);
            }
        });
        spProducts.setViewportView(lstProducts);

        btnViewBasket.setText("View Basket");
        btnViewBasket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewBasketActionPerformed(evt);
            }
        });

        jLabel4.setText("Quantity:");

        btnAddToBasket.setText("Add To Basket");
        btnAddToBasket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToBasketActionPerformed(evt);
            }
        });

        jLabel5.setText("Price:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnBack)
                            .addGap(57, 57, 57)
                            .addComponent(jLabel1)
                            .addGap(50, 50, 50)
                            .addComponent(btnViewBasket))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(63, 63, 63)
                            .addComponent(jLabel2)
                            .addGap(121, 121, 121)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMessage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddToBasket))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPrice))
                            .addComponent(spCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(spProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(comboBoxQuantity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(22, 22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(jLabel1)
                    .addComponent(btnViewBasket))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spCategories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBoxQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(lblPrice)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddToBasket)
                    .addComponent(lblMessage))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        CustomerHome customerHome = new CustomerHome(loggedInCustomer); 
        this.dispose();
        customerHome.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void lstCategoryValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstCategoryValueChanged
        DefaultListModel model = new DefaultListModel();

        for(Map.Entry<Integer, Product> productEntry : products.entrySet())
        {
            Product actualProduct = productEntry.getValue();

            if(actualProduct.getClass().getName().equals("models." + lstCategory.getSelectedValue()))
            {
                model.addElement(actualProduct);
            }
        }
        
        
        lstProducts.setModel(model);
        lblMessage.setText("");
    }//GEN-LAST:event_lstCategoryValueChanged

    private void lstProductsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstProductsValueChanged
        Object productObject = lstProducts.getSelectedValue();
        selectedProduct = (Product)productObject;
        lblMessage.setText("");
        
        lblPrice.setText("£" + Double.toString(selectedProduct.getPrice()));
        
        comboBoxQuantity.removeAllItems();
        
        
        int alreadySelected;
        try
        {
            alreadySelected = customerProductQuantities.get(selectedProduct.getProductId());
        }
        catch(Exception ex)
        {
            alreadySelected = 0;
        }
        for (int i = 1; i <= selectedProduct.getStockLevel() - alreadySelected; i++)
        {
           comboBoxQuantity.addItem(Integer.toString(i));
        }
    }//GEN-LAST:event_lstProductsValueChanged

    private void btnAddToBasketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToBasketActionPerformed
        if (selectedProduct != null)
        {
            
            int quantity = comboBoxQuantity.getSelectedIndex()+1;
            
            Order openOrder = loggedInCustomer.findLatestOrder();
            
            OrderLine newOrderLine = new OrderLine(openOrder, selectedProduct, quantity);
            newOrderLine.setOrderLineId(openOrder.generateUniqueOrderLineId());
            
            DBManager db = new DBManager();
            db.addOrderLine(newOrderLine, loggedInCustomer.findLatestOrder().getOrderId());
            
            lblMessage.setText("Added To basket!");
            
            
            int alreadySelected;
            try
            {alreadySelected = customerProductQuantities.get(selectedProduct.getProductId());}
            catch(Exception ex)
            {alreadySelected = 0;}
            
            for (int i = 1; i <= selectedProduct.getStockLevel() - alreadySelected; i++)
            {comboBoxQuantity.addItem(Integer.toString(i));}
        } 
        else { lblMessage.setText("Select Product First"); }
        
    }//GEN-LAST:event_btnAddToBasketActionPerformed

    private void btnViewBasketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewBasketActionPerformed
        Order customerOrder = loggedInCustomer.findLatestOrder();
        CustomerBasket basket = new CustomerBasket(loggedInCustomer, customerOrder);
        basket.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnViewBasketActionPerformed

    
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
            java.util.logging.Logger.getLogger(CustomerViewProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerViewProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerViewProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerViewProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Customer customer = null;
                new CustomerViewProducts(customer).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToBasket;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnViewBasket;
    private javax.swing.JComboBox<String> comboBoxQuantity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JList<String> lstCategory;
    private javax.swing.JList<String> lstProducts;
    private javax.swing.JScrollPane spCategories;
    private javax.swing.JScrollPane spProducts;
    // End of variables declaration//GEN-END:variables
}
