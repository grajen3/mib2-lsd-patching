/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.slideshow;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.DSIServiceLocator;
import de.vw.mib.asl.framework.internal.framework.dsi.adaptor.AdaptorFactory;
import de.vw.mib.asl.internal.radio.GuiApiDab;
import de.vw.mib.asl.internal.radio.RadioDabTraceUtil;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.dab.DabDatabase;
import de.vw.mib.asl.internal.radio.dab.slideshow.StateDabSlsDabOff;
import de.vw.mib.asl.internal.radio.dab.slideshow.StateDabSlsDiagOff;
import de.vw.mib.asl.internal.radio.dab.slideshow.StateDabSlsSearching;
import de.vw.mib.asl.internal.radio.dab.slideshow.StateDabSlsShowing;
import de.vw.mib.asl.internal.radio.dab.slideshow.StateDabSlsStationChanging;
import de.vw.mib.asl.internal.radio.dab.slideshow.StateDabSlsStationSelected;
import de.vw.mib.asl.internal.radio.dab.slideshow.StateDabSlsSyncLost;
import de.vw.mib.asl.internal.radio.dab.slideshow.StateDabSlsTop;
import de.vw.mib.asl.internal.radio.dab.slideshow.StateDabSlsWaiting;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataApi;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.genericevents.hsm.TargetHsmImpl;
import de.vw.mib.log4mib.LogMessage;
import generated.de.vw.mib.asl.internal.radio.ASLRadioPropertyManager;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.DABSlideShowInfo;
import org.dsi.ifc.radio.DSIDABTuner;
import org.dsi.ifc.radio.ServiceInfo;

