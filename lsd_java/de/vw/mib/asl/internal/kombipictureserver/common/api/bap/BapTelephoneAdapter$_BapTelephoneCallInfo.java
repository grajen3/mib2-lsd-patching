/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.common.api.bap;

import de.vw.mib.asl.internal.kombipictureserver.common.api.bap.telephone.BapTelephoneCallInfo;

class BapTelephoneAdapter$_BapTelephoneCallInfo
implements BapTelephoneCallInfo {
    private final int _callId;
    private final int _callState;
    private final int _callType;

    public BapTelephoneAdapter$_BapTelephoneCallInfo(int n, int n2, int n3) {
        this._callId = n;
        this._callState = n2;
        this._callType = n3;
    }

    @Override
    public int getCallId() {
        return this._callId;
    }

    @Override
    public int getCallState() {
        return this._callState;
    }

    @Override
    public int getCallType() {
        return this._callType;
    }
}

