/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.memory;

import de.vw.mib.asl.api.navigation.INavigationListElement;
import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.memory.INavigationContact;
import de.vw.mib.asl.api.navigation.memory.INavigationContactListElement;
import de.vw.mib.asl.api.navigation.memory.NavigationMemoryListener;

public class NavigationMemoryListenerAdapter
implements NavigationMemoryListener {
    @Override
    public void updateLastDestinations(INavigationListElement[] iNavigationListElementArray) {
    }

    @Override
    public void getLastDestinationResult(INavigationListElement iNavigationListElement, INavigationLocation iNavigationLocation, int n) {
    }

    @Override
    public void importToursFromGpxResult(int n) {
    }

    @Override
    public void updateTourMemoryCapacity(int n) {
    }

    @Override
    public void doTourDownload() {
    }

    @Override
    public void abortTourDownload() {
    }

    @Override
    public void getContactsResult(int n, INavigationContact[] iNavigationContactArray, Object object) {
    }

    @Override
    public void getContactListBlockResult(INavigationContactListElement[] iNavigationContactListElementArray, Object object) {
    }

    @Override
    public void invalidateContactData() {
    }

    @Override
    public void updateProfileDownloadState(int n, int n2, boolean bl) {
    }

    @Override
    public void updateViewSizes(int n, int n2, int n3, int n4, boolean bl) {
    }

    @Override
    public void updateHomeAddressSetToCcpDone(boolean bl) {
    }

    @Override
    public void updateHomeAddressSetDone(boolean bl) {
    }
}

