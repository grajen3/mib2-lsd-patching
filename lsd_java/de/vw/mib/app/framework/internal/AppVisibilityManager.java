/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.desktop.ContentManager;
import de.vw.mib.app.desktop.ContentProcessor;
import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.app.framework.internal.AppContext;
import de.vw.mib.app.framework.internal.AppUIController;
import de.vw.mib.app.framework.internal.AppVisibilityManager$1;
import de.vw.mib.app.framework.internal.AppVisibilityManager$ContentProvider;
import de.vw.mib.app.framework.internal.AppVisibilityManager$VisibilityGrant;
import de.vw.mib.app.framework.internal.Assembly;
import de.vw.mib.app.framework.internal.Services$AppFrameworkServices;
import de.vw.mib.app.framework.internal.Services$CioFrameworkServices;
import de.vw.mib.app.framework.internal.Services$CommonFrameworkServices;
import de.vw.mib.app.framework.internal.Services$ConfigurationDataServices;
import de.vw.mib.app.framework.internal.Services$EventDispatcherServices;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.app.framework.AppFrameworkCioFactory;
import de.vw.mib.cio.app.framework.CioIntentDefinition;
import de.vw.mib.cio.app.framework.ShowContentCio;
import de.vw.mib.cio.app.framework.ShowContentCioExecutor;
import de.vw.mib.desktop.DesktopManager;
import de.vw.mib.event.dispatcher.FrameworkEventDispatcher;
import de.vw.mib.log4mib.Logger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;

