/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.desktop.internal.viewhandler;

import de.vw.mib.cache.Cacheable;
import de.vw.mib.viewmanager.internal.ViewHandler;

public class CacheableViewHandler
implements Cacheable {
    protected ViewHandler viewHandler;

    public CacheableViewHandler(ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
    }

    public ViewHandler getViewHandler() {
        return this.viewHandler;
    }

    @Override
    public int getByteSize() {
        return 1;
    }
}

