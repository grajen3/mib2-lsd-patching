/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.configuration.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileHelper {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Properties readPropertiesFromFile(String string) {
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(string);
            properties.load(fileInputStream);
            Properties properties2 = properties;
            return properties2;
        }
        catch (FileNotFoundException fileNotFoundException) {
            properties = null;
        }
        catch (IOException iOException) {
            properties = null;
        }
        finally {
            if (fileInputStream != null) {
                try {
                    ((InputStream)fileInputStream).close();
                }
                catch (IOException iOException) {}
            }
        }
        return properties;
    }
}

