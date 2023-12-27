/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombifastlist;

import org.dsi.ifc.kombifastlist.DataCombinedNumbers;
import org.dsi.ifc.kombifastlist.DataFavoriteList;
import org.dsi.ifc.kombifastlist.DataInitials;
import org.dsi.ifc.kombifastlist.DataPhonebook;

public interface DSIFastListScrollingTelephoneC {
    default public void pushFunctionAvailabilityTelephone(int n) {
    }

    default public void pushMOSTOperationStateTelephone(short s) {
    }

    default public void responsePhonebook(int n, int n2, int n3, int n4, int n5, long l, int n6, int n7, int n8, int n9, int n10, int n11, int n12) {
    }

    default public void responsePhonebookArray(int n, int n2, DataPhonebook[] dataPhonebookArray) {
    }

    default public void responseGetInitialsTelephone(int n, int n2, int n3, int n4, DataInitials[] dataInitialsArray) {
    }

    default public void pushupdateFavoriteList(int n, int n2, DataFavoriteList[] dataFavoriteListArray) {
    }

    default public void pushCombinedNumbers(int n, int n2, DataCombinedNumbers[] dataCombinedNumbersArray) {
    }

    default public void pushCurrentListSizeTelephone(int n, int n2, int n3) {
    }

    default public void responsePhonebookJobs(int n, int n2, int n3) {
    }

    default public void responseNotifyCombinedNumbersPush(boolean bl) {
    }

    default public void responseNotifyCurrentListSizes(boolean bl) {
    }

    default public void responseNotifyFavoriteListPush(boolean bl) {
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

