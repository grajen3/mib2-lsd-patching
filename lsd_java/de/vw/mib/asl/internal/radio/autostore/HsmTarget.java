/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.autostore;

import de.vw.mib.asl.api.radio.ASLRadioTargetIds;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.adaptor.AdaptorFactory;
import de.vw.mib.asl.internal.radio.GuiApiDab;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPreset;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetApi;
import de.vw.mib.asl.internal.radio.autostore.StateAutostoreAbort;
import de.vw.mib.asl.internal.radio.autostore.StateAutostoreAm;
import de.vw.mib.asl.internal.radio.autostore.StateAutostoreDab;
import de.vw.mib.asl.internal.radio.autostore.StateAutostoreDone;
import de.vw.mib.asl.internal.radio.autostore.StateAutostoreFm;
import de.vw.mib.asl.internal.radio.autostore.StateAutostoreIdle;
import de.vw.mib.asl.internal.radio.autostore.StateAutostorePrepareAmFM;
import de.vw.mib.asl.internal.radio.autostore.StateAutostorePrepareDab;
import de.vw.mib.asl.internal.radio.autostore.StateAutostoreTop;
import de.vw.mib.asl.internal.radio.comparator.FrequencyHDComparatorChain;
import de.vw.mib.asl.internal.radio.comparator.QualityPIFrequencyHDComparatorChain;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataApi;
import de.vw.mib.collections.longs.LongIntOptHashMap;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.radio.DSIAMFMTuner;
import org.dsi.ifc.radio.DSIDABTuner;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.ServiceInfo;

