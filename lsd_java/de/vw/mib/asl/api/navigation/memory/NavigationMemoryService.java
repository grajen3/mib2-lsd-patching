/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.memory;

import de.vw.mib.asl.api.navigation.INavigationListElement;
import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.memory.SetHomeAddressToCcpCallback;

public interface NavigationMemoryService {
    public static final int DOWNLOADSTATE_PENDING;
    public static final int DOWNLOADSTATE_ACTIVE_ALL;
    public static final int DOWNLOADSTATE_ACTIVE_CONTACTS_FIRST;
    public static final int DOWNLOADSTATE_ACTIVE_PICTURES;
    public static final int DOWNLOADSTATE_FINISHED_NEW_DATA;
    public static final int DOWNLOADSTATE_FINISHED_UNCHANGED;
    public static final int DOWNLOADSTATE_UNFINISHED;
    public static final int FAILUREREASON_OK;
    public static final int FAILUREREASON_ADB_FULL_ENTRIES;
    public static final int FAILUREREASON_ADB_FULL_MEM;
    public static final int FAILUREREASON_MEDIA_REMOVED;
    public static final int FAILUREREASON_MEDIA_READONLY;
    public static final int FAILUREREASON_WRONG_FORMAT;
    public static final int FAILUREREASON_DUPLICATES;
    public static final int FAILUREREASON_INVALID_LOCATION;
    public static final int FAILUREREASON_BT_LOST;
    public static final int FAILUREREASON_UNKNOWN;
    public static final int VIEWTYPE_ADB_ALL;
    public static final int VIEWTYPE_ADB_NAVI;
    public static final int VIEWTYPE_ADB_TOP_DESTINATIONS;
    public static final int VIEWTYPE_ADB_ONLINE_DESTINATION;

    default public INavigationLocation getHomeAddress() {
    }

    default public void setHomeAddress(INavigationLocation iNavigationLocation) {
    }

    default public INavigationListElement[] getLastDestinations() {
    }

    default public void getLastDestination(INavigationListElement iNavigationListElement) {
    }

    default public boolean isServiceAvailable() {
    }

    default public int getTourMemoryCapacity() {
    }

    default public void importToursFromGpx(String string) {
    }

    default public void importToursAbort() {
    }

    default public void toursAvailable(int n) {
    }

    default public void downloadError(int n) {
    }

    default public void getContacts(long[] lArray, Object object) {
    }

    default public void getContactListBlock(int n, int n2, int n3, Object object) {
    }

    default public void freeService() {
    }

    default public void setHomeAddressToCcp(SetHomeAddressToCcpCallback setHomeAddressToCcpCallback) {
    }

    default public void setHomeAddressToCcp() {
    }
}

