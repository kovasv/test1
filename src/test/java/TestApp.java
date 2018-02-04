import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestApp {


     private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        @BeforeTest
        public void setUpStreams() {
            System.setOut(new PrintStream(outContent));
        }

        @AfterTest
        public void cleanUpStreams() {
            System.setOut(null);
        }

        @Test
        public void testLogEvent() {
            App.main(null);
            String msg = outContent.toString();
            Assert.assertFalse(msg.contains("1"));
            Assert.assertTrue(msg.contains("John Smith"));
        }


    }

