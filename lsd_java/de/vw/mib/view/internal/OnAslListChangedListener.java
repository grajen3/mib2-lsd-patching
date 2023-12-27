/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal;

import de.vw.mib.view.internal.AbstractOnExternalListChangedListener;
import de.vw.mib.view.internal.AbstractViewHandler;

public class OnAslListChangedListener
extends AbstractOnExternalListChangedListener {
    private final int publicAslListId;

    public OnAslListChangedListener(AbstractViewHandler abstractViewHandler, int n) {
        super(abstractViewHandler);
        this.publicAslListId = n;
    }

    @Override
    protected void onExternalListChanged() {
        this.viewHandler.onAslListChanged(this.publicAslListId);
    }
}

