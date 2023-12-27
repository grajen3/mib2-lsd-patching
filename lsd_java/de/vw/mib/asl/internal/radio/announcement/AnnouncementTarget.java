/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.announcement;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.DSIServiceLocator;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmPTY31Option;
import de.vw.mib.asl.internal.radio.announcement.AnnouncementAudio;
import de.vw.mib.asl.internal.radio.announcement.AnnouncementDamper;
import de.vw.mib.asl.internal.radio.announcement.AnnouncementData;
import de.vw.mib.asl.internal.radio.announcement.AnnouncementFreezer;
import de.vw.mib.asl.internal.radio.announcement.AnnouncementListener;
import de.vw.mib.asl.internal.radio.announcement.AnnouncementStateActive;
import de.vw.mib.asl.internal.radio.announcement.AnnouncementStateIdle;
import de.vw.mib.asl.internal.radio.announcement.AnnouncementStateTop;
import de.vw.mib.asl.internal.radio.announcement.AnnouncementTimer;
import de.vw.mib.asl.internal.radio.announcement.AnnouncementTuner;
import de.vw.mib.asl.internal.radio.announcement.AnnouncementView;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.genericevents.hsm.TargetHsmImpl;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.radio.DSITunerAnnouncement;

public final class AnnouncementTarget
extends TargetHsmImpl {
    private final AnnouncementTuner mAnnouncementTuner;
    private final AnnouncementData mAnnouncementData;
    final AnnouncementView announcementView;
    private final HsmState mStateTop;
    private final HsmState mStateIdle;
    private final HsmState mStateActive;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSITunerAnnouncement;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSITunerAnnouncementListener;

    public AnnouncementTarget(GenericEvents genericEvents) {
        super(genericEvents);
        AnnouncementAudio announcementAudio = new AnnouncementAudio(this);
        this.announcementView = new AnnouncementView(announcementAudio);
        AnnouncementDamper announcementDamper = new AnnouncementDamper(this, this.announcementView);
        AnnouncementFreezer announcementFreezer = new AnnouncementFreezer(announcementDamper);
        this.mAnnouncementTuner = new AnnouncementTuner();
        this.mAnnouncementData = new AnnouncementData(announcementFreezer, this.mAnnouncementTuner, this.announcementView);
        this.mStateTop = new AnnouncementStateTop(this, null, this.mAnnouncementData);
        this.mStateIdle = new AnnouncementStateIdle(this, this.mStateTop, this.mAnnouncementData);
        this.mStateActive = new AnnouncementStateActive(this, this.mStateTop, announcementAudio, this.mAnnouncementData);
    }

    public void start(String string) {
        try {
            this.startHsmAndRegisterTarget(this.mEventContext, this.mEventContext.getEventDispatcher().getNextTargetId(), string, this.mStateTop);
        }
        catch (Exception exception) {
            ServiceManager.logger.error(8192, "COULD NOT START Announcement Controller.", exception);
        }
    }

    void startTimer(AnnouncementTimer announcementTimer, long l) {
        EventGeneric eventGeneric = ServiceManager.eventMain.getEventFactory().newEvent();
        eventGeneric.setReceiverEventId(-1517944576);
        eventGeneric.setObject(0, announcementTimer);
        this.startTimer(eventGeneric, l, false, false);
    }

    void register() {
        this.addObserver(-721158080);
        this.addObserver(-737935296);
        this.addObserver(-586940352);
        this.addObserver(-335282112);
        this.addObserver(822689024);
        this.registerService(-862060544);
        this.addObserver(-862060544);
        boolean bl = AmfmPTY31Option.get();
        if (!bl && this.mAnnouncementData.isPTY31TypeFM()) {
            this.abortAndClosePopup();
        }
        this.mAnnouncementData.updateFMAlarmAnnouncements(bl);
        this.addObserver(-929169408);
        this.addObserver(-778174464);
        this.addObserver(-845283328);
        this.addObserver(-727842816);
        this.addObserver(1268973568);
        this.addObserver(1285750784);
        this.addObserver(1302528000);
        this.addObserver(1319305216);
        this.addObserver(1336082432);
        this.addObserver(352926976);
        DSIServiceLocator dSIServiceLocator = ServiceManager.dsiServiceLocator;
        DSITunerAnnouncement dSITunerAnnouncement = (DSITunerAnnouncement)dSIServiceLocator.getService(this, class$org$dsi$ifc$radio$DSITunerAnnouncement == null ? (class$org$dsi$ifc$radio$DSITunerAnnouncement = AnnouncementTarget.class$("org.dsi.ifc.radio.DSITunerAnnouncement")) : class$org$dsi$ifc$radio$DSITunerAnnouncement);
        AnnouncementListener announcementListener = new AnnouncementListener(this);
        dSIServiceLocator.addResponseListener(this, class$org$dsi$ifc$radio$DSITunerAnnouncementListener == null ? (class$org$dsi$ifc$radio$DSITunerAnnouncementListener = AnnouncementTarget.class$("org.dsi.ifc.radio.DSITunerAnnouncementListener")) : class$org$dsi$ifc$radio$DSITunerAnnouncementListener, announcementListener);
        int[] nArray = new int[]{2, 4, 3};
        dSITunerAnnouncement.setNotification(nArray, (DSIListener)announcementListener);
        this.mAnnouncementTuner.setDsiTunerAnnouncement(dSITunerAnnouncement);
    }

    protected HsmState getDefaultState() {
        return this.mStateTop;
    }

    void abortAndClosePopup() {
        this.mAnnouncementData.abort();
        this.mAnnouncementData.updateAnnouncementValue(20);
        this.transIdle();
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        super.gotEvent(eventGeneric);
    }

    @Override
    public int getSubClassifier() {
        return 8192;
    }

    void transIdle() {
        this.hsm.trans(this.mStateIdle);
    }

    void transActive() {
        this.hsm.trans(this.mStateActive);
    }

    public AnnouncementData getmAnnouncementData() {
        return this.mAnnouncementData;
    }

    public AnnouncementView getAnnouncementView() {
        return this.announcementView;
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

