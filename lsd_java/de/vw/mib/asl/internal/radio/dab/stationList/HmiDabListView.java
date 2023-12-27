/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.stationList;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiDab;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioDabTraceUtil;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.dab.DabTunerState;
import de.vw.mib.asl.internal.radio.dab.dsi.DabDsiApi;
import de.vw.mib.asl.internal.radio.dab.main.DabMainApi;
import de.vw.mib.asl.internal.radio.dab.stationList.HmiDabListManager;
import de.vw.mib.asl.internal.radio.util.RadioSystemEventsUtil;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.ServiceInfo;

public class HmiDabListView
extends AbstractTarget {
    HmiDabListManager mManager = new HmiDabListManager();
    boolean active = false;
    boolean waitForJumpLm = false;
    boolean loading = false;
    public static boolean ensembleClosed = false;

    protected HmiDabListView(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    void registerObservers() {
        this.addObservers(new int[]{-1392246720, -1610350528, -1593573312, -1492910016, -1459355584, -2063335360, -1862008768, -1979449280, -1996226496, -1929117632, -1945894848, -1375469504});
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        if (RadioCurrentWaveband.isDab()) {
            switch (eventGeneric.getReceiverEventId()) {
                case 1073743017: {
                    if (this.mManager.isLoaded()) break;
                    if (this.waitForJumpLm) {
                        this.loading = true;
                        DabDsiApi.canceljumpLM();
                        break;
                    }
                    this.openList();
                    this.loading = false;
                    break;
                }
                case 1073743009: {
                    this.closeList();
                    break;
                }
                case 1073743021: {
                    int n = eventGeneric.getInt(0);
                    ensembleClosed = n == -1;
                    if (ServiceManager.logger.isTraceEnabled(256)) {
                        ServiceManager.logger.trace(256).append("ensemble Closed : ").append(ensembleClosed).log();
                    }
                    this.openEnsemble(n);
                    break;
                }
                case 1073743022: {
                    long l = eventGeneric.getLong(0);
                    if (ServiceManager.logger.isTraceEnabled(256)) {
                        ServiceManager.logger.info(256).append("received OPEN_ENSEMBLE_BY_ID with id : ").append(l).log();
                    }
                    this.openEnsembleById(l);
                    RadioSystemEventsUtil.sendOpenEnsembleFinished();
                    break;
                }
                case 1073743015: {
                    int n = eventGeneric.getInt(0);
                    this.openService(n);
                    break;
                }
                case 0x400004A0: {
                    break;
                }
                case 1073742981: {
                    int n = eventGeneric.getInt(0);
                    this.activateService(n);
                    break;
                }
                case 1073742993: {
                    int n = eventGeneric.getInt(0);
                    this.activateComponent(n);
                    break;
                }
                case 1073742986: {
                    if (ServiceManager.logger.isTraceEnabled(256)) {
                        ServiceManager.logger.trace(256).append("received ACTIVATE_NEXT_LIST_STATION with learnMemoryUpdateRunning : ").append(RadioData.getDabDatabase().learnMemoryUpdateRunning).log();
                    }
                    if (RadioData.getDabDatabase().learnMemoryUpdateRunning) break;
                    this.activateNextService();
                    break;
                }
                case 1073742989: {
                    if (ServiceManager.logger.isTraceEnabled(256)) {
                        ServiceManager.logger.trace(256).append("received ACTIVATE_PREVIOUS_LIST_STATION with learnMemoryUpdateRunning : ").append(RadioData.getDabDatabase().learnMemoryUpdateRunning).log();
                    }
                    if (RadioData.getDabDatabase().learnMemoryUpdateRunning) break;
                    this.activatePreviousService();
                    break;
                }
                case 1073742985: {
                    this.activateNextComponent();
                    break;
                }
                case 1073742988: {
                    this.activatePreviousComponent();
                    break;
                }
                case 100003: {
                    this.updateSyncState();
                    break;
                }
                case 100007: {
                    this.updateLinkingState();
                    break;
                }
                case 100002: {
                    this.updateCurrentStationInfo();
                    break;
                }
                case 100004: {
                    this.updateServiceList();
                    break;
                }
                case 100005: {
                    this.updateAdditionalServiceList();
                    break;
                }
                case 100006: {
                    this.updateDataServiceList();
                    break;
                }
                case 100008: {
                    this.updatePresetBank();
                    break;
                }
                case 100009: {
                    if (!this.mManager.isLoaded()) break;
                    this.mManager.resetList();
                    this.mManager.loadEnsembleList();
                    this.updateHmiList(true);
                    break;
                }
                case 100011: {
                    this.waitForJumpLm = true;
                    break;
                }
                case 100010: {
                    if (!this.waitForJumpLm || !this.loading) break;
                    if (!this.mManager.isLoaded()) {
                        this.openList();
                    }
                    this.waitForJumpLm = false;
                    break;
                }
                case 100013: {
                    this.closeList();
                    break;
                }
            }
        }
    }

    private void openList() {
        this.mManager.loadEnsembleList();
        this.updateHmiList(true);
    }

    private void closeList() {
        this.mManager.resetList();
        this.loading = false;
        ensembleClosed = false;
    }

    private void openEnsemble(int n) {
        this.mManager.setOpenedEnsemble(n);
        if (n > -1) {
            this.updateHmiServiceList();
        } else {
            GuiApiDab.updateOpenedEnsembleIndex(n);
        }
    }

    private void openEnsembleById(long l) {
        EnsembleInfo ensembleInfo;
        if (this.mManager.isLoaded() && (ensembleInfo = RadioData.getDabDatabase().mTunerState.getEnsembleBySpeechId(l)) != null && this.mManager.setOpenedEnsemble(ensembleInfo)) {
            this.updateHmiServiceList();
            RadioSystemEventsUtil.sendSelectEnsembleFinished(true);
            return;
        }
        RadioSystemEventsUtil.sendSelectEnsembleFinished(false);
    }

    private void openService(int n) {
        this.mManager.setOpenedService(n);
        this.updateHmiComponentList();
    }

    private void updateServiceList() {
        boolean bl;
        int n = this.mManager.getOpenedEnsembleIndex();
        this.mManager.updateEnsembleAndServiceList();
        boolean bl2 = bl = n != this.mManager.getOpenedEnsembleIndex();
        if (this.mManager.isLoaded()) {
            this.updateHmiList(bl);
        }
    }

    private void updateAdditionalServiceList() {
        this.mManager.updateAdditionalServiceList();
        this.updateHmiComponentList();
        this.updateHmiServiceListElements();
    }

    private void updateDataServiceList() {
        this.mManager.updateDataServiceList();
        this.updateHmiServiceListElements();
        this.updateHmiComponentListElements();
    }

    private void updatePresetBank() {
        this.mManager.updatePresetBank();
        this.updateHmiServiceListElements();
    }

    private void updateCurrentStationInfo() {
        int n = this.mManager.getOpenedEnsembleIndex();
        this.mManager.updateCurrentStationInfo();
        if (this.mManager.isLoaded()) {
            boolean bl = n != this.mManager.getOpenedEnsembleIndex();
            this.updateHmiList(bl);
            this.updateHmiComponentList();
        }
    }

    private void updateSyncState() {
        this.mManager.updateSyncState();
        this.updateHmiEnsembleListElements();
        this.updateHmiServiceListElements();
        this.updateHmiComponentListElements();
    }

    private void updateLinkingState() {
        this.updateHmiEnsembleListElements();
        this.updateHmiServiceListElements();
        this.updateHmiComponentListElements();
    }

    private void activateService(int n) {
        ServiceInfo serviceInfo = this.mManager.getService(n);
        EnsembleInfo ensembleInfo = this.mManager.getOpenedEnsemble();
        if (serviceInfo != null && serviceInfo.sID > 0L) {
            RadioData.getDabDatabase().mTunerState.tuneService(serviceInfo, ensembleInfo);
            DabMainApi.notifyServiceTunedFromList();
            int n2 = this.mManager.getOpenedEnsembleIndex();
            this.mManager.setActiveService(ensembleInfo, serviceInfo);
            if (this.mManager.isLoaded()) {
                boolean bl = n2 != this.mManager.getOpenedEnsembleIndex();
                this.updateHmiList(bl);
            }
        }
    }

    private void activateComponent(int n) {
        EnsembleInfo ensembleInfo = this.mManager.getOpenedEnsemble();
        ServiceInfo serviceInfo = this.mManager.getOpenedService();
        ComponentInfo componentInfo = this.mManager.getComponent(n);
        if (componentInfo != null) {
            RadioData.getDabDatabase().mTunerState.tuneComponent(componentInfo, serviceInfo, ensembleInfo);
        } else {
            RadioData.getDabDatabase().mTunerState.tuneService(serviceInfo, ensembleInfo);
        }
        DabMainApi.notifyServiceTunedFromList();
        this.mManager.setActiveComponent(ensembleInfo, serviceInfo, componentInfo);
        this.updateHmiList(true);
    }

    private void activateNextService() {
        ServiceInfo serviceInfo = this.mManager.getNextService();
        if (serviceInfo != null) {
            this.activateService(serviceInfo);
        }
    }

    private void activatePreviousService() {
        ServiceInfo serviceInfo = this.mManager.getPreviousService();
        if (serviceInfo != null) {
            this.activateService(serviceInfo);
        }
    }

    private void activateService(ServiceInfo serviceInfo) {
        if (serviceInfo != null) {
            ServiceInfo serviceInfo2 = RadioData.getDabDatabase().mTunerState.getCurrentService();
            EnsembleInfo ensembleInfo = RadioData.getDabDatabase().mTunerState.getEnsembleById(serviceInfo.ensID, serviceInfo.ensECC);
            if (serviceInfo2 == null || !DabTunerState.compare(serviceInfo, serviceInfo2)) {
                RadioData.getDabDatabase().mTunerState.tuneService(serviceInfo, ensembleInfo);
                int n = this.mManager.getOpenedEnsembleIndex();
                this.mManager.setActiveService(ensembleInfo, serviceInfo);
                DabMainApi.notifyServiceTunedFromList();
                if (this.mManager.isLoaded()) {
                    boolean bl = n != this.mManager.getOpenedEnsembleIndex();
                    this.updateHmiList(bl);
                }
            }
        }
    }

    private void activateNextComponent() {
        int n = this.mManager.getNextComponentIdx();
        this.activateComponent(n);
    }

    private void activatePreviousComponent() {
        int n = this.mManager.getPreviousComponentIdx();
        this.activateComponent(n);
    }

    private void updateHmiList(boolean bl) {
        GuiApiDab.updateActiveEnsembleIndex(this.mManager.getActiveEnsembleIndex());
        GuiApiDab.updateServiceIndex(this.mManager.getActiveServiceIndex());
        if (bl) {
            GuiApiDab.updateOpenedEnsembleIndex(this.mManager.getOpenedEnsembleIndex());
        }
        Object[] objectArray = this.mManager.getCurrentServiceList();
        RadioDabTraceUtil.DataPoolTraceDab("--- Update Ensemble List");
        Object[] objectArray2 = this.mManager.getCurrentEnsembleList();
        ListManager.getGenericASLList(1460).updateList(objectArray2);
        RadioDabTraceUtil.DataPoolTraceDab(new StringBuffer().append("--- Update Service List (").append(objectArray.length).append(" entries)").toString());
        ListManager.getGenericASLList(1459).updateList(objectArray);
        this.updateHmiComponentList();
        RadioSystemEventsUtil.sendListUpdateFinished();
    }

    private void updateHmiComponentList() {
        if (this.mManager.isServiceOpened()) {
            Object[] objectArray = this.mManager.getCurrentAdditionalServiceList();
            ListManager.getGenericASLList(1457).updateList(objectArray);
            ServiceManager.aslPropertyManager.valueChangedInteger(1337, this.mManager.getActiveComponentIndex());
        }
    }

    private void updateHmiServiceList() {
        GuiApiDab.updateOpenedEnsembleIndex(this.mManager.getOpenedEnsembleIndex());
        GuiApiDab.updateServiceIndex(this.mManager.getActiveServiceIndex());
        Object[] objectArray = this.mManager.getCurrentServiceList();
        RadioDabTraceUtil.DataPoolTraceDab(new StringBuffer().append("--- Update Service List (").append(objectArray.length).append(" entries)").toString());
        ListManager.getGenericASLList(1459).updateList(objectArray);
        RadioSystemEventsUtil.sendListUpdateFinished();
    }

    private void updateHmiServiceListElements() {
        if (this.mManager.isEnsembleOpened()) {
            Object[] objectArray = this.mManager.getCurrentServiceList();
            ListManager.getGenericASLList(1459).updateListItems(0, objectArray);
        }
    }

    private void updateHmiEnsembleListElements() {
        if (this.mManager.isLoaded()) {
            Object[] objectArray = this.mManager.getCurrentEnsembleList();
            ListManager.getGenericASLList(1460).updateListItems(0, objectArray);
        }
    }

    private void updateHmiComponentListElements() {
        if (this.mManager.isServiceOpened()) {
            Object[] objectArray = this.mManager.getCurrentAdditionalServiceList();
            ListManager.getGenericASLList(1457).updateListItems(0, objectArray);
        }
    }
}

