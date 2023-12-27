/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal.overlay;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.view.internal.overlay.ImageOverlay;
import de.vw.mib.widgets.internal.ServiceManager;
import java.io.IOException;

public final class Pointer
extends ImageOverlay {
    private static final String POINTER_IMAGE;
    private static final boolean CENTER_POINTER_IMAGE;

    public Pointer(Logger logger, Graphics3D graphics3D) {
        super(logger, graphics3D, "Pointer");
        try {
            BufferImage bufferImage = ServiceManager.imageManager.getImageFromCommonSkin("cursor.png");
            this.setImage(bufferImage);
            this.setCenterImage(false);
        }
        catch (IOException iOException) {
            LogMessage logMessage = this.getLogger().error(16);
            logMessage.append("Unable to load pointer image '");
            logMessage.append("cursor.png");
            logMessage.append("' from common skin: ");
            logMessage.attachThrowable(iOException);
            logMessage.log();
        }
    }
}

