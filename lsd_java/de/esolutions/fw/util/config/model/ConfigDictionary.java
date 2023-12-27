/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config.model;

import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.writer.IConfigExporter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ConfigDictionary
extends ConfigValue {
    private HashMap dict = new HashMap();

    public void addValue(String string, ConfigValue configValue) {
        this.dict.put(string, configValue);
    }

    public void removeValue(String string) {
        this.dict.remove(string);
    }

    @Override
    public boolean isArray() {
        return false;
    }

    @Override
    public boolean isDictionary() {
        return true;
    }

    @Override
    public boolean isNull() {
        return false;
    }

    @Override
    public boolean isScalar() {
        return false;
    }

    @Override
    public boolean hasDictValue(String string) {
        return this.dict.containsKey(string);
    }

    @Override
    public ConfigValue getDictValue(String string) {
        return (ConfigValue)this.dict.get(string);
    }

    @Override
    public String[] getAllDictKeys() {
        Set set = this.dict.keySet();
        int n = set.size();
        String[] stringArray = new String[n];
        Iterator iterator = set.iterator();
        for (int i2 = 0; i2 < n; ++i2) {
            stringArray[i2] = (String)iterator.next();
        }
        return stringArray;
    }

    @Override
    public ConfigValue[] getAllDictValues() {
        Collection collection = this.dict.values();
        int n = collection.size();
        ConfigValue[] configValueArray = new ConfigValue[n];
        Iterator iterator = collection.iterator();
        for (int i2 = 0; i2 < n; ++i2) {
            configValueArray[i2] = (ConfigValue)iterator.next();
        }
        return configValueArray;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        Iterator iterator = this.dict.keySet().iterator();
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            stringBuffer.append(string);
            stringBuffer.append(":");
            stringBuffer.append(this.dict.get(string).toString());
            if (!iterator.hasNext()) continue;
            stringBuffer.append(",");
        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    public boolean equals(Object object) {
        if (!(object instanceof ConfigDictionary)) {
            return false;
        }
        ConfigDictionary configDictionary = (ConfigDictionary)object;
        if (configDictionary.dict.size() != this.dict.size()) {
            return false;
        }
        Iterator iterator = this.dict.keySet().iterator();
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            Object object2 = this.dict.get(string);
            Object object3 = configDictionary.dict.get(string);
            if (object3 == null) {
                return false;
            }
            if (object2.equals(object3)) continue;
            return false;
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 17 + (this.dict == null ? 0 : this.dict.hashCode());
        return n;
    }

    @Override
    public void export(IConfigExporter iConfigExporter) {
        iConfigExporter.beginDictionary(this, this.dict.size());
        Iterator iterator = this.dict.keySet().iterator();
        int n = 0;
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            ConfigValue configValue = (ConfigValue)this.dict.get(string);
            boolean bl = !iterator.hasNext();
            iConfigExporter.beginDictEntry(n, string);
            configValue.export(iConfigExporter);
            iConfigExporter.endDictEntry(bl);
            ++n;
        }
        iConfigExporter.endDictionary();
    }
}

