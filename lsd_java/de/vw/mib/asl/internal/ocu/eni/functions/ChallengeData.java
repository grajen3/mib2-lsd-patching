/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.eni.functions;

import de.vw.mib.asl.internal.ocu.common.timer.TimerObj;
import de.vw.mib.asl.internal.ocu.eni.api.online.ChallengeDataService;
import de.vw.mib.asl.internal.ocu.eni.api.online.ChallengeDataServiceListener;
import de.vw.mib.asl.internal.ocu.eni.functions.ENIFunction;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.ChallengeData_Data;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.ChallengeData_GetArray;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.ChallengeData_StatusArray;
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
import java.util.ArrayList;

public class ChallengeData
extends ENIFunction
implements ArrayListener,
ASGArrayListFactory,
ASGArrayListChangeNotifier,
ASGArrayListDelegate,
Logger,
ChallengeDataService {
    private static final int CHALLENGE_DATA_MAX_REQUESTABLE_ELEMENTS;
    private static final int HIGH_LEVEL_RETRY_B_NUMBER_OF_RETRIES;
    private static final int HIGH_LEVEL_RETRY_B_RETRY_TIME;
    private ASGArrayList _challengeData;
    private int _hashProcedureVersion = -1;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$eni$api$online$ChallengeDataServiceListener;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$eni$api$online$ChallengeDataService;

    private ASGArrayList getChallengeData() {
        if (this._challengeData == null) {
            this._challengeData = new ArrayListFactory().createCompleteArrayList(this, this, this, 1, this.getFunctionId(), true, 4, 0);
        }
        return this._challengeData;
    }

    private ChallengeDataServiceListener getChallengeDataServiceListener() {
        return (ChallengeDataServiceListener)this.getDelegate().getService(class$de$vw$mib$asl$internal$ocu$eni$api$online$ChallengeDataServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$ChallengeDataServiceListener = ChallengeData.class$("de.vw.mib.asl.internal.ocu.eni.api.online.ChallengeDataServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$ChallengeDataServiceListener);
    }

    @Override
    public void initialize(boolean bl) {
        if (bl) {
            this.getChallengeData().reloadData();
        } else {
            this.getDelegate().registerServiceProvider(this, class$de$vw$mib$asl$internal$ocu$eni$api$online$ChallengeDataService == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$ChallengeDataService = ChallengeData.class$("de.vw.mib.asl.internal.ocu.eni.api.online.ChallengeDataService")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$ChallengeDataService, ChallengeDataService.SERVICE_CONSTANTS);
            this.getDelegate().registerServiceProviderListener(this, class$de$vw$mib$asl$internal$ocu$eni$api$online$ChallengeDataServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$ChallengeDataServiceListener = ChallengeData.class$("de.vw.mib.asl.internal.ocu.eni.api.online.ChallengeDataServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$ChallengeDataServiceListener, ChallengeDataServiceListener.SERVICE_CONSTANTS);
        }
    }

    @Override
    public void uninitialize() {
        this.getChallengeData().stopFetchingData();
        this.updateChallengeData(this.getChallengeData(), true);
    }

    @Override
    public int getFunctionId() {
        return 30;
    }

    @Override
    public void requestError(int n, BAPFunction bAPFunction) {
        switch (n) {
            case 34: {
                this.getChallengeData().error(-1);
                break;
            }
            case 33: {
                this.getChallengeData().error(-2);
                break;
            }
            case 67: {
                this.getChallengeData().error(-3);
                break;
            }
            case 66: {
                this.getChallengeData().error(-4);
                this.updateChallengeData(this.getChallengeData(), true);
                break;
            }
            default: {
                this.getLogger().warn(256).append("ChallengeData: ignore got error code = ").append(n).log();
            }
        }
    }

    @Override
    public void statusArray(BAPStatusArray bAPStatusArray, Array array) {
        ChallengeData_StatusArray challengeData_StatusArray = (ChallengeData_StatusArray)bAPStatusArray;
        this._hashProcedureVersion = challengeData_StatusArray.hashProcedureVersion;
        this.getChallengeData().statusArray(bAPStatusArray);
    }

    @Override
    public void changedArray(BAPChangedArray bAPChangedArray, Array array) {
        this.getChallengeData().changedArray(bAPChangedArray);
    }

    @Override
    public BAPGetArray createGetArrayRequest(ASGArrayList aSGArrayList) {
        ChallengeData_GetArray challengeData_GetArray = new ChallengeData_GetArray();
        challengeData_GetArray.authorizationType = 1;
        return challengeData_GetArray;
    }

    @Override
    public BAPSetGetArray createSetGetArrayRequest(ASGArrayList aSGArrayList) {
        return null;
    }

    @Override
    public BAPArrayElement createEmptyElement(ASGArrayList aSGArrayList) {
        return new ChallengeData_Data(new ArrayHeader());
    }

    @Override
    public BAPArrayElement mergeArrayElementAttributes(ASGArrayList aSGArrayList, BAPArrayElement bAPArrayElement, BAPArrayElement bAPArrayElement2, int n) {
        ChallengeData_Data challengeData_Data = (ChallengeData_Data)bAPArrayElement;
        ChallengeData_Data challengeData_Data2 = (ChallengeData_Data)bAPArrayElement2;
        switch (n) {
            case 1: {
                challengeData_Data2 = challengeData_Data;
                break;
            }
            default: {
                this.getLogger().error(256, "ChallengeData: Wrong recordAddress given in mergeArrayElementAttributes");
            }
        }
        return challengeData_Data2;
    }

    @Override
    public Timer createTimer(ASGArrayList aSGArrayList, TimerNotifier timerNotifier, long l) {
        return new TimerObj(timerNotifier, l);
    }

    @Override
    public void elementsInserted(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
        this.updateChallengeData(aSGArrayList);
    }

    @Override
    public void elementsDeleted(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
        this.updateChallengeData(aSGArrayList);
    }

    @Override
    public void elementsUpdated(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
        this.updateChallengeData(aSGArrayList);
    }

    @Override
    public void reloaded(ASGArrayList aSGArrayList) {
        this.updateChallengeData(aSGArrayList);
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
        this.getLogger().warn(256).append("ChallengeData: request time out counter=").append(n).append(", finished=").append(bl).log();
        if (bl) {
            this.updateChallengeData(aSGArrayList);
        }
    }

    @Override
    public int getMaxRequestableElements(ASGArrayList aSGArrayList, int n) {
        return 5;
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
        String string2 = "ChallengeData: ";
        switch (n) {
            case 1: {
                this.getLogger().fatal(256).append("ChallengeData: ").append(string).log();
                break;
            }
            case 2: {
                this.getLogger().error(256).append("ChallengeData: ").append(string).log();
                break;
            }
            case 4: {
                this.getLogger().warn(256).append("ChallengeData: ").append(string).log();
                break;
            }
            case 8: {
                this.getLogger().info(256).append("ChallengeData: ").append(string).log();
                break;
            }
            case 12: {
                this.getLogger().normal(256).append("ChallengeData: ").append(string).log();
                break;
            }
            case 16: {
                if (!this.getLogger().isTraceEnabled(256)) break;
                this.getLogger().trace(256).append("ChallengeData: ").append(string).log();
                break;
            }
            default: {
                this.getLogger().error(256).append("ChallengeData: ").append("Wrong log message called from ASG array list").log();
            }
        }
    }

    @Override
    public void serviceListenerRegistered(int n) {
        if (ChallengeDataServiceListener.SERVICE_CONSTANTS[0] == n) {
            this.updateChallengeData(this.getChallengeData());
        }
    }

    private void updateChallengeData(ASGArrayList aSGArrayList, boolean bl) {
        int n = bl ? 1 : (aSGArrayList.isLoadingError() ? 4 : (aSGArrayList.isLoading() ? 2 : 3));
        ArrayList arrayList = new ArrayList();
        if (n != 1) {
            aSGArrayList.getAllElements().addToList(arrayList);
        }
        this.getChallengeDataServiceListener().updateChallengeData(n, arrayList, this._hashProcedureVersion);
        if (this.getLogger().isTraceEnabled(256)) {
            this.getLogger().trace(256).append("ChallengeData: updated with numElements=").append(arrayList.size()).append(", state=").append(n).log();
        }
    }

    private void updateChallengeData(ASGArrayList aSGArrayList) {
        if (!aSGArrayList.isLoading()) {
            this.updateChallengeData(aSGArrayList, false);
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

