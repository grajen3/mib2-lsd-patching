/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.bap;

import de.vw.mib.asl.api.navbap.ASLNavBAPFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.bap.BapAdbListFetcher;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.organizer.AdbViewSize;
import org.dsi.ifc.organizer.DSIAdbList;
import org.dsi.ifc.organizer.DataSet;

public class BapNavBookAdbListFetcher
extends BapAdbListFetcher {
    private static final int WIDNOW_SIZE;

    public BapNavBookAdbListFetcher(DSIAdbList dSIAdbList, int n) {
        super(dSIAdbList, n);
        ASLNavBAPFactory.getNavBAPApi().navBookInit(this, 20);
    }

    public void configureAdbList() {
        this.getAdbList().setListStyle(0, 1, 3);
    }

    public void dsiAdbListGetViewWindowResult(int n, DataSet[] dataSetArray, int n2) {
        ASLNavBAPFactory.getNavBAPApi().navBookUpdate(n, dataSetArray, n2);
    }

    public void dsiAdbListUpdateViewSize(AdbViewSize adbViewSize, int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(728, adbViewSize.navi);
        GenericASLList genericASLList = ListManager.getGenericASLList(746);
        if (adbViewSize.navi != genericASLList.getItemCount()) {
            genericASLList.setSize(adbViewSize.navi);
        } else {
            genericASLList.refetch(0, genericASLList.getItemCount());
        }
    }

    public void dsiAdbListInvalidData(int n) {
        GenericASLList genericASLList = ListManager.getGenericASLList(746);
        genericASLList.refetch(0, genericASLList.getItemCount());
    }

    public void dsiAdbListSetListStyleResult(int n) {
        if (n == 0) {
            this.getLogger().trace("Configuring addressbook description strings succeeded.");
        } else {
            this.getLogger().trace("Configuring addressbook description strings failed.");
        }
    }
}

