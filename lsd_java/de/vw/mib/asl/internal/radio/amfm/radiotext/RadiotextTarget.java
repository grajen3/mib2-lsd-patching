/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.radiotext;

import de.vw.mib.asl.api.radio.ASLRadioTargetIds;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.DSIServiceLocator;
import de.vw.mib.asl.internal.radio.RadioConstants;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.radiotext.Radiotext;
import de.vw.mib.asl.internal.radio.amfm.radiotext.RadiotextListener;
import de.vw.mib.asl.internal.radio.amfm.radiotext.RadiotextPresenter;
import de.vw.mib.asl.internal.radio.amfm.radiotext.RadiotextShowtime;
import de.vw.mib.asl.internal.radio.amfm.radiotext.RadiotextStateDeviceOff;
import de.vw.mib.asl.internal.radio.amfm.radiotext.RadiotextStateDeviceOn;
import de.vw.mib.asl.internal.radio.amfm.radiotext.RadiotextStateNoneFreeze;
import de.vw.mib.asl.internal.radio.amfm.radiotext.RadiotextStateNoneIdle;
import de.vw.mib.asl.internal.radio.amfm.radiotext.RadiotextStateShowFreeze;
import de.vw.mib.asl.internal.radio.amfm.radiotext.RadiotextStateShowIdle;
import de.vw.mib.asl.internal.radio.amfm.radiotext.RadiotextStateTop;
import de.vw.mib.asl.internal.radio.amfm.radiotext.RadiotextStateWaitFreeze;
import de.vw.mib.asl.internal.radio.amfm.radiotext.RadiotextStateWaitIdle;
import de.vw.mib.asl.internal.radio.amfm.radiotext.RadiotextStorage;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.genericevents.hsm.TargetHsmImpl;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.radio.DSIAMFMTuner;

