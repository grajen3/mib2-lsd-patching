/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.error.internal;

import de.vw.mib.debug.spi.DebugSPI;
import de.vw.mib.error.RebootExecutor;
import de.vw.mib.error.ShowErrorPopupExecutor;
import de.vw.mib.error.SwitchToMenuExecutor;
import de.vw.mib.error.internal.ErrorHandlerImpl;
import de.vw.mib.error.internal.HighLoadDetectionManager;
import de.vw.mib.error.internal.MemoryInfoProvider;
import de.vw.mib.error.internal.PoorMansPoolStatisticsProvider;
import de.vw.mib.error.internal.ServiceManager;
import de.vw.mib.log4mib.LogManager;
import de.vw.mib.log4mib.LoggerFactory;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;

public class Activator
implements BundleActivator,
ServiceListener {
    private static final String REBOOT_EXECUTOR = (class$de$vw$mib$error$RebootExecutor == null ? (class$de$vw$mib$error$RebootExecutor = Activator.class$("de.vw.mib.error.RebootExecutor")) : class$de$vw$mib$error$RebootExecutor).getName();
    private static final String SHOW_ERROR_POPUP_EXECUTOR = (class$de$vw$mib$error$ShowErrorPopupExecutor == null ? (class$de$vw$mib$error$ShowErrorPopupExecutor = Activator.class$("de.vw.mib.error.ShowErrorPopupExecutor")) : class$de$vw$mib$error$ShowErrorPopupExecutor).getName();
    private static final String SWITCH_TO_MENU_EXECUTOR = (class$de$vw$mib$error$SwitchToMenuExecutor == null ? (class$de$vw$mib$error$SwitchToMenuExecutor = Activator.class$("de.vw.mib.error.SwitchToMenuExecutor")) : class$de$vw$mib$error$SwitchToMenuExecutor).getName();
    private BundleContext context;
    static /* synthetic */ Class class$de$vw$mib$error$RebootExecutor;
    static /* synthetic */ Class class$de$vw$mib$error$ShowErrorPopupExecutor;
    static /* synthetic */ Class class$de$vw$mib$error$SwitchToMenuExecutor;
    static /* synthetic */ Class class$de$vw$mib$debug$spi$DebugSPI;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LogManager;
    static /* synthetic */ Class class$de$vw$mib$error$ErrorHandler;

    @Override
    public void serviceChanged(ServiceEvent serviceEvent) {
        block3: {
            block2: {
                if (serviceEvent.getType() != 1) break block2;
                Object object = this.context.getService(serviceEvent.getServiceReference());
                String[] stringArray = (String[])serviceEvent.getServiceReference().getProperty("objectClass");
                for (int i2 = 0; i2 < stringArray.length; ++i2) {
                    this.handleServiceRegistered(stringArray[i2], object);
                }
                break block3;
            }
            if (serviceEvent.getType() != 4) break block3;
            String[] stringArray = (String[])serviceEvent.getServiceReference().getProperty("objectClass");
            for (int i3 = 0; i3 < stringArray.length; ++i3) {
                this.handleServiceUnregistering(stringArray[i3]);
            }
        }
    }

    @Override
    public void start(BundleContext bundleContext) {
        this.context = bundleContext;
        ServiceManager.debugSpi = (DebugSPI)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$debug$spi$DebugSPI == null ? (class$de$vw$mib$debug$spi$DebugSPI = Activator.class$("de.vw.mib.debug.spi.DebugSPI")) : class$de$vw$mib$debug$spi$DebugSPI).getName()));
        ServiceManager.loggerFactory = (LoggerFactory)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = Activator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName()));
        LogManager logManager = (LogManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$log4mib$LogManager == null ? (class$de$vw$mib$log4mib$LogManager = Activator.class$("de.vw.mib.log4mib.LogManager")) : class$de$vw$mib$log4mib$LogManager).getName()));
        ErrorHandlerImpl errorHandlerImpl = new ErrorHandlerImpl(ServiceManager.debugSpi);
        bundleContext.registerService((class$de$vw$mib$error$ErrorHandler == null ? (class$de$vw$mib$error$ErrorHandler = Activator.class$("de.vw.mib.error.ErrorHandler")) : class$de$vw$mib$error$ErrorHandler).getName(), (Object)errorHandlerImpl, null);
        HighLoadDetectionManager.create();
        new MemoryInfoProvider(logManager, errorHandlerImpl);
        new PoorMansPoolStatisticsProvider(errorHandlerImpl);
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("(|");
        stringBuffer.append("(").append("objectClass").append("=").append(REBOOT_EXECUTOR).append(")");
        stringBuffer.append("(").append("objectClass").append("=").append(SHOW_ERROR_POPUP_EXECUTOR).append(")");
        stringBuffer.append("(").append("objectClass").append("=").append(SWITCH_TO_MENU_EXECUTOR).append(")");
        stringBuffer.append(")");
        String string = stringBuffer.toString();
        bundleContext.addServiceListener(this, string);
    }

    @Override
    public void stop(BundleContext bundleContext) {
    }

    private void handleServiceRegistered(String string, Object object) {
        if (REBOOT_EXECUTOR.equals(string)) {
            ServiceManager.rebootExecutor = (RebootExecutor)object;
        } else if (SHOW_ERROR_POPUP_EXECUTOR.equals(string)) {
            ServiceManager.showErrorPopupExecutor = (ShowErrorPopupExecutor)object;
        } else if (SWITCH_TO_MENU_EXECUTOR.equals(string)) {
            ServiceManager.switchToMenuExecutor = (SwitchToMenuExecutor)object;
        }
    }

    private void handleServiceUnregistering(String string) {
        if (REBOOT_EXECUTOR.equals(string)) {
            ServiceManager.rebootExecutor = null;
        } else if (SHOW_ERROR_POPUP_EXECUTOR.equals(string)) {
            ServiceManager.showErrorPopupExecutor = null;
        } else if (SWITCH_TO_MENU_EXECUTOR.equals(string)) {
            ServiceManager.switchToMenuExecutor = null;
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

