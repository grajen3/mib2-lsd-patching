/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiDab;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioConstants;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioDabTraceUtil;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.dab.DabComponentComparator;
import de.vw.mib.asl.internal.radio.dab.DabEnsembleFrequencyComparator;
import de.vw.mib.asl.internal.radio.dab.DabEnsembleNameComparator;
import de.vw.mib.asl.internal.radio.dab.DabServiceComparator;
import de.vw.mib.asl.internal.radio.dab.EnsembleSyncStateList;
import de.vw.mib.asl.internal.radio.dab.ServiceListWithEmptyLabels;
import de.vw.mib.asl.internal.radio.dab.dsi.DabDsiApi;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataApi;
import de.vw.mib.asl.internal.radio.tile.list.TileStationList;
import de.vw.mib.collections.longs.LongObjectOptHashMap;
import java.util.Arrays;
import java.util.TreeSet;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.DataServiceInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.radio.ServiceInfo;

public class DabTunerState {
    private EnsembleInfo[] mEnsembleList = new EnsembleInfo[0];
    private FrequencyInfo[] mFrequencyList = new FrequencyInfo[1];
    private ServiceInfo[] mServiceList = new ServiceInfo[0];
    private ComponentInfo[] mComponentList = new ComponentInfo[0];
    public DataServiceInfo[] mDataServiceList = new DataServiceInfo[0];
    public LongObjectOptHashMap mBapHmiList = null;
    public static final int DEFAULT_FREQUENCY_INDEX;
    private int mCurrentFrequencyIndex = -1;
    private FrequencyInfo mCurrentFrequency = null;
    private EnsembleInfo mCurrentEnsemble = null;
    private int mEnsembleStatus = 4;
    private ServiceInfo mCurrentService = null;
    private int mServiceState = 0;
    private int mAdditionalServiceState = 0;
    private final int mServiceIndex;
    private boolean mCurrentServiceMuted = false;
    private boolean mCurrentServiceLinkingFm = false;
    private boolean mCurrentServiceLinkingDRM = false;
    private ComponentInfo mCurrentComponent = null;
    public EnsembleSyncStateList mEnsembleSyncStateList = new EnsembleSyncStateList();
    private final DabEnsembleNameComparator mEnsembleNameComparator = new DabEnsembleNameComparator();
    private final DabEnsembleFrequencyComparator ensembleFreqComparator = new DabEnsembleFrequencyComparator();
    private final DabServiceComparator mServiceComparator = new DabServiceComparator(this.mEnsembleNameComparator, 1);
    private final DabComponentComparator mComponentComparator = new DabComponentComparator();
    private final ServiceListWithEmptyLabels mEmptyLabelList = new ServiceListWithEmptyLabels();
    private final EnsembleInfo mDefaultEnsemble = new EnsembleInfo(0, 0, "No Ens", "No Ensemble", "5A", 0, false, false);
    private FrequencyInfo mDefaultFrequency = new FrequencyInfo(0, "5A");
    public boolean mStoreViewEntered = false;
    public ServiceInfo serviceInListStoreView = null;
    public EnsembleInfo ensembleInListStoreView = null;
    static /* synthetic */ Class class$org$dsi$ifc$radio$EnsembleInfo;
    static /* synthetic */ Class class$org$dsi$ifc$radio$ServiceInfo;
    static /* synthetic */ Class class$org$dsi$ifc$radio$ComponentInfo;

    public DabTunerState() {
        this.mServiceIndex = -1;
        this.mFrequencyList[0] = new FrequencyInfo(0, "5A");
    }

    public FrequencyInfo setFrequencyIndexAsCurrentProgram(int n) {
        if (this.mFrequencyList == null) {
            return null;
        }
        this.mCurrentFrequencyIndex = n;
        int n2 = this.mFrequencyList.length;
        if (0 <= n && n < n2) {
            this.mCurrentFrequency = this.mFrequencyList[n];
            RadioData.getDabDatabase().mPersistable.setCurrentFrequency(this.mCurrentFrequency);
            this.mCurrentService = null;
            this.mCurrentComponent = null;
            this.mCurrentEnsemble = null;
            return this.mCurrentFrequency;
        }
        return null;
    }

    public void setFrequencyAsCurrentProgram(FrequencyInfo frequencyInfo) {
        this.setCurrentFrequency(frequencyInfo);
        this.mCurrentEnsemble = null;
        this.mCurrentService = null;
        this.mCurrentComponent = null;
        this.calcServiceState();
        this.calcAdditionalServiceState();
    }

    public FrequencyInfo getCurrentFrequencyInfo() {
        return this.mCurrentFrequency;
    }

    public int getFrequencyIndex() {
        return this.mCurrentFrequencyIndex;
    }

    public int findFrequencyIndex(FrequencyInfo frequencyInfo) {
        int n = this.mFrequencyList.length;
        for (int i2 = 0; i2 < n; ++i2) {
            if (this.mFrequencyList[i2].frequency != frequencyInfo.getFrequency()) continue;
            return i2;
        }
        if (frequencyInfo.frequency < this.mFrequencyList[0].frequency) {
            return 0;
        }
        if (frequencyInfo.frequency > this.mFrequencyList[n - 1].frequency) {
            return n - 1;
        }
        return 0;
    }

    public FrequencyInfo setNextFrequencyAsCurrentProgram(boolean bl) {
        if (this.mFrequencyList == null) {
            return null;
        }
        int n = this.mCurrentFrequencyIndex + 1;
        if (n >= this.mFrequencyList.length && bl) {
            if (bl) {
                n = 0;
            } else {
                return null;
            }
        }
        return this.setFrequencyIndexAsCurrentProgram(n);
    }

    public FrequencyInfo setPreviousFrequencyAsCurrentProgram(boolean bl) {
        if (this.mFrequencyList == null) {
            return null;
        }
        int n = this.mCurrentFrequencyIndex - 1;
        int n2 = this.mFrequencyList.length;
        if (n2 == 0) {
            return null;
        }
        if (n < 0) {
            if (bl) {
                n = n2 - 1;
            } else {
                return null;
            }
        }
        return this.setFrequencyIndexAsCurrentProgram(n);
    }

