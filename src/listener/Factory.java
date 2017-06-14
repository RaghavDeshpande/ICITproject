package listener;

import java.util.Properties;

public class Factory {
	private static Properties contextProperties;
	
	public static Properties getContextProperties(){
		return contextProperties;
	}
	
	public static void setContextProperties(Properties contextProperties){
		Factory.contextProperties = contextProperties;
	}
	
}
