/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.onlineservices.auth;

import de.esolutions.fw.comm.asi.onlineservices.auth.PairingCodeValidatorReply;

public interface PairingCodeValidatorS {
    default public void validatePairingCode(String string, String string2, int n, int n2, PairingCodeValidatorReply pairingCodeValidatorReply) {
    }

    default public void updateActiveProfile(int n, String string, String string2, PairingCodeValidatorReply pairingCodeValidatorReply) {
    }
}