final class AppVisibilityManager
implements ContentManager,
ShowContentCioExecutor {
    final Logger logger;
    private final AppFrameworkCioFactory appFrameworkCioFactory;
    private final Assembly assembly;
    private final ContentProcessor contentProcessor;
    private final Map contentProviders;
    private final Map contents;
    private final DesktopManager desktopManager;
    private final FrameworkEventDispatcher frameworkEventDispatcher;
    private final Map visibilityGrants;

    AppVisibilityManager(Services$AppFrameworkServices services$AppFrameworkServices, Services$CioFrameworkServices services$CioFrameworkServices, Services$ConfigurationDataServices services$ConfigurationDataServices, Services$CommonFrameworkServices services$CommonFrameworkServices, Services$EventDispatcherServices services$EventDispatcherServices) {
        this.logger = services$CommonFrameworkServices.getLogger();
        this.assembly = services$ConfigurationDataServices.getAssembly();
        this.appFrameworkCioFactory = services$CioFrameworkServices.getAppFrameworkCioFactory();
        this.contentProcessor = services$AppFrameworkServices.getContentProcessor();
        this.desktopManager = services$AppFrameworkServices.getDesktopManager();
        this.frameworkEventDispatcher = services$EventDispatcherServices.getFrameworkEventDispatcher();
        this.contentProviders = new HashMap();
        this.contents = new HashMap();
        this.visibilityGrants = new HashMap();
    }

    @Override
    public void execute(ShowContentCio showContentCio) {
        String string = showContentCio.getScreenAreaId();
        String string2 = showContentCio.getContentId();
        this.contentProcessor.requestContent(string, string2);
    }

    @Override
    public void updateContent(String string, String string2) {
        if ("HMI_TRAFFIC".equals(string2)) {
            this.updateContent(string, "HMI_NAVI");
            return;
        }
        if (this.logger.isTraceEnabled(32)) {
            this.logger.trace(32).append("ContentManager - updated content: ").append(string2).append("@").append(string).log();
        }
        this.contents.put(string, string2);
        this.frameworkEventDispatcher.invoke(new AppVisibilityManager$1(this, string, string2));
    }

    void assignUsedScreenArea(AppUIController appUIController, String string, String string2) {
        String string3;
        if (this.logger.isTraceEnabled(64)) {
            this.logger.trace(64).append(appUIController).append(" - assign layer ").append(string).append(" to screen area ").append(string2).log();
        }
        if ((string3 = appUIController.getUsedScreenAreaId(string)) != null) {
            appUIController.revokeVisibility(string, new String[]{string3}, null);
        }
        appUIController.setUsedScreenAreaId(string, string2);
        AppUIController appUIController2 = appUIController.getHostAppUIController();
        if (appUIController2 == null) {
            this.replaceCurrentAppForScreenArea(string, appUIController);
        } else {
            String string4 = appUIController.getUsedScreenAreaId(string);
            appUIController2.linkHostedAppToScreenArea(string, string4, appUIController);
        }
    }

    void onUpdateContent(String string, String string2) {
        if ("NO_CONTENT".equals(string2)) {
            this.removeCurrentAppForScreenArea(string);
            return;
        }
        AppVisibilityManager$ContentProvider appVisibilityManager$ContentProvider = (AppVisibilityManager$ContentProvider)this.contentProviders.get(new StringBuffer().append(string2).append(".").append(string).toString());
        if (appVisibilityManager$ContentProvider == null) {
            this.logger.warn(32).append("no provider registered for content ").append(string2).log();
            return;
        }
        appVisibilityManager$ContentProvider.activate();
    }

    void registerContentProvider(AppContext appContext) {
        AppDefinition appDefinition = appContext.getAppDefinition();
        Map map = this.assembly.getProvidedContent(appDefinition);
        if (map == null) {
            return;
        }
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            String string;
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            String string2 = (String)map$Entry.getKey();
            String string3 = (String)map$Entry.getValue();
            String string4 = appDefinition.getAppName();
            String string5 = (String)appDefinition.getUsedScreenAreas().get(string2);
            AppVisibilityManager$ContentProvider appVisibilityManager$ContentProvider = new AppVisibilityManager$ContentProvider(this, string4, appContext.getAppUIController(), string2, string3);
            if (this.contentProviders.put(new StringBuffer().append(string3).append(".").append(string5).toString(), appVisibilityManager$ContentProvider) == null && this.logger.isTraceEnabled(32)) {
                this.logger.trace(32).append("register content provider - app: ").append(appContext.getAppDefinition().getAppName()).append(" for content ").append(string3).append("@").append(string5).log();
            }
            if (string3.equals(string = (String)this.contents.get(string5))) {
                appVisibilityManager$ContentProvider.activate();
            }
            CioIntentDefinition cioIntentDefinition = this.assembly.getShowContentCio(appDefinition, string3);
            CioExecutor cioExecutor = appContext.getAppAdapterController().getCioExecutor();
            this.registerShowContentCio(cioIntentDefinition, string3, string5, cioExecutor);
        }
    }

    void requestVisibility(AppUIController appUIController, String string) {
        if (appUIController.isVisibilityGranted(string)) {
            String string2 = appUIController.getUsedScreenAreaId(string);
            AppVisibilityManager$VisibilityGrant appVisibilityManager$VisibilityGrant = (AppVisibilityManager$VisibilityGrant)this.visibilityGrants.get(string2);
            if (appVisibilityManager$VisibilityGrant != null) {
                appVisibilityManager$VisibilityGrant.grantVisibility();
                return;
            }
            return;
        }
        AppUIController appUIController2 = appUIController.getHostAppUIController();
        if (appUIController2 == null) {
            this.replaceCurrentAppForScreenArea(string, appUIController);
        } else {
            String string3 = appUIController.getUsedScreenAreaId(string);
            appUIController2.linkHostedAppToScreenArea(string, string3, appUIController);
        }
    }

    private void registerShowContentCio(CioIntentDefinition cioIntentDefinition, String string, String string2, CioExecutor cioExecutor) {
        this.appFrameworkCioFactory.createAndRegisterShowContentCio(cioIntentDefinition, string, string2, cioExecutor, this);
    }

    private void removeCurrentAppForScreenArea(String string) {
        AppVisibilityManager$VisibilityGrant appVisibilityManager$VisibilityGrant = (AppVisibilityManager$VisibilityGrant)this.visibilityGrants.get(string);
        if (appVisibilityManager$VisibilityGrant == null) {
            return;
        }
        appVisibilityManager$VisibilityGrant.revokeVisibility();
        if (this.logger.isTraceEnabled(64)) {
            this.logger.trace(64).append("Clear screen area : ").append(string).log();
        }
        this.desktopManager.clearScreenArea(new String[]{string});
    }

    private void replaceCurrentAppForScreenArea(String string, AppUIController appUIController) {
        AppVisibilityManager$VisibilityGrant appVisibilityManager$VisibilityGrant;
        String string2 = appUIController.getUsedScreenAreaId(string);
        AppVisibilityManager$VisibilityGrant appVisibilityManager$VisibilityGrant2 = (AppVisibilityManager$VisibilityGrant)this.visibilityGrants.put(string2, appVisibilityManager$VisibilityGrant = new AppVisibilityManager$VisibilityGrant(this, string2, string, appUIController));
        if (appVisibilityManager$VisibilityGrant2 == null) {
            appVisibilityManager$VisibilityGrant.grantVisibility();
            return;
        }
        appVisibilityManager$VisibilityGrant2.revokeVisibility();
        appVisibilityManager$VisibilityGrant.grantVisibility();
    }
}

