/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.entertainmentmanager.has;

import de.vw.mib.asl.api.media.services.player.MediaPlayerService;
import de.vw.mib.asl.api.radio.ASLRadioFactory;
import de.vw.mib.asl.framework.api.entertainmentmanager.contextlistener.EntertainmentContextListener;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.entertainmentmanager.activations.AbsoluteActivation;
import de.vw.mib.asl.framework.internal.entertainmentmanager.has.EntertainmentManagerServicesAdapterImpl$1;
import de.vw.mib.asl.framework.internal.entertainmentmanager.has.EntertainmentManagerServicesAdapterImpl$2;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.has.HAS;
import de.vw.mib.has.HASContext;
import de.vw.mib.has.HASEngineAPI;
import generated.de.vw.mib.has.containers.MediaSourceContainer;
import generated.de.vw.mib.has.containers.RadioBandContainer;
import generated.de.vw.mib.has.contexts.entertainmentmanager.EntertainmentManagerProperties;
import generated.de.vw.mib.has.contexts.entertainmentmanager.EntertainmentManagerResults;
import generated.de.vw.mib.has.contexts.entertainmentmanager.EntertainmentManagerServicesAdapter;

public final class EntertainmentManagerServicesAdapterImpl
extends EntertainmentManagerServicesAdapter
implements EntertainmentContextListener {
    private final HASContext context;
    private final EntertainmentManagerResults hasResults;
    private final EntertainmentManagerProperties hasProperties;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$entertainmentmanager$contextlistener$EntertainmentContextListenerService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$media$services$player$MediaPlayerService;

    public EntertainmentManagerServicesAdapterImpl() {
        HASEngineAPI hASEngineAPI = HAS.getInstance().getEngine();
        this.context = hASEngineAPI.getRegistry().getContextByName("EntertainmentManager");
        this.hasProperties = (EntertainmentManagerProperties)this.context.getPropertiesImpl();
        this.hasResults = (EntertainmentManagerResults)this.context.getResultsImpl();
    }

    public void register() {
        this.context.setServicesImpl(this);
        ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().requestAPI(class$de$vw$mib$asl$framework$api$entertainmentmanager$contextlistener$EntertainmentContextListenerService == null ? (class$de$vw$mib$asl$framework$api$entertainmentmanager$contextlistener$EntertainmentContextListenerService = EntertainmentManagerServicesAdapterImpl.class$("de.vw.mib.asl.framework.api.entertainmentmanager.contextlistener.EntertainmentContextListenerService")) : class$de$vw$mib$asl$framework$api$entertainmentmanager$contextlistener$EntertainmentContextListenerService, new EntertainmentManagerServicesAdapterImpl$1(this));
    }

    private void send(int n, AbsoluteActivation absoluteActivation) {
        absoluteActivation.setCallId(n);
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(272503040, 272503040, -715385600);
        eventGeneric.setObject(-1067707136, absoluteActivation);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void activateMediaSource(int n, MediaSourceContainer mediaSourceContainer) {
        MediaPlayerService mediaPlayerService = (MediaPlayerService)ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().getAPIInstance(class$de$vw$mib$asl$api$media$services$player$MediaPlayerService == null ? (class$de$vw$mib$asl$api$media$services$player$MediaPlayerService = EntertainmentManagerServicesAdapterImpl.class$("de.vw.mib.asl.api.media.services.player.MediaPlayerService")) : class$de$vw$mib$asl$api$media$services$player$MediaPlayerService);
        if (mediaPlayerService == null) {
            this.hasResults.activateMediaSourceResult(n, 1);
            return;
        }
        mediaPlayerService.activateMediaSourceByHasId(mediaSourceContainer.getSource(), new EntertainmentManagerServicesAdapterImpl$2(this, n));
    }

    @Override
    public void activateRadioBand(int n, RadioBandContainer radioBandContainer) {
        this.send(n, new AbsoluteActivation(1, ASLRadioFactory.getRadioApi().convertRadioBandHAS2ASL(radioBandContainer.getBand())));
    }

    public void respond(int n, int n2, boolean bl) {
        int n3 = bl ? 0 : 1;
        switch (n) {
            case 1: {
                this.hasResults.activateRadioBandResult(n2, n3);
                break;
            }
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: {
                this.hasResults.activateAppConnectAudioResult(n2, n3);
                break;
            }
            default: {
                ServiceManager.logger2.warn(16).append("EntertainmentManagerServicesAdapterImpl.respond with context unknown to HAS: ").append(n2).log();
            }
        }
    }

    @Override
    public void updateContext(int n) {
        this.hasProperties.updateEntertainmentContext(EntertainmentManagerServicesAdapterImpl.toHasContext(n));
    }

    private static int toHasContext(int n) {
        switch (n) {
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 5: {
                return 4;
            }
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: {
                return 3;
            }
        }
        ServiceManager.logger2.warn(16).append("updateEntertainmentContext with context unknown to HAS: ").append(n).log();
        return 0;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ EntertainmentManagerResults access$000(EntertainmentManagerServicesAdapterImpl entertainmentManagerServicesAdapterImpl) {
        return entertainmentManagerServicesAdapterImpl.hasResults;
    }
}

