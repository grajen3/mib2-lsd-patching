/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm;

import de.vw.mib.asl.internal.exboxm.ExBoxMDisplay;
import de.vw.mib.asl.internal.exboxm.IntStringMap;
import de.vw.mib.asl.internal.exboxm.TargetASLExBoxM;
import de.vw.mib.asl.internal.exboxm.services.ExboxServicesProvider;
import de.vw.mib.asl.internal.exboxm.util.ExboxLogger;

public class ExBoxMDisplay_SM
extends ExBoxMDisplay {
    public static final int CHANGE_DISPLAY_CONTEXT;
    public static final int IDLE;
    public static final int SWITCH_DISPLAY_CONTROL;
    public static final int DSI_EVENT_DISPLAY_CONTEXT_CHANGED;
    public static final int ASL_EVENT_FADE_OUT_TIMER_ELAPSED;
    public static final int ASL_EVENT_FADE_IN_TIMER_ELAPSED;
    public static final int HMI_EVENT_SWITCH_DISPLAY_CONTROL;
    public static final int HMI_EVENT_KEEP_DISPLAY_CONTROL;
    public static final int DSI_EVENT_DISPLAY_CONTEXT_CHANGED_ERROR;
    public static final int HMI_EVENT_CHANGE_DISPLAY_CONTEXT;
    public static final int ASL_EVENT_EXBOX_ERROR;
    public static final int EXBOXMDISPLAY_SM_NO_MSG;
    private static final IntStringMap EVENTINDEX_TO_NAME_MAP;
    private static final IntStringMap STATEINDEX_TO_NAME_MAP;
    private boolean m_initialized = false;
    private int stateVar;
    private final ExboxLogger exboxLogger = new ExboxLogger(ExboxServicesProvider.getExBoxServices().getLogger(), super.getClass());

    public ExBoxMDisplay_SM(TargetASLExBoxM targetASLExBoxM) {
        super(targetASLExBoxM);
    }

    public boolean isInCHANGE_DISPLAY_CONTEXT() {
        return this.stateVar == 0;
    }

    public boolean isInIDLE() {
        return this.stateVar == 1;
    }

    public boolean isInSWITCH_DISPLAY_CONTROL() {
        return this.stateVar == 2;
    }

    public void initialize() {
        if (!this.m_initialized) {
            this.m_initialized = true;
            this.stateVar = 1;
        }
    }

    public int processEvent(int n) {
        int n2 = 0;
        if (!this.m_initialized) {
            return 0;
        }
        this.exboxLogger.trace(new Object[]{"processEvent called! ", "state=", new Integer(this.stateVar), " (", STATEINDEX_TO_NAME_MAP.get(this.stateVar), ") ", "event=", new Integer(n), " (", EVENTINDEX_TO_NAME_MAP.get(n), ")"});
        switch (this.stateVar) {
            case 0: {
                if (n == 7) {
                    this.stopFadeOutTimer();
                    this.stateVar = 1;
                    break;
                }
                if (n == 1) {
                    this.fadeOutTimerElapsed();
                    this.signalSwitchDisplayControlToDSI();
                    this.stateVar = 2;
                    break;
                }
                if (n == 4) {
                    this.stopFadeOutTimer();
                    this.stateVar = 1;
                    break;
                }
                if (n != 3) break;
                this.stopFadeOutTimer();
                this.signalSwitchDisplayControlToDSI();
                this.stateVar = 2;
                break;
            }
            case 1: {
                if (n == 7) {
                    this.stateVar = 1;
                    break;
                }
                if (n == 2) {
                    this.fadeInTimerElapsed();
                    this.stateVar = 1;
                    break;
                }
                if (n != 6) break;
                this.stopFadeInTimer();
                this.signalContextChangeToHMI();
                this.startFadeOutTimer();
                this.stateVar = 0;
                break;
            }
            case 2: {
                if (n == 7) {
                    this.startFadeInTimer();
                    this.stopFadeInTimer();
                    this.stateVar = 1;
                    break;
                }
                if (n == 0) {
                    this.startFadeInTimer();
                    this.switchDisplayResponse();
                    this.stateVar = 1;
                    break;
                }
                if (n != 5) break;
                this.startFadeInTimer();
                this.signalContextChangeToHMI();
                this.switchDisplayResponse();
                this.stateVar = 1;
                break;
            }
        }
        return n2;
    }

    static {
        EVENTINDEX_TO_NAME_MAP = new IntStringMap("Unknown", new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8}, new String[]{"DSI_EVENT_DISPLAY_CONTEXT_CHANGED", "ASL_EVENT_FADE_OUT_TIMER_ELAPSED", "ASL_EVENT_FADE_IN_TIMER_ELAPSED", "HMI_EVENT_SWITCH_DISPLAY_CONTROL", "HMI_EVENT_KEEP_DISPLAY_CONTROL", "DSI_EVENT_DISPLAY_CONTEXT_CHANGED_ERROR", "HMI_EVENT_CHANGE_DISPLAY_CONTEXT", "ASL_EVENT_EXBOX_ERROR", "EXBOXMDISPLAY_SM_NO_MSG"});
        STATEINDEX_TO_NAME_MAP = new IntStringMap("Unknown", new int[]{0, 1, 2}, new String[]{"CHANGE_DISPLAY_CONTEXT", "IDLE", "SWITCH_DISPLAY_CONTROL"});
    }
}

