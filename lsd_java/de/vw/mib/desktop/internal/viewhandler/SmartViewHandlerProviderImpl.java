/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.desktop.internal.viewhandler;

import de.vw.mib.desktop.ViewHandlerProvider;
import de.vw.mib.desktop.internal.common.ServiceManager;
import de.vw.mib.desktop.internal.viewhandler.SmartViewHandler;
import de.vw.mib.desktop.internal.viewhandler.SmartViewHandlerProvider;
import de.vw.mib.desktop.internal.viewhandler.cache.ViewHandlerCache;
import de.vw.mib.log4mib.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map$Entry;

public class SmartViewHandlerProviderImpl
implements SmartViewHandlerProvider {
    private final ViewHandlerCache viewHandlerCache;
    private final HashMap views;
    protected final Logger logger;

    public SmartViewHandlerProviderImpl(ViewHandlerCache viewHandlerCache) {
        this.viewHandlerCache = viewHandlerCache;
        this.views = new HashMap();
        this.logger = ServiceManager.loggerFactory.getLogger(1024);
    }

    @Override
    public SmartViewHandler getViewHandler(ViewHandlerProvider viewHandlerProvider, String string, boolean bl) {
        SmartViewHandler smartViewHandler = (SmartViewHandler)this.views.get(string);
        if (bl) {
            if (smartViewHandler == null) {
                smartViewHandler = this.viewHandlerCache.getViewHandler(viewHandlerProvider, string);
                this.views.put(string, smartViewHandler);
            }
            smartViewHandler.setDestroyable(false);
        }
        return smartViewHandler;
    }

    @Override
    public SmartViewHandler getPopupViewHandler(String string) {
        SmartViewHandler smartViewHandler = (SmartViewHandler)this.views.get(string);
        if (smartViewHandler == null) {
            smartViewHandler = this.viewHandlerCache.getPopupViewHandler(string);
            this.views.put(string, smartViewHandler);
        }
        smartViewHandler.setDestroyable(false);
        return smartViewHandler;
    }

    @Override
    public void reloadViewHandler(SmartViewHandler smartViewHandler) {
        this.viewHandlerCache.reloadViewHandler(smartViewHandler);
        this.views.put(smartViewHandler.getShortViewHandlerName(), smartViewHandler);
        smartViewHandler.setDestroyable(false);
    }

    @Override
    public SmartViewHandler getDarkFaderIndicatorViewHandler() {
        SmartViewHandler smartViewHandler = this.viewHandlerCache.getDarkFaderIndicatorViewHandler();
        this.views.put(smartViewHandler.getShortViewHandlerName(), smartViewHandler);
        return smartViewHandler;
    }

    @Override
    public SmartViewHandler getPopupBackgroundViewHandler() {
        SmartViewHandler smartViewHandler = this.viewHandlerCache.getGenericPopupBackground();
        this.views.put(smartViewHandler.getShortViewHandlerName(), smartViewHandler);
        return smartViewHandler;
    }

    @Override
    public void free(String string) {
        SmartViewHandler smartViewHandler = (SmartViewHandler)this.views.get(string);
        if (smartViewHandler == null) {
            if (this.logger.isTraceEnabled(2)) {
                this.logger.trace(2, new StringBuffer().append("Trying to free an unused viewHandler ('").append(string).append("')!").toString());
            }
        } else {
            smartViewHandler.setDestroyable(true);
            if (!this.viewHandlerCache.isCachedViewHandler(string)) {
                smartViewHandler.destroy('d');
            }
            this.views.remove(string);
        }
    }

    @Override
    public void clear() {
        Iterator iterator = this.views.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            String string = (String)map$Entry.getKey();
            if (this.viewHandlerCache.isCachedViewHandler(string)) continue;
            SmartViewHandler smartViewHandler = (SmartViewHandler)map$Entry.getValue();
            smartViewHandler.setDestroyable(true);
            smartViewHandler.destroy('c');
        }
        this.views.clear();
        this.viewHandlerCache.clear();
    }

    @Override
    public ArrayList addDiagnostics(ArrayList arrayList) {
        return arrayList;
    }

    @Override
    public String getGuideName(String string) {
        SmartViewHandler smartViewHandler = (SmartViewHandler)this.views.get(string);
        if (smartViewHandler == null) {
            return "<???>";
        }
        return smartViewHandler.getName();
    }
}

