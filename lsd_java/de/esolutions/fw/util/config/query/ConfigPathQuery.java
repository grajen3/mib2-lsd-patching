/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config.query;

import de.esolutions.fw.util.commons.StringUtils;
import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.query.AbstractConfigQuery;
import de.esolutions.fw.util.config.query.ConfigSimplePathResolver;
import de.esolutions.fw.util.config.query.IConfigPathResolver;

public class ConfigPathQuery
extends AbstractConfigQuery {
    private ConfigValue root;
    private IConfigPathResolver resolver;

    public ConfigPathQuery(ConfigValue configValue) {
        this.root = configValue;
        this.resolver = new ConfigSimplePathResolver();
    }

    public ConfigPathQuery(ConfigValue configValue, IConfigPathResolver iConfigPathResolver) {
        this.root = configValue;
        this.resolver = iConfigPathResolver;
    }

    @Override
    public ConfigValue getValue(String string) {
        String[] stringArray = StringUtils.splitString(string, '.');
        if (stringArray == null) {
            return null;
        }
        return this.resolver.resolvePath(stringArray, this.root);
    }
}

