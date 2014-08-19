package com.clearqa.test;

import java.awt.List;
import java.io.IOException;

import com.google.gdata.client.spreadsheet.FeedURLFactory;
import com.google.gdata.client.spreadsheet.ListQuery;
import com.google.gdata.client.spreadsheet.SpreadsheetQuery;
import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.CustomElementCollection;
import com.google.gdata.data.spreadsheet.ListEntry;
import com.google.gdata.data.spreadsheet.ListFeed;
import com.google.gdata.data.spreadsheet.SpreadsheetEntry;
import com.google.gdata.data.spreadsheet.SpreadsheetFeed;
import com.google.gdata.data.spreadsheet.WorksheetEntry;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;

public class WebDriverManager{

public static void main(String[] args) throws IOException, ServiceException{
   //SimpleCommandLineParser parser = new SimpleCommandLineParser(args);
   //String username = parser.getValue("username", "user", "u");
   String username = "hiro.nakasuji@streambox.com";
   
   String password = "Streamwolf70";
   //String password = parser.getValue("password", "pass", "p");
   
   //boolean help = parser.containsKey("help", "h");

   if (username == null || password == null) {
     //usage();
     System.exit(1);
   }

   SpreadsheetService service = new SpreadsheetService("Cell Demo");
   service.setUserCredentials(username,password);
   
   FeedURLFactory urlFactory = FeedURLFactory.getDefault();
   SpreadsheetQuery spreadsheetQuery = new SpreadsheetQuery(urlFactory.getSpreadsheetsFeedUrl());
   
  
   
   spreadsheetQuery.setTitleQuery("xpath for live/es");  //Set the name of spreadsheet which we would like to use
   SpreadsheetFeed spreadsheetFeed = (SpreadsheetFeed) service.query(spreadsheetQuery,SpreadsheetFeed.class);
   
   SpreadsheetEntry spreadsheetEntry = (SpreadsheetEntry) spreadsheetFeed.getEntries().get(0);
   
   System.out.println("Name:" + spreadsheetEntry.getTitle().getPlainText());
   
   //get worksheet which I am looking for
   WorksheetEntry worksheetEntry = spreadsheetEntry.getDefaultWorksheet();
   
   
   //Seraching  inside wirksheet
   
   ListQuery listQuery = new ListQuery(worksheetEntry.getListFeedUrl());
   listQuery.setSpreadsheetQuery("Live");
   ListFeed listFeed = (ListFeed) service.query(listQuery,ListFeed.class);
   ListEntry listEntry = (ListEntry) listFeed.getEntries().get(0);
   CustomElementCollection elements = listEntry.getCustomElements();
   System.out.println("Refer to:   " + elements.getValue("esls type"));
   
   
   //    System.out.println( "content=[" + listEntry.getPlainTextContent() + "]");
     //  CustomElementCollection elements = listEntry.getCustomElements();
   
   /*
   ListEntry listEntry = (ListEntry) listFeed.getEntries().get(9);
   CustomElementCollection elements = listEntry.getCustomElements();
   System.out.println("Refer to:   " + elements.getValue("esls type"));
   */
   
   
   
   /*
   CellDemo demo = new CellDemo(new SpreadsheetService("Cell Demo"),
       System.out);

   demo.run(username, password);
 */
 
 }//end of main


}