public final class HsmDabSlsTarget
extends TargetHsmImpl {
    final int DIAG_SLS_NO_LIMITATION;
    final int DIAG_SLS_OFF;
    boolean mAboveLimit = false;
    boolean thresholdON = true;
    int mDiagDuration1 = 0;
    int mDiagDuration2 = 0;
    private boolean mainViewVisible = true;
    public final HsmState stateDabSlsTop = new StateDabSlsTop(this, "stateDabSlsTop", null);
    public final HsmState stateDabSlsDabOff = new StateDabSlsDabOff(this, "stateDabSlsDabOff", this.stateDabSlsTop);
    final HsmState stateDabSlsStationSelected = new StateDabSlsStationSelected(this, "stateDabSlsStationSelected", this.stateDabSlsTop);
    final HsmState stateDabSlsStationChanging = new StateDabSlsStationChanging(this, "stateDabSlsStationChanging", this.stateDabSlsTop);
    final HsmState stateDabSlsShowing = new StateDabSlsShowing(this, "stateDabSlsShowing", this.stateDabSlsStationSelected);
    final HsmState stateDabSlsWaiting = new StateDabSlsWaiting(this, "stateDabSlsWaiting", this.stateDabSlsStationSelected);
    final HsmState stateDabSlsSyncLost = new StateDabSlsSyncLost(this, "stateDabSlsSyncLost", this.stateDabSlsStationSelected);
    final HsmState stateDabSlsDiagOff = new StateDabSlsDiagOff(this, "stateDabSlsDiagOff", this.stateDabSlsTop);
    final HsmState stateDabSlsSearching = new StateDabSlsSearching(this, "stateDabSlsSearching", this.stateDabSlsTop);
    ResourceLocator mCurrentSlideShowImage = null;
    int currentSlideShowState = 1;
    boolean slSSearching = false;
    DSIDABTuner mDsiDabTuner;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSIDABTuner;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSIDABTunerListener;

    protected void registerObservers() {
        this.addObservers(new int[]{235536448, 252313664});
        DSIServiceLocator dSIServiceLocator = ServiceManager.dsiServiceLocator;
        this.mDsiDabTuner = (DSIDABTuner)dSIServiceLocator.getService(this, class$org$dsi$ifc$radio$DSIDABTuner == null ? (class$org$dsi$ifc$radio$DSIDABTuner = HsmDabSlsTarget.class$("org.dsi.ifc.radio.DSIDABTuner")) : class$org$dsi$ifc$radio$DSIDABTuner);
        DSIListener dSIListener = AdaptorFactory.createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$radio$DSIDABTunerListener == null ? (class$org$dsi$ifc$radio$DSIDABTunerListener = HsmDabSlsTarget.class$("org.dsi.ifc.radio.DSIDABTunerListener")) : class$org$dsi$ifc$radio$DSIDABTunerListener);
        dSIServiceLocator.addResponseListener(this, class$org$dsi$ifc$radio$DSIDABTunerListener == null ? (class$org$dsi$ifc$radio$DSIDABTunerListener = HsmDabSlsTarget.class$("org.dsi.ifc.radio.DSIDABTunerListener")) : class$org$dsi$ifc$radio$DSIDABTunerListener, dSIListener);
        this.mDsiDabTuner.setNotification(32, dSIListener);
        this.addObservers(new int[]{580731136, 563953920});
    }

    public HsmDabSlsTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents);
        this.DIAG_SLS_NO_LIMITATION = 0;
        this.DIAG_SLS_OFF = -65536;
        this.setTargetId(n);
        this.hsm.verbose = false;
        this.startHsmAndRegisterTarget(genericEvents, n, string, this.stateDabSlsTop);
        DabDatabase.mDabSlsTarget = this;
    }

    protected HsmState getDefaultState() {
        return this.stateDabSlsTop;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 8: {
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append("HsmDabSlsTarget - gotEvent() - NOTIFY_TARGET_REGISTERED").log();
                }
                this.registerObservers();
                this.mCurrentSlideShowImage = ASLRadioPropertyManager.DAB_SLIDE_SHOW_IMAGE__DEFAULT_VALUE;
                this.decideSlideShowImageOrLogoImageAndSlideShowState();
                this.mDsiDabTuner.setSlideShowMode(1);
                EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), 5602, 5);
                this.send(eventGeneric2);
                break;
            }
            default: {
                super.gotEvent(eventGeneric);
            }
        }
    }

    void trace(Object[] objectArray) {
        if (this.isTraceEnabled()) {
            LogMessage logMessage = this.getTextLogger().trace(256);
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                logMessage.append(objectArray[i2]);
            }
            logMessage.log();
        }
    }

    void decideSlideshowState() {
        ServiceInfo serviceInfo = RadioData.getDabDatabase().mTunerState.getCurrentService();
        if (serviceInfo != null && ServiceManager.logger.isTraceEnabled(256)) {
            ServiceManager.logger.trace(256).append("Inside updateSlideshowState with service: ").append(serviceInfo.toString()).log();
        }
        if (serviceInfo != null && RadioData.getDabDatabase().mTunerState.hasSlideShowServices(serviceInfo)) {
            if (this.mCurrentSlideShowImage == null) {
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append("Inside updateSlideshowState with mCurrentSlideShowImage null").log();
                }
                RadioData.getDabDatabase().mPersistable.setLsmSupportsSlideshow(true);
                this.currentSlideShowState = 2;
                this.mCurrentSlideShowImage = null;
                this.decideSlideShowImageOrLogoImageAndSlideShowState();
            }
        } else {
            if (ServiceManager.logger.isTraceEnabled(256)) {
                ServiceManager.logger.trace(256).append("Inside updateSlideshowState with SS Not Supported").log();
            }
            RadioData.getDabDatabase().mPersistable.setLsmSupportsSlideshow(false);
            this.currentSlideShowState = 0;
            this.mCurrentSlideShowImage = null;
            this.decideSlideShowImageOrLogoImageAndSlideShowState();
        }
    }

    @Override
    public int getSubClassifier() {
        return 256;
    }

    void notifyFriendsAboutActivationSLS(boolean bl) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setSenderTargetId(this.getTargetId());
        eventGeneric.setReceiverTargetId(5610);
        eventGeneric.setReceiverEventId(547176704);
        eventGeneric.setBoolean(0, bl);
        this.send(eventGeneric);
    }

    boolean slsAllowed(EventGeneric eventGeneric) {
        this.thresholdON = eventGeneric.getBoolean(0);
        if (this.thresholdON) {
            this.mDiagDuration1 = eventGeneric.getInt(1);
            this.mDiagDuration2 = eventGeneric.getInt(2);
            RadioDabTraceUtil.traceDab(this.getTargetId(), new StringBuffer().append("Threshold ON: ").append(this.thresholdON).append("SLS Duration 1").append(this.mDiagDuration1).append("SLS Duration 2").append(this.mDiagDuration2).toString());
        } else {
            this.mDiagDuration2 = this.mDiagDuration1 = eventGeneric.getInt(1);
            RadioDabTraceUtil.traceDab(this.getTargetId(), new StringBuffer().append("Threshold ON: ").append(this.thresholdON).append("So considering only the SLS Duration 1").append(this.mDiagDuration1).toString());
        }
        return this.mDiagDuration1 != -65536 && this.mDiagDuration2 != -65536;
    }

    void mainViewVisible(boolean bl) {
        this.mainViewVisible = bl;
    }

    boolean isSlsVisible() {
        int n = RadioData.getDabDatabase().mRadioTextSetupState.get();
        switch (n) {
            case 1: 
            case 3: {
                return this.mainViewVisible;
            }
        }
        return false;
    }

    void decideSlideShowImageOrLogoImageAndSlideShowState() {
        ServiceInfo serviceInfo = RadioData.getDabDatabase().mTunerState.getCurrentService();
        if (this.slSSearching || null == serviceInfo) {
            GuiApiDab.updateSlideShowOrLogoVisibility(0);
            GuiApiDab.updateSlideShowAvailable(1);
            GuiApiDab.updateSlideShowImage(null);
            ServiceManager.aslPropertyManager.valueChangedBoolean(432415744, false);
            return;
        }
        if (null != serviceInfo && ServiceManager.logger.isTraceEnabled(256)) {
            ServiceManager.logger.trace(256).append("updating slideshow or logo to the service: ").append(serviceInfo.toString()).log();
        }
        if (this.mCurrentSlideShowImage != null) {
            GuiApiDab.updateSlideShowOrLogoVisibility(0);
            GuiApiDab.updateSlideShowImage(this.mCurrentSlideShowImage);
            GuiApiDab.updateSlideShowAvailable(1);
            ServiceManager.aslPropertyManager.valueChangedBoolean(432415744, true);
            if (ServiceManager.logger.isTraceEnabled(256)) {
                ServiceManager.logger.trace(256).append("slideShowImage name:").append(this.mCurrentSlideShowImage.toString()).append("slideShowState is : ").append(this.currentSlideShowState).log();
            }
        } else {
            ServiceManager.aslPropertyManager.valueChangedBoolean(432415744, false);
            ResourceLocator resourceLocator = RadioDataApi.requestRadioDabStationLogoFromHmiBuffer(serviceInfo);
            if (resourceLocator != null) {
                GuiApiDab.updateSlideShowOrLogoVisibility(3);
                GuiApiDab.updateSlideShowImage(resourceLocator);
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append("stationLogo name:").append(resourceLocator.toString()).log();
                }
            } else {
                this.defaultSlideshowOrLogoState();
            }
        }
    }

    private void defaultSlideshowOrLogoState() {
        GuiApiDab.updateSlideShowOrLogoVisibility(0);
        GuiApiDab.updateSlideShowImage(this.mCurrentSlideShowImage);
        GuiApiDab.updateSlideShowAvailable(this.currentSlideShowState);
        if (ServiceManager.logger.isTraceEnabled(256)) {
            ServiceManager.logger.trace(256).append("slideShowImage & stationlogo are empty and the slideShow state is :").append(this.currentSlideShowState).log();
        }
    }

    public boolean isItforCurrentServiceorComponent(DABSlideShowInfo dABSlideShowInfo) {
        boolean bl = false;
        if (null != dABSlideShowInfo && dABSlideShowInfo.category == 1) {
            ComponentInfo componentInfo = RadioData.getDabDatabase().mTunerState.getCurrentComponent();
            if (null != componentInfo) {
                if (dABSlideShowInfo.sCIDI == componentInfo.sCIDI && (long)dABSlideShowInfo.sID == componentInfo.sID && dABSlideShowInfo.ensID == componentInfo.ensID) {
                    bl = true;
                }
            } else {
                ServiceInfo serviceInfo = RadioData.getDabDatabase().mTunerState.getCurrentService();
                if (null != serviceInfo && (long)dABSlideShowInfo.sID == serviceInfo.sID && dABSlideShowInfo.ensID == serviceInfo.ensID) {
                    bl = true;
                }
            }
            if (!bl) {
                RadioDabTraceUtil.traceDab(this.getTargetId(), "+++ SlideShow: Wrong ServiceID or Component ID");
            }
        }
        return bl;
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

