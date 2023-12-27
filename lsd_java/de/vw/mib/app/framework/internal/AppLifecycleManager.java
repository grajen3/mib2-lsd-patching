/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.AppUIGate;
import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.app.framework.AppUIGateFactory;
import de.vw.mib.app.framework.internal.AppAdapterController;
import de.vw.mib.app.framework.internal.AppContext;
import de.vw.mib.app.framework.internal.AppLifecycleController;
import de.vw.mib.app.framework.internal.AppLifecycleManager$1;
import de.vw.mib.app.framework.internal.AppUIController;
import de.vw.mib.app.framework.internal.AppVisibilityManager;
import de.vw.mib.app.framework.internal.Assembly;
import de.vw.mib.app.framework.internal.Services$AppFrameworkManagerServices;
import de.vw.mib.app.framework.internal.Services$AppFrameworkServices;
import de.vw.mib.app.framework.internal.Services$CioFrameworkServices;
import de.vw.mib.app.framework.internal.Services$CommonFrameworkServices;
import de.vw.mib.app.framework.internal.Services$ConfigurationDataServices;
import de.vw.mib.app.framework.internal.Services$EventDispatcherServices;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.app.framework.AppFrameworkCioFactory;
import de.vw.mib.cio.app.framework.AppLifecycleCio;
import de.vw.mib.cio.app.framework.AppLifecycleCioExecutor;
import de.vw.mib.cio.app.framework.CioIntentDefinition;
import de.vw.mib.event.StartupEvent;
import de.vw.mib.event.consumer.AppStartupManagerEventConsumer;
import de.vw.mib.log4mib.Logger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;

