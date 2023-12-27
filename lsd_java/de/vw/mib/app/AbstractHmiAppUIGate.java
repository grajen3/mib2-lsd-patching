/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app;

import de.vw.mib.app.AppLifecycleService;
import de.vw.mib.app.AppUIGate;
import de.vw.mib.app.AppUIService;
import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.app.internal.AppSystemServices;
import de.vw.mib.datapool.AppAdapterListItemControlManager;
import de.vw.mib.datapool.internal.AppAdapterListItemControlManagerImpl;
import de.vw.mib.event.dispatcher.ViewEventDispatcher;
import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.modelapi.ui.ModelApiUpEventHandler;
import de.vw.mib.view.internal.ViewHandlerAppServices;
import de.vw.mib.view.internal.ViewHandlerAppServicesImpl;
import de.vw.mib.viewmanager.internal.ViewHandler;
import de.vw.mib.viewmanager.internal.ViewHandlerFactory;

public abstract class AbstractHmiAppUIGate
implements AppUIGate {
    protected final AppDefinition appDefinition;
    protected final AppSystemServices systemServices;
    private AppLifecycleService lifecycleService;
    private AppUIService uiService;
    private boolean isStarted = false;
    private ViewHandlerFactory viewHandlerFactory;
    private AppAdapterListItemControlManager appAdapterListItemControlManager;

    protected AbstractHmiAppUIGate(AppDefinition appDefinition, AppSystemServices appSystemServices) {
        this.appDefinition = appDefinition;
        this.systemServices = appSystemServices;
    }

    public final AppDefinition getAppDefinition() {
        return this.appDefinition;
    }

    @Override
    public final void onBusinessComponentAvailable(String string, Object object) {
    }

    @Override
    public final void onBusinessComponentUnavailable(String string, Object object) {
    }

    @Override
    public final void start(AppLifecycleService appLifecycleService, AppUIService appUIService) {
        if (!this.isStarted) {
            this.lifecycleService = appLifecycleService;
            this.uiService = appUIService;
            this.onStarting();
            this.isStarted = true;
            this.lifecycleService.started(this.newModelApiUpEventHandler(this.appAdapterListItemControlManager));
        }
    }

    protected abstract ModelApiUpEventHandler newModelApiUpEventHandler(AppAdapterListItemControlManager appAdapterListItemControlManager) {
    }

    @Override
    public final void ready() {
        this.onReady(this.uiService);
        boolean bl = this.appDefinition.getAppType().equals("DesktopApp");
        if (bl) {
            this.requestVisibilityOfAllLayers(this.uiService);
        }
    }

    protected abstract void requestVisibilityOfAllLayers(AppUIService appUIService) {
    }

    @Override
    public final void stop() {
        if (this.isStarted) {
            this.onStopping();
            this.isStarted = false;
            this.lifecycleService.stopped();
        }
    }

    protected void onStarting() {
        this.appAdapterListItemControlManager = this.newAppAdapterListItemControlManager();
        ViewEventDispatcher viewEventDispatcher = this.systemServices.getViewEventDispatcher();
        ViewHandlerAppServicesImpl viewHandlerAppServicesImpl = new ViewHandlerAppServicesImpl(this.appDefinition, this.appAdapterListItemControlManager, viewEventDispatcher);
        this.viewHandlerFactory = this.newViewHandlerFactory(viewHandlerAppServicesImpl);
        this.systemServices.getGlobalViewHandlerRegister().registerRelayFactory(this.appDefinition, this.viewHandlerFactory);
    }

    protected abstract void onReady(AppUIService appUIService) {
    }

    protected void onStopping() {
        this.systemServices.getGlobalViewHandlerRegister().unregisterRelayFactory(this.appDefinition);
        this.viewHandlerFactory = null;
        this.appAdapterListItemControlManager = null;
    }

    private AppAdapterListItemControlManager newAppAdapterListItemControlManager() {
        return new AppAdapterListItemControlManagerImpl(this.appDefinition, this.getAppAdapterListInitialSizes(), this.systemServices.getLoggerFactory());
    }

    protected int[] getAppAdapterListInitialSizes() {
        return new int[0];
    }

    protected abstract ViewHandlerFactory newViewHandlerFactory(ViewHandlerAppServices viewHandlerAppServices) {
    }

    @Override
    public ViewHandler getViewHandler(String string) {
        Preconditions.checkState(this.isStarted, new StringBuffer().append("Operation not allowed yet. App UI Gate ").append(super.getClass().getName()).append(" not started.").toString());
        return this.viewHandlerFactory.createViewHandler(string);
    }

    protected void fireInternalHMIEvent(int n) {
        this.systemServices.getEventDispatcher().createAndSubmitHMIEvent(this.appDefinition, this.appDefinition, n);
    }
}

