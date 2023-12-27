/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.radio;

import de.vw.mib.bap.mqbab2.common.api.APIFactoryInterface;
import de.vw.mib.bap.mqbab2.common.api.asl.HMIRelevantASLDataPoolAdapter;
import de.vw.mib.bap.mqbab2.common.api.radio.RadioService;
import de.vw.mib.bap.mqbab2.common.api.radio.RadioServiceListener;
import de.vw.mib.bap.mqbab2.common.api.radio.datatypes.RadioCurrentAMStationInfo;
import de.vw.mib.bap.mqbab2.common.api.radio.datatypes.RadioCurrentChannelInfo;
import de.vw.mib.bap.mqbab2.common.api.radio.datatypes.RadioCurrentDABStationInfo;
import de.vw.mib.bap.mqbab2.common.api.radio.datatypes.RadioCurrentFMStationInfo;
import de.vw.mib.bap.mqbab2.common.api.radio.datatypes.RadioCurrentSatRadioText;
import de.vw.mib.bap.mqbab2.common.api.radio.datatypes.RadioCurrentStationIndices;
import de.vw.mib.bap.mqbab2.common.api.radio.datatypes.iterator.asl.AMPresetListASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.radio.datatypes.iterator.asl.DABPresetListASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.radio.datatypes.iterator.asl.FMPresetListASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.radio.datatypes.iterator.asl.ReceptionListASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.radio.datatypes.iterator.asl.SiriusPresetListASLDataPoolIterator;
import de.vw.mib.bap.mqbab2.common.api.radio.datatypes.iterator.asl.TrafficMessageListASLDataPoolIterator;
import de.vw.mib.datapool.ASLDatapool;
import de.vw.mib.genericevents.EventGeneric;
import java.util.Iterator;
import java.util.List;

