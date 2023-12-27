/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config.model;

import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.writer.IConfigExporter;
import java.util.ArrayList;
import java.util.ListIterator;

public class ConfigArray
extends ConfigValue {
    private ArrayList list = new ArrayList(10);

    public void addValue(ConfigValue configValue) {
        this.list.add(configValue);
    }

    public void removeValue(ConfigValue configValue) {
        this.list.remove(configValue);
    }

    @Override
    public boolean isArray() {
        return true;
    }

    @Override
    public boolean isDictionary() {
        return false;
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
    public int getArraySize() {
        return this.list.size();
    }

    @Override
    public ConfigValue getArrayValue(int n) {
        return (ConfigValue)this.list.get(n);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        ListIterator listIterator = this.list.listIterator();
        while (listIterator.hasNext()) {
            stringBuffer.append(listIterator.next().toString());
            if (!listIterator.hasNext()) continue;
            stringBuffer.append(",");
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public boolean equals(Object object) {
        if (!(object instanceof ConfigArray)) {
            return false;
        }
        ConfigArray configArray = (ConfigArray)object;
        if (configArray.list.size() != this.list.size()) {
            return false;
        }
        for (int i2 = 0; i2 < this.list.size(); ++i2) {
            if (this.list.get(i2).equals(configArray.list.get(i2))) continue;
            return false;
        }
        return true;
    }

    public int hashCode() {
        int n = 1;
        n = n * 17 + (this.list == null ? 0 : this.list.hashCode());
        return n;
    }

    @Override
    public void export(IConfigExporter iConfigExporter) {
        iConfigExporter.beginArray(this, this.list.size());
        ListIterator listIterator = this.list.listIterator();
        int n = 0;
        while (listIterator.hasNext()) {
            ConfigValue configValue = (ConfigValue)listIterator.next();
            boolean bl = !listIterator.hasNext();
            iConfigExporter.beginArrayEntry(n);
            configValue.export(iConfigExporter);
            iConfigExporter.endArrayEntry(bl);
            ++n;
        }
        iConfigExporter.endArray();
    }
}

