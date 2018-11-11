package com.amazonaws.lambda.demo;


import java.util.Random;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaFunctionHandler implements RequestHandler<Object, String> {



	public class Generator {
	    Random ran_gen = new Random();
	    char[] pw;
	    int max_length;
	
	    //constructors
	    public Generator()
	    {
	        pw = new char[12];
	        max_length = 12;
	    }
	
	    public Generator(int n)
	    {
	        pw = new char[n];
	        max_length = n;
	    }
	
	    //methods
	    public char[] generatePW()
	    {
	        for(int i = 0; i<max_length; i++)
	        {
	            pw[i] = generatePWChar();
	        }
	        return pw;
	    }
	
	    public char generatePWChar()
	    {
	        int category,value = 0,potential_symbol_category;
	        category = ran_gen.nextInt(4)+1;
	        switch(category)
	        {
	            case 1:	//capitals
	                value = ran_gen.nextInt(26)+65;
	                break;
	            case 2:	//lowercases
	                value = ran_gen.nextInt(26)+97;
	                break;
	            case 3: //digits
	                value = ran_gen.nextInt(10)+48;
	                break;
	            case 4:	//symbols
	                potential_symbol_category = ran_gen.nextInt(4)+1;
	                switch(potential_symbol_category)
	                {
	                    case 1:
	                        value = ran_gen.nextInt(15)+33;
	                        break;
	                    case 2:
	                        value = ran_gen.nextInt(7)+58;
	                        break;
	                    case 3:
	                        value = ran_gen.nextInt(6)+91;
	                        break;
	                    case 4:
	                        value = ran_gen.nextInt(4)+123;
	                        break;
	                    default:
	                        value = 0;
	                }
	                break;
	            default:
	                value = 0;
	        }
	        return (char) value;
	    }
	
	    public String toString()
	    {
	        String output = new String(pw);
	        return output;
	    }
	}

	
	public class HardCode {
		int devices;
		Generator g = new Generator();
		String output;
		
		public HardCode(int input)
		{
			devices = input;
		}
		
		public String dividePassword()
		{
			String temp = g.generatePW().toString();
			if(devices == 3)
			{
				output = g.toString().substring(0,3) + " " + g.toString().substring(4,7) + " " + g.toString().substring(8,11);
			}
			else if(devices == 2)
			{
				output = g.toString().substring(0,5) + " " + g.toString().substring(6,11);
			}
			return output;
		}
		
	}
	
    @Override
    public String handleRequest(Object input, Context context) {
        context.getLogger().log("Input: " + input);
        HardCode h = new HardCode(3);//(Character.getNumericValue(input.toString().charAt(7)));
        // TODO: implement your handler
        return h.dividePassword();
    }

}
