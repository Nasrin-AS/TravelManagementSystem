package com.canddella.utility;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.sql.DataSource;

import com.canddella.dbconnectionpool.DBConnectionPool;
import com.canddella.entity.Booking;
import com.canddella.entity.BusRoute;
import com.canddella.service.BookingServiceImpl;
import com.canddella.service.BusRouteServiceImpl;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class BillPdfGenerator {

	public static void main(String[] args) {
		generateBill();
	}
		public static void generateBill() {
			
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the Bill ID");
		int id = in.nextInt();
		
		String query = "select bill.bill_id,bill.booking_id,passenger.passenger_name,bill.amount,bill.payment_mode,bill.payment_date from bill join passenger on bill.passenger_id = passenger.passenger_id where bill.bill_id = "+id;
		String query1 = "select booking.route_id from bill join booking on bill.booking_id = booking.booking_id where bill.bill_id = "+id;
        try {  
        	Connection connection = null;
    		PreparedStatement prepStmt = null;
        
            // Connect to the database
        	DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(query);
			ResultSet resultSet = prepStmt.executeQuery();
			prepStmt = connection.prepareStatement(query1);
			ResultSet resultSet1 = prepStmt.executeQuery();

            // Create a new PDF document
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\nasri\\eclipse-workspace\\Travel_Management_System\\pdf\\demo.pdf"));
            document.open();
            
            document.add(Image.getInstance("C:\\Users\\nasri\\eclipse-workspace\\Travel_Management_System\\TMSLogo.jpg"));
			document.add(new Paragraph(" "));
			
//			BookingServiceImpl bookingServiceImpl = new BookingServiceImpl();
//			Booking booking = bookingServiceImpl.bookingid(id);
			
//			BusRouteServiceImpl busRouteServiceImpl = new BusRouteServiceImpl();
//			BusRoute busRoute = busRouteServiceImpl.busRouteid(id);
			
            while (resultSet.next()) {
            	Paragraph para = new Paragraph("*******************************BILL*******************************");
            	document.add(para);

    			
            	Paragraph para1 = new Paragraph("BILL ID : " + resultSet.getInt("bill_id") + "\n" +"BOOKING ID :" + resultSet.getInt("booking_id")+"\n" + "PASSENGER NAME : " + resultSet.getString("passenger_name"));
            	document.add(para1);
            	while(resultSet1.next()) {
            	BusRouteServiceImpl busRouteServiceImpl = new BusRouteServiceImpl();
    			BusRoute busRoute = busRouteServiceImpl.busRouteid(resultSet1.getInt(1));
    			
            	Paragraph para2 = new Paragraph("STARTING POINT : " + busRoute.getStartingPoint() +"\n"+ "DESTINATION : " + busRoute.getDestination() +"\n");
            	document.add(para2);
            	}
            	Paragraph para3 = new Paragraph("AMOUNT : " + resultSet.getInt("amount")+ "\n" +"PAYMENT MODE : " + resultSet.getString("payment_mode")+ "\n" + "PAYMENT DATE : " + resultSet.getString("payment_date"));
                document.add(para3);
                
                Paragraph para4 = new Paragraph("*******************************************************************");
                document.add(para4);
                System.out.println("Bill generated successfully");
            }

            document.close();
            
        } catch (Exception e) {
            e.printStackTrace();
		
		
        }
		
	}
}	
