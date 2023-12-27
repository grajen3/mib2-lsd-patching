/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.audiotiles.appui.internal;

import de.vw.mib.appui.cio.AbstractCioVisualizationService;
import de.vw.mib.cio.CioIntentVisualizationImpl;
import de.vw.mib.cio.framework.CioIdService;
import de.vw.mib.cio.framework.CioIntentVisualization;
import generated.de.vw.mib.global.datapool.SkinDataPool;

public class AudioTileScioVisualizationService
extends AbstractCioVisualizationService {
    private static final int V_CREATE_AUDIO_TILE_S__AUDIO_TILE_SBACK;
    private static final int COUNT;

    public AudioTileScioVisualizationService(String string) {
        super("AudioTileS", string, 1);
    }

    @Override
    protected void loadMapping(CioIdService cioIdService) {
        this.putIndexIdMapping(0, cioIdService, "CreateAudioTileS", "AudioTileSBack");
    }

    @Override
    protected CioIntentVisualization getVisualizationByIndex(int n) {
        switch (n) {
            case 0: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(8)), SkinDataPool.getColorVector(17), SkinDataPool.getColorVector(16), this.getI18nString(1752), null, null);
            }
        }
        return this.visualizationNotAvailable();
    }
}

