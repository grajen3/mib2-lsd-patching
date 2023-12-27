/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.online.services.verification;

import de.vw.mib.asl.api.online.services.verification.CarNetPinVerificationServiceListener;

public interface CarNetPinVerificationService {
    default public void verifyCarNetPin(String string, CarNetPinVerificationServiceListener carNetPinVerificationServiceListener) {
    }
}

