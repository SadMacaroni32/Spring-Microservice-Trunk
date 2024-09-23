package com.config.configservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CustomPropertySourceLocator implements PropertySourceLocator {

    private static final Logger logger = LoggerFactory.getLogger(CustomPropertySourceLocator.class);

    private static final Map<String, String> serviceFileMap = new HashMap<>() {{
        put("discoveryservice", "0__8761__DiscoveryService.properties");
        put("apigateway", "8080__APIGatewayService.properties");
        put("userservice", "8081__UserService.properties");
        put("productservice", "8082__ProductService.properties");
        put("orderservice", "8083__OrderService.properties");
        put("checkoutservice", "8084__CheckoutService.properties");
        put("paymentservice", "8085__PaymentService.properties");
    }};

    @Override
    public PropertySource<?> locate(Environment environment) {
        String applicationName = environment.getProperty("spring.application.name").toLowerCase();
        String fileName = serviceFileMap.get(applicationName);

        if (fileName == null) {
            logger.warn("No mapping found for application: {}", applicationName);
            return new PropertiesPropertySource(applicationName, new Properties()); // Return an empty PropertySource
        }

        // Use a dynamic path for flexibility
        String configDir = System.getProperty("config.dir", 
            "C:/Users/jaquino/Desktop/Github_Planet/MicroSerivces__EcommerceWeb/backend/0___Config___Files");
        File file = new File(configDir, fileName);

        if (file.exists()) {
            Properties properties = new Properties();
            try (FileInputStream inputStream = new FileInputStream(file)) {
                properties.load(inputStream);
                return new PropertiesPropertySource(fileName, properties); // Return the property source directly
            } catch (IOException e) {
                logger.error("Error loading properties from file: {}", fileName, e);
            }
        } else {
            logger.warn("Configuration file not found: {}", file.getAbsolutePath());
        }

        // Return an empty PropertySource if the file doesn't exist
        return new PropertiesPropertySource(fileName, new Properties());
    }
}
