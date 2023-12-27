/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.online.services.authenticate;

public interface OnlineAuthenticationListener {
    public static final int RESULT_OK;
    public static final int RESULT_ERROR;
    public static final int RESULT_AUTHMETHOD_NOT_IMPLEMENTED;
    public static final int RESULT_SPIN_WRONG;
    public static final int RESULT_SPIN_LOCKED;

    default public void updateSpinHashResult(String string, int n) {
    }

    default public void updateSpinRequired(String string) {
    }

    default public void setSPinResponse(String string, int n) {
    }

    default public void updateMainUserEnrolled(boolean bl, String string) {
    }
}

