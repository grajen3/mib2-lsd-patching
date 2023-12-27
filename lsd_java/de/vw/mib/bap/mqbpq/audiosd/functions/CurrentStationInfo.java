/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.functions;

import de.vw.mib.asl.api.bap.timer.Timer;
import de.vw.mib.asl.api.bap.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbpq.audiosd.api.stages.CurrentStationInfoStage;
import de.vw.mib.bap.mqbpq.common.api.adapter.LanguageUtil;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbpq.common.arrays.BAPArrayList;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.CurrentStationInfo_Status;
import de.vw.mib.collections.ObjectObjectOptHashMap;
import java.util.ArrayList;

public class CurrentStationInfo
extends CurrentStationInfoStage
implements TimerNotifier {
    private BAPStageInitializer _stageInitializer;
    private LanguageUtil _languageUtil;
    private BAPArrayList _receptionList;
    private int _lastHandle;
    private ObjectObjectOptHashMap _languageMap;
    private int lastAudioComponent;
    private static final int TIMER_UPDATE_TIME;
    private Timer _updateTimer;
    private static final int TIMER_ACTION_NOTHING;
    private static final int TIMER_ACTION_UPDATE_DATA;
    private static final int TIMER_ACTION_STOP_IGNORE_ENTERTAINMENT_SUPRESSION;
    private static final int TIMER_UPDATE_SUPPRESSION_TIME;
    private static final int TIMER_UPDATE_SUPPRESSION_INSTANCE_ID;
    private Timer _suppressionTimer;
    private static final int LANG_NAME_TRACK;
    private static final int LANG_NAME_CHAPTER;
    private static final int LANG_NAME_FILE;
    private static final int LANG_NAME_FOLDER;
    private static final int LANG_NAME_BLUETOOTH;
    private static final int LANG_NAME_AUDIO;
    private static final int LANG_NUMBER_OF_ELEMENTS;
    private static final String MIRROR_LINK_NAME;
    private static final String APPLE_CAR_PLAY_NAME;
    private static final String GOOGLE_GAL_NAME;
    private static final String BAIDU_CARLIFE_NAME;
    private static final String I18N_FILTERCRITERIA_UNKNOWN_ARTIST_STRING;
    private static final String I18N_FILTERCRITERIA_UNKNOWN_ALBUM_STRING;
    private static final String I18N_FILTERCRITERIA_NOW_PLAYING_FOLDER_STRING;
    private static final String UPDATE_TEXT;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        super.init(bAPStageInitializer);
        this.setStageInitializer(bAPStageInitializer);
        CurrentStationInfo_Status currentStationInfo_Status = this.dequeueBAPEntity();
        this.setBapCurrentStationInfoData(currentStationInfo_Status);
        return currentStationInfo_Status;
    }

    private BAPStageInitializer getStageInitializer() {
        return this._stageInitializer;
    }

    private void setStageInitializer(BAPStageInitializer bAPStageInitializer) {
        this._stageInitializer = bAPStageInitializer;
    }

    private Timer getUpdateTimer() {
        if (this._updateTimer == null) {
            this._updateTimer = this.getStageInitializer().createTimer(this, this, 0, 0);
        }
        return this._updateTimer;
    }

    protected final LanguageUtil getLanguageUtil() {
        if (this._languageUtil == null) {
            this._languageUtil = this.getStageInitializer().createLanguageUtil(this);
        }
        return this._languageUtil;
    }

    private Timer getSuppressionTimer() {
        if (this._suppressionTimer == null) {
            this._suppressionTimer = this.getStageInitializer().createTimer(this, this, 0, 1);
        }
        return this._suppressionTimer;
    }

    protected BAPArrayList getReceptionList() {
        return this._receptionList;
    }

    @Override
    protected void setReceptionList(BAPArrayList bAPArrayList) {
        this._receptionList = bAPArrayList;
        this.process(-1);
    }

    private int getLastHandle() {
        return this._lastHandle;
    }

    private void setLastHandle(int n) {
        this._lastHandle = n;
    }

    private ArrayList getLanguageMap() {
        ArrayList arrayList;
        if (this._languageMap == null) {
            this._languageMap = new ObjectObjectOptHashMap();
            arrayList = new ArrayList(6);
            arrayList.add(0, "Titel");
            arrayList.add(1, "Kapitel");
            arrayList.add(2, "Datei");
            arrayList.add(3, "Ordner");
            arrayList.add(4, "Bluetooth");
            arrayList.add(5, "Audio");
            this._languageMap.put("de_DE", arrayList);
            arrayList = new ArrayList(6);
            arrayList.add(0, "Track");
            arrayList.add(1, "Chapter");
            arrayList.add(2, "File");
            arrayList.add(3, "Folder");
            arrayList.add(4, "Bluetooth");
            arrayList.add(5, "Audio");
            this._languageMap.put("en_US", arrayList);
            arrayList = new ArrayList(6);
            arrayList.add(0, "Track");
            arrayList.add(1, "Chapter");
            arrayList.add(2, "File");
            arrayList.add(3, "Folder");
            arrayList.add(4, "Bluetooth");
            arrayList.add(5, "Audio");
            this._languageMap.put("en_GB", arrayList);
            arrayList = new ArrayList(6);
            arrayList.add(0, "Titre");
            arrayList.add(1, "Chapitre");
            arrayList.add(2, "Fichier");
            arrayList.add(3, "Dossier");
            arrayList.add(4, "Bluetooth");
            arrayList.add(5, "Audio");
            this._languageMap.put("fr_FR", arrayList);
            arrayList = new ArrayList(6);
            arrayList.add(0, "Brano");
            arrayList.add(1, "Capitolo");
            arrayList.add(2, "File");
            arrayList.add(3, "Cartella");
            arrayList.add(4, "Bluetooth");
            arrayList.add(5, "Audio");
            this._languageMap.put("it_IT", arrayList);
            arrayList = new ArrayList(6);
            arrayList.add(0, "T\u00edtulo");
            arrayList.add(1, "Cap\u00edtulo");
            arrayList.add(2, "Archivo");
            arrayList.add(3, "Carpeta");
            arrayList.add(4, "Bluetooth");
            arrayList.add(5, "Audio");
            this._languageMap.put("es_ES", arrayList);
            arrayList = new ArrayList(6);
            arrayList.add(0, "T\u00edtulo");
            arrayList.add(1, "Cap\u00edtulo");
            arrayList.add(2, "Ficheiro");
            arrayList.add(3, "Diret\u00f3rio");
            arrayList.add(4, "Bluetooth");
            arrayList.add(5, "\u00c1udio");
            this._languageMap.put("pt_PT", arrayList);
            arrayList = new ArrayList(6);
            arrayList.add(0, "Titul");
            arrayList.add(1, "Kapitola");
            arrayList.add(2, "Soubor");
            arrayList.add(3, "Slo\u017eka");
            arrayList.add(4, "Bluetooth");
            arrayList.add(5, "Audio");
            this._languageMap.put("cs_CZ", arrayList);
            arrayList = new ArrayList(6);
            arrayList.add(0, "\u66f2\u76ee");
            arrayList.add(1, "\u7ae0\u8282");
            arrayList.add(2, "\u6587\u4ef6");
            arrayList.add(3, "\u6587\u4ef6\u5939");
            arrayList.add(4, "\u84dd\u7259");
            arrayList.add(5, "\u97f3\u9891");
            this._languageMap.put("zh_CN", arrayList);
            arrayList = new ArrayList(6);
            arrayList.add(0, "\u0422\u0440\u0435\u043a");
            arrayList.add(1, "\u0427\u0430\u0441\u0442\u044c");
            arrayList.add(2, "\u0424\u0430\u0439\u043b");
            arrayList.add(3, "\u041f\u0430\u043f\u043a\u0430");
            arrayList.add(4, "Bluetooth");
            arrayList.add(5, "\u0417\u0432\u0443\u043a");
            this._languageMap.put("ru_RU", arrayList);
            arrayList = new ArrayList(6);
            arrayList.add(0, "Par\u00e7a");
            arrayList.add(1, "B\u00f6l\u00fcm");
            arrayList.add(2, "Dosya");
            arrayList.add(3, "Klas\u00f6r");
            arrayList.add(4, "Bluetooth");
            arrayList.add(5, "Ses");
            this._languageMap.put("tr_TR", arrayList);
            arrayList = new ArrayList(6);
            arrayList.add(0, "Titel");
            arrayList.add(1, "Hoofdstuk");
            arrayList.add(2, "Bestand");
            arrayList.add(3, "Map");
            arrayList.add(4, "Bluetooth");
            arrayList.add(5, "Audio");
            this._languageMap.put("nl_NL", arrayList);
            arrayList = new ArrayList(6);
            arrayList.add(0, "L\u00e5t");
            arrayList.add(1, "Kapitel");
            arrayList.add(2, "Fil");
            arrayList.add(3, "Mapp");
            arrayList.add(4, "Bluetooth");
            arrayList.add(5, "Ljud");
            this._languageMap.put("sv_SE", arrayList);
            arrayList = new ArrayList(6);
            arrayList.add(0, "Spor");
            arrayList.add(1, "Kapittel");
            arrayList.add(2, "Fil");
            arrayList.add(3, "Mappe");
            arrayList.add(4, "Bluetooth");
            arrayList.add(5, "Audio");
            this._languageMap.put("no_NO", arrayList);
            arrayList = new ArrayList(6);
            arrayList.add(0, "Utw\u00f3r");
            arrayList.add(1, "Rozdzia\u0142");
            arrayList.add(2, "Plik");
            arrayList.add(3, "Folder");
            arrayList.add(4, "Bluetooth");
            arrayList.add(5, "Audio");
            this._languageMap.put("pl_PL", arrayList);
        }
        if ((arrayList = (ArrayList)this._languageMap.get(this.getInstrumentClusterIsLanguage())) == null) {
            arrayList = (ArrayList)this._languageMap.get("en_GB");
        }
        return arrayList;
    }

    private String getLanguageString(int n) {
        String string = (String)this.getLanguageMap().get(n);
        return string != null ? string : "";
    }

    private String getActivePlayingFolderName() {
        String string = this.getActivePlayedFolderName();
        return string.intern() == "filterCriteria.nowPlaying".intern() ? "" : string;
    }

    private String formatFrequency(int n, int n2) {
        String string = this.getFmFrequencyScale() == 1 ? this.getLanguageUtil().formatFrequencyNAR(n, n2, -1) : this.getLanguageUtil().formatFrequency(n, n2);
        return string;
    }

    private void setBapCurrentStationInfoNoInformationAvailable(CurrentStationInfo_Status currentStationInfo_Status) {
        currentStationInfo_Status.infotext_1.setEmptyString();
        currentStationInfo_Status.infotext_2.setEmptyString();
        currentStationInfo_Status.infotext_3.setEmptyString();
    }

    protected void setBapCurrentStationInfoInfoTextsForRadioAM(CurrentStationInfo_Status currentStationInfo_Status) {
        if (this.getAmRadioGetListState() == 1) {
            currentStationInfo_Status.infotext_1.setContent("UPDATING...");
            currentStationInfo_Status.infotext_2.setEmptyString();
            currentStationInfo_Status.infotext_3.setEmptyString();
        } else {
            String string;
            String string2;
            String string3 = this.getCurrentAmStationName();
            if (string3.length() != 0) {
                currentStationInfo_Status.infotext_1.setContent(string3);
            } else {
                currentStationInfo_Status.infotext_1.setContent(this.formatFrequency(this.getCurrentAMFrequency(), 1));
            }
            currentStationInfo_Status.infotext_2.setEmptyString();
            currentStationInfo_Status.infotext_3.setEmptyString();
            if (!this.getManualModeActive() && this.isRadioTextPlusEnabledAMFM()) {
                string2 = this.getCurrentAMRadioTextTitleName();
                string = this.getCurrentAMRadioTextArtistName();
            } else {
                string2 = "";
                string = "";
            }
            currentStationInfo_Status.infotext_2.setContent(string2);
            currentStationInfo_Status.infotext_3.setContent(string);
        }
    }

    protected void setBapCurrentStationInfoInfoTextsForRadioFM(CurrentStationInfo_Status currentStationInfo_Status) {
        String string;
        String string2;
        String string3 = this.getCurrentFmStationName();
        if (string3.length() != 0) {
            currentStationInfo_Status.infotext_1.setContent(string3);
        } else {
            currentStationInfo_Status.infotext_1.setContent(this.formatFrequency(this.getCurrentFmFrequency(), 0));
        }
        if (!this.getManualModeActive() && this.isRadioTextPlusEnabledAMFM()) {
            string2 = this.getCurrentFmRadioTextPlusTitleName();
            string = this.getCurrentFmRadioTextPlusArtistName();
        } else {
            string2 = "";
            string = "";
        }
        currentStationInfo_Status.infotext_2.setContent(string2);
        currentStationInfo_Status.infotext_3.setContent(string);
    }

    protected final boolean isRadioTextPlusEnabledAMFM() {
        return this.getRadioTextSetupState() && this.getRadioTextPlusSetupState() && this.getRatioTextPlusActive() && this.getRdsSetupOptionState();
    }

    protected void setBapCurrentStationInfoInfoTextsForRadioDAB(CurrentStationInfo_Status currentStationInfo_Status) {
        if (this.getDabRadioListState() == 1) {
            currentStationInfo_Status.infotext_1.setContent("UPDATING...");
            currentStationInfo_Status.infotext_2.setEmptyString();
            currentStationInfo_Status.infotext_3.setEmptyString();
        } else {
            String string;
            boolean bl = false;
            int n = this.getDabServiceState();
            int n2 = this.getDabEnsembleState();
            int n3 = this.getDabAdditionalServiceState();
            if (this.getDabEnsembleState() == 1) {
                string = this.getCurrentDABFrequencyLabel();
                bl = true;
            } else if (n2 == 2) {
                string = this.getCurrentDABFrequencyLabel();
                bl = true;
            } else {
                string = n == 1 ? this.getCurrentDabServiceShortName() : (n3 == 2 ? this.getCurrentDabSecondaryServiceShortName() : this.getCurrentDabServiceShortName());
            }
            String string2 = this.getCurrentDABEnsembleName();
            if (string2.length() != 0) {
                if (this.getDabServiceState() == 3) {
                    currentStationInfo_Status.infotext_1.setContent("(FM)");
                } else {
                    currentStationInfo_Status.infotext_1.setContent(string2);
                }
            } else {
                currentStationInfo_Status.infotext_1.setContent(this.getCurrentDABFrequencyLabel());
            }
            if (bl) {
                currentStationInfo_Status.infotext_2.setEmptyString();
            } else {
                currentStationInfo_Status.infotext_2.setContent(string);
            }
            currentStationInfo_Status.infotext_3.setEmptyString();
        }
    }

    private void setBapCurrentStationInfoInfoTextsForRadioSirius(CurrentStationInfo_Status currentStationInfo_Status) {
        currentStationInfo_Status.infotext_1.setContent(this.getCurrentSatChannelShortName());
        currentStationInfo_Status.infotext_2.setContent(this.getCurrentSatTitleName());
        currentStationInfo_Status.infotext_3.setContent(this.getCurrentSatArtistName());
    }

    private void setBapCurrentStationInfoInfoTextsForRadio(CurrentStationInfo_Status currentStationInfo_Status) {
        switch (this.getCurrentStationInfoBand()) {
            case 0: {
                this.setBapCurrentStationInfoInfoTextsForRadioAM(currentStationInfo_Status);
                break;
            }
            case 1: {
                this.setBapCurrentStationInfoInfoTextsForRadioFM(currentStationInfo_Status);
                break;
            }
            case 2: {
                this.setBapCurrentStationInfoInfoTextsForRadioDAB(currentStationInfo_Status);
                break;
            }
            case 3: {
                this.setBapCurrentStationInfoInfoTextsForRadioSirius(currentStationInfo_Status);
                break;
            }
            default: {
                this.setBapCurrentStationInfoNoInformationAvailable(currentStationInfo_Status);
            }
        }
    }

    private void setBapCurrentStationInfoInfoTextsForMirrorLink(CurrentStationInfo_Status currentStationInfo_Status) {
        String string;
        switch (this.getSmarphoneIntegrationConnectionType()) {
            case 1: {
                string = "MirrorLink\u2122";
                break;
            }
            case 2: {
                string = "Apple CarPlay";
                break;
            }
            case 3: {
                string = "Android Auto";
                break;
            }
            case 4: {
                string = "Baidu CarLife";
                break;
            }
            default: {
                string = "";
            }
        }
        currentStationInfo_Status.infotext_1.setContent(string);
        currentStationInfo_Status.infotext_2.setEmptyString();
        currentStationInfo_Status.infotext_3.setEmptyString();
    }

    private boolean setArtistAndAlbum(CurrentStationInfo_Status currentStationInfo_Status) {
        boolean bl;
        String string = this.getCurrentArtist();
        String string2 = this.getCurrentAlbum();
        if (string2.intern() == "filterCriteria.unknownAlbum".intern()) {
            currentStationInfo_Status.infotext_3.setEmptyString();
            bl = false;
        } else {
            currentStationInfo_Status.infotext_3.setContent(string2);
            bl = true;
        }
        if (string.intern() == "filterCriteria.unknownArtist".intern()) {
            currentStationInfo_Status.infotext_1.setEmptyString();
            bl = false;
        } else {
            currentStationInfo_Status.infotext_1.setContent(string);
            bl = true;
        }
        return bl;
    }

    protected void setSimpleTitleWithoutId3Information(CurrentStationInfo_Status currentStationInfo_Status) {
        int n = this.getCurrentTrackNumber();
        currentStationInfo_Status.infotext_1.setContent(n != 0 ? new StringBuffer().append(this.getLanguageString(0)).append(" ").append(n).toString() : "");
        currentStationInfo_Status.infotext_2.setEmptyString();
        currentStationInfo_Status.infotext_3.setEmptyString();
    }

    protected void setBapCurrentStationInfoInfoTextsForMediaDigitalAudioCD(CurrentStationInfo_Status currentStationInfo_Status) {
        boolean bl;
        String string = this.getCurrentTitle();
        boolean bl2 = bl = string != null && string.trim().length() != 0;
        if (bl) {
            currentStationInfo_Status.infotext_2.setContent(string);
            this.setArtistAndAlbum(currentStationInfo_Status);
        } else {
            this.setSimpleTitleWithoutId3Information(currentStationInfo_Status);
        }
    }

    protected void setBapCurrentStationInfoInfoTextsForExternalDevice(CurrentStationInfo_Status currentStationInfo_Status) {
        String string = this.getCurrentTitle();
        boolean bl = string.trim().length() != 0;
        int n = this.getCurrentTrackNumber();
        if (bl || n == 0) {
            currentStationInfo_Status.infotext_2.setContent(string);
            this.setArtistAndAlbum(currentStationInfo_Status);
        } else {
            this.setSimpleTitleWithoutId3Information(currentStationInfo_Status);
            currentStationInfo_Status.infotext_2.setContent(this.getActivePlayingFolderName());
        }
    }

    private void setBapCurrentStationInfoInfoTextsForMedia(CurrentStationInfo_Status currentStationInfo_Status) {
        block0 : switch (this.getCurrentAudioSource()) {
            case 1: 
            case 4: {
                switch (this.getCDContentType()) {
                    case 3: 
                    case 4: {
                        int n = this.getDvdChapter();
                        int n2 = this.getDvdChapterCount();
                        currentStationInfo_Status.infotext_1.setContent(new StringBuffer().append(this.getLanguageString(1)).append(" ").append(n).append("/").append(n2).toString());
                        currentStationInfo_Status.infotext_2.setEmptyString();
                        currentStationInfo_Status.infotext_3.setEmptyString();
                        break block0;
                    }
                    case 1: {
                        this.setBapCurrentStationInfoInfoTextsForMediaDigitalAudioCD(currentStationInfo_Status);
                        break block0;
                    }
                    case 2: {
                        this.setBapCurrentStationInfoInfoTextsForExternalDevice(currentStationInfo_Status);
                        break block0;
                    }
                }
                this.setBapCurrentStationInfoNoInformationAvailable(currentStationInfo_Status);
                break;
            }
            case 7: 
            case 14: {
                this.setBapCurrentStationInfoInfoTextsForExternalDevice(currentStationInfo_Status);
                break;
            }
            case 6: {
                this.setBapCurrentStationInfoInfoTextsForExternalDevice(currentStationInfo_Status);
                if (this.getBluetoothAvrcpSupported() && (!currentStationInfo_Status.infotext_1.isEmptyString() || !currentStationInfo_Status.infotext_2.isEmptyString() || !currentStationInfo_Status.infotext_3.isEmptyString())) break;
                currentStationInfo_Status.infotext_1.setContent(this.getLanguageString(4));
                currentStationInfo_Status.infotext_2.setContent(this.getLanguageString(5));
                break;
            }
            case 2: 
            case 5: 
            case 8: 
            case 10: 
            case 11: 
            case 13: {
                this.setBapCurrentStationInfoInfoTextsForExternalDevice(currentStationInfo_Status);
                break;
            }
            case 3: 
            case 9: {
                this.setBapCurrentStationInfoNoInformationAvailable(currentStationInfo_Status);
                break;
            }
            default: {
                this.setBapCurrentStationInfoNoInformationAvailable(currentStationInfo_Status);
            }
        }
    }

    private void setBapCurrentStationInfoInfoTextsForTvTuner(CurrentStationInfo_Status currentStationInfo_Status) {
        currentStationInfo_Status.infotext_1.setContent(this.getCurrentTvTunerStationName());
        currentStationInfo_Status.infotext_2.setEmptyString();
        currentStationInfo_Status.infotext_3.setEmptyString();
    }

    private boolean setCurrentAudioComponent(CurrentStationInfo_Status currentStationInfo_Status) {
        boolean bl;
        int n = this.getCurrentAudioComponent();
        if (n != this.lastAudioComponent && n != 0) {
            this.lastAudioComponent = n;
            this.setBapCurrentStationInfoNoInformationAvailable(currentStationInfo_Status);
            bl = true;
        } else {
            if (n == 0) {
                if (!this.getSuppressionTimer().isRunning()) {
                    this.getSuppressionTimer().retrigger(2);
                }
            } else {
                this.lastAudioComponent = n;
            }
            bl = false;
        }
        return bl;
    }

    private void setBapCurrentStationInfoInfoTexts(CurrentStationInfo_Status currentStationInfo_Status) {
        switch (this.lastAudioComponent) {
            case 2: 
            case 3: {
                this.setBapCurrentStationInfoInfoTextsForMedia(currentStationInfo_Status);
                break;
            }
            case 5: {
                this.setBapCurrentStationInfoInfoTextsForTvTuner(currentStationInfo_Status);
                break;
            }
            case 1: {
                this.setBapCurrentStationInfoInfoTextsForRadio(currentStationInfo_Status);
                break;
            }
            case 6: {
                this.setBapCurrentStationInfoInfoTextsForMirrorLink(currentStationInfo_Status);
                break;
            }
            default: {
                this.setBapCurrentStationInfoNoInformationAvailable(currentStationInfo_Status);
            }
        }
    }

    private void setBapCurrentStationInfoSwitches(CurrentStationInfo_Status currentStationInfo_Status) {
        currentStationInfo_Status.stationInfoSwitches.taTpAvailable = this.getTpState() == 0;
        currentStationInfo_Status.stationInfoSwitches.tmcAvailable = this.getRdsSetupOptionState() && this.getTmcSignalAvailable();
    }

    protected int findBapPosIdInReceptionList() {
        return this.getReceptionList() != null ? this.getReceptionList().getBapPosID(this.getStationListActiveID()) : 0;
    }

    private int getBapCurrentStationInfoHandleForRadio() {
        int n;
        switch (this.getCurrentStationInfoBand()) {
            case 0: 
            case 1: 
            case 2: 
            case 3: {
                n = this.findBapPosIdInReceptionList();
                break;
            }
            default: {
                n = 0;
            }
        }
        return n;
    }

    private int getBapCurrentStationInfoHandle() {
        int n;
        switch (this.lastAudioComponent) {
            case 1: {
                n = this.getBapCurrentStationInfoHandleForRadio();
                break;
            }
            case 5: {
                n = this.findBapPosIdInReceptionList();
                break;
            }
            default: {
                n = 0;
            }
        }
        return n;
    }

    private void setBapCurrentStationInfoData(CurrentStationInfo_Status currentStationInfo_Status) {
        this.setBapCurrentStationInfoInfoTexts(currentStationInfo_Status);
        this.setBapCurrentStationInfoSwitches(currentStationInfo_Status);
        currentStationInfo_Status.fsgHandle = this.getBapCurrentStationInfoHandle();
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.getLanguageUtil().uninitialize();
        this.getUpdateTimer().stop();
        this.getSuppressionTimer().stop();
    }

    @Override
    public void process(int n) {
        if (!this.getUpdateTimer().isRunning()) {
            boolean bl;
            CurrentStationInfo_Status currentStationInfo_Status = this.dequeueBAPEntity();
            if (!this.setCurrentAudioComponent(currentStationInfo_Status)) {
                this.setBapCurrentStationInfoData(currentStationInfo_Status);
                bl = this.getDelegate().getPropertyListener(this).statusProperty(currentStationInfo_Status, this);
            } else {
                bl = this.getDelegate().getPropertyListener(this).statusProperty(currentStationInfo_Status, this);
            }
            if (currentStationInfo_Status.fsgHandle != this.getLastHandle()) {
                this.setLastHandle(currentStationInfo_Status.fsgHandle);
                if (bl) {
                    this.setCurrentStationHandleRequested(Boolean.TRUE);
                } else {
                    this.requestAcknowledge();
                }
            }
            if (bl) {
                this.getUpdateTimer().retrigger(1);
            }
        } else {
            int n2 = this.getBapCurrentStationInfoHandle();
            if (n2 != this.getLastHandle()) {
                this.setLastHandle(n2);
                this.setCurrentStationHandleRequested(Boolean.TRUE);
            }
            this.getUpdateTimer().setUserInfo(1);
        }
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void requestAcknowledge() {
        this.setCurrentFsgHandle(new Integer(this.getLastHandle()));
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void timerFired(int n) {
        switch (n) {
            case 1: 
            case 2: {
                this.process(-1);
                break;
            }
        }
    }
}

