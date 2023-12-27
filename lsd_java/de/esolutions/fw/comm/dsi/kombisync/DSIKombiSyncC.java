/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync;

import org.dsi.ifc.kombisync.MMIDisplayRequest;
import org.dsi.ifc.kombisync.MMIDisplayStatus;
import org.dsi.ifc.kombisync.MMIPopupRequest;
import org.dsi.ifc.kombisync.MenuState;

public interface DSIKombiSyncC {
    default public void setMMIDisplayStatus(MMIDisplayStatus mMIDisplayStatus) {
    }

    default public void setMMIDisplayRequest(MMIDisplayRequest mMIDisplayRequest) {
    }

    default public void setMenuState(MenuState menuState) {
    }

    default public void setMMIPopupRequest(MMIPopupRequest mMIPopupRequest) {
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

