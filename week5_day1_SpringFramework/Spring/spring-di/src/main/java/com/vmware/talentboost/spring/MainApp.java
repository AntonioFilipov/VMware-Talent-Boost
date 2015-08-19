package com.vmware.talentboost.spring;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vmware.talentboost.spring.impl.AccountManager;
import com.vmware.talentboost.spring.impl.ConsolePlayer;
import com.vmware.talentboost.spring.impl.HardCodedRepository;
import com.vmware.talentboost.spring.impl.QuestionManager;


public class MainApp {
	public static void main(String... args) {
		// Task 1: Instantiate all the classes and run the game.

		// Task 2: Involve Spring...
		//		- Include the required libs to the project
		//		- Create the XML configuration file
		//		- In the main method create an application context
		//			and get the game from it.

		// Task 3*: Switch to annotation based configuration
		//		- Use @Autowired instead of constructor-arg
		//		- Enable automatic component scan
		
		/*IRepository repository = new HardCodedRepository();

		IAccountManager accountManager= new AccountManager(repository);
		IQuestionManager questionManager = new QuestionManager(repository);
		IPlayer player = new ConsolePlayer();
		Game game = new Game(accountManager, questionManager, player);
		game.run();
		System.out.println("Success!");*/
		

		ApplicationContext context= new ClassPathXmlApplicationContext("application-config.xml");
		Game game = context.getBean("game", Game.class);
		game.run();
	}
}
