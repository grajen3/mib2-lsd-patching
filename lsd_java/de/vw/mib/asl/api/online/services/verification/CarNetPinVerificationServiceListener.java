/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.online.services.verification;

public interface CarNetPinVerificationServiceListener {
    public static final int RESULT_CARNETPIN_VERIFICATION_OK;
    public static final int RESULT_CARNETPIN_VERIFICATION_WRONG;
    public static final int RESULT_CARNETPIN_VERIFICATION_CONNECTIVITY;
    public static final int RESULT_CARNETPIN_VERIFICATION_ERROR;
    public static final int RESULT_CARNETPIN_VERIFICATION_NOTAVAILABLE;
    public static final int RESULT_CARNETPIN_VERIFICATION_TIMEOUT;
    public static final int RESULT_CARNETPIN_VERIFICATION_CANCELED;

    default public void verifyCarNetPinResponse(int n) {
    }
}

