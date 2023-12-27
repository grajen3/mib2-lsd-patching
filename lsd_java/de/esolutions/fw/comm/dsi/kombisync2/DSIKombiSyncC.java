/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync2;

import org.dsi.ifc.kombisync2.DisplayIdentification;
import org.dsi.ifc.kombisync2.DisplayRequestResponse;
import org.dsi.ifc.kombisync2.DisplayStatus;
import org.dsi.ifc.kombisync2.MenuState;
import org.dsi.ifc.kombisync2.PopupActionRequestResponse;
import org.dsi.ifc.kombisync2.PopupRegisterRequestResponse;
import org.dsi.ifc.kombisync2.PopupStatus;

public interface DSIKombiSyncC {
    default public void setMMIDisplayRequestResponse(DisplayRequestResponse displayRequestResponse) {
    }

    default public void setMMIDisplayStatus(DisplayStatus displayStatus) {
    }

    default public void setMenuState(MenuState menuState) {
    }

    default public void setMMIPopupRegisterRequest(PopupRegisterRequestResponse popupRegisterRequestResponse) {
    }

    default public void setMMIPopupActionResponse(PopupActionRequestResponse popupActionRequestResponse) {
    }

    default public void setMMIPopupStatus(PopupStatus popupStatus) {
    }

    default public void setMMIDisplayIdentification(DisplayIdentification displayIdentification) {
    }

    default public void setHMIIsReady(boolean bl) {
    }

    default public void setNotification(int[] nArray) {
    }

    default public void setNotification(int n) {
    }

    default public void setNotification() {
    }

    default public void clearNotification(int[] nArray) {
    }

    default public void clearNotification(int n) {
    }

    default public void clearNotification() {
    }

    default public void yySet(String string, String string2) {
    }
}

