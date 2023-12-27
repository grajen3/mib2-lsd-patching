/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.array.asg.complete;

import de.vw.mib.bap.array.asg.complete.ASGArrayListData;
import de.vw.mib.bap.array.asg.complete.ASGArrayPendingRequests$PendigRequestEnumerator;
import de.vw.mib.bap.array.asg.complete.ASGArrayPendingRequests$PendingRequestEntry;
import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.timer.Timer;
import java.util.Iterator;
import java.util.LinkedHashMap;

class ASGArrayPendingRequests {
    public static final int PENDING_REQUEST_TYPE_INVALID;
    public static final int PENDING_REQUEST_TYPE_RELOAD;
    public static final int PENDING_REQUEST_TYPE_LOADING;
    public static final int PENDING_REQUEST_TYPE_DELETE_REQUEST;
    public static final int PENDING_REQUEST_TYPE_MODIFY_REQUEST;
    public static final int PENDING_REQUEST_TYPE_INSERT_REQUEST;
    public static final int PENDIG_REQUEST_TYPE_INSERT_ONE_ELEMENT_INDICATION;
    public static final int PENDING_REQUEST_TYPE_INSERT_INDICATION;
    public static final int PENDING_REQUEST_TYPE_MODIFY_INDICATION;
    private LinkedHashMap _pendigRequests;
    private static final int INITIAL_NUMBER_OF_REQUESTS;

    ASGArrayPendingRequests() {
    }

    public void insertPendingRequest(BAPGetArray bAPGetArray, int n, ASGArrayListData aSGArrayListData) {
        Integer n2 = new Integer(bAPGetArray.getTransactionId());
        ASGArrayPendingRequests$PendingRequestEntry aSGArrayPendingRequests$PendingRequestEntry = (ASGArrayPendingRequests$PendingRequestEntry)this.getPendingRequests().get(n2);
        if (aSGArrayPendingRequests$PendingRequestEntry != null) {
            aSGArrayPendingRequests$PendingRequestEntry.setBapGetArray(bAPGetArray);
            aSGArrayPendingRequests$PendingRequestEntry.setPendigRequestType(n);
            aSGArrayPendingRequests$PendingRequestEntry.setPendingElements(aSGArrayListData);
        } else {
            this.getPendingRequests().put(n2, new ASGArrayPendingRequests$PendingRequestEntry(bAPGetArray, n, aSGArrayListData));
        }
    }

    public void setPendigRequestTimer(int n, Timer timer) {
        ASGArrayPendingRequests$PendingRequestEntry aSGArrayPendingRequests$PendingRequestEntry = (ASGArrayPendingRequests$PendingRequestEntry)this.getPendingRequests().get(new Integer(n));
        if (aSGArrayPendingRequests$PendingRequestEntry != null) {
            aSGArrayPendingRequests$PendingRequestEntry.setTimer(timer);
        }
    }

    public int getPendingRequestType(int n) {
        ASGArrayPendingRequests$PendingRequestEntry aSGArrayPendingRequests$PendingRequestEntry = (ASGArrayPendingRequests$PendingRequestEntry)this.getPendingRequests().get(new Integer(n));
        return aSGArrayPendingRequests$PendingRequestEntry != null ? aSGArrayPendingRequests$PendingRequestEntry.getPendingRequestType() : -1;
    }

    public ASGArrayListData getPendingRequestElements(int n) {
        ASGArrayPendingRequests$PendingRequestEntry aSGArrayPendingRequests$PendingRequestEntry = (ASGArrayPendingRequests$PendingRequestEntry)this.getPendingRequests().get(new Integer(n));
        return aSGArrayPendingRequests$PendingRequestEntry != null ? aSGArrayPendingRequests$PendingRequestEntry.getPendingElements() : null;
    }

    public BAPGetArray getPendingRequest(int n) {
        ASGArrayPendingRequests$PendingRequestEntry aSGArrayPendingRequests$PendingRequestEntry = (ASGArrayPendingRequests$PendingRequestEntry)this.getPendingRequests().get(new Integer(n));
        return aSGArrayPendingRequests$PendingRequestEntry != null ? aSGArrayPendingRequests$PendingRequestEntry.getBapGetArray() : null;
    }

    public Timer getPendingRequestTimer(int n) {
        ASGArrayPendingRequests$PendingRequestEntry aSGArrayPendingRequests$PendingRequestEntry = (ASGArrayPendingRequests$PendingRequestEntry)this.getPendingRequests().get(new Integer(n));
        return aSGArrayPendingRequests$PendingRequestEntry != null ? aSGArrayPendingRequests$PendingRequestEntry.getTimer() : null;
    }

    public boolean enumerate(ASGArrayPendingRequests$PendigRequestEnumerator aSGArrayPendingRequests$PendigRequestEnumerator) {
        ASGArrayPendingRequests$PendingRequestEntry aSGArrayPendingRequests$PendingRequestEntry;
        boolean bl = false;
        Iterator iterator = this.getPendingRequests().values().iterator();
        while (iterator.hasNext() && !(bl = aSGArrayPendingRequests$PendigRequestEnumerator.enumerate((aSGArrayPendingRequests$PendingRequestEntry = (ASGArrayPendingRequests$PendingRequestEntry)iterator.next()).getBapGetArray(), aSGArrayPendingRequests$PendingRequestEntry.getPendingRequestType(), aSGArrayPendingRequests$PendingRequestEntry.getTimer()))) {
        }
        return bl;
    }

    public void deletePendingRequest(int n) {
        this.getPendingRequests().remove(new Integer(n));
    }

    public void clearAll() {
        this.getPendingRequests().clear();
    }

    public boolean existsPendingRequest(int n) {
        return this.getPendingRequests().containsKey(new Integer(n));
    }

    public int size() {
        return this.getPendingRequests().size();
    }

    private LinkedHashMap getPendingRequests() {
        if (this._pendigRequests == null) {
            this._pendigRequests = new LinkedHashMap(8);
        }
        return this._pendigRequests;
    }
}

