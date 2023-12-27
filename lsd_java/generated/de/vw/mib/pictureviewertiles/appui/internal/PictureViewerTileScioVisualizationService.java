/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.pictureviewertiles.appui.internal;

import de.vw.mib.appui.cio.AbstractCioVisualizationService;
import de.vw.mib.cio.CioIntentVisualizationImpl;
import de.vw.mib.cio.framework.CioIdService;
import de.vw.mib.cio.framework.CioIntentVisualization;
import generated.de.vw.mib.global.datapool.SkinDataPool;

public class PictureViewerTileScioVisualizationService
extends AbstractCioVisualizationService {
    private static final int V_CREATE_HOSTED_APP__PICTURE_VIEWER_TILE_SBACK;
    private static final int V_PICTURE_VIEWER_TILE_SHEADER_BUTTON_ACTION__PICTURE_VIEWER_TILE_SHEADER;
    private static final int COUNT;

    public PictureViewerTileScioVisualizationService(String string) {
        super("PictureViewerTileS", string, 2);
    }

    @Override
    protected void loadMapping(CioIdService cioIdService) {
        this.putIndexIdMapping(0, cioIdService, "CreateHostedApp", "PictureViewerTileSBack");
        this.putIndexIdMapping(1, cioIdService, "PictureViewerTileSHeaderButtonAction", "PictureViewerTileSHeader");
    }

    @Override
    protected CioIntentVisualization getVisualizationByIndex(int n) {
        switch (n) {
            case 0: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(17)), SkinDataPool.getColorVector(35), SkinDataPool.getColorVector(34), this.getI18nString(1767), null, null);
            }
            case 1: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(53)), SkinDataPool.getColorVector(107), SkinDataPool.getColorVector(106), this.getI18nString(1767), null, null);
            }
        }
        return this.visualizationNotAvailable();
    }
}

