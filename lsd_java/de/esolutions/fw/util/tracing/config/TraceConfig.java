/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.config;

import de.esolutions.fw.util.commons.StringUtils;
import de.esolutions.fw.util.commons.traceme.TraceMe;
import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.query.ConfigOverlayPathQuery;
import de.esolutions.fw.util.config.query.ConfigPathQuery;
import de.esolutions.fw.util.config.query.IConfigQuery;
import de.esolutions.fw.util.config.reader.ConfigReaderRegistry;
import de.esolutions.fw.util.config.reader.ReadConfigException;
import de.esolutions.fw.util.tracing.config.TraceConfigBackend;
import de.esolutions.fw.util.tracing.config.TraceConfigDecoder;
import de.esolutions.fw.util.tracing.config.TraceConfigFileTransfer;
import de.esolutions.fw.util.tracing.config.TraceConfigFormatter;
import de.esolutions.fw.util.tracing.config.TraceConfigLevels;
import de.esolutions.fw.util.tracing.config.TraceConfigPlugin;
import de.esolutions.fw.util.tracing.config.TraceConfigProvider;
import java.io.File;

public final class TraceConfig {
    private String name;
    private String coreClass;
    private boolean isValid;
    private String failString;
    private TraceConfigProvider configProvider;
    private IConfigQuery currentQuery;
    private TraceConfigBackend[] backends;
    private TraceConfigPlugin[] plugins;
    private TraceConfigDecoder[] decoders;
    private TraceConfigFormatter[] formatters;
    private TraceConfigLevels levels;
    private TraceConfigFileTransfer fileTransfer;
    private boolean enabled = true;
    private String traceMe = null;
    private String traceMeLogFile = null;
    private int messageBufferSize = 256;
    private int messageBufferStartupSize = 0;
    private int messageBufferThreshold = 64;
    private int messageBufferFlushInterval = 1000;
    private int commandBufferSize = 256;
    private int maxBackends = 8;
    private int entityPoolSize = 4096;
    private int entityFlushInterval = 500;
    private boolean useDefaultConsole = false;
    private boolean allowOverwrite = false;
    private String emergencyLogFile = null;
    private boolean omitMessagePrefix = false;
    private boolean enforceSpeedLimit = false;
    private int lowerSizeLimit = 0;
    private int upperSizeLimit = 0;
    private int lowerCountLimit = 0;
    private int upperCountLimit = 0;
    private int checkIntervals = 100;
    private int maxCount = 4096;
    private String disableSpeedLimitFile = "/var/tracing_disable_speedlimit";
    private int maxTimeZones = 16;
    private boolean ignoreStartupPreset = false;
    private String startupPresetFile = "savedpreset.json";
    private String configPath = "./config";
    private boolean enableCoreStatistics = false;
    private int coreStatisticsInterval = 10000;
    private Integer traceCoreCPU = null;
    private static final String chn;

    public TraceConfig(String string, String string2) {
        this.name = string;
        this.coreClass = string2;
        this.isValid = true;
    }

    public boolean readConfig() {
        return this.readConfig(null);
    }

    public boolean readConfigFromFile(String string) {
        if (string == null) {
            return false;
        }
        File file = new File(string);
        if (file.exists()) {
            try {
                ConfigValue configValue = ConfigReaderRegistry.getInstance().readFromFile(string);
                return this.readConfig(configValue);
            }
            catch (ReadConfigException readConfigException) {
                this.failString = new StringBuffer().append("ERROR reading tracing config: ").append(string).append(": ").append(readConfigException.getMessage()).toString();
                return false;
            }
        }
        this.failString = new StringBuffer().append("Can't find config file: ").append(string).toString();
        return false;
    }

