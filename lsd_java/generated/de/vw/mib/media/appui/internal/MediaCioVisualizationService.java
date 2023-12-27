/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.media.appui.internal;

import de.vw.mib.appui.cio.AbstractCioVisualizationService;
import de.vw.mib.cio.CioIntentVisualizationImpl;
import de.vw.mib.cio.framework.CioIdService;
import de.vw.mib.cio.framework.CioIntentVisualization;
import generated.de.vw.mib.global.datapool.SkinDataPool;

public class MediaCioVisualizationService
extends AbstractCioVisualizationService {
    private static final int V_MENU_ACTION__VISUALIZATION_MEDIA_BUTTON;
    private static final int V_MENU_ACTION__VISUALIZATION_MEDIA_FAV_BUTTON;
    private static final int COUNT;

    public MediaCioVisualizationService(String string) {
        super("Media", string, 2);
    }

    @Override
    protected void loadMapping(CioIdService cioIdService) {
        this.putIndexIdMapping(0, cioIdService, "MenuAction", "VisualizationMediaButton");
        this.putIndexIdMapping(1, cioIdService, "MenuAction", "VisualizationMediaFavButton");
    }

    @Override
    protected CioIntentVisualization getVisualizationByIndex(int n) {
        switch (n) {
            case 0: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(34)), SkinDataPool.getColorVector(69), SkinDataPool.getColorVector(68), this.getI18nString(2476), null, null);
            }
            case 1: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(35)), SkinDataPool.getColorVector(71), SkinDataPool.getColorVector(70), this.getI18nString(2476), null, null);
            }
        }
        return this.visualizationNotAvailable();
    }
}

