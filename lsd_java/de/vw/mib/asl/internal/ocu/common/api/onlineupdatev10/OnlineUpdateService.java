/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api.onlineupdatev10;

import de.vw.mib.asl.api.ocu.eni.ENIServiceProvider;
import de.vw.mib.asl.api.ocu.onlineupdatev10.OnlineUpdateServiceListener;
import de.vw.mib.asl.api.ocu.onlineupdatev10.OnlineUpdateServiceResponseListener;
import de.vw.mib.asl.internal.ocu.common.api.onlineupdatev10.OnlineUpdateService$IteratorProvider;
import de.vw.mib.asl.internal.ocu.common.api.onlineupdatev10.OnlineUpdateServiceProvider;
import de.vw.mib.asl.internal.ocu.common.api.onlineupdatev10.data.OnlineUpdateChallengeData;
import de.vw.mib.asl.internal.ocu.common.api.onlineupdatev10.data.OnlineUpdateChallengeList;
import de.vw.mib.asl.internal.ocu.common.api.onlineupdatev10.data.OnlineUpdateList;
import de.vw.mib.asl.internal.ocu.common.api.onlineupdatev10.data.OnlineUpdateListEntry;
import de.vw.mib.asl.internal.ocu.common.api.onlineupdatev10.data.OnlineUpdateState;
import de.vw.mib.asl.internal.ocu.common.api.onlineupdatev10.enums.OnlineUpdateListState;
import de.vw.mib.asl.internal.ocu.common.api.onlineupdatev10.enums.OperationResult;
import de.vw.mib.asl.internal.ocu.common.api.onlineupdatev10.enums.OperationType;
import de.vw.mib.asl.internal.ocu.common.api.onlineupdatev10.mapping.OnlineUpdateMapping;
import de.vw.mib.asl.internal.ocu.eni.api.EniApiServices;
import de.vw.mib.asl.internal.ocu.eni.api.online.ChallengeDataServiceListener;
import de.vw.mib.asl.internal.ocu.eni.api.online.CurrentOnlineUpdateStateServiceListener;
import de.vw.mib.asl.internal.ocu.eni.api.online.OnlineUpdateListServiceListener;
import de.vw.mib.asl.internal.ocu.eni.api.online.OperationStateServiceListener;
import de.vw.mib.asl.internal.ocu.eni.api.online.RemoteProcessServiceListener;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.ChallengeData_Data;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.OnlineUpdateList_Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OnlineUpdateService
implements de.vw.mib.asl.api.ocu.onlineupdatev10.OnlineUpdateService,
RemoteProcessServiceListener,
CurrentOnlineUpdateStateServiceListener,
OnlineUpdateListServiceListener,
OperationStateServiceListener,
ChallengeDataServiceListener {
    private final OnlineUpdateService$IteratorProvider listenerIteratorProvider;
    private OnlineUpdateServiceResponseListener lastResponseListener;
    private de.vw.mib.asl.api.ocu.onlineupdatev10.data.OnlineUpdateList onlineUpdateList;
    private de.vw.mib.asl.api.ocu.onlineupdatev10.data.OnlineUpdateState onlineUpdateState;
    private de.vw.mib.asl.api.ocu.onlineupdatev10.data.OnlineUpdateChallengeList onlineUpdateChallengeList;
    private boolean _requestChallengeInProgress;

    public OnlineUpdateService(OnlineUpdateServiceProvider onlineUpdateServiceProvider) {
        this.listenerIteratorProvider = onlineUpdateServiceProvider;
    }

    private Iterator getListenerIterator() {
        return this.listenerIteratorProvider.getIterator();
    }

    private void setLastResponseListener(OnlineUpdateServiceResponseListener onlineUpdateServiceResponseListener) {
        this.lastResponseListener = onlineUpdateServiceResponseListener;
    }

    private OnlineUpdateServiceResponseListener getLastResponseListener() {
        return this.lastResponseListener;
    }

    private void clearLastResponseListener() {
        this.setLastResponseListener(null);
    }

    private EniApiServices getEniApiServices() {
        return (EniApiServices)ENIServiceProvider.getENIService(ENIServiceProvider.ENI_SERVICE_VERSION_1_0).getEniApiServices();
    }

    @Override
    public de.vw.mib.asl.api.ocu.onlineupdatev10.data.OnlineUpdateState getOnlineUpdateState() {
        return this.getOnlineUpdateStateInternal();
    }

    public de.vw.mib.asl.api.ocu.onlineupdatev10.data.OnlineUpdateState getOnlineUpdateStateInternal() {
        if (this.onlineUpdateState == null) {
            this.onlineUpdateState = new OnlineUpdateState("", OnlineUpdateMapping.mapEniUpdateState(1, 0, 1, 0), 0, new Date(0L).toString());
        }
        return this.onlineUpdateState;
    }

    private void setOnlineUpdateState(de.vw.mib.asl.api.ocu.onlineupdatev10.data.OnlineUpdateState onlineUpdateState) {
        if (!this.getOnlineUpdateState().equals(onlineUpdateState)) {
            this.onlineUpdateState = onlineUpdateState;
            Iterator iterator = this.getListenerIterator();
            while (iterator.hasNext()) {
                OnlineUpdateServiceListener onlineUpdateServiceListener = (OnlineUpdateServiceListener)iterator.next();
                onlineUpdateServiceListener.updateOnlineUpdateState(this, this.getOnlineUpdateState());
            }
        }
    }

    @Override
    public de.vw.mib.asl.api.ocu.onlineupdatev10.data.OnlineUpdateChallengeList getOnlineUpdateChallengeList() {
        if (this.onlineUpdateChallengeList == null) {
            this.onlineUpdateChallengeList = new OnlineUpdateChallengeList(OnlineUpdateListState.ENUM_NOT_INITIALIZED, new ArrayList(), 0);
        }
        return this.onlineUpdateChallengeList;
    }

    private void setOnlineUpdateChallengeList(int n, List list, int n2) {
        Object object;
        ArrayList arrayList = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); ++i2) {
            object = (ChallengeData_Data)list.get(i2);
            arrayList.add(new OnlineUpdateChallengeData((ChallengeData_Data)object));
        }
        OnlineUpdateChallengeList onlineUpdateChallengeList = new OnlineUpdateChallengeList(OnlineUpdateMapping.mapEniOnlineUpdateListState(n), arrayList, n2);
        if (!this.getOnlineUpdateChallengeList().equals(onlineUpdateChallengeList) || this._requestChallengeInProgress) {
            this._requestChallengeInProgress = false;
            this.onlineUpdateChallengeList = onlineUpdateChallengeList;
            object = this.getListenerIterator();
            while (object.hasNext()) {
                OnlineUpdateServiceListener onlineUpdateServiceListener = (OnlineUpdateServiceListener)object.next();
                onlineUpdateServiceListener.updateOnlineUpdateChallengeList(this, this.onlineUpdateChallengeList);
            }
        }
    }

    @Override
    public de.vw.mib.asl.api.ocu.onlineupdatev10.data.OnlineUpdateList getOnlineUpdateList() {
        if (this.onlineUpdateList == null) {
            this.onlineUpdateList = new OnlineUpdateList(OnlineUpdateListState.ENUM_NOT_INITIALIZED, new ArrayList());
        }
        return this.onlineUpdateList;
    }

    private void setOnlineUpdateList(int n, List list) {
        Object object;
        ArrayList arrayList = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); ++i2) {
            object = (OnlineUpdateList_Data)list.get(i2);
            arrayList.add(new OnlineUpdateListEntry((OnlineUpdateList_Data)object));
        }
        OnlineUpdateList onlineUpdateList = new OnlineUpdateList(OnlineUpdateMapping.mapEniOnlineUpdateListState(n), arrayList);
        if (!this.getOnlineUpdateList().equals(onlineUpdateList)) {
            this.onlineUpdateList = onlineUpdateList;
            object = this.getListenerIterator();
            while (object.hasNext()) {
                OnlineUpdateServiceListener onlineUpdateServiceListener = (OnlineUpdateServiceListener)object.next();
                onlineUpdateServiceListener.updateOnlineUpdateList(this, this.onlineUpdateList);
            }
        }
    }

    @Override
    public void postponeOnlineDownload(String string, Date date, OnlineUpdateServiceResponseListener onlineUpdateServiceResponseListener) {
        if (this.getLastResponseListener() != null) {
            onlineUpdateServiceResponseListener.operationResult(this, OperationType.ENUM_POSTPONE_ONLINE_DOWNLOAD, OperationResult.ENUM_NOT_SUCCESSFUL_SERVICE_BUSY);
        } else {
            this.setLastResponseListener(onlineUpdateServiceResponseListener);
            this.getEniApiServices().postponeOnlineDownload(string, "");
        }
    }

    @Override
    public void authenticateOnlineDownload(String string, OnlineUpdateServiceResponseListener onlineUpdateServiceResponseListener) {
        if (this.getLastResponseListener() != null) {
            onlineUpdateServiceResponseListener.operationResult(this, OperationType.ENUM_AUTHENTICATE_ONLINE_DOWNLOAD, OperationResult.ENUM_NOT_SUCCESSFUL_SERVICE_BUSY);
        } else {
            this.setLastResponseListener(onlineUpdateServiceResponseListener);
            this.getEniApiServices().authenticateOnlineDownload(string);
        }
    }

    @Override
    public void requestChallenge(OnlineUpdateServiceResponseListener onlineUpdateServiceResponseListener) {
        if (this.getLastResponseListener() != null) {
            onlineUpdateServiceResponseListener.operationResult(this, OperationType.ENUM_REQUEST_CHALLENGE, OperationResult.ENUM_NOT_SUCCESSFUL_SERVICE_BUSY);
        } else {
            this._requestChallengeInProgress = true;
            this.setLastResponseListener(onlineUpdateServiceResponseListener);
            this.getEniApiServices().getChallenge();
        }
    }

    @Override
    public void confirmOnlineDownloadError(String string, OnlineUpdateServiceResponseListener onlineUpdateServiceResponseListener) {
        if (this.getLastResponseListener() != null) {
            onlineUpdateServiceResponseListener.operationResult(this, OperationType.ENUM_CONFIRM_UPDATE_ERROR, OperationResult.ENUM_NOT_SUCCESSFUL_SERVICE_BUSY);
        } else {
            this.setLastResponseListener(onlineUpdateServiceResponseListener);
            this.getEniApiServices().confirmDownloadError(string);
        }
    }

    @Override
    public void postponeUpdateInstallation(String string, Date date, OnlineUpdateServiceResponseListener onlineUpdateServiceResponseListener) {
        if (this.getLastResponseListener() != null) {
            onlineUpdateServiceResponseListener.operationResult(this, OperationType.ENUM_POSTPONE_UPDATE_INSTALLATION, OperationResult.ENUM_NOT_SUCCESSFUL_SERVICE_BUSY);
        } else {
            this.setLastResponseListener(onlineUpdateServiceResponseListener);
            this.getEniApiServices().postponeUpdateInstallation(string, "");
        }
    }

    @Override
    public void confirmUpdateInstallation(String string, OnlineUpdateServiceResponseListener onlineUpdateServiceResponseListener) {
        if (this.getLastResponseListener() != null) {
            onlineUpdateServiceResponseListener.operationResult(this, OperationType.ENUM_CONFIRM_UPDATE_INSTALLATION, OperationResult.ENUM_NOT_SUCCESSFUL_SERVICE_BUSY);
        } else {
            this.setLastResponseListener(onlineUpdateServiceResponseListener);
            this.getEniApiServices().confirmUpdateInstallation(string);
        }
    }

    @Override
    public void confirmInstallationError(String string, OnlineUpdateServiceResponseListener onlineUpdateServiceResponseListener) {
        if (this.getLastResponseListener() != null) {
            onlineUpdateServiceResponseListener.operationResult(this, OperationType.ENUM_CONFIRM_UPDATE_ERROR, OperationResult.ENUM_NOT_SUCCESSFUL_SERVICE_BUSY);
        } else {
            this.setLastResponseListener(onlineUpdateServiceResponseListener);
            this.getEniApiServices().confirmInstallationError(string);
        }
    }

    @Override
    public void confirmInstallationFinished(String string, OnlineUpdateServiceResponseListener onlineUpdateServiceResponseListener) {
        if (this.getLastResponseListener() != null) {
            onlineUpdateServiceResponseListener.operationResult(this, OperationType.ENUM_CONFIRM_INSTALLATION_FINISHED, OperationResult.ENUM_NOT_SUCCESSFUL_SERVICE_BUSY);
        } else {
            this.setLastResponseListener(onlineUpdateServiceResponseListener);
            this.getEniApiServices().confirmInstallationFinished(string);
        }
    }

    @Override
    public void confirmUpdateWithdrawn(String string, OnlineUpdateServiceResponseListener onlineUpdateServiceResponseListener) {
        if (this.getLastResponseListener() != null) {
            onlineUpdateServiceResponseListener.operationResult(this, OperationType.ENUM_CONFIRM_UPDATE_WITHDRAWN, OperationResult.ENUM_NOT_SUCCESSFUL_SERVICE_BUSY);
        } else {
            this.setLastResponseListener(onlineUpdateServiceResponseListener);
            this.getEniApiServices().confirmUpdateWithdrawn(string);
        }
    }

    @Override
    public void operationStatus(int n) {
    }

    @Override
    public void operationResult(int n, int n2) {
        OnlineUpdateServiceResponseListener onlineUpdateServiceResponseListener = this.getLastResponseListener();
        if (onlineUpdateServiceResponseListener != null) {
            this.clearLastResponseListener();
            onlineUpdateServiceResponseListener.operationResult(this, OnlineUpdateMapping.mapEniOperationType(n), OnlineUpdateMapping.mapEniOperationResult(n2));
        }
    }

    @Override
    public void updateEniCurrentOnlineUpdateState(String string, int n, int n2, int n3, String string2, int n4, int n5) {
        this.setOnlineUpdateState(new OnlineUpdateState(string, OnlineUpdateMapping.mapEniUpdateState(n, n2, n4, n5), n3, string2));
    }

    @Override
    public void updateOnlineUpdateListData(int n, List list) {
        this.setOnlineUpdateList(n, list);
    }

    @Override
    public void updateEniOperationState(boolean bl) {
        this.setOnlineUpdateState(this.getOnlineUpdateStateInternal());
    }

    @Override
    public void updateChallengeData(int n, List list, int n2) {
        this.setOnlineUpdateChallengeList(n, list, n2);
    }
}

