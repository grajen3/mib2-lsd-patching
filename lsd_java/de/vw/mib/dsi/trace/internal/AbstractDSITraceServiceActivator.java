/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.internal;

import de.vw.mib.dsi.trace.DSITraceService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public abstract class AbstractDSITraceServiceActivator
implements BundleActivator {
    protected static final String ERRORMESSAGE_DSITRACESERVICE_INIT_FAILED;
    protected static final String ERRORMESSAGE_DSITRACESERVICE_EXCEPTION_WHILE_INIT;
    private DSITraceService traceServiceInstance = null;
    static /* synthetic */ Class class$de$vw$mib$dsi$trace$DSITraceService;

    @Override
    public final void start(BundleContext bundleContext) {
        try {
            if (this.initDSITraceService()) {
                DSITraceService dSITraceService = this.getDSITraceServiceForOSGiRegistration();
                bundleContext.registerService((class$de$vw$mib$dsi$trace$DSITraceService == null ? (class$de$vw$mib$dsi$trace$DSITraceService = AbstractDSITraceServiceActivator.class$("de.vw.mib.dsi.trace.DSITraceService")) : class$de$vw$mib$dsi$trace$DSITraceService).getName(), (Object)dSITraceService, null);
            } else {
                this.logError("Failed to initialize DSI trace service", null);
            }
        }
        catch (Exception exception) {
            this.logError("Exception in initialization of DSI trace service", exception);
        }
    }

    @Override
    public final void stop(BundleContext bundleContext) {
    }

    protected abstract boolean initDSITraceService() {
    }

    protected final void setDSITraceServiceForOSGiRegistration(DSITraceService dSITraceService) {
        this.traceServiceInstance = dSITraceService;
    }

    protected final DSITraceService getDSITraceServiceForOSGiRegistration() {
        return this.traceServiceInstance;
    }

    protected final void logError(String string, Exception exception) {
        System.err.println(string);
        if (exception != null) {
            exception.printStackTrace(System.err);
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

