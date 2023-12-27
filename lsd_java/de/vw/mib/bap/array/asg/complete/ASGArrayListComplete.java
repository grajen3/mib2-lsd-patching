/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.array.asg.complete;

import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.asg.ASGArrayListChangeNotifier;
import de.vw.mib.bap.array.asg.ASGArrayListDelegate;
import de.vw.mib.bap.array.asg.ASGArrayListFactory;
import de.vw.mib.bap.array.asg.complete.ASGArrayListComplete$1;
import de.vw.mib.bap.array.asg.complete.ASGArrayListComplete$2;
import de.vw.mib.bap.array.asg.complete.ASGArrayListComplete$3;
import de.vw.mib.bap.array.asg.complete.ASGArrayListComplete$TimerUserInfo;
import de.vw.mib.bap.array.asg.complete.ASGArrayListData;
import de.vw.mib.bap.array.asg.complete.ASGArrayPendingRequests;
import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.requests.BAPSetGetArray;
import de.vw.mib.bap.array.requests.BAPStatusArray;
import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayDataList;
import de.vw.mib.bap.datatypes.BAPArrayElement;

class ASGArrayListComplete
implements ASGArrayList,
TimerNotifier {
    private static final int TRANSACTION_ID_MIN;
    private static final int TRANSACTION_ID_MAX;
    private static final int MAX_ELEMENTS_8_BIT_INDEX_SIZE;
    private static final int MINIMUM_ELEMENTS_FOR_BLOCK_CHANGE;
    private static final int POS_OFFSET;
    private final int _asgId;
    private final int _listId;
    private int _bapArrayListSize;
    private ASGArrayListDelegate _delegate;
    private ASGArrayListChangeNotifier _changeNotifier;
    private ASGArrayListFactory _factory;
    private int _highLevelRetryType;
    private int _highLevelRetryNumberOfRetries;
    private long _highLevelRetryTime;
    private boolean _loading;
    private int _transactionId;
    private boolean _loadingError;
    private ASGArrayPendingRequests _pendingRequests;
    private ASGArrayListData _arrayListData;
    static /* synthetic */ Class class$de$vw$mib$bap$array$requests$BAPSetGetArray;

    ASGArrayListComplete(int n, int n2) {
        this._asgId = n;
        this._listId = n2;
        this._transactionId = 1;
        this._highLevelRetryType = 0;
        this._highLevelRetryNumberOfRetries = 2;
        this._highLevelRetryTime = 0;
    }

    @Override
    public void changedArray(BAPChangedArray bAPChangedArray) {
        boolean bl;
        if (bAPChangedArray.getArrayHeader().isElementChangedRequest() || bAPChangedArray.getArrayHeader().isElementsChangedBlockRequest()) {
            this._logTrace("Received element changed request");
            bl = !this._processChangedElementsIndication(bAPChangedArray);
        } else if (bAPChangedArray.getArrayHeader().isElementInsertedRequest() || bAPChangedArray.getArrayHeader().isElementsInsertedBlockRequest()) {
            this._logTrace("Received element insert request");
            if (this.getBapArrayListSize() == 0) {
                this._logTrace("List is empty, can't process insert");
                bl = true;
            } else {
                bl = !this._processInsertElementsIndication(bAPChangedArray);
            }
        } else if (bAPChangedArray.getArrayHeader().isElementsDeleteRangeRequest()) {
            this._logTrace("Received element delete request (range)");
            bl = !this._processDeleteRangeElementsIndication(bAPChangedArray);
        } else if (bAPChangedArray.getArrayHeader().isElementsDeleteBlockRequest()) {
            this._logTrace("Received delete block elements request");
            bl = !this._processDeleteBlockElementsIndication(bAPChangedArray);
        } else if (bAPChangedArray.getArrayHeader().isFullRangeUpdate()) {
            this._logTrace("Received full range update. Reload array");
            this.stopFetchingData();
            this.reloadData();
            bl = false;
        } else {
            this._logError("Received change array with wrong parameters");
            bl = true;
        }
        if (bl) {
            this._logWarning("Fallback to full-range-update");
            this.reloadData();
        }
    }

    @Override
    public void statusArray(BAPStatusArray bAPStatusArray) {
        if (this._checkPendigRequestAnswerParametersForHighLevelRetry(bAPStatusArray)) {
            int n = bAPStatusArray.getTransactionId();
            this._recomputePosWithinStatusArray(bAPStatusArray);
            ASGArrayListData aSGArrayListData = this.getPendingRequests().getPendingRequestElements(bAPStatusArray.getTransactionId());
            BAPGetArray bAPGetArray = this.getPendingRequests().getPendingRequest(bAPStatusArray.getTransactionId());
            int n2 = this.getPendingRequests().getPendingRequestType(n);
            this.getPendingRequests().deletePendingRequest(n);
            switch (n2) {
                case 0: {
                    this._logTrace("Received PENDING_REQUEST_TYPE_RELOAD");
                    this._pendingReloadRequest(bAPStatusArray);
                    break;
                }
                case 1: {
                    this._logTrace("Received PENDING_REQUEST_TYPE_LOADING");
                    this._pendingLoadRequest(bAPStatusArray);
                    break;
                }
                case 7: {
                    this._logTrace("Received PENDING_REQUEST_TYPE_MODIFY_INDICATION");
                    this._pendingChangeRequest(bAPStatusArray, aSGArrayListData);
                    break;
                }
                case 5: {
                    this._logTrace("Received PENDIG_REQUEST_TYPE_INSERT_ONE_ELEMENT_INDICATION");
                    this._peningInsertOneElementIndication(bAPStatusArray);
                    break;
                }
                case 6: {
                    this._logTrace("Received PENDING_REQUEST_TYPE_INSERT_INDICATION");
                    this._pendingInsertElementsIndication(bAPStatusArray, bAPGetArray, aSGArrayListData);
                    break;
                }
                case 2: {
                    this._logTrace("Received PENDING_REQUEST_TYPE_DELETE_REQUEST");
                    this._pendingDeleteRequest(bAPStatusArray);
                    break;
                }
                case 3: {
                    this._logTrace("Received PENDING_REQUEST_TYPE_MODIFY_REQUEST");
                    this._pendingModifyRequest(bAPStatusArray);
                    break;
                }
                case 4: {
                    this._logTrace("Received PENDING_REQUEST_TYPE_INSERT_REQUEST");
                    this._pendingInsertRequest(bAPStatusArray);
                    break;
                }
                default: {
                    this._logError("Not handled pending type for status array.");
                    break;
                }
            }
        } else if (this.isLoadingError() && this.size() == 0) {
            this._logWarning("Received StatusArray after error. Fallback to full-range update");
            this.reloadData();
        } else if (bAPStatusArray.isBroadcast()) {
            this._logTrace("Received Broadcast StatusArray message");
            this._processBroadcastStatusArrayIndication(bAPStatusArray);
        } else {
            this._logWarning("Reject StatusArray, whitout previous request");
        }
    }

    @Override
    public void error(int n) {
        this._logError(new StringBuffer().append("Received error = ").append(n).toString());
        this._errorOccurredCheckHighLevelRetry(n);
    }

    @Override
    public void insertArrayElements(BAPArrayDataList bAPArrayDataList, int n, int n2) {
        BAPSetGetArray bAPSetGetArray = this._createSetGetArrayRequest(-1, bAPArrayDataList.size(), 2);
        bAPSetGetArray.getArrayHeader().setRecordAddress(n);
        int n3 = bAPArrayDataList.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            BAPArrayElement bAPArrayElement = bAPArrayDataList.get(i2);
            bAPArrayElement.setArrayHeader(bAPSetGetArray.getArrayHeader());
            bAPSetGetArray.getArrayData().add(bAPArrayElement);
        }
        this._sendRequest(bAPSetGetArray, 4, null);
    }

    @Override
    public void deleteArrayElements(BAPArrayDataList bAPArrayDataList, int n) {
        BAPSetGetArray bAPSetGetArray = this._createSetGetArrayRequest(bAPArrayDataList.getFirst().getPos(), bAPArrayDataList.size(), 3);
        bAPSetGetArray.getArrayHeader().setRecordAddress(n);
        int n2 = bAPArrayDataList.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            BAPArrayElement bAPArrayElement = this.getFactory().createEmptyElement(this);
            bAPArrayElement.setPos(bAPArrayDataList.get(i2).getPos());
            bAPArrayElement.setArrayHeader(bAPSetGetArray.getArrayHeader());
            bAPSetGetArray.getArrayData().add(bAPArrayElement);
        }
        this._sendRequest(bAPSetGetArray, 2, null);
    }

    private void modifyArrayElements(BAPArrayDataList bAPArrayDataList, int n) {
        BAPSetGetArray bAPSetGetArray = this._createSetGetArrayRequest(bAPArrayDataList.getFirst().getPos(), bAPArrayDataList.size(), 1);
        bAPSetGetArray.getArrayHeader().setRecordAddress(n);
        int n2 = bAPArrayDataList.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            BAPArrayElement bAPArrayElement = bAPArrayDataList.get(i2);
            bAPArrayElement.setArrayHeader(bAPSetGetArray.getArrayHeader());
            bAPSetGetArray.getArrayData().add(bAPArrayDataList.get(i2));
        }
        this._sendRequest(bAPSetGetArray, 3, null);
    }

    @Override
    public void modifyArrayElement(BAPArrayElement bAPArrayElement, int n) {
        BAPArrayData bAPArrayData = new BAPArrayData(2);
        bAPArrayData.add(bAPArrayElement);
        this.modifyArrayElements(bAPArrayData, n);
    }

    @Override
    public void reloadData() {
        this._logTrace("Start reloading data");
        this.stopFetchingData();
        this.setLoading(true);
        int n = this.getDelegate().getDefaultRecordAddress(this);
        BAPGetArray bAPGetArray = this._createGetArrayRequest(0, this.getDelegate().getMaxRequestableElements(this, n), n, false);
        this._sendRequest(bAPGetArray, 0, null);
        this.setLoadingError(false);
        this.getChangeNotifier().reloaded(this);
    }

    @Override
    public void refreshElements(BAPArrayElement bAPArrayElement, int n, int n2) {
        BAPGetArray bAPGetArray = this._createGetArrayRequest(bAPArrayElement.getPos(), this._maxRequestableElements(n2, n), n2, false);
        ASGArrayListData aSGArrayListData = new ASGArrayListData(this.getArrayListData().getElements(this.getArrayListData().indexOf(bAPArrayElement), n));
        this._sendRequest(bAPGetArray, 7, aSGArrayListData);
    }

    @Override
    public void stopFetchingData() {
        this._logTrace("Stopped fetching data");
        this.getPendingRequests().enumerate(new ASGArrayListComplete$1(this));
        this.getPendingRequests().clearAll();
        this.setLoading(false);
    }

    @Override
    public void clearList() {
        this.stopFetchingData();
        this.getArrayListData().clearAll();
        this.setBapArrayListSize(0);
        this.getChangeNotifier().reloaded(this);
    }

    @Override
    public boolean isLoading() {
        return this._loading;
    }

    @Override
    public boolean isLoadingError() {
        return this._loadingError;
    }

    private void setLoadingError(boolean bl) {
        this._loadingError = bl;
    }

    @Override
    public boolean isModifyRequestPending() {
        return this.getPendingRequests().enumerate(new ASGArrayListComplete$2(this));
    }

    private void setLoading(boolean bl) {
        this._loading = bl;
    }

    @Override
    public int getListId() {
        return this._listId;
    }

    @Override
    public int getAsgId() {
        return this._asgId;
    }

    @Override
    public int size() {
        return this.getArrayListData().size();
    }

    @Override
    public int getBapArrayListSize() {
        return this._bapArrayListSize;
    }

    private void setBapArrayListSize(int n) {
        this._bapArrayListSize = n;
    }

    @Override
    public int getHighLevelRetryType() {
        return this._highLevelRetryType;
    }

    void setHighLevelRetryType(int n) {
        this._highLevelRetryType = n;
    }

    void setHighLevelRetryNumberOfRetries(int n) {
        this._highLevelRetryNumberOfRetries = n;
    }

    private int getHighLevelRetryNumberOfRetries() {
        return this._highLevelRetryNumberOfRetries;
    }

    void setHighLevelRetryTime(long l) {
        this._highLevelRetryTime = l;
    }

    private long getHighLevelRetryTime() {
        return this._highLevelRetryTime;
    }

    @Override
    public BAPArrayElement get(int n) {
        return this.getArrayListData().get(n);
    }

    @Override
    public BAPArrayDataList getElements(int n, int n2) {
        return this.getArrayListData().getElements(n, n2);
    }

    @Override
    public BAPArrayDataList getAllElements() {
        return this.getArrayListData().toArrayDataList();
    }

    @Override
    public ASGArrayListDelegate getDelegate() {
        return this._delegate;
    }

    void setDelegate(ASGArrayListDelegate aSGArrayListDelegate) {
        this._delegate = aSGArrayListDelegate;
    }

    @Override
    public ASGArrayListChangeNotifier getChangeNotifier() {
        return this._changeNotifier;
    }

    void setChangeNotifier(ASGArrayListChangeNotifier aSGArrayListChangeNotifier) {
        this._changeNotifier = aSGArrayListChangeNotifier;
    }

    @Override
    public ASGArrayListFactory getFactory() {
        return this._factory;
    }

    void setFactory(ASGArrayListFactory aSGArrayListFactory) {
        this._factory = aSGArrayListFactory;
    }

    private void _recomputePosWithinStatusArray(BAPStatusArray bAPStatusArray) {
        if (!bAPStatusArray.getArrayHeader().mode.arrayPositionIsTransmitted && bAPStatusArray.getArrayData().size() != 0 && bAPStatusArray.getArrayHeader().start != 0) {
            int n = bAPStatusArray.getArrayHeader().mode.arrayDirectionIsBackward ? -1 : 1;
            int n2 = bAPStatusArray.getArrayHeader().start + (bAPStatusArray.getArrayHeader().mode.shift ? n : 0);
            BAPArrayData bAPArrayData = bAPStatusArray.getArrayData();
            int n3 = bAPArrayData.size();
            for (int i2 = 0; i2 < n3; ++i2) {
                BAPArrayElement bAPArrayElement = bAPArrayData.get(i2);
                bAPArrayElement.setPos(n2 + i2 * n);
            }
        }
    }

    private int getNextTransactionId() {
        int n = this._transactionId;
        this._transactionId = this._transactionId % 15 + 1;
        return n;
    }

    private BAPGetArray _createGetArrayRequest(int n, int n2, int n3, boolean bl) {
        BAPGetArray bAPGetArray = this.getFactory().createGetArrayRequest(this);
        bAPGetArray.setAsgId(this.getAsgId());
        bAPGetArray.getArrayHeader().setRecordAddress(n3, 15);
        bAPGetArray.getArrayHeader().start = n;
        bAPGetArray.getArrayHeader().elements = n2;
        bAPGetArray.getArrayHeader().mode.indexSize16BitForStartElements = n > 255;
        bAPGetArray.getArrayHeader().mode.shift = bl;
        return bAPGetArray;
    }

    private BAPSetGetArray _createSetGetArrayRequest(int n, int n2, int n3) {
        BAPSetGetArray bAPSetGetArray = this.getFactory().createSetGetArrayRequest(this);
        bAPSetGetArray.setAsgId(this.getAsgId());
        bAPSetGetArray.getArrayHeader().setSetGetRequestChangeType(n3);
        bAPSetGetArray.getArrayHeader().start = n;
        bAPSetGetArray.getArrayHeader().elements = n2;
        bAPSetGetArray.getArrayHeader().mode.indexSize16BitForStartElements = n > 255;
        bAPSetGetArray.getArrayHeader().mode.shift = false;
        bAPSetGetArray.getArrayHeader().mode.arrayPositionIsTransmitted = n2 > 1;
        return bAPSetGetArray;
    }

    private int _maxRequestableElements(int n, int n2) {
        int n3 = this.getDelegate().getMaxRequestableElements(this, n);
        return n2 > n3 ? n3 : n2;
    }

    private void _transmitRequest(BAPGetArray bAPGetArray, int n, ASGArrayListData aSGArrayListData) {
        this.getDelegate().requestGetArray(this, bAPGetArray);
        this.getPendingRequests().insertPendingRequest(bAPGetArray, n, aSGArrayListData);
        this._startHighLevelRetryTimerForSendRequest(bAPGetArray);
    }

    private void _sendRequest(BAPGetArray bAPGetArray, int n, ASGArrayListData aSGArrayListData) {
        bAPGetArray.setTransactionId(this.getNextTransactionId());
        this._transmitRequest(bAPGetArray, n, aSGArrayListData);
    }

    private void _transmitRequest(BAPSetGetArray bAPSetGetArray, int n, ASGArrayListData aSGArrayListData) {
        this.getDelegate().requestSetGetArray(this, bAPSetGetArray);
        this.getPendingRequests().insertPendingRequest(bAPSetGetArray, n, aSGArrayListData);
        this._startHighLevelRetryTimerForSendRequest(bAPSetGetArray);
    }

    private void _sendRequest(BAPSetGetArray bAPSetGetArray, int n, ASGArrayListData aSGArrayListData) {
        bAPSetGetArray.setTransactionId(this.getNextTransactionId());
        ArrayHeader arrayHeader = bAPSetGetArray.getArrayHeader();
        this.getPendingRequests().enumerate(new ASGArrayListComplete$3(this, arrayHeader));
        this._stopHighLevelRetryTimer(bAPSetGetArray.getTransactionId());
        this._transmitRequest(bAPSetGetArray, n, aSGArrayListData);
    }

    protected static boolean _isSetGetRequest(BAPGetArray bAPGetArray) {
        Class[] classArray = super.getClass().getInterfaces();
        return classArray.length > 0 && classArray[0] == (class$de$vw$mib$bap$array$requests$BAPSetGetArray == null ? (class$de$vw$mib$bap$array$requests$BAPSetGetArray = ASGArrayListComplete.class$("de.vw.mib.bap.array.requests.BAPSetGetArray")) : class$de$vw$mib$bap$array$requests$BAPSetGetArray);
    }

    private ASGArrayPendingRequests getPendingRequests() {
        if (this._pendingRequests == null) {
            this._pendingRequests = new ASGArrayPendingRequests();
        }
        return this._pendingRequests;
    }

    private void _startHighLevelRetryTimer(BAPGetArray bAPGetArray) {
        ASGArrayListComplete$TimerUserInfo aSGArrayListComplete$TimerUserInfo;
        Timer timer = this.getPendingRequests().getPendingRequestTimer(bAPGetArray.getTransactionId());
        if (timer == null) {
            timer = this.getFactory().createTimer(this, this, this.getHighLevelRetryTime());
            this.getPendingRequests().setPendigRequestTimer(bAPGetArray.getTransactionId(), timer);
            aSGArrayListComplete$TimerUserInfo = new ASGArrayListComplete$TimerUserInfo(bAPGetArray.getTransactionId());
        } else {
            aSGArrayListComplete$TimerUserInfo = (ASGArrayListComplete$TimerUserInfo)timer.getUserInfo();
        }
        this._logTrace("Retrigger high level retry timer");
        ASGArrayListComplete.retriggerHiglLevelRetryTimer(timer, aSGArrayListComplete$TimerUserInfo);
    }

    private void _startHighLevelRetryTimerForSendRequest(BAPGetArray bAPGetArray) {
        if (this.getHighLevelRetryType() == 1) {
            this._startHighLevelRetryTimer(bAPGetArray);
        }
    }

    private void _stopHighLevelRetryTimer(int n) {
        Timer timer = this.getPendingRequests().getPendingRequestTimer(n);
        if (timer != null) {
            timer.stop();
        }
    }

    private boolean _checkPendigRequestAnswerParametersForHighLevelRetry(BAPStatusArray bAPStatusArray) {
        boolean bl;
        int n = bAPStatusArray.getTransactionId();
        boolean bl2 = this.getPendingRequests().existsPendingRequest(n);
        if (this.getHighLevelRetryType() == 0 && bl2) {
            boolean bl3 = bl = this.getAsgId() == bAPStatusArray.getAsgId();
            if (this.getAsgId() != bAPStatusArray.getAsgId() && !bAPStatusArray.isBroadcast()) {
                this._startHighLevelRetryTimer(this.getPendingRequests().getPendingRequest(n));
            }
        } else if (bl2) {
            ArrayHeader arrayHeader = this.getPendingRequests().getPendingRequest(n).getArrayHeader();
            ArrayHeader arrayHeader2 = bAPStatusArray.getArrayHeader();
            boolean bl4 = this.getPendingRequests().getPendingRequestType(n) == 4;
            bl = this.getAsgId() == bAPStatusArray.getAsgId() && arrayHeader.mode.shift == arrayHeader2.mode.shift && arrayHeader.mode.arrayDirectionIsBackward == arrayHeader2.mode.arrayDirectionIsBackward && (bl4 || arrayHeader.start == arrayHeader2.start);
        } else {
            bl = false;
        }
        if (bl) {
            this._stopHighLevelRetryTimer(n);
        }
        return bl;
    }

    private void _errorOccurredCheckHighLevelRetry(int n) {
        switch (n) {
            case -4: 
            case -3: 
            case -2: 
            case -1: {
                this.setLoadingError(true);
                this.clearList();
                break;
            }
            default: {
                this._logError(new StringBuffer().append("Unknown error received, errorCode = ").append(n).toString());
            }
        }
    }

    @Override
    public void timerFired(Timer timer) {
        boolean bl;
        this._logWarning("High level retry time out");
        ASGArrayListComplete$TimerUserInfo aSGArrayListComplete$TimerUserInfo = (ASGArrayListComplete$TimerUserInfo)timer.getUserInfo();
        if (aSGArrayListComplete$TimerUserInfo.getCounter() > this.getHighLevelRetryNumberOfRetries()) {
            this._logWarning("Give up HIGH level retry");
            this.getPendingRequests().deletePendingRequest(aSGArrayListComplete$TimerUserInfo.getTransactionId());
            bl = true;
            this.setLoadingError(true);
        } else {
            this._logWarning("Repeat request");
            BAPGetArray bAPGetArray = this.getPendingRequests().getPendingRequest(aSGArrayListComplete$TimerUserInfo.getTransactionId());
            int n = this.getPendingRequests().getPendingRequestType(aSGArrayListComplete$TimerUserInfo.getTransactionId());
            ASGArrayListData aSGArrayListData = this.getPendingRequests().getPendingRequestElements(aSGArrayListComplete$TimerUserInfo.getTransactionId());
            if (ASGArrayListComplete._isSetGetRequest(bAPGetArray)) {
                this._transmitRequest((BAPSetGetArray)bAPGetArray, n, aSGArrayListData);
            } else {
                this._transmitRequest(bAPGetArray, n, aSGArrayListData);
            }
            bl = false;
        }
        this.getDelegate().requestTimeout(this, aSGArrayListComplete$TimerUserInfo.getCounter(), bl);
        if (bl) {
            this.clearList();
        }
    }

    private static void retriggerHiglLevelRetryTimer(Timer timer, ASGArrayListComplete$TimerUserInfo aSGArrayListComplete$TimerUserInfo) {
        if (!timer.isRunning()) {
            aSGArrayListComplete$TimerUserInfo.incrementCounter();
            timer.retrigger(aSGArrayListComplete$TimerUserInfo);
        }
    }

    private ASGArrayListData getArrayListData() {
        if (this._arrayListData == null) {
            this._arrayListData = new ASGArrayListData();
        }
        return this._arrayListData;
    }

    private void _resetWithArrayElements(BAPArrayData bAPArrayData, int n) {
        this.getArrayListData().reset(bAPArrayData.getElements(0, Math.min(bAPArrayData.size(), n)));
    }

    private boolean _processChangedElementsIndication(BAPChangedArray bAPChangedArray) {
        boolean bl;
        if (bAPChangedArray.getArrayHeader().isElementChangedRequest()) {
            if (this.getArrayListData().contains(bAPChangedArray.getArrayHeader().start)) {
                BAPGetArray bAPGetArray = this._createGetArrayRequest(bAPChangedArray.getArrayHeader().start, this._maxRequestableElements(bAPChangedArray.getArrayHeader().getRecordAddress(), bAPChangedArray.getArrayHeader().elements), bAPChangedArray.getArrayHeader().getRecordAddress(), false);
                ASGArrayListData aSGArrayListData = new ASGArrayListData(this.getArrayListData().getElements(this.getArrayListData().indexOf(bAPGetArray.getArrayHeader().start), bAPChangedArray.getArrayHeader().elements));
                this._sendRequest(bAPGetArray, 7, aSGArrayListData);
                bl = true;
            } else {
                this._logWarning("Received change array with start not existing in array.");
                bl = false;
            }
        } else if (bAPChangedArray.getArrayHeader().isElementsChangedBlockRequest()) {
            if (bAPChangedArray.getArrayData().size() >= 2 && bAPChangedArray.getArrayHeader().elements >= 2) {
                BAPGetArray bAPGetArray = this._createGetArrayRequest(bAPChangedArray.getArrayData().getFirst().getPos(), this._maxRequestableElements(bAPChangedArray.getArrayHeader().getRecordAddress(), bAPChangedArray.getArrayHeader().elements - 1), bAPChangedArray.getArrayHeader().getRecordAddress(), false);
                ASGArrayListData aSGArrayListData = new ASGArrayListData(bAPChangedArray.getArrayData().getElements(0, bAPChangedArray.getArrayHeader().elements - 1));
                this._sendRequest(bAPGetArray, 7, aSGArrayListData);
                bl = true;
            } else {
                this._logWarning("Received corrupted, change array (elements changed blocked).");
                bl = false;
            }
        } else {
            this._logWarning("Received unknown changed elements indication.");
            bl = false;
        }
        return bl;
    }

    private boolean _processInsertElementsIndication(BAPChangedArray bAPChangedArray) {
        boolean bl;
        if (bAPChangedArray.getArrayHeader().isElementInsertedRequest()) {
            if (this.getDelegate().getMaxRequestableElements(this, this.getDelegate().getDefaultRecordAddress(this)) >= 2) {
                BAPGetArray bAPGetArray = this._createGetArrayRequest(bAPChangedArray.getArrayHeader().start, 2, this.getDelegate().getDefaultRecordAddress(this), false);
                this._sendRequest(bAPGetArray, 5, null);
                bl = true;
            } else {
                this._logWarning("Can not perform a insert, because not more than one element can be requested.");
                bl = false;
            }
        } else if (bAPChangedArray.getArrayHeader().isElementsInsertedBlockRequest()) {
            if (bAPChangedArray.getArrayData().size() >= 2 && bAPChangedArray.getArrayHeader().elements >= 2) {
                if (bAPChangedArray.getArrayHeader().start == 0 || this.getArrayListData().contains(bAPChangedArray.getArrayHeader().start)) {
                    int n = this.getDelegate().getDefaultRecordAddress(this);
                    BAPGetArray bAPGetArray = this._createGetArrayRequest(bAPChangedArray.getArrayHeader().start, this._maxRequestableElements(n, bAPChangedArray.getArrayHeader().elements - 1), n, bAPChangedArray.getArrayHeader().start != 0);
                    ASGArrayListData aSGArrayListData = new ASGArrayListData(bAPChangedArray.getArrayData().getElements(0, bAPChangedArray.getArrayHeader().elements - 1));
                    this._sendRequest(bAPGetArray, 6, aSGArrayListData);
                    bl = true;
                } else {
                    this._logWarning("Can't process the changed array insert indication, because the predecessor of inserted element in start, does not exists.");
                    bl = false;
                }
            } else {
                this._logWarning("Ignore change array (data insert) because of not enough existing pos elements provided.");
                bl = false;
            }
        } else {
            this._logError("Received uknown insert changed array indication");
            bl = false;
        }
        return bl;
    }

    private boolean _processDeleteRangeElementsIndication(BAPChangedArray bAPChangedArray) {
        boolean bl;
        if (bAPChangedArray.getArrayHeader().start <= this.getArrayListData().size() && bAPChangedArray.getArrayHeader().start > 0 && bAPChangedArray.getArrayHeader().elements > 0) {
            BAPArrayDataList bAPArrayDataList = this.getElements(bAPChangedArray.getArrayHeader().start - 1, bAPChangedArray.getArrayHeader().elements);
            this.getArrayListData().deleteElements(bAPChangedArray.getArrayHeader().start - 1, bAPArrayDataList.size());
            if (bAPChangedArray.getArrayHeader().elements != bAPArrayDataList.size()) {
                this._logError("Not all elements could be deleted (range) for received request");
            }
            this.getChangeNotifier().elementsDeleted(this, bAPChangedArray.getArrayHeader().start - 1, bAPArrayDataList);
            bl = true;
        } else {
            this._logError("Ingnore delete (range) request, because start is not in the list");
            bl = false;
        }
        return bl;
    }

    private boolean _processDeleteBlockElementsIndication(BAPChangedArray bAPChangedArray) {
        return this._deleteArrayElements(bAPChangedArray.getArrayHeader().start, bAPChangedArray.getArrayData());
    }

    private boolean _deleteArrayElements(int n, BAPArrayData bAPArrayData) {
        boolean bl;
        int n2 = this.getArrayListData().indexOf(n);
        if (n2 != -1) {
            ASGArrayListData aSGArrayListData = this.getArrayListData();
            BAPArrayData bAPArrayData2 = new BAPArrayData(bAPArrayData.maxSize());
            int n3 = bAPArrayData.size();
            for (int i2 = 0; i2 < n3; ++i2) {
                BAPArrayElement bAPArrayElement = bAPArrayData.get(i2);
                int n4 = aSGArrayListData.indexOf(bAPArrayElement);
                if (n4 != -1) {
                    aSGArrayListData.deleteElement(n4);
                    bAPArrayData2.add(bAPArrayElement);
                    continue;
                }
                this._logError("Deleting one element (block) failed");
            }
            if (bAPArrayData2.size() != 0) {
                this.getChangeNotifier().elementsDeleted(this, aSGArrayListData.indexOf(bAPArrayData2.getFirst()), bAPArrayData2);
                bl = true;
            } else {
                this._logError("Can't delete (block) elements, because the given array is empty or contains invalid pos elements");
                bl = false;
            }
        } else {
            this._logError("Can't delete elements, because they can not be found in current list.");
            bl = false;
        }
        return bl;
    }

    private void _loadLeftArrayElements(BAPStatusArray bAPStatusArray) {
        this.setBapArrayListSize(bAPStatusArray.getNumberOfElements());
        if (this.getDelegate().continueLoading(this) && this.getBapArrayListSize() > this.getArrayListData().size()) {
            int n = this.getDelegate().getDefaultRecordAddress(this);
            int n2 = Math.min(this.getBapArrayListSize() - this.getArrayListData().size(), this.getDelegate().getMaxRequestableElements(this, n));
            BAPGetArray bAPGetArray = this._createGetArrayRequest(this.getArrayListData().getLast().getPos(), n2, n, true);
            this._sendRequest(bAPGetArray, 1, null);
            this._logTrace("Continue loading of BAP elements");
        } else {
            this.setLoading(false);
            this._logTrace("Loading of BAP array finished");
        }
    }

    private void _pendingReloadRequest(BAPStatusArray bAPStatusArray) {
        this._resetWithArrayElements(bAPStatusArray.getArrayData(), bAPStatusArray.getArrayHeader().getNumberOfElements());
        this._loadLeftArrayElements(bAPStatusArray);
        this.getChangeNotifier().reloaded(this);
    }

    private void _pendingLoadRequest(BAPStatusArray bAPStatusArray) {
        int n = this.getArrayListData().insertAfter(bAPStatusArray.getArrayHeader().start, bAPStatusArray.getArrayData(), bAPStatusArray.getArrayHeader().getNumberOfElements());
        this._loadLeftArrayElements(bAPStatusArray);
        if (n != -1) {
            if (this.isLoading()) {
                this.getChangeNotifier().elementsInserted(this, n, bAPStatusArray.getArrayData());
            } else {
                this.getChangeNotifier().reloaded(this);
            }
        }
    }

    private BAPArrayData _insertStatusArrayElements(BAPStatusArray bAPStatusArray, String string, ASGArrayListData aSGArrayListData) {
        BAPArrayData bAPArrayData = bAPStatusArray.getArrayData();
        ASGArrayListData aSGArrayListData2 = this.getArrayListData();
        BAPArrayData bAPArrayData2 = new BAPArrayData(bAPArrayData.maxSize());
        int n = bAPArrayData.size();
        for (int i2 = 0; i2 < n; ++i2) {
            BAPArrayElement bAPArrayElement = bAPArrayData.get(i2);
            int n2 = aSGArrayListData2.indexOf(bAPArrayElement);
            if (n2 != -1) {
                BAPArrayElement bAPArrayElement2 = this.getFactory().mergeArrayElementAttributes(this, bAPArrayElement, aSGArrayListData2.get(n2), bAPStatusArray.getArrayHeader().getRecordAddress());
                aSGArrayListData2.replace(bAPArrayElement2);
                bAPArrayData2.add(bAPArrayElement2);
            } else {
                this._logError(string);
            }
            if (aSGArrayListData == null) continue;
            aSGArrayListData.deleteElementPos(bAPArrayElement.getPos());
        }
        return bAPArrayData2;
    }

    private void _pendingChangeRequest(BAPStatusArray bAPStatusArray, ASGArrayListData aSGArrayListData) {
        BAPArrayData bAPArrayData = this._insertStatusArrayElements(bAPStatusArray, "Changed element was not found in the list", aSGArrayListData);
        if (bAPArrayData.size() != 0) {
            ASGArrayListData aSGArrayListData2 = this.getArrayListData();
            this.getChangeNotifier().elementsUpdated(this, aSGArrayListData2.indexOf(bAPArrayData.getFirst()), bAPArrayData);
            if (aSGArrayListData.size() != 0) {
                BAPGetArray bAPGetArray = this._createGetArrayRequest(aSGArrayListData.getFirst().getPos(), this._maxRequestableElements(bAPStatusArray.getArrayHeader().getRecordAddress(), aSGArrayListData.size()), bAPStatusArray.getArrayHeader().getRecordAddress(), false);
                this._sendRequest(bAPGetArray, 7, aSGArrayListData);
            }
        } else {
            this._logError("Got change array with no elements or with invalid pos");
        }
    }

    private void _peningInsertOneElementIndication(BAPStatusArray bAPStatusArray) {
        if (bAPStatusArray.getArrayData().size() > 0) {
            int n = bAPStatusArray.getArrayData().size() >= 2 ? this.getArrayListData().insertBefore(bAPStatusArray.getArrayData().getFirst().getPos(), bAPStatusArray.getArrayData().getLast()) : this.getArrayListData().add(bAPStatusArray.getArrayData().getFirst());
            if (n != -1) {
                this.getChangeNotifier().elementsInserted(this, n, this.getArrayListData().getElements(n, 1));
            } else {
                this._logError("Ignore, insert (one element) answer, because the insertion position is not provided or already exists");
            }
        } else {
            this._logError("Ignore, insert (one element) answer, because no inserted elements were provided.");
        }
    }

    private void _pendingInsertElementsIndication(BAPStatusArray bAPStatusArray, BAPGetArray bAPGetArray, ASGArrayListData aSGArrayListData) {
        if (bAPStatusArray.getArrayData().size() > 0) {
            int n = this.getArrayListData().insertAfter(bAPGetArray.getArrayHeader().start, bAPStatusArray.getArrayData(), bAPGetArray.getArrayHeader().getNumberOfElements());
            if (n != -1) {
                boolean bl;
                this.getChangeNotifier().elementsInserted(this, n, bAPStatusArray.getArrayData());
                boolean bl2 = aSGArrayListData.size() == bAPGetArray.getArrayHeader().elements;
                aSGArrayListData.deleteElementPositions(bAPStatusArray.getArrayData());
                boolean bl3 = bl = aSGArrayListData.size() != 0;
                if (!bl2 && bl) {
                    int n2 = this.getDelegate().getDefaultRecordAddress(this);
                    BAPGetArray bAPGetArray2 = this._createGetArrayRequest(bAPStatusArray.getArrayData().getLast().getPos(), this._maxRequestableElements(n2, aSGArrayListData.size()), n2, true);
                    this._sendRequest(bAPGetArray2, 6, aSGArrayListData);
                } else if (!bl2 || bl) {
                    this._logError("Requested inserted elements were inserted, can't load other elements because of incorrect pos in requested status array");
                }
            } else {
                this._logError("Ignore, insert answer, because the insertion position is not provided");
            }
        } else {
            this._logError("Ignore insert elements answer, because no inserted elements were provided.");
        }
    }

    private void _pendingDeleteRequest(BAPStatusArray bAPStatusArray) {
        this._deleteArrayElements(bAPStatusArray.getArrayHeader().start, bAPStatusArray.getArrayData());
    }

    private void _pendingModifyRequest(BAPStatusArray bAPStatusArray) {
        BAPArrayData bAPArrayData = this._insertStatusArrayElements(bAPStatusArray, "Modified element was not found in the list", null);
        if (bAPArrayData.size() != 0) {
            ASGArrayListData aSGArrayListData = this.getArrayListData();
            this.getChangeNotifier().elementsUpdated(this, aSGArrayListData.indexOf(bAPArrayData.getFirst()), bAPArrayData);
        } else {
            this._logError("Got confirmation of requested changed elements with array of no elements or with invalid pos");
        }
    }

    private void _pendingInsertRequest(BAPStatusArray bAPStatusArray) {
        this._logWarning("Got confirmation of requested inserted elements with, there is yet no concept to add this elements, we wait for ChangeArray now");
        this._stopHighLevelRetryTimer(bAPStatusArray.getTransactionId());
    }

    private void _processBroadcastStatusArrayIndication(BAPStatusArray bAPStatusArray) {
        if (bAPStatusArray.getArrayData().size() > 0) {
            if (this.getFactory().createEmptyElement(this).equalTo(bAPStatusArray.getArrayData().getFirst())) {
                this._deleteArrayElements(bAPStatusArray.getArrayHeader().start, bAPStatusArray.getArrayData());
            } else {
                BAPArrayData bAPArrayData = this._insertStatusArrayElements(bAPStatusArray, "Broadcast StatusArray element was not found in the list", null);
                if (bAPArrayData.size() != 0) {
                    ASGArrayListData aSGArrayListData = this.getArrayListData();
                    this.getChangeNotifier().elementsUpdated(this, aSGArrayListData.indexOf(bAPArrayData.getFirst()), bAPArrayData);
                } else {
                    this._logError("Got broadcast StatusArray message elements with array with invalid pos, which can not be found in current list");
                }
            }
        } else {
            this._logError("Got broadcast StatusArray message elements with array of no elements");
        }
    }

    private void _logError(String string) {
        this.getDelegate().getLogger(this).log(this, 2, string);
    }

    private void _logWarning(String string) {
        this.getDelegate().getLogger(this).log(this, 4, string);
    }

    private void _logTrace(String string) {
        this.getDelegate().getLogger(this).log(this, 16, string);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