final class AppLifecycleManager
implements AppLifecycleCioExecutor,
AppStartupManagerEventConsumer {
    final Logger logger;
    private final Map appContexts;
    private final AppFrameworkCioFactory appFrameworkCioFactory;
    private final Services$AppFrameworkManagerServices appFrameworkManagerServices;
    private final Services$AppFrameworkServices appFrameworkServices;
    private final AppUIGateFactory appUIGateFactory;
    private final AppVisibilityManager appVisibilityManager;
    private final Assembly assembly;
    private final Services$CioFrameworkServices cioFrameworkServices;
    private final Services$CommonFrameworkServices commonFrameworkServices;
    private final Services$ConfigurationDataServices configurationDataServices;
    private final Services$EventDispatcherServices eventDispatcherServices;
    private final Map preInitiatilizedAppUiGates;

    AppLifecycleManager(Services$AppFrameworkManagerServices services$AppFrameworkManagerServices, Services$AppFrameworkServices services$AppFrameworkServices, Services$CioFrameworkServices services$CioFrameworkServices, Services$CommonFrameworkServices services$CommonFrameworkServices, Services$ConfigurationDataServices services$ConfigurationDataServices, Services$EventDispatcherServices services$EventDispatcherServices, AppVisibilityManager appVisibilityManager) {
        this.logger = services$CommonFrameworkServices.getLogger();
        this.assembly = services$ConfigurationDataServices.getAssembly();
        this.appFrameworkServices = services$AppFrameworkServices;
        this.cioFrameworkServices = services$CioFrameworkServices;
        this.configurationDataServices = services$ConfigurationDataServices;
        this.appFrameworkCioFactory = services$CioFrameworkServices.getAppFrameworkCioFactory();
        this.appVisibilityManager = appVisibilityManager;
        this.appFrameworkManagerServices = services$AppFrameworkManagerServices;
        this.appUIGateFactory = services$AppFrameworkServices.getAppUIGateFactory();
        this.commonFrameworkServices = services$CommonFrameworkServices;
        this.eventDispatcherServices = services$EventDispatcherServices;
        this.appContexts = new HashMap();
        this.preInitiatilizedAppUiGates = new HashMap();
    }

    @Override
    public void consumeEvent(StartupEvent startupEvent) {
        if (startupEvent.getEventId() != 10) {
            return;
        }
        this.startApps();
    }

    @Override
    public void execute(AppLifecycleCio appLifecycleCio, CioActionParameters cioActionParameters) {
        String string = appLifecycleCio.getCioIntentClass();
        if ("CreateHostedApp".equals(string)) {
            this.createLazyApp(appLifecycleCio);
        } else if ("BindHostedApp".equals(string)) {
            this.bindHostedApp(appLifecycleCio, cioActionParameters);
        } else if ("DisposeHostedApp".equals(string)) {
            this.disposeLazyApp(appLifecycleCio);
        } else if ("ClearScreenArea".equals(string)) {
            this.clearScreenArea(appLifecycleCio, cioActionParameters);
        }
    }

    void readyAppIfPossible(AppContext appContext, AppLifecycleController appLifecycleController) {
        if (this.isAppReadyNow(appContext, appLifecycleController)) {
            this.registerCioIntents(appContext);
            appLifecycleController.ready();
            this.appVisibilityManager.registerContentProvider(appContext);
        } else if (this.logger.isTraceEnabled(2)) {
            this.logger.trace(2).append(appContext).append(" - waiting for mandatory hosted apps").log();
        }
    }

    void readyHostAppsIfPossible(AppContext appContext) {
        AppDefinition[] appDefinitionArray = appContext.getAppDefinition().getHostApps();
        if (appDefinitionArray == null) {
            return;
        }
        for (int i2 = 0; i2 < appDefinitionArray.length; ++i2) {
            AppContext appContext2 = this.getAppContext(appDefinitionArray[i2]);
            if (appContext2 == null) {
                if (this.logger.isTraceEnabled(2)) {
                    this.logger.trace(2).append(appDefinitionArray[i2]).append(" - is not started yet").log();
                }
                return;
            }
            AppLifecycleController appLifecycleController = appContext2.getAppLifecycleController();
            if (this.isAppReadyNow(appContext2, appLifecycleController)) {
                this.registerCioIntents(appContext2);
                appLifecycleController.ready();
                this.appVisibilityManager.registerContentProvider(appContext2);
                if (appContext2.getAppDefinition() != this.assembly.getDesktopAppDefinition()) continue;
                this.eventDispatcherServices.getStartupEventDispatcher().createAndSubmitStartupEvent(11);
                continue;
            }
            if (appLifecycleController.getLifecycleState() == 8) {
                if (!this.logger.isTraceEnabled(2)) continue;
                this.logger.trace(2).append(appContext2).append(" - is already running").log();
                continue;
            }
            if (!this.logger.isTraceEnabled(2)) continue;
            this.logger.trace(2).append(appContext2).append(" - still waiting for mandatory hosted apps").log();
        }
    }

    AppContext startLazyApp(String string, String string2) {
        if (this.assembly == null) {
            this.logger.error(8).append("couldn't start 'lazy' app ").append(string).append("! No hmi assembly specified!").log();
            return null;
        }
        AppDefinition appDefinition = this.assembly.getLazyAppDefinition(string, string2);
        if (appDefinition == null) {
            this.logger.error(8).append("couldn't start 'lazy' app ").append(string).append("! No app definition specified!").log();
            return null;
        }
        return this.startApp(appDefinition, true);
    }

    void stopHostAppsIfNecessary(AppContext appContext) {
        if (!appContext.getAppDefinition().isMandatory()) {
            return;
        }
        AppDefinition[] appDefinitionArray = appContext.getAppDefinition().getHostApps();
        if (appDefinitionArray == null) {
            return;
        }
        for (int i2 = 0; i2 < appDefinitionArray.length; ++i2) {
            AppContext appContext2 = this.getAppContext(appDefinitionArray[i2]);
            AppLifecycleController appLifecycleController = appContext2.getAppLifecycleController();
            if (appLifecycleController.getLifecycleState() != 8) continue;
            appLifecycleController.stop();
        }
    }

    private void bindHostedApp(AppLifecycleCio appLifecycleCio, CioActionParameters cioActionParameters) {
        String string = appLifecycleCio.getAppName();
        String string2 = appLifecycleCio.getAppInstanceName();
        if (cioActionParameters == null) {
            this.logger.error(256).append("couldn't bind hosted app ").append(string).append(", ").append(string2).append("! No action parameters specified!").log();
            return;
        }
        String string3 = cioActionParameters.getString("hostAppName");
        String string4 = cioActionParameters.getString("hostAppInstanceName");
        String string5 = cioActionParameters.getString("hostAppScreenArea");
        String string6 = cioActionParameters.getString("hostedAppLayerLabel");
        AppContext appContext = this.getAppContextByName(string3, string4);
        AppContext appContext2 = this.getAppContextByName(string, string2);
        if (appContext != null && appContext2 != null) {
            AppUIController appUIController = appContext2.getAppUIController();
            appUIController.setUsedScreenAreaId(string6, string5);
            AppUIController appUIController2 = appContext.getAppUIController();
            appUIController2.linkHostedAppToScreenArea(string6, string5, appUIController);
        }
    }

    private void clearScreenArea(AppLifecycleCio appLifecycleCio, CioActionParameters cioActionParameters) {
        String string = appLifecycleCio.getAppName();
        String string2 = appLifecycleCio.getAppInstanceName();
        if (cioActionParameters == null) {
            this.logger.error(256).append("couldn't clear screen area for app ").append(string).append(", ").append(string2).append("! No action parameters specified!").log();
            return;
        }
        AppContext appContext = this.getAppContextByName(string, string2);
        String string3 = cioActionParameters.getString("screenArea");
        appContext.getAppUIController().clearScreenArea(string3);
    }

    private AppContext createAppContext(AppUIGate appUIGate, AppDefinition appDefinition) {
        AppContext appContext = new AppContext(appUIGate, appDefinition, this.appFrameworkManagerServices, this.appFrameworkServices, this.cioFrameworkServices, this.commonFrameworkServices, this.configurationDataServices, this.eventDispatcherServices);
        this.appContexts.put(appDefinition, appContext);
        return appContext;
    }

    private void createLazyApp(AppLifecycleCio appLifecycleCio) {
        String string;
        String string2 = appLifecycleCio.getAppName();
        AppDefinition appDefinition = this.assembly.getLazyAppDefinition(string2, string = appLifecycleCio.getAppInstanceName());
        if (appDefinition == null) {
            this.logger.error(8).append("couldn't start 'lazy' app ").append(string2).append("! No app definition specified!").log();
            return;
        }
        AppContext appContext = this.startApp(appDefinition, true);
        if (appContext == null) {
            return;
        }
        CioExecutor cioExecutor = appContext.getAppAdapterController().getCioExecutor();
        CioIntentDefinition cioIntentDefinition = this.assembly.getAppLifecycleCio(appDefinition, "BindHostedApp");
        this.appFrameworkCioFactory.createAndRegisterAppLifecycleCio(cioIntentDefinition, cioExecutor, this);
        CioIntentDefinition cioIntentDefinition2 = this.assembly.getAppLifecycleCio(appDefinition, "DisposeHostedApp");
        this.appFrameworkCioFactory.createAndRegisterAppLifecycleCio(cioIntentDefinition2, cioExecutor, this);
    }

    private void disposeLazyApp(AppLifecycleCio appLifecycleCio) {
        String string;
        String string2 = appLifecycleCio.getAppName();
        AppDefinition appDefinition = this.assembly.getLazyAppDefinition(string2, string = appLifecycleCio.getAppInstanceName());
        AppContext appContext = this.getAppContext(appDefinition);
        AppUIController appUIController = appContext.getAppUIController();
        AppUIController appUIController2 = appUIController.getHostAppUIController();
        if (appUIController2 != null) {
            appUIController2.removeHostedApp(appUIController);
        }
        this.unregisterCioIntents(appContext);
        CioIntentDefinition cioIntentDefinition = this.assembly.getAppLifecycleCio(appDefinition, "BindHostedApp");
        this.appFrameworkCioFactory.unregisterCio(cioIntentDefinition);
        CioIntentDefinition cioIntentDefinition2 = this.assembly.getAppLifecycleCio(appDefinition, "DisposeHostedApp");
        this.appFrameworkCioFactory.unregisterCio(cioIntentDefinition2);
        this.stopApp(appContext);
    }

    private AppContext getAppContext(AppDefinition appDefinition) {
        return (AppContext)this.appContexts.get(appDefinition);
    }

    private AppContext getAppContextByName(String string, String string2) {
        AppDefinition appDefinition = this.assembly.getAppDefinition(string, string2);
        return this.getAppContext(appDefinition);
    }

    private boolean isAppReadyNow(AppContext appContext, AppLifecycleController appLifecycleController) {
        if (appContext == null) {
            return false;
        }
        if (appLifecycleController.getLifecycleState() == 8) {
            return false;
        }
        if (!appContext.hasHostedApps()) {
            return true;
        }
        AppDefinition[] appDefinitionArray = appContext.getAppDefinition().getHostedApps();
        for (int i2 = 0; i2 < appDefinitionArray.length; ++i2) {
            AppDefinition appDefinition = appDefinitionArray[i2];
            if (!appDefinition.isMandatory()) continue;
            AppContext appContext2 = this.getAppContext(appDefinition);
            if (appContext2 == null) {
                return false;
            }
            AppLifecycleController appLifecycleController2 = appContext2.getAppLifecycleController();
            if (appLifecycleController2.getLifecycleState() == 8) continue;
            return false;
        }
        return true;
    }

    private void registerCreateLazyAppsCioIntents() {
        Collection collection = this.assembly.getLazyAppDefinitions();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            AppDefinition appDefinition = (AppDefinition)iterator.next();
            AppUIGate appUIGate = this.appUIGateFactory.createApp(appDefinition);
            this.preInitiatilizedAppUiGates.put(appDefinition, appUIGate);
            CioIntentDefinition cioIntentDefinition = this.assembly.getAppLifecycleCio(appDefinition, "CreateHostedApp");
            this.appFrameworkCioFactory.createAndRegisterAppLifecycleCio(cioIntentDefinition, null, this);
        }
    }

    private void registerClearScreenAreaCioIntent(AppContext appContext) {
        AppDefinition appDefinition = appContext.getAppDefinition();
        if (appDefinition.getAppType().equals("DesktopApp")) {
            return;
        }
        if (!this.assembly.hasLazyHostedApps(appDefinition) && !appContext.hasHostedApps()) {
            return;
        }
        if (this.logger.isTraceEnabled(256)) {
            this.logger.trace(256).append(appContext).append(" - registering clear screen area cio intent ...").log();
        }
        CioExecutor cioExecutor = appContext.getAppAdapterController().getCioExecutor();
        CioIntentDefinition cioIntentDefinition = this.assembly.getAppLifecycleCio(appDefinition, "ClearScreenArea");
        this.appFrameworkCioFactory.createAndRegisterAppLifecycleCio(cioIntentDefinition, cioExecutor, this);
    }

    private void registerCioIntents(AppContext appContext) {
        if (this.logger.isTraceEnabled(256)) {
            this.logger.trace(256).append(appContext).append(" - registering cio intents ...").log();
        }
        this.registerClearScreenAreaCioIntent(appContext);
        AppDefinition appDefinition = appContext.getAppDefinition();
        CioIntentDefinition[] cioIntentDefinitionArray = appDefinition.getCioIntents();
        if (cioIntentDefinitionArray == null || cioIntentDefinitionArray.length == 0) {
            if (this.logger.isTraceEnabled(256)) {
                this.logger.warn(256).append(appContext).append(" - no cio intents specified").log();
            }
            return;
        }
        CioExecutor cioExecutor = appContext.getAppAdapterController().getCioExecutor();
        if (cioExecutor == null) {
            this.logger.warn(256).append(appContext).append(" - no cio executor provided").log();
            cioExecutor = new AppLifecycleManager$1(this, appContext);
        }
        for (int i2 = 0; i2 < cioIntentDefinitionArray.length; ++i2) {
            CioIntentDefinition cioIntentDefinition = cioIntentDefinitionArray[i2];
            int n = cioIntentDefinition.getFeatureFlagId();
            if ("BindHostedApp".equals(cioIntentDefinition.getCioIntentClassName())) {
                this.appFrameworkCioFactory.createAndRegisterAppLifecycleCio(cioIntentDefinition, cioExecutor, this);
                continue;
            }
            if ("CreateHostedApp".equals(cioIntentDefinition.getCioIntentClassName())) continue;
            if (n == -1) {
                if (this.logger.isTraceEnabled(256)) {
                    this.logger.trace(256).append(appContext).append(" - register cio intent (no feature flag specified): ").append(cioIntentDefinition).log();
                }
                this.appFrameworkCioFactory.createAndRegisterCio(cioIntentDefinition, cioExecutor);
                continue;
            }
            if (this.configurationDataServices.getConfigurationManager().isFeatureFlagSet(n)) {
                if (this.logger.isTraceEnabled(256)) {
                    this.logger.trace(256).append(appContext).append(" - register cio intent (specified feature flag is true): ").append(cioIntentDefinition).log();
                }
                this.appFrameworkCioFactory.createAndRegisterCio(cioIntentDefinition, cioExecutor);
                continue;
            }
            if (!this.logger.isTraceEnabled(256)) continue;
            this.logger.trace(256).append(appContext).append(" - don't register cio intent (specified feature flag is false): ").append(cioIntentDefinition).log();
        }
    }

    private void unregisterCioIntents(AppContext appContext) {
        AppDefinition appDefinition;
        CioIntentDefinition[] cioIntentDefinitionArray;
        if (this.logger.isTraceEnabled(256)) {
            this.logger.trace(256).append(appContext).append(" - unregistering cio intents ...").log();
        }
        if ((cioIntentDefinitionArray = (appDefinition = appContext.getAppDefinition()).getCioIntents()) == null || cioIntentDefinitionArray.length == 0) {
            return;
        }
        for (int i2 = 0; i2 < cioIntentDefinitionArray.length; ++i2) {
            CioIntentDefinition cioIntentDefinition = cioIntentDefinitionArray[i2];
            if ("CreateHostedApp".equals(cioIntentDefinition.getCioIntentClassName())) continue;
            this.appFrameworkCioFactory.unregisterCio(cioIntentDefinition);
        }
    }

    private AppContext startApp(AppDefinition appDefinition, boolean bl) {
        this.logger.normal(8).append("AppFramework - starting app: ").append(appDefinition).log();
        AppContext appContext = this.getAppContext(appDefinition);
        if (appContext != null) {
            this.startInitializedApp(appContext);
            return appContext;
        }
        AppUIGate appUIGate = (AppUIGate)this.preInitiatilizedAppUiGates.get(appDefinition);
        if (appUIGate == null) {
            appUIGate = this.appUIGateFactory.createApp(appDefinition);
        }
        if (appUIGate == null) {
            this.logger.error(8).append("Couldn't instantiate app! Factory returns null for app ").append(appDefinition.getAppName()).log();
            return null;
        }
        appContext = this.createAppContext(appUIGate, appDefinition);
        AppAdapterController appAdapterController = appContext.getAppAdapterController();
        appAdapterController.init();
        AppLifecycleController appLifecycleController = appContext.getAppLifecycleController();
        appLifecycleController.start();
        if (bl) {
            AppUIController appUIController = appContext.getAppUIController();
            AppDefinition[] appDefinitionArray = appDefinition.getHostedApps();
            for (int i2 = 0; i2 < appDefinitionArray.length; ++i2) {
                AppDefinition appDefinition2 = appDefinitionArray[i2];
                AppContext appContext2 = this.startApp(appDefinition2, true);
                if (appContext2 == null) continue;
                Iterator iterator = appDefinition2.getUsedScreenAreas().entrySet().iterator();
                while (iterator.hasNext()) {
                    Map$Entry map$Entry = (Map$Entry)iterator.next();
                    String string = (String)map$Entry.getKey();
                    String string2 = (String)map$Entry.getValue();
                    appUIController.linkHostedAppToScreenArea(string, string2, appContext2.getAppUIController());
                }
            }
        }
        return appContext;
    }

    private void startApps() {
        this.logger.normal(8, "start all apps");
        this.logger.normal(8, this.assembly.toString());
        this.logger.normal(8, "starting desktop app ...");
        AppDefinition appDefinition = this.assembly.getDesktopAppDefinition();
        this.startApp(appDefinition, false);
        this.logger.normal(8, "starting apps ...");
        AppDefinition[] appDefinitionArray = appDefinition.getHostedApps();
        for (int i2 = 0; i2 < appDefinitionArray.length; ++i2) {
            this.startApp(appDefinitionArray[i2], true);
        }
        this.registerCreateLazyAppsCioIntents();
    }

    private void startInitializedApp(AppContext appContext) {
        AppLifecycleController appLifecycleController = appContext.getAppLifecycleController();
        switch (appLifecycleController.getLifecycleState()) {
            case 1: 
            case 32: {
                appLifecycleController.start();
                break;
            }
            case 4: {
                this.readyAppIfPossible(appContext, appLifecycleController);
                this.readyHostAppsIfPossible(appContext);
                break;
            }
            default: {
                return;
            }
        }
    }

    private void stopApp(AppContext appContext) {
        appContext.getAppLifecycleController().stop();
    }
}

