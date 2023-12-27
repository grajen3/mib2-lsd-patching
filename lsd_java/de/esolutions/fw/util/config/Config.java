/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;

public class Config {
    public static final int NONE;
    private static final boolean TRACING_ENABLED;
    private static final String GLOBAL_SYSPROP_PREFIX;
    private String domain;
    private String fileName;
    private String sysPropPrefix;
    private Properties properties;

    protected Config(String string, String string2) {
        this.domain = string;
        this.fileName = string2;
        this.sysPropPrefix = new StringBuffer().append("config.").append(string).append(".").toString();
        this.loadPropertyFile();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void loadPropertyFile() {
        this.properties = new Properties();
        File file = new File(this.fileName);
        if (file.exists()) {
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(file);
                this.properties.load(fileInputStream);
            }
            catch (Exception exception) {
                if (TRACING_ENABLED) {
                    System.out.println(new StringBuffer().append("[CONFIG] Error happened during property file loading: domain=").append(this.domain).append(", file=").append(this.fileName).append(", message=").append(exception.getMessage()).toString());
                }
            }
            finally {
                try {
                    fileInputStream.close();
                }
                catch (IOException iOException) {}
            }
        }
    }

    public String[] getKeys(String string, String string2) {
        if (this.properties != null) {
            ArrayList arrayList = new ArrayList(this.properties.size());
            Enumeration enumeration = this.properties.keys();
            while (enumeration.hasMoreElements()) {
                String string3 = (String)enumeration.nextElement();
                if (string != null && (!string3.startsWith(string) || string2 != null && !string3.endsWith(string2))) continue;
                arrayList.add(string3);
            }
            return (String[])arrayList.toArray(new String[arrayList.size()]);
        }
        return new String[0];
    }

    public String getStringValue(String string) {
        return this.readProperty(string);
    }

    public String getStringValue(String string, String string2) {
        String string3 = this.readProperty(string);
        if (string3 == null) {
            string3 = string2;
        }
        return string3;
    }

    public int getIntValue(String string) {
        int n = -1;
        String string2 = this.readProperty(string);
        if (string2 != null) {
            n = Integer.parseInt(string2);
        }
        return n;
    }

    public int getIntValue(String string, int n) {
        int n2 = -1;
        String string2 = this.readProperty(string);
        n2 = string2 == null ? n : Integer.parseInt(string2);
        return n2;
    }

    public boolean getBooleanValue(String string) {
        boolean bl = false;
        String string2 = this.readProperty(string);
        if (string2 != null) {
            bl = Boolean.valueOf(string2);
        }
        return bl;
    }

    public boolean getBooleanValue(String string, boolean bl) {
        boolean bl2 = false;
        String string2 = this.readProperty(string);
        bl2 = string2 == null ? bl : Boolean.valueOf(string2);
        return bl2;
    }

    private String readProperty(String string) {
        String string2 = new StringBuffer().append(this.sysPropPrefix).append(string).toString();
        String string3 = System.getProperty(string2);
        if (string3 != null) {
            if (TRACING_ENABLED) {
                System.out.println(new StringBuffer().append("[CONFIG] Requested property defined in system environment: domain=").append(this.domain).append(", system=").append(string2).append(", key=").append(string).append(", value=").append(string3).toString());
            }
        } else if (string3 == null && this.properties != null && this.properties.containsKey(string)) {
            string3 = this.properties.getProperty(string);
            if (TRACING_ENABLED) {
                System.out.println(new StringBuffer().append("[CONFIG] Requested property defined in property file: domain=").append(this.domain).append(", file=").append(this.fileName).append(", key=").append(string).append(", value=").append(string3).toString());
            }
        }
        if (string3 != null && string3.equals("null")) {
            string3 = null;
        }
        return string3;
    }

    static {
        TRACING_ENABLED = Boolean.getBoolean("trace.config");
    }
}

