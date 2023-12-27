/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config.fw;

import de.esolutions.fw.util.commons.timeout.ITimeSource;
import de.esolutions.fw.util.commons.timeout.TimeSourceProvider;
import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.fw.FrameworkConfigProvider;
import de.esolutions.fw.util.config.query.IConfigQuery;
import java.util.ArrayList;
import java.util.HashMap;

public class SystemConfig {
    private static SystemConfig config;
    private static String namePreset;
    private String myProcName;
    private String myNodeName;
    private int myProcId;
    private boolean isValid;
    private boolean doTraceConfig;
    private String failString;
    private ConfigValue nodesConfig;
    private ConfigValue procsConfig;
    private ConfigValue myProcConfig;
    private ConfigValue myNodeConfig;
    private HashMap nodeNameMap;
    private HashMap procNameMap;
    private HashMap procNameIdMap;
    private HashMap procIdNameMap;
    private HashMap procNodeMap;
    private HashMap procNodeNameMap;
    private HashMap nodeProcMap;
    private HashMap nodeProcNameMap;
    private String[] nodeNames;
    private String[] procNames;
    private int[] procIds;
    private FrameworkConfigProvider fwConfig;

    public static synchronized void setMyProcName(String string) {
        namePreset = string;
    }

    public static synchronized SystemConfig getInstance() {
        if (config == null) {
            String string = System.getProperty("ipl.config.myProcName", namePreset);
            config = new SystemConfig(string);
        }
        return config;
    }

    protected SystemConfig(String string) {
        this.myProcName = string;
        this.fwConfig = FrameworkConfigProvider.getInstance();
        if (!this.fwConfig.isValid()) {
            this.failString = new StringBuffer().append("No valid framework config: ").append(this.fwConfig.getFailString()).toString();
            return;
        }
        this.doTraceConfig = this.fwConfig.doTraceConfig();
        this.isValid = this.parseConfig(this.fwConfig);
    }

    public boolean isValid() {
        return this.isValid;
    }

    public FrameworkConfigProvider getFrameworkConfigProvider() {
        return this.fwConfig;
    }

    public String getFailString() {
        return this.failString;
    }

    public boolean doTraceConfig() {
        return this.doTraceConfig;
    }

    public String getMyProcName() {
        return this.myProcName;
    }

    public int getMyProcId() {
        return this.myProcId;
    }

    public ConfigValue getMyProcConfig() {
        return this.myProcConfig;
    }

    public String getMyNodeName() {
        return this.myNodeName;
    }

    public ConfigValue getMyNodeConfig() {
        return this.myNodeConfig;
    }

    public String[] getAllNodeNames() {
        return this.nodeNames;
    }

    public String[] getAllProcNames() {
        return this.procNames;
    }

    public int[] getAllProcIds() {
        return this.procIds;
    }

    public String mapProcId(int n) {
        return (String)this.procIdNameMap.get(new Integer(n));
    }

    public Integer mapIdProc(String string) {
        return (Integer)this.procNameIdMap.get(string);
    }

    public ConfigValue getNodeConfigByName(String string) {
        return (ConfigValue)this.nodeNameMap.get(string);
    }

    public ConfigValue getProcConfigByName(String string) {
        return (ConfigValue)this.procNameMap.get(string);
    }

    public ConfigValue getNodeConfigForProcConfig(ConfigValue configValue) {
        return (ConfigValue)this.procNodeMap.get(configValue);
    }

    public String getNodeForProc(String string) {
        return (String)this.procNodeNameMap.get(string);
    }

    public ConfigValue[] getProcConfigsForNodeConfig(ConfigValue configValue) {
        ArrayList arrayList = (ArrayList)this.nodeProcMap.get(configValue);
        if (arrayList == null) {
            return null;
        }
        Object[] objectArray = new ConfigValue[arrayList.size()];
        arrayList.toArray(objectArray);
        return objectArray;
    }

    public String[] getProcNamesForNodeName(String string) {
        ArrayList arrayList = (ArrayList)this.nodeProcNameMap.get(string);
        if (arrayList == null) {
            return null;
        }
        Object[] objectArray = new String[arrayList.size()];
        arrayList.toArray(objectArray);
        return objectArray;
    }

    public ConfigValue getNodesConfig() {
        return this.nodesConfig;
    }

    public ConfigValue getProcsConfig() {
        return this.procsConfig;
    }

