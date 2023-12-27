/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sApplicationSoftwareVersionNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSerialNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSparePartNumber;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSubsystemState;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sSystemName;
import de.esolutions.fw.comm.asi.diagnosis.media.sActiveMediaSourceState;
import de.esolutions.fw.comm.asi.diagnosis.media.sDTCPState;
import de.esolutions.fw.comm.asi.diagnosis.media.sMediaDBVersion;
import de.esolutions.fw.comm.asi.diagnosis.media.sMediaRegionCodes;
import de.esolutions.fw.comm.asi.diagnosis.media.sMediaTypeOpticalDrive;
import de.esolutions.fw.comm.asi.diagnosis.media.sPmlState;
import de.esolutions.fw.comm.asi.diagnosis.media.sUsbOvercurrent;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2MediaDiagServiceReply;

public interface MMX2MediaDiagServiceS {
    default public void responseErrorMedia(sClientResponseError sClientResponseError2, MMX2MediaDiagServiceReply mMX2MediaDiagServiceReply) {
    }

    default public void responseSubsystemState(sSubsystemState sSubsystemState2, MMX2MediaDiagServiceReply mMX2MediaDiagServiceReply) {
    }

    default public void responseMediaDBVersion(sMediaDBVersion sMediaDBVersion2, MMX2MediaDiagServiceReply mMX2MediaDiagServiceReply) {
    }

    default public void responseActiveMediaSourceState(sActiveMediaSourceState sActiveMediaSourceState2, MMX2MediaDiagServiceReply mMX2MediaDiagServiceReply) {
    }

    default public void responseMediaRegionCodes(sMediaRegionCodes sMediaRegionCodes2, MMX2MediaDiagServiceReply mMX2MediaDiagServiceReply) {
    }

    default public void responseMediaTypeOpticalDrive(sMediaTypeOpticalDrive sMediaTypeOpticalDrive2, MMX2MediaDiagServiceReply mMX2MediaDiagServiceReply) {
    }

    default public void responseUsbOvercurrent(sUsbOvercurrent sUsbOvercurrent2, MMX2MediaDiagServiceReply mMX2MediaDiagServiceReply) {
    }

    default public void responsePmlState(sPmlState sPmlState2, MMX2MediaDiagServiceReply mMX2MediaDiagServiceReply) {
    }

    default public void responseSparePartNumberMediaDB(sSparePartNumber sSparePartNumber2, MMX2MediaDiagServiceReply mMX2MediaDiagServiceReply) {
    }

    default public void responseApplicationSoftwareVersionNumberMediaDB(sApplicationSoftwareVersionNumber sApplicationSoftwareVersionNumber2, MMX2MediaDiagServiceReply mMX2MediaDiagServiceReply) {
    }

    default public void responseSerialNumberMediaDB(sSerialNumber sSerialNumber2, MMX2MediaDiagServiceReply mMX2MediaDiagServiceReply) {
    }

    default public void responseSystemNameMediaDB(sSystemName sSystemName2, MMX2MediaDiagServiceReply mMX2MediaDiagServiceReply) {
    }

    default public void responseStatusUSBCommunication(long l, int n, MMX2MediaDiagServiceReply mMX2MediaDiagServiceReply) {
    }

    default public void responseUSBHubIdentification(long l, short[] sArray, MMX2MediaDiagServiceReply mMX2MediaDiagServiceReply) {
    }

    default public void responseDTCPEncryptionState(long l, sDTCPState[] sDTCPStateArray, MMX2MediaDiagServiceReply mMX2MediaDiagServiceReply) {
    }

    default public void responseDTCPKeytypeMMX(long l, int n, MMX2MediaDiagServiceReply mMX2MediaDiagServiceReply) {
    }

    default public void responseDTCPSRMInfo(long l, short s, int n, int n2, MMX2MediaDiagServiceReply mMX2MediaDiagServiceReply) {
    }
}

