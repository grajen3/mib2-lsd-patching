/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal;

import de.vw.mib.list.ListItemControlListener;
import de.vw.mib.view.internal.AbstractViewHandler;

abstract class AbstractOnExternalListChangedListener
implements ListItemControlListener {
    protected final AbstractViewHandler viewHandler;

    public AbstractOnExternalListChangedListener(AbstractViewHandler abstractViewHandler) {
        this.viewHandler = abstractViewHandler;
    }

    @Override
    public void activatedIndexChanged(int n) {
    }

    @Override
    public void itemsChanged(int n, int n2) {
        this.onExternalListChanged();
    }

    @Override
    public void itemsInserted(int n, int n2, int n3) {
        this.onExternalListChanged();
    }

    @Override
    public void itemsRemoved(int n, int n2, int n3) {
        this.onExternalListChanged();
    }

    @Override
    public void listChanged(int n) {
        this.onExternalListChanged();
    }

    @Override
    public void listContentChanged() {
        this.onExternalListChanged();
    }

    @Override
    public void stringIndexChanged() {
        this.onExternalListChanged();
    }

    abstract void onExternalListChanged() {
    }
}

