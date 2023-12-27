/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.esolutions.fw.util.config.model;

import de.esolutions.fw.util.config.model.ConfigScalar;
import de.esolutions.fw.util.config.writer.IConfigExporter;

public class ConfigBoolean
extends ConfigScalar {
    private Boolean value;

    public ConfigBoolean(boolean bl) {
        this.value = new Boolean(bl);
    }

    public ConfigBoolean(Boolean bl) {
        this.value = bl;
    }

    @Override
    public boolean isBoolean() {
        return true;
    }

    @Override
    public Boolean getBoolean() {
        return this.value;
    }

    @Override
    public Boolean getBoolean(Boolean bl) {
        if (this.value == null) {
            return bl;
        }
        return this.value;
    }

    @Override
    public Boolean convertToBoolean() {
        return this.value;
    }

    @Override
    public Integer convertToInteger() {
        return new Integer(this.value != false ? 1 : 0);
    }

    @Override
    public Double convertToDouble() {
        return new Double(this.value != false ? 1.0 : 0.0);
    }

    @Override
    public String convertToString() {
        return this.value.toString();
    }

    public String toString() {
        return this.value.toString();
    }

    public boolean equals(Object object) {
        if (!(object instanceof ConfigBoolean)) {
            return false;
        }
        ConfigBoolean configBoolean = (ConfigBoolean)object;
        return this.value.equals(configBoolean.value);
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
            iConfigExporter.writeBoolean(this.value);
        }
    }
}

