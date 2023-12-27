/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sRoutineResponse;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2TelephoneDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sConnectedBtHandset;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sNadIMEI;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sNumberHandsetsHUCs;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sSimState;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sTelephoneAntennaState;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sTelephoneNetworkState;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sTelephoneTemperature;

public interface MMX2TelephoneDiagServiceS {
    default public void responseErrorTelephone(sClientResponseError sClientResponseError2, MMX2TelephoneDiagServiceReply mMX2TelephoneDiagServiceReply) {
    }

    default public void responseSimState(sSimState sSimState2, MMX2TelephoneDiagServiceReply mMX2TelephoneDiagServiceReply) {
    }

    default public void responseNadIMEI(sNadIMEI sNadIMEI2, MMX2TelephoneDiagServiceReply mMX2TelephoneDiagServiceReply) {
    }

    default public void responseTelephoneAntennaState(sTelephoneAntennaState sTelephoneAntennaState2, MMX2TelephoneDiagServiceReply mMX2TelephoneDiagServiceReply) {
    }

    default public void responseConnectedBtHandset(sConnectedBtHandset sConnectedBtHandset2, MMX2TelephoneDiagServiceReply mMX2TelephoneDiagServiceReply) {
    }

    default public void responseNumberHandsetsHUCs(sNumberHandsetsHUCs sNumberHandsetsHUCs2, MMX2TelephoneDiagServiceReply mMX2TelephoneDiagServiceReply) {
    }

    default public void responseTelephoneNetworkState(sTelephoneNetworkState sTelephoneNetworkState2, MMX2TelephoneDiagServiceReply mMX2TelephoneDiagServiceReply) {
    }

    default public void responseTelephoneTemperature(sTelephoneTemperature sTelephoneTemperature2, MMX2TelephoneDiagServiceReply mMX2TelephoneDiagServiceReply) {
    }

    default public void responseDeleteMemory(sRoutineResponse sRoutineResponse2, MMX2TelephoneDiagServiceReply mMX2TelephoneDiagServiceReply) {
    }

    default public void responseNetworkName(long l, String string, MMX2TelephoneDiagServiceReply mMX2TelephoneDiagServiceReply) {
    }

    default public void responseNetworkType(long l, int n, MMX2TelephoneDiagServiceReply mMX2TelephoneDiagServiceReply) {
    }

    default public void responseDialNumber(long l, MMX2TelephoneDiagServiceReply mMX2TelephoneDiagServiceReply) {
    }

    default public void responseCallStatus(long l, boolean bl, MMX2TelephoneDiagServiceReply mMX2TelephoneDiagServiceReply) {
    }

    default public void responseInternalSimIdentification(long l, String string, String string2, MMX2TelephoneDiagServiceReply mMX2TelephoneDiagServiceReply) {
    }
}

