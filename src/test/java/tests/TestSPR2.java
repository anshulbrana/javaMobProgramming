package tests;

import conf.AppConfiguration;
import jdk.jfr.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import javax.inject.Inject;

@ExtendWith(SpringExtension.class)

@ContextConfiguration(classes = {AppConfiguration.class})

public class TestSPR2 {

    static {
        System.setProperty("conf.file","src/test/resources/conf.properties");
    }


    @Inject
    @Name("myFirstBean")
    String testSpring;

    @Test
    public void testInjection(){
        Assertions.assertNotNull(testSpring);
        System.out.println(testSpring);
    }
}
