/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.util.keymapping;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.system.util.Preconditions;
import de.vw.mib.asl.internal.system.util.keymapping.DsiKeyAndKeyBoardId;
import de.vw.mib.asl.internal.system.util.keymapping.DsiTiming;
import de.vw.mib.asl.internal.system.util.keymapping.StateHKEvent;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.log4mib.Logger;

public class HardKeyReader {
    private static final int VERSION;
    private static final int START_INDEX;
    private static final String LOG_PREFIX;
    private final IntIntOptHashMap dsiKey2Index = new IntIntOptHashMap();
    private int[] longPressTime;
    private int[] ultraLongPressTime;
    private int[][] keyBoardID;
    private int[][] keyStateID;
    private int[][] hkEventID;
    private int[] keyTimesAndMappingsData;
    private int position;
    private StateHKEvent[] stateHKEventCache;
    private DsiTiming[] dsiTimingCache;
    private int versionNumber;
    private StateHKEvent stateHKEventDefaultValue;
    private DsiTiming dsiTimingDefault;
    private Logger logger;

    public HardKeyReader(int[] nArray, Logger logger) {
        Preconditions.checkArgumentNotNull(nArray);
        this.keyTimesAndMappingsData = nArray;
        this.logger = logger;
        this.createDefaultValue();
        this.readTimingAndKeyMapping();
    }

    public StateHKEvent findDsiKeyToASLSystemHKEvent(int n, int n2, int n3) {
        int n4 = this.encodeKeyBoardIdWithDsiKey(n, n2);
        if (!this.dsiKey2Index.containsKey(n4)) {
            return this.stateHKEventDefaultValue;
        }
        if (n2 == 45) {
            switch (n3) {
                case 0: {
                    ServiceManager.eventDispatcher.createAndSubmitHMIEvent(203);
                    break;
                }
                case 3: {
                    ServiceManager.eventDispatcher.createAndSubmitHMIEvent(204);
                    break;
                }
            }
            return new StateHKEvent();
        }
        int n5 = this.dsiKey2Index.get(n4);
        int n6 = this.keyStateID[n5].length;
        for (int i2 = 0; i2 < n6; ++i2) {
            if (n3 != this.keyStateID[n5][i2]) continue;
            if (this.stateHKEventCache[n5 + i2] == null) {
                this.stateHKEventCache[n5 + i2] = new StateHKEvent(this.keyStateID[n5][i2], this.hkEventID[n5][i2]);
                return this.stateHKEventCache[n5 + i2];
            }
            this.stateHKEventCache[n5 + i2].setHkEventID(this.hkEventID[n5][i2]);
            this.stateHKEventCache[n5 + i2].setKeyStateID(this.keyStateID[n5][i2]);
            return this.stateHKEventCache[n5 + i2];
        }
        this.stateHKEventDefaultValue.setKeyStateID(n3);
        return this.stateHKEventDefaultValue;
    }

    public DsiTiming findDsiKeyToTiming(int n, int n2) {
        int n3 = this.encodeKeyBoardIdWithDsiKey(n, n2);
        if (!this.dsiKey2Index.containsKey(n3)) {
            return this.dsiTimingDefault;
        }
        int n4 = this.dsiKey2Index.get(n3);
        if (this.dsiTimingCache[n4] == null) {
            this.dsiTimingCache[n4] = new DsiTiming(this.longPressTime[n4], this.ultraLongPressTime[n4]);
            return this.dsiTimingCache[n4];
        }
        return this.dsiTimingCache[n4];
    }

