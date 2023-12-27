/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config;

import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.model.ConfigString;

public class ConfigValueHelper {
    public static ConfigValue createConfigLong(long l) {
        return new ConfigString(Long.toString(l));
    }

    public static Long getConfigLong(ConfigValue configValue) {
        if (configValue == null) {
            return null;
        }
        if (!configValue.isString()) {
            return null;
        }
        String string = configValue.getString();
        if (string == null) {
            return null;
        }
        return new Long(Long.parseLong(string));
    }
}

