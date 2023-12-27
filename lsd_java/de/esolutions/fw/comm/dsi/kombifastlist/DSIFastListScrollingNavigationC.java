/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombifastlist;

import org.dsi.ifc.kombifastlist.DataAddress;
import org.dsi.ifc.kombifastlist.DataInitials;

public interface DSIFastListScrollingNavigationC {
    default public void pushFunctionAvailabilityNavigation(int n) {
    }

    default public void pushMOSTOperationStateNavigation(int n) {
    }

    default public void responseNavBook(int n, int n2, int n3, int n4, int n5, long l, int n6, int n7, int n8, int n9, int n10, int n11, int n12) {
    }

    default public void responseNavBookArray(int n, int n2, DataAddress[] dataAddressArray) {
    }

    default public void responseGetInitialsNavigation(int n, int n2, int n3, int n4, DataInitials[] dataInitialsArray) {
    }

    default public void pushLastDestList(int n, int n2, DataAddress[] dataAddressArray) {
    }

    default public void pushUpdateFavoriteDestList(int n, int n2, DataAddress[] dataAddressArray) {
    }

    default public void pushCurrentListSizeNavigation(int n, int n2, int n3) {
    }

    default public void responseNavBookJobs(int n, int n2, int n3) {
    }

    default public void responseNotifyCurrentListSizesNavigation(boolean bl) {
    }

    default public void responseNotifyFavoriteDestList(boolean bl) {
    }

    default public void responseNotifyLastDestList(boolean bl) {
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

