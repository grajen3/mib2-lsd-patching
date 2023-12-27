/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.helper;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiTunerCommon;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.has.RadioHASUpdater;
import de.vw.mib.asl.internal.radio.sat.transformer.AlertCollector;
import de.vw.mib.asl.internal.radio.sat.transformer.SimilarContentCollector;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolListener;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolRecord;
import de.vw.mib.asl.internal.radio.sdars.database.ObjectCompare;
import de.vw.mib.asl.internal.radio.sdars.debug.SatLogHandler;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.properties.values.SpellerData;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.radio.bap.transformer.RadioBapCurrentStationIndicesCollector;
import generated.de.vw.mib.asl.internal.radio.sat.transformer.RadioSATCurrentChannelInfoCollector;
import generated.de.vw.mib.asl.internal.radio.sat.transformer.RadioSATRadioTextCollector;
import generated.de.vw.mib.asl.internal.radio.sat.transformer.RadioSATSATAlertInfoCollector;
import org.dsi.ifc.sdars.CategoryInfo;
import org.dsi.ifc.sdars.SeekEntry;
import org.dsi.ifc.sdars.StationInfo;
import org.dsi.ifc.sdars.TrafficWxEntry;

public final class SatModelApi
implements IAslPoolListener {
    private final SatLogHandler mLogHandler;
    private final IAslPool mPool;
    private final ASLPropertyManager mPM;
    private long mCurrentChannelInfoHash = 0L;
    private static final int MAXCHAR;
    private final RadioBapCurrentStationIndicesCollector radioBapCurrentStationIndicesCollector = new RadioBapCurrentStationIndicesCollector();

    public SatModelApi(IAslPool iAslPool, SatLogHandler satLogHandler) {
        this.mPool = iAslPool;
        this.mLogHandler = satLogHandler;
        this.mPM = SatDb.getPropertyManager();
        iAslPool.addListener(6, (IAslPoolListener)this);
        iAslPool.addListener(153, (IAslPoolListener)this);
        iAslPool.addListener(154, (IAslPoolListener)this);
        iAslPool.addListener(174, (IAslPoolListener)this);
        iAslPool.addListener(145, (IAslPoolListener)this);
        iAslPool.addListener(180, (IAslPoolListener)this);
        iAslPool.addListener(175, (IAslPoolListener)this);
        iAslPool.addListener(159, (IAslPoolListener)this);
        iAslPool.addListener(160, (IAslPoolListener)this);
        iAslPool.addListener(155, (IAslPoolListener)this);
        iAslPool.addListener(156, (IAslPoolListener)this);
        iAslPool.addListener(157, (IAslPoolListener)this);
        iAslPool.addListener(158, (IAslPoolListener)this);
        iAslPool.addListener(164, (IAslPoolListener)this);
        iAslPool.addListener(177, (IAslPoolListener)this);
        iAslPool.addListener(184, (IAslPoolListener)this);
        iAslPool.addListener(182, (IAslPoolListener)this);
        iAslPool.addListener(149, (IAslPoolListener)this);
        iAslPool.addListener(140, (IAslPoolListener)this);
        iAslPool.addListener(146, (IAslPoolListener)this);
        iAslPool.addListener(161, (IAslPoolListener)this);
        iAslPool.addListener(165, (IAslPoolListener)this);
        iAslPool.addListener(176, (IAslPoolListener)this);
        iAslPool.addListener(181, (IAslPoolListener)this);
        iAslPool.addListener(179, (IAslPoolListener)this);
        iAslPool.addListener(162, (IAslPoolListener)this);
        iAslPool.addListener(152, (IAslPoolListener)this);
        iAslPool.addListener(186, (IAslPoolListener)this);
        iAslPool.addListener(144, (IAslPoolListener)this);
        iAslPool.addListener(150, (IAslPoolListener)this);
        iAslPool.addListener(143, (IAslPoolListener)this);
        iAslPool.addListener(163, (IAslPoolListener)this);
        iAslPool.addListener(166, (IAslPoolListener)this);
        iAslPool.addListener(167, (IAslPoolListener)this);
        iAslPool.addListener(168, (IAslPoolListener)this);
        iAslPool.addListener(169, (IAslPoolListener)this);
        iAslPool.addListener(170, (IAslPoolListener)this);
        iAslPool.addListener(171, (IAslPoolListener)this);
        iAslPool.addListener(47, (IAslPoolListener)this);
        iAslPool.addListener(11, (IAslPoolListener)this);
        iAslPool.addListener(48, (IAslPoolListener)this);
        iAslPool.addListener(49, (IAslPoolListener)this);
        iAslPool.addListener(172, (IAslPoolListener)this);
        iAslPool.addListener(183, (IAslPoolListener)this);
        iAslPool.addListener(141, (IAslPoolListener)this);
        iAslPool.addListener(142, (IAslPoolListener)this);
        iAslPool.addListener(173, (IAslPoolListener)this);
        iAslPool.addListener(178, (IAslPoolListener)this);
        iAslPool.addListener(147, (IAslPoolListener)this);
        iAslPool.addListener(185, (IAslPoolListener)this);
        iAslPool.addListener(151, (IAslPoolListener)this);
        iAslPool.addListener(148, (IAslPoolListener)this);
        iAslPool.addListener(188, (IAslPoolListener)this);
        iAslPool.addListener(189, (IAslPoolListener)this);
        iAslPool.addListener(190, (IAslPoolListener)this);
        iAslPool.addListener(201, (IAslPoolListener)this);
        iAslPool.addListener(202, (IAslPoolListener)this);
        iAslPool.addListener(192, (IAslPoolListener)this);
        iAslPool.addListener(193, (IAslPoolListener)this);
        iAslPool.addListener(194, (IAslPoolListener)this);
        iAslPool.addListener(195, (IAslPoolListener)this);
        iAslPool.addListener(196, (IAslPoolListener)this);
        iAslPool.addListener(200, (IAslPoolListener)this);
        iAslPool.addListener(197, (IAslPoolListener)this);
        iAslPool.addListener(198, (IAslPoolListener)this);
        iAslPool.addListener(199, (IAslPoolListener)this);
        iAslPool.addListener(203, (IAslPoolListener)this);
        iAslPool.addListener(205, (IAslPoolListener)this);
        iAslPool.addListener(204, (IAslPoolListener)this);
        iAslPool.notifyUpdate(175);
        iAslPool.notifyUpdate(155);
        iAslPool.notifyUpdate(156);
        iAslPool.notifyUpdate(157);
        iAslPool.notifyUpdate(158);
        iAslPool.notifyUpdate(164);
        iAslPool.notifyUpdate(177);
        iAslPool.notifyUpdate(184);
        iAslPool.notifyUpdate(150);
        iAslPool.notifyUpdate(172);
        iAslPool.notifyUpdate(183);
        iAslPool.notifyUpdate(147);
        iAslPool.notifyUpdate(169);
        iAslPool.notifyUpdate(170);
        iAslPool.notifyUpdate(171);
        iAslPool.notifyUpdate(149);
        String string = System.getProperty("de.vw.mib.asl.internal.radio.sdars.phonenumber", "800-643-2112");
        iAslPool.setString(47, string);
        String string2 = System.getProperty("de.vw.mib.asl.internal.radio.sdars.siriusurl", "www.siriusxm.com");
        iAslPool.setString(11, string2);
        String string3 = System.getProperty("de.vw.mib.asl.internal.radio.sdars.affiliateid", "1l3v43Q");
        iAslPool.setString(12, string3);
    }

    private LogMessage getLM() {
        LogMessage logMessage = this.mLogHandler.getLogMsg();
        if (logMessage != null) {
            logMessage.append("-->Model: ");
        }
        return logMessage;
    }

    public void updateSpellerDataForEnteringChannelNumber(String string, String string2, String string3, int n, int n2, int n3, int n4) {
        LogMessage logMessage = this.getLM();
        if (logMessage != null) {
            logMessage.append("SPELLER_DATA_FOR_ENTERING_CHANNEL_NUMBER=[").append("AvaileChars=").append(string).append(",EnteredText=").append(string2).append(",MatchText=").append(string3).append(",MatchCount=").append(n).append(",CursorPos=").append(n2).append(",SelectStart=").append(n3).append(",SelectEnd=").append(n4).append("]").log();
        }
        if (string2.length() >= 3) {
            string = "";
        }
        SpellerData spellerData = new SpellerData(string, string2, string3, n, n2, n3, n4);
        this.mPM.valueChangedSpellerData(1287, spellerData);
    }

    public void updateBapChannelList(StationInfo[] stationInfoArray) {
        if (!RadioCurrentWaveband.isAm() && !RadioCurrentWaveband.isFm()) {
            GuiApiTunerCommon.updateBapReceptionList(stationInfoArray);
            RadioHASUpdater.updateSdarsStationList(stationInfoArray);
        }
    }

    public void updateCurrentChannelInfo(RadioSATCurrentChannelInfoCollector[] radioSATCurrentChannelInfoCollectorArray, boolean bl) {
        long l = ObjectCompare.calcHash(radioSATCurrentChannelInfoCollectorArray);
        if (bl || this.mCurrentChannelInfoHash != l) {
            this.mCurrentChannelInfoHash = l;
            this.mLogHandler.simpleTrace("CURRENT_CHANNEL_INFO_LIST");
            ListManager.getGenericASLList(1308).updateList(radioSATCurrentChannelInfoCollectorArray);
            RadioHASUpdater.updateCurrentSdarsStation(radioSATCurrentChannelInfoCollectorArray[0]);
        }
    }

    public void updatePDT(RadioSATRadioTextCollector[] radioSATRadioTextCollectorArray) {
        this.mLogHandler.simpleTrace("RADIO_TEXT_LIST");
        ListManager.getGenericASLList(3962).updateList(radioSATRadioTextCollectorArray);
    }

    public void updateAlertList(AlertCollector[] alertCollectorArray) {
        this.mLogHandler.simpleTrace("SAT_ALERT_LIST");
        ListManager.getGenericASLList(1309).updateList(alertCollectorArray);
    }

    public void updateManageAlertList(SeekEntry[] seekEntryArray) {
        this.mLogHandler.simpleTrace("MANAGE_ALERT_LIST");
        ListManager.getGenericASLList(1311).updateList(seekEntryArray);
    }

    public void updateChannelFilterCategoryList(CategoryInfo[] categoryInfoArray) {
        this.mLogHandler.simpleTrace("CHANNEL_FILTER_CATEGORY_LIST");
        ListManager.getGenericASLList(1305).updateList(categoryInfoArray);
    }

    public void updateChannelFilterChannelList(StationInfo[] stationInfoArray) {
        this.mLogHandler.simpleTrace("CHANNEL_FILTER_CHANNEL_LIST");
        ListManager.getGenericASLList(1306).updateList(stationInfoArray);
    }

    public Object[] getChannelListItemInfo() {
        return ListManager.getGenericASLList(1307).getDSIObjects();
    }

    public Object[] getCategoryListSubItemInfo() {
        return ListManager.getGenericASLList(314975232).getDSIObjects();
    }

    public void updateChannelListItemInfo(StationInfo[] stationInfoArray) {
        this.mLogHandler.simpleTrace("CHANNEL_LIST_ITEM_INFO");
        ListManager.getGenericASLList(1307).updateList(stationInfoArray);
        RadioServiceManager.getServiceManager().getAdapterAslSpeech().updateSiriusChannelListToSpeech();
    }

    public void updateCurrentChannelListItem(int n, StationInfo stationInfo) {
        if (null == stationInfo) {
            ServiceManager.logger.error(512).append("SatModelApi - updateCurrentChannelListItem() - null == channelListStation").log();
            return;
        }
        this.mLogHandler.simpleTrace("Current CHANNEL_LIST_ITEM_INFO");
        ListManager.getGenericASLList(1307).updateListItem(n, stationInfo);
    }

    public void updateCurrentCategoryListSubItemInfo(int n, StationInfo stationInfo) {
        if (null == stationInfo) {
            ServiceManager.logger.error(512).append("SatModelApi - updateCurrentCategoryListSubItemInfo() - null == channelListStation").log();
            return;
        }
        this.mLogHandler.simpleTrace("Current CATEGORY_LIST_SUB_ITEM_INFO");
        ListManager.getGenericASLList(314975232).updateListItem(n, stationInfo);
    }

    public void updateCategoryListSubItemInfo(StationInfo[] stationInfoArray) {
        if (null == stationInfoArray) {
            ServiceManager.logger.error(512).append("SatModelApi - updateCategoryListSubItemInfo() - null == stationList").log();
            return;
        }
        this.mLogHandler.simpleTrace("CATEGORY_LIST_SUB_ITEM_INFO");
        this.mPool.setObjectArray(213, stationInfoArray);
        ListManager.getGenericASLList(314975232).updateList(stationInfoArray);
    }

    public void updateBapCurrentStationIndices(int n, long l) {
        LogMessage logMessage = this.mLogHandler.getLogMsg();
        if (logMessage != null) {
            logMessage.append("set BAP_CURRENT_STATION_INDICES index=").append(n).append(" channelNo=").append(l).log();
        }
        if (RadioCurrentWaveband.isSdars()) {
            RadioServiceManager.getServiceManager().getGuiBapApi().updateBapCurrentStationIndices(n, l);
        }
    }

    public void updateBapCurrentStationIndices(long l) {
        int n = this.mPool.getInt(156);
        this.updateBapCurrentStationIndices(n, l);
    }

    public void updateCategoryListInfo(CategoryInfo[] categoryInfoArray) {
        this.mLogHandler.simpleTrace("CATEGORY_LIST_INFO");
        ListManager.getGenericASLList(1304).updateList(categoryInfoArray);
    }

    public void updatePresetListInfo(StationInfo[] stationInfoArray) {
        this.mLogHandler.simpleTrace("PRESET_LIST_INFO");
        ListManager.getGenericASLList(1313).updateList(stationInfoArray);
        this.mPool.incInt(65);
    }

    public void updateTrafficMarketList(TrafficWxEntry[] trafficWxEntryArray) {
        this.mLogHandler.simpleTrace("TRAFFIC_MARKET_LIST");
        ListManager.getGenericASLList(1314).updateList(trafficWxEntryArray);
    }

    public void updateAlertInfo(RadioSATSATAlertInfoCollector[] radioSATSATAlertInfoCollectorArray) {
        this.mLogHandler.simpleTrace("SAT_ALERT_INFO");
        ListManager.getGenericASLList(1312).updateList(radioSATSATAlertInfoCollectorArray);
    }

    public void sXMUnsubscriptionPopup(int n) {
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(382084096);
    }

    @Override
    public void notifyUpdate(IAslPool iAslPool, int n, IAslPoolRecord iAslPoolRecord) {
        switch (n) {
            case 140: {
                this.mPM.valueChangedString(3119, iAslPoolRecord.getString());
                break;
            }
            case 141: {
                this.mPM.valueChangedBoolean(1302, iAslPoolRecord.getBoolean());
                break;
            }
            case 142: {
                this.mPM.valueChangedBoolean(1303, iAslPoolRecord.getBoolean());
                break;
            }
            case 143: {
                this.mPM.valueChangedBoolean(1300, iAslPoolRecord.getBoolean());
                break;
            }
            case 144: {
                this.mPM.valueChangedBoolean(1299, iAslPoolRecord.getBoolean());
                break;
            }
            case 145: {
                this.mPM.valueChangedBoolean(1295, iAslPoolRecord.getBoolean());
                break;
            }
            case 146: {
                this.mPM.valueChangedString(1301, iAslPoolRecord.getString());
                break;
            }
            case 147: {
                this.mPM.valueChangedInteger(1291, iAslPoolRecord.getInt());
                break;
            }
            case 148: {
                this.mPM.valueChangedBoolean(3186, iAslPoolRecord.getBoolean());
                break;
            }
            case 149: {
                this.mPM.valueChangedBoolean(1296, iAslPoolRecord.getBoolean());
                break;
            }
            case 150: {
                this.mPM.valueChangedInteger(1279, iAslPoolRecord.getInt());
                break;
            }
            case 151: {
                this.mPM.valueChangedInteger(1292, iAslPoolRecord.getInt());
                break;
            }
            case 152: {
                this.mPM.valueChangedBoolean(1294, iAslPoolRecord.getBoolean());
                break;
            }
            case 153: {
                this.mPM.valueChangedInteger(1271, iAslPoolRecord.getInt());
                break;
            }
            case 154: {
                this.mPM.valueChangedInteger(1272, iAslPoolRecord.getInt());
                break;
            }
            case 155: {
                this.mPM.valueChangedInteger(1278, iAslPoolRecord.getInt());
                break;
            }
            case 156: {
                int n2 = iAslPoolRecord.getInt();
                if (-1 == n2) {
                    n2 = 255;
                }
                this.mPM.valueChangedInteger(1280, n2);
                break;
            }
            case 157: {
                this.mPM.valueChangedInteger(1281, iAslPoolRecord.getInt());
                break;
            }
            case 158: {
                this.mPM.valueChangedInteger(1282, iAslPoolRecord.getInt());
                break;
            }
            case 159: {
                this.mPM.valueChangedString(1276, iAslPoolRecord.getString());
                break;
            }
            case 160: {
                this.mPM.valueChangedString(1277, iAslPoolRecord.getString());
                break;
            }
            case 161: {
                this.mPM.valueChangedString(3120, iAslPoolRecord.getString());
                break;
            }
            case 162: {
                this.mPM.valueChangedString(1286, iAslPoolRecord.getString());
                break;
            }
            case 163: {
                this.mPM.valueChangedString(1288, iAslPoolRecord.getString());
                break;
            }
            case 164: {
                this.mPM.valueChangedInteger(1283, iAslPoolRecord.getInt());
                break;
            }
            case 165: {
                this.mPM.valueChangedInteger(1285, iAslPoolRecord.getInt());
                break;
            }
            case 47: {
                this.mPM.valueChangedString(4016, iAslPoolRecord.getString());
                break;
            }
            case 11: {
                this.mPM.valueChangedString(4017, "www.siriusxm.com");
                break;
            }
            case 48: {
                break;
            }
            case 49: {
                break;
            }
            case 169: {
                break;
            }
            case 170: {
                break;
            }
            case 171: {
                break;
            }
            case 166: 
            case 167: 
            case 168: 
            case 172: {
                int n3 = iAslPool.getInt(172);
                int n4 = n3 == 1 ? 0 : -1;
                this.mPM.valueChangedInteger(1289, n3);
                int n5 = iAslPool.getInt(168);
                if (n5 > 2000) {
                    int n6 = iAslPool.getInt(166);
                    int n7 = iAslPool.getInt(167);
                    this.mPM.valueChangedInteger(3347, n6);
                    this.mPM.valueChangedInteger(3348, n7);
                    this.mPM.valueChangedInteger(3349, n5);
                    break;
                }
                this.mPM.valueChangedInteger(3347, n4);
                this.mPM.valueChangedInteger(3348, n4);
                this.mPM.valueChangedInteger(3349, n4);
                break;
            }
            case 173: {
                this.mPM.valueChangedInteger(1290, iAslPoolRecord.getInt());
                break;
            }
            case 174: {
                this.mPM.valueChangedBoolean(1293, iAslPoolRecord.getBoolean());
                break;
            }
            case 190: {
                this.mPM.valueChangedBoolean(499524608, iAslPoolRecord.getBoolean());
                break;
            }
            case 175: {
                this.mPM.valueChangedBoolean(1297, iAslPoolRecord.getBoolean());
                break;
            }
            case 176: {
                this.mPM.valueChangedBoolean(1298, iAslPoolRecord.getBoolean());
                break;
            }
            case 177: {
                this.mPM.valueChangedBoolean(3445, iAslPoolRecord.getBoolean());
                break;
            }
            case 178: {
                this.mPM.valueChangedBoolean(3354, iAslPoolRecord.getBoolean());
                break;
            }
            case 179: {
                this.mPM.valueChangedBoolean(3373, iAslPoolRecord.getBoolean());
                break;
            }
            case 180: {
                this.mPM.valueChangedResourceLocator(1274, iAslPoolRecord.getResourceLocator());
                break;
            }
            case 181: {
                Object[] objectArray = (SimilarContentCollector[])iAslPoolRecord.getObjectArray();
                ListManager.getGenericASLList(3340).updateList(objectArray);
                break;
            }
            case 182: {
                this.mPM.valueChangedBoolean(3824, iAslPoolRecord.getBoolean());
                break;
            }
            case 6: 
            case 183: {
                int n8;
                int n9 = iAslPool.getInt(6);
                int n10 = n9 == 2 ? 1 : ((n8 = iAslPool.getInt(183)) == 2 ? 1 : 0);
                this.mPM.valueChangedInteger(4145, n10);
                this.mPM.valueChangedInteger(3350, n10);
                this.mPM.valueChangedInteger(3351, n10);
                this.mPM.valueChangedInteger(3352, n10);
                break;
            }
            case 184: {
                boolean bl = iAslPoolRecord.getBoolean();
                this.mPM.valueChangedBoolean(4018, bl);
                break;
            }
            case 185: {
                if (iAslPoolRecord.getUpdateCount() <= 0 || !RadioCurrentWaveband.isSdars()) break;
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(221);
                break;
            }
            case 192: {
                this.mPM.valueChangedInteger(583410688, iAslPoolRecord.getInt());
                break;
            }
            case 193: {
                this.mPM.valueChangedInteger(600187904, iAslPoolRecord.getInt());
                break;
            }
            case 194: {
                this.mPM.valueChangedInteger(616965120, iAslPoolRecord.getInt());
                break;
            }
            case 195: {
                this.mPM.valueChangedInteger(633742336, iAslPoolRecord.getInt());
                break;
            }
            case 196: {
                this.mPM.valueChangedInteger(650519552, iAslPoolRecord.getInt());
                break;
            }
            case 197: {
                this.mPM.valueChangedBoolean(801514496, iAslPoolRecord.getBoolean());
                break;
            }
            case 198: {
                this.mPM.valueChangedBoolean(818291712, iAslPoolRecord.getBoolean());
                break;
            }
            case 199: {
                this.mPM.valueChangedBoolean(835068928, iAslPoolRecord.getBoolean());
                break;
            }
            case 200: {
                this.mPM.valueChangedInteger(851846144, iAslPoolRecord.getInt());
                break;
            }
            case 201: {
                this.mPM.valueChangedString(784737280, iAslPoolRecord.getString());
                break;
            }
            case 202: {
                if (!iAslPoolRecord.getBoolean()) break;
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(398861312);
                break;
            }
            case 203: {
                this.mPM.valueChangedBoolean(885400576, iAslPoolRecord.getBoolean());
                break;
            }
            case 205: {
                this.mPM.valueChangedBoolean(902177792, iAslPoolRecord.getBoolean());
                break;
            }
            case 204: {
                this.mPM.valueChangedBoolean(918955008, iAslPoolRecord.getBoolean());
                break;
            }
        }
    }
}

