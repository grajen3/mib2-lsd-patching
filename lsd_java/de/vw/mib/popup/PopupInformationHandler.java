/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.popup;

public interface PopupInformationHandler {
    public static final int POPUPINFO_NO_POPUP_DISPLAYED;
    public static final int POPUPINFO_POPUP_DISPLAYED;
    public static final int POPUPINFO_POPUP_WITH_BUTTONS_DISPLAYED;

    default public void onPopupInformationChanged(int n) {
    }
}

