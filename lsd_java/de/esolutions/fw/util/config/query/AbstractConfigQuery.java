/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.esolutions.fw.util.config.query;

import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.query.IConfigQuery;

public abstract class AbstractConfigQuery
implements IConfigQuery {
    @Override
    public abstract ConfigValue getValue(String string) {
    }

    @Override
    public String getStringValue(String string) {
        ConfigValue configValue = this.getValue(string);
        if (configValue == null) {
            return null;
        }
        if (configValue.isString()) {
            return configValue.getString();
        }
        return null;
    }

    @Override
    public String getStringValue(String string, String string2) {
        ConfigValue configValue = this.getValue(string);
        if (configValue == null) {
            return string2;
        }
        if (configValue.isString()) {
            return configValue.getString();
        }
        return string2;
    }

    @Override
    public Integer getIntegerValue(String string) {
        ConfigValue configValue = this.getValue(string);
        if (configValue == null) {
            return null;
        }
        if (configValue.isInteger()) {
            return configValue.getInteger();
        }
        return null;
    }

    @Override
    public int getIntegerValue(String string, int n) {
        ConfigValue configValue = this.getValue(string);
        if (configValue == null) {
            return n;
        }
        if (configValue.isInteger() && configValue.getInteger() != null) {
            return configValue.getInteger();
        }
        return n;
    }

    @Override
    public Boolean getBooleanValue(String string) {
        ConfigValue configValue = this.getValue(string);
        if (configValue == null) {
            return null;
        }
        if (configValue.isBoolean()) {
            return configValue.getBoolean();
        }
        return null;
    }

    @Override
    public boolean getBooleanValue(String string, boolean bl) {
        ConfigValue configValue = this.getValue(string);
        if (configValue == null) {
            return bl;
        }
        if (configValue.isBoolean() && configValue.getBoolean() != null) {
            return configValue.getBoolean();
        }
        return bl;
    }

    @Override
    public Double getDoubleValue(String string) {
        ConfigValue configValue = this.getValue(string);
        if (configValue == null) {
            return null;
        }
        if (configValue.isDouble()) {
            return configValue.getDouble();
        }
        return null;
    }

    @Override
    public double getDoubleValue(String string, double d2) {
        ConfigValue configValue = this.getValue(string);
        if (configValue == null) {
            return d2;
        }
        if (configValue.isDouble() && configValue.getDouble() != null) {
            return configValue.getDouble();
        }
        return d2;
    }

    @Override
    public ConfigValue getArray(String string) {
        ConfigValue configValue = this.getValue(string);
        if (configValue == null) {
            return null;
        }
        if (configValue.isArray()) {
            return configValue;
        }
        return null;
    }

    @Override
    public ConfigValue getDictionary(String string) {
        ConfigValue configValue = this.getValue(string);
        if (configValue == null) {
            return null;
        }
        if (configValue.isDictionary()) {
            return configValue;
        }
        return null;
    }
}

