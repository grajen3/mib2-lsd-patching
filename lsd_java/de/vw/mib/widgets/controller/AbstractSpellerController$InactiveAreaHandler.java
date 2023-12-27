/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.AbstractSpellerController;
import de.vw.mib.widgets.event.OutEventAdapter;

final class AbstractSpellerController$InactiveAreaHandler
extends OutEventAdapter {
    private final /* synthetic */ AbstractSpellerController this$0;

    public AbstractSpellerController$InactiveAreaHandler(AbstractSpellerController abstractSpellerController) {
        this.this$0 = abstractSpellerController;
    }

    @Override
    public void outHMIEventFired(String string) {
        this.this$0.closeSubSpeller();
    }
}