public class RadioASLDataAdapter
extends HMIRelevantASLDataPoolAdapter
implements RadioService,
RadioCurrentStationIndices,
RadioCurrentAMStationInfo,
RadioCurrentFMStationInfo,
RadioCurrentDABStationInfo,
RadioCurrentChannelInfo,
RadioCurrentSatRadioText {
    private APIFactoryInterface apiFactory;
    private static final int[] RADIO_ASL_PROPERTY_IDS_TO_LISTEN_TO = new int[]{1341, 1317, 1320, 1321, 516301824, 1366, 1371, 1372, 533079040, 1324, 1448, 1424, 1429, 1326, 1325, 1339, 1356, 1357, 1352, 1354, 2482, 2397, 1441, 1327, 3006, 3007, 1328, 1426, 1410, 1444, 3403, 3404, 1443, 1436, 2323, 1409, 1423, 1446, 1445, 1438, 1282, 1449, 1421, 1422, 1412, 1291};
    private static final int[] RADIO_ASL_LIST_ITEM_IDS_TO_LISTEN_TO = new int[]{1454, 1456, 2486, 1455, 1308, 3962, 1451, 1458, 1461, 1270, 1313, 1466};
    private static final int[] RADIO_HMI_EVENT_IDS_TO_LISTEN_TO = new int[]{201, 216, 202, 203, 204};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$common$api$radio$RadioService;

    public RadioASLDataAdapter(APIFactoryInterface aPIFactoryInterface, ASLDatapool aSLDatapool) {
        super(aSLDatapool);
        this.apiFactory = aPIFactoryInterface;
        this.apiFactory.getHMIEventService().addHMIEventListener(this, RADIO_HMI_EVENT_IDS_TO_LISTEN_TO);
    }

    protected APIFactoryInterface getAPIFactory() {
        return this.apiFactory;
    }

    public static Class getServiceClass() {
        return class$de$vw$mib$bap$mqbab2$common$api$radio$RadioService == null ? (class$de$vw$mib$bap$mqbab2$common$api$radio$RadioService = RadioASLDataAdapter.class$("de.vw.mib.bap.mqbab2.common.api.radio.RadioService")) : class$de$vw$mib$bap$mqbab2$common$api$radio$RadioService;
    }

    @Override
    public int getDABRadioListState() {
        return this.getDataPool().getInteger(1341, 0);
    }

    @Override
    public int getAMRadioListState() {
        return this.getDataPool().getInteger(1317, 0);
    }

    @Override
    public String getCurrentAMStationInfoStationName() {
        return RadioASLDataAdapter.getStringListValue(1454, 1);
    }

    @Override
    public String getCurrentAMStationInfoStationShortName() {
        return RadioASLDataAdapter.getStringListValue(1454, 3);
    }

    @Override
    public int getCurrentAMStationInfoFrequency() {
        return RadioASLDataAdapter.getIntegerListValue(1454, 0);
    }

    @Override
    public boolean isHDAvailableForCurrentAMStation() {
        return RadioASLDataAdapter.getBooleanListValue(1454, 2);
    }

    @Override
    public int getCurrentAMStationInfoHDChannelNumber() {
        return RadioASLDataAdapter.getIntegerListValue(1454, 4);
    }

    @Override
    public RadioCurrentAMStationInfo getCurrentAMStationInfo() {
        return this;
    }

    @Override
    public String getCurrentAMRadioTextArtistName() {
        return this.getDataPool().getString(1320, "");
    }

    @Override
    public String getCurrentAMRadioTextTitleName() {
        return this.getDataPool().getString(1321, "");
    }

    @Override
    public int getAmHdRadioState() {
        return this.getDataPool().getInteger(516301824, 3);
    }

    @Override
    public int getFMFrequencyScale() {
        return this.getDataPool().getInteger(1366, 0);
    }

    @Override
    public String getCurrentFMStationInfoStationName() {
        return RadioASLDataAdapter.getStringListValue(1456, 4);
    }

    @Override
    public String getCurrentFMStationInfoStationShortName() {
        return RadioASLDataAdapter.getStringListValue(1456, 5);
    }

    @Override
    public int getCurrentFMStationInfoFrequency() {
        return RadioASLDataAdapter.getIntegerListValue(1456, 0);
    }

    @Override
    public boolean isHDAvailableForCurrentFMStation() {
        return RadioASLDataAdapter.getBooleanListValue(1456, 2);
    }

    @Override
    public int getCurrentFMStationInfoHDChannelNumber() {
        return RadioASLDataAdapter.getIntegerListValue(1456, 6);
    }

    @Override
    public boolean isCurrentFMStationSupportingTaTp() {
        return RadioASLDataAdapter.getBooleanListValue(1456, 1);
    }

    @Override
    public boolean isCurrentFMStationInfoTMCAvailable() {
        return RadioASLDataAdapter.getBooleanListValue(1456, 3);
    }

    @Override
    public RadioCurrentFMStationInfo getCurrentFMStationInfo() {
        return this;
    }

    @Override
    public String getCurrentFMRadioTextArtistName() {
        return this.getDataPool().getString(1371, "");
    }

    @Override
    public String getCurrentFMRadioTextTitleName() {
        return this.getDataPool().getString(1372, "");
    }

    @Override
    public int getFmHdRadioState() {
        return this.getDataPool().getInteger(533079040, 3);
    }

    @Override
    public int getCurrentStationBand() {
        return this.getDataPool().getInteger(1324, 1);
    }

    @Override
    public int getCurrentStationIndicesActivePresetIndex() {
        return RadioASLDataAdapter.getIntegerListValue(2486, 0);
    }

    @Override
    public long getCurrentStationIndicesStationListActiveID() {
        return RadioASLDataAdapter.getLongListValue(2486, 1);
    }

    @Override
    public RadioCurrentStationIndices getCurrentStationIndices() {
        return this;
    }

    @Override
    public boolean isTrafficAnnouncementActive() {
        return this.getDataPool().getBoolean(1448, false);
    }

    @Override
    public int getTrafficAnnouncementSource() {
        return this.getDataPool().getInteger(1424, 0);
    }

    @Override
    public boolean isDABAnnouncementActive() {
        return this.getDataPool().getBoolean(1429, false);
    }

    @Override
    public int getCurrentDABAnnouncementType() {
        return this.getDataPool().getInteger(1326, 0);
    }

    @Override
    public String getCurrentDABAnnouncementStationName() {
        return this.getDataPool().getString(1325, "");
    }

    @Override
    public int getDABEnsembleState() {
        return this.getDataPool().getInteger(1339, 0);
    }

    @Override
    public int getDABServiceState() {
        return this.getDataPool().getInteger(1356, 0);
    }

    @Override
    public int getDABAdditionalServiceState() {
        return this.getDataPool().getInteger(1357, 0);
    }

    @Override
    public String getCurrentDABStationEnsembleName() {
        return RadioASLDataAdapter.getStringListValue(1455, 0);
    }

    @Override
    public String getCurrentDABStationFrequencyLabel() {
        return RadioASLDataAdapter.getStringListValue(1455, 6);
    }

    @Override
    public String getCurrentDABStationServiceShortName() {
        return RadioASLDataAdapter.getStringListValue(1455, 4);
    }

    @Override
    public String getCurrentDABStationSecondaryServiceName() {
        return RadioASLDataAdapter.getStringListValue(1455, 1);
    }

    @Override
    public String getCurrentDABStationSecondaryServiceShortName() {
        return RadioASLDataAdapter.getStringListValue(1455, 2);
    }

    @Override
    public boolean isCurrentDABStationInfoTPAvailable() {
        return RadioASLDataAdapter.getBooleanListValue(1455, 7);
    }

    @Override
    public String getCurrentDABStationServiceProgrammStation() {
        return RadioASLDataAdapter.getStringListValue(1455, 3);
    }

    @Override
    public RadioCurrentDABStationInfo getCurrentDABStationInfo() {
        return this;
    }

    @Override
    public String getCurrentDABRadioTextPlusArtistName() {
        return this.getDataPool().getString(1352, "");
    }

    @Override
    public String getCurrentDABRadioTextPlusTitleName() {
        return this.getDataPool().getString(1354, "");
    }

    @Override
    public boolean isTrafficInformationActive() {
        return this.getDataPool().getBoolean(2482, false);
    }

    @Override
    public int getTrafficInformationFrequencyType() {
        return this.getDataPool().getInteger(2397, 0);
    }

    @Override
    public boolean isPTYAnnouncementActive() {
        return this.getDataPool().getBoolean(1441, false);
    }

    @Override
    public String getCurrentPTYAnnouncementStationName() {
        return this.getDataPool().getString(1327, "");
    }

    @Override
    public int getCurrentPTYAnnouncementFrequency() {
        return this.getDataPool().getInteger(3006, -530972416);
    }

    @Override
    public int getCurrentTAFrequency() {
        return this.getDataPool().getInteger(3007, -530972416);
    }

    @Override
    public String getCurrentTAStationName() {
        return this.getDataPool().getString(1328, "");
    }

    @Override
    public boolean isPiCodingActivated() {
        return this.getDataPool().getBoolean(1426, true);
    }

    @Override
    public Iterator getReceptionList() {
        return new ReceptionListASLDataPoolIterator();
    }

    @Override
    public boolean isRDSSetupOptionEnabled() {
        return this.getDataPool().getBoolean(1410, true);
    }

    @Override
    public boolean isRDSSetupOptionAvailable() {
        return this.getDataPool().getBoolean(1444, true);
    }

    @Override
    public String getCurrentHDRadioPsTitleName() {
        return this.getDataPool().getString(3403, "");
    }

    @Override
    public String getCurrentHDRadioPsArtistName() {
        return this.getDataPool().getString(3404, "");
    }

    @Override
    public boolean isRatioTextPlusActive() {
        return this.getDataPool().getBoolean(1443, false);
    }

    @Override
    public boolean getDABRadioTextPlusActive() {
        return this.getDataPool().getBoolean(1436, false);
    }

    @Override
    public boolean isRadioTextPlusSetupActive() {
        return this.getDataPool().getBoolean(2323, true);
    }

    @Override
    public boolean isRadioTextSetupActive() {
        return this.getDataPool().getBoolean(1409, true);
    }

    @Override
    public int getTPState() {
        return this.getDataPool().getInteger(1423, 0);
    }

    @Override
    public String getCurrentSatChannelName() {
        return RadioASLDataAdapter.getStringListValue(1308, 5);
    }

    @Override
    public String getCurrentSatChannelShortName() {
        return RadioASLDataAdapter.getStringListValue(1308, 18);
    }

    @Override
    public int getCurrentSatChannelNumber() {
        return RadioASLDataAdapter.getIntegerListValue(1308, 6);
    }

    @Override
    public RadioCurrentChannelInfo getCurrentChannelInfo() {
        return this;
    }

    @Override
    public String getCurrentSatRadioTextTitleName() {
        return RadioASLDataAdapter.getStringListValue(3962, 4);
    }

    @Override
    public String getCurrentSatRadioTextShortTitleName() {
        return RadioASLDataAdapter.getStringListValue(3962, 5);
    }

    @Override
    public String getCurrentSatRadioTextArtistName() {
        return RadioASLDataAdapter.getStringListValue(3962, 0);
    }

    @Override
    public String getCurrentSatRadioTextShortArtistName() {
        return RadioASLDataAdapter.getStringListValue(3962, 1);
    }

    @Override
    public String getCurrentSatRadioTextCategoryName() {
        return RadioASLDataAdapter.getStringListValue(3962, 3);
    }

    @Override
    public RadioCurrentSatRadioText getCurrentSatRadioText() {
        return this;
    }

    @Override
    public boolean isRadioSeekActive() {
        return this.getDataPool().getBoolean(1446, false);
    }

    @Override
    public boolean isRadioScanningActive() {
        return this.getDataPool().getBoolean(1445, false);
    }

    @Override
    public boolean isManualModeActive() {
        return this.getDataPool().getBoolean(1438, false);
    }

    @Override
    public Iterator getSiriusPresetList() {
        return new SiriusPresetListASLDataPoolIterator();
    }

    @Override
    public int getSiriusPresetSelectedIndex() {
        return this.getDataPool().getInteger(1282, 0);
    }

    @Override
    public Iterator getDABPresetList() {
        return new DABPresetListASLDataPoolIterator();
    }

    @Override
    public Iterator getAMPresetList() {
        return new AMPresetListASLDataPoolIterator();
    }

    @Override
    public Iterator getFMPresetList() {
        return new FMPresetListASLDataPoolIterator();
    }

    @Override
    public boolean isTrafficMessageRecording() {
        return this.getDataPool().getBoolean(1449, false);
    }

    @Override
    public int getTpMemoListSelectedIndex() {
        return this.getDataPool().getInteger(1421, 0);
    }

    @Override
    public boolean isTpSetupOptionEnabled() {
        return this.getDataPool().getBoolean(1422, false);
    }

    @Override
    public Iterator getTrafficMessages() {
        return new TrafficMessageListASLDataPoolIterator();
    }

    @Override
    public int getScopeOfArrowKeyMode() {
        return this.getDataPool().getInteger(1412, 1);
    }

    @Override
    public int getSatTunerState() {
        return this.getDataPool().getInteger(1291, 1);
    }

    @Override
    public void stopTrafficAnnouncement() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-586940352);
        this.getAPIFactory().getSpeechService().performingBAPAction(1);
    }

    @Override
    public void stopTrafficInformation() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-2079915968);
        this.getAPIFactory().getSpeechService().performingBAPAction(1);
    }

    @Override
    public void startSeek(int n) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setInt(0, n);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-805044160, eventGeneric);
        this.getAPIFactory().getSpeechService().performingBAPAction(1);
    }

    @Override
    public void stopSeek() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-654049216);
        this.getAPIFactory().getSpeechService().performingBAPAction(1);
    }

    @Override
    public void startTargetSeek(int n) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setInt(0, n);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-788266944, eventGeneric);
        this.getAPIFactory().getSpeechService().performingBAPAction(1);
    }

    @Override
    public void stopTargetSeek() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-620494784);
    }

    @Override
    public void stopChangingFrequency() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-754712512);
    }

    @Override
    public void startScan() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-821821376);
        this.getAPIFactory().getSpeechService().performingBAPAction(1);
    }

    @Override
    public void stopScan() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-670826432);
        this.getAPIFactory().getSpeechService().performingBAPAction(1);
    }

    @Override
    public void setTpState(boolean bl) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setBoolean(0, bl);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-888930240, eventGeneric);
    }

    @Override
    public void setRDSSetupOptionState(boolean bl) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setBoolean(0, bl);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-956039104, eventGeneric);
    }

    @Override
    public void activateNextStation() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-1962672064);
        this.getAPIFactory().getSpeechService().performingBAPAction(1);
    }

    @Override
    public void activatePreviousStation() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-1895563200);
        this.getAPIFactory().getSpeechService().performingBAPAction(1);
    }

    @Override
    public void activateNextSatChannel() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(0x4F040040);
        this.getAPIFactory().getSpeechService().performingBAPAction(1);
    }

    @Override
    public void activatePreviousSatChannel() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(1375993920);
        this.getAPIFactory().getSpeechService().performingBAPAction(1);
    }

    @Override
    public void activateStationByID(long l, int n) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setLong(0, l);
        eventGeneric.setInt(1, n);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(0x4A040040, eventGeneric);
        this.getAPIFactory().getSpeechService().performingBAPAction(1);
    }

    @Override
    public void activateDABServiceByID(long l) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setLong(0, l);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-2046558144, eventGeneric);
        this.getAPIFactory().getSpeechService().performingBAPAction(1);
    }

    @Override
    public void activateDABSecondaryServiceByID(long l) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setLong(0, l);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-2080112576, eventGeneric);
        this.getAPIFactory().getSpeechService().performingBAPAction(1);
    }

    @Override
    public void activateStationPreset(int n) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setInt(0, n);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-1811677120, eventGeneric);
        this.getAPIFactory().getSpeechService().performingBAPAction(1);
    }

    @Override
    public void activateSatChannelPreset(int n) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setInt(0, n);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(0x4D040040, eventGeneric);
        this.getAPIFactory().getSpeechService().performingBAPAction(1);
    }

    @Override
    public void activateNextListStation() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-1979449280);
        this.getAPIFactory().getSpeechService().performingBAPAction(1);
    }

    @Override
    public void activatePreviousListStation() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-1929117632);
        this.getAPIFactory().getSpeechService().performingBAPAction(1);
    }

    @Override
    public void activateNextListSatChannel() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(0x50040040);
        this.getAPIFactory().getSpeechService().performingBAPAction(1);
    }

    @Override
    public void activatePreviousListSatChannel() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(1392771136);
        this.getAPIFactory().getSpeechService().performingBAPAction(1);
    }

    @Override
    public void activateSatChannelByID(long l) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setLong(0, l);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(0x4C040040, eventGeneric);
        this.getAPIFactory().getSpeechService().performingBAPAction(1);
    }

    @Override
    public void activateBand(int n) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setInt(0, n);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-2096889792, eventGeneric);
        this.getAPIFactory().getSpeechService().performingBAPAction(0);
    }

    @Override
    public void startUpdateStationList() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-402390976);
    }

    @Override
    public void cancelUpdateStationList() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-1727791040);
    }

    @Override
    public void setManualMode(boolean bl) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        if (bl) {
            eventGeneric.setBoolean(0, true);
        } else {
            eventGeneric.setBoolean(0, false);
        }
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-1023147968, eventGeneric);
    }

    @Override
    public void setTpMemoScreenEntered() {
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-519831488);
    }

    @Override
    public void startFastForwardTrafficMessage(int n) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setInt(0, n);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-1576796096, eventGeneric);
        this.getAPIFactory().getSpeechService().performingBAPAction(1);
    }

    @Override
    public void startRewindTrafficMessage(int n) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setInt(0, n);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-1358692288);
        this.getAPIFactory().getSpeechService().performingBAPAction(1);
    }

    @Override
    public void activateTrafficMessage(int n) {
        EventGeneric eventGeneric = this.getAPIFactory().getEventFactory().newEvent();
        eventGeneric.setInt(0, n);
        this.getAPIFactory().getGenericEventsService().getServiceRegister().triggerObserver(-1778122688, eventGeneric);
        this.getAPIFactory().getSpeechService().performingBAPAction(1);
    }

    @Override
    public void datapoolValueChanged(int n) {
        this._notifyServiceDelegates(n);
    }

    private void _notifyServiceDelegates(int n) {
        List list = this.getRegisteredServiceDelegates(n);
        if (list != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                RadioServiceListener radioServiceListener = (RadioServiceListener)iterator.next();
                radioServiceListener.updateRadioData(this, n);
            }
        }
    }

    @Override
    protected int[] getPropertyIds() {
        return RADIO_ASL_PROPERTY_IDS_TO_LISTEN_TO;
    }

    @Override
    protected int[] getListIds() {
        return RADIO_ASL_LIST_ITEM_IDS_TO_LISTEN_TO;
    }

    @Override
    protected void listValueChanged(int n) {
        this._notifyServiceDelegates(n);
    }

    @Override
    public void addRadioServiceListener(RadioServiceListener radioServiceListener, int[] nArray) {
        this.registerServiceListener((Object)radioServiceListener, nArray);
    }

    @Override
    public void removeRadioServiceListener(RadioServiceListener radioServiceListener, int[] nArray) {
        this.removeServiceListener(radioServiceListener, nArray);
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

