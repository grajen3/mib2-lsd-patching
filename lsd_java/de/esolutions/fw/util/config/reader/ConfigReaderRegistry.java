/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config.reader;

import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.bcf.BCFConfigReader;
import de.esolutions.fw.util.config.model.ConfigDictionary;
import de.esolutions.fw.util.config.reader.IConfigReader;
import de.esolutions.fw.util.config.reader.JSONConfigReader;
import de.esolutions.fw.util.config.reader.ReadConfigException;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class ConfigReaderRegistry {
    private static ConfigReaderRegistry registry;
    private static Object lockObject;
    private HashMap readerMap = new HashMap();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ConfigReaderRegistry getInstance() {
        Object object = lockObject;
        synchronized (object) {
            if (registry == null) {
                registry = new ConfigReaderRegistry();
            }
            return registry;
        }
    }

    private ConfigReaderRegistry() {
        this.addReader("json", new JSONConfigReader());
        this.addReader("bcf", new BCFConfigReader());
    }

    private void addReader(String string, IConfigReader iConfigReader) {
        this.readerMap.put(string.toLowerCase(), iConfigReader);
    }

    private IConfigReader queryReader(String string) {
        return (IConfigReader)this.readerMap.get(string.toLowerCase());
    }

    public ConfigValue readFromFile(String string) {
        return this.readFromFile(string, new ConfigDictionary());
    }

    public ConfigValue readFromMemory(String string, byte[] byArray) {
        return this.readFromMemory(string, byArray, new ConfigDictionary());
    }

    public synchronized ConfigValue readFromFile(String string, ConfigDictionary configDictionary) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(string);
        }
        catch (FileNotFoundException fileNotFoundException) {
            throw new ReadConfigException(new StringBuffer().append("File not found: ").append(string).toString());
        }
        return this.readFromInputStream(fileInputStream, string, configDictionary);
    }

    public ConfigValue readFromResource(String string) {
        return this.readFromResource(string, new ConfigDictionary());
    }

    public synchronized ConfigValue readFromResource(String string, ConfigDictionary configDictionary) {
        InputStream inputStream = super.getClass().getResourceAsStream(string);
        return this.readFromInputStream(inputStream, string, configDictionary);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private ConfigValue readFromInputStream(InputStream inputStream, String string, ConfigDictionary configDictionary) {
        int n = string.lastIndexOf(".");
        if (n == -1) {
            throw new ReadConfigException(new StringBuffer().append("No file extension given for resource/file: ").append(string).toString());
        }
        String string2 = string.substring(n + 1);
        IConfigReader iConfigReader = this.queryReader(string2);
        if (iConfigReader == null) {
            throw new ReadConfigException(new StringBuffer().append("No reader for file found for resource: ").append(string).toString());
        }
        if (inputStream == null) {
            throw new ReadConfigException(new StringBuffer().append("No resource/file found: ").append(string).toString());
        }
        try {
            ConfigValue configValue;
            ConfigValue configValue2 = configValue = iConfigReader.readFromInputStream(inputStream, configDictionary);
            inputStream.close();
            return configValue2;
        }
        catch (Throwable throwable) {
            try {
                inputStream.close();
                throw throwable;
            }
            catch (IOException iOException) {
                throw new ReadConfigException(new StringBuffer().append("IO: ").append(iOException.getMessage()).toString());
            }
        }
    }

    public synchronized ConfigValue readFromMemory(String string, byte[] byArray, ConfigDictionary configDictionary) {
        IConfigReader iConfigReader = this.queryReader(string);
        if (iConfigReader == null) {
            throw new ReadConfigException(new StringBuffer().append("No reader for extension found: ").append(string).toString());
        }
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
            ConfigValue configValue = iConfigReader.readFromInputStream(byteArrayInputStream, configDictionary);
            byteArrayInputStream.close();
            return configValue;
        }
        catch (IOException iOException) {
            throw new ReadConfigException(new StringBuffer().append("IO: ").append(iOException.getMessage()).toString());
        }
    }

    static {
        lockObject = new Object();
    }
}

