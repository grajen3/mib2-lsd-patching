/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.eni.functions;

import de.vw.mib.asl.api.bap.observer.BAPObserverRegistry;
import de.vw.mib.asl.api.bap.observer.BAPValueObserver;
import de.vw.mib.asl.api.bap.observer.BAPValueObserverable;
import de.vw.mib.asl.internal.ocu.common.api.services.InternalServiceProvider;
import de.vw.mib.asl.internal.ocu.eni.api.online.CurrentOnlineUpdateStateServiceListener;
import de.vw.mib.asl.internal.ocu.eni.functions.ENIFunction;
import de.vw.mib.asl.internal.ocu.eni.functions.OnlineUpdateList;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.CurrentOnlineUpdateState_Status;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.OnlineUpdateList_Data;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.RemoteProcessState_Status;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunction;
import de.vw.mib.bap.functions.BAPFunctionController;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.desktop.internal.common.ServiceManager;

public class CurrentOnlineUpdateState
extends ENIFunction
implements PropertyListener,
InternalServiceProvider,
BAPValueObserver {
    private CurrentOnlineUpdateState_Status _currentOnlineUpdateStateStatus;
    private RemoteProcessState_Status _remoteProcessStateStatus;
    private ASGArrayList _onlineUpdateList;
    private ASGArrayList _userList;
    private boolean registeredAsServiceProvider;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$eni$api$online$CurrentOnlineUpdateStateServiceListener;

    public CurrentOnlineUpdateStateServiceListener getCurrentOnlineUpdateStateServiceListener() {
        return (CurrentOnlineUpdateStateServiceListener)this.getDelegate().getService(class$de$vw$mib$asl$internal$ocu$eni$api$online$CurrentOnlineUpdateStateServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$CurrentOnlineUpdateStateServiceListener = CurrentOnlineUpdateState.class$("de.vw.mib.asl.internal.ocu.eni.api.online.CurrentOnlineUpdateStateServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$CurrentOnlineUpdateStateServiceListener);
    }

    private CurrentOnlineUpdateState_Status getCurrentOnlineUpdateStateStatus() {
        if (this._currentOnlineUpdateStateStatus == null) {
            this._currentOnlineUpdateStateStatus = new CurrentOnlineUpdateState_Status();
        }
        return this._currentOnlineUpdateStateStatus;
    }

    private RemoteProcessState_Status getRemoteProcessStateStatus() {
        if (this._remoteProcessStateStatus == null) {
            this._remoteProcessStateStatus = new RemoteProcessState_Status();
        }
        return this._remoteProcessStateStatus;
    }

    private ASGArrayList getOnlineUpdateList() {
        if (this._onlineUpdateList == null) {
            OnlineUpdateList onlineUpdateList = (OnlineUpdateList)this.getDelegate().getBAPFunctionListener(37);
            this._onlineUpdateList = onlineUpdateList.getOnlineUpdateList();
        }
        return this._onlineUpdateList;
    }

    private void _informServices() {
        boolean bl = true;
        CurrentOnlineUpdateState_Status currentOnlineUpdateState_Status = this.getCurrentOnlineUpdateStateStatus();
        String string = currentOnlineUpdateState_Status.currentUpdateId.toString();
        int n = this.getRemoteProcessStateStatus().processState;
        int n2 = this.getRemoteProcessStateStatus().exceptionState;
        if (!(currentOnlineUpdateState_Status.updateState != 2 && currentOnlineUpdateState_Status.updateState != 22 || n2 != 0 || n == 1 && this.checkIsUpdateIdInOnlineUpdateList(string) && this.checkCurrentLanguageEqualToUpdateLanguage(string))) {
            bl = false;
        }
        if (this.getRemoteProcessStateStatus().commandType == 3 || this.getRemoteProcessStateStatus().commandType == 19) {
            bl = false;
        }
        if (bl) {
            this.getCurrentOnlineUpdateStateServiceListener().updateEniCurrentOnlineUpdateState(string.toString(), currentOnlineUpdateState_Status.updateState, currentOnlineUpdateState_Status.exceptionState, currentOnlineUpdateState_Status.updateProgress, currentOnlineUpdateState_Status.startTime.toString(), n, n2);
        }
        if (this.getLogger().isTraceEnabled(256)) {
            this.getLogger().trace(256).append("CurrentOnlineUpdateState: Update with updateId =").append(string.toString()).append(" updateState = ").append(currentOnlineUpdateState_Status.updateState).append(" updateProgress = ").append(currentOnlineUpdateState_Status.updateProgress).append(" startTime = ").append(currentOnlineUpdateState_Status.startTime).log();
        }
    }

    private boolean checkIsUpdateIdInOnlineUpdateList(String string) {
        boolean bl = false;
        int n = this.getOnlineUpdateList().size();
        for (int i2 = 0; i2 < n; ++i2) {
            if (!((OnlineUpdateList_Data)this.getOnlineUpdateList().get((int)i2)).updateId.toString().equals(string)) continue;
            bl = true;
            break;
        }
        return bl;
    }

    private boolean checkCurrentLanguageEqualToUpdateLanguage(String string) {
        String string2;
        boolean bl = false;
        String string3 = ServiceManager.configurationManager.getCurrentGuiLanguage();
        int n = -1;
        int n2 = this.getOnlineUpdateList().size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!((OnlineUpdateList_Data)this.getOnlineUpdateList().get((int)i2)).updateId.toString().equals(string)) continue;
            n = ((OnlineUpdateList_Data)this.getOnlineUpdateList().get((int)i2)).language;
            break;
        }
        if ((string2 = OnlineUpdateList.LANGUAGES[n]) == null) {
            return bl;
        }
        if (string3.equals(string2)) {
            bl = true;
        }
        return bl;
    }

    @Override
    public void initialize(boolean bl) {
        if (bl) {
            this.getDelegate().getProperty(this).getProperty(null, this);
            if (!this.registeredAsServiceProvider) {
                this.getDelegate().registerServiceProviderListener(this, class$de$vw$mib$asl$internal$ocu$eni$api$online$CurrentOnlineUpdateStateServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$CurrentOnlineUpdateStateServiceListener = CurrentOnlineUpdateState.class$("de.vw.mib.asl.internal.ocu.eni.api.online.CurrentOnlineUpdateStateServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$CurrentOnlineUpdateStateServiceListener, CurrentOnlineUpdateStateServiceListener.SERVICE_CONSTANTS);
                this.registeredAsServiceProvider = true;
            }
            ((BAPObserverRegistry)((Object)this.getDelegate())).getBapValueObservable(37).addObserver(this, null);
            ((BAPObserverRegistry)((Object)this.getDelegate())).getBapValueObservable(20).addObserver(this, null);
        }
    }

    @Override
    public void uninitialize() {
        ((BAPObserverRegistry)((Object)this.getDelegate())).getBapValueObservable(37).removeObserver(this);
        ((BAPObserverRegistry)((Object)this.getDelegate())).getBapValueObservable(20).removeObserver(this);
    }

    @Override
    public int getFunctionId() {
        return 36;
    }

    @Override
    public void requestError(int n, BAPFunction bAPFunction) {
    }

    @Override
    public boolean statusProperty(BAPEntity bAPEntity, Property property) {
        CurrentOnlineUpdateState_Status currentOnlineUpdateState_Status = (CurrentOnlineUpdateState_Status)bAPEntity;
        CurrentOnlineUpdateState_Status currentOnlineUpdateState_Status2 = this.getCurrentOnlineUpdateStateStatus();
        currentOnlineUpdateState_Status2.currentUpdateId.setContent(currentOnlineUpdateState_Status.currentUpdateId);
        currentOnlineUpdateState_Status2.updateProgress = currentOnlineUpdateState_Status.updateProgress;
        currentOnlineUpdateState_Status2.updateState = currentOnlineUpdateState_Status.updateState;
        currentOnlineUpdateState_Status2.exceptionState = currentOnlineUpdateState_Status.exceptionState;
        this._informServices();
        return true;
    }

    @Override
    public boolean statusAckProperty(BAPEntity bAPEntity, Property property) {
        return false;
    }

    @Override
    public void serviceListenerRegistered(int n) {
        if (CurrentOnlineUpdateStateServiceListener.SERVICE_CONSTANTS[0] == n) {
            this._informServices();
        }
    }

    @Override
    public void bapValueChanged(BAPValueObserverable bAPValueObserverable, BAPEntity bAPEntity, BAPEntity bAPEntity2, Object object) {
        if (((BAPFunctionController)((Object)bAPValueObserverable)).getFunctionId() == 20) {
            this._remoteProcessStateStatus = (RemoteProcessState_Status)bAPEntity;
            this._informServices();
        } else if (((BAPFunctionController)((Object)bAPValueObserverable)).getFunctionId() == 37) {
            OnlineUpdateList onlineUpdateList = (OnlineUpdateList)this.getDelegate().getBAPFunctionListener(37);
            this._onlineUpdateList = onlineUpdateList.getOnlineUpdateList();
            this._informServices();
        }
    }

    @Override
    public void bapValueError(BAPValueObserverable bAPValueObserverable, int n, Object object) {
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

