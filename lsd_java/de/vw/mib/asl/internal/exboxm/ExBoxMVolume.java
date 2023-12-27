/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.internal.exboxm.AbstractExBoxM;
import de.vw.mib.asl.internal.exboxm.IntIntMiniMap;
import de.vw.mib.asl.internal.exboxm.TargetASLExBoxM;
import de.vw.mib.asl.internal.exboxm.services.ExboxServices;
import de.vw.mib.asl.internal.exboxm.services.ExboxServicesProvider;
import de.vw.mib.asl.internal.exboxm.util.ExboxLogger;
import de.vw.mib.log4mib.LogMessage;
import java.util.BitSet;
import org.dsi.ifc.audio.DSISound;
import org.dsi.ifc.exboxm.DSIExBoxM;

public class ExBoxMVolume
extends AbstractExBoxM {
    private ExboxServices exboxServices;
    private final ExboxLogger exboxLogger;
    private static final int VOLUME_DISPLAY_TIME_WINDOW_BEFORE;
    private DSIExBoxM dsiExBoxM;
    public static final int ENTERTAINMENT_RANGE;
    private static final int MENU_VOLUME_RANGE_NAV;
    private static final int MENU_VOLUME_RANGE_PHONE;
    private static final int MENU_VOLUME_RANGE_SDS;
    private static final int EXBOX_VOLUME_IGNORED_INDEX;
    private static final int EXBOX_VOLUME_ENTERTAINMENT_INDEX;
    private static final int EXBOX_VOLUME_NAVIGATION_INDEX;
    private static final int EXBOX_VOLUME_PHONE_INDEX;
    private static final int EXBOX_VOLUME_SDS_INDEX;
    private static final int EXBOX_VOLUME_SIZE;
    private static final IntIntMiniMap RANGECONNECTION_DSI2INDEX;
    private static final int UNSPECIFIED_VOLUME_INDEX;
    private static final IntIntMiniMap VOLUMESOURCE_INDEX2DSI;
    private int[] minValues = new int[4];
    private int[] maxValues = new int[4];
    private int[] curValues = new int[4];
    private final BitSet missingVolumeRanges = new BitSet(1);
    private boolean userMute = false;
    private boolean fullValideVolumeRangesSend = false;
    private long UNSET_TIME;
    private long lastForceDisplayVolumeTime = this.UNSET_TIME = Integer.MIN_VALUE;
    private long lastRefreshTime = this.UNSET_TIME;
    private int volumeFocus = 0;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$exboxm$TargetASLExBoxM;

    ExBoxMVolume(TargetASLExBoxM targetASLExBoxM, DSIExBoxM dSIExBoxM) {
        super(targetASLExBoxM);
        this.dsiExBoxM = dSIExBoxM;
        this.exboxServices = ExboxServicesProvider.getExBoxServices();
        this.exboxLogger = new ExboxLogger(this.exboxServices.getLogger(), class$de$vw$mib$asl$internal$exboxm$TargetASLExBoxM == null ? (class$de$vw$mib$asl$internal$exboxm$TargetASLExBoxM = ExBoxMVolume.class$("de.vw.mib.asl.internal.exboxm.TargetASLExBoxM")) : class$de$vw$mib$asl$internal$exboxm$TargetASLExBoxM);
        this.resetVolumeSettings(true);
    }

    public void requestVolumeRanges(DSISound dSISound) {
        this.exboxLogger.trace("requestVolumeRanges called. Get volume ranges of NAV, PHONE, SDS.");
        this.resetVolumeSettings(false);
        dSISound.getMenuVolumeRange(83, 1);
        dSISound.getMenuVolumeRange(87, 1);
        dSISound.getMenuVolumeRange(86, 1);
    }

    public void setVolumeRange(int n, int n2, int n3) {
        if (RANGECONNECTION_DSI2INDEX.isUnknownKey(n)) {
            if (this.isTraceEnabledEx()) {
                LogMessage logMessage = this.traceEx().append("EX:DSI>ASL Volume Range for unknown audio connection received. DSI connection ");
                logMessage.append(n).append(" := ").append(n2).append("..").append(n3);
                logMessage.log();
            }
            return;
        }
        int n4 = RANGECONNECTION_DSI2INDEX.get(n);
        if (this.missingVolumeRanges.get(n4) || this.minValues[n4] != n2 || this.maxValues[n4] != n3) {
            this.minValues[n4] = n2;
            this.maxValues[n4] = n3;
            this.missingVolumeRanges.clear(n4);
            if (this.isTraceEnabledEx()) {
                LogMessage logMessage = this.traceEx().append("EX:DSI>ASL Volume Range for audio connection received. Connection ");
                logMessage.append(RANGECONNECTION_DSI2INDEX.getName(n)).append(" := ").append(n2).append("..").append(n3);
                logMessage.append(" missing ").append(this.missingVolumeRanges.toString());
                logMessage.log();
            }
            this.refreshVolumeSettings(false);
        } else {
            this.errorEx().append("EX:volume Range already received for: ").append(RANGECONNECTION_DSI2INDEX.getName(n)).log();
        }
    }

    public void refreshVolumeSettings(boolean bl) {
        if (this.checkIfInitializationComplete()) {
            if (this.isExBoxOperationStateNormal()) {
                this.signalVolumeRangeToDSI(bl);
            } else if (this.isTraceEnabledEx()) {
                this.traceEx().append("EX:ASL>?DSI? refresh volume settings interrupted because exbox operation state is not normal").log();
            }
        } else if (this.isTraceEnabledEx()) {
            this.traceEx().append("EX:Refresh volume settings interrupted because volume data not complette").log();
        }
    }

    private boolean checkIfInitializationComplete() {
        return this.missingVolumeRanges.isEmpty();
    }

    private void signalVolumeRangeToDSI(boolean bl) {
        if (!this.fullValideVolumeRangesSend || bl) {
            if (this.isTraceEnabledEx()) {
                LogMessage logMessage = this.traceEx().append("EX:ASL>DSI signal DSI volume range. ");
                logMessage.append("Entertainment := ");
                logMessage.append(this.minValues[0]).append("..").append(this.maxValues[0]);
                logMessage.append(", Navigation := ");
                logMessage.append(this.minValues[1]).append("..").append(this.maxValues[1]).append(", ");
                logMessage.append(", Phone := ");
                logMessage.append(this.minValues[2]).append("..").append(this.maxValues[2]).append(", ");
                logMessage.append(", SDS := ");
                logMessage.append(this.minValues[3]).append("..").append(this.maxValues[3]);
                logMessage.log();
            }
            this.dsiExBoxM.volumeRange(this.minValues[0], this.maxValues[0], this.minValues[1], this.maxValues[1], this.minValues[2], this.maxValues[2], this.minValues[3], this.maxValues[3]);
            this.fullValideVolumeRangesSend = this.checkIfInitializationComplete();
        }
        this.refreshUserMute();
    }

    private void resetVolumeSettings(boolean bl) {
        if (this.isTraceEnabledEx()) {
            this.traceEx().append("EX: reset volume ranges: ").append(this.missingVolumeRanges.toString()).log();
        }
        if (bl) {
            this.missingVolumeRanges.set(0, 1, true);
            this.fullValideVolumeRangesSend = false;
        }
        for (int i2 = 1; i2 < 4; ++i2) {
            this.minValues[i2] = 0;
            this.maxValues[i2] = 30;
        }
    }

    private int getVolumeValueConnectionIndex(int n) {
        switch (n) {
            case 9: 
            case 12: 
            case 13: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 23: 
            case 24: 
            case 26: 
            case 27: 
            case 28: 
            case 84: 
            case 91: 
            case 95: 
            case 201: 
            case 214: 
            case 215: 
            case 216: 
            case 217: {
                return 0;
            }
            case 83: 
            case 116: 
            case 117: 
            case 220: 
            case 221: {
                return 1;
            }
            case 87: 
            case 88: 
            case 89: 
            case 90: 
            case 97: 
            case 98: 
            case 99: 
            case 103: 
            case 104: 
            case 212: 
            case 218: {
                return 2;
            }
            case 86: 
            case 112: 
            case 114: 
            case 115: 
            case 118: 
            case 119: 
            case 126: 
            case 127: 
            case 219: {
                return 3;
            }
            case 8: {
                return 0;
            }
            case 122: {
                return -1;
            }
        }
        if (this.isTraceEnabledEx()) {
            this.traceEx().append("EX:DSI>ASL Map volume class for an unmapped audio connection to Entertainment. DSI connection: ").append(n).log();
        }
        return 0;
    }

    public void setActiveConnection(int n) {
        int n2 = this.getVolumeValueConnectionIndex(n);
        if (n2 < 0) {
            if (this.isTraceEnabledEx()) {
                this.traceEx().append("EX:DSI>ASL Ignored set active connection for connection >").append(n).append("<").log();
            }
            return;
        }
        if (n2 != this.volumeFocus) {
            this.volumeFocus = n2;
            this.lastForceDisplayVolumeTime = this.UNSET_TIME;
            this.lastRefreshTime = this.UNSET_TIME;
            if (this.isTraceEnabledEx()) {
                this.traceEx().append("EX:DSI>ASL Set volume focus to: ").append(VOLUMESOURCE_INDEX2DSI.getName(this.volumeFocus)).log();
            }
            this.refreshUserMute();
        }
    }

    public void updateVolume(int n, int n2, int n3) {
        if (this.isTraceEnabledEx()) {
            this.traceEx().append("EX:DSI>ASL updateVolume received - value >").append(n2).append("< for connection >").append(n).append("<").log();
        }
        if (n3 != 1) {
            LogMessage logMessage = this.errorEx().append("EX:DSI>ASL Update volume for audio connection with invalid flag. DSI connection: ");
            logMessage.append(n).append(", flag: ").append(n3);
            logMessage.log();
            return;
        }
        int n4 = this.getVolumeValueConnectionIndex(n);
        if (n4 < 0) {
            if (this.isTraceEnabledEx()) {
                this.traceEx().append("EX:DSI>ASL Ignored volume update for connection >").append(n).append("<").log();
            }
            return;
        }
        if (VOLUMESOURCE_INDEX2DSI.isUnknownKey(n4)) {
            LogMessage logMessage = this.errorEx().append("EX:DSI>ASL Update volume for unknown audio connection. DSI connection: ");
            logMessage.append(n);
            logMessage.log();
            return;
        }
        if (n4 == this.volumeFocus && this.curValues[n4] != n2 && this.getCurrentTime() - this.lastRefreshTime < 0) {
            this.curValues[n4] = n2;
            this.displayVolume();
        } else {
            this.curValues[n4] = n2;
        }
    }

    private long getCurrentTime() {
        return ASLFrameworkFactory.getASLFrameworkAPI().getServices().getTimerManager().getSystemTimeMillis();
    }

    protected void refreshVolume() {
        long l = this.getCurrentTime();
        if (l - this.lastForceDisplayVolumeTime > 0) {
            this.lastForceDisplayVolumeTime = l;
            this.displayVolume();
        }
        this.lastRefreshTime = l;
    }

    private void displayVolume() {
        if (this.volumeFocus == -1) {
            if (this.isTraceEnabledEx()) {
                this.traceEx().append("EX:ASL>DSI: Display volume on ExBox skipped: Unknown volume focus.").log();
            }
            return;
        }
        if (this.isExBoxOperationStateNormal()) {
            int n;
            if (!this.fullValideVolumeRangesSend) {
                this.errorEx().append("EX:ASL>DSI Display volume received before volume range collection is complete. Default Ranges will be set").log();
                for (n = 0; n < 4; ++n) {
                    if (!this.missingVolumeRanges.get(n)) continue;
                    this.minValues[n] = 0;
                    this.maxValues[n] = 30;
                }
                this.signalVolumeRangeToDSI(true);
            }
            n = this.curValues[this.volumeFocus];
            if (this.isTraceEnabledEx()) {
                LogMessage logMessage = this.traceEx().append("EX:ASL>DSI: Display volume on ExBox: ");
                logMessage.append(VOLUMESOURCE_INDEX2DSI.getName(this.volumeFocus)).append(" := ").append(n);
                logMessage.append(" in range ").append(this.minValues[this.volumeFocus]).append("..").append(this.maxValues[this.volumeFocus]);
                logMessage.log();
            }
            this.dsiExBoxM.displayCurrentVolume(VOLUMESOURCE_INDEX2DSI.get(this.volumeFocus), n);
        } else if (this.isTraceEnabledEx()) {
            this.traceEx().append("EX:ASL>?DSI? Display volume changed but not communicated to exbox because exbox operation state is not normal").log();
        }
    }

    private void refreshUserMute() {
        this.exboxLogger.trace("refreshUserMute called!");
        if (this.isExBoxOperationStateNormal()) {
            if (this.userMute) {
                this.dsiExBoxM.displayCurrentVolume(VOLUMESOURCE_INDEX2DSI.get(this.volumeFocus), 254);
                this.exboxLogger.trace("Mute value 254 was sent to ExBox.");
            } else {
                this.dsiExBoxM.displayCurrentVolume(VOLUMESOURCE_INDEX2DSI.get(this.volumeFocus), 255);
                this.exboxLogger.trace("De-mute value 255 was sent to ExBox.");
            }
        } else {
            this.exboxLogger.trace("No refresh of mute state. ExBox operation state is not normal.");
        }
    }

    public void setUserMute(boolean bl) {
        this.userMute = bl;
        this.refreshUserMute();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        RANGECONNECTION_DSI2INDEX = new IntIntMiniMap(-1, "Entertainment", new int[]{0, 0});
        VOLUMESOURCE_INDEX2DSI = new IntIntMiniMap(-1, "Entertainment|Navigation|Phone|SDS", new int[]{0, 1, 1, 2, 2, 3, 3, 4});
    }
}

