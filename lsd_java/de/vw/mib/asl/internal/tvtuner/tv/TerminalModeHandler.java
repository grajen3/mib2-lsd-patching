/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner.tv;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.tvtuner.accessor.TVTunerObjectAccessor;
import de.vw.mib.asl.internal.tvtuner.common.KeyPanelList;
import de.vw.mib.asl.internal.tvtuner.common.TVTunerHelper;
import edu.emory.mathcs.backport.java.util.Arrays;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.tvtuner.transformer.TVTunerKeyPanelListCollector;

public class TerminalModeHandler {
    private int currentTerminalMode = 0;
    private int currentScreenMode = 0;
    private boolean isTerminalModeEntered = false;
    private KeyPanelList requiredKeypanelList = new KeyPanelList(new short[0]);
    private boolean tmVideoDisclaimerShown = false;

    public void setTerminalMode(int n) {
        int n2;
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TerminalModeHandler#setTerminalMode called - terminalMode = ").append(n).toString());
        }
        int n3 = n2 = this.tmVideoDisclaimerShown ? 1 : 0;
        if (n != 0) {
            TVTunerKeyPanelListCollector tVTunerKeyPanelListCollector = this.requiredKeypanelList.getKeyPanelPositions(n);
            ListManager.getGenericASLList(-1119083008).updateList(new TVTunerKeyPanelListCollector[]{tVTunerKeyPanelListCollector});
        }
        TVTunerObjectAccessor.getTargetTVTunerDSI().getDSITVTuner().setTerminalMode(n, n2);
    }

    public void updateTerminalMode(int n, int n2) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TerminalModeHandler#updateTerminalMode called - terminalMode = ").append(n).toString());
        }
        if (n == this.currentTerminalMode) {
            if (TVTunerHelper.isTraceEnabled()) {
                TVTunerHelper.trace("TerminalModeHandler#updateTerminalMode - updated terminal mode is last tm, screenmode was updated");
            }
            return;
        }
        this.currentTerminalMode = n;
        this.currentScreenMode = n2;
        ServiceManager.aslPropertyManager.valueChangedInteger(3015, n);
        if (n == 0 && this.isTerminalModeEntered) {
            if (TVTunerHelper.isTraceEnabled()) {
                TVTunerHelper.trace("TerminalModeHandler#updateTerminalMode - leave terminal mode, send event to hmi");
            }
            TVTunerObjectAccessor.getTargetTVTuner().sendHMIEvent(463);
        } else if (n != 14) {
            if (TVTunerHelper.isTraceEnabled()) {
                TVTunerHelper.trace("TerminalModeHandler#updateTerminalMode - enter terminal mode, send event to hmi");
            }
            TVTunerObjectAccessor.getTargetTVTuner().sendHMIEvent(462);
            TVTunerObjectAccessor.getTvTunerSettings().setTMAspectRatio();
        }
    }

    public void setTerminalModeEntered(boolean bl) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TerminalModeHandler#setTerminalModeEntered called - isTerminalModeEntered = ").append(bl).toString());
        }
        this.isTerminalModeEntered = bl;
    }

    public void setRequiredKeypanelList(short[] sArray) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TerminalModeHandler#setRequiredKeypanelList( ").append(Arrays.toString(sArray)).append(" )").toString());
        }
        this.requiredKeypanelList = new KeyPanelList(sArray);
    }

    public void updateScreenMode(boolean bl) {
        this.tmVideoDisclaimerShown = bl;
        if (!this.isTerminalModeEntered) {
            if (TVTunerHelper.isTraceEnabled()) {
                TVTunerHelper.trace("TerminalModeHandler#updateScreenMode called - tm-mode not entered, skip updating screenmode");
            }
            return;
        }
        if (!this.hasTMSafetyRestrictions(this.currentTerminalMode)) {
            if (TVTunerHelper.isTraceEnabled()) {
                TVTunerHelper.trace(new StringBuffer().append("TerminalModeHandler#updateScreenMode called - tm-mode ").append(this.currentTerminalMode).append(" has no safety restrictions").toString());
            }
            return;
        }
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TerminalModeHandler#updateScreenMode called - videoDisclaimerShown = ").append(bl).toString());
        }
        this.setTerminalMode(this.currentTerminalMode);
    }

    private boolean hasTMSafetyRestrictions(int n) {
        switch (n) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 9: 
            case 11: 
            case 12: {
                return true;
            }
        }
        return false;
    }

    public void setIncMoved(int n) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TerminalModeHandler#setIncMoved called - one step ").append(n > 0 ? "right" : "left").toString());
        }
        TVTunerObjectAccessor.getTargetTVTunerDSI().getDSITVTuner().incMoved((byte)n);
    }

    public void setTMTVKey(int n, int n2) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TerminalModeHandler#setTMTVKey called - keyID = ").append(n).append(" and keyState = ").append(n2).toString());
        }
        TVTunerObjectAccessor.getTargetTVTunerDSI().getDSITVTuner().setTMTVKeyPanel((short)n, (short)n2);
    }

    public void handleGesture(int n, int n2) {
        int n3;
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TerminalModeHandler#handleGesture called - deltaX = ").append(n).append("; deltaY = ").append(n2).toString());
        }
        if (Math.abs(n) > Math.abs(n2)) {
            n3 = 11 == this.getCurrentTerminalMode() ? (n > 0 ? 14 : 15) : (n > 0 ? 42 : 43);
        } else if (11 == this.getCurrentTerminalMode()) {
            n3 = n2 > 0 ? 12 : 13;
        } else {
            int n4 = n3 = n2 > 0 ? 40 : 41;
        }
        if (TVTunerHelper.isTraceEnabled()) {
            if (11 == this.getCurrentTerminalMode()) {
                TVTunerHelper.trace(new StringBuffer().append("TerminalModeHandler#handleGesture - recognized gesture ").append(n3 == 15 ? "east" : (n3 == 14 ? "west" : (n3 == 12 ? "north" : "south"))).toString());
            } else {
                TVTunerHelper.trace(new StringBuffer().append("TerminalModeHandler#handleGesture - recognized gesture ").append(n3 == 43 ? "east" : (n3 == 42 ? "west" : (n3 == 40 ? "north" : "south"))).toString());
            }
        }
        this.setTMTVKey(n3, 1);
        this.setTMTVKey(n3, 0);
    }

    public int getCurrentTerminalMode() {
        return this.currentTerminalMode;
    }
}

