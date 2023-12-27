/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.bap;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.impl.ASLListItemSoftCacheImpl;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.phone.bap.BapAdbListFetcher;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.organizer.AdbViewSize;
import org.dsi.ifc.organizer.DSIAdbList;
import org.dsi.ifc.organizer.DataSet;

public class BapContactsAdbListFetcher
extends BapAdbListFetcher {
    private static final int WINDOW_SIZE;

    public BapContactsAdbListFetcher(DSIAdbList dSIAdbList, int n) {
        super(dSIAdbList, n);
        GenericASLList genericASLList = ListManager.getGenericASLList(1109);
        genericASLList.enableWindowing(new ASLListItemSoftCacheImpl(), this, 20, 1);
        genericASLList.setColumn4ObjectId(1);
        genericASLList.setFetchTimeout(0);
        this.configureAdbList();
    }

    public void configureAdbList() {
    }

    public void dsiAdbListGetViewWindowResult(int n, DataSet[] dataSetArray, int n2) {
        if (n == 0) {
            ServiceManager.aslPropertyManager.valueChangedInteger(1108, n2);
            if (!Util.isNullOrEmpty(dataSetArray)) {
                ListManager.getGenericASLList(1109).setSize(n2);
                ListManager.getGenericASLList(1109).updateListItems(dataSetArray[0].entryPosition, dataSetArray);
            } else {
                ListManager.getGenericASLList(1109).setSize(0);
            }
        }
    }

    public void dsiAdbListUpdateViewSize(AdbViewSize adbViewSize, int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(1108, adbViewSize.phone);
        GenericASLList genericASLList = ListManager.getGenericASLList(1109);
        if (adbViewSize.phone != genericASLList.getItemCount()) {
            genericASLList.setSize(adbViewSize.phone);
        } else {
            genericASLList.refetch(0, genericASLList.getItemCount());
        }
    }

    public void dsiAdbListInvalidData(int n) {
        GenericASLList genericASLList = ListManager.getGenericASLList(1109);
        genericASLList.refetch(0, genericASLList.getItemCount());
    }

    public void dsiAdbListSetListStyleResult(int n) {
        if (n == 0) {
            this.getLogger().trace("Configuring phoneBook description strings succeeded.");
        } else {
            this.getLogger().trace("Configuring phoneBook description strings failed.");
        }
    }
}

