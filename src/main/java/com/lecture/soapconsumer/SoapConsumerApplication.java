package com.lecture.soapconsumer;

import com.soap.consuming.wsdl.GetTreeResponse;
import com.soap.consuming.wsdl.Tree;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoapConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoapConsumerApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(TreeClient treeClient) {
		return args -> {
			int id = 3;

			if (args.length > 0) {
				id = Integer.parseInt(args[0]);
			}
			GetTreeResponse response = treeClient.getTree(id);
			Tree tree = response.getTree();
			System.err.printf("id = %d, fruit = %s, geoLocation = %s",
					tree.getId(), tree.getFruit(), tree.getGeoLocation());
		};
	}

}

