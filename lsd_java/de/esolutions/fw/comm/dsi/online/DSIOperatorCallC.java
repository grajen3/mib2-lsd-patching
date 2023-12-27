/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online;

import org.dsi.ifc.online.OperatorCallData;

public interface DSIOperatorCallC {
    default public void requestOperatorCallResult(String string, int n) {
    }

    default public void requestOperatorPhoneNumber(int n, OperatorCallData operatorCallData, boolean bl) {
    }

    default public void setLanguage(String string) {
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

