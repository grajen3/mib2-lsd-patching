/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.slideshow;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.dab.slideshow.HsmDabSlsTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.DABSlideShowInfo;
import org.dsi.ifc.radio.ServiceInfo;

public final class StateDabSlsShowing
extends AbstractHsmState {
    private final HsmDabSlsTarget mTarget;
    private ResourceLocator mNewImage = null;
    private int mTimeout;
    boolean mTimerRunning = false;

    public StateDabSlsShowing(HsmDabSlsTarget hsmDabSlsTarget, String string, HsmState hsmState) {
        super(hsmDabSlsTarget.getHsm(), string, hsmState);
        this.mTarget = hsmDabSlsTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateDabSlsShowing is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.mTarget.currentSlideShowState = 1;
                this.showImage(this.mTarget.mCurrentSlideShowImage);
                this.mNewImage = null;
                break;
            }
            case 4300065: {
                this.mTarget.mAboveLimit = eventGeneric.getBoolean(0);
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append(new StringBuffer().append("AboveLimit: ").append(this.mTarget.mAboveLimit).append("Duration1: ").append(this.mTarget.mDiagDuration1).append("Duration2: ").append(this.mTarget.mDiagDuration2).toString()).log();
                }
                if (!this.mTarget.mAboveLimit) {
                    this.mTimeout = this.mTarget.mDiagDuration1 * 1000;
                } else {
                    int n = this.mTarget.mDiagDuration2;
                    super.getClass();
                    if (n == -65536) {
                        this.trans(this.mTarget.stateDabSlsDiagOff);
                        return hsmState;
                    }
                    this.mTimeout = this.mTarget.mDiagDuration2 * 1000;
                }
                super.getClass();
                if (this.mTimeout == 0) {
                    if (this.mNewImage != null) {
                        this.showImage(this.mNewImage);
                        this.mNewImage = null;
                        break;
                    }
                    this.trans(this.mTarget.stateDabSlsWaiting);
                    break;
                }
                this.startTimer();
                break;
            }
            case 1073744399: {
                this.mTarget.mainViewVisible(false);
                if (this.mNewImage == null) break;
                this.showImage(this.mNewImage);
                break;
            }
            case 1073744398: {
                this.mTarget.mainViewVisible(true);
                if (!this.mTarget.isSlsVisible()) break;
                this.startTimer();
                break;
            }
            case 100109: {
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append("Timeout happened so going to show the next slide").log();
                }
                if (this.mNewImage != null) {
                    this.showImage(this.mNewImage);
                    this.mNewImage = null;
                    break;
                }
                this.trans(this.mTarget.stateDabSlsWaiting);
                break;
            }
            case 4300066: {
                if (this.mTarget.slsAllowed(eventGeneric)) {
                    if (ServiceManager.logger.isTraceEnabled(256)) {
                        ServiceManager.logger.trace(256).append(new StringBuffer().append("AboveLimit: ").append(this.mTarget.mAboveLimit).append("Duration1: ").append(this.mTarget.mDiagDuration1).append("Duration2: ").append(this.mTarget.mDiagDuration2).toString()).log();
                    }
                    if (!this.mTarget.mAboveLimit) {
                        this.mTimeout = this.mTarget.mDiagDuration1 * 1000;
                    } else {
                        int n = this.mTarget.mDiagDuration2;
                        super.getClass();
                        if (n == -65536) {
                            this.trans(this.mTarget.stateDabSlsDiagOff);
                            return hsmState;
                        }
                        this.mTimeout = this.mTarget.mDiagDuration2 * 1000;
                    }
                    super.getClass();
                    if (this.mTimeout == 0) {
                        if (this.mNewImage != null) {
                            this.showImage(this.mNewImage);
                            this.mNewImage = null;
                            break;
                        }
                        this.trans(this.mTarget.stateDabSlsWaiting);
                        break;
                    }
                    this.startTimer();
                    break;
                }
                this.trans(this.mTarget.stateDabSlsDiagOff);
                break;
            }
            case 100100: {
                if (this.hasCurrentServiceSls()) break;
                this.trans(this.mTarget.stateDabSlsWaiting);
                break;
            }
            case 4: {
                this.stopTimer();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiDABTunerUpdateSlideShowInfo(DABSlideShowInfo dABSlideShowInfo, int n) {
        if (ServiceManager.logger.isTraceEnabled(256)) {
            ServiceManager.logger.trace(256).append("StateDabSlsShowing - updateSlideShowInfo").log();
        }
        if (this.mTarget.isItforCurrentServiceorComponent(dABSlideShowInfo)) {
            super.getClass();
            if (this.mTimeout == 0 || !this.mTarget.isSlsVisible()) {
                if (dABSlideShowInfo.slideshowImage != null) {
                    this.mTarget.mCurrentSlideShowImage = dABSlideShowInfo.slideshowImage;
                    this.mTarget.currentSlideShowState = 1;
                    this.mTarget.decideSlideShowImageOrLogoImageAndSlideShowState();
                } else {
                    this.trans(this.mTarget.stateDabSlsWaiting);
                }
            } else {
                this.mNewImage = dABSlideShowInfo.slideshowImage;
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append(new StringBuffer().append("Timeout for ").append(this.mTimeout).append("msec is activated, so waiting for timeout to show the new image :").toString()).log();
                }
                if (null != this.mNewImage && ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append(this.mNewImage.toString()).log();
                }
            }
        }
    }

    boolean hasCurrentServiceSls() {
        ServiceInfo serviceInfo = RadioData.getDabDatabase().mTunerState.getCurrentService();
        if (serviceInfo != null) {
            return RadioData.getDabDatabase().mTunerState.hasSlideShowServices(serviceInfo);
        }
        return false;
    }

    void showImage(ResourceLocator resourceLocator) {
        this.stopTimer();
        this.mTarget.mCurrentSlideShowImage = resourceLocator;
        this.mTarget.decideSlideShowImageOrLogoImageAndSlideShowState();
        if (this.mTarget.isSlsVisible()) {
            if (resourceLocator != null) {
                this.startTimer();
            } else {
                this.trans(this.mTarget.stateDabSlsWaiting);
            }
        }
    }

    void startTimer() {
        this.mTimeout = this.mTarget.mAboveLimit ? this.mTarget.mDiagDuration2 * 1000 : this.mTarget.mDiagDuration1 * 1000;
        super.getClass();
        if (this.mTimeout != 0) {
            if (ServiceManager.logger.isTraceEnabled(256)) {
                ServiceManager.logger.trace(256).append(new StringBuffer().append("Inside startTimer() with Timeout: ").append(this.mTimeout).append("Duration1: ").append(this.mTarget.mDiagDuration1).append("Duration2: ").append(this.mTarget.mDiagDuration2).toString()).log();
            }
            if (!this.mTimerRunning) {
                this.mTarget.startTimer(226951424, (long)this.mTimeout, false);
                this.mTimerRunning = true;
            }
        }
    }

    void stopTimer() {
        if (ServiceManager.logger.isTraceEnabled(256)) {
            ServiceManager.logger.trace(256).append("stopTimer is called").log();
        }
        if (this.mTimerRunning) {
            this.mTarget.stopTimer(226951424);
            if (ServiceManager.logger.isTraceEnabled(256)) {
                ServiceManager.logger.trace(256).append("Slideshow timer is stopped").log();
            }
            this.mTimerRunning = false;
        }
    }
}

