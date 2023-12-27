/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.dsi.ext.api.picturehandling;

import de.vw.mib.asl.framework.internal.framework.dsi.ext.api.ComplexAnalyzer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturehandling.DSIPictureHandlingListener;

public final class DSIPictureHandlingComplexAnalyzer
extends ComplexAnalyzer
implements DSIPictureHandlingListener {
    private static final String REQUEST_RICTURES_M_N;
    private int requestPicturesMid = this.getServiceMethodId(class$org$dsi$ifc$picturehandling$DSIPictureHandling == null ? (class$org$dsi$ifc$picturehandling$DSIPictureHandling = DSIPictureHandlingComplexAnalyzer.class$("org.dsi.ifc.picturehandling.DSIPictureHandling")) : class$org$dsi$ifc$picturehandling$DSIPictureHandling, "requestPictures");
    private boolean finishPictureRequest = false;
    static /* synthetic */ Class class$org$dsi$ifc$picturehandling$DSIPictureHandling;

    private void analyze() {
        if (this.analyzedServiceMethodId == this.requestPicturesMid && this.finishPictureRequest) {
            this.finishPictureRequest = false;
            this.finished = true;
        }
    }

    @Override
    public void finishPictureRequest(int n) {
        this.finishPictureRequest = true;
        this.analyze();
    }

    @Override
    public void indicatePicture(int n, int n2, ResourceLocator resourceLocator, ResourceLocator resourceLocator2) {
    }

    @Override
    public void asyncException(int n, String string, int n2) {
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

