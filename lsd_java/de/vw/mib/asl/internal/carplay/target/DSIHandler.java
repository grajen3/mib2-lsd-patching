/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.carplay.target;

import de.vw.mib.asl.internal.carplay.audio.CarPlayAudiohandling;
import de.vw.mib.asl.internal.carplay.common.CarPlayGlobalProperies;
import de.vw.mib.asl.internal.carplay.common.CarPlayModeHandling;
import de.vw.mib.asl.internal.carplay.target.HsmTarget;
import de.vw.mib.log4mib.LogMessage;
import java.util.Hashtable;
import java.util.Iterator;
import org.dsi.ifc.carplay.AppState;
import org.dsi.ifc.carplay.CallState;
import org.dsi.ifc.carplay.Resource;
import org.dsi.ifc.carplay.TelephonyState;

public class DSIHandler {
    private final String classname;
    private HsmTarget target;
    private CarPlayGlobalProperies properties;
    private CarPlayModeHandling modehandling;
    private CarPlayAudiohandling audiohandling;

    public DSIHandler(HsmTarget hsmTarget, CarPlayGlobalProperies carPlayGlobalProperies, CarPlayModeHandling carPlayModeHandling, CarPlayAudiohandling carPlayAudiohandling) {
        this.classname = "DSIController";
        this.target = hsmTarget;
        this.properties = carPlayGlobalProperies;
        this.modehandling = carPlayModeHandling;
        this.audiohandling = carPlayAudiohandling;
    }

    public void handledsiCarPlayupdateMode(Resource[] resourceArray, AppState[] appStateArray) {
        this.modehandling.handleModeChanges(resourceArray, appStateArray);
        this.target.getDSICarPlay().responseUpdateMode(resourceArray, appStateArray);
    }

    public void handledsiCarPlayResponseModeChange(Resource[] resourceArray, AppState[] appStateArray) {
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append("DSIController").append(".").append("handledsiCarPlayResponseModeChange - dont react").log();
        }
    }

    public void handledsiCarPlayUpdateDeviceInfo() {
    }

    public void handledsiCarPlayOemAppSelected() {
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append("DSIController").append(".").append("handledsiCarPlayOemAppSelected").log();
        }
        this.target.triggerObserver(655645952, null);
    }

    public void handledsiCarPlayUpdateMainAudioType(int n) {
        this.properties.setPhoneWaitsForResponseMainAudioType(true);
        if (this.properties.getCurrentMainAudioSource() == 2) {
            if (this.target.getTimerServer().isTimerActive(this.target.getTargetId(), -1417281280)) {
                this.target.stopTimer(-1417281280);
            }
            if (n == 0) {
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("DSIController").append(".handledsiCarPlayUpdateMainAudioType - Teardown detected, delay execution and start timer").log();
                }
                this.target.startTimer(-1417281280, (long)0, false);
            } else {
                this.audiohandling.handleAudioSourceChange(n, this.properties.getCurrentMainAudioSource(), true);
                this.properties.setCurrentMainAudioType(n);
            }
            if (this.target.getTimerServer().isTimerActive(this.target.getTargetId(), -1434058496)) {
                this.target.stopTimer(-1434058496);
            }
            this.target.startTimer(-1434058496, (long)0, false);
        } else {
            this.properties.setPhoneWaitsForResponseMainAudioType(false);
            this.target.getDSICarPlay().responseUpdateMainAudioType(n);
            this.properties.setCurrentMainAudioType(n);
        }
    }

    public void handledsiCarPlayDuckAudio(int n, double d2) {
        this.audiohandling.setAudioConnection(155, true);
    }

    public void handledsiCarPlayUnduckAudio(int n) {
        this.audiohandling.releaseAudioConnection(155, true);
    }

    public void handleUpdateTelephonyState(TelephonyState telephonyState) {
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append("DSIController").append(".").append("handleUpdateTelephonyState").log();
        }
        this.properties.setTelephonyStateValid(true);
        this.properties.setCurrentTelephonyState(telephonyState);
    }

    public boolean handledsiUpdateCallState(CallState[] callStateArray) {
        Hashtable hashtable = this.properties.getCurrentCallStates();
        for (int i2 = 0; i2 < callStateArray.length; ++i2) {
            if (callStateArray[i2].getStatus() == 0) {
                if (!hashtable.containsKey(callStateArray[i2].getUniqueCallID())) continue;
                hashtable.remove(callStateArray[i2].getUniqueCallID());
                continue;
            }
            hashtable.put(callStateArray[i2].getUniqueCallID(), callStateArray[i2]);
        }
        this.properties.setCurrentCallStates(hashtable);
        this.target.getClusterService().sendCallStatesUpdate();
        if (this.properties.getOcuCallState() != 0) {
            CallState callState;
            Iterator iterator = hashtable.values().iterator();
            while (iterator.hasNext()) {
                callState = (CallState)iterator.next();
                if (callState.direction != 0 || callState.status == 0) continue;
                if (this.target.isTraceEnabled()) {
                    this.target.trace("CARPLAY - one or more incoming iphone calls and an ocu call in ongoing => disconnect carplay!");
                }
                this.target.triggerObserver(1125408000, null);
                return false;
            }
            iterator = hashtable.values().iterator();
            while (iterator.hasNext()) {
                callState = (CallState)iterator.next();
                if (callState.direction != 1 || callState.status == 0) continue;
                if (this.target.isTraceEnabled()) {
                    this.target.trace("CARPLAY - no incoming and one or more outgoing iphone calls => send hang up ocu calls!");
                }
                this.audiohandling.hangUpOcu();
            }
        }
        return true;
    }
}

