/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.esolutions.fw.util.config.model;

import de.esolutions.fw.util.config.model.ConfigScalar;
import de.esolutions.fw.util.config.writer.IConfigExporter;

public class ConfigDouble
extends ConfigScalar {
    private Double value;

    public ConfigDouble(Double d2) {
        this.value = d2;
    }

    public ConfigDouble(double d2) {
        this.value = new Double(d2);
    }

    @Override
    public boolean isDouble() {
        return true;
    }

    @Override
    public Double getDouble() {
        return this.value;
    }

    @Override
    public Double getDouble(Double d2) {
        if (this.value == null) {
            return d2;
        }
        return this.value;
    }

    @Override
    public Boolean convertToBoolean() {
        return new Boolean((double)this.value.intValue() != 0.0);
    }

    @Override
    public Integer convertToInteger() {
        return new Integer((int)this.value.doubleValue());
    }

    @Override
    public Double convertToDouble() {
        return this.value;
    }

    @Override
    public String convertToString() {
        return this.value.toString();
    }

    public String toString() {
        return this.value.toString();
    }

    public boolean equals(Object object) {
        if (!(object instanceof ConfigDouble)) {
            return false;
        }
        ConfigDouble configDouble = (ConfigDouble)object;
        return this.value.equals((Object)configDouble.value);
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
            iConfigExporter.writeDouble(this.value);
        }
    }
}

