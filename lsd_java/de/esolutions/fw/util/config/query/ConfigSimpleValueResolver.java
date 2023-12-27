/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config.query;

import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.query.IConfigValueResolver;

public class ConfigSimpleValueResolver
implements IConfigValueResolver {
    @Override
    public ConfigValue getInArray(ConfigValue configValue, String string) {
        try {
            int n = Integer.parseInt(string);
            int n2 = configValue.getArraySize();
            if (n < 0 || n >= n2) {
                return null;
            }
            return configValue.getArrayValue(n);
        }
        catch (NumberFormatException numberFormatException) {
            return null;
        }
    }

    @Override
    public ConfigValue getInDictionary(ConfigValue configValue, String string) {
        return configValue.getDictValue(string);
    }
}

