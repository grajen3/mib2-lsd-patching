/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.eni.functions;

import de.vw.mib.asl.internal.ocu.common.timer.TimerObj;
import de.vw.mib.asl.internal.ocu.eni.api.online.OnlineUpdateListService;
import de.vw.mib.asl.internal.ocu.eni.api.online.OnlineUpdateListServiceListener;
import de.vw.mib.asl.internal.ocu.eni.functions.ENIFunction;
import de.vw.mib.asl.internal.ocu.eni.functions.TriggerRemoteProcess;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.OnlineUpdateList_Data;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.OnlineUpdateList_GetArray;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.OnlineUpdateList_SetGetArray;
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
import de.vw.mib.collections.ObjectIntMultimap;
import de.vw.mib.collections.ints.IntCollection;
import de.vw.mib.desktop.internal.common.ServiceManager;
import java.util.ArrayList;

public class OnlineUpdateList
extends ENIFunction
implements ArrayListener,
ASGArrayListFactory,
ASGArrayListChangeNotifier,
ASGArrayListDelegate,
Logger,
OnlineUpdateListService {
    private static final int ONLINE_UPDATE_LIST_MAX_REQUESTABLE_ELEMENTS;
    private static final int HIGH_LEVEL_RETRY_B_NUMBER_OF_RETRIES;
    private static final int HIGH_LEVEL_RETRY_B_RETRY_TIME;
    public static final String[] LANGUAGES;
    private final ObjectIntMultimap _languageMap = new ObjectIntMultimap();
    public ASGArrayList _onlineUpdateList;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$eni$api$online$OnlineUpdateListServiceListener;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$eni$api$online$OnlineUpdateListService;

    public OnlineUpdateList() {
        this.initLanguages();
    }

    private void initLanguages() {
        int n = LANGUAGES.length;
        for (int i2 = 0; i2 < n; ++i2) {
            this._languageMap.put(LANGUAGES[i2], i2);
        }
    }

    public ASGArrayList getOnlineUpdateList() {
        if (this._onlineUpdateList == null) {
            this._onlineUpdateList = new ArrayListFactory().createCompleteArrayList(this, this, this, 1, this.getFunctionId(), true, 4, 0);
        }
        return this._onlineUpdateList;
    }

    private OnlineUpdateListServiceListener getOnlineUpdateListServiceListener() {
        return (OnlineUpdateListServiceListener)this.getDelegate().getService(class$de$vw$mib$asl$internal$ocu$eni$api$online$OnlineUpdateListServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$OnlineUpdateListServiceListener = OnlineUpdateList.class$("de.vw.mib.asl.internal.ocu.eni.api.online.OnlineUpdateListServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$OnlineUpdateListServiceListener);
    }

    @Override
    public void initialize(boolean bl) {
        if (bl) {
            this.getOnlineUpdateList().reloadData();
        } else {
            this.getDelegate().registerServiceProvider(this, class$de$vw$mib$asl$internal$ocu$eni$api$online$OnlineUpdateListService == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$OnlineUpdateListService = OnlineUpdateList.class$("de.vw.mib.asl.internal.ocu.eni.api.online.OnlineUpdateListService")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$OnlineUpdateListService, OnlineUpdateListService.SERVICE_CONSTANTS);
            this.getDelegate().registerServiceProviderListener(this, class$de$vw$mib$asl$internal$ocu$eni$api$online$OnlineUpdateListServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$eni$api$online$OnlineUpdateListServiceListener = OnlineUpdateList.class$("de.vw.mib.asl.internal.ocu.eni.api.online.OnlineUpdateListServiceListener")) : class$de$vw$mib$asl$internal$ocu$eni$api$online$OnlineUpdateListServiceListener, OnlineUpdateListServiceListener.SERVICE_CONSTANTS);
        }
    }

    @Override
    public void uninitialize() {
        this.getOnlineUpdateList().stopFetchingData();
        this.updateOnlineUpdateListData(this.getOnlineUpdateList(), true);
    }

    @Override
    public int getFunctionId() {
        return 37;
    }

    @Override
    public void requestError(int n, BAPFunction bAPFunction) {
        switch (n) {
            case 34: {
                this.getOnlineUpdateList().error(-1);
                break;
            }
            case 33: {
                this.getOnlineUpdateList().error(-2);
                break;
            }
            case 67: {
                this.getOnlineUpdateList().error(-3);
                break;
            }
            case 66: {
                this.getOnlineUpdateList().error(-4);
                this.updateOnlineUpdateListData(this.getOnlineUpdateList(), true);
                break;
            }
            default: {
                this.getLogger().warn(256).append("OnlineUpdateList: ignore got error code = ").append(n).log();
            }
        }
    }

    @Override
    public void statusArray(BAPStatusArray bAPStatusArray, Array array) {
        this.getOnlineUpdateList().statusArray(bAPStatusArray);
    }

    @Override
    public void changedArray(BAPChangedArray bAPChangedArray, Array array) {
        this.getOnlineUpdateList().changedArray(bAPChangedArray);
    }

    @Override
    public BAPGetArray createGetArrayRequest(ASGArrayList aSGArrayList) {
        return new OnlineUpdateList_GetArray();
    }

    @Override
    public BAPSetGetArray createSetGetArrayRequest(ASGArrayList aSGArrayList) {
        return new OnlineUpdateList_SetGetArray();
    }

    @Override
    public BAPArrayElement createEmptyElement(ASGArrayList aSGArrayList) {
        return new OnlineUpdateList_Data(new ArrayHeader());
    }

    @Override
    public BAPArrayElement mergeArrayElementAttributes(ASGArrayList aSGArrayList, BAPArrayElement bAPArrayElement, BAPArrayElement bAPArrayElement2, int n) {
        OnlineUpdateList_Data onlineUpdateList_Data = (OnlineUpdateList_Data)bAPArrayElement;
        OnlineUpdateList_Data onlineUpdateList_Data2 = (OnlineUpdateList_Data)bAPArrayElement2;
        switch (n) {
            case 1: {
                onlineUpdateList_Data2 = onlineUpdateList_Data;
                break;
            }
            default: {
                this.getLogger().error(256, "OnlineUpdateList: Wrong recordAddress given in mergeArrayElementAttributes");
            }
        }
        return onlineUpdateList_Data2;
    }

    @Override
    public Timer createTimer(ASGArrayList aSGArrayList, TimerNotifier timerNotifier, long l) {
        return new TimerObj(timerNotifier, l);
    }

    @Override
    public void elementsInserted(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
        this.updateOnlineUpdateListData(aSGArrayList);
    }

    @Override
    public void elementsDeleted(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
        this.updateOnlineUpdateListData(aSGArrayList);
    }

    @Override
    public void elementsUpdated(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
        this.updateOnlineUpdateListData(aSGArrayList);
    }

    @Override
    public void reloaded(ASGArrayList aSGArrayList) {
        this.updateOnlineUpdateListData(aSGArrayList);
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
        this.getLogger().warn(256).append("OnlineUpdateList: request time out counter=").append(n).append(", finished=").append(bl).log();
        if (bl) {
            this.updateOnlineUpdateListData(aSGArrayList);
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
        String string2 = "OnlineUpdateList: ";
        switch (n) {
            case 1: {
                this.getLogger().fatal(256).append("OnlineUpdateList: ").append(string).log();
                break;
            }
            case 2: {
                this.getLogger().error(256).append("OnlineUpdateList: ").append(string).log();
                break;
            }
            case 4: {
                this.getLogger().warn(256).append("OnlineUpdateList: ").append(string).log();
                break;
            }
            case 8: {
                this.getLogger().info(256).append("OnlineUpdateList: ").append(string).log();
                break;
            }
            case 12: {
                this.getLogger().normal(256).append("OnlineUpdateList: ").append(string).log();
                break;
            }
            case 16: {
                if (!this.getLogger().isTraceEnabled(256)) break;
                this.getLogger().trace(256).append("OnlineUpdateList: ").append(string).log();
                break;
            }
            default: {
                this.getLogger().error(256).append("OnlineUpdateList: ").append("Wrong log message called from ASG array list").log();
            }
        }
    }

    @Override
    public void serviceListenerRegistered(int n) {
        if (OnlineUpdateListServiceListener.SERVICE_CONSTANTS[0] == n) {
            this.updateOnlineUpdateListData(this.getOnlineUpdateList());
        }
    }

    private void updateOnlineUpdateListData(ASGArrayList aSGArrayList, boolean bl) {
        int n = bl ? 1 : (aSGArrayList.isLoadingError() ? 4 : (aSGArrayList.isLoading() ? 2 : 3));
        ArrayList arrayList = new ArrayList();
        if (n != 1) {
            aSGArrayList.getAllElements().addToList(arrayList);
        }
        this.getOnlineUpdateListServiceListener().updateOnlineUpdateListData(n, arrayList);
        if (this.getLogger().isTraceEnabled(256)) {
            this.getLogger().trace(256).append("OnlineUpdateList: updated with numElements=").append(arrayList.size()).append(", state=").append(n).log();
        }
    }

    private void updateOnlineUpdateListData(ASGArrayList aSGArrayList) {
        boolean bl = false;
        if (!aSGArrayList.isLoading()) {
            String string = ServiceManager.configurationManager.getCurrentGuiLanguage();
            TriggerRemoteProcess triggerRemoteProcess = (TriggerRemoteProcess)this.getDelegate().getBAPFunctionListener(18);
            int n = aSGArrayList.size();
            for (int i2 = 0; i2 < n; ++i2) {
                OnlineUpdateList_Data onlineUpdateList_Data = (OnlineUpdateList_Data)aSGArrayList.get(i2);
                int n2 = onlineUpdateList_Data.language;
                String string2 = LANGUAGES[n2];
                if (string.equals(string2)) continue;
                bl = true;
                IntCollection intCollection = this._languageMap.getAll(string);
                int n3 = 1;
                if (!intCollection.isEmpty()) {
                    n3 = intCollection.toArray()[0];
                }
                triggerRemoteProcess.requestNewLanguage(onlineUpdateList_Data.updateId.toString(), n3);
            }
            if (!bl) {
                this.updateOnlineUpdateListData(aSGArrayList, false);
                this.didChangeValue(null);
            }
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

    static {
        LANGUAGES = new String[]{"de_DE", "en_GB", "en_US", "fr_FR", "it_IT", "es_ES", "pt_PT", "pl_PL", "cs_CZ", "hu_HU", "da_DK", "sv_SE", "fi_FI", "nl_NL", "zh_HK", "ja_JP", "ru_RU", "el_CY", "ko_KR", "fr_CA", "es_US", "pt_PT", "tr_TR", "zh_CN", "zh_HK", "ar_SA", "pt_BR", "ms-MY", "th_TH", "no_NO", "hr_HR", "sr_RS", "sk_SK", "ro_RO", "hi_IN", "in_ID", "az_AZ", "bs_BA", "sl_SI", "bg_BG", "lv_LV", "et_EE", "lt_LT", "uk_UA", "iw_IL", "ca_ES", "gl_ES", "eu_ES", "en_CN", "en_JP", "en_KR", "en_TW"};
    }
}

