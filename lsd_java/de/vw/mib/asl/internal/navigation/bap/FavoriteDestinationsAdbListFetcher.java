/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.bap;

import de.vw.mib.asl.api.navbap.ASLNavBAPFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.bap.BapAdbListFetcher;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.organizer.AdbViewSize;
import org.dsi.ifc.organizer.DSIAdbList;
import org.dsi.ifc.organizer.DataSet;

public class FavoriteDestinationsAdbListFetcher
extends BapAdbListFetcher {
    private static final int WIDNOW_SIZE;

    public FavoriteDestinationsAdbListFetcher(DSIAdbList dSIAdbList, int n) {
        super(dSIAdbList, n);
        ASLNavBAPFactory.getNavBAPApi().favoriteDestinationInit(this, 20);
    }

    public void configureAdbList() {
    }

    public void dsiAdbListGetViewWindowResult(int n, DataSet[] dataSetArray, int n2) {
        ASLNavBAPFactory.getNavBAPApi().favoriteDestinationUpdate(n, dataSetArray, n2);
    }

    public void dsiAdbListUpdateViewSize(AdbViewSize adbViewSize, int n) {
        GenericASLList genericASLList = ListManager.getGenericASLList(740);
        if (adbViewSize.publicTopDestinations != genericASLList.getItemCount()) {
            genericASLList.setSize(adbViewSize.publicTopDestinations);
        } else {
            genericASLList.refetch(0, genericASLList.getItemCount());
        }
    }

    public void dsiAdbListInvalidData(int n) {
        GenericASLList genericASLList = ListManager.getGenericASLList(740);
        genericASLList.setSize(0);
        genericASLList.setSize(1);
    }

    public void dsiAdbListSetListStyleResult(int n) {
        if (n == 0) {
            this.getLogger().trace("Configuring FavoriteDestinations succeeded.");
        } else {
            this.getLogger().trace("Configuring FavoriteDestinations failed.");
        }
    }
}

