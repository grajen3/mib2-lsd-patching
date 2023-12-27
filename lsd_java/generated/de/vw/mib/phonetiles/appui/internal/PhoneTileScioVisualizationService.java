/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.phonetiles.appui.internal;

import de.vw.mib.appui.cio.AbstractCioVisualizationService;
import de.vw.mib.cio.CioIntentVisualizationImpl;
import de.vw.mib.cio.framework.CioIdService;
import de.vw.mib.cio.framework.CioIntentVisualization;
import generated.de.vw.mib.global.datapool.SkinDataPool;

public class PhoneTileScioVisualizationService
extends AbstractCioVisualizationService {
    private static final int V_CREATE_HOSTED_APP__PHONE_TILE_SAPP;
    private static final int V_PHONE_TILE_SHEADER_BUTTON_ACTION__PHONE_TILE_SHEADER;
    private static final int COUNT;

    public PhoneTileScioVisualizationService(String string) {
        super("PhoneTileS", string, 2);
    }

    @Override
    protected void loadMapping(CioIdService cioIdService) {
        this.putIndexIdMapping(0, cioIdService, "CreateHostedApp", "PhoneTileSApp");
        this.putIndexIdMapping(1, cioIdService, "PhoneTileSHeaderButtonAction", "PhoneTileSHeader");
    }

    @Override
    protected CioIntentVisualization getVisualizationByIndex(int n) {
        switch (n) {
            case 0: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(16)), SkinDataPool.getColorVector(33), SkinDataPool.getColorVector(32), this.getI18nString(1766), null, null);
            }
            case 1: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(52)), SkinDataPool.getColorVector(105), SkinDataPool.getColorVector(104), this.getI18nString(1766), null, null);
            }
        }
        return this.visualizationNotAvailable();
    }
}

