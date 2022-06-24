package tests;


import conf.AppConfiguration;
import datamodel.Contact;
import jdk.jfr.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.inject.Inject;

@ExtendWith(SpringExtension.class)

@ContextConfiguration(classes = {AppConfiguration.class})

public class TestSPR3 {

    static {
        System.setProperty("conf.file","src/test/resources/conf.properties");
    }

    @Inject
    @Name("checkContact")
    Contact contact;

    @Test
    public void testInjectionOfPerson(){
        System.out.println(contact);
    }
}
