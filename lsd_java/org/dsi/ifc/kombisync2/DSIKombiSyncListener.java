/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombisync2;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.kombisync2.DisplayIdentification;
import org.dsi.ifc.kombisync2.DisplayRequestResponse;
import org.dsi.ifc.kombisync2.DisplayStatus;
import org.dsi.ifc.kombisync2.PopupActionRequestResponse;
import org.dsi.ifc.kombisync2.PopupRegisterRequestResponse;
import org.dsi.ifc.kombisync2.PopupStatus;

public interface DSIKombiSyncListener
extends DSIListener {
    default public void updateKombiCommunicationState(boolean bl, int n) {
    }

    default public void updateKombiMessageStateDisplayIdentification(int n, int n2) {
    }

    default public void updateKombiMessageStateDisplayRequestResponse(int n, int n2) {
    }

    default public void updateKombiMessageStateDisplayStatus(int n, int n2) {
    }

    default public void updateKombiMessageStatePopupActionRequest(int n, int n2) {
    }

    default public void updateKombiMessageStatePopupRegisterResponse(int n, int n2) {
    }

    default public void updateKombiMessageStatePopupStatus(int n, int n2) {
    }

    default public void responseKombiDisplayRequestResponse(DisplayRequestResponse displayRequestResponse) {
    }

    default public void responseKombiDisplayStatus(DisplayStatus displayStatus) {
    }

    default public void responseKombiDisplayIdentification(DisplayIdentification displayIdentification) {
    }

    default public void responseKombiPopupRegisterResponse(PopupRegisterRequestResponse popupRegisterRequestResponse) {
    }

    default public void responseKombiPopupActionRequest(PopupActionRequestResponse popupActionRequestResponse) {
    }

    default public void responseKombiPopupStatus(PopupStatus popupStatus) {
    }
}

