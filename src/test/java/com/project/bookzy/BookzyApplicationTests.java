package com.project.bookzy;
 
import com.project.bookzy.controllers.WelcomePageController;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookzyApplicationTests {

	@Test
	@DisplayName("Test should pass because function always returns a String")
	public void controllerReturningNotNull() {
		WelcomePageController welcomePageController = new WelcomePageController();
		Assertions.assertNotNull(welcomePageController.showWelcomeMessage());
	}




}
