package phoenix.ovic;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import phoenix.ovic.ParseException;

public class Main {
	

	public static void main(String [] args) throws ParseException, TokenMgrError,IOException
	  {
	    System.out.println("Enter input file path or press enter to input from console:\nPath Example  c:\\users\\smart\\desktop\\test.txt");
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    String FilePath = reader.readLine();
	    Phoenix parser;
	    if (FilePath.isEmpty())
	    {
	      parser = new Phoenix(System.in);
	    }
	    else
	    {
	      System.out.println(FilePath);
	      FileReader fr = new FileReader(FilePath);
	      parser = new Phoenix(fr);
	    }
	    parser.start();
	    System.out.println(parser.boolFlag);
	    System.out.println("Syntax is okay");
	  }

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		try {
//			new phoenix.ovic.Phoenix(System.in).start();
//			System.out.println("Syntax is okay");
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
}
