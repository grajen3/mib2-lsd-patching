/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.soundtiles;

import de.vw.mib.app.appadapter.AbstractAppAdapter;
import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.appadapter.soundtiles.SoundTileSAdapter$1;
import de.vw.mib.appadapter.soundtiles.SoundTileSAdapter$2;
import de.vw.mib.asl.api.sound.capabilities.SoundCapabilitiesUpdate;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.cio.CioExecutor;

public class SoundTileSAdapter
extends AbstractAppAdapter
implements SoundCapabilitiesUpdate {
    private static final int TILE_HEADER_BUTTON_ACTION;
    boolean isDynaudioCharacterPresetsAvailable = false;
    static /* synthetic */ Class class$de$vw$mib$asl$api$sound$capabilities$SoundCapabilitiesService;

    public SoundTileSAdapter(AppAdapterSystemServices appAdapterSystemServices) {
        super(appAdapterSystemServices);
        ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().requestAPI(class$de$vw$mib$asl$api$sound$capabilities$SoundCapabilitiesService == null ? (class$de$vw$mib$asl$api$sound$capabilities$SoundCapabilitiesService = SoundTileSAdapter.class$("de.vw.mib.asl.api.sound.capabilities.SoundCapabilitiesService")) : class$de$vw$mib$asl$api$sound$capabilities$SoundCapabilitiesService, new SoundTileSAdapter$1(this));
    }

    @Override
    public CioExecutor getCioExecutor() {
        return new SoundTileSAdapter$2(this);
    }

    @Override
    public ModelApiService[] getModelApiServices() {
        return null;
    }

    @Override
    public void init(int n, String string) {
    }

    @Override
    public void start() {
    }

    @Override
    public void ready() {
    }

    @Override
    public void stop() {
    }

    @Override
    public void onDynaudioCharacterPresetsAvailableChanged(boolean bl) {
        this.isDynaudioCharacterPresetsAvailable = bl;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ AppAdapterSystemServices access$000(SoundTileSAdapter soundTileSAdapter) {
        return soundTileSAdapter.systemServices;
    }

    static /* synthetic */ AppAdapterSystemServices access$100(SoundTileSAdapter soundTileSAdapter) {
        return soundTileSAdapter.systemServices;
    }
}

