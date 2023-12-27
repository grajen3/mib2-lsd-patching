/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis.config;

import de.vw.mib.asl.framework.internal.diagnosis.config.PropertyFileManager$1;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileManager {
    private static final String PROP_FILE;
    private final Properties mProperties;

    private PropertyFileManager(Properties properties) {
        this.mProperties = properties;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static PropertyFileManager fromFile() {
        PropertyFileManager propertyFileManager = PropertyFileManager.createDummyPropertyFileManager();
        String string = System.getProperty("diagApi.properties");
        if (string != null) {
            FileInputStream fileInputStream = null;
            try {
                Properties properties = new Properties();
                fileInputStream = new FileInputStream(string);
                properties.load(fileInputStream);
                propertyFileManager = new PropertyFileManager(properties);
            }
            catch (Exception exception) {
                ServiceManager.logger.error(16384).append("DIAGNOSTIC readDiagnosticProperties - ").append(exception.toString()).log();
            }
            finally {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    }
                    catch (IOException iOException) {}
                }
            }
        }
        return propertyFileManager;
    }

    public byte[] merge(String string, byte[] byArray) {
        if (string != null && string.length() != 0) {
            String string2 = this.mProperties.getProperty(new StringBuffer().append(string).append(".value").toString(), "");
            String string3 = this.mProperties.getProperty(new StringBuffer().append(string).append(".mask").toString(), "");
            boolean bl = false;
            if (byArray != null && byArray.length != 0) {
                int n = Math.min(string2.length(), string3.length()) >> 1;
                n = Math.min(byArray.length, n);
                for (int i2 = 0; i2 < n; ++i2) {
                    int n2 = i2 << 1;
                    int n3 = n2 + 2;
                    byte by = (byte)Short.parseShort(string2.substring(n2, n3), 16);
                    byte by2 = (byte)Short.parseShort(string3.substring(n2, n3), 16);
                    bl |= by2 != 0;
                    byArray[i2] = (byte)(byArray[i2] & ~by2 | by & by2);
                }
            } else {
                int n = string2.length() >> 1;
                byArray = new byte[n];
                for (int i3 = 0; i3 < n; ++i3) {
                    int n4 = i3 << 1;
                    int n5 = n4 + 2;
                    byArray[i3] = (byte)Short.parseShort(string2.substring(n4, n5), 16);
                }
            }
            if (bl) {
                ServiceManager.logger.info(16384).append("diagApi.property ").append(string).append(".mask  ").append(string3).log();
                ServiceManager.logger.info(16384).append("diagApi.property ").append(string).append(".value ").append(string2).log();
            }
        }
        return byArray;
    }

    private static PropertyFileManager createDummyPropertyFileManager() {
        return new PropertyFileManager$1(null);
    }

    /* synthetic */ PropertyFileManager(Properties properties, PropertyFileManager$1 var2_2) {
        this(properties);
    }
}

