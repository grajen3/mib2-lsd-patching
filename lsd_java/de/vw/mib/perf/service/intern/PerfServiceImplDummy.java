/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.perf.service.intern;

import de.vw.mib.activation.BundleActivatorExtension;
import de.vw.mib.perf.service.PerfService;
import de.vw.mib.perf.service.PerfServiceData;
import org.osgi.framework.BundleContext;

public final class PerfServiceImplDummy
implements BundleActivatorExtension,
PerfService {
    private boolean preloaded;
    static /* synthetic */ Class class$de$vw$mib$perf$service$PerfService;

    @Override
    public void start(BundleContext bundleContext) {
        if (!this.preloaded) {
            this.preload(bundleContext);
        }
    }

    @Override
    public void stop(BundleContext bundleContext) {
    }

    @Override
    public void preload(BundleContext bundleContext) {
        this.preloaded = true;
        bundleContext.registerService((class$de$vw$mib$perf$service$PerfService == null ? (class$de$vw$mib$perf$service$PerfService = PerfServiceImplDummy.class$("de.vw.mib.perf.service.PerfService")) : class$de$vw$mib$perf$service$PerfService).getName(), (Object)this, null);
    }

    @Override
    public void performanceLogMsg(String string) {
    }

    @Override
    public boolean isPerfServiceDataSupported() {
        return false;
    }

    @Override
    public PerfServiceData getPerfServiceData(PerfServiceData perfServiceData) {
        return null;
    }

    @Override
    public boolean isPerformanceLogMsgSupported() {
        return false;
    }

    @Override
    public void performanceLogMsgByID(int n) {
    }

    @Override
    public void performanceLogDSI(String string, int n) {
    }

    @Override
    public void performanceLogDomain(int n, int n2, int n3) {
    }

    @Override
    public void performanceLogASLTarget(int n, int n2) {
    }

    @Override
    public void performanceLogContextSwitch(int[] nArray) {
    }

    @Override
    public void performanceLogRvcStateUpdate(boolean bl) {
    }

    @Override
    public void performanceLogViewHandler(String string, int n) {
    }

    @Override
    public void performanceLogViewHandler(String string, int n, int n2) {
    }

    @Override
    public void performanceLogStartup(int n, int n2, int n3) {
    }

    @Override
    public void performanceLogProfileChange(int n, byte by) {
    }

    @Override
    public void performanceLogProfileComponentChange(int n, String string, boolean bl) {
    }

    @Override
    public void performanceLogPersistence(int n, int n2) {
    }

    @Override
    public void performanceLogDiagnosis(int n, int n2) {
    }

    @Override
    public void performanceLogWorkunit(String string, int n) {
    }

    @Override
    public void performanceLogEvents(int n, int n2, String string) {
    }

    @Override
    public void performanceLogAppUiLife(int n, String string, String string2, int n2) {
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

