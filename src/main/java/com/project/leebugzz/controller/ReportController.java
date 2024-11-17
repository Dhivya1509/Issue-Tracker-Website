package com.project.leebugzz.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.project.leebugzz.model.TicketEntity;

@Controller
public class ReportController {

	@GetMapping("/report")
	public String report(ModelMap model) {
		model.addAttribute("ticket", new TicketEntity());
		model.addAttribute("toDate", Date.class);
		return "adminReport";
	}

	@PostMapping("/report")
	public String pdf(@ModelAttribute("ticket") TicketEntity ticket) {
		try {
			String dest = "C:\\Users\\sysadmin\\Downloads\\report.pdf";
			//String dest = "C:/Users/926958/OneDrive - Cognizant/Desktop/report.pdf";
			PdfWriter writer = new PdfWriter(dest);

			// Creating a PdfDocument
			PdfDocument pdfDoc = new PdfDocument(writer);

			// Adding a new page
			pdfDoc.addNewPage();

			// Creating a Document
			Document document = new Document(pdfDoc);

			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/imdyingdb?" + "user=root&password=systemroot");
			PreparedStatement st = conn.prepareStatement(
					"Select ticketId,createrName,holderName,createDate,status from ticket where title=? and createDate=?");
			st.setObject(1, ticket.getTitle());
			st.setObject(2, ticket.getCreateDate());
			System.out.println("Category: " + ticket.getTitle());
			ResultSet rs = st.executeQuery();

			Paragraph paragraph1 = new Paragraph("REPORT");
			Paragraph paragraph2 = new Paragraph("Category: " + ticket.getTitle());
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			;
			String d = dateFormat.format(ticket.getCreateDate());
			// Paragraph paragraph3 = new Paragraph(ticket.getCreateDate());
			Paragraph paragraph3 = new Paragraph(d);
			document.add(paragraph1);
			document.add(paragraph2);
			document.add(paragraph3);
			// table.addCell(new Cell().add(rs.getString("Ticket ID")));

			float[] pointColumnWidths = { 150F, 150F, 150F, 150F, 150F };
			Table table = new Table(pointColumnWidths);
			Cell cell1 = new Cell(); // Creating a cell
			cell1.add("Ticket ID"); // Adding content to the cell
			table.addCell(cell1);
			// table.addCell(new Cell().add("TicketId"));
			table.addCell(new Cell().add("Creater Name"));
			table.addCell(new Cell().add("Holder Name"));
			table.addCell(new Cell().add("Create Date"));
			table.addCell(new Cell().add("Status"));

			while (rs.next()) {

				table.addCell(new Cell().add(rs.getString(1)));
				System.out.println(rs.getString(1));
				table.addCell(new Cell().add(rs.getString(2)));
				System.out.println(rs.getString(2));
				String n = rs.getString(3);
				if (n != null) {
					table.addCell(new Cell().add(n));
				} else {
					table.addCell(new Cell().add(""));

				}
				System.out.println(n);
				Date dd = rs.getDate(4);
				d = dateFormat.format(dd);
				table.addCell(new Cell().add(d));
				System.out.println(rs.getDate(4));
				String s = rs.getString(5);
				if (s != null) {
					table.addCell(new Cell().add(s));
				} else {
					table.addCell(new Cell().add(""));

				}

			}

			// Closing the document
			document.add(table);
			document.close();
			System.out.println("PDF Created");

		} catch (Exception e) {
		}
		return "redirect:/admindashboard";
	}
}
