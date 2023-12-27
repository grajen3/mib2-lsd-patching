/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.functions;

import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallInfo_Status;
import de.vw.mib.bap.mqbab2.telephone.functions.CallInfo;

public class CallInfoArabic
extends CallInfo {
    @Override
    protected void computeCallInfo(CallInfo_Status callInfo_Status) {
        super.computeCallInfo(callInfo_Status);
        if (callInfo_Status.pbName0.isArabic()) {
            callInfo_Status.pbName0.setNullString();
        }
        if (callInfo_Status.pbName1.isArabic()) {
            callInfo_Status.pbName1.setNullString();
        }
        if (callInfo_Status.pbName2.isArabic()) {
            callInfo_Status.pbName2.setNullString();
        }
        if (callInfo_Status.pbName3.isArabic()) {
            callInfo_Status.pbName3.setNullString();
        }
        if (callInfo_Status.pbName4.isArabic()) {
            callInfo_Status.pbName4.setNullString();
        }
        if (callInfo_Status.pbName5.isArabic()) {
            callInfo_Status.pbName5.setNullString();
        }
        if (callInfo_Status.pbName6.isArabic()) {
            callInfo_Status.pbName6.setNullString();
        }
    }
}

