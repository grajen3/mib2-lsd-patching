/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.DefaultDropDownButtonController;
import de.vw.mib.widgets.event.OutEventAdapter;
import de.vw.mib.widgets.models.DropDownButtonModel;
import de.vw.mib.widgets.models.DropDownModel;

final class DefaultDropDownButtonController$DropDownCloseListener
extends OutEventAdapter {
    private final /* synthetic */ DefaultDropDownButtonController this$0;

    public DefaultDropDownButtonController$DropDownCloseListener(DefaultDropDownButtonController defaultDropDownButtonController) {
        this.this$0 = defaultDropDownButtonController;
    }

    @Override
    public void outHMIEventFired(String string) {
        DropDownModel dropDownModel;
        DropDownButtonModel dropDownButtonModel = this.this$0.getDropDownButton();
        DropDownModel dropDownModel2 = dropDownModel = dropDownButtonModel != null ? dropDownButtonModel.get_dropDownRef() : null;
        if (dropDownModel != null && dropDownModel.is_closeAutomatically() && string == "released") {
            this.this$0.fire_closeDropDown();
        }
    }
}