    public boolean readConfig(ConfigValue configValue) {
        IConfigQuery iConfigQuery;
        if (this.coreClass.compareTo("client") == 0) {
            this.enabled = false;
            this.allowOverwrite = true;
        }
        if (configValue == null) {
            this.configProvider = TraceConfigProvider.getInstance();
            if (!this.configProvider.isValid()) {
                this.failString = new StringBuffer().append("Trace config provider is not valid: ").append(this.configProvider.getFailString()).toString();
                this.isValid = false;
                return false;
            }
            String string = this.configProvider.getFileName();
            TraceMe.msg(TraceMe.INFO, "Config", "loaded config: %1", string);
            iConfigQuery = this.configProvider.getPathQuery();
            File file = new File(string);
            this.configPath = file.getParent();
        } else {
            iConfigQuery = new ConfigPathQuery(configValue);
        }
        this.useDefaultConsole = true;
        boolean bl = this.parseQuery(iConfigQuery);
        if (bl && !this.ignoreStartupPreset) {
            this.overlayStartupPreset();
        }
        this.logConfig();
        return bl;
    }

    private String getOverlayPresetName(ConfigValue configValue) {
        ConfigValue configValue2 = configValue.getDictValue("saved");
        if (configValue2 != null) {
            return "saved";
        }
        String[] stringArray = configValue.getAllDictKeys();
        if (stringArray == null) {
            return null;
        }
        if (stringArray.length == 0) {
            return null;
        }
        return stringArray[0];
    }

    private void overlayStartupPreset() {
        TraceMe.msg(TraceMe.INFO, "Config", "looking for overlayStartupPreset: %1", this.startupPresetFile);
        File file = new File(this.startupPresetFile);
        if (file.exists() && file.isFile()) {
            TraceMe.msg(TraceMe.INFO, "Config", "-> found file");
            try {
                ConfigReaderRegistry configReaderRegistry = ConfigReaderRegistry.getInstance();
                ConfigValue configValue = configReaderRegistry.readFromFile(this.startupPresetFile);
                if (configValue != null) {
                    String string = this.getOverlayPresetName(configValue);
                    if (string != null) {
                        ConfigPathQuery configPathQuery = new ConfigPathQuery(configValue);
                        String string2 = new StringBuffer().append(string).append(".").append(this.name).append(".levels").toString();
                        ConfigValue configValue2 = configPathQuery.getDictionary(string2);
                        if (configValue2 != null) {
                            TraceMe.msg(TraceMe.INFO, "Config", "-> replacing levels with overlay at %1", string2);
                            this.overlayLevels(configValue2);
                        } else {
                            TraceMe.msg(TraceMe.INFO, "Config", "-> failed findind key: %1", string2);
                        }
                    } else {
                        TraceMe.msg(TraceMe.INFO, "Config", "-> no preset found in file");
                    }
                } else {
                    TraceMe.msg(TraceMe.INFO, "Config", "-> failed reading: no root!");
                }
            }
            catch (ReadConfigException readConfigException) {
                TraceMe.msg(TraceMe.ERROR, "Config", "-> failed reading: %1", readConfigException);
            }
        }
    }

    public TraceConfigFileTransfer getFileTransfer() {
        return this.fileTransfer;
    }

