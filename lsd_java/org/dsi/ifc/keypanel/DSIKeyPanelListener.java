/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.keypanel;

import org.dsi.ifc.base.DSIListener;

public interface DSIKeyPanelListener
extends DSIListener {
    default public void updateKey2(int n, int n2, int n3, int n4, int n5) {
    }

    default public void updateEncoder2(int n, int n2, int n3, int n4, int n5) {
    }

    default public void updateDisplayTurnMechStatus(int n, int n2) {
    }

    default public void updateRecognizerLanguage2(int n, String string, int n2, int n3) {
    }

    default public void updateRecognizerMode(int n, int n2, int n3) {
    }

    default public void updateCharacterEvent2(int n, String[] stringArray, int[] nArray, int n2) {
    }

    default public void updateGesture2(int n, int n2, int n3, boolean bl, int n4, int n5, int n6, int n7, int n8, int n9) {
    }

    default public void genericSettingResponse(int n, int n2, int n3) {
    }

    default public void updateProximity(int n, int n2, int n3) {
    }

    default public void updateAdvancedProximity(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
    }

    default public void lastKey(int n, int n2, int n3) {
    }

    default public void updateKeyboardType(int n, int n2) {
    }

    default public void updateTouchSensitiveArea(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    default public void getVersionInfo(int n, int n2, String string) {
    }

    default public void updateInputPanelReady(int n, int n2, int n3) {
    }

    default public void getProperty(int n, int n2, int n3, int n4, byte[] byArray) {
    }
}

