/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.text;

import de.vw.mib.Disposable;
import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.text.TextDrawable;
import de.vw.mib.graphics.effect.Effect;
import de.vw.mib.graphics.effect.image.ImageEffect;
import de.vw.mib.graphics.effect.text.TextEffect;
import de.vw.mib.graphics.font.Font;
import de.vw.mib.graphics.font.Glyph;
import de.vw.mib.graphics.font.GlyphBitmap;
import de.vw.mib.graphics.font.KernedFont;
import de.vw.mib.graphics.font.RasterizableFont;
import de.vw.mib.graphics.font.layout.TextLayout;
import de.vw.mib.graphics.font.spi.layout.GlyphLayout;
import de.vw.mib.graphics.font.spi.layout.TextLineLayout;
import de.vw.mib.graphics.font.style.TextStyle;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.UnsupportedImageFormatException;
import de.vw.mib.graphics.image.UnsupportedImageSizeException;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractSharedDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractSharedDrawableRenderer$AbstractSharedDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.text.TextDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.text.TextDrawableRenderer$DummyGlyphStyle;
import de.vw.mib.graphics.internal.mesh.MeshBuilder;
import de.vw.mib.graphics.internal.mesh.MeshHeap;
import de.vw.mib.graphics.internal.mesh.MeshHeap$SubMesh;
import de.vw.mib.graphics.internal.texture.TextureAtlas;
import de.vw.mib.graphics.internal.texture.TextureAtlas$SubTexture;
import de.vw.mib.graphics.texture.Texture;
import de.vw.mib.graphics.texture.Texture2D;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.ObjectPool;
import de.vw.mib.util.StringBuilder;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

