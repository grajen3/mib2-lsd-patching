/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.browser.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.browser.ImportReport;

public class ImportReportSerializer {
    public static void putOptionalImportReport(ISerializer iSerializer, ImportReport importReport) {
        boolean bl = importReport == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = importReport.getInserted();
            iSerializer.putInt32(n);
            int n2 = importReport.getSkippedOther();
            iSerializer.putInt32(n2);
            int n3 = importReport.getSkippedBecauseTooLong();
            iSerializer.putInt32(n3);
            int n4 = importReport.getSkippedBecauseNonEraseable();
            iSerializer.putInt32(n4);
            boolean bl2 = importReport.isConvError();
            iSerializer.putBool(bl2);
            boolean bl3 = importReport.isParseError();
            iSerializer.putBool(bl3);
            boolean bl4 = importReport.isOverQuota();
            iSerializer.putBool(bl4);
            boolean bl5 = importReport.isSuccess();
            iSerializer.putBool(bl5);
        }
    }

    public static void putOptionalImportReportVarArray(ISerializer iSerializer, ImportReport[] importReportArray) {
        boolean bl = importReportArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(importReportArray.length);
            for (int i2 = 0; i2 < importReportArray.length; ++i2) {
                ImportReportSerializer.putOptionalImportReport(iSerializer, importReportArray[i2]);
            }
        }
    }

    public static ImportReport getOptionalImportReport(IDeserializer iDeserializer) {
        ImportReport importReport = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            int n;
            int n2;
            int n3;
            int n4;
            importReport = new ImportReport();
            importReport.inserted = n4 = iDeserializer.getInt32();
            importReport.skippedOther = n3 = iDeserializer.getInt32();
            importReport.skippedBecauseTooLong = n2 = iDeserializer.getInt32();
            importReport.skippedBecauseNonEraseable = n = iDeserializer.getInt32();
            importReport.convError = bl5 = iDeserializer.getBool();
            importReport.parseError = bl4 = iDeserializer.getBool();
            importReport.overQuota = bl3 = iDeserializer.getBool();
            importReport.success = bl2 = iDeserializer.getBool();
        }
        return importReport;
    }

    public static ImportReport[] getOptionalImportReportVarArray(IDeserializer iDeserializer) {
        ImportReport[] importReportArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            importReportArray = new ImportReport[n];
            for (int i2 = 0; i2 < n; ++i2) {
                importReportArray[i2] = ImportReportSerializer.getOptionalImportReport(iDeserializer);
            }
        }
        return importReportArray;
    }
}

