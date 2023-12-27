/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal;

import de.vw.mib.view.internal.AbstractOnExternalListChangedListener;
import de.vw.mib.view.internal.AbstractViewHandler;

public class OnAppAdapterListChangedListener
extends AbstractOnExternalListChangedListener {
    private final int appAdapterListId;

    public OnAppAdapterListChangedListener(AbstractViewHandler abstractViewHandler, int n) {
        super(abstractViewHandler);
        this.appAdapterListId = n;
    }

    @Override
    protected void onExternalListChanged() {
        this.viewHandler.onAppAdapterListChanged(this.appAdapterListId);
    }
}

