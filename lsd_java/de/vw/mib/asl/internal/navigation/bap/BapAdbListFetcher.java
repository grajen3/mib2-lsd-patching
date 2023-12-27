/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.bap;

import de.vw.mib.asl.internal.list.ASLCachedWindowList;
import de.vw.mib.asl.internal.list.ASLListElementFetcher;
import de.vw.mib.asl.internal.navigation.bap.LoggerDelegate;
import org.dsi.ifc.organizer.DSIAdbList;

public class BapAdbListFetcher
implements ASLListElementFetcher {
    private final DSIAdbList _dsiAdbList;
    private final int _adbViewType;
    private LoggerDelegate _logger;

    public BapAdbListFetcher(DSIAdbList dSIAdbList, int n) {
        this._dsiAdbList = dSIAdbList;
        this._adbViewType = n;
    }

    protected DSIAdbList getAdbList() {
        return this._dsiAdbList;
    }

    public void setLogger(LoggerDelegate loggerDelegate) {
        this._logger = loggerDelegate;
    }

    public LoggerDelegate getLogger() {
        return this._logger;
    }

    @Override
    public void fetchItems(ASLCachedWindowList aSLCachedWindowList, int n, int n2) {
        if (n == 0) {
            this._dsiAdbList.getViewWindow(0L, 4, this._adbViewType, n2);
        } else {
            this._dsiAdbList.getViewWindow(n, 6, this._adbViewType, n2);
        }
    }

    @Override
    public void fetchNextPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        this._dsiAdbList.getViewWindow(aSLCachedWindowList.getObjectId(object), 1, this._adbViewType, n2);
    }

    @Override
    public void fetchPreviousPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        this._dsiAdbList.getViewWindow(aSLCachedWindowList.getObjectId(object), 2, this._adbViewType, n2);
    }
}

