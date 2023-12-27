/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.tunertiles.appui.internal;

import de.vw.mib.appui.cio.AbstractCioVisualizationService;
import de.vw.mib.cio.CioIntentVisualizationImpl;
import de.vw.mib.cio.framework.CioIdService;
import de.vw.mib.cio.framework.CioIntentVisualization;
import generated.de.vw.mib.global.datapool.SkinDataPool;

public class TunerTileScioVisualizationService
extends AbstractCioVisualizationService {
    private static final int V_TUNER_TILE_SACTION__TUNER_TILE_SHEADER;
    private static final int COUNT;

    public TunerTileScioVisualizationService(String string) {
        super("TunerTileS", string, 1);
    }

    @Override
    protected void loadMapping(CioIdService cioIdService) {
        this.putIndexIdMapping(0, cioIdService, "TunerTileSAction", "TunerTileSHeader");
    }

    @Override
    protected CioIntentVisualization getVisualizationByIndex(int n) {
        switch (n) {
            case 0: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(57)), SkinDataPool.getColorVector(115), SkinDataPool.getColorVector(114), this.getI18nString(1769), null, null);
            }
        }
        return this.visualizationNotAvailable();
    }
}

