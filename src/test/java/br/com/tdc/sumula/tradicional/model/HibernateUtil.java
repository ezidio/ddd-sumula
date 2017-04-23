package br.com.tdc.sumula.tradicional.model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by everton on 21/04/17.
 */
public class HibernateUtil {

    public static SessionFactory createSessionFactory() throws URISyntaxException, IOException, ClassNotFoundException {
        Configuration configuration = new Configuration();
        HibernateUtil.getEntityClassesFromPackage("br.com.tdc.sumula.tradicional.model")
                .forEach(configuration::addAnnotatedClass);

        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:h2:~/test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
        configuration.setProperty("hibernate.hbm2ddl.auto", "create");
        configuration.setProperty("javax.persistence.sql-load-script-source", "META-INF/import.sql");
        return configuration.buildSessionFactory();

    }

    public static List<Class<?>> getEntityClassesFromPackage(String packageName) throws ClassNotFoundException, IOException, URISyntaxException {
        List<String> classNames = getClassNamesFromPackage(packageName);
        List<Class<?>> classes = new ArrayList<Class<?>>();
        for (String className : classNames) {
            Class<?> cls = Class.forName(packageName + "." + className);
            Annotation[] annotations = cls.getAnnotations();

            for (Annotation annotation : annotations) {
                System.out.println(cls.getCanonicalName() + ": " + annotation.toString());
                if (annotation instanceof javax.persistence.Entity) {
                    classes.add(cls);
                }
            }
        }

        return classes;
    }

    public static ArrayList<String> getClassNamesFromPackage(String packageName) throws IOException, URISyntaxException, ClassNotFoundException {
        ClassLoader classLoader = HibernateUtil.class.getClassLoader();
        ArrayList<String> names = new ArrayList<String>();

        packageName = packageName.replace(".", "/");
        Enumeration<URL> packageURL = classLoader.getResources(packageName);

        while (packageURL.hasMoreElements()) {
            read(names, packageURL.nextElement());
        }
        //read(names, packageURL);

        return names;
    }

    private static void read(ArrayList<String> names, URL packageURL) throws URISyntaxException {
        URI uri = new URI(packageURL.toString());
        File folder = new File(uri.getPath());
        File[] files = folder.listFiles();
        for (File file: files) {
            String name = file.getName();
            int dotPosition = name.lastIndexOf('.');
            if (!file.isDirectory()) {
                name = name.substring(0, dotPosition);  // remove ".class"
                names.add(name);
            }
        }
    }
}
