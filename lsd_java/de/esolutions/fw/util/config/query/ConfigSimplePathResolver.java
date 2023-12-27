/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config.query;

import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.query.ConfigSimpleValueResolver;
import de.esolutions.fw.util.config.query.IConfigPathResolver;
import de.esolutions.fw.util.config.query.IConfigValueResolver;

public class ConfigSimplePathResolver
implements IConfigPathResolver {
    private IConfigValueResolver resolver;

    public ConfigSimplePathResolver() {
        this.resolver = new ConfigSimpleValueResolver();
    }

    public ConfigSimplePathResolver(IConfigValueResolver iConfigValueResolver) {
        this.resolver = iConfigValueResolver;
    }

    @Override
    public ConfigValue resolvePath(String[] stringArray, ConfigValue configValue) {
        if (stringArray == null) {
            return configValue;
        }
        ConfigValue configValue2 = configValue;
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            String string = stringArray[i2];
            if (configValue2.isArray()) {
                configValue2 = this.resolver.getInArray(configValue2, string);
            } else if (configValue2.isDictionary()) {
                configValue2 = this.resolver.getInDictionary(configValue2, string);
            } else {
                return null;
            }
            if (configValue2 != null) continue;
            return null;
        }
        return configValue2;
    }
}

