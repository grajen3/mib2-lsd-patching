/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2;

import de.vw.mib.asl.framework.api.persistence2.ProfileOperationParticipant;
import de.vw.mib.asl.framework.internal.persistence.internal.util.Preconditions;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ProfileOperationRegistry {
    private final Set participants = new HashSet();

    public void addProfileOperationParticipant(ProfileOperationParticipant profileOperationParticipant) {
        Preconditions.checkArgumentNotNull(profileOperationParticipant, "Participant must not be null");
        Preconditions.checkArgument(!this.participants.contains(profileOperationParticipant), new StringBuffer().append("Participant ").append(super.getClass().getName()).append(" was added before").toString());
        this.participants.add(profileOperationParticipant);
    }

    public void copyProfile(int n, int n2) {
        Iterator iterator = this.participants.iterator();
        while (iterator.hasNext()) {
            ProfileOperationParticipant profileOperationParticipant = (ProfileOperationParticipant)iterator.next();
            profileOperationParticipant.copyProfile(n, n2);
        }
    }

    public void resetProfile(int n) {
        Iterator iterator = this.participants.iterator();
        while (iterator.hasNext()) {
            ProfileOperationParticipant profileOperationParticipant = (ProfileOperationParticipant)iterator.next();
            profileOperationParticipant.resetProfile(n);
        }
    }

    public void resetAllProfiles() {
        Iterator iterator = this.participants.iterator();
        while (iterator.hasNext()) {
            ProfileOperationParticipant profileOperationParticipant = (ProfileOperationParticipant)iterator.next();
            profileOperationParticipant.resetAllProfiles();
        }
    }
}

