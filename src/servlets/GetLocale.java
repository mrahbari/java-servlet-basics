package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class GetLocale extends HttpServlet{

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {
        //Get the client's Locale
        Locale locale = request.getLocale();
        String language = locale.getLanguage();
        String country = locale.getCountry();


        // Set farsi language code.
        response.setHeader("Content-Language", "fa");


        //Get the client's Locale
        //Locale locale = request.getLocale();
        String date = DateFormat.getDateTimeInstance(
                DateFormat.FULL,
                DateFormat.SHORT,
                locale).format(new Date());


        //Get the client's Locale
        //Locale locale = request.getLocale( );
        NumberFormat nft = NumberFormat.getCurrencyInstance(locale);
        String formattedCurr = nft.format(1000000);


        //Get the client's Locale
        //Locale locale = request.getLocale( );
        NumberFormat nft1 = NumberFormat.getPercentInstance(locale);
        String formattedPerc = nft1.format(0.51);

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String title = "Detecting Locale";
        String docType = "<!doctype html\">\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + language + "</h1>\n" +
                "<h2 align=\"center\">" + country + "</h2>\n" +
                "</body></html>");
    }
}