/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.api.system.ASLSystemKeyPanelHandling;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.internal.impl.system.SystemServicesProvider;
import de.vw.mib.asl.internal.system.SystemAccessor;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.abtfeatures.DsiKeyPanelListenerAdapter;
import de.vw.mib.asl.internal.system.keypanel.lock.KeyLockManager;
import de.vw.mib.asl.internal.system.keypanel.lock.KeyLockService;
import de.vw.mib.asl.internal.system.keypanel.lock.KeyLockServiceFactory;
import de.vw.mib.asl.internal.system.util.KeyFilter;
import de.vw.mib.asl.internal.system.util.SystemKeyUtil;
import de.vw.mib.asl.internal.system.util.SystemLogger;
import de.vw.mib.asl.internal.system.util.keymapping.DsiKeyAndKeyBoardId;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.genericevents.EventDispatcherHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.keypanel.DSIKeyPanel;

public class AslTargetSystemKeyPanelHandling
extends DsiKeyPanelListenerAdapter
implements Target,
ASLSystemKeyPanelHandling {
    public static final int UPDATE_GESTURE2_TIME_SCALE_FACTOR = Integer.getInteger("de.vw.mib.asl.internal.system.updateGesture2TimeScaleFactor", 1);
    public static final int KEY_INHIBIT_TIMER;
    public static final int AUDIOSOURCE_KEY_INHIBIT_TIMER;
    public static final int RMA_KEY_FILTER_TIMEOUT;
    private static final int DDS_INTERACTION_TIMER;
    private static final int EVENT_DISABLE;
    private static final int EVENT_ENABLE;
    private final KeyLockService keyLockService = new KeyLockServiceFactory().createKeyLockService(SystemServicesProvider.getSystemServices(), SystemKeyUtil.getInstance());
    private SystemServices services;
    private SystemLogger keyPanelLogger;
    private final int targetId;
    private int screenHeightTouchBorderLimit;
    private int ddsActionCounterForUserInteractionStartStopBehaviour = 0;
    private boolean ddsActionTimerRunning = false;
    private boolean displayOffModeActive = false;
    private boolean wakeUpWasSentLastTime = false;
    private boolean sleepAgainWasSentLastTime = false;
    private int eventFocusOwner = -1;
    private final IntIntOptHashMap longpressedTriggered = new IntIntOptHashMap();
    private final IntIntOptHashMap standardShortPressReleaseEventDisabled = new IntIntOptHashMap();
    private boolean timerStoppedForMflKey = false;
    private boolean bnseAudioIsUnavailable = false;
    private int lastReceivedGestureForBNSEFallback = -1;
    private DSIKeyPanel dsiKeyPanel;
    private KeyLockManager keyLockManager;
    private boolean isTouchInputActive;
    private boolean isRrePressed;
    static /* synthetic */ Class class$org$dsi$ifc$keypanel$DSIKeyPanel;
    static /* synthetic */ Class class$org$dsi$ifc$keypanel$DSIKeyPanelListener;

    public AslTargetSystemKeyPanelHandling(GenericEvents genericEvents, String string) {
        this.targetId = 5601;
        this.initializeTarget(genericEvents, string);
    }

    private void initializeTarget(GenericEvents genericEvents, String string) {
        this.services = SystemServicesProvider.getSystemServices();
        this.keyPanelLogger = new SystemLogger(this.services.getAsl2Logger(), 4096, super.getClass());
        this.keyPanelLogger.trace("initializeTarget called.");
        this.screenHeightTouchBorderLimit = this.services.getConfigManagerDiag().getDisplayDefault(1);
        this.screenHeightTouchBorderLimit -= 10;
        this.registerTarget(genericEvents.getEventDispatcher(), string);
    }

    @Override
    public void updateKey(int n, int n2, int n3, int n4) {
        if (n4 == 1) {
            this.processKeyEvent(n, n2, n3);
        }
    }

    @Override
    public void updateKey2(int n, int n2, int n3, int n4, int n5) {
        n3 = this.overrideKeyState(n3);
        this.processKeyEvent(n, n2, n3);
    }

    @Override
    public void updateEncoder(int n, int n2, int n3, int n4) {
        if (n4 == 1) {
            this.processEncoderEvent(n, n2, n3, 0);
        }
    }

    @Override
    public void updateEncoder2(int n, int n2, int n3, int n4, int n5) {
        if (n5 == 1) {
            this.processEncoderEvent(n, n2, n3, n4);
        }
    }

    @Override
    public GenericEvents getMainObject() {
        return this.services.getGenericEvents();
    }

    @Override
    public int getTargetId() {
        return this.targetId;
    }

    @Override
    public void setTargetId(int n) {
        this.keyPanelLogger.trace("Change target ID is not supported.");
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        block0 : switch (n) {
            case 8: {
                break;
            }
            case 106: {
                this.keyPanelLogger.trace("Received POWER_ON event.");
                this.connectToDsiKeyPanel();
                this.services.getServiceRegister().addObserver(-442744576, this.getTargetId());
                this.keyLockManager = this.services.getKeyLockManager();
                break;
            }
            case 1073743176: {
                this.eventFocusOwner = eventGeneric.getInt(0);
                break;
            }
            case 1073743177: {
                break;
            }
            case 1073743157: {
                SystemKeyUtil.getInstance().setDDSTickSpeedup((short)1, eventGeneric.getInt(1), eventGeneric.getInt(2));
                break;
            }
            case 1073743158: {
                SystemKeyUtil.getInstance().setDDSTickSpeedup((short)2, eventGeneric.getInt(1), eventGeneric.getInt(2));
                break;
            }
            case 1073743185: {
                SystemKeyUtil.getInstance().restoreDDSTickSpeedup((short)1);
                break;
            }
            case 0x40000554: {
                SystemKeyUtil.getInstance().restoreDDSTickSpeedup((short)2);
                break;
            }
            case 100306: {
                if (this.ddsActionCounterForUserInteractionStartStopBehaviour != 0) {
                    this.ddsActionCounterForUserInteractionStartStopBehaviour = 0;
                    this.services.getGenericEvents().getTimerServer().sendTimedEvent(this.getTargetId(), -762904320, 0, false);
                    this.ddsActionTimerRunning = true;
                    break;
                }
                this.ddsActionTimerRunning = false;
                this.services.getSystemEventDispatcher().createAndSubmitHMIEvent(387);
                break;
            }
            case 100303: {
                SystemKeyUtil.getInstance().keyInhibitTimerFinished();
                break;
            }
            case 100304: {
                SystemKeyUtil.getInstance().audioSourceInhibitTimerFinished();
                break;
            }
            case 100305: {
                KeyFilter.getKeyFilter().nextTS();
                break;
            }
            case 4000021: {
                switch (eventGeneric.getInt(0)) {
                    case 0: {
                        this.bnseAudioIsUnavailable = true;
                        this.checkBordNetzSpannungsEinbruchAwarenessLevel();
                        break block0;
                    }
                    case 1: {
                        break block0;
                    }
                    case 2: {
                        this.bnseAudioIsUnavailable = false;
                        this.checkBordNetzSpannungsEinbruchAwarenessLevel();
                        break block0;
                    }
                }
                break;
            }
            case 4300005: {
                this.checkBordNetzSpannungsEinbruchAwarenessLevel();
                break;
            }
            default: {
                int n2 = SystemKeyUtil.getInstance().returnCorrespondingDsiKeyWithKeyBoardIdValue(n);
                if (this.isSpecialHandling(n2, 4, 42)) {
                    if (this.timerStoppedForMflKey) {
                        this.timerStoppedForMflKey = false;
                        break;
                    }
                    this.keyPanelLogger.trace("continued increase by MFL, 1 tick");
                    this.standardShortPressReleaseEventDisabled.put(n2, 1);
                    int n3 = SystemKeyUtil.getInstance().returnCorrespondingEventValue(4, 42);
                    EventGeneric eventGeneric2 = this.services.getEventFactory().newEvent();
                    eventGeneric2.setInt(0, 1);
                    this.services.getServiceRegister().triggerObserver(597508352, eventGeneric2);
                    this.services.getSystemEventDispatcher().createAndSubmitHMIEvent(232);
                    this.getMainObject().getTimerServer().sendTimedEvent(this.getTargetId(), n3, 0, false);
                    break;
                }
                if (this.isSpecialHandling(n2, 4, 43)) {
                    if (this.timerStoppedForMflKey) {
                        this.timerStoppedForMflKey = false;
                        break;
                    }
                    this.keyPanelLogger.trace("continued decrease by MFL, 1 tick");
                    this.standardShortPressReleaseEventDisabled.put(n2, 1);
                    int n4 = SystemKeyUtil.getInstance().returnCorrespondingEventValue(4, 43);
                    EventGeneric eventGeneric3 = this.services.getEventFactory().newEvent();
                    eventGeneric3.setInt(0, -1);
                    this.services.getServiceRegister().triggerObserver(597508352, eventGeneric3);
                    this.services.getSystemEventDispatcher().createAndSubmitHMIEvent(232);
                    this.getMainObject().getTimerServer().sendTimedEvent(this.getTargetId(), n4, 0, false);
                    break;
                }
                if (n2 != -1) {
                    int n5;
                    this.standardShortPressReleaseEventDisabled.put(n2, 1);
                    DsiKeyAndKeyBoardId dsiKeyAndKeyBoardId = SystemKeyUtil.getInstance().decodeDsiKeyAndKeyBoardId(n2);
                    if (this.longpressedTriggered.get(n2) != 1) {
                        this.startConfigurableKeyTimerForUltraLongKeyPress(dsiKeyAndKeyBoardId.getKeyBoardId(), dsiKeyAndKeyBoardId.getDsiKey());
                        n5 = 3;
                    } else {
                        n5 = 4;
                    }
                    this.submitHardkeyFilteredWithTouchInteractionCheck(dsiKeyAndKeyBoardId.getKeyBoardId(), dsiKeyAndKeyBoardId.getDsiKey(), n5);
                    if (n5 == 100 || n5 == 0) {
                        this.sendSleepAgainEvent();
                        if (this.isSpecialHandling(n2, 13, 16)) {
                            this.services.getSystemEventDispatcher().createAndSubmitHMIEvent(433);
                        }
                    }
                    if (this.longpressedTriggered.get(n2) == 1) {
                        this.longpressedTriggered.put(n2, 0);
                        break;
                    }
                    this.longpressedTriggered.put(n2, 1);
                    break;
                }
                this.keyPanelLogger.trace(new Object[]{"A key was not recognized, maybe LONG-/ULTRALONGPRESSED...", new Integer(n)});
                break;
            }
        }
    }

    private void connectToDsiKeyPanel() {
        DSIProxy dSIProxy = this.services.getDsiProxy();
        ConfigurationManagerDiag configurationManagerDiag = this.services.getConfigManagerDiag();
        this.dsiKeyPanel = (DSIKeyPanel)dSIProxy.getService(this, class$org$dsi$ifc$keypanel$DSIKeyPanel == null ? (class$org$dsi$ifc$keypanel$DSIKeyPanel = AslTargetSystemKeyPanelHandling.class$("org.dsi.ifc.keypanel.DSIKeyPanel")) : class$org$dsi$ifc$keypanel$DSIKeyPanel, configurationManagerDiag.getSystemKeyPanelInstance());
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$keypanel$DSIKeyPanelListener == null ? (class$org$dsi$ifc$keypanel$DSIKeyPanelListener = AslTargetSystemKeyPanelHandling.class$("org.dsi.ifc.keypanel.DSIKeyPanelListener")) : class$org$dsi$ifc$keypanel$DSIKeyPanelListener, configurationManagerDiag.getSystemKeyPanelInstance(), this);
        this.dsiKeyPanel.setNotification(new int[]{25, 23, 20}, (DSIListener)this);
    }

    public void updateGesture2(int n, int n2, int n3, boolean bl, int n4, int n5, int n6, int n7, int n8) {
        if (n == 13) {
            if (n2 == 4) {
                this.isTouchInputActive = true;
                this.keyPanelLogger.trace("Registered GESTURE_PRESS.");
            } else if (n2 == 8) {
                this.isTouchInputActive = true;
                this.keyPanelLogger.trace("Registered GESTURE_PRESS2.");
            } else if (n2 == 1) {
                this.isTouchInputActive = false;
                this.keyPanelLogger.trace("Registered GESTURE_TAP.");
            } else if (n2 == 3) {
                this.isTouchInputActive = false;
                this.keyPanelLogger.trace("Registered GESTURE_RELEASE.");
            }
        }
    }

    void setDisplayOffModeActive(boolean bl) {
        this.displayOffModeActive = bl;
    }

    private boolean isSpecialHandling(int n, int n2, int n3) {
        DsiKeyAndKeyBoardId dsiKeyAndKeyBoardId = SystemKeyUtil.getInstance().decodeDsiKeyAndKeyBoardId(n);
        return dsiKeyAndKeyBoardId.compareDsiKeyAndKeyBoardId(n2, n3);
    }

    private void startConfigurableKeyTimerForLongKeyPress(int n, int n2) {
        int n3 = SystemKeyUtil.getInstance().returnCorrespondingEventValue(n, n2);
        if (n3 != -1) {
            this.getMainObject().getTimerServer().sendTimedEvent(this.getTargetId(), n3, SystemKeyUtil.getInstance().getLongpressTime(n, n2), false);
        }
    }

    private void startConfigurableKeyTimerForUltraLongKeyPress(int n, int n2) {
        int n3 = SystemKeyUtil.getInstance().returnCorrespondingEventValue(n, n2);
        if (n3 != -1) {
            this.getMainObject().getTimerServer().sendTimedEvent(this.getTargetId(), n3, SystemKeyUtil.getInstance().getUltraLongpressTime(n, n2), false);
        }
    }

    private void stopKeyTimerForLongOrUltraLongPress(int n, int n2) {
        int n3 = SystemKeyUtil.getInstance().returnCorrespondingEventValue(n, n2);
        if (n3 != -1) {
            this.getMainObject().getTimerServer().stopTimedEvent(this.getTargetId(), n3);
        }
    }

    private void submitHardkeyFilteredWithTouchInteractionCheck(int n, int n2, int n3) {
        if (!this.isTouchInputActive) {
            this.keyLockService.processKeyEvent(n, n2, n3);
        }
    }

    private int overrideKeyState(int n) {
        if (n == 2) {
            n = 1;
        }
        return n;
    }

    private void processTouchEvent(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        int n8;
        int n9 = n8 = n4 > this.screenHeightTouchBorderLimit ? this.screenHeightTouchBorderLimit : n4;
        if (n2 == 1 || n2 == 3) {
            this.sendSleepAgainEvent();
        } else {
            this.sendWakeupEvent();
        }
        if (this.displayOffModeActive) {
            this.keyPanelLogger.trace(new Object[]{"nightModeActive, gestureCode ", new Integer(n2)});
        } else {
            this.lastReceivedGestureForBNSEFallback = n2;
            this.keyPanelLogger.trace(new Object[]{"Gesture:", new Integer(n2), " x:", new Integer(n3), " y:", new Integer(n8), " z:", new Integer(n7), " par1:", new Integer(n5), " par2:", new Integer(n6)});
            SystemEventDispatcher systemEventDispatcher = this.services.getSystemEventDispatcher();
            switch (n2) {
                case 0: {
                    this.keyPanelLogger.error("Got gesture id GESTURE_UNKNOWN from DSI.");
                    break;
                }
                case 1: {
                    int n10 = n5;
                    systemEventDispatcher.createAndSubmitTouchEventClick(n3, n8, n10, n7);
                    systemEventDispatcher.createAndSubmitHMIEvent(387);
                    break;
                }
                case 3: {
                    systemEventDispatcher.createAndSubmitTouchEventRelease(n3, n8, n7);
                    systemEventDispatcher.createAndSubmitHMIEvent(387);
                    break;
                }
                case 4: {
                    systemEventDispatcher.createAndSubmitHMIEvent(386);
                    systemEventDispatcher.createAndSubmitTouchEventPress(n3, n8, n7);
                    systemEventDispatcher.createAndSubmitHMIEvent(419);
                    break;
                }
                case 5: {
                    byte by = (byte)n5;
                    byte by2 = (byte)n6;
                    systemEventDispatcher.createAndSubmitTouchEventDrag(n3, n8, by, by2, n7);
                    break;
                }
                case 6: {
                    byte by = (byte)n5;
                    byte by3 = (byte)n6;
                    systemEventDispatcher.createAndSubmitTouchEventFlick(n3, n8, by, by3, n7);
                    break;
                }
                case 7: {
                    if ((n5 & 0x800000) != 0) {
                        systemEventDispatcher.createAndSubmitTouchEventRotation(-1 * (256 - n5), n7);
                        break;
                    }
                    systemEventDispatcher.createAndSubmitTouchEventRotation(n5, n7);
                    break;
                }
                case 8: {
                    systemEventDispatcher.createAndSubmitHMIEvent(386);
                    systemEventDispatcher.createAndSubmitTouchEventPress2(n3, n8, n5, n7);
                    systemEventDispatcher.createAndSubmitHMIEvent(419);
                    break;
                }
                case 9: {
                    systemEventDispatcher.createAndSubmitTouchEventDrag2(n3, n8, n5, 0, 0, n7);
                    break;
                }
                case 10: {
                    systemEventDispatcher.createAndSubmitTouchEventFlick2(n3, n8, n5, 0, 0, n7);
                    break;
                }
                case 11: {
                    byte by = (byte)n6;
                    systemEventDispatcher.createAndSubmitTouchEventZoom(n3, n8, n5, by, n7);
                    break;
                }
                case 12: {
                    systemEventDispatcher.createAndSubmitTouchEventRightClick(n3, n8, n7);
                    break;
                }
                case 99: {
                    systemEventDispatcher.createAndSubmitTouchEventMousePosition(n3, n8, n7);
                    break;
                }
                default: {
                    this.keyPanelLogger.error(new StringBuffer().append("Unknown Gesturecode: ").append(n2).toString());
                }
            }
        }
    }

    private void processKeyEvent(int n, int n2, int n3) {
        int n4 = SystemKeyUtil.getInstance().returnCorrespondingEventValue(n, n2);
        this.keyPanelLogger.normal(new Object[]{"HK Received: KBD[", new Integer(n), "] KEY[", new Integer(n2), "] KST[", new Integer(n3), "]"});
        if (n2 == 83) {
            return;
        }
        if (n3 == 1) {
            this.startConfigurableKeyTimerForLongKeyPress(n, n2);
            if (n2 == 42 || n2 == 43) {
                this.timerStoppedForMflKey = false;
            } else if (n2 == 32) {
                this.services.getServiceRegister().triggerObserver(161300736);
            } else if (n2 == 16 && !this.isTouchInputActive) {
                this.isRrePressed = true;
                this.services.getSystemEventDispatcher().createAndSubmitHMIEvent(419);
            }
            if (n != 4 && n != 8 && n2 != 17) {
                this.sendWakeupEvent();
            }
        } else if (n3 == 0) {
            this.stopKeyTimerForLongOrUltraLongPress(n, n2);
            if (n2 == 42 || n2 == 43) {
                this.timerStoppedForMflKey = true;
            }
            if (this.standardShortPressReleaseEventDisabled.get(n4) == 1) {
                this.standardShortPressReleaseEventDisabled.put(n4, 0);
                this.sendSleepAgainEvent();
                this.submitHardkeyFilteredWithTouchInteractionCheck(n, n2, 100);
                if (n2 == 16 && this.isRrePressed) {
                    this.services.getSystemEventDispatcher().createAndSubmitHMIEvent(433);
                    this.isRrePressed = false;
                }
            } else {
                this.sendSleepAgainEvent();
                this.submitHardkeyFilteredWithTouchInteractionCheck(n, n2, 0);
                if (n2 == 16 && this.isRrePressed) {
                    this.services.getSystemEventDispatcher().createAndSubmitHMIEvent(433);
                    this.isRrePressed = false;
                }
                if (n2 == 42) {
                    this.keyPanelLogger.trace("increase by MFL, 1 tick");
                    EventGeneric eventGeneric = this.services.getEventFactory().newEvent();
                    eventGeneric.setInt(0, 1);
                    this.services.getServiceRegister().triggerObserver(597508352, eventGeneric);
                    this.services.getSystemEventDispatcher().createAndSubmitHMIEvent(232);
                } else if (n2 == 43) {
                    this.keyPanelLogger.trace("decrease by MFL, 1 tick");
                    EventGeneric eventGeneric = this.services.getEventFactory().newEvent();
                    eventGeneric.setInt(0, -1);
                    this.services.getServiceRegister().triggerObserver(597508352, eventGeneric);
                    this.services.getSystemEventDispatcher().createAndSubmitHMIEvent(232);
                }
            }
            this.longpressedTriggered.put(n4, 0);
        } else if (n3 == 2 && (n2 == 42 || n2 == 43)) {
            this.keyPanelLogger.normal("double pressed mfl_vol, handle as if it was single pressed");
            this.startConfigurableKeyTimerForLongKeyPress(n, n2);
            this.timerStoppedForMflKey = false;
            if (n != 4 && n != 8 && n2 != 17) {
                this.sendWakeupEvent();
            }
        } else if (n2 != 50 && (n3 == 3 || n3 == 4 || n3 == 5)) {
            this.standardShortPressReleaseEventDisabled.put(n4, 1);
        }
        if (n3 != 0 && this.standardShortPressReleaseEventDisabled.get(n4) != 1 && n2 != 42 && n2 != 43) {
            this.submitHardkeyFilteredWithTouchInteractionCheck(n, n2, n3);
            if (n3 == 100 || n3 == 0) {
                this.sendSleepAgainEvent();
                if (n2 == 16 && this.isRrePressed) {
                    this.services.getSystemEventDispatcher().createAndSubmitHMIEvent(433);
                    this.isRrePressed = false;
                }
            }
        }
    }

    private void processEncoderEvent(int n, int n2, int n3, int n4) {
        this.keyPanelLogger.trace(new Object[]{"ENCODER Keyboard: ", new Integer(n), " keyId:", new Integer(n2), " incrementCount:", new Integer(n3)});
        if (n2 == 16) {
            if (!this.isTouchInputActive) {
                this.services.getSystemEventDispatcher().createAndSubmitHMIEvent(386);
                this.startTimerForDDSAction();
                ++this.ddsActionCounterForUserInteractionStartStopBehaviour;
                int n5 = SystemKeyUtil.getInstance().getDDSTicks((short)1, n3);
                if (!this.keyLockManager.isLocked(n, n2)) {
                    this.sendDdsRotaryEvent(n2, n4, n5);
                }
                this.services.getSystemEventDispatcher().createAndSubmitHMIEvent(419);
            }
        } else if (n2 == 17 || n2 == 44) {
            this.services.getSystemEventDispatcher().createAndSubmitHMIEvent(386);
            this.startTimerForDDSAction();
            int n6 = SystemKeyUtil.getInstance().getDDSTicks((short)2, n3);
            if (!this.keyLockManager.isLocked(n, n2)) {
                this.sendVolumeRotaryEvent(n2, n4, n6);
            }
        } else {
            this.keyPanelLogger.warn("A wrong DDS Encoder was recognized");
        }
        if (n != 4 && n != 8) {
            this.sendWakeupEvent();
            this.sendSleepAgainEvent();
        }
    }

    private void sendVolumeRotaryEvent(int n, int n2, int n3) {
        EventGeneric eventGeneric = this.services.getEventFactory().newEvent();
        eventGeneric.setInt(0, n3);
        this.services.getServiceRegister().triggerObserver(597508352, eventGeneric);
        if (n == 17) {
            if (n3 > 0) {
                this.services.getSystemEventDispatcher().createAndSubmitRotationEvent(296, n3, n2);
                SystemKeyUtil.getInstance().createRotationEvent(n, 103);
            } else {
                this.services.getSystemEventDispatcher().createAndSubmitRotationEvent(290, -n3, n2);
                SystemKeyUtil.getInstance().createRotationEvent(n, 102);
            }
        } else {
            this.services.getSystemEventDispatcher().createAndSubmitHMIEvent(232);
        }
    }

    private void sendDdsRotaryEvent(int n, int n2, int n3) {
        EventGeneric eventGeneric = this.services.getEventFactory().newEvent();
        eventGeneric.setInt(0, n3);
        eventGeneric.setInt(1, this.eventFocusOwner);
        this.services.getServiceRegister().triggerObserver(614285568, eventGeneric);
        if (n3 > 0) {
            this.services.getSystemEventDispatcher().createAndSubmitRotationEvent(288, n3, n2);
            SystemKeyUtil.getInstance().createRotationEvent(n, 103);
        } else {
            this.services.getSystemEventDispatcher().createAndSubmitRotationEvent(283, -n3, n2);
            SystemKeyUtil.getInstance().createRotationEvent(n, 102);
        }
    }

    private void startTimerForDDSAction() {
        if (!this.ddsActionTimerRunning) {
            this.services.getGenericEvents().getTimerServer().sendTimedEvent(this.getTargetId(), -762904320, 0, false);
            this.ddsActionTimerRunning = true;
        }
    }

    private void sendWakeupEvent() {
        if (!this.wakeUpWasSentLastTime) {
            this.wakeUpWasSentLastTime = true;
            this.sleepAgainWasSentLastTime = false;
            try {
                EventGeneric eventGeneric = this.services.getEventFactory().newEvent(this.getTargetId(), 5603, 211632384);
                this.services.getEventDispatcher().send(eventGeneric);
            }
            catch (GenericEventException genericEventException) {
                this.keyPanelLogger.error("Could not send wakeUpEvent to Display");
            }
        }
    }

    private void sendSleepAgainEvent() {
        if (!this.sleepAgainWasSentLastTime) {
            this.wakeUpWasSentLastTime = false;
            this.sleepAgainWasSentLastTime = true;
            try {
                EventGeneric eventGeneric = this.services.getEventFactory().newEvent(this.getTargetId(), 5603, 228409600);
                this.services.getEventDispatcher().send(eventGeneric);
            }
            catch (GenericEventException genericEventException) {
                this.keyPanelLogger.error("Could not send sleepAgainEvent to Display", genericEventException);
            }
        }
    }

    private void checkBordNetzSpannungsEinbruchAwarenessLevel() {
        if (this.bnseAudioIsUnavailable) {
            SystemKeyUtil.getInstance().releaseLastSentKeyInBnseCase();
            if (this.lastReceivedGestureForBNSEFallback != 3 && this.lastReceivedGestureForBNSEFallback != 1 && this.lastReceivedGestureForBNSEFallback != 12) {
                this.processTouchEvent(13, 3, -1, -1, 0, 0, 0);
            }
        }
    }

    private void registerTarget(EventDispatcherHSM eventDispatcherHSM, String string) {
        this.keyPanelLogger.trace("registerTarget called!");
        try {
            eventDispatcherHSM.registerTarget(this.getTargetId(), this, string);
        }
        catch (Exception exception) {
            this.keyPanelLogger.error("Could not register target.", exception);
        }
        SystemAccessor.setKeyPanelTarget(this);
        this.keyPanelLogger.info(new StringBuffer().append("Created ").append(super.getClass().getName()).append(" instance with target ID ").append(this.targetId).toString());
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

