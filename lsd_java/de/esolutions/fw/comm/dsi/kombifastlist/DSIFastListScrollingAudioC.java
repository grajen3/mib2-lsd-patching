/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombifastlist;

import org.dsi.ifc.kombifastlist.DataCommonList;
import org.dsi.ifc.kombifastlist.DataMediaBrowser;
import org.dsi.ifc.kombifastlist.DataReceptionList;

public interface DSIFastListScrollingAudioC {
    default public void pushFunctionAvailabilityAudio(int n) {
    }

    default public void pushMOSTOperationStateAudio(int n) {
    }

    default public void responseMediaBrowser(int n, int n2, int n3, int n4, int n5, int n6, int n7, long l, int n8, long l2, long l3, int n9, int n10, int n11) {
    }

    default public void responseMediaBrowserArray(long l, int n, DataMediaBrowser[] dataMediaBrowserArray) {
    }

    default public void pushCommonList(long l, int n, DataCommonList[] dataCommonListArray) {
    }

    default public void pushReceptionList(long l, int n, DataReceptionList[] dataReceptionListArray) {
    }

    default public void pushCurrentListSizeAudio(int n, int n2, int n3) {
    }

    default public void responseMediaBrowserJobs(long l, int n, int n2) {
    }

    default public void responseNotifyCommonListPush(boolean bl) {
    }

    default public void responseNotifyCurrentListSizeAudio(boolean bl) {
    }

    default public void responseNotifyReceptionList(boolean bl) {
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

