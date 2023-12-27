/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.startup;

import de.vw.mib.asl.framework.api.diagnosis.ASLDiagnosisAPI;
import de.vw.mib.asl.framework.api.diagnosis.AdaptionApi;
import de.vw.mib.asl.framework.api.diagnosis.config.Information;
import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider.PersistenceServices;
import de.vw.mib.asl.framework.internal.persistence.internal.startup.AbstractInitialStartupTarget;
import de.vw.mib.asl.framework.internal.persistence.internal.startup.InitialProfileTargetSTD$1;
import de.vw.mib.genericevents.EventDispatcherHSM;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public class InitialProfileTargetSTD
extends AbstractInitialStartupTarget {
    public InitialProfileTargetSTD(PersistenceServices persistenceServices) {
        super(persistenceServices);
    }

    @Override
    void requestInitialProfile(int n, int n2, PersistenceServices persistenceServices) {
        this.info("Requesting startup profile for STD (requestConfigManagerPersInformation).");
        ASLDiagnosisAPI aSLDiagnosisAPI = persistenceServices.getDiagnosisAPI();
        AdaptionApi adaptionApi = aSLDiagnosisAPI.getAdaptionApi();
        GenericEvents genericEvents = persistenceServices.getGenericEvents();
        EventFactory eventFactory = genericEvents.getEventFactory();
        EventDispatcherHSM eventDispatcherHSM = genericEvents.getEventDispatcher();
        adaptionApi.requestInformation(new InitialProfileTargetSTD$1(this, eventDispatcherHSM, eventFactory));
    }

    @Override
    void processInitialProfileResponse(EventGeneric eventGeneric) {
        Information information = (Information)eventGeneric.getObject(1);
        if (!this.containsStartupProfile(information)) {
            this.setInitialProfileToDefault("The initial startup profile is not available!");
            return;
        }
        byte by = this.getStartupProfile(information);
        if (this.isInvalidStartupProfile(by)) {
            this.setInitialProfileToDefault("The initial startup profile is invalid!");
            return;
        }
        this.info(new StringBuffer().append("Persistence sets initial profile to ").append(by).toString());
        this.setInitialProfile(by);
    }

    @Override
    void writeInitialProfile(byte by, AslPersistenceSyncApi aslPersistenceSyncApi) {
        this.info(new StringBuffer().append("Writing personalisation startup profile: profileId=").append(by).toString());
        byte[] byArray = new byte[]{by, 0, 0, 0};
        aslPersistenceSyncApi.writeByteArray(-1945800920, 0, byArray);
    }

    private boolean containsStartupProfile(Information information) {
        return information.contains(1192);
    }

    private byte getStartupProfile(Information information) {
        return (byte)(information.getValue(1192) & 0xF);
    }
}

