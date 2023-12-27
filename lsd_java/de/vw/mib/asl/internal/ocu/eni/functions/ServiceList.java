/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.eni.functions;

import de.vw.mib.asl.internal.ocu.common.timer.TimerObj;
import de.vw.mib.asl.internal.ocu.eni.api.online.ServiceListService;
import de.vw.mib.asl.internal.ocu.eni.api.online.ServiceListServiceListener;
import de.vw.mib.asl.internal.ocu.eni.functions.ENIFunction;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.ServiceList_Data;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.ServiceList_GetArray;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.ServiceList_SetGetArray;
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
import de.vw.mib.bap.functions.Array;
import de.vw.mib.bap.functions.ArrayListener;
import de.vw.mib.bap.functions.BAPFunction;
import de.vw.mib.bap.functions.BAPFunctionList;
import java.util.ArrayList;
import java.util.Iterator;

public class ServiceList
extends ENIFunction
implements ArrayListener,
ASGArrayListFactory,
ASGArrayListChangeNotifier,
ASGArrayListDelegate,
Logger,
ServiceListService {
    private static final int SERVICE_LIST_MAX_REQUESTABLE_ELEMENTS;
    private static final int HIGH_LEVEL_RETRY_B_NUMBER_OF_RETRIES;
    private static final int HIGH_LEVEL_RETRY_B_RETRY_TIME;
    private ASGArrayList _serviceList;
    private static final int INVALID_SERVICE_ID_OR_TRANSACTION_ID;
    private int posServiceToBlockUnblock;
    private int transactionIdOfServiceToBlockUnblock;
    private boolean positiveResponseToBlockUnblockRequest;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$eni$api$online$ServiceListServiceListener;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$eni$api$online$ServiceListService;

    private ASGArrayList getServiceList() {
        if (this._serviceList == null) {
            this._serviceList = new ArrayListFactory().createCompleteArrayList(this, this, this, 1, this.getFunctionId(), true, 4, 0);
        }
        return this._serviceList;
    }

    private ServiceListServiceListener getServiceListServiceListener() {
        return (ServiceListServiceListener)this.getDelegate().getService(class$de$vw$mib$asl$internal$ocu$eni$api$online$ServiceListServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$ServiceListServiceListener = ServiceList.class$("de.vw.mib.asl.internal.ocu.eni.api.online.ServiceListServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$ServiceListServiceListener);
    }

    private BAPFunctionList getFunctionList() {
        return (BAPFunctionList)((Object)this.getDelegate().getBAPFunctionListener(3));
    }

    @Override
    public void initialize(boolean bl) {
        if (bl) {
            this.posServiceToBlockUnblock = -1;
            this.transactionIdOfServiceToBlockUnblock = -1;
            this.positiveResponseToBlockUnblockRequest = false;
            this.getServiceList().reloadData();
        } else {
            this.getDelegate().registerServiceProvider(this, class$de$vw$mib$asl$internal$ocu$eni$api$online$ServiceListService == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$ServiceListService = ServiceList.class$("de.vw.mib.asl.internal.ocu.eni.api.online.ServiceListService")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$ServiceListService, ServiceListService.SERVICE_CONSTANTS);
            this.getDelegate().registerServiceProviderListener(this, class$de$vw$mib$asl$internal$ocu$eni$api$online$ServiceListServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$ServiceListServiceListener = ServiceList.class$("de.vw.mib.asl.internal.ocu.eni.api.online.ServiceListServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$ServiceListServiceListener, ServiceListServiceListener.SERVICE_CONSTANTS);
        }
    }

    @Override
    public void uninitialize() {
        this.getServiceList().stopFetchingData();
        this.updateServiceListData(this.getServiceList(), true);
    }

    @Override
    public int getFunctionId() {
        return 22;
    }

    @Override
    public void requestError(int n, BAPFunction bAPFunction) {
        switch (n) {
            case 34: {
                this.getServiceList().error(-1);
                break;
            }
            case 33: {
                this.getServiceList().error(-2);
                break;
            }
            case 67: {
                this.getServiceList().error(-3);
                break;
            }
            case 66: {
                this.getServiceList().error(-4);
                this.updateServiceListData(this.getServiceList(), true);
                break;
            }
            default: {
                this.getLogger().warn(256).append("ServiceList: ignore got error code = ").append(n).log();
            }
        }
    }

    @Override
    public void statusArray(BAPStatusArray bAPStatusArray, Array array) {
        this.checkOfPossibleResponseOfModificationRequest(bAPStatusArray);
        this.getServiceList().statusArray(bAPStatusArray);
    }

    @Override
    public void changedArray(BAPChangedArray bAPChangedArray, Array array) {
        this.getServiceList().changedArray(bAPChangedArray);
    }

    @Override
    public BAPGetArray createGetArrayRequest(ASGArrayList aSGArrayList) {
        return new ServiceList_GetArray();
    }

    @Override
    public BAPSetGetArray createSetGetArrayRequest(ASGArrayList aSGArrayList) {
        return new ServiceList_SetGetArray();
    }

    @Override
    public BAPArrayElement createEmptyElement(ASGArrayList aSGArrayList) {
        return new ServiceList_Data(new ArrayHeader());
    }

    @Override
    public BAPArrayElement mergeArrayElementAttributes(ASGArrayList aSGArrayList, BAPArrayElement bAPArrayElement, BAPArrayElement bAPArrayElement2, int n) {
        ServiceList_Data serviceList_Data = (ServiceList_Data)bAPArrayElement;
        ServiceList_Data serviceList_Data2 = (ServiceList_Data)bAPArrayElement2;
        switch (n) {
            case 1: {
                serviceList_Data2 = serviceList_Data;
                break;
            }
            case 2: {
                serviceList_Data2.serviceId.setContent(serviceList_Data.serviceId);
                serviceList_Data2.userSettings.serviceActivatedAllowedByDriver = serviceList_Data.userSettings.serviceActivatedAllowedByDriver;
                break;
            }
            default: {
                this.getLogger().error(256, "ServiceList: Wrong recordAddress given in mergeArrayElementAttributes");
            }
        }
        return serviceList_Data2;
    }

    @Override
    public Timer createTimer(ASGArrayList aSGArrayList, TimerNotifier timerNotifier, long l) {
        return new TimerObj(timerNotifier, l);
    }

    @Override
    public void elementsInserted(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
        this.updateServiceListData(aSGArrayList);
    }

    @Override
    public void elementsDeleted(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
        this.updateServiceListData(aSGArrayList);
    }

    @Override
    public void elementsUpdated(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
        this.updateServiceListData(aSGArrayList);
        this.checkAndUpdateResponseOfModificationRequest(n);
    }

    @Override
    public void reloaded(ASGArrayList aSGArrayList) {
        this.updateServiceListData(aSGArrayList);
    }

    @Override
    public void requestGetArray(ASGArrayList aSGArrayList, BAPGetArray bAPGetArray) {
        this.getDelegate().getArray(this).getArray(bAPGetArray, this);
    }

    @Override
    public void requestSetGetArray(ASGArrayList aSGArrayList, BAPSetGetArray bAPSetGetArray) {
        this.getDelegate().getArray(this).setGetArray(bAPSetGetArray, this);
        this.checkForPossibleRequestBlockingOfService(bAPSetGetArray);
    }

    @Override
    public void requestTimeout(ASGArrayList aSGArrayList, int n, boolean bl) {
        this.getLogger().warn(256).append("ServiceList: request time out counter=").append(n).append(", finished=").append(bl).log();
        if (bl) {
            this.updateServiceListData(aSGArrayList);
        }
    }

    @Override
    public int getMaxRequestableElements(ASGArrayList aSGArrayList, int n) {
        return 1;
    }

    @Override
    public int getDefaultRecordAddress(ASGArrayList aSGArrayList) {
        return 1;
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
        String string2 = "ServiceList: ";
        switch (n) {
            case 1: {
                this.getLogger().fatal(256).append("ServiceList: ").append(string).log();
                break;
            }
            case 2: {
                this.getLogger().error(256).append("ServiceList: ").append(string).log();
                break;
            }
            case 4: {
                this.getLogger().warn(256).append("ServiceList: ").append(string).log();
                break;
            }
            case 8: {
                this.getLogger().info(256).append("ServiceList: ").append(string).log();
                break;
            }
            case 12: {
                this.getLogger().normal(256).append("ServiceList: ").append(string).log();
                break;
            }
            case 16: {
                if (!this.getLogger().isTraceEnabled(256)) break;
                this.getLogger().trace(256).append("ServiceList: ").append(string).log();
                break;
            }
            default: {
                this.getLogger().error(256).append("ServiceList: ").append("Wrong log message called from ASG array list").log();
            }
        }
    }

    private void updateServiceListData(ASGArrayList aSGArrayList, boolean bl) {
        int n = bl ? 1 : (aSGArrayList.isLoadingError() ? 4 : (aSGArrayList.isLoading() ? 2 : 3));
        ArrayList arrayList = new ArrayList();
        if (n != 1) {
            aSGArrayList.getAllElements().addToList(arrayList);
        }
        this.getServiceListServiceListener().updateServiceListData(n, arrayList);
        if (this.getLogger().isTraceEnabled(256)) {
            this.getLogger().trace(256).append("ServiceList: updated with numElements=").append(arrayList.size()).append(", state=").append(n).log();
        }
    }

    private void updateServiceListData(ASGArrayList aSGArrayList) {
        this.updateServiceListData(aSGArrayList, false);
    }

    private void checkForPossibleRequestBlockingOfService(BAPSetGetArray bAPSetGetArray) {
        if (this.posServiceToBlockUnblock != -1 && bAPSetGetArray.getArrayHeader().start == this.posServiceToBlockUnblock) {
            this.transactionIdOfServiceToBlockUnblock = bAPSetGetArray.getTransactionId();
            this.positiveResponseToBlockUnblockRequest = false;
        }
    }

    private void checkOfPossibleResponseOfModificationRequest(BAPStatusArray bAPStatusArray) {
        if (bAPStatusArray.getTransactionId() == this.transactionIdOfServiceToBlockUnblock && this.posServiceToBlockUnblock == bAPStatusArray.getArrayHeader().start) {
            this.positiveResponseToBlockUnblockRequest = true;
        }
    }

    private void checkAndUpdateResponseOfModificationRequest(int n) {
        if (this.positiveResponseToBlockUnblockRequest) {
            this.positiveResponseToBlockUnblockRequest = false;
            this.posServiceToBlockUnblock = -1;
            this.transactionIdOfServiceToBlockUnblock = -1;
            this.getServiceListServiceListener().updateBlockedService(this.getServiceList().get(n));
        }
    }

    private void deactivateService(ServiceList_Data serviceList_Data, boolean bl) {
        if (serviceList_Data.serviceState.disablingByDriverAllowedDf3_3) {
            serviceList_Data.userSettings.serviceActivatedAllowedByDriver = !bl;
            this.posServiceToBlockUnblock = serviceList_Data.getPos();
            this.getServiceList().modifyArrayElement(serviceList_Data, 2);
        } else {
            this.getLogger().warn(256).append("ServiceList: Could not block service, serviceId=").append(serviceList_Data.serviceId.toString()).append(", bockingActive=").append(bl).append(", because the blocking of this service is protected").log();
        }
    }

    @Override
    public void serviceListenerRegistered(int n) {
        if (ServiceListServiceListener.SERVICE_CONSTANTS[0] == n) {
            this.updateServiceListData(this.getServiceList());
        }
    }

    @Override
    public void blockService(String string, boolean bl) {
        boolean bl2 = false;
        Iterator iterator = this.getServiceList().getAllElements().getIterator();
        while (iterator.hasNext()) {
            ServiceList_Data serviceList_Data = (ServiceList_Data)iterator.next();
            if (serviceList_Data.serviceId.toString().compareTo(string) != 0) continue;
            this.deactivateService(serviceList_Data, bl);
            bl2 = true;
            break;
        }
        if (!bl2) {
            this.getLogger().warn(256).append("ServiceList: Could not block service, serviceId=").append(string).append(", bockingActive=").append(bl).log();
        }
    }

    @Override
    public void blockServices(boolean bl) {
        if (!this.getFunctionList().containsFunction(24)) {
            Iterator iterator = this.getServiceList().getAllElements().getIterator();
            while (iterator.hasNext()) {
                ServiceList_Data serviceList_Data = (ServiceList_Data)iterator.next();
                this.deactivateService(serviceList_Data, bl);
            }
        } else if (this.getLogger().isTraceEnabled(256)) {
            this.getLogger().trace(256).append("ServiceList: Blocking all services skipped, because PrivacySetup is used for that").log();
        }
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

