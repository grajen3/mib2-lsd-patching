/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.startup;

import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.internal.persistence.AslPersistenceAsyncApi;
import de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider.PersistenceServices;
import de.vw.mib.asl.framework.internal.persistence.internal.startup.AbstractInitialStartupTarget;
import de.vw.mib.genericevents.EventGeneric;

public class InitialProfileTargetHIGH
extends AbstractInitialStartupTarget {
    public InitialProfileTargetHIGH(PersistenceServices persistenceServices) {
        super(persistenceServices);
    }

    @Override
    void requestInitialProfile(int n, int n2, PersistenceServices persistenceServices) {
        this.info("Requesting startup profile for HIGH (readInt).");
        AslPersistenceAsyncApi aslPersistenceAsyncApi = persistenceServices.getAslPersistenceAsyncApi();
        aslPersistenceAsyncApi.readInt(n, n2, -1945800920, 0);
    }

    @Override
    void processInitialProfileResponse(EventGeneric eventGeneric) {
        byte by = this.getStartupProfile(eventGeneric);
        this.info(new StringBuffer().append("processInitialProfileResponse startupProfileId=").append(by).append(" ").append(eventGeneric).toString());
        if (this.isInvalidStartupProfile(by)) {
            this.setInitialProfileToDefault("The initial startup profile is invalid!");
            return;
        }
        this.info(new StringBuffer().append("Persistence sets initial profile to ").append(by).toString());
        this.setInitialProfile(by);
    }

    @Override
    void writeInitialProfile(byte by, AslPersistenceSyncApi aslPersistenceSyncApi) {
        this.info(new StringBuffer().append("Writing new initial profile >").append(by).append("< after profile change to persistence.").toString());
        aslPersistenceSyncApi.writeInt(-1945800920, 0, by);
    }

    private byte getStartupProfile(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(2);
        return (byte)(n & 0xF);
    }
}

