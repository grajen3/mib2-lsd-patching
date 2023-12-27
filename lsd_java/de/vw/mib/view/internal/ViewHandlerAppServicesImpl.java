/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.datapool.AppAdapterListItemControlManager;
import de.vw.mib.event.dispatcher.ViewEventDispatcher;
import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.view.internal.ViewHandlerAppServices;

public class ViewHandlerAppServicesImpl
implements ViewHandlerAppServices {
    private final AppDefinition appDefinition;
    private final AppAdapterListItemControlManager adapterListItemControlManager;
    private final ViewEventDispatcher viewEventDispatcher;
    static /* synthetic */ Class class$de$vw$mib$app$framework$AppDefinition;
    static /* synthetic */ Class class$de$vw$mib$datapool$AppAdapterListItemControlManager;
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$ViewEventDispatcher;

    public ViewHandlerAppServicesImpl(AppDefinition appDefinition, AppAdapterListItemControlManager appAdapterListItemControlManager, ViewEventDispatcher viewEventDispatcher) {
        this.appDefinition = appDefinition;
        ViewHandlerAppServicesImpl.checkNotNull(this.appDefinition, class$de$vw$mib$app$framework$AppDefinition == null ? (class$de$vw$mib$app$framework$AppDefinition = ViewHandlerAppServicesImpl.class$("de.vw.mib.app.framework.AppDefinition")) : class$de$vw$mib$app$framework$AppDefinition);
        this.adapterListItemControlManager = appAdapterListItemControlManager;
        ViewHandlerAppServicesImpl.checkNotNull(this.adapterListItemControlManager, class$de$vw$mib$datapool$AppAdapterListItemControlManager == null ? (class$de$vw$mib$datapool$AppAdapterListItemControlManager = ViewHandlerAppServicesImpl.class$("de.vw.mib.datapool.AppAdapterListItemControlManager")) : class$de$vw$mib$datapool$AppAdapterListItemControlManager);
        this.viewEventDispatcher = viewEventDispatcher;
        ViewHandlerAppServicesImpl.checkNotNull(this.viewEventDispatcher, class$de$vw$mib$event$dispatcher$ViewEventDispatcher == null ? (class$de$vw$mib$event$dispatcher$ViewEventDispatcher = ViewHandlerAppServicesImpl.class$("de.vw.mib.event.dispatcher.ViewEventDispatcher")) : class$de$vw$mib$event$dispatcher$ViewEventDispatcher);
    }

    private static void checkNotNull(Object object, Class clazz) {
        Preconditions.checkNotNull(object, "%s service", clazz.getName());
    }

    @Override
    public AppDefinition getAppDefinition() {
        return this.appDefinition;
    }

    @Override
    public AppAdapterListItemControlManager getAppAdapterListItemControlManager() {
        return this.adapterListItemControlManager;
    }

    @Override
    public ViewEventDispatcher getViewEventDispatcher() {
        return this.viewEventDispatcher;
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

