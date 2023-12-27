/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.framework4u;

import de.vw.mib.collections.CollectionsHelper$SizeWarningsListener;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import org.osgi.framework.BundleContext;

public class SizeWarningsLogger
implements CollectionsHelper$SizeWarningsListener {
    private static final int CLASSIFIER;
    private static final int SUB_CLASSIFIER;
    private final BundleContext context;
    private Logger logger;
    private LoggerFactory loggerFactory;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;

    public SizeWarningsLogger(BundleContext bundleContext) {
        this.context = bundleContext;
    }

    @Override
    public void newSizeWarning(String string, int n, int n2) {
        this.createLoggerIfNecessary();
        if (null != this.logger) {
            StackTraceElement stackTraceElement = new RuntimeException().getStackTrace()[n2];
            this.logger.warn(2).append(string).append(": Possible memory leak detected in ").append(stackTraceElement.getFileName()).append(":").append(stackTraceElement.getLineNumber()).append(" (current container size=").append(n).append(")").log();
        }
    }

    private void createLoggerIfNecessary() {
        if (null != this.logger) {
            return;
        }
        this.loggerFactory = (LoggerFactory)this.context.getService(this.context.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = SizeWarningsLogger.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName()));
        if (null == this.loggerFactory) {
            return;
        }
        this.logger = this.loggerFactory.getLogger(4);
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

