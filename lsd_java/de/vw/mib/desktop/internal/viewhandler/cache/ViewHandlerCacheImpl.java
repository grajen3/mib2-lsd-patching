/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.desktop.internal.viewhandler.cache;

import de.vw.mib.cache.AbstractCache$Entry;
import de.vw.mib.cache.LRUCache;
import de.vw.mib.cache.policies.MaximumObjectCountCachingPolicy;
import de.vw.mib.desktop.ViewHandlerProvider;
import de.vw.mib.desktop.internal.viewhandler.SmartViewHandler;
import de.vw.mib.desktop.internal.viewhandler.cache.ViewHandlerCache;
import de.vw.mib.viewmanager.internal.PopupViewHandler;
import de.vw.mib.viewmanager.internal.ViewHandler;
import de.vw.mib.viewmanager.internal.ViewHandlerFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ViewHandlerCacheImpl
extends LRUCache
implements ViewHandlerCache {
    private final boolean caching_enabled;
    protected ViewHandlerFactory viewHandlerFactory;
    protected HashMap permanentViewHandlers;
    protected String darkFaderIndicatorViewHandlerName;
    protected SmartViewHandler darkFaderIndicatorViewHandler;
    protected String speechIndicatorViewHandlerName;
    protected String genericPopupBackgroundViewHandlerName;
    private boolean destroyViewHandlers = false;

    public ViewHandlerCacheImpl(ViewHandlerFactory viewHandlerFactory, int n) {
        super(new MaximumObjectCountCachingPolicy(n), true);
        int n2;
        this.caching_enabled = n >= 1;
        this.viewHandlerFactory = viewHandlerFactory;
        String[] stringArray = this.viewHandlerFactory.getFastAccessibleViewHandler();
        String[] stringArray2 = this.viewHandlerFactory.getFastAccessiblePopupViewHandler();
        this.permanentViewHandlers = new HashMap();
        for (n2 = 0; n2 < stringArray.length; ++n2) {
            this.permanentViewHandlers.put(stringArray[n2], null);
        }
        for (n2 = 0; n2 < stringArray2.length; ++n2) {
            this.permanentViewHandlers.put(stringArray2[n2], null);
        }
    }

    private boolean isCachingEnabled() {
        return this.caching_enabled;
    }

    private long computeId(String string) {
        long l = 0L;
        int n = string.length() - 1;
        int n2 = 0;
        do {
            l += (long)string.charAt(n) << n2;
        } while (--n >= 0 && (n2 += 7) < 54);
        return l;
    }

    protected SmartViewHandler getViewHandler(ViewHandlerProvider viewHandlerProvider, String string, boolean bl, SmartViewHandler smartViewHandler) {
        if (!this.isCachingEnabled()) {
            ViewHandler viewHandler = bl ? this.viewHandlerFactory.createPopupViewHandler(string) : viewHandlerProvider.getViewHandler(string);
            if (viewHandler == null) {
                return null;
            }
            if (smartViewHandler == null) {
                SmartViewHandler smartViewHandler2 = new SmartViewHandler(viewHandler, string, viewHandlerProvider);
                smartViewHandler2.create();
                return smartViewHandler2;
            }
            smartViewHandler.setViewHandler(viewHandler);
            smartViewHandler.create();
            return smartViewHandler;
        }
        SmartViewHandler smartViewHandler3 = (SmartViewHandler)this.permanentViewHandlers.get(string);
        if (smartViewHandler3 != null) {
            return smartViewHandler3;
        }
        SmartViewHandler smartViewHandler4 = (SmartViewHandler)this.get(this.computeId(string));
        if (smartViewHandler4 == null) {
            ViewHandler viewHandler = bl ? this.viewHandlerFactory.createPopupViewHandler(string) : viewHandlerProvider.getViewHandler(string);
            if (viewHandler == null) {
                return null;
            }
            if (smartViewHandler == null) {
                smartViewHandler4 = new SmartViewHandler(viewHandler, string, viewHandlerProvider);
            } else {
                smartViewHandler.setViewHandler(viewHandler);
                smartViewHandler4 = smartViewHandler;
            }
            smartViewHandler4.create();
            if (this.permanentViewHandlers.containsKey(string)) {
                this.permanentViewHandlers.put(string, smartViewHandler4);
                return smartViewHandler4;
            }
            this.put(this.computeId(string), smartViewHandler4);
        } else {
            smartViewHandler4.setDestroyable(false);
        }
        return smartViewHandler4;
    }

    @Override
    public boolean isCachedViewHandler(String string) {
        return this.isCachingEnabled() && (this.permanentViewHandlers.containsKey(string) || this.get(this.computeId(string)) != null);
    }

    @Override
    public SmartViewHandler getViewHandler(ViewHandlerProvider viewHandlerProvider, String string) {
        return this.getViewHandler(viewHandlerProvider, string, false, null);
    }

    @Override
    public SmartViewHandler getPopupViewHandler(String string) {
        return this.getViewHandler(null, string, true, null);
    }

    @Override
    public void reloadViewHandler(SmartViewHandler smartViewHandler) {
        this.getViewHandler(smartViewHandler.getViewHandlerProvider(), smartViewHandler.getShortViewHandlerName(), smartViewHandler.getViewHandlerProvider() == null, smartViewHandler);
    }

    @Override
    public SmartViewHandler getDarkFaderIndicatorViewHandler() {
        if (this.darkFaderIndicatorViewHandlerName == null) {
            this.darkFaderIndicatorViewHandlerName = this.viewHandlerFactory.getDarkFaderIndicatorViewHandler();
            if (this.darkFaderIndicatorViewHandlerName == null) {
                this.darkFaderIndicatorViewHandlerName = "#DFI#";
                this.darkFaderIndicatorViewHandler = SmartViewHandler.EMPTY_SMART_VIEWHANDLER;
            } else {
                PopupViewHandler popupViewHandler = this.viewHandlerFactory.createPopupViewHandler(this.darkFaderIndicatorViewHandlerName);
                if (popupViewHandler != null) {
                    this.darkFaderIndicatorViewHandler = new SmartViewHandler(popupViewHandler, this.darkFaderIndicatorViewHandlerName, null);
                    this.darkFaderIndicatorViewHandler.create();
                } else {
                    this.darkFaderIndicatorViewHandler = SmartViewHandler.EMPTY_SMART_VIEWHANDLER;
                }
            }
        }
        return this.darkFaderIndicatorViewHandler;
    }

    @Override
    public SmartViewHandler getGenericPopupBackground() {
        if (this.genericPopupBackgroundViewHandlerName == null) {
            this.genericPopupBackgroundViewHandlerName = this.viewHandlerFactory.getPopupBackgroundViewHandler();
            if (this.genericPopupBackgroundViewHandlerName == null) {
                this.genericPopupBackgroundViewHandlerName = "#GPBG#";
                this.permanentViewHandlers.put(this.genericPopupBackgroundViewHandlerName, SmartViewHandler.EMPTY_SMART_VIEWHANDLER);
            } else {
                this.permanentViewHandlers.put(this.genericPopupBackgroundViewHandlerName, null);
            }
        }
        return this.getPopupViewHandler(this.genericPopupBackgroundViewHandlerName);
    }

    @Override
    public void clear() {
        Iterator iterator = this.permanentViewHandlers.values().iterator();
        while (iterator.hasNext()) {
            SmartViewHandler smartViewHandler = (SmartViewHandler)iterator.next();
            if (smartViewHandler == null) continue;
            smartViewHandler.setDestroyable(true);
            smartViewHandler.destroy('a');
        }
        this.permanentViewHandlers.clear();
        this.destroyViewHandlers = true;
        while (this.size() > 0) {
            this.evict();
        }
        this.destroyViewHandlers = false;
        this.darkFaderIndicatorViewHandlerName = null;
        this.darkFaderIndicatorViewHandler = null;
        this.speechIndicatorViewHandlerName = null;
        this.genericPopupBackgroundViewHandlerName = null;
    }

    @Override
    protected void evict(AbstractCache$Entry abstractCache$Entry) {
        SmartViewHandler smartViewHandler = (SmartViewHandler)abstractCache$Entry.getValue();
        if (smartViewHandler != null) {
            if (this.destroyViewHandlers) {
                smartViewHandler.setDestroyable(true);
            }
            smartViewHandler.destroy('b');
        }
        super.evict(abstractCache$Entry);
    }

    public ArrayList addDiagnostics(ArrayList arrayList) {
        return arrayList;
    }
}

