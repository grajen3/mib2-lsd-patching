/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config;

import de.esolutions.fw.util.config.Config;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ConfigProviderLegacy {
    private static final boolean TRACING_ENABLED = Boolean.getBoolean("trace.config");
    private static final String SYSPROP_CONFIGDIR;
    private static final String DEFAULT_CONFIGDIR;
    private static final String SYSPROP_CONFIG_PREFIX;
    private static final String CONFIG_SUFFIX;
    private static ConfigProviderLegacy provider;
    private Map configMap = new HashMap();
    private String configDirName = System.getProperty("config.dir", "config");

    public static ConfigProviderLegacy getInstance() {
        if (provider == null) {
            provider = new ConfigProviderLegacy();
        }
        return provider;
    }

    private ConfigProviderLegacy() {
    }

    public Config getConfig(String string) {
        if (TRACING_ENABLED) {
            System.out.println(new StringBuffer().append("[CONFIG] Config for following domain requested: ").append(string).toString());
        }
        Config config = null;
        if (this.configMap.containsKey(string)) {
            config = (Config)this.configMap.get(string);
        } else {
            String string2 = new StringBuffer().append(this.configDirName).append(File.separator).append(string).append(".properties").toString();
            String string3 = System.getProperty(new StringBuffer().append("config.file.").append(string).toString(), string2);
            if (TRACING_ENABLED) {
                System.out.println(new StringBuffer().append("[CONFIG] Load config file: ").append(string3).toString());
            }
            config = new Config(string, string3);
            this.configMap.put(string, config);
        }
        return config;
    }
}

