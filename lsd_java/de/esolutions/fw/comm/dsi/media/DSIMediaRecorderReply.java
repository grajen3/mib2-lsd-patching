/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media;

import org.dsi.ifc.media.DatabaseSpace;
import org.dsi.ifc.media.ListEntry;

public interface DSIMediaRecorderReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateActiveMedia(long l, long l2, int n) {
    }

    default public void responseSetSelection(int n, boolean bl) {
    }

    default public void updateImportSummary(long l, long l2, long l3, long l4, long l5, long l6, int n) {
    }

    default public void updateImportProgress(long l, ListEntry listEntry, int n) {
    }

    default public void updateImportStatus(int n, int n2) {
    }

    default public void updateDeletionProgress(long l, int n) {
    }

    default public void updateDeletionStatus(int n, int n2) {
    }

    default public void updateDatabaseSpace(DatabaseSpace databaseSpace, int n) {
    }

    default public void updateTargetMedia(long l, long l2, int n) {
    }

    default public void responseSetEncodingQuality(int n) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

