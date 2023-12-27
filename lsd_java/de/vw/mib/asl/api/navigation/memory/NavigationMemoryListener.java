/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.memory;

import de.vw.mib.asl.api.navigation.INavigationListElement;
import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.memory.INavigationContact;
import de.vw.mib.asl.api.navigation.memory.INavigationContactListElement;

public interface NavigationMemoryListener {
    default public void updateLastDestinations(INavigationListElement[] iNavigationListElementArray) {
    }

    default public void getLastDestinationResult(INavigationListElement iNavigationListElement, INavigationLocation iNavigationLocation, int n) {
    }

    default public void importToursFromGpxResult(int n) {
    }

    default public void updateTourMemoryCapacity(int n) {
    }

    default public void doTourDownload() {
    }

    default public void abortTourDownload() {
    }

    default public void getContactsResult(int n, INavigationContact[] iNavigationContactArray, Object object) {
    }

    default public void getContactListBlockResult(INavigationContactListElement[] iNavigationContactListElementArray, Object object) {
    }

    default public void updateProfileDownloadState(int n, int n2, boolean bl) {
    }

    default public void invalidateContactData() {
    }

    default public void updateViewSizes(int n, int n2, int n3, int n4, boolean bl) {
    }

    default public void updateHomeAddressSetToCcpDone(boolean bl) {
    }

    default public void updateHomeAddressSetDone(boolean bl) {
    }
}

