/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.esolutions.fw.util.config.query;

import de.esolutions.fw.util.config.ConfigValue;

public interface IConfigQuery {
    default public String getStringValue(String string) {
    }

    default public String getStringValue(String string, String string2) {
    }

    default public Integer getIntegerValue(String string) {
    }

    default public int getIntegerValue(String string, int n) {
    }

    default public Boolean getBooleanValue(String string) {
    }

    default public boolean getBooleanValue(String string, boolean bl) {
    }

    default public Double getDoubleValue(String string) {
    }

    default public double getDoubleValue(String string, double d2) {
    }

    default public ConfigValue getArray(String string) {
    }

    default public ConfigValue getDictionary(String string) {
    }

    default public ConfigValue getValue(String string) {
    }
}

