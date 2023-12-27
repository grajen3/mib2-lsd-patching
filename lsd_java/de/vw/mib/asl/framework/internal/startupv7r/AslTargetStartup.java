/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rAPI;
import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.id.PreRegisteredIds;
import de.vw.mib.asl.framework.internal.startupv7r.AslTargetStartup$1;
import de.vw.mib.asl.framework.internal.startupv7r.DSIBootExtensionNEW;
import de.vw.mib.asl.framework.internal.startupv7r.PersistableEarlyData;
import de.vw.mib.asl.framework.internal.startupv7r.StartupServiceManager;
import de.vw.mib.asl.framework.internal.startupv7r.StartupServices;
import de.vw.mib.asl.framework.internal.startupv7r.operation.StartupLauncher;
import de.vw.mib.asl.framework.internal.startupv7r.specialmethods.SpecialMethodWaitForNavToFinish;
import de.vw.mib.error.RebootExecutor;
import de.vw.mib.error.ShowErrorPopupExecutor;
import de.vw.mib.error.SwitchToMenuExecutor;
import de.vw.mib.event.StartupEvent;
import de.vw.mib.event.consumer.ASLStartupManagerEventConsumer;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.powermanagement.DSIPowerManagement;
import org.dsi.ifc.powermanagement.DSIPowerManagementListener;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

