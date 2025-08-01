/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Controller.ViewExpandedBookingController;
import Model.BookingModel;
import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author Dell
 */
public class MyBookingPanel extends javax.swing.JPanel {
    /**
     * Creates new form MyBookingPanel
     */
    public MyBookingPanel() {       
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myBookings_label = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        MainFlowPanel = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(884, 545));
        setMinimumSize(new java.awt.Dimension(884, 545));

        myBookings_label.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        myBookings_label.setText("My Bookings");

        jScrollPane2.setViewportView(MainFlowPanel);

        MainFlowPanel.setPreferredSize(new java.awt.Dimension(884, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addGap(350, 350, 350)
                .addComponent(myBookings_label, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(myBookings_label)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainFlowPanel;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel myBookings_label;
    // End of variables declaration//GEN-END:variables

    public void displayBookings(List<BookingModel> bookings, ViewExpandedBookingController controller) {
        MainFlowPanel.removeAll();
        
        if(bookings == null || bookings.isEmpty()) {
            MainFlowPanel.add(new JLabel("No bookings found"));
        } else {
            for(BookingModel booking : bookings) {
                BookingCardPanel card = new BookingCardPanel();
                
                card.setBookingId(booking.getBookingId());
                card.setRoomType(booking.getRoomType());
                card.setCheckInDate(booking.getCheckInDate());
                card.setGuestCount(booking.getGuestCount());
                card.setPrice("Rs. " + booking.getPrice());
                card.setController(controller);
                
                MainFlowPanel.add(card);
            
            }
        }
        MainFlowPanel.revalidate();
        MainFlowPanel.repaint();
    
    }
    
}
