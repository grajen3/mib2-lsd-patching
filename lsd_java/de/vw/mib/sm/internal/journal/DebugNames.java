/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal.journal;

import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.hmi.HmiEventIdMap;
import de.vw.mib.hmi.internal.PublicIdMapImpl;
import de.vw.mib.hmi.utils.DebugDataReader;
import de.vw.mib.hmi.utils.PerfectSlotHash;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class DebugNames {
    private static final String UNKNOWN;
    private static final String EVENTS_DEBUG_INFO_FILE_NAME;
    private static final String STATEMACHINES_DEBUG_INFO_FILE_NAME;
    private PerfectSlotHash publicEventId_2_eventSlot = PerfectSlotHash.NULL;
    private IntIntOptHashMap compactEventId_2_publicEventId = DebugNames.createEmptyIntIntOptHashMap();
    private String[] eventNames = new String[0];
    private String[] eventTypes = new String[0];
    private String[] topStatemachineNames = new String[0];
    private String[] subStatemachineNames = new String[0];
    private String[] stateNames = new String[0];

    public void load(InputStream inputStream, int n, int n2) {
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        if (zipInputStream != null) {
            this.loadFromZipStream(zipInputStream, n, n2);
        }
    }

    public String resolveEventNameByPublicId(int n) {
        int n2 = this.publicEventId_2_eventSlot.getSlot(n);
        return this.getArrayItemOrUnknown(this.eventNames, n2);
    }

    public String resolveEventNameByCompactId(int n) {
        int n2 = this.compactEventId_2_publicEventId.get(n);
        return this.resolveEventNameByPublicId(n2);
    }

    public String resolveEventType(int n) {
        int n2 = this.publicEventId_2_eventSlot.getSlot(n);
        return this.getArrayItemOrUnknown(this.eventTypes, n2);
    }

    public String resolveTopStatemachineName(int n) {
        return this.getArrayItemOrUnknown(this.topStatemachineNames, n);
    }

    public String resolveSubStatemachineName(int n) {
        return this.getArrayItemOrUnknown(this.subStatemachineNames, n);
    }

    public String resolveStateName(int n) {
        return this.getArrayItemOrUnknown(this.stateNames, n);
    }

    private void loadFromZipStream(ZipInputStream zipInputStream, int n, int n2) {
        ZipEntry zipEntry = zipInputStream.getNextEntry();
        while (zipEntry != null) {
            this.loadDebugEventsInformation(n, zipInputStream, zipEntry);
            this.loadDebugStatemachinesInformations(n2, zipInputStream, zipEntry);
            zipEntry = zipInputStream.getNextEntry();
        }
    }

    private void loadDebugEventsInformation(int n, ZipInputStream zipInputStream, ZipEntry zipEntry) {
        if (this.isAcceptedZipEntry("DebugEvents.info", zipEntry)) {
            Object[] objectArray = this.readData(zipInputStream, n, 1143817558, "DebugEvents.info");
            int[] nArray = (int[])objectArray[1];
            short[] sArray = (short[])objectArray[5];
            this.publicEventId_2_eventSlot = PerfectSlotHash.newSlotHash(nArray, sArray);
            this.compactEventId_2_publicEventId = this.mapCompactEventId_2_publicEventId(nArray);
            this.eventNames = (String[])objectArray[2];
            this.eventTypes = (String[])objectArray[3];
        }
    }

    private void loadDebugStatemachinesInformations(int n, ZipInputStream zipInputStream, ZipEntry zipEntry) {
        if (this.isAcceptedZipEntry("DebugStatemachines.info", zipEntry)) {
            Object[] objectArray = this.readData(zipInputStream, n, 1143821133, "DebugStatemachines.info");
            this.topStatemachineNames = (String[])objectArray[1];
            this.subStatemachineNames = (String[])objectArray[2];
            this.stateNames = (String[])objectArray[3];
        }
    }

    private boolean isAcceptedZipEntry(String string, ZipEntry zipEntry) {
        return string.equals(zipEntry.getName());
    }

    private Object[] readData(ZipInputStream zipInputStream, int n, int n2, String string) {
        Object[] objectArray = DebugDataReader.readData(zipInputStream);
        this.assertValidChecksumAndMagicNumber(objectArray, n, n2, string);
        return objectArray;
    }

    private void assertValidChecksumAndMagicNumber(Object[] objectArray, int n, int n2, String string) {
        int[] nArray = (int[])objectArray[0];
        if (nArray[0] != n2) {
            throw new IOException(new StringBuffer().append("Invalid Magic Number for ").append(string).toString());
        }
        if (nArray[1] != n && n != 0) {
            throw new IOException(new StringBuffer().append("Invalid Checksum for ").append(string).toString());
        }
    }

    private IntIntOptHashMap mapCompactEventId_2_publicEventId(int[] nArray) {
        IntIntOptHashMap intIntOptHashMap = DebugNames.createEmptyIntIntOptHashMap();
        HmiEventIdMap hmiEventIdMap = this.getHmiEventIdMap();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            short s = hmiEventIdMap.getCompactEventId(nArray[i2]);
            if (s < 0) continue;
            intIntOptHashMap.put(s, nArray[i2]);
        }
        return intIntOptHashMap;
    }

    protected HmiEventIdMap getHmiEventIdMap() {
        return new PublicIdMapImpl();
    }

    private static IntIntOptHashMap createEmptyIntIntOptHashMap() {
        int n = 3;
        int n2 = 63;
        int n3 = 63;
        int n4 = -1;
        return IntIntOptHashMap.createWithNeutralValue(3, 63, 63, -1);
    }

    private String getArrayItemOrUnknown(String[] stringArray, int n) {
        return n >= 0 && n < stringArray.length ? stringArray[n] : "???";
    }
}

