/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config.model;

import de.esolutions.fw.util.config.model.ConfigScalar;
import de.esolutions.fw.util.config.writer.IConfigExporter;

public class ConfigString
extends ConfigScalar {
    private String value;

    public ConfigString(String string) {
        this.value = string;
    }

    @Override
    public boolean isString() {
        return true;
    }

    @Override
    public String getString() {
        return this.value;
    }

    @Override
    public String getString(String string) {
        if (this.value == null) {
            return string;
        }
        return this.value;
    }

    @Override
    public String convertToString() {
        return this.value;
    }

    public String toString() {
        return new StringBuffer().append("\"").append(this.value).append("\"").toString();
    }

    public boolean equals(Object object) {
        if (!(object instanceof ConfigString)) {
            return false;
        }
        ConfigString configString = (ConfigString)object;
        return this.value.equals(configString.value);
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
            iConfigExporter.writeString(this.value);
        }
    }
}

