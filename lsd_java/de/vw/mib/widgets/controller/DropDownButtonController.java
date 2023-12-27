/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.PushButtonController;

public interface DropDownButtonController
extends PushButtonController {
    public static final String IN_OPENDROPDOWN_NAME;
    public static final String IN_CLOSEDROPDOWN_NAME;
    public static final String OUT_DROPDOWNOPENED_NAME;
    public static final String OUT_DROPDOWNCLOSED_NAME;

    default public void fire_openDropDown() {
    }

    default public void fire_closeDropDown() {
    }

    default public void fire_dropDownOpened() {
    }

    default public void fire_dropDownClosed() {
    }
}

