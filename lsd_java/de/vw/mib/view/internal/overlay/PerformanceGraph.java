/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal.overlay;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.shape.PolyLineDrawable;
import de.vw.mib.graphics.drawable.text.TextDrawable;
import de.vw.mib.graphics.font.Font;
import de.vw.mib.graphics.font.spi.style.GlyphStyle;
import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.view.internal.overlay.AbstractOverlay;
import de.vw.mib.widgets.internal.ServiceManager;
import java.io.UnsupportedEncodingException;

public final class PerformanceGraph
extends AbstractOverlay {
    private static final int GRAPH_LINE_WIDTH;
    private final Rectangle rect;
    private final Color4f color;
    private final Color4f textColor;
    private final Font font;
    private final int fontSize;
    private final int numSamples;
    private final int[] samples;
    private int currentSampleIndex;
    private int currentSum;
    private int currentMinimum;
    private int currentMaximum;
    private Point2f[] points;
    private PolyLineDrawable lineDrawable;
    private TextDrawable nameTextDrawable;
    private TextDrawable minimumTextDrawable;
    private TextDrawable maximumTextDrawable;
    private TextDrawable averageTextDrawable;
    private de.vw.mib.graphics.font.style.GlyphStyle glyphStyle;
    private Point2f minimumTextPos;
    private Point2f maximumTextPos;
    private Point2f averageTextPos;
    private Point2f nameTextPos;

    public PerformanceGraph(Logger logger, Graphics3D graphics3D, String string, Rectangle rectangle, Color4f color4f, Color4f color4f2, Font font, int n, int n2) {
        super(logger, graphics3D, string);
        this.rect = rectangle;
        this.color = color4f;
        this.textColor = color4f2;
        this.font = font;
        this.fontSize = n;
        this.numSamples = n2;
        this.samples = new int[n2];
        this.currentSampleIndex = 0;
        this.currentSum = 0;
        this.currentMinimum = -129;
        this.currentMaximum = 128;
        this.points = new Point2f[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            this.points[i2] = new Point2f();
        }
        this.minimumTextDrawable = graphics3D.getDrawableManager().createTextDrawable();
        this.minimumTextDrawable.setColor(color4f2);
        this.minimumTextDrawable.setFont(this.font);
        this.minimumTextDrawable.setSize(this.fontSize);
        this.minimumTextDrawable.setStyle(0);
        this.minimumTextDrawable.setText(Integer.toString(0));
        this.maximumTextDrawable = graphics3D.getDrawableManager().createTextDrawable();
        this.maximumTextDrawable.setColor(color4f2);
        this.maximumTextDrawable.setFont(this.font);
        this.maximumTextDrawable.setSize(this.fontSize);
        this.maximumTextDrawable.setStyle(0);
        this.maximumTextDrawable.setText(Integer.toString(0));
        this.averageTextDrawable = graphics3D.getDrawableManager().createTextDrawable();
        this.averageTextDrawable.setColor(color4f2);
        this.averageTextDrawable.setFont(this.font);
        this.averageTextDrawable.setSize(this.fontSize);
        this.averageTextDrawable.setStyle(0);
        this.averageTextDrawable.setText(Integer.toString(0));
        this.nameTextDrawable = graphics3D.getDrawableManager().createTextDrawable();
        this.nameTextDrawable.setColor(color4f2);
        this.nameTextDrawable.setFont(this.font);
        this.nameTextDrawable.setSize(this.fontSize);
        this.nameTextDrawable.setStyle(0);
        this.nameTextDrawable.setText(string);
        this.minimumTextPos = new Point2f();
        this.maximumTextPos = new Point2f();
        this.averageTextPos = new Point2f();
        this.nameTextPos = new Point2f();
        this.glyphStyle = ServiceManager.textLayoutManager.createGlyphStyle(font.getFontId(), this.fontSize, 0);
        this.update();
    }

    @Override
    public void dispose() {
        if (this.lineDrawable != null) {
            this.lineDrawable.dispose();
            this.lineDrawable = null;
        }
        if (this.nameTextDrawable != null) {
            this.nameTextDrawable.dispose();
            this.nameTextDrawable = null;
        }
        if (this.minimumTextDrawable != null) {
            this.minimumTextDrawable.dispose();
            this.minimumTextDrawable = null;
        }
        if (this.maximumTextDrawable != null) {
            this.maximumTextDrawable.dispose();
            this.maximumTextDrawable = null;
        }
        if (this.averageTextDrawable != null) {
            this.averageTextDrawable.dispose();
            this.averageTextDrawable = null;
        }
        if (this.glyphStyle != null) {
            this.glyphStyle.dispose();
            this.glyphStyle = null;
        }
        super.dispose();
    }

    public void addSample(int n) {
        int n2 = this.samples[this.currentSampleIndex];
        if (n2 == this.currentMinimum) {
            this.currentMinimum = -129;
        }
        if (n2 == this.currentMaximum) {
            this.currentMaximum = 128;
        }
        this.currentSum -= n2;
        this.currentSum += n;
        if (n < this.currentMinimum) {
            this.currentMinimum = n;
        } else if (n > this.currentMaximum) {
            this.currentMaximum = n;
        }
        this.samples[this.currentSampleIndex] = n;
        ++this.currentSampleIndex;
        this.currentSampleIndex %= this.numSamples;
    }

    public void update() {
        int n;
        Graphics3D graphics3D = this.getGraphics3D();
        float f2 = this.rect.x;
        float f3 = this.rect.y + this.rect.height;
        float f4 = (float)this.rect.width / (float)this.numSamples;
        float f5 = this.rect.height;
        float f6 = this.currentMaximum > 0 ? (float)this.currentMaximum / f5 : 1.0f;
        boolean bl = false;
        boolean bl2 = false;
        for (n = this.numSamples - 1; n >= 0; --n) {
            int n2 = this.samples[(this.currentSampleIndex + n) % this.numSamples];
            float f7 = f2 + (float)n * f4;
            float f8 = f3 - (float)n2 / f6;
            this.points[n].set(f7, f8);
            if (!bl && n2 == this.currentMinimum) {
                this.minimumTextPos.set(f7, f8);
                this.minimumTextDrawable.setText(Integer.toString(n2));
                bl = true;
            }
            if (bl2 || n2 != this.currentMaximum) continue;
            this.maximumTextPos.set(f7, f8);
            this.maximumTextDrawable.setText(Integer.toString(n2));
            bl2 = true;
        }
        if (this.lineDrawable == null) {
            this.lineDrawable = graphics3D.getDrawableManager().createPolyLineDrawable();
            this.lineDrawable.setColor(this.color);
            this.lineDrawable.setStrokeWidth(2.0f);
        }
        this.lineDrawable.setCoordinates2D(this.points);
        n = this.currentSum / this.numSamples;
        this.nameTextPos.set(f2, f3 - (float)n / f6);
        try {
            String string = Integer.toString(n);
            int n3 = this.font.getBoundingBox((String)string, (GlyphStyle)this.glyphStyle).width >> 6;
            if (this.averageTextDrawable == null) {
                this.averageTextDrawable = graphics3D.getDrawableManager().createTextDrawable();
                this.averageTextDrawable.setColor(this.textColor);
                this.averageTextDrawable.setFont(this.font);
                this.averageTextDrawable.setSize(this.fontSize);
                this.averageTextDrawable.setStyle(0);
            }
            this.averageTextDrawable.setText(string);
            this.averageTextPos.set((float)this.rect.x + (float)this.rect.width - (float)n3, f3 - (float)n / f6);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            // empty catch block
        }
    }

    @Override
    public void draw() {
        this.lineDrawable.draw();
        this.nameTextDrawable.draw(this.nameTextPos.x, this.nameTextPos.y);
        this.minimumTextDrawable.draw(this.minimumTextPos.x, this.minimumTextPos.y);
        this.maximumTextDrawable.draw(this.maximumTextPos.x, this.maximumTextPos.y);
        this.averageTextDrawable.draw(this.averageTextPos.x, this.averageTextPos.y);
    }
}

