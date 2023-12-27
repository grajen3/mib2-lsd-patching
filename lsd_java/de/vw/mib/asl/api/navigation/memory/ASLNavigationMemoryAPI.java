/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.memory;

import de.vw.mib.asl.api.navigation.IASLNavigationInternalServiceFirst;
import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.memory.IEntriesResultListener;
import de.vw.mib.asl.api.navigation.memory.IListResultListener;
import de.vw.mib.asl.api.navigation.memory.ITbmResultListener;
import de.vw.mib.asl.api.navigation.memory.IUpdateListener;
import org.dsi.ifc.navigation.TryBestMatchData;

public interface ASLNavigationMemoryAPI
extends IASLNavigationInternalServiceFirst {
    public static final int RESULT_OK;
    public static final int RESULT_ERROR;
    public static final int ASL_NAVIGATION_INTERNAL_MEMORY_FIRST;
    public static final int ASL_NAVIGATION_INTERNAL_MEMORY_GET_LIST_BLOCK;
    public static final int ASL_NAVIGATION_INTERNAL_MEMORY_GET_LIST_BLOCK_LISTENER_P0;
    public static final int ASL_NAVIGATION_INTERNAL_MEMORY_GET_LIST_BLOCK_VIEWTYPE_P1;
    public static final int ASL_NAVIGATION_INTERNAL_MEMORY_GET_LIST_BLOCK_OFFSET_P2;
    public static final int ASL_NAVIGATION_INTERNAL_MEMORY_GET_LIST_BLOCK_COUNT_P3;

    default public void setDestinationDetails(ILocationWrapper iLocationWrapper, String string) {
    }

    default public void importContactSummary(int n, int n2, int n3, int n4) {
    }

    default public void getOrganizerListBlock(IListResultListener iListResultListener, int n, int n2, int n3, Object object) {
    }

    default public void getOrganizerEntries(IEntriesResultListener iEntriesResultListener, long[] lArray, int n, Object object) {
    }

    default public void tryBestMatch(ITbmResultListener iTbmResultListener, TryBestMatchData tryBestMatchData, Object object) {
    }

    default public void registerUpdateListener(IUpdateListener iUpdateListener) {
    }

    default public void unregisterUpdateListener(IUpdateListener iUpdateListener) {
    }
}

