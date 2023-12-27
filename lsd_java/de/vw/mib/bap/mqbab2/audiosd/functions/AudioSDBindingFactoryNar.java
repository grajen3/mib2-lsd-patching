/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.mqbab2.audiosd.functions.AnnouncementInfoNar;
import de.vw.mib.bap.mqbab2.audiosd.functions.AudioSDBindingFactoryAll;
import de.vw.mib.bap.mqbab2.audiosd.functions.CurrentStationHandleNar;
import de.vw.mib.bap.mqbab2.audiosd.functions.CurrentStationInfoNar;
import de.vw.mib.bap.mqbab2.audiosd.functions.FSGSetupNar;
import de.vw.mib.bap.mqbab2.audiosd.functions.MediaBrowserNar;
import de.vw.mib.bap.mqbab2.audiosd.functions.MuteNar;
import de.vw.mib.bap.mqbab2.audiosd.functions.PreferredListNar;
import de.vw.mib.bap.mqbab2.audiosd.functions.RadioTVPresetListNar;
import de.vw.mib.bap.mqbab2.audiosd.functions.ReceptionListNar;
import de.vw.mib.bap.mqbab2.audiosd.functions.SourceListNar;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;

public class AudioSDBindingFactoryNar
extends AudioSDBindingFactoryAll {
    @Override
    public BAPStage createNewFSGSetupStage() {
        return new FSGSetupNar();
    }

    @Override
    public BAPStage createNewAnnouncementInfoStage() {
        return new AnnouncementInfoNar();
    }

    @Override
    public BAPStage createNewSourceListStage() {
        return new SourceListNar();
    }

    @Override
    public BAPStage createNewPreferredListStage() {
        return new PreferredListNar();
    }

    @Override
    public BAPStage createNewMuteStage() {
        return new MuteNar();
    }

    @Override
    public BAPStage createNewReceptionListStage() {
        return new ReceptionListNar();
    }

    @Override
    public BAPStage createNewCurrentStationInfoStage() {
        return new CurrentStationInfoNar();
    }

    @Override
    public BAPStage createNewCurrentStationHandleStage() {
        return new CurrentStationHandleNar();
    }

    @Override
    public BAPStage createNewRadioTVPresetListStage() {
        return new RadioTVPresetListNar();
    }

    @Override
    public BAPStage createNewMediaBrowserStage() {
        return new MediaBrowserNar();
    }
}

