/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal.overlay;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.drawable.shape.RectangleDrawable;
import de.vw.mib.graphics.drawable.text.TextDrawable;
import de.vw.mib.graphics.font.Font;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.view.internal.overlay.AbstractOverlay;
import de.vw.mib.widgets.internal.ServiceManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextOverlay
extends AbstractOverlay {
    protected static final int TEXT_OVERLAY_FONT_SIZE;
    protected static final int TEXT_OVERLAY_FONT_STYLE;
    private final Color4f foregroundColor;
    private final Color4f backgroundColor;
    private RectangleDrawable backgroundDrawable;
    private final List textLines;
    private boolean textDrawablesValid;
    private List textDrawables;
    private List textPositions;

    public TextOverlay(Logger logger, Graphics3D graphics3D, String string, Dimension dimension, Color4f color4f, Color4f color4f2) {
        super(logger, graphics3D, string);
        this.setSize(dimension);
        this.foregroundColor = (Color4f)color4f.clone();
        this.backgroundColor = (Color4f)color4f2.clone();
        this.textLines = new ArrayList();
    }

    @Override
    public void dispose() {
        if (this.backgroundDrawable != null) {
            this.backgroundDrawable.dispose();
            this.backgroundDrawable = null;
        }
        if (this.textDrawables != null) {
            for (int i2 = this.textDrawables.size() - 1; i2 >= 0; --i2) {
                TextDrawable textDrawable = (TextDrawable)this.textDrawables.get(i2);
                textDrawable.dispose();
            }
            this.textDrawables.clear();
            this.textDrawables = null;
        }
        super.dispose();
    }

    public final Color4f getForegroundColor() {
        return this.foregroundColor;
    }

    public final void setForegroundColor(Color4f color4f) {
        this.foregroundColor.set(color4f);
    }

    public final Color4f getBackgroundColor() {
        return this.backgroundColor;
    }

    public final void setBackgroundColor(Color4f color4f) {
        this.backgroundColor.set(color4f);
    }

    public final Font getFont() {
        try {
            return ServiceManager.fontManager.getDefaultFont();
        }
        catch (IOException iOException) {
            LogMessage logMessage = this.getLogger().error(16);
            logMessage.append("Unable to load default font: ");
            logMessage.attachThrowable(iOException);
            logMessage.log();
            throw iOException;
        }
    }

    public final int getFontSize() {
        return 14;
    }

    public List getTextLines() {
        return this.textLines;
    }

    public void setTextLines(List list) {
        if (!((Object)this.textLines).equals(list)) {
            this.textLines.clear();
            this.textLines.addAll(list);
            this.textDrawablesValid = false;
        }
    }

    @Override
    public void draw() {
        Point point;
        Graphics3D graphics3D = this.getGraphics3D();
        if (this.backgroundColor != null && !this.backgroundColor.isFullyTransparent()) {
            if (this.backgroundDrawable == null) {
                this.backgroundDrawable = graphics3D.getDrawableManager().createRectangleDrawable();
                this.backgroundDrawable.set(this.getRectangle());
            }
            if (this.backgroundDrawable != null) {
                this.backgroundDrawable.setColor(this.backgroundColor);
                this.backgroundDrawable.draw();
            }
        }
        if (!this.textDrawablesValid) {
            if (this.textDrawables == null) {
                this.textDrawables = new ArrayList(this.textLines.size());
                this.textPositions = new ArrayList(this.textLines.size());
            }
            try {
                Font font = this.getFont();
                int n = font.getHeight(14) >> 6;
                point = new Point(this.getX() + 2, this.getY() + 2 + 14);
                for (int i2 = 0; i2 < this.textLines.size(); ++i2) {
                    String string = (String)this.textLines.get(i2);
                    int n2 = point.x;
                    int n3 = point.y + i2 * n;
                    if (string.length() > 0 && string.charAt(0) == '\t') {
                        string = string.substring(1, string.length());
                        n2 += 10;
                    }
                    TextDrawable textDrawable = null;
                    Point point2 = null;
                    if (i2 < this.textDrawables.size()) {
                        textDrawable = (TextDrawable)this.textDrawables.get(i2);
                        point2 = (Point)this.textPositions.get(i2);
                    } else {
                        textDrawable = graphics3D.getDrawableManager().createTextDrawable();
                        textDrawable.setFont(font);
                        textDrawable.setSize(14);
                        textDrawable.setStyle(0);
                        this.textDrawables.add(textDrawable);
                        point2 = new Point();
                        this.textPositions.add(point2);
                    }
                    textDrawable.setText(string);
                    point2.setLocation(n2, n3);
                }
                this.textDrawablesValid = true;
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
        if (this.textDrawablesValid) {
            for (int i3 = 0; i3 < this.textLines.size(); ++i3) {
                TextDrawable textDrawable = (TextDrawable)this.textDrawables.get(i3);
                point = (Point)this.textPositions.get(i3);
                textDrawable.setColor(this.foregroundColor);
                textDrawable.draw(point.x, point.y);
            }
        }
    }
}

