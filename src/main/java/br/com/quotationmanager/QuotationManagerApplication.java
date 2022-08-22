package br.com.quotationmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class QuotationManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuotationManagerApplication.class, args);
    }
}
