package com.demo.springmvc3.controller;

import com.demo.springmvc3.model.Product;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
@Component
public class PdfReport {

  public static ByteArrayInputStream employeePdfViews(List<Product> products){

    ByteArrayOutputStream out=new ByteArrayOutputStream();

    Document document=new Document();


    try {

      PdfPTable table = new PdfPTable(7);
      table.setWidthPercentage(80);
      table.setWidths(new int[]{1,3,3,3,3,3,3});


      PdfPCell hcell;
      Font font= FontFactory.getFont(FontFactory.HELVETICA);

      hcell=new PdfPCell(new Phrase("Id",font));
      hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
      table.addCell(hcell);

      hcell=new PdfPCell(new Phrase("Name",font));
      hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
      table.addCell(hcell);


      hcell=new PdfPCell(new Phrase("Price",font));
      hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
      table.addCell(hcell);

      hcell=new PdfPCell(new Phrase("Quantity",font));
      hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
      table.addCell(hcell);

      hcell=new PdfPCell(new Phrase("LastUpdated",font));
      hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
      table.addCell(hcell);

      hcell=new PdfPCell(new Phrase("Category Name",font));
      hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
      table.addCell(hcell);

      hcell=new PdfPCell(new Phrase("Posted Time",font));
      hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
      table.addCell(hcell);


      for(Product product:products){
        PdfPCell cell;

        cell=new PdfPCell(new Phrase(product.getId().toString()));
        cell.setPaddingLeft(5);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(cell);

        cell=new PdfPCell(new Phrase(String.valueOf(product.getName())));
        cell.setPaddingLeft(5);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(cell);


        cell=new PdfPCell(new Phrase(String.valueOf(product.getPrice())));
        cell.setPaddingLeft(5);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(cell);


        cell=new PdfPCell(new Phrase(String.valueOf(product.getQuantity())));
        cell.setPaddingLeft(5);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(cell);


        cell=new PdfPCell(new Phrase(String.valueOf(String.valueOf(product.getLastUpdted()))));
        cell.setPaddingLeft(5);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(cell);

        cell=new PdfPCell(new Phrase(String.valueOf(product.getCategory().getName())));
        cell.setPaddingLeft(5);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(cell);

        cell=new PdfPCell(new Phrase(String.valueOf(product.getPrettyTime())));
        cell.setPaddingLeft(5);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(cell);


      }

      PdfWriter.getInstance(document,out);
      document.open();

      document.add(table);

      document.close();


    }catch (Exception e){
      e.printStackTrace();
    }

    return  new ByteArrayInputStream(out.toByteArray());
  }
}