    public void setCurrentFrequency(FrequencyInfo frequencyInfo) {
        this.mCurrentFrequency = frequencyInfo;
        RadioData.getDabDatabase().mPersistable.setCurrentFrequency(this.mCurrentFrequency);
        this.mCurrentFrequencyIndex = -1;
        if (this.mFrequencyList == null || this.mCurrentFrequency == null) {
            this.mCurrentFrequencyIndex = -1;
        } else {
            FrequencyInfo[] frequencyInfoArray = this.mFrequencyList;
            for (int i2 = 0; i2 < frequencyInfoArray.length; ++i2) {
                if (frequencyInfoArray[i2].frequency != this.mCurrentFrequency.frequency) continue;
                this.mCurrentFrequencyIndex = i2;
            }
            if (this.mCurrentFrequencyIndex == -1) {
                this.mCurrentFrequencyIndex = frequencyInfoArray.length - 1;
            }
        }
    }

    public void setCurrentFrequency(int n) {
        if (this.mFrequencyList == null) {
            this.mCurrentFrequency = null;
            RadioData.getDabDatabase().mPersistable.setCurrentFrequency(this.mCurrentFrequency);
            return;
        }
        this.mCurrentFrequencyIndex = n;
        this.mCurrentFrequency = 0 <= n && n < this.mFrequencyList.length ? this.mFrequencyList[n] : null;
        RadioData.getDabDatabase().mPersistable.setCurrentFrequency(this.mCurrentFrequency);
    }

    public FrequencyInfo getNearest(int n) {
        if (this.mFrequencyList == null || this.mFrequencyList.length == 0) {
            return null;
        }
        FrequencyInfo frequencyInfo = null;
        frequencyInfo = n >= 0 && n < this.mFrequencyList.length ? this.mFrequencyList[n] : (n < 0 ? this.mFrequencyList[0] : this.mFrequencyList[this.mFrequencyList.length - 1]);
        return frequencyInfo;
    }

    public FrequencyInfo getFrequencyByValue(long l) {
        for (int i2 = 0; this.mFrequencyList != null && i2 < this.mFrequencyList.length; ++i2) {
            if (l != this.mFrequencyList[i2].frequency) continue;
            return this.mFrequencyList[i2];
        }
        return null;
    }

    public ServiceInfo[] getServiceList() {
        return this.mServiceList;
    }