public final class HsmTarget
extends AbstractASLHsmTarget {
    private Logger logger = ServiceManager.logger;
    int mActiveTunerAtAbort = 1;
    int mCurrentBankIndex = 0;
    final HsmState stateAutostoreTop = new StateAutostoreTop(this, this.hsm, "stateAutostoreTop", this.getWorkStateParent());
    final HsmState stateAutostoreIdle = new StateAutostoreIdle(this, this.hsm, "stateAutostoreIdle", this.stateAutostoreTop);
    final HsmState stateAutostorePrepareAmFm = new StateAutostorePrepareAmFM(this, this.hsm, "stateAutostoreActive", this.stateAutostoreTop);
    final HsmState stateAutostorePrepareDab = new StateAutostorePrepareDab(this, this.hsm, "stateAutostorePrepareDab", this.stateAutostorePrepareAmFm);
    final HsmState stateAutostoreAm = new StateAutostoreAm(this, this.hsm, "stateAutostoreAm", this.stateAutostorePrepareAmFm);
    final HsmState stateAutostoreFm = new StateAutostoreFm(this, this.hsm, "stateAutostoreFm", this.stateAutostorePrepareAmFm);
    final HsmState stateAutostoreDab = new StateAutostoreDab(this, this.hsm, "stateAutostoreDab", this.stateAutostorePrepareAmFm);
    final HsmState stateAutostoreAbort = new StateAutostoreAbort(this, this.hsm, "stateAutostoreAbort", this.stateAutostoreTop);
    final HsmState stateAutostoreDone = new StateAutostoreDone(this, this.hsm, "stateAutostoreDone", this.stateAutostoreTop);
    protected DSIDABTuner mDsiDabTuner;
    protected DSIAMFMTuner mDsiAMFMTuner;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSIDABTuner;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSIDABTunerListener;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSIAMFMTuner;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSIAMFMTunerListener;

    public HsmTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.hsm.verbose = false;
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateAutostoreTop;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        super.gotEvent(eventGeneric);
    }

    void prepareAmFmAutostore() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), ASLRadioTargetIds.ASL_RADIO_HSMTARGET_AMFM, 92733696, -1870200576);
        try {
            this.send(eventGeneric);
        }
        catch (GenericEventException genericEventException) {
            this.getTextLogger().error(128).attachThrowable(genericEventException).log();
        }
    }

    void prepareDabAutostore() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), ASLRadioTargetIds.ASL_RADIO_HSMTARGET_DAB, -1886977792, -1903755008);
        try {
            this.send(eventGeneric);
        }
        catch (GenericEventException genericEventException) {
            this.getTextLogger().error(128).attachThrowable(genericEventException).log();
        }
    }

    static void setTAStatus(boolean bl) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setBoolean(0, bl);
        ServiceManager.eventMain.getServiceRegister().triggerObserver(1319305216, eventGeneric);
    }

    private void storeAmPresets() {
        AmFmStation[] amFmStationArray;
        Object object;
        int n;
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_AUTOSTORE).append("HsmTarget - storeAmPresets()").log();
        }
        AmFmPresetApi.deletePresets(0, true);
        TreeSet treeSet = RadioData.getAmfmDatabase().getAslStationListAM().getListAsTreeSet();
        TreeSet treeSet2 = new TreeSet(QualityPIFrequencyHDComparatorChain.INSTANCE);
        TreeSet treeSet3 = new TreeSet(FrequencyHDComparatorChain.INSTANCE);
        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            AmFmStation amFmStation = new AmFmStation((AmFmStation)iterator.next());
            treeSet2.add(amFmStation);
        }
        Iterator iterator2 = treeSet2.iterator();
        for (n = 0; iterator2.hasNext() && n < RadioData.getAmfmDatabase().getSettingsPersistable().getAmFmNoOfPresets(); ++n) {
            object = new AmFmStation((AmFmStation)iterator2.next());
            treeSet3.add(object);
        }
        object = new ArrayList(0);
        n = 0;
        Iterator iterator3 = treeSet3.iterator();
        while (iterator3.hasNext() && n < RadioData.getAmfmDatabase().getSettingsPersistable().getAmFmNoOfPresets()) {
            amFmStationArray = (AmFmStation[])iterator3.next();
            if (null == amFmStationArray || amFmStationArray.getAslWaveband() != 0) continue;
            if (RadioDataApi.isSouthSideStationLogoDbActive()) {
                AmFmPresetApi.storeAmStationOnPreset(n, (AmFmStation)amFmStationArray, false);
                ((ArrayList)object).add(amFmStationArray);
            } else {
                AmFmPresetApi.storeAmStationOnPreset(n, (AmFmStation)amFmStationArray, true);
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_AUTOSTORE).append(" AM index = ").append(n).append(", quality = ").append(amFmStationArray.getReceptionQuality()).append(", frequency = ").append(amFmStationArray.getFrequency()).log();
            }
            ++n;
        }
        if (RadioDataApi.isSouthSideStationLogoDbActive()) {
            amFmStationArray = (AmFmStation[])((ArrayList)object).toArray(new AmFmStation[((ArrayList)object).size()]);
            RadioDataApi.requestRadioAmStationLogos(amFmStationArray, 3);
        }
        if (this.isTraceEnabled()) {
            this.trace().append(RadioUtil.LOG_PREFIX_AMFM_AUTOSTORE).append("AM autostore done, stored ").append(treeSet.size()).append(" stations").log();
        }
    }

    private void storeFmPresets(int n) {
        AmFmStation[] amFmStationArray;
        Object object;
        int n2;
        Object object2;
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_AUTOSTORE).append("HsmTarget - storeFmPresets()").log();
        }
        AmFmPresetApi.deletePresets(1, true);
        TreeSet treeSet = new TreeSet(QualityPIFrequencyHDComparatorChain.INSTANCE);
        TreeSet treeSet2 = new TreeSet(AmFmFactory.getInstanceEUStationListViewWalker().getFmComparator());
        TreeSet treeSet3 = RadioData.getAmfmDatabase().getAslStationListFM().getListAsTreeSet();
        Iterator iterator = treeSet3.iterator();
        while (iterator.hasNext()) {
            object2 = new AmFmStation((AmFmStation)iterator.next());
            treeSet.add(object2);
            if (!this.logger.isTraceEnabled(128)) continue;
            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_AUTOSTORE).append("HsmTarget - add station to quality set: ").append(((AmFmStation)object2).getName()).append(", ").append(((AmFmStation)object2).getReceptionQuality()).log();
        }
        object2 = treeSet.iterator();
        for (n2 = 0; object2.hasNext() && n2 < RadioData.getAmfmDatabase().getSettingsPersistable().getAmFmNoOfPresets(); ++n2) {
            object = new AmFmStation((AmFmStation)object2.next());
            treeSet2.add(object);
            if (!this.logger.isTraceEnabled(128)) continue;
            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_AUTOSTORE).append("HsmTarget - add station to PI set: ").append(((AmFmStation)object).getName()).append(", ").append(((AmFmStation)object).getReceptionQuality()).log();
        }
        object = new ArrayList(0);
        Iterator iterator2 = treeSet2.iterator();
        n2 = 0;
        while (iterator2.hasNext() && n2 < RadioData.getAmfmDatabase().getSettingsPersistable().getAmFmNoOfPresets()) {
            amFmStationArray = (AmFmStation[])iterator2.next();
            if (null == amFmStationArray || amFmStationArray.getAslWaveband() != 1) continue;
            if (RadioDataApi.isSouthSideStationLogoDbActive()) {
                AmFmPresetApi.storeFmStationOnPreset(n2, (AmFmStation)amFmStationArray, false, false);
                ((ArrayList)object).add(amFmStationArray);
            } else {
                AmFmPresetApi.storeFmStationOnPreset(n2, (AmFmStation)amFmStationArray, false, true);
            }
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_AUTOSTORE).append(" FM index = ").append(n2).append(", quality = ").append(amFmStationArray.getReceptionQuality()).append(", PI = ").append(amFmStationArray.getPi()).append(", frequency = ").append(amFmStationArray.getFrequency()).log();
            }
            ++n2;
        }
        if (RadioDataApi.isSouthSideStationLogoDbActive()) {
            amFmStationArray = (AmFmStation[])((ArrayList)object).toArray(new AmFmStation[((ArrayList)object).size()]);
            RadioDataApi.requestRadioFmStationLogos(amFmStationArray, 4);
        }
        if (this.isTraceEnabled()) {
            this.trace().append(RadioUtil.LOG_PREFIX_AMFM_AUTOSTORE).append("FM autostore done, stored ").append(treeSet3.size()).append(" stations, last index: ").append(n2).log();
        }
    }

    private void storeDabPresets() {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_AUTOSTORE).append("HsmTarget - storeDabPresets()").log();
        }
        RadioData.getDabDatabase().dabPresetList.deleteAllPresets();
        if (RadioData.getDabDatabase().mTunerState.getServiceList().length > 0) {
            boolean bl;
            LongIntOptHashMap longIntOptHashMap = new LongIntOptHashMap();
            int n = 0;
            EnsembleInfo[] ensembleInfoArray = RadioData.getDabDatabase().mTunerState.getEnsembleList();
            ServiceInfo[][] serviceInfoArrayArray = new ServiceInfo[ensembleInfoArray.length][];
            for (int i2 = 0; i2 < ensembleInfoArray.length; ++i2) {
                serviceInfoArrayArray[i2] = RadioData.getDabDatabase().mTunerState.getServicesByEnsemble(ensembleInfoArray[i2]);
            }
            ArrayList arrayList = new ArrayList(0);
            do {
                bl = false;
                block2: for (int i3 = 0; i3 < serviceInfoArrayArray.length && n < RadioData.getAmfmDatabase().getSettingsPersistable().getDabNoOfPresets(); ++i3) {
                    for (int i4 = 0; i4 < serviceInfoArrayArray[i3].length; ++i4) {
                        ServiceInfo serviceInfo = serviceInfoArrayArray[i3][i4];
                        if (longIntOptHashMap.containsKey(serviceInfo.sID)) continue;
                        longIntOptHashMap.put(serviceInfo.sID, 0);
                        if (RadioDataApi.isSouthSideStationLogoDbActive()) {
                            RadioData.getDabDatabase().dabPresetList.setPreset(ensembleInfoArray[i3], serviceInfo, n, false, false);
                            arrayList.add(serviceInfo);
                        } else {
                            RadioData.getDabDatabase().dabPresetList.setPreset(ensembleInfoArray[i3], serviceInfo, n, false, true);
                        }
                        ++n;
                        bl = true;
                        continue block2;
                    }
                }
            } while (bl && n < RadioData.getAmfmDatabase().getSettingsPersistable().getDabNoOfPresets());
            if (this.logger.isTraceEnabled(128)) {
                this.logger.trace(128).append(RadioUtil.LOG_PREFIX_DAB_AUTOSTORE).append("DAB autostore done").log();
            }
            RadioData.getDabDatabase().dabPresetList.setVisibleBankIndex(0);
            if (RadioDataApi.isSouthSideStationLogoDbActive()) {
                ServiceInfo[] serviceInfoArray = (ServiceInfo[])arrayList.toArray(new ServiceInfo[arrayList.size()]);
                RadioDataApi.requestRadioDabStationLogos(serviceInfoArray, 5);
            }
        }
    }

    public void doAutostore(int n) {
        AmFmPresetApi.setUserCanSelectPresetImage(false);
        RadioDataApi.setPersistStationLogosInSouthSideDbUnlocked(false);
        if (!RadioCodingAdapter.isAmDisabled()) {
            this.storeAmPresets();
        }
        this.storeFmPresets(n);
        if (RadioData.getDabDatabase().getDabDeviceFitted()) {
            this.storeDabPresets();
        }
        RadioDataApi.setPersistStationLogosInSouthSideDbUnlocked(true);
        RadioDataApi.requestPersistStationLogosInSouthSideDb();
        AmFmPresetApi.setUserCanSelectPresetImage(true);
    }

    public void setFirstStation() {
        Object object;
        Object object2;
        AmFmPreset amFmPreset = AmFmPresetApi.getPresetByIndex(1, 0);
        if (null != amFmPreset && !amFmPreset.isEmpty()) {
            object2 = amFmPreset.getPresetStation();
            if (object2 == null) {
                object2 = new AmFmStation(amFmPreset.getFrequency());
            } else {
                amFmPreset.updatePresetOnChange();
                RadioData.getAmfmDatabase().setCurrentStation((AmFmStation)object2);
                AmFmFactory.getAslAmfmModelController().updateNewStationListIDAndPresetIndexForBAP(RadioUtil.computeUniqueID((AmFmStation)object2), AmFmPresetApi.getCurrentIndex());
                AmFmFactory.getAslAmfmModelController().updateCurrentStationInfo((AmFmStation)object2);
            }
        }
        if (null != (object2 = AmFmPresetApi.getPresetByIndex(0, 0)) && !((AmFmPreset)object2).isEmpty()) {
            object = ((AmFmPreset)object2).getPresetStation();
            if (object == null) {
                object = new AmFmStation(((AmFmPreset)object2).getFrequency());
            } else {
                RadioData.getAmfmDatabase().setCurrentStation((AmFmStation)object);
            }
        }
        if ((object = RadioData.getDabDatabase().dabPresetList.get(0)) != null) {
            EnsembleInfo ensembleInfo = RadioData.getDabDatabase().mTunerState.getEnsembleById(((ServiceInfo)object).ensID, ((ServiceInfo)object).ensECC);
            RadioData.getDabDatabase().mTunerState.setCurrentService((ServiceInfo)object, ensembleInfo);
            RadioData.getDabDatabase().mPersistable.setCurrentEnsemble(ensembleInfo);
            RadioData.getDabDatabase().mPersistable.setCurrentService((ServiceInfo)object);
            RadioData.getDabDatabase().mPersistable.setCurrentPresetIndexSelectedByHmi(0);
            GuiApiDab.setActivePreset(0);
            GuiApiDab.updatePresetList();
        } else {
            RadioData.getDabDatabase().mTunerState.setCurrentService(null, null);
            RadioData.getDabDatabase().mPersistable.setCurrentEnsemble(null);
            RadioData.getDabDatabase().mPersistable.setCurrentService(null);
            RadioData.getDabDatabase().mPersistable.setCurrentComponent(null);
            GuiApiDab.setActivePreset(-1);
            RadioData.getDabDatabase().mPersistable.setCurrentPresetIndexSelectedByHmi(-1);
        }
    }

    public void registerDSIProxy() {
        this.mDsiDabTuner = (DSIDABTuner)ServiceManager.dsiServiceLocator.getService(this, class$org$dsi$ifc$radio$DSIDABTuner == null ? (class$org$dsi$ifc$radio$DSIDABTuner = HsmTarget.class$("org.dsi.ifc.radio.DSIDABTuner")) : class$org$dsi$ifc$radio$DSIDABTuner);
        DSIListener dSIListener = AdaptorFactory.createDSIListenerMethodAdapter(this, class$org$dsi$ifc$radio$DSIDABTunerListener == null ? (class$org$dsi$ifc$radio$DSIDABTunerListener = HsmTarget.class$("org.dsi.ifc.radio.DSIDABTunerListener")) : class$org$dsi$ifc$radio$DSIDABTunerListener);
        ServiceManager.dsiServiceLocator.addResponseListener(this, class$org$dsi$ifc$radio$DSIDABTunerListener == null ? (class$org$dsi$ifc$radio$DSIDABTunerListener = HsmTarget.class$("org.dsi.ifc.radio.DSIDABTunerListener")) : class$org$dsi$ifc$radio$DSIDABTunerListener, dSIListener);
        this.mDsiAMFMTuner = (DSIAMFMTuner)ServiceManager.dsiServiceLocator.getService(this, class$org$dsi$ifc$radio$DSIAMFMTuner == null ? (class$org$dsi$ifc$radio$DSIAMFMTuner = HsmTarget.class$("org.dsi.ifc.radio.DSIAMFMTuner")) : class$org$dsi$ifc$radio$DSIAMFMTuner);
        DSIListener dSIListener2 = AdaptorFactory.createDSIListenerMethodAdapter(this, class$org$dsi$ifc$radio$DSIAMFMTunerListener == null ? (class$org$dsi$ifc$radio$DSIAMFMTunerListener = HsmTarget.class$("org.dsi.ifc.radio.DSIAMFMTunerListener")) : class$org$dsi$ifc$radio$DSIAMFMTunerListener);
        ServiceManager.dsiServiceLocator.addResponseListener(this, class$org$dsi$ifc$radio$DSIAMFMTunerListener == null ? (class$org$dsi$ifc$radio$DSIAMFMTunerListener = HsmTarget.class$("org.dsi.ifc.radio.DSIAMFMTunerListener")) : class$org$dsi$ifc$radio$DSIAMFMTunerListener, dSIListener2);
    }

    public void registerObservers() {
        this.addObserver(362627328);
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

