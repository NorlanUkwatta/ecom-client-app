package lk.jiat.ecom.client;

import lk.jiat.ecom.user.remote.TestRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        System.out.println("Clinet Application Started");

        try {
            Properties properties = new Properties();
            properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
            properties.setProperty(Context.PROVIDER_URL, "iiop://localhost:3700");
            InitialContext ic = new InitialContext();
            TestRemote tc = (TestRemote) ic.lookup("java:global/ecom-user-1.0/TestSessionBean");
            tc.test();
            ic.rebind("Name", "Norlan");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}