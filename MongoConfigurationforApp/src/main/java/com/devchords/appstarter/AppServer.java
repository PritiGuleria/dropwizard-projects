package com.devchords.appstarter;

import com.devchords.config.MongoDBConnection;
import com.devchords.config.MyAppConfig;
import com.devchords.resources.MongoConfigResources;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;

public class AppServer extends Application<MyAppConfig>{
	

	@Override
	public void run(MyAppConfig conf, Environment e)
			throws Exception {
		
		MongoDBConnection.appConfig =conf;
		
		e.jersey().register(new MongoConfigResources());

		
		System.out.println("Hello by DropWizard");
		
	}
	public static void main(String[] args) throws Exception {
		new AppServer().run(args);
	}

}