    public void installAllTimingValues(IntIntOptHashMap intIntOptHashMap, IntIntOptHashMap intIntOptHashMap2) {
        int[] nArray = this.dsiKey2Index.keysToArray();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n = nArray[i2];
            int n2 = this.dsiKey2Index.get(n);
            intIntOptHashMap.put(n, this.longPressTime[n2]);
            intIntOptHashMap2.put(n, this.ultraLongPressTime[n2]);
        }
    }

    public int encodeKeyBoardIdWithDsiKey(int n, int n2) {
        if (this.versionNumber < -2) {
            return (short)((n << 8) + n2);
        }
        return n2;
    }

    public DsiKeyAndKeyBoardId getKeyBoardIdAndDsiKey(int n) {
        int n2 = n >> 8 & 0xFF;
        int n3 = n & 0xFF;
        return new DsiKeyAndKeyBoardId(n3, n2);
    }

    private void setPosition(int n) {
        this.position = n;
    }

    private void readTimingAndKeyMapping() {
        this.setPosition(0);
        this.checkVersionNumber();
        if (this.versionNumber < -2) {
            this.readDataStructure();
        } else {
            this.readTimingData();
            this.readMappingData();
        }
    }

    private void readDataStructure() {
        int n = 0;
        int n2 = this.readStream();
        this.installDefaultKeys(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = this.readStream();
            this.readKeyBoardId(n);
            this.storeStateHKEvents(n);
            this.storeDsiTiming(n);
            this.storeDsiKeyWithKeyBoardIds(n, n3);
            ++n;
        }
    }

    private void storeDsiTiming(int n) {
        this.longPressTime[n] = this.readStream();
        this.ultraLongPressTime[n] = this.readStream();
    }

    private void storeStateHKEvents(int n) {
        int n2 = this.readStream();
        this.installDefaultValueStateHKEvent(n2, n);
        for (int i2 = 0; i2 < n2; ++i2) {
            this.keyStateID[n][i2] = this.readStream();
            this.hkEventID[n][i2] = this.readStream();
        }
    }

    private void storeDsiKeyWithKeyBoardIds(int n, int n2) {
        for (int n3 : this.keyBoardID[n]) {
            int n4 = this.encodeKeyBoardIdWithDsiKey(n3, n2);
            this.dsiKey2Index.put(n4, n);
        }
    }

    private void installDefaultKeys(int n) {
        int n2 = 6;
        this.longPressTime = new int[n];
        this.ultraLongPressTime = new int[n];
        this.dsiTimingCache = new DsiTiming[n];
        this.stateHKEventCache = new StateHKEvent[n * n2];
        this.keyBoardID = new int[n][];
        this.keyStateID = new int[n][];
        this.hkEventID = new int[n][];
        for (int i2 = 0; i2 < n; ++i2) {
            this.longPressTime[i2] = -1;
            this.ultraLongPressTime[i2] = -1;
        }
    }

    private void readMappingData() {
        int n = 6;
        int n2 = this.readStream();
        this.keyStateID = new int[n2][];
        this.hkEventID = new int[n2][];
        this.stateHKEventCache = new StateHKEvent[n2 * n];
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = this.readStream();
            int n4 = this.readStream();
            int n5 = this.dsiKey2Index.get(n3);
            this.installDefaultValueStateHKEvent(n4, n5);
            for (int i3 = 0; i3 < n4; ++i3) {
                this.keyStateID[n5][i3] = this.readStream();
                this.hkEventID[n5][i3] = this.readStream();
            }
        }
    }

    private void installDefaultValueStateHKEvent(int n, int n2) {
        this.keyStateID[n2] = new int[n];
        this.hkEventID[n2] = new int[n];
        for (int i2 = 0; i2 < n; ++i2) {
            this.keyStateID[n2][i2] = -1;
            this.hkEventID[n2][i2] = -1;
        }
    }

    private void readTimingData() {
        int n = 0;
        int n2 = this.readStream();
        this.installDefaultDsiTimings(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = this.readStream();
            this.readKeyBoardId(n);
            this.storeDsiTiming(n);
            this.dsiKey2Index.put(n3, n);
            ++n;
        }
    }

    private void readKeyBoardId(int n) {
        if (this.versionNumber <= -2) {
            int n2 = this.readStream();
            this.keyBoardID[n] = new int[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                this.keyBoardID[n][i2] = this.readStream();
            }
        }
    }

    private int readStream() {
        if (this.position >= this.keyTimesAndMappingsData.length) {
            throw new IndexOutOfBoundsException("Next value is not available.");
        }
        return this.keyTimesAndMappingsData[this.position++];
    }

    private void checkVersionNumber() {
        this.versionNumber = this.readStream();
        if (this.versionNumber < 0) {
            this.trace(new StringBuffer().append("Key map declaration version number ").append(Math.abs(this.versionNumber)).toString());
        } else {
            this.trace("The version number is not available.");
            this.setPosition(0);
        }
    }

    private void createDefaultValue() {
        this.stateHKEventDefaultValue = new StateHKEvent();
        this.dsiTimingDefault = new DsiTiming();
    }

    private void installDefaultDsiTimings(int n) {
        this.longPressTime = new int[n];
        this.ultraLongPressTime = new int[n];
        this.dsiTimingCache = new DsiTiming[n];
        this.keyBoardID = new int[n][];
        for (int i2 = 0; i2 < n; ++i2) {
            this.longPressTime[i2] = -1;
            this.ultraLongPressTime[i2] = -1;
        }
    }

    private void trace(String string) {
        if (this.logger.isTraceEnabled(2048)) {
            this.logger.trace(2048).append("[HardKeyReader] ").append(string).log();
        }
    }
}

