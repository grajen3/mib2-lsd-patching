/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.factoryreset;

import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponent;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetParticipant;
import de.vw.mib.asl.internal.system.util.Preconditions;
import java.util.HashMap;
import java.util.HashSet;

final class ComponentParticipantsMap {
    private static final String COMPONENT_MUST_NOT_BE_NULL;
    private static final FactoryResetParticipant[] EMPTY_ARRAY;
    private static final String PARTICIPANT_MUST_NOT_BE_NULL;
    private final HashMap multiMap = new HashMap();

    ComponentParticipantsMap() {
    }

    public boolean containsEntry(FactoryResetComponent factoryResetComponent, FactoryResetParticipant factoryResetParticipant) {
        HashSet hashSet = (HashSet)this.multiMap.get(factoryResetComponent);
        if (hashSet == null) {
            return false;
        }
        return hashSet.contains(factoryResetParticipant);
    }

    public FactoryResetParticipant[] get(FactoryResetComponent factoryResetComponent) {
        HashSet hashSet = (HashSet)this.multiMap.get(factoryResetComponent);
        return hashSet == null ? EMPTY_ARRAY : hashSet.toArray(new FactoryResetParticipant[hashSet.size()]);
    }

    public boolean hasParticipants(FactoryResetComponent factoryResetComponent) {
        HashSet hashSet = (HashSet)this.multiMap.get(factoryResetComponent);
        return hashSet == null ? false : !hashSet.isEmpty();
    }

    public void put(FactoryResetComponent factoryResetComponent, FactoryResetParticipant factoryResetParticipant) {
        Preconditions.checkArgumentNotNull(factoryResetComponent, "Component must not be null.");
        Preconditions.checkArgumentNotNull(factoryResetParticipant, "Participant must not be null.");
        HashSet hashSet = (HashSet)this.multiMap.get(factoryResetComponent);
        if (hashSet == null) {
            hashSet = new HashSet();
            this.multiMap.put(factoryResetComponent, hashSet);
        }
        hashSet.add(factoryResetParticipant);
    }

    public void remove(FactoryResetComponent factoryResetComponent, FactoryResetParticipant factoryResetParticipant) {
        HashSet hashSet = (HashSet)this.multiMap.get(factoryResetComponent);
        if (hashSet == null) {
            return;
        }
        hashSet.remove(factoryResetParticipant);
        if (hashSet.isEmpty()) {
            this.multiMap.remove(factoryResetComponent);
        }
    }

    static {
        EMPTY_ARRAY = new FactoryResetParticipant[0];
    }
}

