/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.arrays;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.bap.array.requests.BAPStatusArray;
import de.vw.mib.bap.mqbpq.common.arrays.ArrayRequestData;
import de.vw.mib.bap.mqbpq.common.arrays.ArrayRequestData$ArrayRequestIterator;
import de.vw.mib.bap.mqbpq.common.arrays.BAPWindowedArrayList$BAPArrayListDelegate;
import de.vw.mib.list.DynamicListDataListener;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.ArrayList;

public class BAPWindowedArrayList
implements DynamicListDataListener {
    private final ASLList _aslList;
    private final BAPWindowedArrayList$BAPArrayListDelegate _delegate;
    private ArrayRequestData _arrayRequestData;
    private BAPStatusArray _requestedBapArray;

    public BAPWindowedArrayList(int n, BAPWindowedArrayList$BAPArrayListDelegate bAPArrayListDelegate) {
        this._aslList = ListManager.getASLList(n);
        this._delegate = bAPArrayListDelegate;
        this._arrayRequestData = null;
        this._requestedBapArray = null;
    }

    public void initialize() {
        this.getAslList().addDynamicListDataListener(this);
        this._stopProcessingGetArray();
    }

    public void unitialize() {
        this.getAslList().removeDynamicListDataListener(this);
        this._stopProcessingGetArray();
    }

    public void processGetArray(ArrayRequestData arrayRequestData, BAPStatusArray bAPStatusArray) {
        this._processGetArray(arrayRequestData, bAPStatusArray);
    }

    public void stopProcessingGetArray() {
        this._stopProcessingGetArray();
    }

    public long getIdAtPos(int n) {
        return this.getAslList().getObjectIdByRowCacheOnly(n);
    }

    public int getSize() {
        return this.getAslList().getSize();
    }

    private ASLList getAslList() {
        return this._aslList;
    }

    private BAPWindowedArrayList$BAPArrayListDelegate getDelegate() {
        return this._delegate;
    }

    private void setArrayRequestData(ArrayRequestData arrayRequestData) {
        this._arrayRequestData = arrayRequestData;
    }

    private ArrayRequestData getArrayRequestData() {
        return this._arrayRequestData;
    }

    private void setRequestedBapArray(BAPStatusArray bAPStatusArray) {
        this._requestedBapArray = bAPStatusArray;
    }

    private BAPStatusArray getRequestedBapArray() {
        return this._requestedBapArray;
    }

    private void _processGetArray(ArrayRequestData arrayRequestData, BAPStatusArray bAPStatusArray) {
        this._startProcessingGetArray(arrayRequestData, bAPStatusArray);
        ArrayList arrayList = new ArrayList(arrayRequestData.getNumberOfElements());
        if (this._fetchArrayElements(arrayRequestData, arrayList)) {
            this.getDelegate().getArrayAnswer(this, arrayRequestData, arrayList, bAPStatusArray);
            this._stopProcessingGetArray();
        }
    }

    private boolean _fetchArrayElements(ArrayRequestData arrayRequestData, ArrayList arrayList) {
        ArrayRequestData$ArrayRequestIterator arrayRequestData$ArrayRequestIterator = new ArrayRequestData$ArrayRequestIterator(arrayRequestData);
        ASLList aSLList = this.getAslList();
        boolean bl = true;
        while (arrayRequestData$ArrayRequestIterator.hasNext()) {
            int n = arrayRequestData$ArrayRequestIterator.next();
            Object object = aSLList.getRowItem(n);
            if (aSLList.isValidItem(object)) {
                arrayList.add(object);
                continue;
            }
            bl = false;
            break;
        }
        return bl;
    }

    private void _stopProcessingGetArray() {
        this.setArrayRequestData(null);
        this.setRequestedBapArray(null);
    }

    private void _startProcessingGetArray(ArrayRequestData arrayRequestData, BAPStatusArray bAPStatusArray) {
        this.setArrayRequestData(arrayRequestData);
        this.setRequestedBapArray(bAPStatusArray);
    }

    private boolean isGetArrayRequested() {
        return this.getArrayRequestData() != null && this.getRequestedBapArray() != null;
    }

    private void processExistingRequestIfPresent() {
        if (this.isGetArrayRequested()) {
            this._processGetArray(this.getArrayRequestData(), this.getRequestedBapArray());
        }
    }

    @Override
    public void activatedIndexChanged(int n) {
    }

    @Override
    public void itemsChanged(int n, int n2) {
        this.processExistingRequestIfPresent();
    }

    @Override
    public void itemsInserted(int n, int n2, int n3) {
        this.getDelegate().listWasChanged(this);
    }

    @Override
    public void itemsRemoved(int n, int n2, int n3) {
        this.getDelegate().listWasChanged(this);
    }

    @Override
    public void listChanged(int n) {
        this.getDelegate().listWasChanged(this);
        this.processExistingRequestIfPresent();
    }

    @Override
    public void listContentChanged() {
        this.getDelegate().listWasChanged(this);
        this.processExistingRequestIfPresent();
    }

    @Override
    public void stringIndexChanged() {
    }
}

