/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm;

import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.internal.exboxm.AbstractExBoxM;
import de.vw.mib.asl.internal.exboxm.IntIntMiniMap;
import de.vw.mib.asl.internal.exboxm.TargetASLExBoxM;
import de.vw.mib.asl.internal.exboxm.services.ExboxServices;
import de.vw.mib.asl.internal.exboxm.services.ExboxServicesProvider;
import de.vw.mib.asl.internal.exboxm.util.ExboxLogger;
import org.dsi.ifc.exboxm.DSIExBoxM;

public class ExBoxMDisplay
extends AbstractExBoxM {
    public static final int DISPLAYCONTEXT_SDS;
    private static final int FADEOUT_TIMEOUT;
    private static final int FADEIN_TIMEOUT;
    private int fadeOutTimerCurrentId = 0;
    private int fadeInTimerCurrentId = 0;
    private int currentDisplayContext = -1;
    private int nextASLContextValue = 0;
    private int nextASLContextFlag = 0;
    public static final int NEXTASLCONTEXTFLAG_OFF;
    public static final int NEXTASLCONTEXTFLAG_HARD;
    public static final int NEXTASLCONTEXTFLAG_SOFT;
    public static final int ASL_CONTEXT_UNDEFINED;
    public static final int DSI_CONTEXT_UNDEFINED;
    private static final IntIntMiniMap DISPLAYCONTEXT_ASL2DSI;
    private static final IntIntMiniMap DISPLAYCONTEXT_DSI2ASL;
    private static final IntIntMiniMap DISPLAYREQUEST_DSI2ASL;
    private DSIExBoxM dsiExBoxM;
    private int displayContextActivationMarker = 0;
    private static final int DISPLAY_CONTEXT_ACTIVATION_MARKER_EMPTY;
    private static final int DISPLAY_CONTEXT_DSI_SEND_MARKER_FOR_EA;
    private static final int DISPLAY_CONTEXT_DSI_SEND_MARKER_FOR_SDS_F40;
    private ExboxServices exboxServices = ExboxServicesProvider.getExBoxServices();
    private final ExboxLogger exboxLogger = new ExboxLogger(this.exboxServices.getLogger(), super.getClass());
    private int contextBeforeSleep = 0;
    private boolean recoveryState = false;
    private boolean sleepingState = false;

    public ExBoxMDisplay(TargetASLExBoxM targetASLExBoxM) {
        super(targetASLExBoxM);
    }

    public void connectAndStart(DSIExBoxM dSIExBoxM) {
        this.dsiExBoxM = dSIExBoxM;
        this.setCurrentAslContext(0);
        this.signalContextChangeToHMI();
    }

    public void signalContextChangeToHMI() {
        int n = this.getCurrentDSIContext();
        String string = DISPLAYCONTEXT_DSI2ASL.getName(n);
        int n2 = DISPLAYCONTEXT_DSI2ASL.get(n);
        this.exboxLogger.trace(new Object[]{"signalContextChangeToHMI called! DSI context = ", new Integer(n), " (", string, "), ASL context = ", new Integer(n2), ". See ASL.ExBoxM.activeContext and EXBOXM_ACTIVE_CONTEXT_CHANGED in GUIDE."});
        AbstractASLTarget.writeIntegerToDatapool(2788, n2);
    }

    public void indicateDisplayRequest(int n) {
        String string = DISPLAYCONTEXT_DSI2ASL.getName(n);
        this.exboxLogger.trace(new Object[]{"indicateDisplayRequest called! DSI context = ", new Integer(n), " (", string, ")."});
        if (DISPLAYREQUEST_DSI2ASL.isUnknownKey(n)) {
            this.exboxLogger.error(new StringBuffer().append("indicateDisplayRequest: DSI context ").append(n).append("is unknown! Return.").toString());
            return;
        }
        this.exboxLogger.trace(new Object[]{"displayContextActivationMarker=", new Integer(this.displayContextActivationMarker)});
        switch (n) {
            case 0: {
                if (this.displayContextActivationMarker == 7 || this.displayContextActivationMarker == 8) {
                    this.sendDisplayContextToHMI(n);
                }
                this.resetDisplayFlags();
                break;
            }
            case 3: 
            case 4: 
            case 7: {
                this.sendDisplayContextToHMI(n);
                this.resetDisplayFlags();
                break;
            }
            default: {
                this.exboxLogger.trace("Display request not handled.");
                this.resetDisplayFlags();
            }
        }
    }

    public void sendDisplayContextToHMI(int n) {
        String string = DISPLAYREQUEST_DSI2ASL.getName(n);
        this.exboxLogger.trace(new Object[]{"sendDisplayContextToHMI called! DSI context = ", new Integer(n), " (", string, "). See ASL.ExBoxM.requestContext and EXBOXM_REQUEST_CONTEXT_CHANGED in GUIDE."});
        int n2 = DISPLAYREQUEST_DSI2ASL.get(n);
        AbstractASLTarget.writeIntegerToDatapool(3504, n2);
    }

    public void resetDisplayFlags() {
        this.exboxLogger.trace("resetDisplayFlags called!");
        if (this.displayContextActivationMarker == 7) {
            this.exboxLogger.trace("Display wakeup marker reset.");
            ExboxServicesProvider.getExBoxServices().getProximityInstaller().resumeProximity(2);
        }
        if (this.displayContextActivationMarker != 0) {
            this.displayContextActivationMarker = 0;
            this.exboxLogger.trace("DisplayRequest activation marker reset.");
        }
        if (this.displayContextActivationMarker == 0) {
            this.exboxLogger.trace("displayContextActivationMarker is empty! Nothing to reset.");
        }
    }

    protected void switchDisplayResponse() {
        this.exboxLogger.trace("switchDisplayResponse called! See in GUIDE EXBOXM_DISPLAY_CONTROL_SWITCHED.");
        this.sendHMIEvent(445);
    }

    protected void signalSwitchDisplayControlToDSI() {
        this.exboxLogger.trace(new Object[]{"signalSwitchDisplayControlToDSI called! Display context is ", this.getCurrentDSIContext4log(), "."});
        int n = this.getCurrentDSIContext();
        if (n != -1) {
            this.dsiExBoxM.displayControl(n);
        }
    }

    protected void startFadeOutTimer() {
        this.exboxLogger.trace("startFadeOutTimer called!");
        this.fadeOutTimerCurrentId = this.startUniqueTimer(-1517944576, 1000);
    }

    protected void stopFadeOutTimer() {
        this.fadeOutTimerCurrentId = 0;
    }

    protected void fadeOutTimerElapsed() {
        this.exboxLogger.trace("fadeOutTimerElapsed called! See in GUIDE EXBOXM_FADEOUT_TIMEOUT.");
        this.sendHMIEvent(481);
    }

    public int getFadeOutTimerCurrentId() {
        return this.fadeOutTimerCurrentId;
    }

    protected void startFadeInTimer() {
        this.exboxLogger.trace("startFadeInTimer called!");
        this.fadeInTimerCurrentId = this.startUniqueTimer(-1517944576, 1000);
    }

    protected void stopFadeInTimer() {
        this.fadeInTimerCurrentId = 0;
    }

    protected void fadeInTimerElapsed() {
        this.exboxLogger.trace("fadeInTimerElapsed called! See in GUIDE EXBOXM_FADEIN_TIMEOUT.");
        this.sendHMIEvent(482);
    }

    public int getFadeInTimerCurrentId() {
        return this.fadeInTimerCurrentId;
    }

    boolean isEntertainmentDMBAudioSourceFromCurrentDisplayContext() {
        return this.getCurrentDSIContext() == 1;
    }

    protected void setCurrentAslContext(int n) {
        String string = DISPLAYCONTEXT_ASL2DSI.getName(n);
        this.exboxLogger.trace(new Object[]{"setCurrentAslContext called! ASL context = ", new Integer(n), " (", string, ")."});
        this.clearSleepState();
        this.processFlagsForNewContext(n);
        this.currentDisplayContext = DISPLAYCONTEXT_ASL2DSI.get(n);
    }

    private void processFlagsForNewContext(int n) {
        this.exboxLogger.trace(new Object[]{"processFlagsForNewContext called! ASL context = ", new Integer(n), "."});
        switch (n) {
            case 7: {
                this.displayContextActivationMarker = 7;
                this.exboxLogger.trace("Set displayContextActivationMarker = EA.");
                ASLSystemFactory.getSystemApi().getEmergencyAnnouncementService().setEmergencyAnnouncementState(true);
                ExboxServicesProvider.getExBoxServices().getProximityInstaller().pauseProximity(2, true);
                break;
            }
            case 8: {
                this.displayContextActivationMarker = 8;
                this.exboxLogger.trace("Set displayContextActivationMarker = SDS.");
                break;
            }
            default: {
                ASLSystemFactory.getSystemApi().getEmergencyAnnouncementService().setEmergencyAnnouncementState(false);
                this.resetDisplayFlags();
            }
        }
    }

    public boolean isCurrentContext(int n) {
        return this.currentDisplayContext == n;
    }

    public int getCurrentDSIContext() {
        return this.currentDisplayContext;
    }

    public String getCurrentDSIContext4log() {
        return DISPLAYCONTEXT_DSI2ASL.getName(this.currentDisplayContext);
    }

    public void setNextASLContext(int n, int n2) {
        String string = DISPLAYCONTEXT_ASL2DSI.getName(n);
        this.exboxLogger.trace(new Object[]{"setNextASLContext called! ASL context = ", new Integer(n), " (", string, ")."});
        this.nextASLContextValue = n;
        this.nextASLContextFlag = n2;
    }

    public void clearNextASLContext() {
        this.nextASLContextValue = 0;
        this.nextASLContextFlag = 0;
    }

    public int hasNextASLContext() {
        return this.nextASLContextFlag;
    }

    public int getNextASLContext() {
        return this.nextASLContextValue;
    }

    public void setDisplayAsleep() {
        this.exboxLogger.trace("setDisplayAsleep called!");
        if (this.currentDisplayContext == -1) {
            this.exboxLogger.error("Will not set standby, because of undefined state.");
            return;
        }
        if (this.isAtSleep()) {
            return;
        }
        if (this.isAtRecovery()) {
            this.clearSleepState();
            this.exboxLogger.trace("Unexpected sleep request.");
        } else {
            this.contextBeforeSleep = this.currentDisplayContext;
            this.currentDisplayContext = 0;
            this.signalSwitchDisplayControlToDSI();
            this.sleepingState = true;
            this.recoveryState = false;
        }
    }

    public void setDisplayAwake() {
        this.exboxLogger.trace("setDisplayAwake called!");
        if (this.isAtSleep()) {
            this.currentDisplayContext = this.contextBeforeSleep;
            this.recoveryState = true;
            this.sleepingState = false;
            this.signalSwitchDisplayControlToDSI();
        }
    }

    public boolean isAtSleep() {
        return this.sleepingState;
    }

    public boolean isAtRecovery() {
        return this.recoveryState;
    }

    public void clearSleepState() {
        this.contextBeforeSleep = 0;
        this.recoveryState = false;
        this.sleepingState = false;
    }

    static {
        DISPLAYCONTEXT_ASL2DSI = new IntIntMiniMap(-1, "HMI|DMB|Navigation|TPEG|EA|SDS|Undefined", new int[]{0, 0, 1, 1, 3, 3, 4, 4, 7, 7, 8, 8, -1, -1});
        DISPLAYCONTEXT_DSI2ASL = new IntIntMiniMap(-1, "HMI|DMB|Navigation|TPEG|EA|SDS|Undefined", new int[]{0, 0, 1, 1, 3, 3, 4, 4, 7, 7, 8, 8, -1, -1});
        DISPLAYREQUEST_DSI2ASL = new IntIntMiniMap(0, "BACK|Navigation|TPEG|EA|SDS", new int[]{0, 0, 3, 3, 4, 4, 7, 7, 8, 8});
    }
}

