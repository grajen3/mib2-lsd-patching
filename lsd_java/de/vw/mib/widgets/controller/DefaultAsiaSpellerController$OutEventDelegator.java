/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.DefaultAsiaSpellerController;
import de.vw.mib.widgets.event.OutEventAdapter;

final class DefaultAsiaSpellerController$OutEventDelegator
extends OutEventAdapter {
    private final /* synthetic */ DefaultAsiaSpellerController this$0;

    public DefaultAsiaSpellerController$OutEventDelegator(DefaultAsiaSpellerController defaultAsiaSpellerController) {
        this.this$0 = defaultAsiaSpellerController;
    }

    @Override
    public void outHMIEventFired(String string) {
        this.this$0.fireHMIEvent(string);
    }

    @Override
    public void outIntegerEventFired(String string, int n) {
        this.this$0.fireIntegerEvent(string, n);
    }

    @Override
    public void outSpellerEventFired(String string, String string2, int n, int n2, int n3) {
        this.this$0.fireSpellerEvent(string, string2, n, n2, n3);
    }

    @Override
    public void outStringEventFired(String string, String string2) {
        this.this$0.fireStringEvent(string, string2);
    }
}

