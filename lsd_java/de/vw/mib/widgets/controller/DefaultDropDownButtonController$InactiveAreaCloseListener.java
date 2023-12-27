/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.DefaultDropDownButtonController;
import de.vw.mib.widgets.event.OutEventAdapter;

final class DefaultDropDownButtonController$InactiveAreaCloseListener
extends OutEventAdapter {
    private final /* synthetic */ DefaultDropDownButtonController this$0;

    public DefaultDropDownButtonController$InactiveAreaCloseListener(DefaultDropDownButtonController defaultDropDownButtonController) {
        this.this$0 = defaultDropDownButtonController;
    }

    @Override
    public void outHMIEventFired(String string) {
        this.this$0.fire_closeDropDown();
    }
}