    protected boolean parseConfig(FrameworkConfigProvider frameworkConfigProvider) {
        int n;
        long l = 0L;
        ITimeSource iTimeSource = null;
        if (this.doTraceConfig) {
            iTimeSource = TimeSourceProvider.getMonotonicTimeSource();
            l = iTimeSource.getCurrentTime();
        }
        IConfigQuery iConfigQuery = frameworkConfigProvider.getPathQuery();
        this.nodesConfig = iConfigQuery.getDictionary("nodes");
        if (this.nodesConfig == null) {
            this.failString = "No 'nodes' dictionary found!";
            return false;
        }
        this.procsConfig = iConfigQuery.getArray("procs");
        if (this.procsConfig == null) {
            this.failString = "No 'procs' array found!";
            return false;
        }
        this.nodeNameMap = new HashMap();
        this.nodeNames = this.nodesConfig.getAllDictKeys();
        for (n = 0; n < this.nodeNames.length; ++n) {
            ConfigValue configValue = this.nodesConfig.getDictValue(this.nodeNames[n]);
            if (configValue == null || !configValue.isDictionary()) {
                this.failString = new StringBuffer().append("Invalid node found: ").append(this.nodeNames[n]).toString();
                return false;
            }
            this.nodeNameMap.put(this.nodeNames[n], configValue);
        }
        this.procNameMap = new HashMap();
        this.procNameIdMap = new HashMap();
        this.procIdNameMap = new HashMap();
        this.procNodeMap = new HashMap();
        this.procNodeNameMap = new HashMap();
        this.nodeProcMap = new HashMap();
        this.nodeProcNameMap = new HashMap();
        n = this.procsConfig.getArraySize();
        this.procNames = new String[n];
        this.procIds = new int[n];
        for (int i2 = 0; i2 < n; ++i2) {
            ArrayList arrayList;
            ConfigValue configValue = this.procsConfig.getArrayValue(i2);
            if (configValue == null || !configValue.isDictionary()) {
                this.failString = new StringBuffer().append("Node at index ").append(i2).append(" is ").append(configValue).toString();
                return false;
            }
            ConfigValue configValue2 = configValue.getDictValue("name");
            if (configValue2 == null || !configValue2.isString()) {
                this.failString = new StringBuffer().append("Proc 'name' at index ").append(i2).append(" is ").append(configValue2).toString();
                return false;
            }
            String string = configValue2.getString();
            this.procNameMap.put(string, configValue);
            ConfigValue configValue3 = configValue.getDictValue("id");
            if (configValue3 == null || !configValue3.isInteger()) {
                this.failString = new StringBuffer().append("Proc 'id' at '").append(string).append("' is ").append(configValue3).toString();
                return false;
            }
            Integer n2 = configValue3.getInteger();
            this.procNameIdMap.put(string, n2);
            this.procIdNameMap.put(n2, string);
            ConfigValue configValue4 = configValue.getDictValue("node");
            if (configValue4 == null || !configValue4.isString()) {
                this.failString = new StringBuffer().append("Proc '").append(string).append("' has invalid 'node' ").append(configValue4).toString();
                return false;
            }
            String string2 = configValue4.getString();
            ConfigValue configValue5 = (ConfigValue)this.nodeNameMap.get(string2);
            if (configValue5 == null) {
                this.failString = new StringBuffer().append("Proc '").append(string).append("' has non-existing node ").append(string2).toString();
                return false;
            }
            this.procNodeMap.put(configValue, configValue5);
            this.procNodeNameMap.put(string, string2);
            this.procNames[i2] = string;
            this.procIds[i2] = n2;
            if (string.equals(this.myProcName)) {
                this.myProcConfig = configValue;
                this.myNodeConfig = configValue5;
                this.myProcId = n2;
                this.myNodeName = string2;
            }
            if ((arrayList = (ArrayList)this.nodeProcMap.get(configValue5)) == null) {
                arrayList = new ArrayList(10);
                this.nodeProcMap.put(configValue5, arrayList);
            }
            arrayList.add(configValue);
            arrayList = (ArrayList)this.nodeProcNameMap.get(string2);
            if (arrayList == null) {
                arrayList = new ArrayList(10);
                this.nodeProcNameMap.put(string2, arrayList);
            }
            arrayList.add(string);
        }
        if (this.myProcConfig == null) {
            this.failString = new StringBuffer().append("My own Proc '").append(this.myProcName).append("' was not found in config").toString();
            return false;
        }
        if (this.myNodeConfig == null) {
            this.failString = "No node for my proc found";
            return false;
        }
        if (this.doTraceConfig) {
            long l2 = iTimeSource.getCurrentTime();
            System.out.println(new StringBuffer().append("SystemConfig: parse time ").append(l2 - l).append(" ms").toString());
        }
        return true;
    }

    static {
        namePreset = "java";
    }
}

