/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.services;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.internal.mediacontrol.common.commands.CommandQueue;
import de.vw.mib.asl.internal.mediacontrol.components.browser.Browser;
import de.vw.mib.asl.internal.mediacontrol.components.player.Player;
import de.vw.mib.asl.internal.mediacontrol.services.Components;
import de.vw.mib.asl.internal.mediacontrol.services.MediaControlAPIImpl;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public class MediaControlServiceProvider
extends AbstractASLTarget {
    public static final int ASL_PLAYER_AVAILABLE;
    public static final int ASL_PLAYER_AVAILABLE_P0_COMPONENT_OBJECT;
    public static final int ASL_BROWSER_AVAILABLE;
    public static final int ASL_BROWSER_AVAILABLE_P0_COMPONENT_OBJECT;
    Components mComponents = new Components();
    static /* synthetic */ Class class$de$vw$mib$asl$api$mediacontrol$services$MediaControlAPI;

    public MediaControlServiceProvider(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return 318905088;
    }

    @Override
    public int getClassifier() {
        return 8;
    }

    @Override
    public int getSubClassifier() {
        return 8;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                break;
            }
            case 107: {
                break;
            }
            case 100001: {
                this.mComponents.setPlayer((Player)eventGeneric.getObject(0));
                if (this.isTraceEnabled()) {
                    this.trace("PLAYER AVAILABLE");
                }
                this.registerMediaControlService();
                break;
            }
            case 100002: {
                this.mComponents.setBrowser((Browser)eventGeneric.getObject(0));
                if (this.isTraceEnabled()) {
                    this.trace("BROWSER AVAILABLE");
                }
                this.registerMediaControlService();
                break;
            }
        }
    }

    private void registerMediaControlService() {
        if (this.mComponents.getPlayer() != null && this.mComponents.getBrowser() != null) {
            CommandQueue commandQueue = new CommandQueue();
            MediaControlAPIImpl mediaControlAPIImpl = new MediaControlAPIImpl(commandQueue, this.mComponents);
            ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().registerAPI(class$de$vw$mib$asl$api$mediacontrol$services$MediaControlAPI == null ? (class$de$vw$mib$asl$api$mediacontrol$services$MediaControlAPI = MediaControlServiceProvider.class$("de.vw.mib.asl.api.mediacontrol.services.MediaControlAPI")) : class$de$vw$mib$asl$api$mediacontrol$services$MediaControlAPI, mediaControlAPIImpl);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

