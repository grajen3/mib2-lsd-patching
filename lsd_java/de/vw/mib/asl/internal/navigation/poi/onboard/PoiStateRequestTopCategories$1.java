/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard;

import de.vw.mib.asl.api.navigation.INavigationListElement;
import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.memory.INavigationContact;
import de.vw.mib.asl.api.navigation.memory.INavigationContactListElement;
import de.vw.mib.asl.api.navigation.memory.NavigationMemoryListener;
import de.vw.mib.asl.api.navigation.util.INavigationLocationHelper;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateRequestTopCategories;
import org.dsi.ifc.global.NavLocation;

class PoiStateRequestTopCategories$1
implements NavigationMemoryListener {
    private final /* synthetic */ PoiStateRequestTopCategories this$0;

    PoiStateRequestTopCategories$1(PoiStateRequestTopCategories poiStateRequestTopCategories) {
        this.this$0 = poiStateRequestTopCategories;
    }

    @Override
    public void updateViewSizes(int n, int n2, int n3, int n4, boolean bl) {
    }

    @Override
    public void updateTourMemoryCapacity(int n) {
    }

    @Override
    public void updateProfileDownloadState(int n, int n2, boolean bl) {
    }

    @Override
    public void updateLastDestinations(INavigationListElement[] iNavigationListElementArray) {
    }

    @Override
    public void updateHomeAddressSetToCcpDone(boolean bl) {
    }

    @Override
    public void updateHomeAddressSetDone(boolean bl) {
    }

    @Override
    public void invalidateContactData() {
    }

    @Override
    public void importToursFromGpxResult(int n) {
    }

    @Override
    public void getLastDestinationResult(INavigationListElement iNavigationListElement, INavigationLocation iNavigationLocation, int n) {
        NavLocation navLocation = ((INavigationLocationHelper)((Object)iNavigationLocation)).getRealLocation();
        this.this$0.setCurrentLdSpeech(navLocation);
    }

    @Override
    public void getContactsResult(int n, INavigationContact[] iNavigationContactArray, Object object) {
    }

    @Override
    public void getContactListBlockResult(INavigationContactListElement[] iNavigationContactListElementArray, Object object) {
    }

    @Override
    public void doTourDownload() {
    }

    @Override
    public void abortTourDownload() {
    }
}

