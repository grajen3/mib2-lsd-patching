/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.eni.functions;

import de.vw.mib.asl.api.bap.observer.BAPObserverRegistry;
import de.vw.mib.asl.api.bap.observer.BAPValueObserver;
import de.vw.mib.asl.api.bap.observer.BAPValueObserverable;
import de.vw.mib.asl.internal.ocu.common.timer.TimerObj;
import de.vw.mib.asl.internal.ocu.eni.api.online.UserListService;
import de.vw.mib.asl.internal.ocu.eni.api.online.UserListServiceListener;
import de.vw.mib.asl.internal.ocu.eni.functions.ENIFunction;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.UserList_Data;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.UserList_GetArray;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.asg.ASGArrayListChangeNotifier;
import de.vw.mib.bap.array.asg.ASGArrayListDelegate;
import de.vw.mib.bap.array.asg.ASGArrayListFactory;
import de.vw.mib.bap.array.asg.complete.ArrayListFactory;
import de.vw.mib.bap.array.logger.Logger;
import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.requests.BAPSetGetArray;
import de.vw.mib.bap.array.requests.BAPStatusArray;
import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayDataList;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.Array;
import de.vw.mib.bap.functions.ArrayListener;
import de.vw.mib.bap.functions.BAPFunction;
import java.util.ArrayList;

