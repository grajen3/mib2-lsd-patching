/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.contacts;

import de.vw.mib.asl.internal.list.ASLCachedWindowList;
import de.vw.mib.asl.internal.list.ASLListElementFetcher;
import de.vw.mib.asl.internal.phone.contacts.HsmPhoneContactsHandling;
import org.dsi.ifc.organizer.DataSet;

public class PhoneSearchFetcher
implements ASLListElementFetcher {
    public static final int HANDLE_NOT_INITIALIZED;
    public static final int HANDLE_WAIT_FOR_RESPONSE_AFTER_START;
    public static int spellerHandle;
    public static int spelleredListSize;
    private final HsmPhoneContactsHandling fetcherTarget;

    public PhoneSearchFetcher(HsmPhoneContactsHandling hsmPhoneContactsHandling) {
        this.fetcherTarget = hsmPhoneContactsHandling;
    }

    @Override
    public void fetchItems(ASLCachedWindowList aSLCachedWindowList, int n, int n2) {
        if (n == 0) {
            switch (spellerHandle) {
                case -2: 
                case -1: {
                    this.fetcherTarget.dsiAdbList.getViewWindow(0L, 4, 1, n2);
                    break;
                }
                default: {
                    this.fetcherTarget.dsiAdbList.getSpellerViewWindow(spellerHandle, 0L, 4, 1, n2);
                    break;
                }
            }
        } else {
            switch (spellerHandle) {
                case -2: 
                case -1: {
                    this.fetcherTarget.dsiAdbList.getViewWindow(n, 6, 1, n2);
                    break;
                }
                default: {
                    this.fetcherTarget.dsiAdbList.getSpellerViewWindow(spellerHandle, n, 6, 1, n2);
                }
            }
        }
    }

    @Override
    public void fetchNextPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        DataSet dataSet = (DataSet)object;
        switch (spellerHandle) {
            case -2: 
            case -1: {
                this.fetcherTarget.dsiAdbList.getViewWindow(dataSet.entryId, 1, 1, n2);
                break;
            }
            default: {
                this.fetcherTarget.dsiAdbList.getSpellerViewWindow(spellerHandle, dataSet.entryId, 1, 1, n2);
            }
        }
    }

    @Override
    public void fetchPreviousPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        DataSet dataSet = (DataSet)object;
        switch (spellerHandle) {
            case -2: 
            case -1: {
                this.fetcherTarget.dsiAdbList.getViewWindow(dataSet.entryId, 2, 1, n2);
                break;
            }
            default: {
                this.fetcherTarget.dsiAdbList.getSpellerViewWindow(spellerHandle, dataSet.entryId, 2, 1, n2);
            }
        }
    }

    static {
        spellerHandle = -1;
        spelleredListSize = 0;
    }
}