final class TextDrawableRenderer$SharedTextDrawable
extends AbstractSharedDrawableRenderer$AbstractSharedDrawable
implements TextDrawable {
    private static final int GLYPH_SAMPLER;
    private String text;
    private TextLayout textLayout;
    private TextStyle[] textStyles;
    private int intervalStart;
    private int intervalEnd;
    private Font font;
    private int size;
    private int style;
    private static TextDrawableRenderer$DummyGlyphStyle dummyGlyphStyle;

    public TextDrawableRenderer$SharedTextDrawable(AbstractSharedDrawableRenderer abstractSharedDrawableRenderer, ObjectPool objectPool) {
        super(abstractSharedDrawableRenderer, objectPool);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append(",text=").append(this.text);
        stringBuilder.append(",textLayout=").append(this.textLayout);
        stringBuilder.append(",textStyles=").append(this.textStyles);
        stringBuilder.append(",intervalStart=").append(this.intervalStart);
        stringBuilder.append(",intervalEnd=").append(this.intervalEnd);
        stringBuilder.append(",font=").append(this.font);
        stringBuilder.append(",size=").append(this.size);
        stringBuilder.append(",style=").append(this.style);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void dispose() {
        this.text = null;
        if (this.textLayout != null) {
            this.textLayout.dispose();
            this.textLayout = null;
        }
        if (this.textStyles != null) {
            for (int i2 = 0; i2 < this.textStyles.length; ++i2) {
                this.textStyles[i2].dispose();
            }
            this.textStyles = null;
        }
        this.intervalStart = 0;
        this.intervalEnd = 0;
        this.font = null;
        this.size = 0;
        this.style = 0;
        super.dispose();
    }

    @Override
    protected void updateAllocationStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics, boolean bl) {
        drawablePerformanceMetrics.allocatedTexts = drawablePerformanceMetrics.allocatedTexts + (bl ? 1 : -1);
    }

    @Override
    protected Effect createEffect(Graphics3D graphics3D) {
        return graphics3D.getEffectManager().getTextEffect();
    }

    @Override
    public String getText() {
        return this.text;
    }

    @Override
    public void setText(String string) {
        if (this.text == null || !this.text.equals(string)) {
            this.text = string;
            this.invalidateGeometry();
        }
    }

    @Override
    public void setTextLayout(TextLayout textLayout) {
        if (this.textLayout == null || !this.textLayout.equals(textLayout)) {
            if (this.textLayout != null) {
                this.textLayout.dispose();
            }
            textLayout.reference();
            this.textLayout = textLayout;
        }
        this.invalidateGeometry();
    }

    @Override
    public TextLayout getTextLayout() {
        return this.textLayout;
    }

    @Override
    public void setTextStyles(TextStyle[] textStyleArray) {
        if (this.textStyles == null || !Arrays.equals(this.textStyles, textStyleArray)) {
            int n;
            if (this.textStyles != null) {
                for (n = 0; n < this.textStyles.length; ++n) {
                    this.textStyles[n].dispose();
                }
            }
            for (n = 0; n < textStyleArray.length; ++n) {
                textStyleArray[n].reference();
            }
            this.textStyles = textStyleArray;
        }
        this.invalidateGeometry();
    }

    @Override
    public TextStyle[] getTextStyles() {
        return this.textStyles;
    }

    @Override
    public void setIntervalStart(int n) {
        if (this.intervalStart != n) {
            this.intervalStart = n;
            this.invalidateGeometry();
        }
    }

    @Override
    public void setIntervalEnd(int n) {
        if (this.intervalEnd != n) {
            this.intervalEnd = n;
            this.invalidateGeometry();
        }
    }

    @Override
    public Font getFont() {
        return this.font;
    }

    @Override
    public void setFont(Font font) {
        if (this.font == null || !this.font.equals(font)) {
            this.font = font;
            this.invalidateGeometry();
        }
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void setSize(int n) {
        if (this.size != n) {
            this.size = n;
            this.invalidateGeometry();
        }
    }

    @Override
    public int getStyle() {
        return this.style;
    }

    @Override
    public void setStyle(int n) {
        if (this.style != n) {
            this.style = n;
            this.invalidateGeometry();
        }
    }

    @Override
    protected void updateEffect(Effect effect) {
        TextEffect textEffect = (TextEffect)effect;
        this.updateTransformationEffect(textEffect);
        this.updateColorEffect(textEffect);
        this.updateImageEffect(textEffect);
    }

    protected void updateImageEffect(ImageEffect imageEffect) {
        imageEffect.setImageSampler(0);
    }

    @Override
    protected void updateDrawingStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics) {
        ++drawablePerformanceMetrics.drawnTexts;
    }

    @Override
    protected MeshHeap$SubMesh updateMesh(Texture[] textureArray, List list) {
        if (this.getTextLayout() != null) {
            return this.updateTextLayout(textureArray, list);
        }
        return this.updateTextLegacy(textureArray, list);
    }

    private MeshHeap$SubMesh updateTextLegacy(Texture[] textureArray, List list) {
        Logger logger = this.getLogger();
        TextDrawableRenderer textDrawableRenderer = (TextDrawableRenderer)this.getDrawableRenderer();
        MeshHeap meshHeap = textDrawableRenderer.getMeshHeap();
        MeshHeap$SubMesh meshHeap$SubMesh = null;
        try {
            Disposable disposable;
            int n;
            TextureAtlas textureAtlas = textDrawableRenderer.getTextureAtlas();
            int n2 = n = this.text.length() > 1024 ? 1024 : this.text.length();
            if (dummyGlyphStyle == null) {
                dummyGlyphStyle = new TextDrawableRenderer$DummyGlyphStyle();
            }
            dummyGlyphStyle.setFontId(this.font.getFontId());
            dummyGlyphStyle.setFontSize(this.size);
            TextDrawableRenderer$DummyGlyphStyle textDrawableRenderer$DummyGlyphStyle = dummyGlyphStyle;
            hcb.reset();
            hcb.append(false);
            hcb.append(this.text);
            hcb.append(this.font.getName());
            hcb.append(this.size);
            hcb.append(this.style);
            long l = hcb.longHashCode();
            meshHeap$SubMesh = meshHeap.getSubMesh(l);
            if (meshHeap$SubMesh == null) {
                int n3;
                disposable = textDrawableRenderer.getMeshBuilder();
                boolean bl = true;
                int n4 = 0;
                boolean bl2 = false;
                Glyph glyph = null;
                ((MeshBuilder)disposable).beginGeometry(4, 0);
                for (n3 = 0; n3 < n; ++n3) {
                    char c2 = this.text.charAt(n3);
                    Glyph glyph2 = this.font.getGlyph(c2, this.size);
                    GlyphBitmap glyphBitmap = ((RasterizableFont)this.font).getGlyphBitmap(glyph2, textDrawableRenderer$DummyGlyphStyle);
                    BufferImage bufferImage = glyphBitmap.getImage();
                    if (glyph != null) {
                        n4 += ((KernedFont)this.font).getKerning(glyph, c2);
                    }
                    if (bufferImage.getWidth() > 0 && bufferImage.getHeight() > 0) {
                        int n5 = n4 + (glyphBitmap.getLeftOffset() << 6);
                        int n6 = 0 - (glyphBitmap.getTopOffset() << 6);
                        TextureAtlas$SubTexture textureAtlas$SubTexture = textureAtlas.getSubTexture(bufferImage);
                        Texture2D texture2D = textureAtlas$SubTexture.getTexture();
                        Dimension dimension = texture2D.getSize();
                        Rectangle rectangle = textureAtlas$SubTexture.getRectangle();
                        list.add(textureAtlas$SubTexture);
                        int n7 = n5 >> 6;
                        int n8 = n6 >> 6;
                        int n9 = n7 + rectangle.width;
                        int n10 = n8 + rectangle.height;
                        float f2 = ((float)rectangle.x + AbstractSharedDrawableRenderer.TEXEL_CENTER_OFFSET) / (float)dimension.width;
                        float f3 = ((float)rectangle.y + AbstractSharedDrawableRenderer.TEXEL_CENTER_OFFSET) / (float)dimension.height;
                        float f4 = ((float)(rectangle.x + rectangle.width) - AbstractSharedDrawableRenderer.TEXEL_CENTER_OFFSET) / (float)dimension.width;
                        float f5 = ((float)(rectangle.y + rectangle.height) - AbstractSharedDrawableRenderer.TEXEL_CENTER_OFFSET) / (float)dimension.height;
                        ((MeshBuilder)disposable).beginVertex();
                        ((MeshBuilder)disposable).setVertexPosition(n7, n8);
                        ((MeshBuilder)disposable).setVertexTextureCoordinate(0, f2, f3);
                        ((MeshBuilder)disposable).endVertex();
                        ((MeshBuilder)disposable).beginVertex();
                        ((MeshBuilder)disposable).setVertexPosition(n7, n10);
                        ((MeshBuilder)disposable).setVertexTextureCoordinate(0, f2, f5);
                        ((MeshBuilder)disposable).endVertex();
                        ((MeshBuilder)disposable).beginVertex();
                        ((MeshBuilder)disposable).setVertexPosition(n9, n10);
                        ((MeshBuilder)disposable).setVertexTextureCoordinate(0, f4, f5);
                        ((MeshBuilder)disposable).endVertex();
                        ((MeshBuilder)disposable).beginVertex();
                        ((MeshBuilder)disposable).setVertexPosition(n9, n10);
                        ((MeshBuilder)disposable).setVertexTextureCoordinate(0, f4, f5);
                        ((MeshBuilder)disposable).endVertex();
                        ((MeshBuilder)disposable).beginVertex();
                        ((MeshBuilder)disposable).setVertexPosition(n9, n8);
                        ((MeshBuilder)disposable).setVertexTextureCoordinate(0, f4, f3);
                        ((MeshBuilder)disposable).endVertex();
                        ((MeshBuilder)disposable).beginVertex();
                        ((MeshBuilder)disposable).setVertexPosition(n7, n8);
                        ((MeshBuilder)disposable).setVertexTextureCoordinate(0, f2, f3);
                        ((MeshBuilder)disposable).endVertex();
                    }
                    n4 += glyphBitmap.getHorizontalAdvance();
                    glyph = glyph2;
                }
                ((MeshBuilder)disposable).endGeometry();
                if (((MeshBuilder)disposable).getVertexCount() > 0) {
                    n3 = ((MeshBuilder)disposable).getVertexCount();
                    meshHeap$SubMesh = meshHeap.insertSubMesh(l, 4, n3);
                    meshHeap$SubMesh.setVertexData(((MeshBuilder)disposable).getVertexArray());
                }
            } else {
                for (int i2 = 0; i2 < n; ++i2) {
                    char c3 = this.text.charAt(i2);
                    Glyph glyph = this.font.getGlyph(c3, this.size);
                    GlyphBitmap glyphBitmap = ((RasterizableFont)this.font).getGlyphBitmap(glyph, textDrawableRenderer$DummyGlyphStyle);
                    BufferImage bufferImage = glyphBitmap.getImage();
                    if (bufferImage.getWidth() <= 0 || bufferImage.getHeight() <= 0) continue;
                    TextureAtlas$SubTexture textureAtlas$SubTexture = textureAtlas.getSubTexture(bufferImage);
                    list.add(textureAtlas$SubTexture);
                }
            }
            if (!list.isEmpty()) {
                disposable = (TextureAtlas$SubTexture)list.get(0);
                textureArray[0] = ((TextureAtlas$SubTexture)disposable).getTexture();
            }
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            // empty catch block
        }
        return meshHeap$SubMesh;
    }

    private MeshHeap$SubMesh updateTextLayout(Texture[] textureArray, List list) {
        Logger logger = this.getLogger();
        TextDrawableRenderer textDrawableRenderer = (TextDrawableRenderer)this.getDrawableRenderer();
        MeshHeap meshHeap = textDrawableRenderer.getMeshHeap();
        MeshHeap$SubMesh meshHeap$SubMesh = null;
        try {
            Disposable disposable;
            TextureAtlas textureAtlas = textDrawableRenderer.getTextureAtlas();
            boolean bl = this.textLayout.isGlyphIdCharacterCode();
            int n = this.textLayout.getLineCount();
            int n2 = 0;
            if (this.intervalEnd != -129) {
                n2 = Math.min(this.intervalEnd - this.intervalStart + 1, 1024);
            } else {
                for (int i2 = 0; i2 < n && n2 < 1024; ++i2) {
                    n2 = Math.min(n2 + this.textLayout.getTextLine(i2).getGlyphCount(), 1024);
                }
            }
            long l = hcb.reset().append(true).append(this.textLayout.getId()).append(this.intervalStart).append(this.intervalEnd).longHashCode();
            meshHeap$SubMesh = meshHeap.getSubMesh(l);
            if (meshHeap$SubMesh == null) {
                disposable = textDrawableRenderer.getMeshBuilder();
                ((MeshBuilder)disposable).beginGeometry(4, 0);
                int n3 = 0;
                de.vw.mib.graphics.font.spi.style.TextStyle textStyle = null;
                block5: for (int i3 = 0; i3 < n && n3 < 1024; ++i3) {
                    TextLineLayout textLineLayout = this.textLayout.getTextLine(i3);
                    int n4 = textLineLayout.getLeft();
                    int n5 = textLineLayout.getBaseline();
                    int n6 = textLineLayout.getGlyphCount();
                    for (int i4 = 0; i4 < n6; ++i4) {
                        Glyph glyph;
                        GlyphBitmap glyphBitmap;
                        BufferImage bufferImage;
                        int n7;
                        Object object;
                        if (n3 >= 1024) {
                            object = logger.error(512);
                            object.append(super.getClass().getName());
                            object.append(".updateTextLayout() maximum glyph count exceeded (").append(n2).append(">").append(1024).append(")").log();
                            continue block5;
                        }
                        object = textLineLayout.getGlyph(i4);
                        int n8 = object.getGlyphId();
                        if (n8 == -16842752 || (n7 = object.getSourceIndex()) < this.intervalStart || n7 > this.intervalEnd) continue;
                        if (textStyle == null || n7 < textStyle.getStartIndex() || n7 > textStyle.getEndIndex()) {
                            textStyle = this.findTextStyle(n7);
                        }
                        if ((bufferImage = (glyphBitmap = ((RasterizableFont)this.font).getGlyphBitmap(glyph = bl ? this.font.getGlyph((char)n8, textStyle.getGlyphStyle().getFontSize()) : this.font.getGlyph(n8, textStyle.getGlyphStyle().getFontSize()), textStyle.getGlyphStyle())).getImage()).getWidth() <= 0 || bufferImage.getHeight() <= 0) continue;
                        TextureAtlas$SubTexture textureAtlas$SubTexture = textureAtlas.getSubTexture(bufferImage);
                        Texture2D texture2D = textureAtlas$SubTexture.getTexture();
                        Dimension dimension = texture2D.getSize();
                        Rectangle rectangle = textureAtlas$SubTexture.getRectangle();
                        list.add(textureAtlas$SubTexture);
                        ++n3;
                        int n9 = n4 + object.getX() + glyphBitmap.getLeftOffset();
                        int n10 = n5 - glyphBitmap.getTopOffset();
                        int n11 = n9 + rectangle.width;
                        int n12 = n10 + rectangle.height;
                        float f2 = (float)rectangle.x / (float)dimension.width;
                        float f3 = (float)rectangle.y / (float)dimension.height;
                        float f4 = (float)(rectangle.x + rectangle.width) / (float)dimension.width;
                        float f5 = (float)(rectangle.y + rectangle.height) / (float)dimension.height;
                        ((MeshBuilder)disposable).beginVertex();
                        ((MeshBuilder)disposable).setVertexPosition(n9, n10);
                        ((MeshBuilder)disposable).setVertexTextureCoordinate(0, f2, f3);
                        ((MeshBuilder)disposable).endVertex();
                        ((MeshBuilder)disposable).beginVertex();
                        ((MeshBuilder)disposable).setVertexPosition(n9, n12);
                        ((MeshBuilder)disposable).setVertexTextureCoordinate(0, f2, f5);
                        ((MeshBuilder)disposable).endVertex();
                        ((MeshBuilder)disposable).beginVertex();
                        ((MeshBuilder)disposable).setVertexPosition(n11, n12);
                        ((MeshBuilder)disposable).setVertexTextureCoordinate(0, f4, f5);
                        ((MeshBuilder)disposable).endVertex();
                        ((MeshBuilder)disposable).beginVertex();
                        ((MeshBuilder)disposable).setVertexPosition(n11, n12);
                        ((MeshBuilder)disposable).setVertexTextureCoordinate(0, f4, f5);
                        ((MeshBuilder)disposable).endVertex();
                        ((MeshBuilder)disposable).beginVertex();
                        ((MeshBuilder)disposable).setVertexPosition(n11, n10);
                        ((MeshBuilder)disposable).setVertexTextureCoordinate(0, f4, f3);
                        ((MeshBuilder)disposable).endVertex();
                        ((MeshBuilder)disposable).beginVertex();
                        ((MeshBuilder)disposable).setVertexPosition(n9, n10);
                        ((MeshBuilder)disposable).setVertexTextureCoordinate(0, f2, f3);
                        ((MeshBuilder)disposable).endVertex();
                    }
                }
                ((MeshBuilder)disposable).endGeometry();
                if (((MeshBuilder)disposable).getVertexCount() > 0) {
                    n3 = ((MeshBuilder)disposable).getVertexCount();
                    meshHeap$SubMesh = meshHeap.insertSubMesh(l, 4, n3);
                    meshHeap$SubMesh.setVertexData(((MeshBuilder)disposable).getVertexArray());
                }
            } else {
                int n13 = 0;
                for (int i5 = 0; i5 < n && n13 < 1024; ++i5) {
                    TextLineLayout textLineLayout = this.textLayout.getTextLine(i5);
                    int n14 = textLineLayout.getGlyphCount();
                    de.vw.mib.graphics.font.spi.style.TextStyle textStyle = null;
                    for (int i6 = 0; i6 < n14 && n13 < 1024; ++i6) {
                        Glyph glyph;
                        GlyphBitmap glyphBitmap;
                        BufferImage bufferImage;
                        int n15;
                        GlyphLayout glyphLayout = textLineLayout.getGlyph(i6);
                        int n16 = glyphLayout.getGlyphId();
                        if (!bl && n16 == -16842752 || (n15 = glyphLayout.getSourceIndex()) < this.intervalStart || n15 > this.intervalEnd) continue;
                        if (textStyle == null || n15 < textStyle.getStartIndex() || n15 > textStyle.getEndIndex()) {
                            textStyle = this.findTextStyle(n15);
                        }
                        if ((bufferImage = (glyphBitmap = ((RasterizableFont)this.font).getGlyphBitmap(glyph = bl ? this.font.getGlyph((char)n16, textStyle.getGlyphStyle().getFontSize()) : this.font.getGlyph(n16, textStyle.getGlyphStyle().getFontSize()), textStyle.getGlyphStyle())).getImage()).getWidth() <= 0 || bufferImage.getHeight() <= 0) continue;
                        TextureAtlas$SubTexture textureAtlas$SubTexture = textureAtlas.getSubTexture(bufferImage);
                        list.add(textureAtlas$SubTexture);
                        ++n13;
                    }
                }
            }
            if (!list.isEmpty()) {
                disposable = (TextureAtlas$SubTexture)list.get(0);
                textureArray[0] = ((TextureAtlas$SubTexture)disposable).getTexture();
            }
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            LogMessage logMessage = logger.trace(16);
            logMessage.append(super.getClass().getName()).append(new StringBuffer().append(": Error while creating the geometry for Text-Layout: ").append(this.textLayout).toString());
            logMessage.attachThrowable(unsupportedEncodingException);
            logMessage.log();
        }
        catch (UnsupportedImageSizeException unsupportedImageSizeException) {
            LogMessage logMessage = logger.error(512);
            logMessage.append(super.getClass().getName());
            logMessage.append(".update() image size too large: ").append(unsupportedImageSizeException.getWidth()).append("x").append(unsupportedImageSizeException.getHeight()).log();
        }
        catch (UnsupportedImageFormatException unsupportedImageFormatException) {
            LogMessage logMessage = logger.error(512);
            logMessage.append(super.getClass().getName());
            logMessage.append(".update() invalid image format: ").append(unsupportedImageFormatException.getFormat()).log();
        }
        return meshHeap$SubMesh;
    }

    private TextStyle findTextStyle(int n) {
        for (int i2 = 0; i2 < this.textStyles.length; ++i2) {
            if (n < this.textStyles[i2].getStartIndex() || n > this.textStyles[i2].getEndIndex()) continue;
            return this.textStyles[i2];
        }
        return this.textStyles[0];
    }
}

