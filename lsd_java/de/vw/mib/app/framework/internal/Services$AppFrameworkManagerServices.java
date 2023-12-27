/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.framework.internal.AppAdapterManager;
import de.vw.mib.app.framework.internal.AppDiagManager;
import de.vw.mib.app.framework.internal.AppLifecycleManager;
import de.vw.mib.app.framework.internal.AppVisibilityManager;
import de.vw.mib.app.framework.internal.EsamRuleEngine;
import de.vw.mib.app.framework.internal.Services$AppFrameworkServices;
import de.vw.mib.app.framework.internal.Services$CioFrameworkServices;
import de.vw.mib.app.framework.internal.Services$CommonFrameworkServices;
import de.vw.mib.app.framework.internal.Services$ConfigurationDataServices;
import de.vw.mib.app.framework.internal.Services$EventDispatcherServices;

final class Services$AppFrameworkManagerServices {
    private final AppAdapterManager appAdapterManager;
    private final AppDiagManager appDiagManager;
    private final AppLifecycleManager appLifecycleManager;
    private final AppVisibilityManager appVisibilityManager;
    private final EsamRuleEngine esamRuleEngine;

    Services$AppFrameworkManagerServices(Services$AppFrameworkServices services$AppFrameworkServices, Services$CioFrameworkServices services$CioFrameworkServices, Services$CommonFrameworkServices services$CommonFrameworkServices, Services$ConfigurationDataServices services$ConfigurationDataServices, Services$EventDispatcherServices services$EventDispatcherServices) {
        this.appAdapterManager = new AppAdapterManager(services$AppFrameworkServices, services$CommonFrameworkServices);
        this.appVisibilityManager = new AppVisibilityManager(services$AppFrameworkServices, services$CioFrameworkServices, services$ConfigurationDataServices, services$CommonFrameworkServices, services$EventDispatcherServices);
        this.appLifecycleManager = new AppLifecycleManager(this, services$AppFrameworkServices, services$CioFrameworkServices, services$CommonFrameworkServices, services$ConfigurationDataServices, services$EventDispatcherServices, this.appVisibilityManager);
        this.esamRuleEngine = new EsamRuleEngine(services$CommonFrameworkServices.getLogger(), services$ConfigurationDataServices.getEsamDefinitionDataService(), services$CioFrameworkServices.getCioDispatcher());
        this.appDiagManager = new AppDiagManager(this.esamRuleEngine);
    }

    AppAdapterManager getAppAdapterManager() {
        return this.appAdapterManager;
    }

    AppDiagManager getAppDiagManager() {
        return this.appDiagManager;
    }

    AppLifecycleManager getAppLifecycleManager() {
        return this.appLifecycleManager;
    }

    AppVisibilityManager getAppVisibilityManager() {
        return this.appVisibilityManager;
    }

    EsamRuleEngine getEsamRuleEngine() {
        return this.esamRuleEngine;
    }
}

