/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.list;

import de.vw.mib.asl.clientapi.list.ASLClientListFetcher;
import de.vw.mib.list.HMIListData;
import de.vw.mib.list.HMIListDataManipulator;
import de.vw.mib.list.HMIListState;
import de.vw.mib.list.StringIndex;

public interface ASLClientList
extends HMIListState,
HMIListData,
HMIListDataManipulator {
    public static final int LIST_SETTING_DEFAULTS;
    public static final int LIST_SETTING_LAZY_FETCHING;

    default public StringIndex createStringIndex(int[] nArray, String[] stringArray) {
    }

    default public void disableFetching() {
    }

    default public void enableFetching(ASLClientListFetcher aSLClientListFetcher, int n, int n2) {
    }
}

