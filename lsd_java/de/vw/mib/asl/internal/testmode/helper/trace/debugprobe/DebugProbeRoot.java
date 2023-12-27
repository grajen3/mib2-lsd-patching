/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode.helper.trace.debugprobe;

import de.vw.mib.asl.internal.testmode.helper.trace.debugprobe.DebugProbe;
import de.vw.mib.asl.internal.testmode.helper.trace.debugprobe.DebugProbeFilter;
import de.vw.mib.util.Util;
import java.io.File;
import java.util.Arrays;

public class DebugProbeRoot {
    private static final String KEY_PROBE_CONFIG_PATH;
    private static final String PROBE_CONFIG_PATH;
    private final DebugProbe[] mDebugProbeArray;

    public DebugProbeRoot() {
        Object[] objectArray = this.getDebugProbeFileList();
        int n = 0;
        if (!Util.isNullOrEmpty(objectArray)) {
            n = objectArray.length;
        }
        this.mDebugProbeArray = new DebugProbe[n + 3];
        this.mDebugProbeArray[0] = new DebugProbe("Off", -2);
        this.mDebugProbeArray[1] = new DebugProbe("From SD", -1);
        this.mDebugProbeArray[2] = new DebugProbe("HMIMonitor", -3);
        for (int i2 = 0; i2 <= n - 1; ++i2) {
            String string = DebugProbeFilter.getDebugProbeName((String)objectArray[i2]);
            int n2 = DebugProbeFilter.getDebugProbeIndex((String)objectArray[i2]);
            this.mDebugProbeArray[i2 + 3] = new DebugProbe(string, n2);
        }
        Arrays.sort(this.mDebugProbeArray);
    }

    private String[] getDebugProbeFileList() {
        String[] stringArray = null;
        try {
            File file = new File(PROBE_CONFIG_PATH);
            DebugProbeFilter debugProbeFilter = new DebugProbeFilter();
            stringArray = file.list(debugProbeFilter);
        }
        catch (Exception exception) {
            stringArray = null;
        }
        return stringArray;
    }

    public void setSelectedDebugProbe(int n) {
        for (int i2 = 0; i2 < this.mDebugProbeArray.length; ++i2) {
            boolean bl = this.mDebugProbeArray[i2].getIndex() == n;
            this.mDebugProbeArray[i2].setActive(bl);
        }
    }

    public int getDebugProbeNrByIndex(int n) {
        return this.mDebugProbeArray[n].getIndex();
    }

    public boolean getMainLoggingState() {
        boolean bl = false;
        for (int i2 = 1; i2 < this.mDebugProbeArray.length; ++i2) {
            if (!this.mDebugProbeArray[i2].isActive()) continue;
            bl = true;
        }
        return bl;
    }

    public DebugProbe[] getDebugRootArray() {
        return this.mDebugProbeArray;
    }

    static {
        PROBE_CONFIG_PATH = System.getProperty("debugprobes.config.path");
    }
}

