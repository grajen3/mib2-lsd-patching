/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.pictureviewer.appui.internal;

import de.vw.mib.appui.cio.AbstractCioVisualizationService;
import de.vw.mib.cio.CioIntentVisualizationImpl;
import de.vw.mib.cio.framework.CioIdService;
import de.vw.mib.cio.framework.CioIntentVisualization;
import generated.de.vw.mib.global.datapool.SkinDataPool;

public class PictureViewerCioVisualizationService
extends AbstractCioVisualizationService {
    private static final int V_MENU_ACTION__VISUALIZATION_PICTURE_VIEWER_BUTTON;
    private static final int V_MENU_ACTION__VISUALIZATION_PICTURE_VIEWER_FAV_BUTTON;
    private static final int COUNT;

    public PictureViewerCioVisualizationService(String string) {
        super("PictureViewer", string, 2);
    }

    @Override
    protected void loadMapping(CioIdService cioIdService) {
        this.putIndexIdMapping(0, cioIdService, "MenuAction", "VisualizationPictureViewerButton");
        this.putIndexIdMapping(1, cioIdService, "MenuAction", "VisualizationPictureViewerFavButton");
    }

    @Override
    protected CioIntentVisualization getVisualizationByIndex(int n) {
        switch (n) {
            case 0: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(38)), SkinDataPool.getColorVector(77), SkinDataPool.getColorVector(76), this.getI18nString(5433), null, null);
            }
            case 1: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(39)), SkinDataPool.getColorVector(79), SkinDataPool.getColorVector(78), this.getI18nString(5433), null, null);
            }
        }
        return this.visualizationNotAvailable();
    }
}

