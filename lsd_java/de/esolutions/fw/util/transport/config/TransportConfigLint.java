/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.config;

import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.fw.SystemConfig;
import de.esolutions.fw.util.config.query.ConfigOverlayPathQuery;
import de.esolutions.fw.util.config.query.IConfigQuery;
import de.esolutions.fw.util.transport.config.TransportConfig;

public class TransportConfigLint {
    private TransportConfig config;

    private TransportConfigLint(TransportConfig transportConfig) {
        this.config = transportConfig;
    }

    private boolean checkService(IConfigQuery iConfigQuery, String string) {
        String string2;
        String string3 = iConfigQuery.getStringValue("serializer");
        if (string3 == null) {
            System.out.println(new StringBuffer().append("ERROR: No serializer given for ").append(string).toString());
            return false;
        }
        String string4 = iConfigQuery.getStringValue("mode");
        if (string4 == null) {
            System.out.println(new StringBuffer().append("WARNING: No 'mode' set for ").append(string).append(". Falling back to legacy auto mode!").toString());
        }
        ConfigValue configValue = iConfigQuery.getDictionary("tcpip");
        ConfigValue configValue2 = iConfigQuery.getDictionary("resman");
        ConfigValue configValue3 = iConfigQuery.getDictionary("ts");
        if (configValue == null && configValue2 == null && configValue3 == null) {
            System.out.println(new StringBuffer().append("ERROR: Neither 'resman', 'ts', nor 'tcp' for ").append(string).toString());
            return false;
        }
        if ((string4 == null || string4.equals("tcp")) && configValue != null) {
            string2 = iConfigQuery.getStringValue("tcpip.address");
            Integer n = iConfigQuery.getIntegerValue("tcpip.port");
            if (string2 == null && n != null) {
                System.out.println(new StringBuffer().append("ERROR: missing 'address' in 'tcpip' for ").append(string).toString());
                return false;
            }
        }
        if ((string4 == null || string4.equals("resman")) && configValue2 != null && (string2 = iConfigQuery.getStringValue("resman.root_path")) == null) {
            System.out.println(new StringBuffer().append("ERROR: missing 'root_path' in 'resman' for ").append(string).toString());
            return false;
        }
        if (string4 != null) {
            if (string4.equals("tcpip")) {
                if (configValue == null) {
                    System.out.println("ERROR: mode 'tcpip' selected but no parameters given!");
                    return false;
                }
            } else if (string4.equals("ts")) {
                if (configValue3 == null) {
                    System.out.println("ERROR: mode 'ts' selected but no parameters given!");
                    return false;
                }
            } else if (string4.equals("resman")) {
                if (configValue2 == null) {
                    System.out.println("ERROR: mode 'resman' selected but no parameters given!");
                    return false;
                }
            } else {
                System.out.println(new StringBuffer().append("ERROR: invalid mode ").append(string4).toString());
                return false;
            }
        }
        return true;
    }

    private boolean lint() {
        String[] stringArray;
        String[] stringArray2;
        SystemConfig systemConfig = SystemConfig.getInstance();
        String[] stringArray3 = systemConfig.getAllProcNames();
        String[] stringArray4 = this.config.getAllServiceNames();
        String string = systemConfig.getMyProcName();
        boolean bl = systemConfig.doTraceConfig();
        if (stringArray4 != null) {
            for (int i2 = 0; i2 < stringArray4.length; ++i2) {
                String string2 = stringArray4[i2];
                if (bl) {
                    System.out.println(new StringBuffer().append("checking service: ").append(string2).toString());
                }
                for (int i3 = 0; i3 < stringArray3.length; ++i3) {
                    ConfigOverlayPathQuery configOverlayPathQuery;
                    stringArray2 = stringArray3[i3];
                    if (stringArray2.equals(string)) continue;
                    if (bl) {
                        System.out.println(new StringBuffer().append("checking proc: ").append((String)stringArray2).toString());
                    }
                    if ((configOverlayPathQuery = this.config.getQueryForService(string2, (String)stringArray2)) == null || this.checkService(configOverlayPathQuery, new StringBuffer().append(string2).append(":").append((String)stringArray2).toString())) continue;
                    return false;
                }
            }
        }
        if ((stringArray = this.config.getMyServiceNames()) != null) {
            for (int i4 = 0; i4 < stringArray.length; ++i4) {
                String string3 = stringArray[i4];
                if (bl) {
                    System.out.println(new StringBuffer().append("checking my service: ").append(string3).toString());
                }
                if ((stringArray2 = this.config.getMyReachableNodes(string3)) == null) continue;
                for (int i5 = 0; i5 < stringArray2.length; ++i5) {
                    String string4 = stringArray2[i5];
                    if (bl) {
                        System.out.println(new StringBuffer().append("checking node: ").append(string4).toString());
                    }
                    String string5 = new StringBuffer().append(string).append(":").append(string3).append(":").append(string4).toString();
                    ConfigOverlayPathQuery configOverlayPathQuery = this.config.getQueryForMyService(string3, string4);
                    if (configOverlayPathQuery == null) {
                        System.out.println(new StringBuffer().append("ERROR: Can't find own service ").append(string5).toString());
                        return false;
                    }
                    if (this.checkService(configOverlayPathQuery, string5)) continue;
                    return false;
                }
            }
        }
        System.out.println("OK");
        return true;
    }

    public static void main(String[] stringArray) {
        TransportConfig transportConfig = TransportConfig.getInstance();
        if (!transportConfig.isValid()) {
            System.out.println(new StringBuffer().append("ERROR reading config: ").append(transportConfig.getFailString()).toString());
            return;
        }
        TransportConfigLint transportConfigLint = new TransportConfigLint(transportConfig);
        boolean bl = transportConfigLint.lint();
        if (bl) {
            System.exit(0);
        } else {
            System.exit(1);
        }
    }
}

