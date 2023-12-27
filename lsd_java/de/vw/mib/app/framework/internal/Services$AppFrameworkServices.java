/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.appadapter.proxy.ModelApiProxyFactory;
import de.vw.mib.app.desktop.ContentProcessor;
import de.vw.mib.app.framework.AppUIGateFactory;
import de.vw.mib.app.framework.internal.DesktopManagerProxy;
import de.vw.mib.app.framework.internal.Services$EventDispatcherServices;
import de.vw.mib.desktop.DesktopManager;

final class Services$AppFrameworkServices {
    private final AppUIGateFactory appUIGateFactory;
    private final ContentProcessor contentProcessor;
    private final DesktopManager desktopManager;
    private final ModelApiProxyFactory modelApiProxyFactory;

    Services$AppFrameworkServices(AppUIGateFactory appUIGateFactory, ContentProcessor contentProcessor, DesktopManager desktopManager, ModelApiProxyFactory modelApiProxyFactory, Services$EventDispatcherServices services$EventDispatcherServices) {
        this.appUIGateFactory = appUIGateFactory;
        this.contentProcessor = contentProcessor;
        this.desktopManager = new DesktopManagerProxy(desktopManager, services$EventDispatcherServices.getStatemachineEventDispatcher());
        this.modelApiProxyFactory = modelApiProxyFactory;
    }

    AppUIGateFactory getAppUIGateFactory() {
        return this.appUIGateFactory;
    }

    ContentProcessor getContentProcessor() {
        return this.contentProcessor;
    }

    DesktopManager getDesktopManager() {
        return this.desktopManager;
    }

    ModelApiProxyFactory getModelApiProxyFactory() {
        return this.modelApiProxyFactory;
    }
}