final class RadiotextTarget
extends TargetHsmImpl
implements Radiotext {
    private final RadiotextStorage mRadiotextStorage = new RadiotextStorage(this);
    private final RadiotextShowtime mRadiotextShowtime = new RadiotextShowtime();
    private final RadiotextPresenter mRadiotextPresenter = new RadiotextPresenter(this.mRadiotextStorage);
    private final HsmState mStateRadiotextTop = new RadiotextStateTop(this, "stateRadiotextTop", null, this.mRadiotextPresenter, this.mRadiotextStorage, this.mRadiotextShowtime);
    private final HsmState mStateRadiotextDeviceOff = new RadiotextStateDeviceOff(this, "stateRadiotextDeviceOff", this.mStateRadiotextTop);
    private final HsmState mStateRadiotextDeviceOn = new RadiotextStateDeviceOn(this, "stateRadiotextDeviceOn", this.mStateRadiotextTop);
    private final HsmState mStateRadiotextWaitFreeze = new RadiotextStateWaitFreeze(this, "stateRadiotextWaitFreeze", this.mStateRadiotextDeviceOn, this.mRadiotextStorage, this.mRadiotextPresenter);
    private final HsmState mStateRadiotextWaitIdle = new RadiotextStateWaitIdle(this, "stateRadiotextWaitIdle", this.mStateRadiotextDeviceOn);
    private final HsmState mStateRadiotextShowFreeze = new RadiotextStateShowFreeze(this, "stateRadiotextShowFreeze", this.mStateRadiotextDeviceOn, this.mRadiotextStorage, this.mRadiotextShowtime, this.mRadiotextPresenter);
    private final HsmState mStateRadiotextShowIdle = new RadiotextStateShowIdle(this, "stateRadiotextShowIdle", this.mStateRadiotextDeviceOn);
    private final HsmState mStateRadiotextNoneFreeze = new RadiotextStateNoneFreeze(this, "stateRadiotextNoneFreeze", this.mStateRadiotextDeviceOn, this.mRadiotextStorage, this.mRadiotextPresenter);
    private final HsmState mStateRadiotextNoneIdle = new RadiotextStateNoneIdle(this, "stateRadiotextNoneIdle", this.mStateRadiotextDeviceOn);
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSIAMFMTuner;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSIAMFMTunerListener;

    RadiotextTarget(GenericEvents genericEvents) {
        super(genericEvents);
    }

    @Override
    public void start(String string) {
        this.startHsmAndRegisterTarget(this.mEventContext, ASLRadioTargetIds.ASL_RADIO_RADIOTEXT_TARGET, string, this.mStateRadiotextTop);
    }

    void register() {
        DSIServiceLocator dSIServiceLocator = ServiceManager.dsiServiceLocator;
        DSIAMFMTuner dSIAMFMTuner = (DSIAMFMTuner)dSIServiceLocator.getService(this, class$org$dsi$ifc$radio$DSIAMFMTuner == null ? (class$org$dsi$ifc$radio$DSIAMFMTuner = RadiotextTarget.class$("org.dsi.ifc.radio.DSIAMFMTuner")) : class$org$dsi$ifc$radio$DSIAMFMTuner);
        RadiotextListener radiotextListener = new RadiotextListener(this.mRadiotextStorage);
        dSIServiceLocator.addResponseListener(this, class$org$dsi$ifc$radio$DSIAMFMTunerListener == null ? (class$org$dsi$ifc$radio$DSIAMFMTunerListener = RadiotextTarget.class$("org.dsi.ifc.radio.DSIAMFMTunerListener")) : class$org$dsi$ifc$radio$DSIAMFMTunerListener, radiotextListener);
        int[] nArray = new int[]{6, 11};
        dSIAMFMTuner.setNotification(nArray, (DSIListener)radiotextListener);
        dSIAMFMTuner.enableRadiotextPlus(RadioConstants.AMFM_RT_PLUS_TAGS);
        this.addObserver(-409190144);
        this.addObserver(731726080);
    }

    @Override
    public void deactivate() {
        this.triggerMe(ServiceManager.mGenericEventFactory.newEvent(), 75956480);
    }

    @Override
    public void activate() {
        this.triggerMe(ServiceManager.mGenericEventFactory.newEvent(), 92733696);
    }

    @Override
    public void notifyStationChange() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        this.triggerMe(eventGeneric, -1585053440);
    }

    @Override
    public void clearRtAndRtplus() {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(RadioUtil.LOG_PREFIX_AMFM_RADIOTEXT).append("Inside clearRtAndRtplus").log();
        }
        try {
            this.mRadiotextStorage.clear();
            this.mRadiotextPresenter.show(2);
        }
        catch (Exception exception) {
            ServiceManager.logger.error(128, "Exception in clearRtAndRtplus : ", exception);
        }
    }

    @Override
    public void notifyLostRDS() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        this.triggerMe(eventGeneric, -1534721792);
    }

    @Override
    public void show(String string, String string2) {
        EventGeneric eventGeneric = ServiceManager.eventMain.getEventFactory().newEvent();
        eventGeneric.setString(1, string);
        eventGeneric.setString(2, string2);
        this.triggerMe(eventGeneric, -1484390144);
    }

    protected HsmState getDefaultState() {
        return this.mStateRadiotextTop;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        super.gotEvent(eventGeneric);
    }

    void transDeviceOn() {
        this.hsm.trans(this.mStateRadiotextDeviceOn);
    }

    void transDeviceOff() {
        this.hsm.trans(this.mStateRadiotextDeviceOff);
    }

    void transWaitFreeze() {
        this.hsm.trans(this.mStateRadiotextWaitFreeze);
    }

    void transShowFreeze() {
        this.hsm.trans(this.mStateRadiotextShowFreeze);
    }

    void transNoneFreeze() {
        this.hsm.trans(this.mStateRadiotextNoneFreeze);
    }

    void transWaitIdle() {
        this.hsm.trans(this.mStateRadiotextWaitIdle);
    }

    void transShowIdle() {
        this.hsm.trans(this.mStateRadiotextShowIdle);
    }

    void transNoneIdle() {
        this.hsm.trans(this.mStateRadiotextNoneIdle);
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

