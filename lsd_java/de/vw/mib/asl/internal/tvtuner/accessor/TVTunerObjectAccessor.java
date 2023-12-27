/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner.accessor;

import de.vw.mib.asl.internal.tvtuner.TargetTVTuner;
import de.vw.mib.asl.internal.tvtuner.TargetTVTunerDSI;
import de.vw.mib.asl.internal.tvtuner.api.tile.impl.TVTunerTileDisclaimerHelper;
import de.vw.mib.asl.internal.tvtuner.api.tile.impl.TVTunerTileServiceImpl;
import de.vw.mib.asl.internal.tvtuner.common.LogoHandler;
import de.vw.mib.asl.internal.tvtuner.common.ResetParticipant;
import de.vw.mib.asl.internal.tvtuner.common.TVTunerAudioManager;
import de.vw.mib.asl.internal.tvtuner.common.TVTunerBAPHandler;
import de.vw.mib.asl.internal.tvtuner.common.TVTunerCioHandler;
import de.vw.mib.asl.internal.tvtuner.common.TVTunerCioHelper;
import de.vw.mib.asl.internal.tvtuner.lists.PresetListHandler;
import de.vw.mib.asl.internal.tvtuner.lists.StationListHandler;
import de.vw.mib.asl.internal.tvtuner.persistence.TVTunerDB;
import de.vw.mib.asl.internal.tvtuner.settings.StartUpConfigHandler;
import de.vw.mib.asl.internal.tvtuner.settings.TVTunerAVSettings;
import de.vw.mib.asl.internal.tvtuner.settings.TVTunerSettings;
import de.vw.mib.asl.internal.tvtuner.source.TVAVSourceHandler;
import de.vw.mib.asl.internal.tvtuner.tv.EWSHandler;
import de.vw.mib.asl.internal.tvtuner.tv.TVInfo;
import de.vw.mib.asl.internal.tvtuner.tv.TerminalModeHandler;
import de.vw.mib.asl.internal.tvtuner.tv.TuningHandler;

public class TVTunerObjectAccessor {
    private static TargetTVTuner targetTVTuner;
    private static TargetTVTunerDSI targetTVTunerDSI;
    private static TVInfo tvInfo;
    private static TVTunerSettings tvTunerSettings;
    private static LogoHandler logoHandler;
    private static TuningHandler tuningHandler;
    private static StationListHandler stationListHandler;
    private static PresetListHandler presetListHandler;
    private static TVAVSourceHandler tvAvSourceHandler;
    private static StartUpConfigHandler startUpConfigHandler;
    private static TVTunerDB tvTunerDB;
    private static TVTunerAVSettings tvTunerAVSettings;
    private static TVTunerCioHandler cioHandler;
    private static TVTunerCioHelper cioHelper;
    private static TVTunerAudioManager tvTunerAudio;
    private static TerminalModeHandler tmHandler;
    private static EWSHandler ewsHandler;
    private static TVTunerBAPHandler tvBAP;
    private static TVTunerTileServiceImpl tileService;
    private static TVTunerTileDisclaimerHelper tileDisclaimerHelper;
    private static ResetParticipant resetParticipant;

    public static TVTunerDB getTvTunerDB() {
        if (tvTunerDB == null) {
            tvTunerDB = new TVTunerDB();
        }
        return tvTunerDB;
    }

    public static StartUpConfigHandler getStartUpConfigHandler() {
        if (startUpConfigHandler == null) {
            startUpConfigHandler = new StartUpConfigHandler();
        }
        return startUpConfigHandler;
    }

    public static TVAVSourceHandler getTvAvSourceHandler() {
        if (tvAvSourceHandler == null) {
            tvAvSourceHandler = new TVAVSourceHandler();
        }
        return tvAvSourceHandler;
    }

    public static StationListHandler getStationListHandler() {
        if (stationListHandler == null) {
            stationListHandler = new StationListHandler();
        }
        return stationListHandler;
    }

    public static PresetListHandler getPresetListHandler() {
        if (presetListHandler == null) {
            presetListHandler = new PresetListHandler();
        }
        return presetListHandler;
    }

    public static TuningHandler getTuningHandler() {
        if (tuningHandler == null) {
            tuningHandler = new TuningHandler();
        }
        return tuningHandler;
    }

    public static LogoHandler getLogoHandler() {
        if (logoHandler == null) {
            logoHandler = new LogoHandler();
        }
        return logoHandler;
    }

    public static TargetTVTuner getTargetTVTuner() {
        return targetTVTuner;
    }

    public static void setTargetTVTuner(TargetTVTuner targetTVTuner) {
        TVTunerObjectAccessor.targetTVTuner = targetTVTuner;
    }

    public static TVTunerCioHandler getCioHandler() {
        if (cioHandler == null) {
            cioHandler = new TVTunerCioHandler();
        }
        return cioHandler;
    }

    public static TVTunerCioHelper getCioHelper() {
        if (cioHelper == null) {
            cioHelper = new TVTunerCioHelper();
        }
        return cioHelper;
    }

    public static TargetTVTunerDSI getTargetTVTunerDSI() {
        return targetTVTunerDSI;
    }

    public static void setTargetTVTunerDSI(TargetTVTunerDSI targetTVTunerDSI) {
        TVTunerObjectAccessor.targetTVTunerDSI = targetTVTunerDSI;
    }

    public static TVInfo getTVInfo() {
        if (tvInfo == null) {
            tvInfo = new TVInfo();
        }
        return tvInfo;
    }

    public static TVTunerSettings getTvTunerSettings() {
        if (tvTunerSettings == null) {
            tvTunerSettings = new TVTunerSettings();
        }
        return tvTunerSettings;
    }

    public static TVTunerAVSettings getTvTunerAVSettings() {
        if (tvTunerAVSettings == null) {
            tvTunerAVSettings = new TVTunerAVSettings();
        }
        return tvTunerAVSettings;
    }

    public static TVTunerAudioManager getTvTunerAudio() {
        if (tvTunerAudio == null) {
            tvTunerAudio = new TVTunerAudioManager();
        }
        return tvTunerAudio;
    }

    public static TerminalModeHandler getTMHandler() {
        if (tmHandler == null) {
            tmHandler = new TerminalModeHandler();
        }
        return tmHandler;
    }

    public static EWSHandler getEWSHandler() {
        if (ewsHandler == null) {
            ewsHandler = new EWSHandler();
        }
        return ewsHandler;
    }

    public static TVTunerBAPHandler getTvBAP() {
        if (tvBAP == null) {
            tvBAP = new TVTunerBAPHandler();
        }
        return tvBAP;
    }

    public static ResetParticipant getResetParticipant() {
        if (resetParticipant == null) {
            resetParticipant = new ResetParticipant();
        }
        return resetParticipant;
    }

    public static void setResetParticipant(ResetParticipant resetParticipant) {
        TVTunerObjectAccessor.resetParticipant = resetParticipant;
    }

    public static TVTunerTileServiceImpl getTileService() {
        if (tileService == null) {
            tileService = new TVTunerTileServiceImpl();
        }
        return tileService;
    }

    public static TVTunerTileDisclaimerHelper getTileDisclaimerHelper() {
        if (tileDisclaimerHelper == null) {
            tileDisclaimerHelper = new TVTunerTileDisclaimerHelper();
        }
        return tileDisclaimerHelper;
    }
}

