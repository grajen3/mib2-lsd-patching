/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.ddp20;

import org.dsi.ifc.ddp20.DisplayRequest;
import org.dsi.ifc.ddp20.UpdateRequest;

public interface DSIDDP20C {
    default public void getDisplayStatus() {
    }

    default public void setHMIState(int n, int n2, int n3) {
    }

    default public void setNaviState(int n, int n2) {
    }

    default public void setMediaState(int n) {
    }

    default public void setPhoneState(int n, int n2, int n3) {
    }

    default public void setFrameStatus(DisplayRequest displayRequest) {
    }

    default public void setFrameUpdate(UpdateRequest updateRequest) {
    }

    default public void setManeuver(int n, short[] sArray, boolean bl) {
    }

    default public void setCompass(int n, short[] sArray, boolean bl) {
    }

    default public void setDistanceBar(int n, int n2, boolean bl, boolean bl2) {
    }

    default public void setDeviationBar(int n, int n2, boolean bl, boolean bl2) {
    }

    default public void setText(int n, int n2, String string, int n3, boolean bl) {
    }

    default public void setTextStyle(int n, int n2, int n3, int n4, boolean bl) {
    }

    default public void setColor(int n, int n2, int[] nArray, boolean bl) {
    }

    default public void setCursor(int n, int n2, int n3, int n4, int n5, boolean bl) {
    }

    default public void setTrafficSign(int n, int n2, int n3, int n4, boolean bl) {
    }

    default public void setLaneGuidanceHeader(int n, int n2, int n3, int n4, int n5, boolean bl) {
    }

    default public void setLaneGuidanceData(int n, int n2, int n3, int n4, short[] sArray, boolean bl) {
    }

    default public void setCodePage(int n) {
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

