/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.util;

import de.vw.mib.asl.api.system.KeyListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.impl.system.SystemServicesProvider;
import de.vw.mib.asl.internal.system.util.KeyFilter;
import de.vw.mib.asl.internal.system.util.keymapping.DsiKeyAndKeyBoardId;
import de.vw.mib.asl.internal.system.util.keymapping.HardKeyReader;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.collections.ints.IntObjectMultimap;
import de.vw.mib.log4mib.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SystemKeyUtil {
    public static final int KEY_VALUE_NOT_CORRECT;
    public static final int KST_LONGRELEASED;
    public static final int KST_MULTIPRESSED;
    public static final int KST_ROTATION_LEFT;
    public static final int KST_ROTATION_RIGHT;
    public static final short EVENT_DDS;
    public static final short VOLUME_DDS;
    public static final int DEFAULT_LONGPRESS_TIME;
    public static final int KEYPANEL_NUM_OF_KEYS;
    private static final int KEY_INHIBIT_TIME;
    private static SystemKeyUtil INSTANCE;
    private int[] keyArray = new int[2];
    private final IntIntOptHashMap longpressTimes = new IntIntOptHashMap(117);
    private final IntIntOptHashMap ultraLongPressTimes = new IntIntOptHashMap(117);
    private int lastKeyBoardId = -1;
    private int lastSentKey = -1;
    private int lastSentKeyState = -1;
    private int eventDDSThreshold = -1;
    private int eventDDSMultiplier = -1;
    private int volumeDDSThreshold = -1;
    private int volumeDDSMultiplier = -1;
    private final IntObjectMultimap mapKeyId2Listeners = new IntObjectMultimap();
    private final IntObjectMultimap mapKeyboardId2Listeners = new IntObjectMultimap();
    private final IntObjectMultimap mapKeyIdWithKeyboardId2Listeners = new IntObjectMultimap();
    private final Logger logger = SystemServicesProvider.getSystemServices().getAsl1Logger();
    private final HardKeyReader hardKeyReader = this.createReadHardKeyReader();

    public static SystemKeyUtil getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SystemKeyUtil();
        }
        return INSTANCE;
    }

    public void restoreDDSTickSpeedup(short s) {
        if (s == 1) {
            this.eventDDSMultiplier = -1;
            this.eventDDSThreshold = -1;
        } else if (s == 2) {
            this.volumeDDSMultiplier = -1;
            this.volumeDDSThreshold = -1;
        }
    }

    public void setDDSTickSpeedup(short s, int n, int n2) {
        if (s == 1) {
            this.eventDDSMultiplier = n2;
            this.eventDDSThreshold = n;
        } else if (s == 2) {
            this.volumeDDSMultiplier = n2;
            this.volumeDDSThreshold = n;
        }
    }

    public int getDDSTicks(short s, int n) {
        int n2 = n < 0 ? -n : n;
        switch (s) {
            case 1: {
                if (this.eventDDSThreshold <= -1 || n2 < this.eventDDSThreshold) break;
                return n * this.eventDDSMultiplier;
            }
            case 2: {
                if (this.volumeDDSThreshold <= -1 || n2 < this.volumeDDSThreshold) break;
                return n * this.volumeDDSMultiplier;
            }
            default: {
                return n;
            }
        }
        return n;
    }

    public int getLongpressTime(int n, int n2) {
        int n3 = this.hardKeyReader.encodeKeyBoardIdWithDsiKey(n, n2);
        int n4 = this.longpressTimes.get(n3);
        if (n2 >= 0 && n2 < 117 && 0 != n4) {
            return n4;
        }
        this.logger.warn(1, "LongPressTime ist not defined");
        return 5000;
    }

    public int getUltraLongpressTime(int n, int n2) {
        int n3 = this.hardKeyReader.encodeKeyBoardIdWithDsiKey(n, n2);
        if (n2 >= 0 && n2 < 117 && this.ultraLongPressTimes.containsKey(n3)) {
            return this.ultraLongPressTimes.get(n3);
        }
        this.logger.warn(1, "UltraLongpressTime ist not defined");
        return 5000;
    }

    public int returnCorrespondingEventValue(int n, int n2) {
        short s = (short)((n << 8) + n2);
        if (n2 < 0 || n2 > 117) {
            return -1;
        }
        return s;
    }

    public DsiKeyAndKeyBoardId decodeDsiKeyAndKeyBoardId(int n) {
        return this.hardKeyReader.getKeyBoardIdAndDsiKey(n);
    }

    public int returnCorrespondingDsiKeyWithKeyBoardIdValue(int n) {
        int n2 = this.hardKeyReader.getKeyBoardIdAndDsiKey(n).getDsiKey();
        if (n2 < 0 || n2 > 117) {
            return -1;
        }
        return n;
    }

    public void releaseLastSentKeyInBnseCase() {
        if (this.lastSentKeyState == 1) {
            this.createAndSubmitHardkeyEvent(this.lastKeyBoardId, this.lastSentKey, 0);
        } else if (this.lastSentKeyState == 3 || this.lastSentKeyState == 4 || this.lastSentKeyState == 5) {
            this.createAndSubmitHardkeyEvent(this.lastKeyBoardId, this.lastSentKey, 100);
        }
    }

    public void createAndSubmitHardkeyEvent(int n, int n2, int n3) {
        this.sendHmiEvent(n, n2, n3);
        this.notifyKeyListeners(n, n2, n3);
    }

    public void createRotationEvent(int n, int n2) {
        this.notifyKeyListenerId(n, n2);
    }

    public void keyInhibitTimerFinished() {
        ServiceManager.eventMain.getTimerServer().stopTimedEvent(5601, -813235968);
        if (this.keyArray[0] != -1 && this.keyArray[1] != -1) {
            ServiceManager.eventDispatcher.createAndSubmitHardkeyEvent(this.keyArray[0]);
            ServiceManager.eventDispatcher.createAndSubmitHardkeyEvent(this.keyArray[1]);
            ServiceManager.eventMain.getTimerServer().restartOrStartTimedEvent(5601, -813235968, 0, false);
        } else if (this.keyArray[0] != -1 && this.keyArray[1] == -1) {
            ServiceManager.eventDispatcher.createAndSubmitHardkeyEvent(this.keyArray[0]);
            ServiceManager.eventMain.getTimerServer().restartOrStartTimedEvent(5601, -813235968, 0, false);
        }
        this.keyArray[0] = -1;
        this.keyArray[1] = -1;
    }

    public void audioSourceInhibitTimerFinished() {
        ServiceManager.eventMain.getTimerServer().stopTimedEvent(5601, -796458752);
    }

    public void addKeyListener(int n, int n2, KeyListener keyListener) {
        if (keyListener == null) {
            throw new IllegalArgumentException("Cannot add key listener since it is null");
        }
        if (n != 0 && n2 == 35) {
            this.mapKeyboardId2Listeners.put(n, keyListener);
        } else if (n == 0) {
            this.mapKeyId2Listeners.put(n2, keyListener);
        } else {
            int n3 = this.hardKeyReader.encodeKeyBoardIdWithDsiKey(n, n2);
            this.mapKeyIdWithKeyboardId2Listeners.put(n3, keyListener);
        }
    }

    public void removeKeyListener(int n, int n2, KeyListener keyListener) {
        if (keyListener == null) {
            throw new IllegalArgumentException("Cannot remove key listener since it is null");
        }
        if (n != 0 && n2 == 35) {
            this.mapKeyboardId2Listeners.removeValue(n, keyListener);
        } else if (n == 0) {
            this.mapKeyId2Listeners.removeValue(n2, keyListener);
        } else {
            int n3 = this.hardKeyReader.encodeKeyBoardIdWithDsiKey(n, n2);
            this.mapKeyIdWithKeyboardId2Listeners.removeValue(n3, keyListener);
        }
    }

    static SystemKeyUtil createUnitTestInstance() {
        return new SystemKeyUtil();
    }

    public static void setSystemKeyUtil(SystemKeyUtil systemKeyUtil) {
        INSTANCE = systemKeyUtil;
    }

    private HardKeyReader createReadHardKeyReader() {
        int[] nArray = ServiceManager.configManagerDiag.getKeyTimesAndMappingsData();
        HardKeyReader hardKeyReader = new HardKeyReader(nArray, this.logger);
        hardKeyReader.installAllTimingValues(this.longpressTimes, this.ultraLongPressTimes);
        return hardKeyReader;
    }

    private void notifyKeyListeners(int n, int n2, int n3) {
        this.notifyKeyListenerId(n2, n3);
        this.notifyKeyboardListenerId(n, n2, n3);
        this.notifyKeyWithKeyboardListenerId(n, n2, n3);
    }

    private void notifyKeyListenerId(int n, int n2) {
        int n3 = this.transformDsiKeyIdToKeyListenerId(n);
        ArrayList arrayList = new ArrayList(this.mapKeyId2Listeners.getAll(n3));
        this.notifyListeners(arrayList, n3, n2);
    }

    private void notifyKeyboardListenerId(int n, int n2, int n3) {
        int n4 = this.transformDsiKeyIdToKeyListenerId(n2);
        int n5 = this.transformDsiKeyboardIdToKeyboardListenerId(n);
        ArrayList arrayList = new ArrayList(this.mapKeyboardId2Listeners.getAll(n5));
        this.notifyListeners(arrayList, n4, n3);
    }

    private void notifyKeyWithKeyboardListenerId(int n, int n2, int n3) {
        int n4 = this.transformDsiKeyIdToKeyListenerId(n2);
        int n5 = this.transformDsiKeyboardIdToKeyboardListenerId(n);
        int n6 = this.hardKeyReader.encodeKeyBoardIdWithDsiKey(n5, n4);
        ArrayList arrayList = new ArrayList(this.mapKeyIdWithKeyboardId2Listeners.getAll(n6));
        this.notifyListeners(arrayList, n4, n3);
    }

    private void notifyListeners(List list, int n, int n2) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            KeyListener keyListener = (KeyListener)iterator.next();
            try {
                this.notifyKeyListener(n2, n, keyListener);
            }
            catch (Exception exception) {
                this.logger.error(2048, exception.getMessage(), exception);
            }
        }
    }

    private void notifyKeyListener(int n, int n2, KeyListener keyListener) {
        switch (n) {
            case 1: {
                keyListener.onPressed(n2);
                break;
            }
            case 0: {
                keyListener.onReleased(n2);
                break;
            }
            case 3: {
                keyListener.onLongPressed(n2);
                break;
            }
            case 100: {
                keyListener.onLongReleased(n2);
                break;
            }
            case 4: {
                keyListener.onUltraLongPressed(n2);
                break;
            }
            case 101: {
                keyListener.onMultiPressed(n2);
                break;
            }
            case 102: {
                keyListener.onRotationLeft(n2);
                break;
            }
            case 103: {
                keyListener.onRotationRight(n2);
                break;
            }
            default: {
                this.logger.error(2048).append("Invalid key state: ").append(n).log();
            }
        }
    }

    private int transformDsiKeyboardIdToKeyboardListenerId(int n) {
        switch (n) {
            case 4: {
                return 2;
            }
            case 13: {
                return 1;
            }
            case 1: {
                return 3;
            }
        }
        return 0;
    }

    private int transformDsiKeyIdToKeyListenerId(int n) {
        switch (n) {
            case 1: {
                return 1;
            }
            case 3: {
                return 2;
            }
            case 4: {
                return 3;
            }
            case 5: {
                return 4;
            }
            case 6: {
                return 5;
            }
            case 7: {
                return 6;
            }
            case 10: {
                return 7;
            }
            case 47: {
                return 8;
            }
            case 46: {
                return 9;
            }
            case 14: {
                return 10;
            }
            case 15: {
                return 11;
            }
            case 16: {
                return 12;
            }
            case 17: {
                return 13;
            }
            case 32: {
                return 14;
            }
            case 50: {
                return 15;
            }
            case 78: {
                return 16;
            }
            case 79: {
                return 17;
            }
            case 86: {
                return 18;
            }
            case 87: {
                return 19;
            }
            case 88: {
                return 20;
            }
            case 57: {
                return 21;
            }
            case 44: {
                return 22;
            }
            case 89: {
                return 23;
            }
            case 93: {
                return 24;
            }
            case 107: {
                return 26;
            }
            case 104: {
                return 25;
            }
            case 45: {
                return 27;
            }
            case 42: {
                return 28;
            }
            case 43: {
                return 29;
            }
            case 48: {
                return 30;
            }
            case 49: {
                return 31;
            }
            case 53: {
                return 32;
            }
            case 116: {
                return 33;
            }
            case 114: {
                return 34;
            }
        }
        return 0;
    }

    private void sendHmiEvent(int n, int n2, int n3) {
        this.lastKeyBoardId = n;
        this.lastSentKey = n2;
        this.lastSentKeyState = n3;
        int n4 = this.hardKeyReader.findDsiKeyToASLSystemHKEvent(n, n2, n3).getHkEventId();
        if (n4 != -1) {
            if (n3 == 1) {
                if (KeyFilter.getKeyFilter() == null) {
                    ServiceManager.eventDispatcher.createAndSubmitHardkeyEvent(n4);
                } else if (!KeyFilter.getKeyFilter().logKeyEvent()) {
                    ServiceManager.eventDispatcher.createAndSubmitHardkeyEvent(n4);
                } else {
                    this.logger.warn(2048, "[RMA KeyFilter] key filter: discard event!!!! ");
                }
            } else {
                ServiceManager.eventDispatcher.createAndSubmitHardkeyEvent(n4);
            }
        }
    }
}

