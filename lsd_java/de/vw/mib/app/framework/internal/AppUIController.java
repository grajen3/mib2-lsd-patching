/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.AppUIGate;
import de.vw.mib.app.AppUIService;
import de.vw.mib.app.esam.EsamServiceForViews;
import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.app.framework.internal.AppContext;
import de.vw.mib.app.framework.internal.AppDiagController;
import de.vw.mib.app.framework.internal.AppUIController$HostedAppLink;
import de.vw.mib.app.framework.internal.AppUIController$PrivateModelApiDownEventService;
import de.vw.mib.app.framework.internal.AppUIController$PrivateViewEventDispatcher;
import de.vw.mib.app.framework.internal.AppVisibilityManager;
import de.vw.mib.app.framework.internal.Services$AppFrameworkManagerServices;
import de.vw.mib.app.framework.internal.Services$AppFrameworkServices;
import de.vw.mib.app.framework.internal.Services$CommonFrameworkServices;
import de.vw.mib.app.framework.internal.Services$EventDispatcherServices;
import de.vw.mib.desktop.DesktopManager;
import de.vw.mib.event.dispatcher.apps.ViewEventDispatcher;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.modelapi.appadapter.ModelApiDownEventHandler;
import de.vw.mib.modelapi.ui.ModelApiDownEventService;
import de.vw.mib.viewmanager.internal.ViewHandler;
import edu.emory.mathcs.backport.java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;

