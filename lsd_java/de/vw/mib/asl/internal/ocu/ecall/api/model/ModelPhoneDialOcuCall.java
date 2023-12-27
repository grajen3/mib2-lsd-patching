/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.ecall.api.model;

public interface ModelPhoneDialOcuCall {
    public static final int[] SERVICE_CONSTANTS = new int[]{-295955136, -279177920, -262400704, -346286784, -480504512, -312732352, -463727296};

    default public void abortEmergencyConfirmation() {
    }

    default public void abortService() {
    }

    default public void confirmEmergencyConfirmation() {
    }

    default public void denyAllServicesConfirmations() {
    }

    default public void dialEmergencyNumber() {
    }

    default public void dialInfoNumber() {
    }

    default public void dialServiceNumber() {
    }
}

