/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.config;

import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.tracing.config.TraceConfig;
import de.esolutions.fw.util.tracing.config.TraceConfigProvider;

public class TraceConfigLint {
    private TraceConfig config;

    private TraceConfigLint(TraceConfig traceConfig) {
        this.config = traceConfig;
    }

    private boolean checkMachine(String string, ConfigValue configValue, boolean bl, ConfigValue configValue2) {
        ConfigValue configValue3;
        Object object;
        boolean bl2 = bl;
        ConfigValue configValue4 = configValue.getDictValue("enabled");
        if (configValue4 != null) {
            object = configValue4.getBoolean();
            if (object == null) {
                System.out.println(new StringBuffer().append("ERROR: client '").append(string).append("' has invalid 'enabled' value!").toString());
                return false;
            }
            bl2 = (Boolean)object;
            if (!bl2) {
                if (bl) {
                    System.out.println(new StringBuffer().append("WARNING: server '").append(string).append("' is not enabled!").toString());
                } else {
                    System.out.println(new StringBuffer().append("INFO: client '").append(string).append("' tracing is disabled.").toString());
                }
            }
        }
        if (!bl2) {
            return true;
        }
        object = null;
        ConfigValue configValue5 = null;
        if (configValue2 != null && (object = configValue2.getDictValue("levels")) != null) {
            configValue5 = ((ConfigValue)object).getDictValue("channel");
        }
        if ((configValue3 = configValue.getDictValue("levels")) != null) {
            ConfigValue configValue6 = configValue3.getDictValue("channel");
            if (configValue6 == null && !bl && configValue != configValue2 && configValue5 == null) {
                System.out.println(new StringBuffer().append("WARNING: client '").append(string).append("' has no channels defined! (No trace output!)").toString());
            }
        } else if (!bl && configValue != configValue2 && object == null) {
            System.out.println(new StringBuffer().append("WARNING: client '").append(string).append("' has no levels set! (No tracing output)").toString());
        }
        return true;
    }

    private boolean checkMachineSet(ConfigValue configValue, boolean bl) {
        ConfigValue configValue2 = configValue.getDictValue("default");
        String[] stringArray = configValue.getAllDictKeys();
        if (configValue2 == null) {
            if (stringArray.length == 0) {
                System.out.println("ERROR: no 'default' and no instances!");
                return false;
            }
            System.out.println(new StringBuffer().append("WARNING: no 'default' in ").append(bl ? "server" : "client").toString());
        }
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            ConfigValue configValue3 = configValue.getDictValue(stringArray[i2]);
            if (configValue3 == null) {
                return false;
            }
            if (this.checkMachine(stringArray[i2], configValue3, bl, configValue2)) continue;
            return false;
        }
        return true;
    }

    private boolean lint() {
        ConfigValue configValue;
        TraceConfigProvider traceConfigProvider = this.config.getProvider();
        ConfigValue configValue2 = traceConfigProvider.getRoot().getDictValue("server");
        if (configValue2 != null) {
            if (!this.checkMachineSet(configValue2, true)) {
                return false;
            }
        } else {
            System.out.println("WARNING: no 'server' definition!");
        }
        if ((configValue = traceConfigProvider.getRoot().getDictValue("client")) != null) {
            if (!this.checkMachineSet(configValue, false)) {
                return false;
            }
        } else {
            System.out.println("WARNING: no 'client' definition!");
        }
        System.out.println("OK");
        return true;
    }

    public static void main(String[] stringArray) {
        TraceConfig traceConfig = new TraceConfig("java", "client");
        if (!traceConfig.readConfig()) {
            System.out.println(new StringBuffer().append("Error reading config: ").append(traceConfig.getFailString()).toString());
            return;
        }
        TraceConfigLint traceConfigLint = new TraceConfigLint(traceConfig);
        boolean bl = traceConfigLint.lint();
        if (bl) {
            System.exit(0);
        } else {
            System.exit(1);
        }
    }
}

