/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.event;

import de.vw.mib.widgets.View;
import de.vw.mib.widgets.event.ViewChangedListener;

public abstract class ViewAdapter
implements ViewChangedListener {
    protected ViewAdapter() {
    }

    @Override
    public void viewCovered() {
    }

    @Override
    public void viewUncovered() {
    }

    public void viewSwitched(boolean bl) {
    }

    @Override
    public void viewInited(View view) {
    }

    @Override
    public void viewEntered(View view) {
    }

    @Override
    public void viewLeft(View view) {
    }
}

