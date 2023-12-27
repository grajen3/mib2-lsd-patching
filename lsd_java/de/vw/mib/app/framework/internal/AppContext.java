/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.AppUIGate;
import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.app.framework.internal.AppAdapterController;
import de.vw.mib.app.framework.internal.AppContext$PrivateEsamService;
import de.vw.mib.app.framework.internal.AppDiagController;
import de.vw.mib.app.framework.internal.AppLifecycleController;
import de.vw.mib.app.framework.internal.AppUIController;
import de.vw.mib.app.framework.internal.Services$AppFrameworkManagerServices;
import de.vw.mib.app.framework.internal.Services$AppFrameworkServices;
import de.vw.mib.app.framework.internal.Services$CioFrameworkServices;
import de.vw.mib.app.framework.internal.Services$CommonFrameworkServices;
import de.vw.mib.app.framework.internal.Services$ConfigurationDataServices;
import de.vw.mib.app.framework.internal.Services$EventDispatcherServices;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.util.StringBuilder;

final class AppContext {
    final AppDiagController appDiagController;
    final Logger logger;
    private final AppAdapterController appAdapterController;
    private final AppDefinition appDefintion;
    private final AppLifecycleController appLifecycleController;
    private final AppUIController appUIController;
    private final AppUIGate appUIGate;
    private final AppContext$PrivateEsamService esamService;
    private final String REPRESENTATION;

    AppContext(AppUIGate appUIGate, AppDefinition appDefinition, Services$AppFrameworkManagerServices services$AppFrameworkManagerServices, Services$AppFrameworkServices services$AppFrameworkServices, Services$CioFrameworkServices services$CioFrameworkServices, Services$CommonFrameworkServices services$CommonFrameworkServices, Services$ConfigurationDataServices services$ConfigurationDataServices, Services$EventDispatcherServices services$EventDispatcherServices) {
        this.logger = services$CommonFrameworkServices.getLogger();
        this.appUIGate = appUIGate;
        this.appDefintion = appDefinition;
        this.appDiagController = new AppDiagController(this, services$AppFrameworkManagerServices);
        this.appAdapterController = new AppAdapterController(this, services$AppFrameworkManagerServices, services$CioFrameworkServices, services$CommonFrameworkServices, services$ConfigurationDataServices, services$EventDispatcherServices);
        this.appUIController = new AppUIController(this, services$AppFrameworkManagerServices, services$AppFrameworkServices, services$CommonFrameworkServices, services$EventDispatcherServices);
        this.appLifecycleController = new AppLifecycleController(this, services$AppFrameworkManagerServices, services$CommonFrameworkServices);
        this.esamService = new AppContext$PrivateEsamService(this, services$AppFrameworkManagerServices.getEsamRuleEngine());
        this.REPRESENTATION = this.createStringRepresentation();
    }

    public String toString() {
        return this.REPRESENTATION;
    }

    AppAdapterController getAppAdapterController() {
        return this.appAdapterController;
    }

    AppDefinition getAppDefinition() {
        return this.appDefintion;
    }

    AppDiagController getAppDiagController() {
        return this.appDiagController;
    }

    AppLifecycleController getAppLifecycleController() {
        return this.appLifecycleController;
    }

    AppUIController getAppUIController() {
        return this.appUIController;
    }

    AppUIGate getAppUIGate() {
        return this.appUIGate;
    }

    AppContext$PrivateEsamService getEsamService() {
        return this.esamService;
    }

    Logger getLogger() {
        return this.logger;
    }

    boolean hasHostedApps() {
        return this.appDefintion.getHostedApps().length > 0;
    }

    private String createStringRepresentation() {
        String string = this.appDefintion.getAppName();
        String string2 = this.appDefintion.getAppInstanceName();
        StringBuilder stringBuilder = new StringBuilder("App {");
        stringBuilder.append(string);
        if (string2 != null && !string2.equals(string)) {
            stringBuilder.append(".").append(string2);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

