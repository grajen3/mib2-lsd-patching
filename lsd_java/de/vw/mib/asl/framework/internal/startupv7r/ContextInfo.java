/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r;

import de.vw.mib.asl.framework.api.startupv7r.DSIInfo;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.framework.internal.startupv7r.StartupConfiguration;
import de.vw.mib.collections.booleans.BooleanArrayList;
import de.vw.mib.collections.ints.IntArrayList;
import org.dsi.ifc.base.ServiceAdmin;

public class ContextInfo {
    public void startDSIById(int n) {
        this.startDSIByIds(new int[]{n}, true);
    }

    public DSIInfo[] getDSIInfoBeforeStart(int[] nArray, boolean bl) {
        if (!bl) {
            DSIInfo[] dSIInfoArray = new DSIInfo[nArray.length / 2];
            for (int i2 = 0; i2 < dSIInfoArray.length; ++i2) {
                dSIInfoArray[i2] = new DSIInfo(ServiceManager.configManagerDiag.getServiceName(nArray[2 * i2]), nArray[2 * i2 + 1]);
            }
            return dSIInfoArray;
        }
        DSIInfo[] dSIInfoArray = new DSIInfo[nArray.length];
        for (int i3 = 0; i3 < nArray.length; ++i3) {
            dSIInfoArray[i3] = new DSIInfo(this.getServiceNameForId(nArray[i3]), this.getInstanceIdForDsi(nArray[i3]));
        }
        return dSIInfoArray;
    }

    public boolean[] startDSIByIds(int[] nArray, boolean bl) {
        if (!bl) {
            boolean[] blArray = new boolean[nArray.length / 2];
            for (int i2 = 0; i2 < blArray.length; ++i2) {
                blArray[i2] = this.startDSI(ServiceManager.configManagerDiag.getServiceName(nArray[2 * i2]), nArray[2 * i2 + 1], ServiceManager.dsiServiceAdmin, nArray[i2]);
            }
            return blArray;
        }
        boolean[] blArray = new boolean[nArray.length];
        for (int i3 = 0; i3 < nArray.length; ++i3) {
            String string = this.getServiceNameForId(nArray[i3]);
            int n = this.getInstanceIdForDsi(nArray[i3]);
            blArray[i3] = this.startDSI(string, n, ServiceManager.dsiServiceAdmin, nArray[i3]);
        }
        return blArray;
    }

    public int getInstanceIdForDsi(int n) {
        int n2 = 0;
        if ((n & 0x80) != 0) {
            if ((n & 0x200) != 0) {
                n2 = 1;
            } else if ((n & 0x400) != 0) {
                n2 = 2;
            } else if ((n & 0x800) != 0) {
                n2 = 3;
            } else if ((n & 0x1000) != 0) {
                n2 = 4;
            } else if ((n & 0x2000) != 0) {
                n2 = 5;
            } else if ((n & 0x4000) != 0) {
                n2 = 6;
            } else if ((n & 0x8000) != 0) {
                n2 = 7;
            }
        }
        return n2;
    }

    private String getServiceNameForId(int n) {
        return RuntimeGeneratedConstants.SERVICE_TS_NS[n & 0xFF];
    }

    private boolean startDSI(String string, int n, ServiceAdmin serviceAdmin, int n2) {
        int n3 = n2;
        String string2 = string;
        int n4 = n;
        if (ServiceManager.logger.isTraceEnabled(1)) {
            ServiceManager.logger.trace(1).append("[ASLStartup v8]").append("Calling DSI ").append(string2).append(", instance ").append(n4).log();
        }
        boolean bl = serviceAdmin.startService(string2, n4);
        return bl;
    }

    public int[] filterForAllowedDsis(int[] nArray, boolean bl) {
        IntArrayList intArrayList = new IntArrayList(nArray.length);
        if (!bl) {
            for (int i2 = 0; i2 < nArray.length; i2 += 2) {
                if (StartupConfiguration.isDsiAllowedForStart(ServiceManager.configManagerDiag.getServiceName(nArray[i2]))) {
                    intArrayList.add(nArray[i2]);
                    intArrayList.add(nArray[i2 + 1]);
                    continue;
                }
                ServiceManager.logger.info(1).append("[ASLStartup v8]").append("skipping DSI: ").append(ServiceManager.configManagerDiag.getServiceName(nArray[i2])).append(" ,instance ").append(nArray[i2 + 1]).append(" because FeatureFlag was not set").log();
            }
        } else {
            for (int i3 = 0; i3 < nArray.length; ++i3) {
                if (StartupConfiguration.isDsiAllowedForStart(this.getServiceNameForId(nArray[i3]))) {
                    intArrayList.add(nArray[i3]);
                    continue;
                }
                ServiceManager.logger.info(1).append("[ASLStartup v8]").append("skipping DSI: ").append(this.getServiceNameForId(nArray[i3])).append(" because FeatureFlag was not set").log();
            }
        }
        return intArrayList.toArray();
    }

    public boolean[] filterForAllowedDsis(int[] nArray, boolean[] blArray, boolean bl) {
        BooleanArrayList booleanArrayList = new BooleanArrayList(nArray.length);
        if (!bl) {
            for (int i2 = 0; i2 < nArray.length; i2 += 2) {
                if (!StartupConfiguration.isDsiAllowedForStart(ServiceManager.configManagerDiag.getServiceName(nArray[i2]))) continue;
                booleanArrayList.add(blArray[i2 / 2]);
            }
        } else {
            for (int i3 = 0; i3 < nArray.length; ++i3) {
                if (!StartupConfiguration.isDsiAllowedForStart(this.getServiceNameForId(nArray[i3]))) continue;
                booleanArrayList.add(blArray[i3]);
            }
        }
        return booleanArrayList.toArray();
    }
}

