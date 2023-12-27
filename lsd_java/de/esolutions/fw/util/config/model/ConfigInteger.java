/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.esolutions.fw.util.config.model;

import de.esolutions.fw.util.config.model.ConfigScalar;
import de.esolutions.fw.util.config.writer.IConfigExporter;

public class ConfigInteger
extends ConfigScalar {
    private Integer value;

    public ConfigInteger(Integer n) {
        this.value = n;
    }

    public ConfigInteger(int n) {
        this.value = new Integer(n);
    }

    @Override
    public boolean isInteger() {
        return true;
    }

    @Override
    public Integer getInteger() {
        return this.value;
    }

    @Override
    public Integer getInteger(Integer n) {
        if (this.value == null) {
            return n;
        }
        return this.value;
    }

    @Override
    public Boolean convertToBoolean() {
        return new Boolean(this.value != 0);
    }

    @Override
    public Integer convertToInteger() {
        return this.value;
    }

    @Override
    public Double convertToDouble() {
        return new Double((double)this.value.intValue());
    }

    @Override
    public String convertToString() {
        return this.value.toString();
    }

    public String toString() {
        return this.value.toString();
    }

    public boolean equals(Object object) {
        if (!(object instanceof ConfigInteger)) {
            return false;
        }
        ConfigInteger configInteger = (ConfigInteger)object;
        return this.value.equals(configInteger.value);
    }

    public int hashCode() {
        int n = 1;
        n = n * 17 + (this.value == null ? 0 : this.value.hashCode());
        return n;
    }

    @Override
    public void export(IConfigExporter iConfigExporter) {
        if (this.value == null) {
            iConfigExporter.writeNull();
        } else {
            iConfigExporter.writeInteger(this.value);
        }
    }
}

