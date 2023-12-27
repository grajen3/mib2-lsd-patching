/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.arrays;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayList;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListIdGenerator;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListWindowed$BAPArrayListDelegate;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListWindowed$WindowedAbsPosArrayListIterator;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListWindowed$WindowedArbitraryArrayListIterator;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayObjectId;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayObjectIdGenerator;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayPosIdIterator;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayRequestData;
import de.vw.mib.collections.ObjectIntMap;
import de.vw.mib.collections.ObjectIntOptHashMap;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.list.DynamicListDataListener;
import generated.de.vw.mib.asl.internal.ListManager;

public class FsgArrayListWindowed
implements DynamicListDataListener,
FsgArrayList {
    private final ASLList _aslList;
    private final FsgArrayListWindowed$BAPArrayListDelegate _delegate;
    private BAPGetArray _requestedBapGetArray;
    private FsgArrayObjectIdGenerator _objectIdGenerator;
    private FsgArrayListIdGenerator _arrayListIDGenerator;
    private static final int BAP_POS_ID_FETCHING_IN_PROGRESS;
    private static final int INVALID_INDEX;
    private static final int BAP_OBJECT_ID_MAP_CACHE_SIZE;
    private static final int BAP_OBJECT_ID_MAP_DEFAULT_SIZE;
    private IntObjectMap _bapPosObjectIdMap;
    private ObjectIntMap _objectIdBapPosMap;
    private int _modCount;

    public FsgArrayListWindowed(int n, FsgArrayListWindowed$BAPArrayListDelegate fsgArrayListWindowed$BAPArrayListDelegate) {
        this._aslList = ListManager.getASLList(n);
        this._delegate = fsgArrayListWindowed$BAPArrayListDelegate;
    }

    public void initialize() {
        this.getAslList().addDynamicListDataListener(this);
        this._stopProcessingGetArray();
    }

    public void unitialize() {
        this.getAslList().removeDynamicListDataListener(this);
        this._stopProcessingGetArray();
    }

    public void processGetArray(BAPGetArray bAPGetArray) {
        this._processGetArray(bAPGetArray);
    }

    public void stopProcessingGetArray() {
        this._stopProcessingGetArray();
    }

    public long getIdAtPos(int n) {
        return this.getAslList().getObjectIdByRowCacheOnly(n);
    }

    @Override
    public int getSize() {
        return this.getAslList().getSize();
    }

    private ASLList getAslList() {
        return this._aslList;
    }

    private FsgArrayListWindowed$BAPArrayListDelegate getDelegate() {
        return this._delegate;
    }

    private void setRequestedGetArray(BAPGetArray bAPGetArray) {
        this._requestedBapGetArray = bAPGetArray;
    }

    private BAPGetArray getRequestedGetArray() {
        return this._requestedBapGetArray;
    }

    private boolean _processGetArray(BAPGetArray bAPGetArray) {
        boolean bl;
        this._startProcessingGetArray(bAPGetArray);
        FsgArrayRequestData fsgArrayRequestData = this.getDelegate().computeArrayRequestData(this, bAPGetArray);
        if (fsgArrayRequestData.isValid() || this.getSize() == 0) {
            int[] nArray = new int[fsgArrayRequestData.getNumberOfElements()];
            if (this._fetchArrayElements(fsgArrayRequestData, nArray)) {
                this.getDelegate().getArrayAnswer(this, this.getIteratorWithRequestArrayData(fsgArrayRequestData), fsgArrayRequestData, nArray, bAPGetArray);
                this._stopProcessingGetArray();
                bl = true;
            } else {
                bl = false;
            }
        } else {
            bl = false;
        }
        return bl;
    }

    private boolean _fetchArrayElements(FsgArrayRequestData fsgArrayRequestData, int[] nArray) {
        boolean bl = this.isGenerateObjectIdsEnabled();
        FsgArrayListWindowed$WindowedAbsPosArrayListIterator fsgArrayListWindowed$WindowedAbsPosArrayListIterator = bl ? new FsgArrayListWindowed$WindowedAbsPosArrayListIterator(this.getIndexOfBapPosId(fsgArrayRequestData.getStartOfList()), fsgArrayRequestData.getNumberOfElements(), fsgArrayRequestData.getDirectionIncrement()) : new FsgArrayListWindowed$WindowedAbsPosArrayListIterator(fsgArrayRequestData);
        ASLList aSLList = this.getAslList();
        boolean bl2 = fsgArrayListWindowed$WindowedAbsPosArrayListIterator.hasNext();
        boolean bl3 = true;
        int n = 0;
        while (fsgArrayListWindowed$WindowedAbsPosArrayListIterator.hasNext()) {
            int n2 = fsgArrayListWindowed$WindowedAbsPosArrayListIterator.next();
            Object object = aSLList.getRowItem(n2);
            if (aSLList.isValidItem(object)) {
                nArray[n++] = n2;
                if (!bl) continue;
                this._generateObjectId(object, n2);
                continue;
            }
            bl3 = false;
            break;
        }
        if (bl2) {
            this.setModCount(aSLList.getModCount());
        }
        return bl3;
    }

    private void _stopProcessingGetArray() {
        this.setRequestedGetArray(null);
        this._clearCachedIdsIfNeeded();
    }

    private void _startProcessingGetArray(BAPGetArray bAPGetArray) {
        this.setRequestedGetArray(bAPGetArray);
    }

    private boolean isGetArrayRequested() {
        return this.getRequestedGetArray() != null;
    }

    private boolean _processExistingRequestIfPresent() {
        boolean bl = this.isGetArrayRequested() ? this._processGetArray(this.getRequestedGetArray()) : false;
        return bl;
    }

    public FsgArrayPosIdIterator getIteratorStartingAt(int n, boolean bl) {
        return new FsgArrayListWindowed$WindowedArbitraryArrayListIterator(this, n, bl);
    }

    private FsgArrayPosIdIterator getIteratorWithRequestArrayData(FsgArrayRequestData fsgArrayRequestData) {
        FsgArrayPosIdIterator fsgArrayPosIdIterator = this.isGenerateObjectIdsEnabled() ? new FsgArrayListWindowed$WindowedArbitraryArrayListIterator(this, fsgArrayRequestData.getStartOfList(), fsgArrayRequestData.getDirectionIncrement() > 0) : new FsgArrayListWindowed$WindowedAbsPosArrayListIterator(fsgArrayRequestData);
        return fsgArrayPosIdIterator;
    }

    public final FsgArrayObjectIdGenerator getObjectIdGenerator() {
        return this._objectIdGenerator;
    }

    public final void setObjectIdGenerator(FsgArrayObjectIdGenerator fsgArrayObjectIdGenerator) {
        this._objectIdGenerator = fsgArrayObjectIdGenerator;
    }

    @Override
    public final FsgArrayListIdGenerator getIDGenerator() {
        return this._arrayListIDGenerator;
    }

    public final void setArrayListIDGenerator(FsgArrayListIdGenerator fsgArrayListIdGenerator) {
        this._arrayListIDGenerator = fsgArrayListIdGenerator;
    }

    public int getBapPosId(FsgArrayObjectId fsgArrayObjectId) {
        return this.getObjectIdBapPosMap().get(fsgArrayObjectId);
    }

    public int getBapPosIdOrGenerate(FsgArrayObjectId fsgArrayObjectId) {
        return fsgArrayObjectId != INVALID_OBJECT_ID ? this._generateBapPosId(fsgArrayObjectId) : 0;
    }

    public FsgArrayObjectId getObjectId(int n) {
        FsgArrayObjectId fsgArrayObjectId = (FsgArrayObjectId)this.getBapPosObjectIdMap().get(n);
        return fsgArrayObjectId != null ? fsgArrayObjectId : INVALID_OBJECT_ID;
    }

    @Override
    public int getIndexOfBapPosId(int n) {
        FsgArrayObjectId fsgArrayObjectId = (FsgArrayObjectId)this.getBapPosObjectIdMap().get(n);
        Object object = fsgArrayObjectId != null ? this.getAslList().getRowItemCacheOnly(fsgArrayObjectId.getPosIndex()) : null;
        int n2 = fsgArrayObjectId != null && this.getAslList().isValidItem(object) && this.getObjectIdGenerator().compareObjectID(fsgArrayObjectId, object) ? fsgArrayObjectId.getPosIndex() : -1;
        return n2;
    }

    private boolean isGenerateObjectIdsEnabled() {
        return this.getObjectIdGenerator() != null && this.getIDGenerator() != null;
    }

    private void _clearCachedIdsIfNeeded() {
        if (this.isGenerateObjectIdsEnabled() && this.getObjectIdBapPosMap().size() > 10000) {
            this.getObjectIdBapPosMap().clear();
            this.getBapPosObjectIdMap().clear();
            this.getIDGenerator().reset();
            this.getDelegate().listCacheCleared(this);
        }
    }

    private IntObjectMap getBapPosObjectIdMap() {
        if (this._bapPosObjectIdMap == null) {
            IntObjectOptHashMap intObjectOptHashMap = new IntObjectOptHashMap(30);
            intObjectOptHashMap.setSizeWarningThreshold(10030);
            this._bapPosObjectIdMap = intObjectOptHashMap;
        }
        return this._bapPosObjectIdMap;
    }

    private ObjectIntMap getObjectIdBapPosMap() {
        if (this._objectIdBapPosMap == null) {
            ObjectIntOptHashMap objectIntOptHashMap = new ObjectIntOptHashMap(30);
            objectIntOptHashMap.setSizeWarningThreshold(10030);
            this._objectIdBapPosMap = objectIntOptHashMap;
        }
        return this._objectIdBapPosMap;
    }

    private int _generateBapPosId(FsgArrayObjectId fsgArrayObjectId) {
        int n = this.getObjectIdBapPosMap().get(fsgArrayObjectId);
        if (n == 0 || !this.getIDGenerator().isBAPPosIDValid(n, 0L)) {
            n = this.getIDGenerator().createBAPPosID(0L);
            this.getObjectIdBapPosMap().put(fsgArrayObjectId, n);
            this.getBapPosObjectIdMap().put(n, fsgArrayObjectId);
        } else {
            FsgArrayObjectId fsgArrayObjectId2 = (FsgArrayObjectId)this.getBapPosObjectIdMap().get(n);
            if (fsgArrayObjectId.getPosIndex() != -1 && fsgArrayObjectId2.getPosIndex() != fsgArrayObjectId.getPosIndex()) {
                this.getObjectIdBapPosMap().put(fsgArrayObjectId, n);
                this.getBapPosObjectIdMap().put(n, fsgArrayObjectId);
            }
        }
        return n;
    }

    private int _generateObjectId(Object object, int n) {
        FsgArrayObjectId fsgArrayObjectId = this.getObjectIdGenerator().createObjectID(object, n);
        return this._generateBapPosId(fsgArrayObjectId);
    }

    private int _bapPosIdOrfetchArrayElement(int n) {
        int n2;
        ASLList aSLList = this.getAslList();
        if (n >= 0 && aSLList.getSize() > n) {
            Object object = aSLList.getRowItem(n);
            n2 = aSLList.isValidItem(object) ? this._generateObjectId(object, n) : -1;
            this.setModCount(aSLList.getModCount());
        } else {
            n2 = 0;
        }
        return n2;
    }

    private void setModCount(int n) {
        this._modCount = n;
    }

    private int getModCount() {
        return this._modCount;
    }

    private void _updateListDelegateDependOnModCount() {
        int n = this.getAslList().getModCount();
        if (this.getModCount() != n) {
            this.getDelegate().listWasChanged(this);
            this.setModCount(n);
        }
    }

    @Override
    public void activatedIndexChanged(int n) {
    }

    @Override
    public void itemsChanged(int n, int n2) {
        this._processExistingRequestIfPresent();
        this._updateListDelegateDependOnModCount();
    }

    @Override
    public void itemsInserted(int n, int n2, int n3) {
        this.getDelegate().listWasChanged(this);
        this.setModCount(this.getAslList().getModCount());
    }

    @Override
    public void itemsRemoved(int n, int n2, int n3) {
        this.getDelegate().listWasChanged(this);
        this.setModCount(this.getAslList().getModCount());
    }

    @Override
    public void listChanged(int n) {
        this._processExistingRequestIfPresent();
        this.getDelegate().listWasChanged(this);
        this.setModCount(this.getAslList().getModCount());
    }

    @Override
    public void listContentChanged() {
        this._processExistingRequestIfPresent();
        this._updateListDelegateDependOnModCount();
    }

    @Override
    public void stringIndexChanged() {
    }

    @Override
    public int firstBAPPosID() {
        return this._bapPosIdOrfetchArrayElement(0);
    }

    @Override
    public int lastBAPPosID() {
        return this._bapPosIdOrfetchArrayElement(this.getSize() - 1);
    }

    @Override
    public int previousBapPosID(int n) {
        return this._bapPosIdOrfetchArrayElement(this.getIndexOfBapPosId(n) - 1);
    }

    @Override
    public int nextBapPosID(int n) {
        int n2 = this.getIndexOfBapPosId(n);
        return n2 != -1 ? this._bapPosIdOrfetchArrayElement(n2 + 1) : -1;
    }

    @Override
    public int nextBapPosID(int n, int n2) {
        int n3 = this.getIndexOfBapPosId(n);
        return n3 != -1 ? this._bapPosIdOrfetchArrayElement(n3 + n2) : -1;
    }

    @Override
    public int numberOfElementsInDirection(int n, boolean bl, int n2) {
        int n3 = this.getIndexOfBapPosId(n);
        int n4 = n3 != -1 && n3 < this.getSize() ? (bl ? n3 - Math.max(n3 - n2, -1) : Math.min(this.getSize() - n3, n2)) : 0;
        return n4;
    }

    @Override
    public BAPArrayElement getElement(int n) {
        throw new UnsupportedOperationException("Element can't be retrieved from a windowed list. Use a 'complete' list");
    }
}

