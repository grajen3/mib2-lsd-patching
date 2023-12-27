/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.config;

import de.esolutions.fw.util.commons.timeout.ITimeSource;
import de.esolutions.fw.util.commons.timeout.TimeSourceProvider;
import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.fw.SystemConfig;
import de.esolutions.fw.util.config.query.ConfigOverlayPathQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class TransportConfig {
    private static TransportConfig config;
    private boolean isValid;
    private String failString;
    private boolean doTraceConfig;
    private HashMap nodeServiceMap;
    private HashMap procServiceMap;
    private String[] allNodeNames;
    private HashMap myProcServiceMap;
    private String myProcName;
    private String myNodeName;
    private ArrayList myKeys;
    private String[] myServiceNames;
    private String[] allServiceNames;
    private SystemConfig sysConfig = SystemConfig.getInstance();

    public static TransportConfig getInstance() {
        if (config == null) {
            config = new TransportConfig();
        }
        return config;
    }

    private TransportConfig() {
        if (!this.sysConfig.isValid()) {
            this.failString = new StringBuffer().append("No valid system config: ").append(this.sysConfig.getFailString()).toString();
            return;
        }
        this.doTraceConfig = this.sysConfig.doTraceConfig();
        long l = 0L;
        ITimeSource iTimeSource = null;
        if (this.doTraceConfig) {
            iTimeSource = TimeSourceProvider.getMonotonicTimeSource();
            l = iTimeSource.getCurrentTime();
        }
        this.isValid = this.parse(this.sysConfig);
        if (this.doTraceConfig) {
            long l2 = iTimeSource.getCurrentTime();
            System.out.println(new StringBuffer().append("TransportConfig: parse time ").append(l2 - l).append(" ms").toString());
        }
    }

    public SystemConfig getSystemConfig() {
        return this.sysConfig;
    }

    public boolean isValid() {
        return this.isValid;
    }

    public String getFailString() {
        return this.failString;
    }

    public String[] getMyServiceNames() {
        return this.myServiceNames;
    }

    public String[] getAllServiceNames() {
        return this.allServiceNames;
    }

    public String[] getAllNodeNames() {
        return this.allNodeNames;
    }

    public String[] getMyReachableNodes(String string) {
        Object[] objectArray;
        int n;
        String string2 = new StringBuffer().append(this.myProcName).append(":").append(string).append(":").toString();
        int n2 = string2.length();
        HashSet hashSet = new HashSet();
        for (n = 0; n < this.myKeys.size(); ++n) {
            objectArray = (Object[])this.myKeys.get(n);
            if (!objectArray.startsWith(string2)) continue;
            String string3 = objectArray.substring(n2);
            if (string3.equals("*")) {
                for (int i2 = 0; i2 < this.allNodeNames.length; ++i2) {
                    hashSet.add(this.allNodeNames[n]);
                }
                continue;
            }
            hashSet.add(string3);
        }
        n = hashSet.size();
        if (n == 0) {
            return null;
        }
        objectArray = new String[n];
        hashSet.toArray(objectArray);
        return objectArray;
    }

    public ConfigValue[] getDictsForService(String string, String string2) {
        if (this.doTraceConfig) {
            System.out.println(new StringBuffer().append("TransportConfig.getDictsForService: service=").append(string).append(" remoteProc=").append(string2).toString());
        }
        String string3 = new StringBuffer().append(string2).append(":").append(string).append(":").append(this.myNodeName).toString();
        ConfigValue configValue = (ConfigValue)this.procServiceMap.get(string3);
        String string4 = new StringBuffer().append(string2).append(":").append(string).append(":*").toString();
        ConfigValue configValue2 = (ConfigValue)this.procServiceMap.get(string4);
        if (this.doTraceConfig) {
            System.out.println(new StringBuffer().append("  lookup: key=").append(string3).append(" -> ").append(configValue).toString());
            System.out.println(new StringBuffer().append("  lookup: key=").append(string4).append(" -> ").append(configValue2).toString());
        }
        String string5 = this.sysConfig.getNodeForProc(string2);
        String string6 = new StringBuffer().append(string5).append(":").append(string).append(":").append(this.myNodeName).toString();
        ConfigValue configValue3 = (ConfigValue)this.nodeServiceMap.get(string6);
        String string7 = new StringBuffer().append(string5).append(":").append(string).append(":*").toString();
        ConfigValue configValue4 = (ConfigValue)this.nodeServiceMap.get(string7);
        if (this.doTraceConfig) {
            System.out.println(new StringBuffer().append("  lookup: key=").append(string6).append(" -> ").append(configValue3).toString());
            System.out.println(new StringBuffer().append("  lookup: key=").append(string7).append(" -> ").append(configValue4).toString());
        }
        if (configValue == null && configValue2 == null && configValue3 == null && configValue4 == null) {
            return null;
        }
        return new ConfigValue[]{configValue, configValue2, configValue3, configValue4};
    }

    public ConfigValue[] getDictsForMyService(String string, String string2) {
        if (this.doTraceConfig) {
            System.out.println(new StringBuffer().append("TransportConfig.getDictsForMyService: service=").append(string).append(" offeredNode=").append(string2).toString());
        }
        String string3 = new StringBuffer().append(this.myProcName).append(":").append(string).append(":").append(string2).toString();
        ConfigValue configValue = (ConfigValue)this.myProcServiceMap.get(string3);
        String string4 = new StringBuffer().append(this.myProcName).append(":").append(string).append(":*").toString();
        ConfigValue configValue2 = (ConfigValue)this.myProcServiceMap.get(string4);
        if (this.doTraceConfig) {
            System.out.println(new StringBuffer().append("  lookup: key=").append(string3).append(" -> ").append(configValue).toString());
            System.out.println(new StringBuffer().append("  lookup: key=").append(string4).append(" -> ").append(configValue2).toString());
        }
        if (configValue == null && configValue2 == null) {
            return null;
        }
        String string5 = new StringBuffer().append(this.myNodeName).append(":").append(string).append(":").append(string2).toString();
        ConfigValue configValue3 = (ConfigValue)this.nodeServiceMap.get(string5);
        String string6 = new StringBuffer().append(this.myNodeName).append(":").append(string).append(":*").toString();
        ConfigValue configValue4 = (ConfigValue)this.nodeServiceMap.get(string6);
        if (this.doTraceConfig) {
            System.out.println(new StringBuffer().append("  lookup: key=").append(string5).append(" -> ").append(configValue3).toString());
            System.out.println(new StringBuffer().append("  lookup: key=").append(string6).append(" -> ").append(configValue4).toString());
        }
        if (configValue == null && configValue2 == null && configValue3 == null && configValue4 == null) {
            return null;
        }
        return new ConfigValue[]{configValue, configValue2, configValue3, configValue4};
    }

    public ConfigOverlayPathQuery getQueryForService(String string, String string2) {
        ConfigValue[] configValueArray = this.getDictsForService(string, string2);
        if (configValueArray == null) {
            return null;
        }
        return new ConfigOverlayPathQuery(configValueArray);
    }

    public ConfigOverlayPathQuery getQueryForMyService(String string, String string2) {
        ConfigValue[] configValueArray = this.getDictsForMyService(string, string2);
        if (configValueArray == null) {
            return null;
        }
        return new ConfigOverlayPathQuery(configValueArray);
    }

    protected boolean parse(SystemConfig systemConfig) {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        Object object5;
        String[] stringArray;
        this.myProcName = systemConfig.getMyProcName();
        this.myNodeName = systemConfig.getMyNodeName();
        this.nodeServiceMap = new HashMap();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        ConfigValue configValue = systemConfig.getNodesConfig();
        String[] stringArray2 = systemConfig.getAllNodeNames();
        for (int i2 = 0; i2 < stringArray2.length; ++i2) {
            String string = stringArray2[i2];
            stringArray = configValue.getDictValue(string);
            if (stringArray == null || !stringArray.isDictionary()) {
                this.failString = new StringBuffer().append("Invalid node ").append(string).toString();
                return false;
            }
            object5 = stringArray.getDictValue("transport");
            if (object5 == null || !((ConfigValue)object5).isDictionary()) {
                this.failString = new StringBuffer().append("No 'transport' in node ").append(string).toString();
                return false;
            }
            if (!string.equals("*")) {
                hashSet2.add(string);
            }
            String[] stringArray3 = ((ConfigValue)object5).getAllDictKeys();
            for (int i3 = 0; i3 < stringArray3.length; ++i3) {
                object4 = stringArray3[i3];
                hashSet.add(object4);
                object3 = ((ConfigValue)object5).getDictValue((String)object4);
                if (object3 == null || !((ConfigValue)object3).isDictionary()) {
                    this.failString = new StringBuffer().append("Invalid 'service' ").append(string).append(":").append((String)object4).toString();
                    return false;
                }
                String[] stringArray4 = ((ConfigValue)object3).getAllDictKeys();
                for (int i4 = 0; i4 < stringArray4.length; ++i4) {
                    String string2 = stringArray4[i4];
                    object2 = ((ConfigValue)object3).getDictValue(string2);
                    if (object2 == null || !((ConfigValue)object2).isDictionary()) {
                        this.failString = new StringBuffer().append("Invalid target 'node' in ").append(string).append(":").append((String)object4).append(":").append(string2).toString();
                        return false;
                    }
                    object = new StringBuffer().append(string).append(":").append((String)object4).append(":").append(string2).toString();
                    if (this.doTraceConfig) {
                        System.out.println(new StringBuffer().append("TransportConfig: node '").append((String)object).append("' is ").append(object2).toString());
                    }
                    this.nodeServiceMap.put(object, object2);
                    if (string2.equals("*")) continue;
                    hashSet2.add(string2);
                }
            }
        }
        this.procServiceMap = new HashMap();
        this.myProcServiceMap = new HashMap();
        this.myKeys = new ArrayList();
        ConfigValue configValue2 = systemConfig.getProcsConfig();
        int n = configValue2.getArraySize();
        stringArray = systemConfig.getAllProcNames();
        object5 = systemConfig.getMyProcName();
        for (int i5 = 0; i5 < n; ++i5) {
            ConfigValue configValue3 = configValue2.getArrayValue(i5);
            if (configValue3 == null || (object4 = configValue3.getDictValue("transport")) == null) continue;
            if (!((ConfigValue)object4).isDictionary()) {
                this.failString = new StringBuffer().append("Invalid transport in proc ").append(stringArray[i5]).toString();
                return false;
            }
            object3 = stringArray[i5];
            boolean bl = ((String)object3).equals(object5);
            String[] stringArray5 = ((ConfigValue)object4).getAllDictKeys();
            if (bl) {
                this.myServiceNames = stringArray5;
            }
            for (int i6 = 0; i6 < stringArray5.length; ++i6) {
                object2 = stringArray5[i6];
                hashSet.add(object2);
                object = ((ConfigValue)object4).getDictValue((String)object2);
                if (object == null || !((ConfigValue)object).isDictionary()) {
                    this.failString = new StringBuffer().append("Invalid 'service' ").append((String)object2).append(" in proc ").append(stringArray[i5]).toString();
                    return false;
                }
                String[] stringArray6 = ((ConfigValue)object).getAllDictKeys();
                for (int i7 = 0; i7 < stringArray6.length; ++i7) {
                    String string = stringArray6[i7];
                    ConfigValue configValue4 = ((ConfigValue)object).getDictValue(string);
                    if (configValue4 == null || !configValue4.isDictionary()) {
                        this.failString = new StringBuffer().append("Invalid target 'node' in ").append((String)object3).append(":").append((String)object2).append(":").append(string).toString();
                        return false;
                    }
                    String string3 = new StringBuffer().append((String)object3).append(":").append((String)object2).append(":").append(string).toString();
                    if (bl) {
                        if (this.doTraceConfig) {
                            System.out.println(new StringBuffer().append("TransportConfig: mine '").append(string3).append("' is ").append(configValue4).toString());
                        }
                        this.myProcServiceMap.put(string3, configValue4);
                        this.myKeys.add(string3);
                    } else {
                        if (this.doTraceConfig) {
                            System.out.println(new StringBuffer().append("TransportConfig: '").append(string3).append("' is ").append(configValue4).toString());
                        }
                        this.procServiceMap.put(string3, configValue4);
                    }
                    if (string.equals("*")) continue;
                    hashSet2.add(string);
                }
            }
        }
        this.allServiceNames = new String[hashSet.size()];
        hashSet.toArray(this.allServiceNames);
        this.allNodeNames = new String[hashSet2.size()];
        hashSet2.toArray(this.allNodeNames);
        return true;
    }
}

