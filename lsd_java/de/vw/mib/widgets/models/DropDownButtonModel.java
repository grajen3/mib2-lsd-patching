/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.widgets.models.ButtonModel;
import de.vw.mib.widgets.models.DropDownModel;
import de.vw.mib.widgets.models.InactiveAreaModel;

public interface DropDownButtonModel
extends ButtonModel {
    public static final int PID_BASE;
    public static final int PID_DROP_DOWN_REF;
    public static final int PID_DROP_DOWN_EXISTENCE_FLAGS;
    public static final int PID_INACTIVE_AREA_REF;
    public static final int PID_OPEN_DROP_DOWN;
    public static final int PID_COUNT_DROP_DOWN_BUTTON;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_COUNT_DROPDOWNBUTTON;
    public static final int SID_BASE;
    public static final int SID_OPEN_DROPDOWN;
    public static final int SID_COUNT_DROPDOWN_BUTTON;

    default public DropDownModel get_dropDownRef() {
    }

    default public void set_dropDownRef(DropDownModel dropDownModel) {
    }

    default public InactiveAreaModel get_inactiveAreaRef() {
    }

    default public void set_inactiveAreaRef(InactiveAreaModel inactiveAreaModel) {
    }

    default public void set_dropDownExistenceFlags(boolean[] blArray) {
    }

    default public boolean[] get_dropDownExistenceFlags() {
    }

    default public boolean is_openDropDown() {
    }

    default public void set_openDropDown(boolean bl) {
    }
}

