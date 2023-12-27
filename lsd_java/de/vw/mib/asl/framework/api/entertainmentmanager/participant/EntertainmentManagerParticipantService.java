/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.entertainmentmanager.participant;

import de.vw.mib.asl.framework.api.entertainmentmanager.participant.EntertainmentManagerParticipant;

public interface EntertainmentManagerParticipantService {
    default public void registerParticipant(int n, EntertainmentManagerParticipant entertainmentManagerParticipant) {
    }

    default public void unregisterParticipant(int n) {
    }

    default public boolean isRegistered(int n) {
    }

    default public void requestContext(int n) {
    }
}