public class AslTargetStartup
extends AbstractASLTarget
implements ServiceListener,
DSIServiceStateListener,
ASLStartupManagerEventConsumer,
ShowErrorPopupExecutor,
RebootExecutor,
SwitchToMenuExecutor {
    public static AslTargetStartup aslTargetStartupInstance;
    private static int lastKnownPowerState;
    private static final int EV_DEBUGPROBES_CHANGED;
    private static final int INVALID;
    private final ASLStartupv7rAPI aslStartupv7rAPI = ASLStartupv7rFactory.getStartupv7rApi();
    private final StartupServices startupServices;
    private PersistableEarlyData persistableData = PersistableEarlyData.getInstance();
    private boolean initialWorkDone = false;
    private boolean navigationWasUNRegistered = false;
    private DSIPowerManagement dsiPowerManagement;
    private DSIListener powerManagementListener;
    private boolean startUpCalled = false;
    static /* synthetic */ Class class$de$vw$mib$event$consumer$ASLStartupManagerEventConsumer;
    static /* synthetic */ Class class$org$dsi$ifc$base$ServiceAdmin;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagement;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagementListener;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;

    public AslTargetStartup(GenericEvents genericEvents, int n, String string, StartupServices startupServices) {
        super(genericEvents, n, string);
        aslTargetStartupInstance = this;
        this.startupServices = startupServices;
        ServiceManager.bundleContext.registerService((class$de$vw$mib$event$consumer$ASLStartupManagerEventConsumer == null ? (class$de$vw$mib$event$consumer$ASLStartupManagerEventConsumer = AslTargetStartup.class$("de.vw.mib.event.consumer.ASLStartupManagerEventConsumer")) : class$de$vw$mib$event$consumer$ASLStartupManagerEventConsumer).getName(), (Object)this, null);
    }

    void doInitialWorkPreload() {
        this.trace(">>> doing initial work");
        DSIProxyFactory.getDSIProxyAPI().getDSIProxy().addServiceStateListener(this);
        PreRegisteredIds.registerIds(ServiceManager.eventMain);
        this.startupServices.getStartupStateService().updateStartupState(1);
    }

    @Override
    public void serviceChanged(ServiceEvent serviceEvent) {
        Object object = ServiceManager.bundleContext.getService(serviceEvent.getServiceReference());
        String[] stringArray = (String[])serviceEvent.getServiceReference().getProperty("objectClass");
        try {
            int n = stringArray.length;
            block5: while (--n >= 0) {
                if (!stringArray[n].equals((class$org$dsi$ifc$base$ServiceAdmin == null ? AslTargetStartup.class$("org.dsi.ifc.base.ServiceAdmin") : class$org$dsi$ifc$base$ServiceAdmin).getName())) continue;
                switch (serviceEvent.getType()) {
                    case 1: {
                        ServiceManager.dsiServiceAdmin = new DSIBootExtensionNEW(object);
                        this.trace("DSIBoot registered");
                        this.triggerMe(-1568276224);
                        continue block5;
                    }
                }
            }
        }
        catch (GenericEventException genericEventException) {
            ServiceManager.errorHandler.handleError(genericEventException);
        }
    }

    @Override
    public void registered(String string, int n) {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        if (string.equals((class$org$dsi$ifc$powermanagement$DSIPowerManagement == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagement = AslTargetStartup.class$("org.dsi.ifc.powermanagement.DSIPowerManagement")) : class$org$dsi$ifc$powermanagement$DSIPowerManagement).getName())) {
            this.dsiPowerManagement = (DSIPowerManagement)dSIProxy.getService(this, class$org$dsi$ifc$powermanagement$DSIPowerManagement == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagement = AslTargetStartup.class$("org.dsi.ifc.powermanagement.DSIPowerManagement")) : class$org$dsi$ifc$powermanagement$DSIPowerManagement);
            this.powerManagementListener = this.createDsiPowerManagementListener();
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$powermanagement$DSIPowerManagementListener == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagementListener = AslTargetStartup.class$("org.dsi.ifc.powermanagement.DSIPowerManagementListener")) : class$org$dsi$ifc$powermanagement$DSIPowerManagementListener, this.powerManagementListener);
            this.dsiPowerManagement.setNotification(new int[]{1}, this.powerManagementListener);
        } else if (string.equals((class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = AslTargetStartup.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName()) && this.navigationWasUNRegistered) {
            this.navigationWasUNRegistered = false;
            this.info("[ASLStartup v8]", "DSINavigation RE-registered, switching navigation back on");
        }
    }

    private DSIPowerManagementListener createDsiPowerManagementListener() {
        return new AslTargetStartup$1(this);
    }

    @Override
    public void unregistered(String string, int n) {
        if (string.equals((class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = AslTargetStartup.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName())) {
            this.navigationWasUNRegistered = true;
            this.info("[ASLStartup v8]", "DSINavigation unregistered, switching off navigation");
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), 1783305216, 107);
            this.sendSafeLocal(eventGeneric);
        }
    }

    @Override
    public void consumeEvent(StartupEvent startupEvent) {
        if (startupEvent.getEventId() == 8) {
            this.stopTimer(-830013184);
            if (this.isTraceEnabled()) {
                this.trace().append("[ASLStartup v8]").append("Late load Speech: STARTUP_GUI_READY received!").log();
            }
            EventGeneric eventGeneric = null;
            this.triggerObserver(1148656384, eventGeneric);
        } else if (startupEvent.getEventId() == 9) {
            if (this.isTraceEnabled()) {
                this.trace().append("[ASLStartup v8]").append("Late load DONE: Online Services may be started now").log();
            }
            this.startupServices.getStartupStateService().notifyBundleLateLoadDone();
        }
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 8: {
                break;
            }
            case 106: {
                this.doInitialWorkPreload();
                this.registerService(1098324736);
                this.registerService(1148656384);
                this.addObserver(1098324736);
                this.addObserver(782057728);
                this.addObserver(832389376);
                this.doInitialWork();
                if (ServiceManager.dsiServiceAdmin == null) break;
                this.trace("ServiceAdmin is already registered, starting system...");
                this.startUpCalled = true;
                this.startUp();
                break;
            }
            case 4300081: {
                ServiceManager.logger.normal(1).append("[ASLStartup v8]").append(" Recieved most capabilities");
                StartupServiceManager.pictureServerStartAllowed = eventGeneric.getBoolean(0);
                StartupServiceManager.pictureServerStartAllowed |= eventGeneric.getBoolean(1);
                break;
            }
            case 1800001: {
                this.processStartupIsDone();
                break;
            }
            case 1800002: {
                int n = eventGeneric.getInt(0);
                this.trace("DebugProbes changed, persisting... >> ", n);
                this.persistableData.setDebugProbeConfiguration(n);
                ServiceManager.configManagerDiag.setDynamicTmDebugProbesCfg(n);
                break;
            }
            case 1073743401: {
                this.persistableData.toggleTestmodeAlternativeViewSetup1();
                AslTargetStartup.writeBooleanToDatapool(1618, this.persistableData.getTestmodeAlternativeViewSetup1());
                break;
            }
            case 1073743402: {
                this.persistableData.toggleTestmodeAlternativeViewSetup2();
                AslTargetStartup.writeBooleanToDatapool(1619, this.persistableData.getTestmodeAlternativeViewSetup2());
                break;
            }
            case 100303: {
                SpecialMethodWaitForNavToFinish.onNavStartupDone();
                break;
            }
            case 100002: {
                if (!this.initialWorkDone || this.startUpCalled) break;
                this.trace("DSIBoot was registered, starting system...");
                this.startUpCalled = true;
                this.startUp();
                break;
            }
            case 100302: {
                ServiceManager.errorHandler.handleStartupError(new Exception("First Screen was not shown in time (60 sec from start), going to menu..."));
                ServiceManager.eventDispatcher.createAndSubmitHardkeyEvent(320);
                ServiceManager.eventDispatcher.createAndSubmitHardkeyEvent(319);
                break;
            }
            case 4300078: {
                StartupServiceManager.komoNavIsAllowedByCoding = eventGeneric.getBoolean(0);
                break;
            }
            case 100308: {
                ServiceManager.errorHandler.handleStartupError(new Exception("Startup seemingly halted..."));
                this.error("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                this.error("Startup seemingly halted...");
                this.error("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                break;
            }
            default: {
                if (!this.isTraceEnabled()) break;
                this.trace().append("[ASLStartup v8]").append("Unknown event in ASLStartup V7 received: ").append(eventGeneric).log();
            }
        }
    }

    private void startUp() {
        this.startTimer(-830013184, (long)0, false);
        this.startTimer(-729349888, (long)0, false);
        new StartupLauncher(this.startupServices).start();
    }

    public void updateStateToHmi(int n) {
        if (n != -1) {
            if (this.isTraceEnabled()) {
                this.trace().append("[ASLStartup v8]").append("domain-to-hmi update: ").append(n).log();
            }
            boolean bl = true;
            ServiceManager.aslPropertyManager.valueChangedInteger(n, 1);
        }
    }

    public void triggerLamContextToPlay() {
    }

    void dsiPowerManagementUpdatePowerManagementState(int n, int n2) {
        int n3 = n;
        this.info().append("[ASLStartup v8]").append("Powerstate detected by Startup Manager: ").append(n3).log();
        switch (n3) {
            case 8: {
                if (this.aslStartupv7rAPI.isNonCustomerSwdlIsInProgress()) break;
                StartupServiceManager.nonCustomerSwdlIsInProgress = true;
                StartupServiceManager.swdlPowerstateDetected = true;
                this.info().append("[ASLStartup v8]").append("SWDL Powerstate detected by Startup Manager").log();
                break;
            }
            case 0: 
            case 3: 
            case 4: 
            case 9: {
                if (lastKnownPowerState != 8) break;
                StartupServiceManager.nonCustomerSwdlIsInProgress = false;
                break;
            }
            default: {
                if (lastKnownPowerState != 8) break;
                StartupServiceManager.nonCustomerSwdlIsInProgress = false;
            }
        }
        lastKnownPowerState = n;
    }

    private void doInitialWork() {
        if (!this.initialWorkDone) {
            this.trace(">>> doing initial work");
            StringBuffer stringBuffer = new StringBuffer(100);
            stringBuffer.append("(").append("objectClass").append("=").append((class$org$dsi$ifc$base$ServiceAdmin == null ? (class$org$dsi$ifc$base$ServiceAdmin = AslTargetStartup.class$("org.dsi.ifc.base.ServiceAdmin")) : class$org$dsi$ifc$base$ServiceAdmin).getName()).append(")");
            ServiceManager.bundleContext.addServiceListener(this, stringBuffer.toString());
            ServiceReference[] serviceReferenceArray = ServiceManager.bundleContext.getServiceReferences((class$org$dsi$ifc$base$ServiceAdmin == null ? (class$org$dsi$ifc$base$ServiceAdmin = AslTargetStartup.class$("org.dsi.ifc.base.ServiceAdmin")) : class$org$dsi$ifc$base$ServiceAdmin).getName(), null);
            for (int i2 = 0; serviceReferenceArray != null && i2 < serviceReferenceArray.length; ++i2) {
                this.serviceChanged(new ServiceEvent(1, serviceReferenceArray[i2]));
            }
            ServiceManager.eventMain.getServiceRegister().registerService(1115101952, this.getTargetId(), -1400504064, true);
            this.addObserver(1115101952);
            this.addObserver(688259136);
            this.addObserver(705036352);
            this.initialWorkDone = true;
        }
    }

    @Override
    public void trace(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append("[ASLStartup v8]").append(string).log();
        }
    }

    public void triggerMeSafe(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), this.getTargetId(), n);
        this.sendSafeLocal(eventGeneric);
    }

    @Override
    public int getClassifier() {
        return 1;
    }

    @Override
    public int getSubClassifier() {
        return 1;
    }

    @Override
    public void switchToMenu() {
        this.warn().append("[ASLStartup v8]").append("Switch to MainMenu Requested by ErrorHandler").log();
        ServiceManager.eventDispatcher.createAndSubmitHardkeyEvent(320);
        ServiceManager.eventDispatcher.createAndSubmitHardkeyEvent(319);
    }

    @Override
    public void performSystemReboot() {
        boolean bl = false;
        String string = System.getProperty("de.vw.mib.system.useCriticalReboot");
        if (string != null && "true".equalsIgnoreCase(string)) {
            bl = true;
        }
        this.warn().append("[ASLStartup v8]").append("Reboot Requested by ErrorHandler").log();
        if (bl) {
            this.dsiPowerManagement.rebootSystemCritical();
        } else {
            this.dsiPowerManagement.rebootSystem();
        }
    }

    @Override
    public void showErrorPopup(Throwable throwable) {
        String string = throwable.getMessage();
        ServiceManager.aslPropertyManager.valueChangedString(2401, string);
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(429);
    }

    public PersistableEarlyData getPersistableEarlyData() {
        return this.persistableData;
    }

    private void processStartupIsDone() {
        List list = ServiceManager.errorHandler.getStartupErrors();
        if (!list.isEmpty()) {
            Iterator iterator = list.iterator();
            StringBuffer stringBuffer = new StringBuffer();
            while (iterator.hasNext()) {
                Throwable throwable = (Throwable)iterator.next();
                stringBuffer.append(throwable.getMessage());
            }
            ServiceManager.aslPropertyManager.valueChangedString(2401, stringBuffer.toString());
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(429);
            ServiceManager.errorHandler.clearStartupErrors();
        }
        if (this.aslStartupv7rAPI.isHighActivatorStarted()) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(3688, true);
        }
        this.startupServices.getRestartHandler().performRestartAfterStartup();
        this.startupServices.getStartupStateService().updateStartupState(2);
    }

    public boolean sendSafeLocal(EventGeneric eventGeneric) {
        boolean bl = true;
        eventGeneric.setSenderTargetId(this.getTargetId());
        try {
            this.getEventDispatcher().send(eventGeneric);
        }
        catch (GenericEventException genericEventException) {
            bl = false;
            this.error().attachThrowable(genericEventException).log();
        }
        return bl;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        lastKnownPowerState = -1;
    }
}

