/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config.model;

import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.writer.IConfigExporter;

public class ConfigNullValue
extends ConfigValue {
    @Override
    public boolean isArray() {
        return false;
    }

    @Override
    public boolean isDictionary() {
        return false;
    }

    @Override
    public boolean isNull() {
        return true;
    }

    @Override
    public boolean isScalar() {
        return false;
    }

    public String toString() {
        return "null";
    }

    public boolean equals(Object object) {
        return object instanceof ConfigNullValue;
    }

    @Override
    public void export(IConfigExporter iConfigExporter) {
        iConfigExporter.writeNull();
    }
}