public class UserList
extends ENIFunction
implements ArrayListener,
ASGArrayListFactory,
ASGArrayListChangeNotifier,
ASGArrayListDelegate,
Logger,
UserListService,
BAPValueObserver {
    private static final int USER_LIST_MAX_REQUESTABLE_ELEMENTS;
    private static final int HIGH_LEVEL_RETRY_B_NUMBER_OF_RETRIES;
    private static final int HIGH_LEVEL_RETRY_B_RETRY_TIME;
    private ASGArrayList _userList;
    private boolean userListIsNotSynchronized;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$eni$api$online$UserListServiceListener;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$eni$api$online$UserListService;

    public ASGArrayList getUserList() {
        if (this._userList == null) {
            this._userList = new ArrayListFactory().createCompleteArrayList(this, this, this, 1, this.getFunctionId(), true, 4, 0);
        }
        return this._userList;
    }

    private UserListServiceListener getUserListServiceListener() {
        return (UserListServiceListener)this.getDelegate().getService(class$de$vw$mib$asl$internal$ocu$eni$api$online$UserListServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$UserListServiceListener = UserList.class$("de.vw.mib.asl.internal.ocu.eni.api.online.UserListServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$UserListServiceListener);
    }

    @Override
    public void initialize(boolean bl) {
        if (bl) {
            this.getUserList().reloadData();
        } else {
            this.getDelegate().registerServiceProvider(this, class$de$vw$mib$asl$internal$ocu$eni$api$online$UserListService == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$UserListService = UserList.class$("de.vw.mib.asl.internal.ocu.eni.api.online.UserListService")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$UserListService, UserListService.SERVICE_CONSTANTS);
            this.getDelegate().registerServiceProviderListener(this, class$de$vw$mib$asl$internal$ocu$eni$api$online$UserListServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$UserListServiceListener = UserList.class$("de.vw.mib.asl.internal.ocu.eni.api.online.UserListServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$UserListServiceListener, UserListServiceListener.SERVICE_CONSTANTS);
            ((BAPObserverRegistry)((Object)this.getDelegate())).getBapValueObservable(29).addObserver(this, null);
        }
    }

    @Override
    public void uninitialize() {
        this.getUserList().stopFetchingData();
        this.updateUserListData(this.getUserList(), true);
    }

    @Override
    public int getFunctionId() {
        return 21;
    }

    @Override
    public void requestError(int n, BAPFunction bAPFunction) {
        switch (n) {
            case 34: {
                this.getUserList().error(-1);
                break;
            }
            case 33: {
                this.getUserList().error(-2);
                break;
            }
            case 67: {
                this.getUserList().error(-3);
                break;
            }
            case 66: {
                this.getUserList().error(-4);
                this.updateUserListData(this.getUserList(), true);
                break;
            }
            default: {
                this.getLogger().warn(256).append("UserList: ignore got error code = ").append(n).log();
            }
        }
    }

    @Override
    public void statusArray(BAPStatusArray bAPStatusArray, Array array) {
        this.getUserList().statusArray(bAPStatusArray);
    }

    @Override
    public void changedArray(BAPChangedArray bAPChangedArray, Array array) {
        this.getUserList().changedArray(bAPChangedArray);
    }

    @Override
    public BAPGetArray createGetArrayRequest(ASGArrayList aSGArrayList) {
        return new UserList_GetArray();
    }

    @Override
    public BAPSetGetArray createSetGetArrayRequest(ASGArrayList aSGArrayList) {
        return null;
    }

    @Override
    public BAPArrayElement createEmptyElement(ASGArrayList aSGArrayList) {
        return new UserList_Data(new ArrayHeader());
    }

    @Override
    public BAPArrayElement mergeArrayElementAttributes(ASGArrayList aSGArrayList, BAPArrayElement bAPArrayElement, BAPArrayElement bAPArrayElement2, int n) {
        UserList_Data userList_Data = (UserList_Data)bAPArrayElement;
        UserList_Data userList_Data2 = (UserList_Data)bAPArrayElement2;
        switch (n) {
            case 0: {
                userList_Data2 = userList_Data;
                break;
            }
            default: {
                this.getLogger().error(256, "UserList: Wrong recordAddress given in mergeArrayElementAttributes");
            }
        }
        return userList_Data2;
    }

    @Override
    public Timer createTimer(ASGArrayList aSGArrayList, TimerNotifier timerNotifier, long l) {
        return new TimerObj(timerNotifier, l);
    }

    @Override
    public void elementsInserted(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
        this.updateUserListData(aSGArrayList);
    }

    @Override
    public void elementsDeleted(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
        this.updateUserListData(aSGArrayList);
    }

    @Override
    public void elementsUpdated(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
        this.updateUserListData(aSGArrayList);
    }

    @Override
    public void reloaded(ASGArrayList aSGArrayList) {
        this.updateUserListData(aSGArrayList);
    }

    @Override
    public void requestGetArray(ASGArrayList aSGArrayList, BAPGetArray bAPGetArray) {
        this.getDelegate().getArray(this).getArray(bAPGetArray, this);
    }

    @Override
    public void requestSetGetArray(ASGArrayList aSGArrayList, BAPSetGetArray bAPSetGetArray) {
        this.getDelegate().getArray(this).setGetArray(bAPSetGetArray, this);
    }

    @Override
    public void requestTimeout(ASGArrayList aSGArrayList, int n, boolean bl) {
        this.getLogger().warn(256).append("UserList: request time out counter=").append(n).append(", finished=").append(bl).log();
        if (bl) {
            this.updateUserListData(aSGArrayList);
        }
    }

    @Override
    public int getMaxRequestableElements(ASGArrayList aSGArrayList, int n) {
        return 3;
    }

    @Override
    public int getDefaultRecordAddress(ASGArrayList aSGArrayList) {
        return 0;
    }

    @Override
    public boolean continueLoading(ASGArrayList aSGArrayList) {
        return true;
    }

    @Override
    public Logger getLogger(ASGArrayList aSGArrayList) {
        return this;
    }

    @Override
    public void log(ASGArrayList aSGArrayList, int n, String string) {
        String string2 = "UserList: ";
        switch (n) {
            case 1: {
                this.getLogger().fatal(256).append("UserList: ").append(string).log();
                break;
            }
            case 2: {
                this.getLogger().error(256).append("UserList: ").append(string).log();
                break;
            }
            case 4: {
                this.getLogger().warn(256).append("UserList: ").append(string).log();
                break;
            }
            case 8: {
                this.getLogger().info(256).append("UserList: ").append(string).log();
                break;
            }
            case 12: {
                this.getLogger().normal(256).append("UserList: ").append(string).log();
                break;
            }
            case 16: {
                if (!this.getLogger().isTraceEnabled(256)) break;
                this.getLogger().trace(256).append("UserList: ").append(string).log();
                break;
            }
            default: {
                this.getLogger().error(256).append("UserList: ").append("Wrong log message called from ASG array list").log();
            }
        }
    }

    @Override
    public void serviceListenerRegistered(int n) {
        if (UserListServiceListener.SERVICE_CONSTANTS[0] == n) {
            this.updateUserListData(this.getUserList());
        }
    }

    private void updateUserListData(ASGArrayList aSGArrayList, boolean bl) {
        int n = bl ? 1 : (aSGArrayList.isLoadingError() ? 4 : (aSGArrayList.isLoading() ? 2 : 3));
        ArrayList arrayList = new ArrayList();
        if (n != 1) {
            int n2 = aSGArrayList.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                UserList_Data userList_Data = (UserList_Data)aSGArrayList.get(i2);
                if (userList_Data.userType != 0) continue;
                arrayList.add(userList_Data);
            }
        }
        this.getUserListServiceListener().updateUserListData(n, arrayList);
        this.didChangeValue(null);
        if (this.getLogger().isTraceEnabled(256)) {
            this.getLogger().trace(256).append("UserList: updated with numElements=").append(arrayList.size()).append(", state=").append(n).log();
        }
    }

    private void updateUserListData(ASGArrayList aSGArrayList) {
        this.updateUserListData(aSGArrayList, false);
    }

    @Override
    public void bapValueChanged(BAPValueObserverable bAPValueObserverable, BAPEntity bAPEntity, BAPEntity bAPEntity2, Object object) {
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

