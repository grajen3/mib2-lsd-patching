/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debuginterface.internal;

import de.vw.mib.debuginterface.ViewStackProvider;
import de.vw.mib.debuginterface.internal.Activator;
import de.vw.mib.viewmanager.DesktopDiag;
import de.vw.mib.widgets.View;

class Activator$1
implements ViewStackProvider {
    final DesktopDiag desktopDiag;
    private final /* synthetic */ Object val$service;
    private final /* synthetic */ Activator this$0;

    Activator$1(Activator activator, Object object) {
        this.this$0 = activator;
        this.val$service = object;
        this.desktopDiag = (DesktopDiag)this.val$service;
    }

    @Override
    public View[] getCurrentViewStack() {
        return this.desktopDiag.getCurrentViews();
    }
}