final class AppUIController
implements AppUIService {
    private final AppContext appContext;
    private final AppDefinition appDefinition;
    private final AppDiagController appDiagController;
    private final Map appLayer2ScreenAreaPath;
    private final AppUIGate appUIGate;
    private final AppVisibilityManager appVisibilityManager;
    private final Services$CommonFrameworkServices commonFrameworkServices;
    private final DesktopManager desktopManager;
    private AppUIController hostAppUIController = null;
    private final Map linkedHostedApps;
    private final Logger logger;
    private final AppUIController$PrivateModelApiDownEventService modelApiDownEventService;
    private final Map providedScreenAreaPaths;
    private final Map usedScreenAreas;
    private final AppUIController$PrivateViewEventDispatcher viewEventDispatcher;
    private final Set visibleLayers;
    private final Set visibleProvidedScreenAreas;

    AppUIController(AppContext appContext, Services$AppFrameworkManagerServices services$AppFrameworkManagerServices, Services$AppFrameworkServices services$AppFrameworkServices, Services$CommonFrameworkServices services$CommonFrameworkServices, Services$EventDispatcherServices services$EventDispatcherServices) {
        this.logger = appContext.getLogger();
        this.appContext = appContext;
        this.appDiagController = appContext.getAppDiagController();
        this.appUIGate = appContext.getAppUIGate();
        this.appDefinition = appContext.getAppDefinition();
        this.usedScreenAreas = this.appDefinition.getUsedScreenAreas();
        this.appVisibilityManager = services$AppFrameworkManagerServices.getAppVisibilityManager();
        this.commonFrameworkServices = services$CommonFrameworkServices;
        this.desktopManager = services$AppFrameworkServices.getDesktopManager();
        this.modelApiDownEventService = new AppUIController$PrivateModelApiDownEventService(this, this.appDiagController, services$EventDispatcherServices);
        this.viewEventDispatcher = new AppUIController$PrivateViewEventDispatcher(this, this.appDefinition, services$EventDispatcherServices);
        this.appLayer2ScreenAreaPath = new HashMap();
        this.linkedHostedApps = new HashMap();
        this.providedScreenAreaPaths = new HashMap();
        this.visibleLayers = new HashSet();
        this.visibleProvidedScreenAreas = new HashSet();
    }

    @Override
    public void assignUsedScreenArea(String string, String string2) {
        this.appVisibilityManager.assignUsedScreenArea(this, string, string2);
    }

    @Override
    public void enterView(String string, String string2, boolean bl, int n) {
        if (!this.isVisibilityGranted(string)) {
            this.logger.warn(64).append(this.appContext).append(" - couldn't enter view - view name: ").append(string2).append(", app screen area label: ").append(string).append("! Visibility is not granted!").log();
            return;
        }
        Object[] objectArray = this.getPathForLayerLabel(string);
        if (this.logger.isTraceEnabled(64)) {
            this.logger.trace(64).append(this.appContext).append(" - enter view - view name: ").append(string2).append(", app screen area label: ").append(string).append(" @ ").append(Arrays.toString(objectArray)).log();
        }
        this.desktopManager.enterView(this.appDefinition, this.appUIGate, string2, (String[])objectArray, bl, n);
        this.appDiagController.onEnterView(string, (String[])objectArray, string2);
    }

    @Override
    public void leaveView(String string, String string2) {
        this.leaveView(string, string2, -1);
    }

    @Override
    public void leaveView(String string, String string2, int n) {
        Object[] objectArray = this.getPathForLayerLabel(string);
        if (this.logger.isTraceEnabled(64)) {
            this.logger.trace(64).append(this.appContext).append(" - leave view - view name: ").append(string2).append(", app screen area label: ").append(string).append(" @ ").append(Arrays.toString(objectArray)).log();
        }
        boolean bl = this.isVisibilityGranted(string);
        this.desktopManager.leaveView(string2, (String[])objectArray, n, bl);
        this.appDiagController.onLeaveView(string, (String[])objectArray, string2);
    }

    @Override
    public void openPopup(String string, String string2) {
        ViewHandler viewHandler;
        Object[] objectArray = this.getPathForLayerLabel(string);
        if (this.logger.isTraceEnabled(64)) {
            this.logger.trace(64).append(this.appContext).append(" - open popup - view name: ").append(string2).append(", app screen area label: ").append(string).append(" @ ").append(Arrays.toString(objectArray)).log();
        }
        if ((viewHandler = this.appUIGate.getViewHandler(string2)) == null) {
            this.logger.error(64).append(this.appContext).append("Couldn't load view ").append(string2).append("!").log();
            return;
        }
        this.desktopManager.openPopup(viewHandler, (String[])objectArray);
    }

    @Override
    public void closePopup(String string, String string2) {
        ViewHandler viewHandler;
        Object[] objectArray = this.getPathForLayerLabel(string);
        if (this.logger.isTraceEnabled(64)) {
            this.logger.trace(64).append(this.appContext).append(" - close popup - view name: ").append(string2).append(", app screen area label: ").append(string).append(" @ ").append(Arrays.toString(objectArray)).log();
        }
        if ((viewHandler = this.appUIGate.getViewHandler(string2)) == null) {
            this.logger.error(64).append("Couldn't load view ").append(string2).append("!").log();
            return;
        }
        this.desktopManager.closePopup(viewHandler, (String[])objectArray);
    }

    @Override
    public EsamServiceForViews getEsamServiceForViews() {
        return this.appContext.getEsamService();
    }

    @Override
    public Logger getLogger(int n) {
        return this.commonFrameworkServices.getLogger(n);
    }

    @Override
    public ModelApiDownEventService getModelApiDownEventService() {
        return this.modelApiDownEventService;
    }

    @Override
    public ViewEventDispatcher getViewEventDispatcher() {
        return this.viewEventDispatcher;
    }

    @Override
    public void requestVisibility(String string) {
        if (this.logger.isTraceEnabled(64)) {
            this.logger.trace(64).append(this.appContext).append(" - request visibility for app screen area: ").append(string).log();
        }
        this.appDiagController.onVisibilityRequested(string);
        this.appVisibilityManager.requestVisibility(this, string);
    }

    @Override
    public void updateProvidedScreenAreaVisibility(String string, String string2, boolean bl) {
        if (this.logger.isTraceEnabled(64)) {
            this.logger.trace(8).append(this.appContext).append(" - updateProvidedScreenAreaVisibility - layer label: ").append(string).append(", provided screen area: ").append(string2).append(" -> ").append(bl).log();
        }
        AppUIController$HostedAppLink appUIController$HostedAppLink = this.getLinkedHostedApp(string2);
        this.setPathForProvidedScreenArea(string, string2);
        if (bl) {
            this.visibleProvidedScreenAreas.add(string2);
            if (appUIController$HostedAppLink != null) {
                appUIController$HostedAppLink.grantVisibility();
            }
        } else {
            this.visibleProvidedScreenAreas.remove(string2);
            if (appUIController$HostedAppLink != null) {
                appUIController$HostedAppLink.revokeVisibility();
            }
        }
    }

    public String toString() {
        return this.appContext.toString();
    }

    void grantVisibility(String string, String[] stringArray, AppUIController appUIController) {
        if (this.logger.isTraceEnabled(64)) {
            this.logger.trace(64).append(this.appContext).append(" - grant visibility for app screen area: ").append(string).append(" @ ").append(Arrays.toString(stringArray)).log();
        }
        this.hostAppUIController = appUIController;
        this.appLayer2ScreenAreaPath.put(string, stringArray);
        this.visibleLayers.add(string);
        this.appDiagController.onVisibilityChanged(string, stringArray, true);
        this.appUIGate.grantVisibility(string);
    }

    void revokeVisibility(String string, String[] stringArray, AppUIController appUIController) {
        if (this.hostAppUIController != appUIController) {
            return;
        }
        if (this.logger.isTraceEnabled(64)) {
            this.logger.trace(64).append(this.appContext).append(" - revoke visibility for app screen area: ").append(string).append(" @ ").append(Arrays.toString(stringArray)).log();
        }
        this.appDiagController.onVisibilityChanged(string, stringArray, false);
        this.appUIGate.revokeVisibility(string);
        this.visibleLayers.remove(string);
    }

    String[] getPathForProvidedScreenArea(String string) {
        return (String[])this.providedScreenAreaPaths.get(string);
    }

    boolean isVisibilityGranted(String string) {
        return this.visibleLayers.contains(string);
    }

    void clearScreenArea(String string) {
        AppUIController$HostedAppLink appUIController$HostedAppLink = this.getLinkedHostedApp(string);
        if (appUIController$HostedAppLink == null) {
            return;
        }
        appUIController$HostedAppLink.revokeVisibility();
        this.desktopManager.clearScreenArea(this.getPathForProvidedScreenArea(string));
    }

    void linkHostedAppToScreenArea(String string, String string2, AppUIController appUIController) {
        AppUIController$HostedAppLink appUIController$HostedAppLink = this.getLinkedHostedApp(string2);
        if (appUIController$HostedAppLink != null) {
            if (appUIController$HostedAppLink.hostedApp == appUIController) {
                if (this.isProvidedScreenAreaVisible(string2)) {
                    appUIController$HostedAppLink.grantVisibility();
                }
                return;
            }
            appUIController$HostedAppLink.revokeVisibility();
        }
        if (appUIController == null) {
            this.linkedHostedApps.remove(string2);
            return;
        }
        AppUIController$HostedAppLink appUIController$HostedAppLink2 = new AppUIController$HostedAppLink(this, string2, string, appUIController);
        this.linkedHostedApps.put(string2, appUIController$HostedAppLink2);
        if (this.isProvidedScreenAreaVisible(string2)) {
            appUIController$HostedAppLink2.grantVisibility();
        }
    }

    AppUIController getHostAppUIController() {
        return this.hostAppUIController;
    }

    String getUsedScreenAreaId(String string) {
        return (String)this.usedScreenAreas.get(string);
    }

    void removeHostedApp(AppUIController appUIController) {
        Iterator iterator = appUIController.usedScreenAreas.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            String string = (String)map$Entry.getKey();
            String string2 = (String)map$Entry.getValue();
            this.linkHostedAppToScreenArea(string, string2, null);
        }
    }

    void setUsedScreenAreaId(String string, String string2) {
        this.usedScreenAreas.put(string, string2);
    }

    void setModelApiDownEventHandler(ModelApiDownEventHandler modelApiDownEventHandler) {
        this.modelApiDownEventService.setModelApiDownEventHandler(modelApiDownEventHandler);
    }

    private String[] append(String[] stringArray, String string) {
        String[] stringArray2 = new String[stringArray.length + 1];
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            stringArray2[i2] = stringArray[i2];
        }
        stringArray2[i2] = string;
        return stringArray2;
    }

    private AppUIController$HostedAppLink getLinkedHostedApp(String string) {
        return (AppUIController$HostedAppLink)this.linkedHostedApps.get(string);
    }

    private String[] getPathForLayerLabel(String string) {
        return (String[])this.appLayer2ScreenAreaPath.get(string);
    }

    private boolean isProvidedScreenAreaVisible(String string) {
        return this.visibleProvidedScreenAreas.contains(string);
    }

    private void setPathForProvidedScreenArea(String string, String string2) {
        String[] stringArray = this.getPathForLayerLabel(string);
        this.providedScreenAreaPaths.put(string2, this.append(stringArray, string2));
    }

    static /* synthetic */ AppContext access$000(AppUIController appUIController) {
        return appUIController.appContext;
    }

    static /* synthetic */ Logger access$100(AppUIController appUIController) {
        return appUIController.logger;
    }
}