    public boolean parseQuery(IConfigQuery iConfigQuery) {
        char c2;
        ConfigValue configValue;
        ConfigValue configValue2;
        ConfigValue configValue3;
        ConfigValue configValue4;
        ConfigValue configValue5 = iConfigQuery.getDictionary("decoders");
        if (configValue5 != null) {
            this.parseMessageDecoders(configValue5);
        }
        if ((configValue4 = iConfigQuery.getDictionary("formatters")) != null) {
            this.parseMessageFormatters(configValue4);
        }
        ConfigValue configValue6 = iConfigQuery.getDictionary(new StringBuffer().append(this.coreClass).append(".default").toString());
        ConfigValue configValue7 = iConfigQuery.getDictionary(new StringBuffer().append(this.coreClass).append(".").append(this.name).toString());
        if (configValue6 == null && configValue7 == null) {
            this.failString = new StringBuffer().append("Neither default nor proc client entry found for ").append(this.coreClass).append(" ").append(this.name).toString();
            System.out.println(this.failString);
            return false;
        }
        this.currentQuery = new ConfigOverlayPathQuery(configValue7, configValue6);
        this.enabled = this.currentQuery.getBooleanValue("enabled", this.enabled);
        this.traceMe = this.currentQuery.getStringValue("core.traceMe", this.traceMe);
        this.traceCoreCPU = this.currentQuery.getIntegerValue("core.traceCoreCPU");
        this.traceMeLogFile = this.currentQuery.getStringValue("core.traceMeLogFile", this.traceMeLogFile);
        this.messageBufferSize = this.currentQuery.getIntegerValue("core.messageBufferSize", this.messageBufferSize);
        this.messageBufferStartupSize = this.currentQuery.getIntegerValue("core.startupMessageBufferSize", this.messageBufferStartupSize);
        this.messageBufferThreshold = this.currentQuery.getIntegerValue("core.messageBufferThreshold", this.messageBufferThreshold);
        this.messageBufferFlushInterval = this.currentQuery.getIntegerValue("core.messageBufferFlushInterval", this.messageBufferFlushInterval);
        this.commandBufferSize = this.currentQuery.getIntegerValue("core.commandBufferSize", this.commandBufferSize);
        this.maxBackends = this.currentQuery.getIntegerValue("core.maxBackends", this.maxBackends);
        this.entityPoolSize = this.currentQuery.getIntegerValue("core.entityPoolSize", this.entityPoolSize);
        this.entityFlushInterval = this.currentQuery.getIntegerValue("core.entityFlushInterval", this.entityFlushInterval);
        this.useDefaultConsole = this.currentQuery.getBooleanValue("core.useDefaultConsole", this.useDefaultConsole);
        this.allowOverwrite = this.currentQuery.getBooleanValue("core.allowOverwrite", this.allowOverwrite);
        this.emergencyLogFile = this.currentQuery.getStringValue("core.emergencyLogFile", this.emergencyLogFile);
        this.omitMessagePrefix = this.currentQuery.getBooleanValue("core.omitMessagePrefix", this.omitMessagePrefix);
        this.enforceSpeedLimit = this.currentQuery.getBooleanValue("core.enforceSpeedLimit", this.enforceSpeedLimit);
        this.lowerSizeLimit = this.currentQuery.getIntegerValue("core.lowerSizeLimit", this.lowerSizeLimit);
        this.upperSizeLimit = this.currentQuery.getIntegerValue("core.upperSizeLimit", this.upperSizeLimit);
        this.lowerCountLimit = this.currentQuery.getIntegerValue("core.lowerCountLimit", this.lowerCountLimit);
        this.upperCountLimit = this.currentQuery.getIntegerValue("core.upperCountLimit", this.upperCountLimit);
        this.maxCount = this.currentQuery.getIntegerValue("core.maxCount", this.maxCount);
        this.checkIntervals = this.currentQuery.getIntegerValue("core.checkIntervals", this.checkIntervals);
        this.disableSpeedLimitFile = this.currentQuery.getStringValue("core.disableSpeedLimitFile", this.disableSpeedLimitFile);
        this.maxTimeZones = this.currentQuery.getIntegerValue("core.maxTimeZones", this.maxTimeZones);
        this.enableCoreStatistics = this.currentQuery.getBooleanValue("core.enableCoreStatistics", this.enableCoreStatistics);
        this.coreStatisticsInterval = this.currentQuery.getIntegerValue("core.coreStatisticsInterval", this.coreStatisticsInterval);
        String string = this.currentQuery.getStringValue("core.startupPresetFile");
        String string2 = this.currentQuery.getStringValue("core.savedPresetFile");
        if (string != null) {
            this.startupPresetFile = string;
        }
        if (string2 != null) {
            this.startupPresetFile = string2;
        }
        this.ignoreStartupPreset = this.currentQuery.getBooleanValue("core.ignoreStartupPreset", this.ignoreStartupPreset);
        ConfigValue configValue8 = this.currentQuery.getDictionary("fileTransfer");
        if (configValue8 != null) {
            this.parseFileTransfer(configValue8);
        }
        if ((configValue3 = this.currentQuery.getDictionary("backends")) != null) {
            this.parseBackends(configValue3);
        }
        if ((configValue2 = this.currentQuery.getDictionary("plugins")) != null) {
            this.parsePlugins(configValue2);
        }
        if ((configValue = this.currentQuery.getDictionary("levels")) != null) {
            this.levels = new TraceConfigLevels(configValue);
        }
        if (this.maxBackends > 32) {
            this.maxBackends = 32;
        }
        if (this.startupPresetFile.length() > 0 && (c2 = this.startupPresetFile.charAt(0)) != File.separatorChar && c2 != '.') {
            this.startupPresetFile = new StringBuffer().append(this.configPath).append(File.separator).append(this.startupPresetFile).toString();
        }
        return true;
    }

