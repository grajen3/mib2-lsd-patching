/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.esolutions.fw.util.config;

import de.esolutions.fw.util.config.writer.IConfigExporter;

public abstract class ConfigValue {
    public abstract boolean isNull() {
    }

    public abstract boolean isScalar() {
    }

    public abstract boolean isArray() {
    }

    public abstract boolean isDictionary() {
    }

    public boolean isBoolean() {
        return false;
    }

    public boolean isInteger() {
        return false;
    }

    public boolean isDouble() {
        return false;
    }

    public boolean isString() {
        return false;
    }

    public Boolean getBoolean() {
        return null;
    }

    public Boolean getBoolean(Boolean bl) {
        return null;
    }

    public Integer getInteger() {
        return null;
    }

    public Integer getInteger(Integer n) {
        return null;
    }

    public Double getDouble() {
        return null;
    }

    public Double getDouble(Double d2) {
        return null;
    }

    public String getString() {
        return null;
    }

    public String getString(String string) {
        return null;
    }

    public Boolean convertToBoolean() {
        return null;
    }

    public Integer convertToInteger() {
        return null;
    }

    public Double convertToDouble() {
        return null;
    }

    public String convertToString() {
        return null;
    }

    public int getArraySize() {
        return 0;
    }

    public ConfigValue getArrayValue(int n) {
        return null;
    }

    public boolean hasDictValue(String string) {
        return false;
    }

    public ConfigValue getDictValue(String string) {
        return null;
    }

    public String[] getAllDictKeys() {
        return null;
    }

    public ConfigValue[] getAllDictValues() {
        return null;
    }

    public abstract void export(IConfigExporter iConfigExporter) {
    }
}

