/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.download.transformer;

public class SwdlUpdateDataCollector {
    public String dataName;
    public int dataState;
    public int plannedResult;
    public String dataVersion;
    public String dataTargetVersion;
    public boolean dataMarkerDataInSlotIsCurrentVersion = false;
    public boolean doneCollectingDataState = false;
    public boolean doneCollectingDataVersion = false;
    public boolean doneCollectingDataTargetVersion = false;
    public boolean doneCollectingDataNames = false;
    public final String deviceName;
    public final String moduleName;
    public final int retries;
    public final int progress;
    public String stateAbbreviation;
    private static final char OPEN_BRACE;
    private static final char COMMA;
    private static final char CLOSE_BRACE;

    public SwdlUpdateDataCollector() {
        this.dataName = "";
        this.dataVersion = "";
        this.dataTargetVersion = "";
        this.dataState = 0;
        this.plannedResult = 0;
        this.dataMarkerDataInSlotIsCurrentVersion = false;
        this.deviceName = "";
        this.moduleName = "";
        this.progress = 0;
        this.retries = 0;
        this.stateAbbreviation = "";
    }

    public SwdlUpdateDataCollector(int n, int n2, String string, String string2, boolean bl) {
        this.dataName = "";
        this.dataVersion = "";
        this.dataTargetVersion = "";
        this.dataState = 0;
        this.dataMarkerDataInSlotIsCurrentVersion = bl;
        this.deviceName = string;
        this.moduleName = string2;
        this.progress = n;
        this.retries = n2;
        this.stateAbbreviation = "";
    }

    public SwdlUpdateDataCollector(String string, String string2) {
        this.dataName = string;
        this.dataVersion = string2;
        this.dataTargetVersion = "";
        this.dataState = 0;
        this.dataMarkerDataInSlotIsCurrentVersion = false;
        this.deviceName = "";
        this.moduleName = "";
        this.progress = 0;
        this.retries = 0;
        this.stateAbbreviation = "";
    }

    public SwdlUpdateDataCollector(int n, int n2, String string, String string2, boolean bl, int n3) {
        this.dataName = "";
        this.dataVersion = "";
        this.dataTargetVersion = "";
        this.dataState = 0;
        this.plannedResult = n3;
        this.dataMarkerDataInSlotIsCurrentVersion = bl;
        this.deviceName = string;
        this.moduleName = string2;
        this.progress = n;
        this.retries = n2;
        this.stateAbbreviation = "";
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SwdlUpdateDataCollector");
        stringBuffer.append('[');
        stringBuffer.append("dataName: ");
        stringBuffer.append(this.dataName);
        stringBuffer.append(',');
        stringBuffer.append("dataState: ");
        stringBuffer.append(this.dataState);
        stringBuffer.append(',');
        stringBuffer.append("dataVersion: ");
        stringBuffer.append(this.dataVersion);
        stringBuffer.append(',');
        stringBuffer.append("dataTargetVersion: ");
        stringBuffer.append(this.dataTargetVersion);
        stringBuffer.append(',');
        stringBuffer.append("doneCollectingDataState: ");
        stringBuffer.append(this.doneCollectingDataState);
        stringBuffer.append(',');
        stringBuffer.append("doneCollectingDataVersion: ");
        stringBuffer.append(this.doneCollectingDataVersion);
        stringBuffer.append(',');
        stringBuffer.append("doneCollectingDataTargetVersion: ");
        stringBuffer.append(this.doneCollectingDataTargetVersion);
        stringBuffer.append(',');
        stringBuffer.append("dataMarkerDataInSlotIsCurrentVersion: ");
        stringBuffer.append(this.dataMarkerDataInSlotIsCurrentVersion);
        stringBuffer.append(']');
        stringBuffer.append(',');
        stringBuffer.append("stateAbbreviation: ");
        stringBuffer.append(this.stateAbbreviation);
        stringBuffer.append(']');
        return stringBuffer.toString();
    }
}

