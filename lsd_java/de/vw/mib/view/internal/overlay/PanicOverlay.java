/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal.overlay;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.view.internal.overlay.TextOverlay;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public final class PanicOverlay
extends TextOverlay {
    private static final Color4f PANIC_TEXT_COLOR = Color4f.WHITE;
    private final List lines = new ArrayList();
    private String message;

    public PanicOverlay(Logger logger, Graphics3D graphics3D, Dimension dimension, Color4f color4f) {
        super(logger, graphics3D, "Panic", dimension, PANIC_TEXT_COLOR, color4f);
    }

    @Override
    public void dispose() {
        this.lines.clear();
        this.message = null;
        super.dispose();
    }

    public void draw(String string) {
        if (this.message == null || !this.message.equals(string)) {
            this.lines.clear();
            StringTokenizer stringTokenizer = new StringTokenizer(string, "\n\r");
            this.lines.add("*** Fatal HMI Error ***");
            while (stringTokenizer.hasMoreTokens()) {
                this.lines.add(stringTokenizer.nextToken());
            }
            this.message = string;
        }
        this.setTextLines(this.lines);
        super.draw();
    }
}

