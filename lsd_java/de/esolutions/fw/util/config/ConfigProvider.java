/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config;

import de.esolutions.fw.util.commons.timeout.ITimeSource;
import de.esolutions.fw.util.commons.timeout.TimeSourceProvider;
import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.model.ConfigDictionary;
import de.esolutions.fw.util.config.query.ConfigPathQuery;
import de.esolutions.fw.util.config.query.IConfigQuery;
import de.esolutions.fw.util.config.reader.ConfigReaderRegistry;
import de.esolutions.fw.util.config.reader.ReadConfigException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ConfigProvider {
    private static final String DEBUG_FLAG;
    private static final String FILE_PREFIX;
    private static final String DIR_PREFIX;
    private static final String ALL_DIR_PREFIX;
    private static final String JSON_SUFFIX;
    private static final String BCF_SUFFIX;
    private static final String STRATEGY_FLAG;
    private static final String RESOURCE_FLAG;
    private static final int STRATEGY_ONLY_JSON;
    private static final int STRATEGY_ONLY_BCF;
    private static final int STRATEGY_JSON_BEFORE_BCF;
    private static final int STRATEGY_BCF_BEFORE_JSON;
    private String domain;
    private String defaultDir;
    private ConfigValue root;
    private boolean trace;
    private IConfigQuery query;
    private boolean valid;
    private String failString;
    private int strategy;
    private String validFileName;
    private String resourceLocation;
    static /* synthetic */ Class class$de$esolutions$fw$util$config$ConfigProvider;

    public ConfigProvider(String string, String string2) {
        this.domain = string;
        this.defaultDir = string2;
        this.root = null;
        this.strategy = 0;
        this.valid = false;
        this.trace = System.getProperty("ipl.config.trace", null) != null;
        this.trace(new StringBuffer().append("ConfigProvider: domain=").append(string).append(" defaultDir=").append(string2).toString());
        this.getStrategy();
        this.performStrategy(false);
        if (!this.valid) {
            this.trace("ConfigProvider: no suitable config file found ");
            this.resourceLocation = System.getProperty("ipl.config.resource", null);
            if (this.resourceLocation != null) {
                this.trace(new StringBuffer().append("ConfigProvider: using config resource path ").append(this.resourceLocation).toString());
                this.performStrategy(true);
                if (!this.valid) {
                    this.trace(new StringBuffer().append("ConfigProvider: no suitable config resource found at ").append(this.resourceLocation).toString());
                }
            } else {
                this.trace("ConfigProvider: no system property for config resource path set ");
            }
            if (!this.valid) {
                this.trace("ConfigProvider: using default config resource path ");
                this.resourceLocation = "/config";
                this.performStrategy(true);
                if (!this.valid) {
                    this.trace(new StringBuffer().append("ConfigProvider: no suitable config resource found at ").append(this.resourceLocation).toString());
                }
            }
        }
        if (!this.valid) {
            this.root = new ConfigDictionary();
            this.trace("ConfigProvider: no valid config file found -> falling back to empty config!");
        }
        this.query = new ConfigPathQuery(this.root);
    }

    private void performStrategy(boolean bl) {
        switch (this.strategy) {
            default: {
                this.loadConfig(true, bl);
                break;
            }
            case 1: {
                this.loadConfig(false, bl);
                break;
            }
            case 3: {
                if (this.loadConfig(false, bl)) break;
                this.loadConfig(true, bl);
                break;
            }
            case 2: {
                if (this.loadConfig(true, bl)) break;
                this.loadConfig(false, bl);
            }
        }
    }

    private boolean existsResource(String string) {
        InputStream inputStream = (class$de$esolutions$fw$util$config$ConfigProvider == null ? (class$de$esolutions$fw$util$config$ConfigProvider = ConfigProvider.class$("de.esolutions.fw.util.config.ConfigProvider")) : class$de$esolutions$fw$util$config$ConfigProvider).getResourceAsStream(string);
        if (inputStream == null) {
            return false;
        }
        try {
            inputStream.close();
        }
        catch (IOException iOException) {
            // empty catch block
        }
        return true;
    }

    private boolean existsFile(String string) {
        File file = new File(string);
        return file.exists();
    }

    private boolean loadConfig(boolean bl, boolean bl2) {
        String string;
        ConfigReaderRegistry configReaderRegistry = ConfigReaderRegistry.getInstance();
        String string2 = string = bl2 ? this.getConfigResourcePath(bl) : this.getConfigFilePath(bl);
        if (bl2 && !this.existsResource(string) || !bl2 && !this.existsFile(string)) {
            System.out.println(new StringBuffer().append("fw_util_config: Failed to load config file from ").append(string).toString());
            return false;
        }
        try {
            if (this.trace) {
                System.out.println(new StringBuffer().append("ConfigProvider(").append(this.domain).append("): loading file ").append(string).toString());
                ITimeSource iTimeSource = TimeSourceProvider.getMonotonicTimeSource();
                long l = iTimeSource.getCurrentTime();
                this.root = bl2 ? configReaderRegistry.readFromResource(string) : configReaderRegistry.readFromFile(string);
                long l2 = iTimeSource.getCurrentTime();
                System.out.println(new StringBuffer().append("ConfigProvider(").append(this.domain).append("): loaded in ").append(l2 - l).append(" ms").toString());
            } else {
                this.root = bl2 ? configReaderRegistry.readFromResource(string) : configReaderRegistry.readFromFile(string);
            }
            this.valid = true;
            this.validFileName = string;
            return true;
        }
        catch (ReadConfigException readConfigException) {
            this.failString = new StringBuffer().append("ConfigProvider(").append(this.domain).append("): READ ERROR: ").append(readConfigException.getMessage()).toString();
            this.trace(new StringBuffer().append("ConfigProvider(").append(this.domain).append("): ").append(this.failString).toString());
            this.valid = false;
            return false;
        }
    }

    private void getStrategy() {
        String string = System.getProperty("ipl.config.strategy");
        if (string == null) {
            return;
        }
        String string2 = string.toLowerCase();
        if (string2.equals("json")) {
            this.strategy = 0;
        } else if (string2.equals("bcf")) {
            this.strategy = 1;
        } else if (string2.equals("jsonbcf")) {
            this.strategy = 2;
        } else if (string2.equals("bcfjson")) {
            this.strategy = 3;
        } else {
            System.out.println("Invalid ipl.config.strategy given! Use: json, bcf, jsonbcf, bcfjson");
        }
    }

    public ConfigValue getRoot() {
        return this.root;
    }

    public IConfigQuery getPathQuery() {
        return this.query;
    }

    public boolean isValid() {
        return this.valid;
    }

    public String getFileName() {
        return this.validFileName;
    }

    public String getFailString() {
        return this.failString;
    }

    public boolean doTraceConfig() {
        return this.trace;
    }

    private String getConfigFileDir() {
        String string = new StringBuffer().append("ipl.config.dir.").append(this.domain).toString();
        String string2 = System.getProperty(string, null);
        if (string2 == null) {
            string2 = System.getProperty("ipl.config.dir", this.defaultDir);
        }
        return string2;
    }

    private String getConfigFilePath(boolean bl) {
        String string = new StringBuffer().append("ipl.config.file.").append(this.domain).toString();
        String string2 = this.getConfigFileDir();
        return new StringBuffer().append(string2).append(File.separator).append(System.getProperty(string, new StringBuffer().append(this.domain).append(bl ? ".json" : ".bcf").toString())).toString();
    }

    private String getConfigResourceDir() {
        return this.resourceLocation;
    }

    private String getConfigResourcePath(boolean bl) {
        String string = new StringBuffer().append("ipl.config.file.").append(this.domain).toString();
        String string2 = this.getConfigResourceDir();
        return new StringBuffer().append(string2).append('/').append(System.getProperty(string, new StringBuffer().append(this.domain).append(bl ? ".json" : ".bcf").toString())).toString();
    }

    private void trace(String string) {
        if (this.trace) {
            System.out.println(string);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

