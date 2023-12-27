/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.AppLifecycleService;
import de.vw.mib.app.AppUIGate;
import de.vw.mib.app.framework.internal.AppAdapterController;
import de.vw.mib.app.framework.internal.AppContext;
import de.vw.mib.app.framework.internal.AppDiagController;
import de.vw.mib.app.framework.internal.AppLifecycleManager;
import de.vw.mib.app.framework.internal.AppUIController;
import de.vw.mib.app.framework.internal.Services$AppFrameworkManagerServices;
import de.vw.mib.app.framework.internal.Services$CommonFrameworkServices;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.modelapi.ui.ModelApiUpEventHandler;
import de.vw.mib.util.StringBuilder;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

final class AppLifecycleController
implements AppLifecycleService,
ServiceListener {
    private final AppAdapterController appAdapterController;
    private final AppContext appContext;
    private final AppDiagController appDiagController;
    private final AppLifecycleManager appLifecycleManager;
    private final AppUIController appUIController;
    private final AppUIGate appUIGate;
    private final BundleContext bundleContext;
    private int lifecycleState;
    private final Logger logger;

    AppLifecycleController(AppContext appContext, Services$AppFrameworkManagerServices services$AppFrameworkManagerServices, Services$CommonFrameworkServices services$CommonFrameworkServices) {
        this.logger = appContext.getLogger();
        this.appContext = appContext;
        this.appAdapterController = appContext.getAppAdapterController();
        this.appDiagController = appContext.getAppDiagController();
        this.appUIController = appContext.getAppUIController();
        this.appUIGate = appContext.getAppUIGate();
        this.appLifecycleManager = services$AppFrameworkManagerServices.getAppLifecycleManager();
        this.bundleContext = services$CommonFrameworkServices.getBundleContext();
        this.lifecycleState = 1;
    }

    @Override
    public void serviceChanged(ServiceEvent serviceEvent) {
        block5: {
            String[] stringArray;
            Object object;
            block4: {
                object = this.bundleContext.getService(serviceEvent.getServiceReference());
                stringArray = (String[])serviceEvent.getServiceReference().getProperty("objectClass");
                if (serviceEvent.getType() != 1) break block4;
                for (int i2 = 0; i2 < stringArray.length; ++i2) {
                    if (this.logger.isTraceEnabled(8)) {
                        this.logger.trace(8).append(this).append(" - business component available: ").append(stringArray[i2]).log();
                    }
                    this.appUIGate.onBusinessComponentAvailable(stringArray[i2], object);
                }
                break block5;
            }
            if (serviceEvent.getType() != 4) break block5;
            for (int i3 = 0; i3 < stringArray.length; ++i3) {
                if (this.logger.isTraceEnabled(8)) {
                    this.logger.trace(8).append(this).append(" - business component unavailable: ").append(stringArray[i3]).log();
                }
                this.appUIGate.onBusinessComponentUnavailable(stringArray[i3], object);
            }
        }
    }

    @Override
    public void started(ModelApiUpEventHandler modelApiUpEventHandler) {
        if (this.logger.isTraceEnabled(2)) {
            this.logger.trace(2).append(this.appContext).append(" - app started!").log();
        }
        this.checkLifecycle(2);
        this.setLifecycle(4);
        this.appAdapterController.started(modelApiUpEventHandler);
        this.appLifecycleManager.readyAppIfPossible(this.appContext, this);
    }

    @Override
    public void stopped() {
        if (this.logger.isTraceEnabled(2)) {
            this.logger.trace(2).append(this.appContext).append(" - app stopped!").log();
        }
        this.setLifecycle(1);
    }

    public String toString() {
        return this.appContext.toString();
    }

    int getLifecycleState() {
        return this.lifecycleState;
    }

    void start() {
        if (this.logger.isTraceEnabled(2)) {
            this.logger.trace(2).append(this.appContext).append(" - app starting ...").log();
        }
        this.checkLifecycle(1);
        this.setLifecycle(2);
        try {
            this.appUIGate.start(this, this.appUIController);
            this.appAdapterController.start();
        }
        catch (Throwable throwable) {
            this.logger.error(2).append(this.appContext).append("error while handling app start!").attachThrowable(throwable).log();
        }
        this.registerServiceListener();
    }

    void stop() {
        if (this.logger.isTraceEnabled(2)) {
            this.logger.trace(2).append(this.appContext).append(" - app stopping ...").log();
        }
        this.setLifecycle(16);
        try {
            this.appUIGate.stop();
            this.appAdapterController.stop();
        }
        catch (Throwable throwable) {
            this.logger.error(2).append(this.appContext).append("error while handling app stop!").attachThrowable(throwable).log();
        }
        this.appLifecycleManager.stopHostAppsIfNecessary(this.appContext);
    }

    void ready() {
        if (this.logger.isTraceEnabled(2)) {
            this.logger.trace(2).append(this.appContext).append(" - app ready!").log();
        }
        this.checkLifecycle(4);
        this.setLifecycle(8);
        try {
            this.appUIGate.ready();
            this.appAdapterController.ready();
        }
        catch (Throwable throwable) {
            this.logger.error(2).append(this.appContext).append("error while handling app ready!").attachThrowable(throwable).log();
        }
        this.appLifecycleManager.readyHostAppsIfPossible(this.appContext);
    }

    private void checkLifecycle(int n) {
        if (this.lifecycleState != n) {
            this.logger.error(2).append(this.appContext).append(" - Invalid lifecycle state! expected: ").append(n).append(", actual: ").append(this.lifecycleState).attachThrowable(new IllegalStateException("Invalid lifecycle state!")).log();
        }
    }

    private void registerServiceListener() {
        String[] stringArray = this.appContext.getAppDefinition().getNeededBusinessComponents();
        if (stringArray == null || stringArray.length == 0) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(|");
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            stringBuilder.append("(").append("objectClass").append("=").append(stringArray[i2]).append(")");
        }
        stringBuilder.append(")");
        String string = stringBuilder.toString();
        try {
            this.bundleContext.addServiceListener(this, string);
            ServiceReference[] serviceReferenceArray = this.bundleContext.getServiceReferences(null, string);
            for (int i3 = 0; serviceReferenceArray != null && i3 < serviceReferenceArray.length; ++i3) {
                this.serviceChanged(new ServiceEvent(1, serviceReferenceArray[i3]));
            }
        }
        catch (InvalidSyntaxException invalidSyntaxException) {
            // empty catch block
        }
    }

    private void setLifecycle(int n) {
        this.lifecycleState = n;
        this.appDiagController.onLifecycleChanged(n);
    }
}

