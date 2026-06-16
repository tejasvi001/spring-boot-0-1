package com.tejasvivermani.module1Introduction;

import com.tejasvivermani.module1Introduction.homework.CakeBaker;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Module1IntroductionApplication implements CommandLineRunner {

	public final NotificationService notificationService;
	public final CakeBaker cakeBaker;
	public Module1IntroductionApplication(NotificationService notificationService, CakeBaker cakeBaker) {
		this.notificationService = notificationService;
        this.cakeBaker = cakeBaker;
    }

	public static void main(String[] args) {
		SpringApplication.run(Module1IntroductionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		notificationService.sendMessage("HELLO, WELCOME TO MY SPRING APP");
		cakeBaker.bakeCake();
	}
}
