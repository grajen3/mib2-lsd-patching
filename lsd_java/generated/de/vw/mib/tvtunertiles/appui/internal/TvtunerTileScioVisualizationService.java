/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.tvtunertiles.appui.internal;

import de.vw.mib.appui.cio.AbstractCioVisualizationService;
import de.vw.mib.cio.CioIntentVisualizationImpl;
import de.vw.mib.cio.framework.CioIdService;
import de.vw.mib.cio.framework.CioIntentVisualization;
import generated.de.vw.mib.global.datapool.SkinDataPool;

public class TvtunerTileScioVisualizationService
extends AbstractCioVisualizationService {
    private static final int V_TVTUNER_TILE_SACTION__TVTUNER_TILE_SHEADER;
    private static final int COUNT;

    public TvtunerTileScioVisualizationService(String string) {
        super("TVTunerTileS", string, 1);
    }

    @Override
    protected void loadMapping(CioIdService cioIdService) {
        this.putIndexIdMapping(0, cioIdService, "TVTunerTileSAction", "TVTunerTileSHeader");
    }

    @Override
    protected CioIntentVisualization getVisualizationByIndex(int n) {
        switch (n) {
            case 0: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(58)), SkinDataPool.getColorVector(117), SkinDataPool.getColorVector(116), this.getI18nString(1768), null, null);
            }
        }
        return this.visualizationNotAvailable();
    }
}

