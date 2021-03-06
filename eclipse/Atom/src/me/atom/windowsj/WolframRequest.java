package me.atom.windowsj;

import com.wolfram.alpha.WAEngine;
import com.wolfram.alpha.WAException;
import com.wolfram.alpha.WAPlainText;
import com.wolfram.alpha.WAPod;
import com.wolfram.alpha.WAQuery;
import com.wolfram.alpha.WAQueryResult;
import com.wolfram.alpha.WASubpod;


public class WolframRequest {

	/**
	 * The App ID you registered on Wolfram Alpha
	**/
    private static String appid = "YOUR APPID";
    
	public static void query(String ask) {
    	
    	String input = ask;
    	    
	        WAEngine engine = new WAEngine();
	        
	        engine.setAppID(appid);
	        engine.addFormat("plaintext");
	
	        WAQuery query = engine.createQuery();
	      
	        query.setInput(input);
	        String answer = "";
	        try {
	            WAQueryResult queryResult = engine.performQuery(query);
	            
	            if (queryResult.isError()) {
	                System.out.println("Query error");
	                System.out.println("  error code: " + queryResult.getErrorCode());
	                System.out.println("  error message: " + queryResult.getErrorMessage());
	            } else if (!queryResult.isSuccess()) {
	                System.out.println("Query was not understood; no results available.");
	            } else {
	                for (WAPod pod : queryResult.getPods()) {
	                    if (!pod.isError()) {
	                    	if (pod.getTitle() == "Response") {
	                        answer += (pod.getTitle());
	                        answer += "\n";
	                    	}
	                        for (WASubpod subpod : pod.getSubpods()) {
	                            for (Object element : subpod.getContents()) {
	                                if (element instanceof WAPlainText) {
	                                    answer += ((WAPlainText) element).getText();
	                                    System.out.println("");
	                                }
	                            }
	                        }
	                    }
	                }
	            }
	            DialogWindow.print(answer);
	            System.out.print(answer);
	        } catch (WAException e) {
            	DialogWindow.printError();
	        }
            
}
}