    public void overlayLevels(ConfigValue configValue) {
        if (configValue == null) {
            return;
        }
        this.levels = new TraceConfigLevels(configValue);
    }

    private void logConfig() {
        if (this.traceMe != null) {
            TraceMe.enable(this.traceMe);
        }
        if (TraceMe.isEnabled()) {
            TraceMe.msg(TraceMe.INFO, "Config", "I am proc:                   %1", this.name);
            TraceMe.msg(TraceMe.INFO, "Config", "core class:                  %1", this.coreClass);
            TraceMe.msg(TraceMe.INFO, "Config", "traceCoreCPU:                %1", this.traceCoreCPU);
            TraceMe.msg(TraceMe.INFO, "Config", "enabled:                     %1", new Boolean(this.enabled));
            TraceMe.msg(TraceMe.INFO, "Config", "path                         %1", this.configPath);
            TraceMe.msg(TraceMe.INFO, "Config", "messageBufferSize:           %1", new Integer(this.messageBufferSize));
            TraceMe.msg(TraceMe.INFO, "Config", "startupMessageBufferSize     %1", new Integer(this.messageBufferStartupSize));
            TraceMe.msg(TraceMe.INFO, "Config", "messageBufferThreshold:      %1", new Integer(this.messageBufferThreshold));
            TraceMe.msg(TraceMe.INFO, "Config", "messageBufferFlushInterval:  %1", new Integer(this.messageBufferFlushInterval));
            TraceMe.msg(TraceMe.INFO, "Config", "commandBufferSize:           %1", new Integer(this.commandBufferSize));
            TraceMe.msg(TraceMe.INFO, "Config", "maxBackends:                 %1", new Integer(this.maxBackends));
            TraceMe.msg(TraceMe.INFO, "Config", "entityPoolSize:              %1", new Integer(this.entityPoolSize));
            TraceMe.msg(TraceMe.INFO, "Config", "entityFlushInterval:         %1", new Integer(this.entityFlushInterval));
            TraceMe.msg(TraceMe.INFO, "Config", "useDefaultConsole:           %1", new Boolean(this.useDefaultConsole));
            TraceMe.msg(TraceMe.INFO, "Config", "allowOverwrite:              %1", new Boolean(this.allowOverwrite));
            TraceMe.msg(TraceMe.INFO, "Config", "omitMessagePrefix:           %1", new Boolean(this.omitMessagePrefix));
            TraceMe.msg(TraceMe.INFO, "Config", "emergencyLogFile:            %1", this.emergencyLogFile);
            TraceMe.msg(TraceMe.INFO, "Config", "decoders:                    %1", StringUtils.toString(this.decoders));
            TraceMe.msg(TraceMe.INFO, "Config", "formatters:                  %1", StringUtils.toString(this.formatters));
            TraceMe.msg(TraceMe.INFO, "Config", "backends:                    %1", StringUtils.toString(this.backends));
            TraceMe.msg(TraceMe.INFO, "Config", "enforceSpeedLimit:           %1", new Boolean(this.enforceSpeedLimit));
            TraceMe.msg(TraceMe.INFO, "Config", "lowerSizeLimit:              %1", new Integer(this.lowerSizeLimit));
            TraceMe.msg(TraceMe.INFO, "Config", "upperSizeLimit:              %1", new Integer(this.upperSizeLimit));
            TraceMe.msg(TraceMe.INFO, "Config", "lowerCountLimit:             %1", new Integer(this.lowerCountLimit));
            TraceMe.msg(TraceMe.INFO, "Config", "upperCountLimit:             %1", new Integer(this.upperCountLimit));
            TraceMe.msg(TraceMe.INFO, "Config", "checkIntervals:              %1", new Integer(this.checkIntervals));
            TraceMe.msg(TraceMe.INFO, "Config", "disableSpeedLimitFile:       %1", this.disableSpeedLimitFile);
            TraceMe.msg(TraceMe.INFO, "Config", "maxTimeZones:                %1", new Integer(this.maxTimeZones));
            TraceMe.msg(TraceMe.INFO, "Config", "ignoreStartupPreset:         %1", new Boolean(this.ignoreStartupPreset));
            TraceMe.msg(TraceMe.INFO, "Config", "startupPresetFile:           %1", new String(this.startupPresetFile));
            TraceMe.msg(TraceMe.INFO, "Config", "enableCoreStatistics:        %1", new Boolean(this.enableCoreStatistics));
            TraceMe.msg(TraceMe.INFO, "Config", "coreStatisticsInterval:      %1", new Integer(this.coreStatisticsInterval));
        }
    }

