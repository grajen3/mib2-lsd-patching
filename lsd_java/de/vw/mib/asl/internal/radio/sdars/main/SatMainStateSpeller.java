/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.main;

import de.vw.mib.asl.internal.radio.GuiApiTunerCommon;
import de.vw.mib.asl.internal.radio.sdars.helper.ChannelListFromSouth;
import de.vw.mib.asl.internal.radio.sdars.helper.SatConfig;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.main.AbstractMainState;
import de.vw.mib.asl.internal.radio.sdars.main.SatMainTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import java.util.Iterator;
import org.dsi.ifc.sdars.StationInfo;

final class SatMainStateSpeller
extends AbstractMainState {
    private static final int RADIX;
    private static final int MAXDIGITS;
    private static final int INVALID;
    private final StringBuffer mChannelNumberEntered = new StringBuffer(6);
    private static final String CHARSET;
    private char[][] mNumbers;
    private boolean mUseChannelFilter = false;

    SatMainStateSpeller(SatDb satDb, SatMainTarget satMainTarget, Hsm hsm, HsmState hsmState) {
        super(satDb, satMainTarget, hsm, "stateSpeller", hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        block1 : switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.mPool.setString(39, this.getName());
                this.mPool.setBoolean(29, true);
                this.mPool.setBoolean(182, false);
                this.fill();
                this.mChannelNumberEntered.delete(0, this.mChannelNumberEntered.length());
                this.getModelApi().updateSpellerDataForEnteringChannelNumber(this.prepareDigitString(), this.mChannelNumberEntered.toString(), "", 0, this.mChannelNumberEntered.length(), 0, 0);
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                this.mTarget.stopTimer(-1450835712);
                this.getLogHandler().simpleTrace("updateRadioManualMode called from SatMainStateSpeller HSM_EXIT");
                GuiApiTunerCommon.updateRadioManualMode(false);
                this.mPool.setBoolean(29, false);
                this.mPool.removeListener(21, this.mTarget.getTargetId(), -1333395200);
                break;
            }
            case 100009: {
                this.getModelApi().updateSpellerDataForEnteringChannelNumber(this.prepareDigitString(), this.mChannelNumberEntered.toString(), "", 0, this.mChannelNumberEntered.length(), 0, 0);
                break;
            }
            case 0x40000460: {
                int n = eventGeneric.getInt(0);
                LogMessage logMessage = this.getLogHandler().getLogMsg();
                if (logMessage == null) break;
                logMessage.append("Speller enters a ").append(n).log();
                break;
            }
            case 1073742958: {
                String string = this.mChannelNumberEntered.toString();
                if (string.length() <= 0) break;
                try {
                    int n = Integer.parseInt(string);
                    if (n > 999 || n < 0) {
                        this.showAdvisory("Illegal channel");
                        break;
                    }
                    switch (n) {
                        case 0: {
                            this.getTuneHandler().tuneChannel(13, SatConfig.ZERO_CHANNEL, false);
                            this.getLogHandler().simpleTrace("updateRadioManualMode called after tune Zero Channel");
                            GuiApiTunerCommon.updateRadioManualMode(false);
                            break block1;
                        }
                    }
                    StationInfo stationInfo = this.getChannels().getChannel(n);
                    if (stationInfo != null) {
                        this.mPool.addListener(21, this.mTarget.getTargetId(), -1333395200);
                        this.getTuneHandler().tuneChannel(13, stationInfo, false, this.mTarget.getTargetId(), 0);
                    } else {
                        this.showAdvisory("Invalid channel");
                    }
                    GuiApiTunerCommon.updateRadioManualMode(false);
                }
                catch (Exception exception) {}
                break;
            }
            case 1073742959: {
                this.mChannelNumberEntered.deleteCharAt(this.mChannelNumberEntered.length() - 1);
                this.getModelApi().updateSpellerDataForEnteringChannelNumber(this.prepareDigitString(), this.mChannelNumberEntered.toString(), "", 0, this.mChannelNumberEntered.length(), 0, 0);
                boolean bl = this.checkIfChannelExist();
                this.mPool.setBoolean(182, bl);
                break;
            }
            case 1073742961: {
                String string = eventGeneric.getString(0);
                this.mChannelNumberEntered.append(string);
                this.getModelApi().updateSpellerDataForEnteringChannelNumber(this.prepareDigitString(), this.mChannelNumberEntered.toString(), "", 0, this.mChannelNumberEntered.length(), 0, 0);
                boolean bl = this.checkIfChannelExist();
                this.mPool.setBoolean(182, bl);
                break;
            }
            case 1073742957: {
                this.mTarget.transStateMainIdle();
                break;
            }
            case 0x40000470: {
                break;
            }
            case 100016: {
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void fill() {
        if (this.mUseChannelFilter) {
            ChannelListFromSouth channelListFromSouth = this.getChannels();
            int n = 0;
            Iterator iterator = channelListFromSouth.iterator();
            while (iterator.hasNext()) {
                StationInfo stationInfo = (StationInfo)iterator.next();
                if (stationInfo.subscription != 2) continue;
                ++n;
            }
            this.mNumbers = new char[n][4];
            int n2 = 0;
            iterator = channelListFromSouth.iterator();
            while (iterator.hasNext()) {
                StationInfo stationInfo = (StationInfo)iterator.next();
                if (stationInfo.subscription != 2) continue;
                String string = Integer.toString(stationInfo.stationNumber);
                for (int i2 = 0; i2 < 4; ++i2) {
                    this.mNumbers[n2][i2] = i2 < string.length() ? string.charAt(i2) : (char)2;
                }
                ++n2;
            }
        }
    }

    private String prepareDigitString() {
        int n;
        if (!this.mUseChannelFilter) {
            return "0123456789";
        }
        boolean[] blArray = new boolean[10];
        char[] cArray = this.mChannelNumberEntered.toString().toCharArray();
        int n2 = cArray.length;
        if (n2 >= 4) {
            return "";
        }
        for (int i2 = 0; i2 < this.mNumbers.length; ++i2) {
            int n3;
            n = 1;
            for (n3 = 0; n3 < n2; ++n3) {
                if (this.mNumbers[i2][n3] == cArray[n3]) continue;
                n = 0;
                break;
            }
            if (n == 0 || this.mNumbers[i2][n2] == '\u0002') continue;
            n3 = this.mNumbers[i2][n2] - 48;
            if (n3 < 0) {
                blArray[0] = true;
            }
            if (n3 >= 10) continue;
            blArray[n3] = true;
        }
        StringBuffer stringBuffer = new StringBuffer(10);
        for (n = 0; n < blArray.length; ++n) {
            if (!blArray[n]) continue;
            stringBuffer.append("0123456789".charAt(n));
        }
        String string = stringBuffer.toString();
        return string;
    }

    private void showAdvisory(String string) {
        this.getModelApi().updateSpellerDataForEnteringChannelNumber("", string, "", 0, 0, 0, 0);
        int n = this.mPool.getInt(60);
        this.mTarget.startTimer(-1450835712, (long)n, false);
        this.mChannelNumberEntered.setLength(0);
    }

    private boolean checkIfChannelExist() {
        String string = this.mChannelNumberEntered.toString();
        if (string.length() == 0) {
            return false;
        }
        int n = -1;
        try {
            n = Integer.parseInt(string);
        }
        catch (Exception exception) {
            return false;
        }
        if (n < 0 || n > 999) {
            return false;
        }
        if (n == 0) {
            return true;
        }
        StationInfo stationInfo = this.getChannels().getChannel(n);
        return null != stationInfo && null != this.mDb && null != this.mDb.getChannels() && stationInfo.getSubscription() == 2 && !this.mDb.getChannels().isInvalid(stationInfo.sID);
    }
}

