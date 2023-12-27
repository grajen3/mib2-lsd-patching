/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.mediatiles.appui.internal;

import de.vw.mib.appui.cio.AbstractCioVisualizationService;
import de.vw.mib.cio.CioIntentVisualizationImpl;
import de.vw.mib.cio.framework.CioIdService;
import de.vw.mib.cio.framework.CioIntentVisualization;
import generated.de.vw.mib.global.datapool.SkinDataPool;

public class MediaTileScioVisualizationService
extends AbstractCioVisualizationService {
    private static final int V_MEDIA_TILE_SACTION__MEDIA_TILE_SHEADER;
    private static final int COUNT;

    public MediaTileScioVisualizationService(String string) {
        super("MediaTileS", string, 1);
    }

    @Override
    protected void loadMapping(CioIdService cioIdService) {
        this.putIndexIdMapping(0, cioIdService, "MediaTileSAction", "MediaTileSHeader");
    }

    @Override
    protected CioIntentVisualization getVisualizationByIndex(int n) {
        switch (n) {
            case 0: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(29)), SkinDataPool.getColorVector(59), SkinDataPool.getColorVector(58), this.getI18nString(1753), null, null);
            }
        }
        return this.visualizationNotAvailable();
    }
}

