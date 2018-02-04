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



    public App(Client client, EventLogger eventLogger) {

        this.client = client;
        this.eventLogger = eventLogger;
    }




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
