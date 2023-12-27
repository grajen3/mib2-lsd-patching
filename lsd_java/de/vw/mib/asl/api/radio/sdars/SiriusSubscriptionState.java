/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.radio.sdars;

public interface SiriusSubscriptionState {
    public static final int SIRIUS_SUBSCRIPTIONSTATE_UNDEFINED;
    public static final int SIRIUS_SUBSCRIPTIONSTATE_UNSUBSCRIBED;
    public static final int SIRIUS_SUBSCRIPTIONSTATE_SUBSCRIBED;
    public static final int SIRIUS_SUBSCRIPTIONSTATE_SUSPENDALERT;
    public static final int SIRIUS_SUBSCRIPTIONSTATE_SUSPENDED;

    default public int getSiriusSubscriptionState() {
    }
}

