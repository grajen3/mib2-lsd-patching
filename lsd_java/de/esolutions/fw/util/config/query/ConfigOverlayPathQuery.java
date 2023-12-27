/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config.query;

import de.esolutions.fw.util.commons.StringUtils;
import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.query.AbstractConfigQuery;
import de.esolutions.fw.util.config.query.ConfigSimplePathResolver;
import de.esolutions.fw.util.config.query.IConfigPathResolver;
import java.util.ArrayList;

public class ConfigOverlayPathQuery
extends AbstractConfigQuery {
    private ConfigValue[] roots;
    private IConfigPathResolver resolver;

    public ConfigOverlayPathQuery(ConfigValue configValue, ConfigValue configValue2) {
        this.roots = new ConfigValue[]{configValue, configValue2};
        this.resolver = new ConfigSimplePathResolver();
    }

    public ConfigOverlayPathQuery(ConfigValue[] configValueArray) {
        this.roots = configValueArray;
        this.resolver = new ConfigSimplePathResolver();
    }

    public ConfigOverlayPathQuery(ConfigValue configValue, ConfigValue configValue2, IConfigPathResolver iConfigPathResolver) {
        this.roots = new ConfigValue[]{configValue, configValue2};
        this.resolver = iConfigPathResolver;
    }

    public ConfigOverlayPathQuery(ConfigValue[] configValueArray, IConfigPathResolver iConfigPathResolver) {
        this.roots = configValueArray;
        this.resolver = iConfigPathResolver;
    }

    @Override
    public ConfigValue getValue(String string) {
        String[] stringArray = StringUtils.splitString(string, '.');
        if (stringArray == null) {
            return null;
        }
        for (int i2 = 0; i2 < this.roots.length; ++i2) {
            ConfigValue configValue;
            if (this.roots[i2] == null || (configValue = this.resolver.resolvePath(stringArray, this.roots[i2])) == null) continue;
            return configValue;
        }
        return null;
    }

    public static ConfigOverlayPathQuery createPackagePathQuery(ConfigValue configValue, String string, String string2) {
        ArrayList arrayList = new ArrayList(10);
        int n = string.length();
        do {
            String string3 = string.substring(0, n);
            arrayList.add(string3);
        } while ((n = string.lastIndexOf(46, n - 1)) > 0);
        if (string2 != null) {
            arrayList.add(string2);
        }
        int n2 = arrayList.size();
        ConfigValue[] configValueArray = new ConfigValue[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            configValueArray[i2] = configValue.getDictValue((String)arrayList.get(i2));
        }
        return new ConfigOverlayPathQuery(configValueArray);
    }
}

