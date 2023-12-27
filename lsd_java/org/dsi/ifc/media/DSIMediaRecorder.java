/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

import org.dsi.ifc.base.DSIBase;

public interface DSIMediaRecorder
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_ACTIVEMEDIA;
    public static final int ATTR_IMPORTSUMMARY;
    public static final int ATTR_IMPORTPROGRESS;
    public static final int ATTR_DELETIONPROGRESS;
    public static final int ATTR_DATABASESPACE;
    public static final int ATTR_IMPORTSTATUS;
    public static final int ATTR_DELETIONSTATUS;
    public static final int ATTR_TARGETMEDIA;
    public static final int RT_SETACTIVEMEDIA;
    public static final int RT_SETSELECTION;
    public static final int RT_SETTARGETMEDIA;
    public static final int RT_STARTIMPORT;
    public static final int RT_ABORTIMPORT;
    public static final int RT_STARTDELETE;
    public static final int RT_ABORTDELETE;
    public static final int RT_SETENCODINGQUALITY;
    public static final int RP_RESPONSESETSELECTION;
    public static final int RP_RESPONSESETENCODINGQUALITY;
    public static final int IMPORTSTATUS_IDLE;
    public static final int IMPORTSTATUS_IMPORTING;
    public static final int IMPORTSTATUS_PRE_PROCESSING;
    public static final int IMPORTSTATUS_POST_PROCESSING;
    public static final int IMPORTSTATUS_SUCCESS;
    public static final int IMPORTSTATUS_ABORTED;
    public static final int IMPORTSTATUS_SUSPEND;
    public static final int IMPORTSTATUS_READY_FOR_SELECTION;
    public static final int IMPORTSTATUS_READY_FOR_RESUME;
    public static final int DELETIONSTATUS_IDLE;
    public static final int DELETIONSTATUS_DELETING;
    public static final int DELETIONSTATUS_PRE_PROCESSING;
    public static final int DELETIONSTATUS_POST_PROCESSING;
    public static final int DELETIONSTATUS_SUCCESS;
    public static final int DELETIONSTATUS_ABORTED;
    public static final int DELETIONSTATUS_FINISHED_WITH_ERRORS;
    public static final int DELETIONSTATUS_READY_FOR_SELECTION;
    public static final int ENCODINGQUALITY_MAX;
    public static final int ENCODINGQUALITY_HIGH;
    public static final int ENCODINGQUALITY_MEDIUM;
    public static final int ENCODINGQUALITY_LOW;

    default public void setActiveMedia(long l, long l2) {
    }

    default public void setSelection(int n) {
    }

    default public void startImport(boolean bl) {
    }

    default public void abortImport() {
    }

    default public void startDelete() {
    }

    default public void abortDelete() {
    }

    default public void setTargetMedia(long l, long l2) {
    }

    default public void setEncodingQuality(int n) {
    }
}

