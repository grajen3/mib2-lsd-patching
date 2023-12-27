/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.logging;

import de.vw.mib.debug.common.probes.logmanager.LogManagerProbeConfiguration;
import de.vw.mib.debugmanager.probes.AbstractDebugProbe;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;
import de.vw.mib.log4mib.LogManagerDiag;
import de.vw.mib.log4mib.LogManagerDiagListener;

public final class LogManagerProbe
extends AbstractDebugProbe
implements LogManagerDiagListener {
    private LogManagerDiag logManager;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LogManagerDiag;

    public LogManagerProbe(ProbeSystemServices probeSystemServices) {
        super(probeSystemServices);
    }

    @Override
    protected boolean deactivateProbe() {
        this.deactivateAllTraces();
        this.logManager.unregisterLogManagerDiagListener(this);
        return true;
    }

    @Override
    protected boolean initProbe() {
        this.logManager = (LogManagerDiag)this.probeSystemServices.getService((class$de$vw$mib$log4mib$LogManagerDiag == null ? (class$de$vw$mib$log4mib$LogManagerDiag = LogManagerProbe.class$("de.vw.mib.log4mib.LogManagerDiag")) : class$de$vw$mib$log4mib$LogManagerDiag).getName());
        this.logManager.registerLogManagerDiagListener(this);
        return true;
    }

    protected void applySettings() {
        LogManagerProbeConfiguration logManagerProbeConfiguration = (LogManagerProbeConfiguration)this.probeSystemServices.getConfiguration();
        int[] nArray = this.logManager.getClassifierIds();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            Integer n = new Integer(nArray[i2]);
            Integer n2 = (Integer)logManagerProbeConfiguration.getSubClassifierMasks().get(n);
            if (n2 != null) {
                this.logManager.setTraceSubClassifierMask(n, n2);
                continue;
            }
            this.logManager.setTraceSubClassifierMask(n, 0);
        }
    }

    private void deactivateAllTraces() {
        int[] nArray = this.logManager.getClassifierIds();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n = nArray[i2];
            this.logManager.setTraceSubClassifierMask(n, 0);
        }
    }

    @Override
    public void logMangerSettingsUpdated() {
        this.sendConfiguration();
    }

    public String getName() {
        return "LOGMANAGER";
    }

    @Override
    protected boolean configureProbe() {
        this.applySettings();
        return true;
    }

    @Override
    protected boolean activateProbe() {
        return true;
    }

    @Override
    protected boolean cleanUpProbe() {
        return true;
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

