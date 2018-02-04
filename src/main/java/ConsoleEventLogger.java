import javax.xml.bind.SchemaOutputResolver;

/**
 * Created by Kovalenko on 03.06.2017.
 */
public class ConsoleEventLogger implements EventLogger {

    @Override
    public void logEvent(Event event) {
        		System.out.println(event.toString());
    }
}
