/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config.query;

import de.esolutions.fw.util.config.ConfigValue;

public interface IConfigValueResolver {
    default public ConfigValue getInArray(ConfigValue configValue, String string) {
    }

    default public ConfigValue getInDictionary(ConfigValue configValue, String string) {
    }
}

