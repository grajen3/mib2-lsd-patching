/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.internal.testmode.TestmodeServiceManager;
import de.vw.mib.log4mib.LogManagerDiag;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public final class TestmodeServiceManagerImpl
implements TestmodeServiceManager {
    public static final TestmodeServiceManager INSTANCE = new TestmodeServiceManagerImpl();
    private final LogManagerDiag logManagerDiag;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LogManagerDiag;

    private TestmodeServiceManagerImpl() {
        BundleContext bundleContext = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getBundleContext();
        ServiceReference serviceReference = bundleContext.getServiceReference((class$de$vw$mib$log4mib$LogManagerDiag == null ? (class$de$vw$mib$log4mib$LogManagerDiag = TestmodeServiceManagerImpl.class$("de.vw.mib.log4mib.LogManagerDiag")) : class$de$vw$mib$log4mib$LogManagerDiag).getName());
        this.logManagerDiag = (LogManagerDiag)bundleContext.getService(serviceReference);
    }

    @Override
    public LogManagerDiag getLogManagerDiag() {
        return this.logManagerDiag;
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

