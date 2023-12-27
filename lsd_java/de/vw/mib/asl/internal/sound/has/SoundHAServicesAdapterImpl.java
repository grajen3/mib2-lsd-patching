/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound.has;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.has.HAS;
import de.vw.mib.has.HASContext;
import de.vw.mib.has.HASEngineAPI;
import de.vw.mib.has.HASFactory;
import generated.de.vw.mib.has.containers.BalanceFaderContainer;
import generated.de.vw.mib.has.contexts.sound.SoundProperties;
import generated.de.vw.mib.has.contexts.sound.SoundResults;
import generated.de.vw.mib.has.contexts.sound.SoundServicesAdapter;

public class SoundHAServicesAdapterImpl
extends SoundServicesAdapter {
    private final HASContext context;
    private final SoundResults hasResults;
    private final SoundProperties hasProperties;
    private final HASFactory factory;

    public SoundHAServicesAdapterImpl() {
        HASEngineAPI hASEngineAPI = HAS.getInstance().getEngine();
        this.context = hASEngineAPI.getRegistry().getContextByName("Sound");
        this.hasProperties = (SoundProperties)this.context.getPropertiesImpl();
        this.factory = HAS.getInstance().getFactory();
        this.hasResults = (SoundResults)this.context.getResultsImpl();
        this.context.setServicesImpl(this);
    }

    public void register() {
        this.context.setServicesImpl(this);
    }

    @Override
    public void increaseVolume(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1305144064, -1305144064, 537476352);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
        this.hasResults.increaseVolumeResult(n, 0);
    }

    @Override
    public void decreaseVolume(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1305144064, -1305144064, 554253568);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
        this.hasResults.decreaseVolumeResult(n, 0);
    }

    @Override
    public void muteEntertainment(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1338698496, -1338698496, 571030784);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
        this.hasResults.muteEntertainmentResult(n, 0);
    }

    @Override
    public void unmuteEntertainment(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1338698496, -1338698496, 587808000);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
        this.hasResults.unmuteEntertainmentResult(n, 0);
    }

    @Override
    public void setBalanceFader(int n, BalanceFaderContainer balanceFaderContainer) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1305144064, -1305144064, 604585216);
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, balanceFaderContainer.getBalance());
        eventGeneric.setInt(2, balanceFaderContainer.getFader());
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
        this.hasResults.setBalanceFaderResult(n, 0);
    }
}

