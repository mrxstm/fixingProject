package DAO;

import Model.InvoiceModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class InvoiceDaoTest {

    private InvoiceDao invoiceDao;
    private InvoiceModel testInvoice;

    @Before
    public void setUp() {
        invoiceDao = new InvoiceDao();

        // Prepare a test invoice model
        testInvoice = new InvoiceModel();
        testInvoice.setBooking_id(8);  
        testInvoice.setRoomId(9);      
        testInvoice.setInvoiceDate("2025-07-28");
        testInvoice.setTax(11.88);
        testInvoice.setRoomPrice(60);
        testInvoice.setServiceCharge(6);
        testInvoice.setTotalAmount(77.88);
        testInvoice.setPaymentMethod("Card");
    }

    @After
    public void tearDown() {
       
    }

    @Test
    public void testAddInvoice() {
        try {
            invoiceDao.addInvoice(testInvoice);
           
            System.out.println("Invoice inserted successfully.");
        } catch (Exception e) {
            fail("Insertion failed: " + e.getMessage());
        }
    }

    @Test
    public void testGetInvoiceDetails() {
      
        int fakeInvoiceId = 9999;
        InvoiceModel result = invoiceDao.getInvoiceDetails(fakeInvoiceId);

        assertNull("Expected null for non-existing invoice ID", result);
    }
}
