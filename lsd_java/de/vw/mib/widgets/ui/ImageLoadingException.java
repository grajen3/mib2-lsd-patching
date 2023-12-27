/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.widgets.WidgetException;
import java.io.IOException;

public class ImageLoadingException
extends WidgetException {
    private static final long serialVersionUID;
    private final String imageDescriptor;

    public ImageLoadingException(IOException iOException, String string) {
        super(iOException);
        this.imageDescriptor = string;
    }

    public String getImageDescriptor() {
        return this.imageDescriptor;
    }
}

