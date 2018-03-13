package de.diaoliu.springcore.test;

import de.diaoliu.springcore.xmlBean.PetStoreService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Logger;

public class XmlApplicationContextTests {

    private static Logger logger = Logger.getLogger(XmlApplicationContextTests.class.toString());

    ApplicationContext context;

    @Before
    public void setUp() {
        // create and configure beans
        this.context = new ClassPathXmlApplicationContext("/xmlBeans.xml");
    }

    @Test
    public void BeanTest() {
        PetStoreService petStoreService = (PetStoreService) context.getBean("petStore");
        Assert.assertNotNull(petStoreService);
        logger.info("Account is enabled: " + petStoreService.isAccountEnabled());
        logger.info("Account has transaction: " + petStoreService.getAccountDao().getAccounts().get("one"));
    }
}
