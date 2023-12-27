/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.tvtunertiles.listener;

import de.vw.mib.appadapter.tvtunertiles.listener.TVTunerTileSListener;
import de.vw.mib.asl.api.tvtuner.tile.TVTunerTileService;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentAPICallbackAdapter;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import generated.de.vw.mib.appadapter.tvtunertiles.TVTunerModelApiCallback;
import generated.de.vw.mib.appadapter.tvtunertiles.TVTunerModelApiService;

public class TVTunerTileSComponentHandler
extends ASLComponentAPICallbackAdapter
implements TVTunerModelApiService {
    private TVTunerTileService tileService;
    private TVTunerTileSListener tileListener;
    private TVTunerModelApiCallback modelCallback;
    private boolean listenerRegistered;
    static /* synthetic */ Class class$de$vw$mib$asl$api$tvtuner$tile$TVTunerTileService;

    public TVTunerTileSComponentHandler(TVTunerModelApiCallback tVTunerModelApiCallback) {
        this.modelCallback = tVTunerModelApiCallback;
        TVTunerTileService tVTunerTileService = (TVTunerTileService)ServiceManager.componentRegistry.getAPIInstance(class$de$vw$mib$asl$api$tvtuner$tile$TVTunerTileService == null ? (class$de$vw$mib$asl$api$tvtuner$tile$TVTunerTileService = TVTunerTileSComponentHandler.class$("de.vw.mib.asl.api.tvtuner.tile.TVTunerTileService")) : class$de$vw$mib$asl$api$tvtuner$tile$TVTunerTileService);
        if (tVTunerTileService == null) {
            ServiceManager.componentRegistry.requestAPI(class$de$vw$mib$asl$api$tvtuner$tile$TVTunerTileService == null ? (class$de$vw$mib$asl$api$tvtuner$tile$TVTunerTileService = TVTunerTileSComponentHandler.class$("de.vw.mib.asl.api.tvtuner.tile.TVTunerTileService")) : class$de$vw$mib$asl$api$tvtuner$tile$TVTunerTileService, this);
        } else {
            this.tileService = tVTunerTileService;
            if (this.tileListener == null) {
                this.tileListener = new TVTunerTileSListener(tVTunerModelApiCallback);
            }
        }
        this.listenerRegistered = false;
    }

    @Override
    public void registered(Class clazz, Object object) {
        if (clazz.equals(class$de$vw$mib$asl$api$tvtuner$tile$TVTunerTileService == null ? (class$de$vw$mib$asl$api$tvtuner$tile$TVTunerTileService = TVTunerTileSComponentHandler.class$("de.vw.mib.asl.api.tvtuner.tile.TVTunerTileService")) : class$de$vw$mib$asl$api$tvtuner$tile$TVTunerTileService)) {
            this.tileService = (TVTunerTileService)object;
            if (this.tileListener == null) {
                this.tileListener = new TVTunerTileSListener(this.modelCallback);
            }
            if (!this.listenerRegistered) {
                this.registerListener();
            }
        }
    }

    public void registerListener() {
        if (this.tileService == null) {
            this.listenerRegistered = false;
        } else {
            this.tileService.registerListener(this.tileListener);
            this.listenerRegistered = true;
        }
    }

    @Override
    public void _mda_setActiveSource(int n) {
        this.tileService.requestActiveSource(n);
    }

    @Override
    public void _mda_setNextStation() {
        this.tileService.requestNextStation();
    }

    @Override
    public void _mda_setPreviousStation() {
        this.tileService.requestPreviousStation();
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

