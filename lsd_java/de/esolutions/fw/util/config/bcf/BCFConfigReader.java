/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.esolutions.fw.util.config.bcf;

import de.esolutions.fw.util.commons.StringConverter;
import de.esolutions.fw.util.commons.miniser.BEMiniIntDeserializer;
import de.esolutions.fw.util.commons.miniser.IMiniIntDeserializer;
import de.esolutions.fw.util.commons.miniser.LEMiniIntDeserializer;
import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.model.ConfigArray;
import de.esolutions.fw.util.config.model.ConfigBoolean;
import de.esolutions.fw.util.config.model.ConfigDictionary;
import de.esolutions.fw.util.config.model.ConfigDouble;
import de.esolutions.fw.util.config.model.ConfigInteger;
import de.esolutions.fw.util.config.model.ConfigNullValue;
import de.esolutions.fw.util.config.model.ConfigString;
import de.esolutions.fw.util.config.reader.IConfigReader;
import de.esolutions.fw.util.config.reader.ReadConfigException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class BCFConfigReader
implements IConfigReader {
    private boolean bits32;
    private boolean littleEndian;
    private int version;
    private int numElements;
    private int elementBytes;
    private int stringBytes;
    private IMiniIntDeserializer deserializer;
    private byte[] rawStrings;
    private int[] elements;

    @Override
    public ConfigValue readFromInputStream(InputStream inputStream, ConfigDictionary configDictionary) {
        try {
            this.readHeader(inputStream);
            configDictionary.addValue("bits32", new ConfigBoolean(this.bits32));
            configDictionary.addValue("littleEndian", new ConfigBoolean(this.littleEndian));
            configDictionary.addValue("numElements", new ConfigInteger(this.numElements));
            configDictionary.addValue("version", new ConfigInteger(this.version));
            byte[] byArray = new byte[this.elementBytes];
            this.rawStrings = new byte[this.stringBytes];
            inputStream.read(byArray);
            inputStream.read(this.rawStrings);
            this.elements = this.getElements(byArray);
            ConfigValue configValue = this.createConfigValue(0);
            this.elements = null;
            this.rawStrings = null;
            return configValue;
        }
        catch (IOException iOException) {
            throw new ReadConfigException(new StringBuffer().append("IO: ").append(iOException.getMessage()).toString());
        }
    }

    private ConfigValue createConfigValue(int n) {
        ConfigValue configValue;
        int n2 = this.elements[n];
        int n3 = this.elements[n + 1];
        switch (n2) {
            case 1: {
                int n4 = this.elements[n3];
                int n5 = this.elements[n3 + 1] * 2;
                int n6 = n3 + 2;
                ConfigDictionary configDictionary = new ConfigDictionary();
                for (int i2 = 0; i2 < n4; ++i2) {
                    int n7 = this.elements[n6 + i2];
                    String string = this.getString(n7);
                    ConfigValue configValue2 = this.createConfigValue(n5 + i2 * 2);
                    configDictionary.addValue(string, configValue2);
                }
                configValue = configDictionary;
                break;
            }
            case 2: {
                int n8 = this.elements[n3];
                int n9 = this.elements[n3 + 1] * 2;
                ConfigArray configArray = new ConfigArray();
                for (int i3 = 0; i3 < n8; ++i3) {
                    ConfigValue configValue3 = this.createConfigValue(n9 + i3 * 2);
                    configArray.addValue(configValue3);
                }
                configValue = configArray;
                break;
            }
            case 8: {
                configValue = new ConfigNullValue();
                break;
            }
            case 7: {
                configValue = new ConfigBoolean(false);
                break;
            }
            case 6: {
                configValue = new ConfigBoolean(true);
                break;
            }
            case 9: {
                configValue = new ConfigString(this.getString(n3));
                break;
            }
            case 5: {
                String string = this.getString(n3);
                double d2 = Double.parseDouble((String)string);
                configValue = new ConfigDouble(d2);
                break;
            }
            case 3: {
                configValue = new ConfigInteger(n3);
                break;
            }
            case 4: {
                String string = this.getString(n3);
                int n10 = Integer.parseInt(string);
                configValue = new ConfigInteger(n10);
                break;
            }
            default: {
                throw new ReadConfigException(new StringBuffer().append("Invalid BCF Element Type: ").append(n2).toString());
            }
        }
        return configValue;
    }

    private String getString(int n) {
        int n2 = 0;
        int n3 = n;
        while (this.rawStrings[n3] != 0) {
            ++n3;
            ++n2;
        }
        byte[] byArray = new byte[n2];
        System.arraycopy((Object)this.rawStrings, n, (Object)byArray, 0, n2);
        try {
            String string = StringConverter.UTF8.getString(byArray);
            return string;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            return new String(byArray);
        }
    }

    private int[] getElements(byte[] byArray) {
        int n = this.elementBytes;
        n = this.bits32 ? (n /= 4) : (n /= 2);
        int[] nArray = new int[n];
        if (this.bits32) {
            int n2 = 0;
            for (int i2 = 0; i2 < n; ++i2) {
                nArray[i2] = this.deserializer.retrieveInt(byArray, n2);
                n2 += 4;
            }
        } else {
            int n3 = 0;
            for (int i3 = 0; i3 < n; ++i3) {
                nArray[i3] = this.deserializer.retrieveShort(byArray, n3);
                n3 += 2;
            }
        }
        return nArray;
    }

    private void readHeader(InputStream inputStream) {
        byte[] byArray = new byte[16];
        inputStream.read(byArray);
        if (byArray[0] != -27 || byArray[1] != 11 || byArray[2] != -49) {
            throw new ReadConfigException("No BCF Header found!");
        }
        byte by = byArray[3];
        this.version = byArray[3] >> 4;
        if (this.version != 1) {
            throw new ReadConfigException("Invalid BCF Version found!");
        }
        this.littleEndian = (by & 1) == 1;
        this.bits32 = (by & 2) == 2;
        this.deserializer = this.littleEndian ? new LEMiniIntDeserializer() : new BEMiniIntDeserializer();
        this.numElements = this.deserializer.retrieveInt(byArray, 4);
        this.elementBytes = this.deserializer.retrieveInt(byArray, 8);
        this.stringBytes = this.deserializer.retrieveInt(byArray, 12);
    }
}

