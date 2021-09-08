package config.management;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
	private static final Properties config;

	static {
		config = new Properties();
		try {
			config.load( new FileReader( "src/test/config.properties" ) );
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}

	public static String dbUser() {
		return config.getProperty( "database_username" );
	}

	public static String dbPassword() {
		return config.getProperty( "database_password" );
	}

	public static String dbAddress() {
		return config.getProperty( "database_address" );
	}

	public static String apiAddress() {
		return config.getProperty( "api_address" );
	}
}
