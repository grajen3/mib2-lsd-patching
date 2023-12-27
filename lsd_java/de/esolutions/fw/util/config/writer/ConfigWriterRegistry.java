/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config.writer;

import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.bcf.BCFConfigWriter;
import de.esolutions.fw.util.config.model.ConfigDictionary;
import de.esolutions.fw.util.config.writer.IConfigWriter;
import de.esolutions.fw.util.config.writer.JSONConfigWriter;
import de.esolutions.fw.util.config.writer.WriteConfigException;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

public class ConfigWriterRegistry {
    private static ConfigWriterRegistry registry;
    private HashMap writerMap = new HashMap();

    public static synchronized ConfigWriterRegistry getInstance() {
        if (registry == null) {
            registry = new ConfigWriterRegistry();
        }
        return registry;
    }

    private ConfigWriterRegistry() {
        this.addWriter("json", new JSONConfigWriter());
        this.addWriter("bcf", new BCFConfigWriter());
    }

    private void addWriter(String string, IConfigWriter iConfigWriter) {
        this.writerMap.put(string.toLowerCase(), iConfigWriter);
    }

    private IConfigWriter queryWriter(String string) {
        return (IConfigWriter)this.writerMap.get(string.toLowerCase());
    }

    public void writeToFile(String string, ConfigValue configValue) {
        this.writeToFile(string, configValue, new ConfigDictionary());
    }

    public byte[] writeToMemory(String string, ConfigValue configValue) {
        return this.writeToMemory(string, configValue, new ConfigDictionary());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public synchronized void writeToFile(String string, ConfigValue configValue, ConfigDictionary configDictionary) {
        int n = string.lastIndexOf(".");
        if (n == -1) {
            throw new WriteConfigException(new StringBuffer().append("No file extension given: ").append(string).toString());
        }
        String string2 = string.substring(n + 1);
        IConfigWriter iConfigWriter = this.queryWriter(string2);
        if (iConfigWriter == null) {
            throw new WriteConfigException(new StringBuffer().append("No writer for file found: ").append(string).toString());
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(string);
            try {
                iConfigWriter.writeToOutputStream(fileOutputStream, configValue, configDictionary);
            }
            finally {
                ((OutputStream)fileOutputStream).close();
            }
        }
        catch (IOException iOException) {
            throw new WriteConfigException(new StringBuffer().append("Can't open file: ").append(string).toString());
        }
    }

    public synchronized byte[] writeToMemory(String string, ConfigValue configValue, ConfigDictionary configDictionary) {
        IConfigWriter iConfigWriter = this.queryWriter(string);
        if (iConfigWriter == null) {
            throw new WriteConfigException(new StringBuffer().append("No writer for extension found: ").append(string).toString());
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        iConfigWriter.writeToOutputStream(byteArrayOutputStream, configValue, configDictionary);
        return byteArrayOutputStream.toByteArray();
    }
}

