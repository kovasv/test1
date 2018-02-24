import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kovalenko on 03.06.2017.
 */
public class App {

    Client client;
    EventLogger eventLogger;

// first commit in Sergey K
// second commit in Sergey K

    // rebase try

    public App(Client client, EventLogger eventLogger) {

        this.client = client;
        this.eventLogger = eventLogger;
        if (lines==10){
            System.out.println("URA");}
        else System.out.println("FUCK");

    }
// commit 11
// commit 12
// commit 13


    public  static void main(String[] args){
        @SuppressWarnings("resource")
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");

        Event event = ctx.getBean(Event.class);
        app.logEvent(event,"our text 1");

        event = ctx.getBean(Event.class);
       app.logEvent(event,"our text 2");


    }



    private void logEvent(Event event, String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);
        eventLogger.logEvent(event);
    }
}
