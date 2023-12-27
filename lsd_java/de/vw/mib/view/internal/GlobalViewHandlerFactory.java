/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.view.internal.GlobalViewHandlerRegister;
import de.vw.mib.viewmanager.internal.PopupViewHandler;
import de.vw.mib.viewmanager.internal.ViewHandler;
import de.vw.mib.viewmanager.internal.ViewHandlerFactory;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class GlobalViewHandlerFactory
implements ViewHandlerFactory,
GlobalViewHandlerRegister {
    private static final int SUBCLASSIFIER;
    protected static final String NO_VIEWHANDLER;
    protected static final String[] NO_VIEWHANDLERS;
    private final Logger logger;
    private final Map relayFactories = new LinkedHashMap();

    public GlobalViewHandlerFactory(LoggerFactory loggerFactory) {
        this.logger = loggerFactory.getLogger(1024);
    }

    @Override
    public final ViewHandler createViewHandler(String string) {
        throw new UnsupportedOperationException("Central ViewHandlerFactory only available for popup views.");
    }

    @Override
    public void registerRelayFactory(AppDefinition appDefinition, ViewHandlerFactory viewHandlerFactory) {
        Preconditions.checkNotNull(appDefinition, "appDefinition");
        Preconditions.checkNotNull(viewHandlerFactory, "viewHandlerFactory");
        Preconditions.checkArgument(!this.relayFactories.containsKey(appDefinition), "Can't register two factories for app instance '%s'.", appDefinition);
        this.trace(appDefinition, "register");
        this.relayFactories.put(appDefinition, viewHandlerFactory);
    }

    @Override
    public void unregisterRelayFactory(AppDefinition appDefinition) {
        Preconditions.checkNotNull(appDefinition, "appDefinition");
        Preconditions.checkArgument(this.relayFactories.containsKey(appDefinition), "Can't unregister unknown app instance '%s'.", appDefinition);
        this.relayFactories.remove(appDefinition);
        this.trace(appDefinition, "unregister");
    }

    private void trace(AppDefinition appDefinition, String string) {
        if (this.logger.isTraceEnabled(2)) {
            this.logger.trace(2).append("App {").append(appDefinition.getAppInstanceName()).append("} ").append(string).append(" local view handler factory").log();
        }
    }

    @Override
    public final PopupViewHandler createPopupViewHandler(String string) {
        Iterator iterator = this.relayFactories.values().iterator();
        while (iterator.hasNext()) {
            ViewHandlerFactory viewHandlerFactory = (ViewHandlerFactory)iterator.next();
            PopupViewHandler popupViewHandler = viewHandlerFactory.createPopupViewHandler(string);
            if (popupViewHandler == null) continue;
            return popupViewHandler;
        }
        this.logger.error(2).append("Global ViewHandlerFactory can't create popup view handler '").append(string).append("'.").log();
        return null;
    }

    @Override
    public String[] getFastAccessibleViewHandler() {
        return NO_VIEWHANDLERS;
    }

    @Override
    public String[] getFastAccessiblePopupViewHandler() {
        return NO_VIEWHANDLERS;
    }

    @Override
    public String getDarkFaderIndicatorViewHandler() {
        return NO_VIEWHANDLER;
    }

    @Override
    public String getPopupBackgroundViewHandler() {
        return NO_VIEWHANDLER;
    }

    static {
        NO_VIEWHANDLER = null;
        NO_VIEWHANDLERS = new String[0];
    }
}