    private void parseMessageDecoders(ConfigValue configValue) {
        String[] stringArray = configValue.getAllDictKeys();
        int n = stringArray.length;
        if (n > 0) {
            this.decoders = new TraceConfigDecoder[n];
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                TraceConfigDecoder traceConfigDecoder;
                String string = stringArray[i2];
                short s = Short.parseShort(string);
                ConfigValue configValue2 = configValue.getDictValue(string);
                this.decoders[i2] = traceConfigDecoder = new TraceConfigDecoder(s, configValue2, this);
            }
        }
    }

    private void parseMessageFormatters(ConfigValue configValue) {
        String[] stringArray = configValue.getAllDictKeys();
        int n = stringArray.length;
        if (n > 0) {
            this.formatters = new TraceConfigFormatter[n];
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                TraceConfigFormatter traceConfigFormatter;
                String string = stringArray[i2];
                ConfigValue configValue2 = configValue.getDictValue(string);
                this.formatters[i2] = traceConfigFormatter = new TraceConfigFormatter(string, configValue2, this);
            }
        }
    }

    private void parseBackends(ConfigValue configValue) {
        String[] stringArray = configValue.getAllDictKeys();
        int n = stringArray.length;
        if (n > 0) {
            this.backends = new TraceConfigBackend[n];
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                TraceConfigBackend traceConfigBackend;
                String string = stringArray[i2];
                ConfigValue configValue2 = configValue.getDictValue(string);
                this.backends[i2] = traceConfigBackend = new TraceConfigBackend(string, configValue2, this);
            }
        }
    }

    public void setBackends(TraceConfigBackend[] traceConfigBackendArray) {
        this.backends = traceConfigBackendArray;
    }

    private void parsePlugins(ConfigValue configValue) {
        String[] stringArray = configValue.getAllDictKeys();
        int n = stringArray.length;
        if (n > 0) {
            this.plugins = new TraceConfigPlugin[n];
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                TraceConfigPlugin traceConfigPlugin;
                String string = stringArray[i2];
                ConfigValue configValue2 = configValue.getDictValue(string);
                this.plugins[i2] = traceConfigPlugin = new TraceConfigPlugin(string, configValue2, this);
            }
        }
    }

    public void setPlugins(TraceConfigPlugin[] traceConfigPluginArray) {
        this.plugins = traceConfigPluginArray;
    }

    private void parseFileTransfer(ConfigValue configValue) {
        this.fileTransfer = new TraceConfigFileTransfer(configValue);
    }

    public boolean isValid() {
        return this.isValid;
    }

    public String getFailString() {
        return this.failString;
    }

    public TraceConfigProvider getProvider() {
        return this.configProvider;
    }

    public String traceMe() {
        return this.traceMe;
    }

    public String getId() {
        return this.name;
    }

    public int getMessageBufferSize() {
        return this.messageBufferSize;
    }

    public void setMessageBufferSize(int n) {
        this.messageBufferSize = n;
    }

    public int getMessageBufferStartupSize() {
        return this.messageBufferStartupSize;
    }

    public void setMessageBufferStartupSize(int n) {
        this.messageBufferStartupSize = n;
    }

    public int getMessageBufferThreshold() {
        return this.messageBufferThreshold;
    }

    public void setMessageBufferThreshold(int n) {
        this.messageBufferThreshold = n;
    }

    public int getMessageBufferFlushInterval() {
        return this.messageBufferFlushInterval;
    }

    public void setMessageBufferFlushInterval(int n) {
        this.messageBufferFlushInterval = n;
    }

    public int getCommandBufferSize() {
        return this.commandBufferSize;
    }

    public void setCommandBufferSize(int n) {
        this.commandBufferSize = n;
    }

    public int getMaxBackends() {
        return this.maxBackends;
    }

    public void setMaxBackends(int n) {
        this.maxBackends = n;
    }

    public int getEntityPoolSize() {
        return this.entityPoolSize;
    }

    public void setEntityPoolSize(int n) {
        this.entityPoolSize = n;
    }

    public int getEntityFlushInterval() {
        return this.entityFlushInterval;
    }

    public void setEntityFlushInterval(int n) {
        this.entityFlushInterval = n;
    }

    public boolean getUseDefaultConsole() {
        return this.useDefaultConsole;
    }

    public void setUseDefaultConsole(boolean bl) {
        this.useDefaultConsole = bl;
    }

    public boolean getAllowOverwrite() {
        return this.allowOverwrite;
    }

    public void setAllowOverwrite(boolean bl) {
        this.allowOverwrite = bl;
    }

    public boolean getOmitMessagePrefix() {
        return this.omitMessagePrefix;
    }

    public void setOmitMessagePrefix(boolean bl) {
        this.omitMessagePrefix = bl;
    }

    public String getEmergencyLogFile() {
        return this.emergencyLogFile;
    }

    public void setEmergencyLogFile(String string) {
        this.emergencyLogFile = string;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean bl) {
        this.enabled = bl;
    }

    public String getCoreClass() {
        return this.coreClass;
    }

    public void setCoreClass(String string) {
        this.coreClass = string;
    }

    public TraceConfigLevels getLevels() {
        return this.levels;
    }

    public void setLevels(TraceConfigLevels traceConfigLevels) {
        this.levels = traceConfigLevels;
    }

    public TraceConfigBackend[] getBackends() {
        return this.backends;
    }

    public TraceConfigPlugin[] getPlugins() {
        return this.plugins;
    }

    public TraceConfigDecoder[] getMessageDecoders() {
        return this.decoders;
    }

    public TraceConfigFormatter[] getMessageFormatters() {
        return this.formatters;
    }

    public boolean enforceSpeedLimit() {
        return this.enforceSpeedLimit;
    }

    public void setEnforceSpeedLimit(boolean bl) {
        this.enforceSpeedLimit = bl;
    }

    public String disableSpeedLimitFile() {
        return this.disableSpeedLimitFile;
    }

    public void setDisableSpeedLimitFile(String string) {
        this.disableSpeedLimitFile = string;
    }

    public int getLowerSizeLimit() {
        return this.lowerSizeLimit;
    }

    public void setLowerSizeLimit(int n) {
        this.lowerSizeLimit = n;
    }

    public int getUpperSizeLimit() {
        return this.upperSizeLimit;
    }

    public void setUpperSizeLimit(int n) {
        this.upperSizeLimit = n;
    }

    public int getLowerCountLimit() {
        return this.lowerCountLimit;
    }

    public void setLowerCountLimit(int n) {
        this.lowerCountLimit = n;
    }

    public int getUpperCountLimit() {
        return this.upperCountLimit;
    }

    public void setUpperCountLimit(int n) {
        this.upperCountLimit = n;
    }

    public int getCheckIntervals() {
        return this.checkIntervals;
    }

    public void setCheckIntervals(int n) {
        this.checkIntervals = n;
    }

    public int getMaxCount() {
        return this.maxCount;
    }

    public void setMaxCount(int n) {
        this.maxCount = n;
    }

    public int getMaxTimeZones() {
        return this.maxTimeZones;
    }

    public void setMaxTimeZones(int n) {
        this.maxTimeZones = n;
    }

    public boolean getEnableCoreStatistics() {
        return this.enableCoreStatistics;
    }

    public void setEnableCoreStatistics(boolean bl) {
        this.enableCoreStatistics = bl;
    }

    public int getCoreStatisticsInterval() {
        return this.coreStatisticsInterval;
    }

    public void setCoreStatisticsInterval(int n) {
        this.coreStatisticsInterval = n;
    }

    public Integer getTraceCoreCPU() {
        return this.traceCoreCPU;
    }
}