    public void setServiceList(ServiceInfo[] serviceInfoArray) {
        if (serviceInfoArray != null) {
            TreeSet treeSet = new TreeSet(this.mServiceComparator);
            for (int i2 = 0; i2 < serviceInfoArray.length; ++i2) {
                ServiceInfo serviceInfo = serviceInfoArray[i2];
                if (null == serviceInfo) continue;
                long l = DabTunerState.calcServiceId(serviceInfo.ensID, serviceInfo.ensECC, serviceInfo.sID);
                RadioServiceManager.getServiceManager().getDabEnsembleServiceComponentFrequecyChecker().checkServiceAndName(serviceInfo);
                if (serviceInfo.shortName.trim().length() > 0) {
                    RadioData.getDabDatabase().dabPresetList.setLabels(serviceInfo);
                }
                this.correctEmptyLabels(serviceInfo);
                treeSet.add(serviceInfo);
            }
            RadioDataApi.requestRadioDabStationLogos(serviceInfoArray, 7);
            this.mServiceList = new ServiceInfo[treeSet.size()];
            this.mServiceList = (ServiceInfo[])treeSet.toArray(this.mServiceList);
            if (!(ServiceManager.configManagerDiag.isFeatureFlagSet(348) && RadioDataApi.isSouthSideStationLogoDbActive() && RadioData.getAmfmDatabase().getSettingsPersistable().isAutoStoreLogoActive())) {
                RadioServiceManager.getServiceManager().getAdapterAslSpeech().updateDabServiceListToSpeech();
            }
            try {
                TileStationList tileStationList;
                if (RadioCodingAdapter.isRadioTileFeatureActivated() && !RadioServiceManager.getServiceManager().getTileStationList().isTileSVisible() && RadioCurrentWaveband.isDab() && null != (tileStationList = RadioServiceManager.getServiceManager().getTileStationList())) {
                    tileStationList.initTiles();
                }
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public void setComponentList(ComponentInfo[] componentInfoArray) {
        this.mComponentList = componentInfoArray;
        if (this.mComponentList != null) {
            for (int i2 = 0; i2 < this.mComponentList.length; ++i2) {
                ComponentInfo componentInfo = this.mComponentList[i2];
                if (null == componentInfo) continue;
                RadioServiceManager.getServiceManager().getDabEnsembleServiceComponentFrequecyChecker().checkComponentAndName(componentInfo);
                this.correctEmptyLabels(componentInfo);
            }
        }
        this.calcAdditionalServiceState();
        GuiApiDab.updateAdditionalServiceState(this.mAdditionalServiceState);
    }

    public EnsembleInfo[] getEnsembleList() {
        if (this.mEnsembleList == null) {
            return new EnsembleInfo[0];
        }
        return this.mEnsembleList;
    }

    public FrequencyInfo[] getFrequencyList() {
        return this.mFrequencyList;
    }

    public EnsembleInfo[] getEnsembleListSortedByFreq() {
        if (this.mEnsembleList == null) {
            return new EnsembleInfo[0];
        }
        if (this.mEnsembleList.length == 0) {
            return this.mEnsembleList;
        }
        Object[] objectArray = new EnsembleInfo[this.mEnsembleList.length];
        System.arraycopy((Object)this.mEnsembleList, 0, (Object)objectArray, 0, this.mEnsembleList.length);
        Arrays.sort(objectArray, this.ensembleFreqComparator);
        return objectArray;
    }

    public void setFrequencyList(FrequencyInfo[] frequencyInfoArray) {
        if (frequencyInfoArray != null) {
            for (int i2 = 0; i2 < frequencyInfoArray.length; ++i2) {
                RadioServiceManager.getServiceManager().getDabEnsembleServiceComponentFrequecyChecker().checkFrequencyAndName(frequencyInfoArray[i2]);
            }
            this.mFrequencyList = frequencyInfoArray;
        }
        if (this.mFrequencyList.length > 0) {
            this.mDefaultFrequency = this.mFrequencyList[0];
            this.mDefaultEnsemble.frequencyLabel = this.mDefaultFrequency.getLabel();
            this.mDefaultEnsemble.frequencyValue = (int)this.mDefaultFrequency.getFrequency();
        }
    }

    public void setEnsembleList(EnsembleInfo[] ensembleInfoArray) {
        if (ensembleInfoArray == null || ensembleInfoArray.length == 0) {
            this.mEnsembleList = new EnsembleInfo[0];
        } else {
            TreeSet treeSet = new TreeSet(this.mEnsembleNameComparator);
            for (int i2 = 0; i2 < ensembleInfoArray.length; ++i2) {
                EnsembleInfo ensembleInfo = ensembleInfoArray[i2];
                if (null == ensembleInfo) continue;
                RadioServiceManager.getServiceManager().getDabEnsembleServiceComponentFrequecyChecker().checkEnsembleAndName(ensembleInfo);
                DabTunerState.correctEmptyLabels(ensembleInfo);
                treeSet.add(ensembleInfo);
            }
            this.mEnsembleList = new EnsembleInfo[treeSet.size()];
            this.mEnsembleList = (EnsembleInfo[])treeSet.toArray(this.mEnsembleList);
        }
    }

    public EnsembleInfo getEnsembleById(int n, int n2) {
        if (this.mEnsembleList != null) {
            for (int i2 = 0; i2 < this.mEnsembleList.length; ++i2) {
                EnsembleInfo ensembleInfo = this.mEnsembleList[i2];
                if (null == ensembleInfo || !(n2 != 0 && ensembleInfo.ensECC != 0 ? n2 == ensembleInfo.ensECC && n == ensembleInfo.ensID : n == ensembleInfo.ensID)) continue;
                return ensembleInfo;
            }
        }
        return null;
    }

    public EnsembleInfo getEnsembleBySpeechId(long l) {
        Object object = this.mBapHmiList.get(l);
        if (object != null && object.getClass() == (class$org$dsi$ifc$radio$EnsembleInfo == null ? (class$org$dsi$ifc$radio$EnsembleInfo = DabTunerState.class$("org.dsi.ifc.radio.EnsembleInfo")) : class$org$dsi$ifc$radio$EnsembleInfo)) {
            return (EnsembleInfo)object;
        }
        return null;
    }

    public ServiceInfo getServiceBySpeechId(long l) {
        Object object = this.mBapHmiList.get(l);
        if (object != null && object.getClass() == (class$org$dsi$ifc$radio$ServiceInfo == null ? (class$org$dsi$ifc$radio$ServiceInfo = DabTunerState.class$("org.dsi.ifc.radio.ServiceInfo")) : class$org$dsi$ifc$radio$ServiceInfo)) {
            return (ServiceInfo)object;
        }
        return null;
    }

    public ComponentInfo getComponentBySpeechId(long l) {
        Object object = this.mBapHmiList.get(l);
        if (object != null && object.getClass() == (class$org$dsi$ifc$radio$ComponentInfo == null ? (class$org$dsi$ifc$radio$ComponentInfo = DabTunerState.class$("org.dsi.ifc.radio.ComponentInfo")) : class$org$dsi$ifc$radio$ComponentInfo)) {
            return (ComponentInfo)object;
        }
        return null;
    }

    public EnsembleInfo getEnsemblesByFrequency(FrequencyInfo frequencyInfo) {
        if (this.mEnsembleList != null) {
            for (int i2 = 0; i2 < this.mEnsembleList.length; ++i2) {
                EnsembleInfo ensembleInfo = this.mEnsembleList[i2];
                if (null == ensembleInfo || frequencyInfo.frequency != (long)ensembleInfo.frequencyValue) continue;
                return ensembleInfo;
            }
        }
        return null;
    }

    public FrequencyInfo getFrequencyById(int n, int n2) {
        EnsembleInfo ensembleInfo = this.getEnsembleById(n, n2);
        if (ensembleInfo != null) {
            return this.getFrequencyByValue(ensembleInfo.frequencyValue);
        }
        return null;
    }

    public int getEnsembleIndexById(int n, int n2) {
        if (this.mEnsembleList != null) {
            for (int i2 = 0; i2 < this.mEnsembleList.length; ++i2) {
                EnsembleInfo ensembleInfo = this.mEnsembleList[i2];
                if (null == ensembleInfo || !(n2 != 0 && ensembleInfo.ensECC != 0 ? n2 == ensembleInfo.ensECC && n == ensembleInfo.ensID : n == ensembleInfo.ensID)) continue;
                return i2;
            }
        }
        return -1;
    }

    public void setCurrentEnsemble(EnsembleInfo ensembleInfo) {
        this.mCurrentEnsemble = ensembleInfo;
        RadioData.getDabDatabase().dabPresetList.correctEmptyEnsembleNameByPresetEnsembleName(this.mCurrentEnsemble);
        if (ensembleInfo != null && null != ensembleInfo.fullName) {
            ensembleInfo.fullName = ensembleInfo.fullName.trim();
        }
    }

    public EnsembleInfo getCurrentEnsemble() {
        return this.mCurrentEnsemble;
    }

    public DabServiceComparator getServiceComparator() {
        return this.mServiceComparator;
    }

    public DabEnsembleNameComparator getEnsembleNameComparator() {
        return this.mEnsembleNameComparator;
    }

    public boolean hasAudioServices(EnsembleInfo ensembleInfo) {
        for (int i2 = 0; i2 < this.mServiceList.length; ++i2) {
            ServiceInfo serviceInfo = this.mServiceList[i2];
            if (!DabTunerState.compare(serviceInfo, ensembleInfo)) continue;
            return true;
        }
        return false;
    }

    public static boolean compare(ServiceInfo serviceInfo, EnsembleInfo ensembleInfo) {
        return serviceInfo != null && ensembleInfo != null && (serviceInfo.ensECC != 0 && ensembleInfo.ensECC != 0 ? serviceInfo.ensECC == ensembleInfo.ensECC && serviceInfo.ensID == ensembleInfo.ensID : serviceInfo.ensID == ensembleInfo.ensID);
    }

    public static boolean compare(EnsembleInfo ensembleInfo, ComponentInfo componentInfo) {
        return componentInfo.ensECC != 0 && ensembleInfo.ensECC != 0 ? componentInfo.ensECC == ensembleInfo.ensECC && componentInfo.ensID == ensembleInfo.ensID : componentInfo.ensID == ensembleInfo.ensID;
    }

    public static boolean compare(EnsembleInfo ensembleInfo, EnsembleInfo ensembleInfo2) {
        if (null == ensembleInfo || null == ensembleInfo2) {
            return false;
        }
        if ((long)ensembleInfo.frequencyValue != 0L && (long)ensembleInfo2.frequencyValue != 0L && ensembleInfo.frequencyValue != ensembleInfo2.frequencyValue) {
            return false;
        }
        if (ensembleInfo.ensECC != 0 && ensembleInfo2.ensECC != 0 && ensembleInfo.ensECC != ensembleInfo2.ensECC) {
            return false;
        }
        return ensembleInfo.ensID == ensembleInfo2.ensID;
    }

    public static boolean compare(ServiceInfo serviceInfo, ServiceInfo serviceInfo2) {
        if (serviceInfo == null && serviceInfo2 == null) {
            return true;
        }
        return serviceInfo != null && serviceInfo2 != null && (serviceInfo.ensECC != 0 && serviceInfo2.ensECC != 0 ? serviceInfo.ensECC == serviceInfo2.ensECC && serviceInfo.ensID == serviceInfo2.ensID && serviceInfo.sID == serviceInfo2.sID : serviceInfo.ensID == serviceInfo2.ensID && serviceInfo.sID == serviceInfo2.sID);
    }

    public ServiceInfo[] getServicesByEnsemble(EnsembleInfo ensembleInfo) {
        boolean bl = false;
        TreeSet treeSet = new TreeSet(this.mServiceComparator);
        for (int i2 = 0; i2 < this.mServiceList.length; ++i2) {
            if (DabTunerState.compare(this.mServiceList[i2], ensembleInfo)) {
                treeSet.add(this.mServiceList[i2]);
            }
            if (null == this.mCurrentService || !DabTunerState.compare(this.mCurrentService, this.mServiceList[i2])) continue;
            bl = true;
        }
        if (!bl && DabTunerState.compare(this.mCurrentService, ensembleInfo)) {
            treeSet.add(this.mCurrentService);
        }
        Object[] objectArray = new ServiceInfo[treeSet.size()];
        treeSet.toArray(objectArray);
        return objectArray;
    }

    public ServiceInfo findServiceInList(ServiceInfo serviceInfo) {
        for (int i2 = 0; i2 < this.mServiceList.length; ++i2) {
            if (!DabTunerState.compare(serviceInfo, this.mServiceList[i2])) continue;
            return this.mServiceList[i2];
        }
        return null;
    }

    public EnsembleInfo findEnsembleInList(EnsembleInfo ensembleInfo) {
        for (int i2 = 0; i2 < this.mEnsembleList.length; ++i2) {
            if (!DabTunerState.compare(ensembleInfo, this.mEnsembleList[i2])) continue;
            return this.mEnsembleList[i2];
        }
        return null;
    }

    public void setEnsembleStatus(int n) {
        this.mEnsembleStatus = n;
        if (this.mCurrentEnsemble != null) {
            if (n == 3) {
                this.mEnsembleSyncStateList.setSyncState(this.mCurrentEnsemble, 4);
            } else {
                this.mEnsembleSyncStateList.setSyncState(this.mCurrentEnsemble, n);
            }
        }
    }

    public void setEnsembleStatus(EnsembleInfo ensembleInfo, int n) {
        if (ensembleInfo != null) {
            if (n == 3) {
                this.mEnsembleSyncStateList.setSyncState(ensembleInfo, 4);
            } else {
                this.mEnsembleSyncStateList.setSyncState(ensembleInfo, n);
            }
        }
    }

    public void setServiceMuted(boolean bl) {
        this.mCurrentServiceMuted = bl;
    }

    public boolean isServiceInList(ServiceInfo serviceInfo) {
        for (int i2 = 0; i2 < this.mServiceList.length; ++i2) {
            if (!DabTunerState.compare(serviceInfo, this.mServiceList[i2])) continue;
            return true;
        }
        return false;
    }

    public int getEnsembleStatus() {
        return this.mEnsembleStatus;
    }

    public ServiceInfo getCurrentService() {
        return this.mCurrentService;
    }

    public void SetLinkingMode(int n) {
        switch (n) {
            case 2: {
                this.mCurrentServiceLinkingFm = true;
                this.mCurrentServiceLinkingDRM = false;
                break;
            }
            case 1: {
                this.mCurrentServiceLinkingFm = false;
                this.mCurrentServiceLinkingDRM = false;
                break;
            }
            case 3: {
                this.mCurrentServiceLinkingFm = false;
                this.mCurrentServiceLinkingDRM = true;
                break;
            }
        }
        this.calcServiceState();
        if (this.mCurrentServiceLinkingDRM || this.mCurrentServiceLinkingFm) {
            if (this.mCurrentServiceMuted) {
                RadioData.getDabDatabase().mAudioManager.setMuted(false);
            }
        } else if (this.mCurrentServiceMuted) {
            RadioData.getDabDatabase().mAudioManager.setMuted(true);
        }
    }

    public boolean isServiceMuted() {
        return this.mCurrentServiceMuted;
    }

    public boolean isFmLinkingActive() {
        return this.mCurrentServiceLinkingFm;
    }

    public ServiceInfo getNextService() {
        if (this.mServiceList == null || this.mServiceList.length == 0) {
            return null;
        }
        ServiceInfo serviceInfo = this.getNextServiceOfCurrentEnsemble();
        if (null == serviceInfo) {
            EnsembleInfo ensembleInfo = this.getNextEnsemble(this.mCurrentFrequency.frequency);
            if (ensembleInfo != null) {
                ServiceInfo[] serviceInfoArray = this.getServicesByEnsemble(ensembleInfo);
                if (serviceInfoArray.length > 0) {
                    return serviceInfoArray[0];
                }
                return null;
            }
        } else {
            return serviceInfo;
        }
        return null;
    }

    public ServiceInfo getNextServiceOfCurrentEnsemble() {
        if (this.mCurrentEnsemble != null && this.mCurrentService != null) {
            ServiceInfo[] serviceInfoArray = this.getServicesByEnsemble(this.mCurrentEnsemble);
            for (int i2 = 0; i2 < serviceInfoArray.length; ++i2) {
                if (!DabTunerState.compare(this.mCurrentService, serviceInfoArray[i2])) continue;
                int n = i2 + 1;
                if (n >= serviceInfoArray.length) break;
                return serviceInfoArray[n];
            }
        }
        return null;
    }

    public ServiceInfo getPreviousService() {
        if (this.mServiceList == null || this.mServiceList.length == 0) {
            return null;
        }
        ServiceInfo serviceInfo = this.getPreviousServiceOfCurrentEnsemble();
        if (null == serviceInfo) {
            EnsembleInfo ensembleInfo = this.getPreviousEnsemble(this.mCurrentFrequency.frequency);
            if (ensembleInfo != null) {
                ServiceInfo[] serviceInfoArray = this.getServicesByEnsemble(ensembleInfo);
                if (serviceInfoArray.length > 0) {
                    return serviceInfoArray[serviceInfoArray.length - 1];
                }
                return null;
            }
        } else {
            return serviceInfo;
        }
        return null;
    }

    public ServiceInfo getPreviousServiceOfCurrentEnsemble() {
        if (this.mCurrentEnsemble != null && this.mCurrentService != null) {
            ServiceInfo[] serviceInfoArray = this.getServicesByEnsemble(this.mCurrentEnsemble);
            for (int i2 = 0; i2 < serviceInfoArray.length; ++i2) {
                if (!DabTunerState.compare(this.mCurrentService, serviceInfoArray[i2])) continue;
                int n = i2 - 1;
                if (n < 0) break;
                return serviceInfoArray[n];
            }
        }
        return null;
    }

    public void setCurrentService(ServiceInfo serviceInfo, EnsembleInfo ensembleInfo) {
        this.mCurrentService = serviceInfo;
        RadioData.getDabDatabase().dabPresetList.correctEmptyServiceNameByPresetServiceName(this.mCurrentService);
        if (serviceInfo != RadioConstants.DAB_DEFAULT_SERVICE) {
            this.setCurrentEnsemble(ensembleInfo);
        }
        this.calcServiceState();
        this.calcAdditionalServiceState();
        try {
            TileStationList tileStationList;
            if (RadioCodingAdapter.isRadioTileFeatureActivated() && !RadioServiceManager.getServiceManager().getTileStationList().isStationSelectionByTiles() && RadioCurrentWaveband.isDab() && null != (tileStationList = RadioServiceManager.getServiceManager().getTileStationList())) {
                if (RadioServiceManager.getServiceManager().getTileStationList().isTileSVisible()) {
                    tileStationList.updateSelectedDabService(this.mCurrentService, 1170613248);
                    tileStationList.updateSelectedDabService(this.mCurrentService, 1153836032);
                } else {
                    tileStationList.initTiles();
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void setCurrentService(ServiceInfo serviceInfo, EnsembleInfo ensembleInfo, FrequencyInfo frequencyInfo) {
        this.mCurrentService = serviceInfo;
        RadioData.getDabDatabase().dabPresetList.correctEmptyServiceNameByPresetServiceName(this.mCurrentService);
        if (serviceInfo != RadioConstants.DAB_DEFAULT_SERVICE) {
            this.mCurrentEnsemble = ensembleInfo;
            RadioData.getDabDatabase().dabPresetList.correctEmptyEnsembleNameByPresetEnsembleName(this.mCurrentEnsemble);
            this.mCurrentFrequency = frequencyInfo;
            RadioData.getDabDatabase().mPersistable.setCurrentFrequency(this.mCurrentFrequency);
        }
        this.calcServiceState();
        this.calcAdditionalServiceState();
    }

    public void saveCurrentEnsemble(int n, int n2) {
        EnsembleInfo ensembleInfo = this.getEnsembleById(n, n2);
        this.saveCurrentEnsemble(ensembleInfo);
    }

    public void saveCurrentEnsemble(EnsembleInfo ensembleInfo) {
        EnsembleInfo ensembleInfo2 = RadioData.getDabDatabase().mPersistable.getCurrentEnsemble();
        if (!(ensembleInfo == null || ensembleInfo2 != null && DabTunerState.compare(ensembleInfo2, ensembleInfo))) {
            RadioData.getDabDatabase().mPersistable.setCurrentEnsemble(ensembleInfo);
            this.setCurrentEnsemble(ensembleInfo);
        }
    }

    public void tuneService(ServiceInfo serviceInfo, EnsembleInfo ensembleInfo) {
        if (serviceInfo == RadioConstants.DAB_DEFAULT_SERVICE) {
            RadioData.getDabDatabase().mPersistable.setCurrentService(null);
            RadioData.getDabDatabase().mPersistable.setCurrentComponent(null);
            RadioData.getDabDatabase().mPersistable.setCurrentEnsemble(null);
            this.setCurrentFrequency(this.mDefaultFrequency);
            this.setCurrentService(null, null);
            this.setCurrentComponent(null);
            this.resetReceptionState(true);
        } else {
            this.resetReceptionState(ensembleInfo);
            RadioData.getDabDatabase().mPersistable.setCurrentService(serviceInfo);
            RadioData.getDabDatabase().mPersistable.setCurrentComponent(null);
            this.saveCurrentEnsemble(ensembleInfo);
            this.setCurrentService(serviceInfo, ensembleInfo);
            this.setCurrentComponent(null);
            RadioData.getDabDatabase().mInitialStartup = false;
        }
        if (serviceInfo != null) {
            DabDsiApi.selectService(serviceInfo);
        }
    }

    public void tuneServiceByFrequency(ServiceInfo serviceInfo, EnsembleInfo ensembleInfo, FrequencyInfo frequencyInfo) {
        if (serviceInfo == RadioConstants.DAB_DEFAULT_SERVICE) {
            RadioData.getDabDatabase().mPersistable.setCurrentService(null);
            RadioData.getDabDatabase().mPersistable.setCurrentComponent(null);
            RadioData.getDabDatabase().mPersistable.setCurrentEnsemble(null);
            this.setCurrentFrequency(this.mDefaultFrequency);
            this.setCurrentService(null, null);
            this.setCurrentComponent(null);
            this.resetReceptionState(true);
        } else {
            this.resetReceptionState(ensembleInfo);
            RadioData.getDabDatabase().mPersistable.setCurrentService(serviceInfo);
            RadioData.getDabDatabase().mPersistable.setCurrentComponent(null);
            this.saveCurrentEnsemble(ensembleInfo);
            this.setCurrentService(serviceInfo, ensembleInfo);
            this.setCurrentComponent(null);
            RadioData.getDabDatabase().mInitialStartup = false;
        }
        if (serviceInfo != null) {
            DabDsiApi.selectServiceByFrequency(serviceInfo, frequencyInfo);
        }
    }

    public void resetReceptionState(boolean bl) {
        RadioData.getDabDatabase().mTunerState.SetLinkingMode(1);
        RadioData.getDabDatabase().mTunerState.calcAdditionalServiceState();
        if (bl) {
            this.setEnsembleStatus(4);
            this.setServiceMuted(false);
            GuiApiDab.updateServiceState(this.mServiceState);
            GuiApiDab.updateEnsembleStateToAvailableAndNotMuted();
        }
    }

    public void resetReceptionState(EnsembleInfo ensembleInfo) {
        if (null != ensembleInfo) {
            boolean bl = this.mCurrentEnsemble == null || this.mCurrentEnsemble.ensID != ensembleInfo.ensID;
            this.resetReceptionState(bl);
        }
    }

    public void resetLinkingStatus() {
        this.SetLinkingMode(1);
        GuiApiDab.updateServiceState(this.mServiceState);
    }

    public void tuneDefaultService() {
        this.mServiceState = 0;
        this.tuneService(RadioConstants.DAB_DEFAULT_SERVICE, this.mDefaultEnsemble);
        this.resetReceptionState(true);
        RadioData.getDabDatabase().mInitialStartup = true;
    }

    public void tuneComponent(ComponentInfo componentInfo, ServiceInfo serviceInfo, EnsembleInfo ensembleInfo) {
        this.resetReceptionState(ensembleInfo);
        RadioData.getDabDatabase().mPersistable.setCurrentService(serviceInfo);
        RadioData.getDabDatabase().mPersistable.setCurrentComponent(componentInfo);
        this.setCurrentService(serviceInfo, ensembleInfo);
        this.setCurrentComponent(componentInfo);
        this.saveCurrentEnsemble(ensembleInfo);
        if (componentInfo != null) {
            DabDsiApi.selectComponent(componentInfo);
        }
        RadioData.getDabDatabase().mInitialStartup = false;
    }

    public boolean tuneStationById(long l) {
        Object object = this.mBapHmiList.get(l);
        if (object == null) {
            RadioDabTraceUtil.errorLogDab(new StringBuffer().append("BAP no station at this id: ").append(l).toString());
            GuiApiDab.updateBapCurrentStationIndices(RadioData.getDabDatabase().dabPresetList.getCurrentVisibleIndex(), this.getCurrentStationId());
            return false;
        }
        if (object.getClass() == (class$org$dsi$ifc$radio$ServiceInfo == null ? (class$org$dsi$ifc$radio$ServiceInfo = DabTunerState.class$("org.dsi.ifc.radio.ServiceInfo")) : class$org$dsi$ifc$radio$ServiceInfo)) {
            ServiceInfo serviceInfo = (ServiceInfo)object;
            EnsembleInfo ensembleInfo = this.getEnsembleById(serviceInfo.ensID, serviceInfo.ensECC);
            this.tuneService(serviceInfo, ensembleInfo);
            return true;
        }
        if (object.getClass() == (class$org$dsi$ifc$radio$ComponentInfo == null ? (class$org$dsi$ifc$radio$ComponentInfo = DabTunerState.class$("org.dsi.ifc.radio.ComponentInfo")) : class$org$dsi$ifc$radio$ComponentInfo)) {
            ComponentInfo componentInfo = (ComponentInfo)object;
            EnsembleInfo ensembleInfo = this.getEnsembleById(componentInfo.ensID, componentInfo.ensECC);
            ServiceInfo serviceInfo = this.getServiceById(componentInfo.ensID, componentInfo.ensECC, componentInfo.sID);
            this.tuneComponent(componentInfo, serviceInfo, ensembleInfo);
            return true;
        }
        if (object.getClass() == (class$org$dsi$ifc$radio$EnsembleInfo == null ? (class$org$dsi$ifc$radio$EnsembleInfo = DabTunerState.class$("org.dsi.ifc.radio.EnsembleInfo")) : class$org$dsi$ifc$radio$EnsembleInfo)) {
            EnsembleInfo ensembleInfo = (EnsembleInfo)object;
            ServiceInfo[] serviceInfoArray = this.getServicesByEnsemble(ensembleInfo);
            if (serviceInfoArray.length == 0) {
                return false;
            }
            this.tuneService(serviceInfoArray[0], ensembleInfo);
            return true;
        }
        RadioDabTraceUtil.errorLogDab(new StringBuffer().append("BAP no valid station class: ").append(object.getClass().toString()).toString());
        GuiApiDab.updateBapCurrentStationIndices(RadioData.getDabDatabase().dabPresetList.getCurrentVisibleIndex(), this.getCurrentStationId());
        return false;
    }

    public static boolean compare(ServiceInfo serviceInfo, ComponentInfo componentInfo) {
        if (serviceInfo.ensECC != 0 && componentInfo.ensECC != 0 && serviceInfo.ensECC != componentInfo.ensECC) {
            return false;
        }
        return serviceInfo.ensID == componentInfo.ensID && serviceInfo.sID == componentInfo.sID;
    }

    static boolean compare(ServiceInfo serviceInfo, DataServiceInfo dataServiceInfo) {
        if (serviceInfo.ensECC != 0 && dataServiceInfo.ensECC != 0 && serviceInfo.ensECC != dataServiceInfo.ensECC) {
            return false;
        }
        return serviceInfo.ensID == dataServiceInfo.ensID && serviceInfo.sID == dataServiceInfo.sID;
    }

    public boolean containsAdditionalServices(ServiceInfo serviceInfo) {
        if (serviceInfo == null) {
            return false;
        }
        if (this.mComponentList != null) {
            for (int i2 = 0; i2 < this.mComponentList.length; ++i2) {
                if (!DabTunerState.compare(serviceInfo, this.mComponentList[i2])) continue;
                return true;
            }
        }
        return false;
    }

    public ComponentInfo[] getComponentsByService(ServiceInfo serviceInfo) {
        if (this.mComponentList != null) {
            TreeSet treeSet = new TreeSet(this.mComponentComparator);
            for (int i2 = 0; i2 < this.mComponentList.length; ++i2) {
                ComponentInfo componentInfo = this.mComponentList[i2];
                if (!DabTunerState.compare(componentInfo, serviceInfo)) continue;
                treeSet.add(componentInfo);
            }
            Object[] objectArray = new ComponentInfo[treeSet.size()];
            treeSet.toArray(objectArray);
            return objectArray;
        }
        return new ComponentInfo[0];
    }

    public ComponentInfo[] getComponentList() {
        return this.mComponentList;
    }

    public static boolean compare(ComponentInfo componentInfo, ServiceInfo serviceInfo) {
        if (componentInfo.ensECC != 0 && serviceInfo.ensECC != 0 && componentInfo.ensECC != serviceInfo.ensECC) {
            return false;
        }
        return componentInfo.ensID == serviceInfo.ensID && componentInfo.sID == serviceInfo.sID;
    }

    public static boolean compare(ComponentInfo componentInfo, ComponentInfo componentInfo2) {
        if (componentInfo.ensECC != 0 && componentInfo2.ensECC != 0 && componentInfo.ensECC != componentInfo2.ensECC) {
            return false;
        }
        return componentInfo.ensID == componentInfo2.ensID && componentInfo.sID == componentInfo2.sID && componentInfo.sCIDI == componentInfo2.sCIDI;
    }

    static boolean compare(FrequencyInfo frequencyInfo, FrequencyInfo frequencyInfo2) {
        return frequencyInfo.frequency == frequencyInfo2.frequency;
    }

    public int getCurrentServiceState() {
        return this.mServiceState;
    }

    public boolean hasSlideShowServices(ServiceInfo serviceInfo) {
        if (serviceInfo != null && this.mDataServiceList != null) {
            for (int i2 = 0; i2 < this.mDataServiceList.length; ++i2) {
                if (!DabTunerState.compare(serviceInfo, this.mDataServiceList[i2]) || this.mDataServiceList[i2].type != 2) continue;
                return true;
            }
        }
        return false;
    }

    public boolean hasComponents(ServiceInfo serviceInfo) {
        if (this.mComponentList == null) {
            return false;
        }
        for (int i2 = 0; i2 < this.mComponentList.length; ++i2) {
            if (!DabTunerState.compare(serviceInfo, this.mComponentList[i2]) || this.mComponentList[i2].primaryService) continue;
            return true;
        }
        return false;
    }

    public void calcServiceState() {
        this.mServiceState = this.mCurrentEnsemble == null || this.mCurrentService == null ? 1 : (this.mCurrentServiceLinkingFm ? 3 : (this.mCurrentEnsemble != null && (this.mEnsembleStatus == 2 || this.mEnsembleStatus == 1) ? 1 : (this.mCurrentEnsemble != null && this.mEnsembleStatus == 3 ? 1 : (this.mCurrentServiceMuted ? 1 : 0))));
    }

    public void calcAdditionalServiceState() {
        this.mAdditionalServiceState = this.mCurrentComponent != null && !this.mCurrentComponent.primaryService ? 2 : (this.mCurrentService != null && this.hasComponents(this.mCurrentService) ? 1 : 0);
    }

    public int getAdditionalServiceState() {
        return this.mAdditionalServiceState;
    }

    public ServiceInfo getServiceById(int n, int n2, long l) {
        for (int i2 = 0; i2 < this.mServiceList.length; ++i2) {
            ServiceInfo serviceInfo = this.mServiceList[i2];
            if (n2 != 0 && serviceInfo.ensECC != 0 && n2 != serviceInfo.ensECC || serviceInfo.ensID != n || serviceInfo.sID != l) continue;
            return serviceInfo;
        }
        return null;
    }

    public ServiceInfo getNextService(boolean bl, boolean bl2) {
        if (this.mCurrentService == null) {
            return this.mServiceList[0];
        }
        return null;
    }

    public void setCurrentComponent(ComponentInfo componentInfo) {
        this.mCurrentComponent = componentInfo;
        if (componentInfo != null) {
            ServiceInfo serviceInfo = this.getServiceById(componentInfo.ensID, componentInfo.ensECC, componentInfo.sID);
            EnsembleInfo ensembleInfo = null;
            if (serviceInfo != null) {
                ensembleInfo = this.getEnsembleById(serviceInfo.ensID, serviceInfo.ensECC);
            }
            this.setCurrentService(serviceInfo, ensembleInfo);
        }
        this.calcServiceState();
        this.calcAdditionalServiceState();
    }

    public ComponentInfo getCurrentComponent() {
        return this.mCurrentComponent;
    }

    public ComponentInfo getNextComponentOfService(ServiceInfo serviceInfo) {
        if (serviceInfo == null) {
            return null;
        }
        ComponentInfo[] componentInfoArray = this.getComponentsByService(serviceInfo);
        if (componentInfoArray == null) {
            return null;
        }
        int n = 0;
        if (this.mCurrentComponent != null) {
            for (int i2 = 0; i2 < componentInfoArray.length; ++i2) {
                if (!DabTunerState.compare(componentInfoArray[i2], this.mCurrentComponent)) continue;
                n = i2 + 1;
                break;
            }
        }
        if (n < componentInfoArray.length) {
            return componentInfoArray[n];
        }
        return null;
    }

    public ComponentInfo getPreviousComponentOfService(ServiceInfo serviceInfo) {
        if (serviceInfo == null) {
            return null;
        }
        ComponentInfo[] componentInfoArray = this.getComponentsByService(serviceInfo);
        if (componentInfoArray == null) {
            return null;
        }
        int n = 0;
        if (this.mCurrentComponent != null) {
            for (int i2 = 0; i2 < componentInfoArray.length; ++i2) {
                if (!DabTunerState.compare(componentInfoArray[i2], this.mCurrentComponent)) continue;
                n = i2 - 1;
                break;
            }
        }
        if (n < componentInfoArray.length && n >= 0) {
            return componentInfoArray[n];
        }
        return null;
    }

    public int getFrequencyForTicks(int n, int n2) {
        int n3 = (n2 + n) % this.mFrequencyList.length;
        return n3 >= 0 ? n3 : this.mFrequencyList.length + n3;
    }

    public static long calcEnsembleId(int n, int n2) {
        long l = (long)n2 << 32 | (long)n << 16;
        return l;
    }

    public static long calcServiceId(ServiceInfo serviceInfo) {
        if (null != serviceInfo) {
            return DabTunerState.calcServiceId(serviceInfo.ensID, serviceInfo.ensECC, serviceInfo.sID);
        }
        return -1L;
    }

    public static long calcServiceId(int n, int n2, long l) {
        long l2 = l << 40;
        l2 |= (long)n2 << 24;
        return l2 |= (long)(n << 8);
    }

    public static long calcComponentId(int n, long l, int n2, int n3) {
        long l2 = n;
        long l3 = n2;
        return l2 << 56 | l << 32 | (l3 << 16 | (long)n3);
    }

    public static boolean correctEmptyLabels(EnsembleInfo ensembleInfo) {
        boolean bl = false;
        if (ensembleInfo != null) {
            ensembleInfo.shortName = ensembleInfo.shortName.trim();
            ensembleInfo.fullName = ensembleInfo.fullName.trim();
            RadioData.getDabDatabase().dabPresetList.correctEmptyEnsembleNameByPresetEnsembleName(ensembleInfo);
            if (ensembleInfo.fullName.length() == 0) {
                ensembleInfo.fullName = new StringBuffer().append("Ensemble ").append(ensembleInfo.frequencyLabel).toString();
                bl = true;
            }
            if (ensembleInfo.shortName.length() == 0) {
                ensembleInfo.shortName = new StringBuffer().append("Ens ").append(ensembleInfo.frequencyLabel).toString();
                bl = true;
            }
        }
        return bl;
    }

    public boolean correctEmptyLabels(ServiceInfo serviceInfo) {
        serviceInfo.fullName = serviceInfo.fullName.trim();
        serviceInfo.shortName = serviceInfo.shortName.trim();
        RadioData.getDabDatabase().dabPresetList.correctEmptyServiceNameByPresetServiceName(serviceInfo);
        if (serviceInfo.fullName.length() == 0 || serviceInfo.shortName.length() == 0) {
            this.mEmptyLabelList.labelService(serviceInfo);
            return true;
        }
        return false;
    }

    public void correctEmptyLabels(ComponentInfo componentInfo) {
        componentInfo.fullName = componentInfo.fullName.trim();
        componentInfo.shortName = componentInfo.shortName.trim();
        if (componentInfo.fullName.length() == 0 || componentInfo.shortName.length() == 0) {
            this.mEmptyLabelList.labelComponent(componentInfo);
        }
    }

    public boolean isDabLinkingActive() {
        ServiceInfo serviceInfo = RadioData.getDabDatabase().mPersistable.getCurrentService();
        if (this.mCurrentService == null || serviceInfo == null) {
            return false;
        }
        return !DabTunerState.compare(this.mCurrentService, serviceInfo);
    }

    public long getCurrentStationId() {
        if (this.mCurrentComponent != null && this.mCurrentComponent.sCIDI > 0) {
            return DabTunerState.calcComponentId(this.mCurrentComponent.sCIDI, this.mCurrentComponent.sID, this.mCurrentComponent.ensECC, this.mCurrentComponent.ensID);
        }
        if (this.mCurrentService != null && this.mCurrentService.sID > 0L) {
            return DabTunerState.calcServiceId(this.mCurrentService.ensID, this.mCurrentService.ensECC, this.mCurrentService.sID);
        }
        if (this.mCurrentEnsemble != null) {
            return DabTunerState.calcEnsembleId(this.mCurrentEnsemble.ensID, this.mCurrentEnsemble.ensECC);
        }
        return 0L;
    }

    public EnsembleInfo getNextEnsemble(long l) {
        EnsembleInfo[] ensembleInfoArray = this.getEnsembleListSortedByFreq();
        if (ensembleInfoArray == null || ensembleInfoArray.length == 0) {
            return null;
        }
        for (int i2 = 0; i2 < ensembleInfoArray.length; ++i2) {
            if ((long)ensembleInfoArray[i2].frequencyValue <= l) continue;
            return ensembleInfoArray[i2];
        }
        return ensembleInfoArray[0];
    }

    public EnsembleInfo getPreviousEnsemble(long l) {
        EnsembleInfo[] ensembleInfoArray = this.getEnsembleListSortedByFreq();
        if (ensembleInfoArray == null || ensembleInfoArray.length == 0) {
            return null;
        }
        for (int i2 = ensembleInfoArray.length - 1; i2 >= 0; --i2) {
            if ((long)ensembleInfoArray[i2].frequencyValue >= l) continue;
            return ensembleInfoArray[i2];
        }
        return ensembleInfoArray[ensembleInfoArray.length - 1];
    }

    public EnsembleInfo getDefaultEnsemble() {
        return this.mDefaultEnsemble;
    }

    public FrequencyInfo getDefaultFrequency() {
        return this.mDefaultFrequency;
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

