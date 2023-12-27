/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.esolutions.fw.util.config.reader;

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
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map$Entry;
import java.util.Set;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONConfigReader
implements IConfigReader {
    private JSONParser parser = new JSONParser();

    @Override
    public ConfigValue readFromInputStream(InputStream inputStream, ConfigDictionary configDictionary) {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            Object object = this.parser.parse(inputStreamReader);
            return this.transform(object);
        }
        catch (IOException iOException) {
            throw new ReadConfigException(iOException.getMessage());
        }
        catch (ParseException parseException) {
            throw new ReadConfigException(parseException.getMessage());
        }
    }

    private ConfigValue transform(Object object) {
        if (object == null) {
            return new ConfigNullValue();
        }
        if (object instanceof JSONObject) {
            HashMap hashMap = (HashMap)object;
            ConfigDictionary configDictionary = new ConfigDictionary();
            Set set = hashMap.entrySet();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                Map$Entry map$Entry = (Map$Entry)iterator.next();
                Object object2 = map$Entry.getValue();
                String string = (String)map$Entry.getKey();
                ConfigValue configValue = this.transform(object2);
                configDictionary.addValue(string, configValue);
            }
            return configDictionary;
        }
        if (object instanceof JSONArray) {
            ArrayList arrayList = (ArrayList)object;
            ConfigArray configArray = new ConfigArray();
            ListIterator listIterator = arrayList.listIterator();
            while (listIterator.hasNext()) {
                Object object3 = listIterator.next();
                ConfigValue configValue = this.transform(object3);
                configArray.addValue(configValue);
            }
            return configArray;
        }
        if (object instanceof String) {
            return new ConfigString((String)object);
        }
        if (object instanceof Long) {
            Long l = (Long)object;
            return new ConfigInteger(l.intValue());
        }
        if (object instanceof Boolean) {
            return new ConfigBoolean((Boolean)object);
        }
        if (object instanceof Double) {
            return new ConfigDouble((Double)object);
        }
        throw new ReadConfigException(new StringBuffer().append("Invalid class in parsed JSON: ").append(object.getClass().getName()).toString());
    }
}

