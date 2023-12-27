/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.config;

import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.query.ConfigPathQuery;
import de.esolutions.fw.util.config.query.IConfigQuery;
import de.esolutions.fw.util.tracing.TraceLevels;
import de.esolutions.fw.util.tracing.entity.TraceEntityType;

public class TraceConfigLevels {
    private final IConfigQuery query;

    public TraceConfigLevels(ConfigValue configValue) {
        this.query = new ConfigPathQuery(configValue);
    }

    public short getDefaultTraceLevel(short s) {
        return this.getTraceLevel(s, "*");
    }

    public String[] getPaths(short s) {
        String string = TraceEntityType.names[s];
        ConfigValue configValue = this.query.getDictionary(string);
        if (configValue == null) {
            return null;
        }
        return configValue.getAllDictKeys();
    }

    public short getTraceLevel(short s, String string) {
        String string2 = TraceEntityType.names[s];
        short s2 = 7;
        ConfigValue configValue = this.query.getDictionary(string2);
        if (configValue == null) {
            return s2;
        }
        ConfigValue configValue2 = configValue.getDictValue(string);
        if (configValue2 == null && (configValue2 = configValue.getDictValue(string = string.replace('.', '_'))) == null) {
            return s2;
        }
        String string3 = configValue2.getString();
        if (string3 != null) {
            s2 = TraceConfigLevels.parseTraceLevel(string3);
        }
        return s2;
    }

    public static short parseTraceLevel(String string) {
        String string2 = string.toLowerCase();
        for (short s = 0; s < TraceLevels.levelNames.length; s = (short)(s + 1)) {
            if (!TraceLevels.levelNames[s].toLowerCase().equals(string2)) continue;
            return s;
        }
        if (string2.equals("warning")) {
            return 3;
        }
        return 7;
    }
}

