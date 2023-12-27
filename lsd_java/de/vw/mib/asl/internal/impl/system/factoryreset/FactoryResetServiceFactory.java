/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.factoryreset;

import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.internal.impl.system.factoryreset.FactoryResetPopupUpdater;
import de.vw.mib.asl.internal.impl.system.factoryreset.FactoryResetServiceImpl;
import de.vw.mib.asl.internal.impl.system.factoryreset.FactoryResetTimeoutManager;
import de.vw.mib.asl.internal.impl.system.factoryreset.FactoryResetTimer;
import de.vw.mib.asl.internal.impl.system.factoryreset.participant.DefaultLegacyFactoryResetParticipant;
import de.vw.mib.asl.internal.impl.system.factoryreset.participant.FullFactoryResetParticipant;
import de.vw.mib.asl.internal.impl.system.factoryreset.participant.GlobalFacoryResetParticipant;
import de.vw.mib.asl.internal.impl.system.factoryreset.participant.MediaFactoryResetParticipant;
import de.vw.mib.asl.internal.impl.system.factoryreset.participant.PersonalizationFactoryResetParticipant;
import de.vw.mib.asl.internal.system.SystemServices;

public class FactoryResetServiceFactory {
    private final SystemServices systemServices;

    public FactoryResetServiceFactory(SystemServices systemServices) {
        this.systemServices = systemServices;
    }

    public FactoryResetService createFactoryResetService() {
        FactoryResetTimer factoryResetTimer = new FactoryResetTimer(this.systemServices.getThreadSwitcher(), this.systemServices.getTimerManager());
        FactoryResetTimeoutManager factoryResetTimeoutManager = new FactoryResetTimeoutManager(factoryResetTimer, this.systemServices);
        FactoryResetServiceImpl factoryResetServiceImpl = new FactoryResetServiceImpl(this.systemServices.getAsyncServiceFactory(), this.systemServices.getAsl1Logger(), factoryResetTimeoutManager);
        this.addLegacyParticipants(factoryResetServiceImpl);
        this.addListeners(factoryResetServiceImpl);
        return factoryResetServiceImpl;
    }

    private void addListeners(FactoryResetService factoryResetService) {
        factoryResetService.addListener(new FactoryResetPopupUpdater(this.systemServices.getSystemEventDispatcher()));
    }

    private void addLegacyParticipants(FactoryResetService factoryResetService) {
        factoryResetService.addGlobalParticipant(new GlobalFacoryResetParticipant(this.systemServices));
        factoryResetService.addParticipant(new DefaultLegacyFactoryResetParticipant(this.systemServices, -308526848, FactoryResetComponents.AUDIO), FactoryResetComponents.AUDIO);
        factoryResetService.addParticipant(new DefaultLegacyFactoryResetParticipant(this.systemServices, -274972416, FactoryResetComponents.CAR), FactoryResetComponents.CAR);
        factoryResetService.addParticipant(new DefaultLegacyFactoryResetParticipant(this.systemServices, -73645824, FactoryResetComponents.CAR_PARKING_ASSISTANCE), FactoryResetComponents.CAR_PARKING_ASSISTANCE);
        factoryResetService.addParticipant(new DefaultLegacyFactoryResetParticipant(this.systemServices, -157531904, FactoryResetComponents.CONNECTIVITY), FactoryResetComponents.CONNECTIVITY);
        factoryResetService.addParticipant(new FullFactoryResetParticipant(this.systemServices), FactoryResetComponents.FULL);
        factoryResetService.addParticipant(new DefaultLegacyFactoryResetParticipant(this.systemServices, -191086336, FactoryResetComponents.INTERNET_BROWSER), FactoryResetComponents.INTERNET_BROWSER);
        factoryResetService.addParticipant(new DefaultLegacyFactoryResetParticipant(this.systemServices, -207863552, FactoryResetComponents.EX_BOX), FactoryResetComponents.EX_BOX);
        factoryResetService.addParticipant(new MediaFactoryResetParticipant(this.systemServices), FactoryResetComponents.MEDIA);
        factoryResetService.addParticipant(new DefaultLegacyFactoryResetParticipant(this.systemServices, -90423040, FactoryResetComponents.MIRRORLINK), FactoryResetComponents.MIRRORLINK);
        factoryResetService.addParticipant(new DefaultLegacyFactoryResetParticipant(this.systemServices, -174309120, FactoryResetComponents.NAVIGATION), FactoryResetComponents.NAVIGATION);
        factoryResetService.addParticipant(new DefaultLegacyFactoryResetParticipant(this.systemServices, -123977472, FactoryResetComponents.ONLINE), FactoryResetComponents.ONLINE);
        factoryResetService.addParticipant(new PersonalizationFactoryResetParticipant(this.systemServices), FactoryResetComponents.PERSONALIZATION);
        factoryResetService.addParticipant(new DefaultLegacyFactoryResetParticipant(this.systemServices, -258195200, FactoryResetComponents.PHONE), FactoryResetComponents.PHONE);
        factoryResetService.addParticipant(new DefaultLegacyFactoryResetParticipant(this.systemServices, -291749632, FactoryResetComponents.RADIO), FactoryResetComponents.RADIO);
        factoryResetService.addParticipant(new DefaultLegacyFactoryResetParticipant(this.systemServices, -224640768, FactoryResetComponents.SPEECH), FactoryResetComponents.SPEECH);
        factoryResetService.addParticipant(new DefaultLegacyFactoryResetParticipant(this.systemServices, -325304064, FactoryResetComponents.TVTUNER), FactoryResetComponents.TVTUNER);
        factoryResetService.addParticipant(new DefaultLegacyFactoryResetParticipant(this.systemServices, -342081280, FactoryResetComponents.WLAN), FactoryResetComponents.WLAN);
    }
}

