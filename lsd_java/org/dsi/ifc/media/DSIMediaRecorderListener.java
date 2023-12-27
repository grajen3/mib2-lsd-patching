/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.media.DatabaseSpace;
import org.dsi.ifc.media.ListEntry;

public interface DSIMediaRecorderListener
extends DSIListener {
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
}

