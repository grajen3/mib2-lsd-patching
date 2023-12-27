/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec;

import de.esolutions.fw.comm.asi.fec.SFecDetails;
import de.esolutions.fw.comm.asi.fec.SFecHistory;
import de.esolutions.fw.comm.asi.fec.SFecImportStatus;

public interface FecManagerReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void checkDataSignature(String string, boolean bl) {
    }

    default public void fecDetails(SFecDetails sFecDetails) {
    }

    default public void importFecs(int n, SFecImportStatus[] sFecImportStatusArray) {
    }

    default public void exportCCD(int n) {
    }

    default public void getHistory(SFecHistory[] sFecHistoryArray) {
    }

    default public void encryptFile(String string, int n) {
    }

    default public void decryptFile(String string, int n) {
    }
}

