/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.image;

import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.image.ScaleImageDrawable;
import de.vw.mib.graphics.effect.Effect;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.ScaleImage;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractSharedDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.image.CompositeImageDrawableRenderer$SharedCompositeImageDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.image.ScaleImageDrawableRenderer;
import de.vw.mib.graphics.internal.mesh.MeshBuilder;
import de.vw.mib.graphics.internal.mesh.MeshHeap;
import de.vw.mib.graphics.internal.mesh.MeshHeap$SubMesh;
import de.vw.mib.graphics.internal.texture.TextureAtlas;
import de.vw.mib.graphics.internal.texture.TextureAtlas$SubTexture;
import de.vw.mib.graphics.math.Transform;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.texture.Texture;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.ObjectPool;
import de.vw.mib.util.StringBuilder;
import java.util.List;

public class ScaleImageDrawableRenderer$SharedScaleImageDrawable
extends CompositeImageDrawableRenderer$SharedCompositeImageDrawable
implements ScaleImageDrawable {
    private ScaleImage scaleImage;
    private int width;
    private int height;
    private Transform viewTransform;

    public ScaleImageDrawableRenderer$SharedScaleImageDrawable(AbstractSharedDrawableRenderer abstractSharedDrawableRenderer, ObjectPool objectPool) {
        super(abstractSharedDrawableRenderer, objectPool);
    }

    protected ScaleImageDrawableRenderer$SharedScaleImageDrawable(AbstractSharedDrawableRenderer abstractSharedDrawableRenderer, ObjectPool objectPool, boolean bl) {
        super(abstractSharedDrawableRenderer, objectPool, bl);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append(",scaleImage=").append(this.scaleImage);
        stringBuilder.append(",width=").append(this.width);
        stringBuilder.append(",height=").append(this.height);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void dispose() {
        this.scaleImage = null;
        this.width = 0;
        this.height = 0;
        this.viewTransform = null;
        super.dispose();
    }

    @Override
    protected void updateAllocationStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics, boolean bl) {
        drawablePerformanceMetrics.allocatedScaleImages = drawablePerformanceMetrics.allocatedScaleImages + (bl ? 1 : -1);
    }

    @Override
    public ScaleImage getScaleImage() {
        return this.scaleImage;
    }

    @Override
    public void setScaleImage(ScaleImage scaleImage) {
        if (this.scaleImage == null || !this.scaleImage.equals(scaleImage)) {
            this.scaleImage = scaleImage;
            this.invalidateGeometry();
        }
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public void setWidth(int n) {
        if (this.width != n) {
            this.width = n;
            this.invalidateGeometry();
        }
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public void setHeight(int n) {
        if (this.height != n) {
            this.height = n;
            this.invalidateGeometry();
        }
    }

    @Override
    public void draw() {
        if (this.scaleImage == null || this.scaleImage.isEmpty()) {
            return;
        }
        if (this.scaleImage.getScaleMode() == 5) {
            Graphics3D graphics3D = this.getGraphics3D();
            if (this.viewTransform == null) {
                this.viewTransform = new Transform();
            }
            graphics3D.getViewTransformation(this.viewTransform);
            this.setSourceX(Math.min(this.getImage().getWidth(), Math.round(this.viewTransform.getTranslation().x) + this.getScaleImage().getInsets().left));
            super.draw();
        } else if (this.scaleImage.getScaleMode() == 0) {
            Graphics3D graphics3D = this.getGraphics3D();
            graphics3D.pushMatrix(0);
            int n = (this.getWidth() >> 1) - (this.getImage().getWidth() >> 1);
            int n2 = (this.getHeight() >> 1) - (this.getImage().getHeight() >> 1);
            graphics3D.translateMatrix(0, n, n2, 0.0f);
            super.draw();
            graphics3D.popMatrix(0);
        } else {
            super.draw();
        }
    }

    @Override
    protected void updateEffect(Effect effect) {
        super.updateEffect(effect);
    }

    @Override
    protected void updateDrawingStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics) {
        ++drawablePerformanceMetrics.drawnScaleImages;
    }

    @Override
    protected MeshHeap$SubMesh updateMesh(Texture[] textureArray, List list) {
        MeshHeap$SubMesh meshHeap$SubMesh = null;
        if (this.width > 0 && this.height > 0) {
            BufferImage[] bufferImageArray = this.getImages();
            switch (this.scaleImage.getScaleMode()) {
                case 0: {
                    this.setSourceX(0);
                    this.setSourceY(0);
                    this.setSourceWidth(bufferImageArray[0].getWidth());
                    this.setSourceHeight(bufferImageArray[0].getHeight());
                    this.setDestinationX(0);
                    this.setDestinationY(0);
                    this.setDestinationWidth(bufferImageArray[0].getWidth());
                    this.setDestinationHeight(bufferImageArray[0].getHeight());
                    meshHeap$SubMesh = super.updateMesh(textureArray, list);
                    break;
                }
                case 1: {
                    this.setSourceX(0);
                    this.setSourceY(0);
                    this.setSourceWidth(bufferImageArray[0].getWidth());
                    this.setSourceHeight(bufferImageArray[0].getHeight());
                    this.setDestinationX(0);
                    this.setDestinationY(0);
                    this.setDestinationWidth(this.width);
                    this.setDestinationHeight(this.height);
                    meshHeap$SubMesh = super.updateMesh(textureArray, list);
                    break;
                }
                case 2: 
                case 3: {
                    meshHeap$SubMesh = this.updateScaleModeRepeatOrStretch(textureArray, list, bufferImageArray);
                    break;
                }
                case 4: 
                case 5: {
                    Insets insets = this.scaleImage.getInsets();
                    int n = Util.clamp(bufferImageArray[0].getWidth() - this.getSourceX(), 0, this.width - insets.left - insets.right);
                    int n2 = Util.clamp(bufferImageArray[0].getHeight() - this.getSourceY(), 0, this.height - insets.top - insets.bottom);
                    this.setSourceWidth(n);
                    this.setSourceHeight(n2);
                    this.setDestinationX(insets.left);
                    this.setDestinationY(insets.top);
                    this.setDestinationWidth(n);
                    this.setDestinationHeight(n2);
                    meshHeap$SubMesh = super.updateMesh(textureArray, list);
                    break;
                }
                case 6: {
                    Insets insets = this.scaleImage.getInsets();
                    int n = bufferImageArray[0].getWidth();
                    int n3 = bufferImageArray[0].getHeight();
                    int n4 = Util.clamp(this.width - insets.left - insets.right, 0, n);
                    int n5 = Util.clamp(this.height - insets.top - insets.bottom, 0, n3);
                    this.setSourceX(n - n4);
                    this.setSourceY(n3 - n5);
                    this.setSourceWidth(n4);
                    this.setSourceHeight(n5);
                    this.setDestinationX(insets.left);
                    this.setDestinationY(insets.top);
                    this.setDestinationWidth(n4);
                    this.setDestinationHeight(n5);
                    meshHeap$SubMesh = super.updateMesh(textureArray, list);
                    break;
                }
                default: {
                    throw new IllegalStateException("Invalid scale mode");
                }
            }
        }
        return meshHeap$SubMesh;
    }

    private MeshHeap$SubMesh updateScaleModeRepeatOrStretch(Texture[] textureArray, List list, BufferImage[] bufferImageArray) {
        long l;
        Logger logger = this.getLogger();
        ScaleImageDrawableRenderer scaleImageDrawableRenderer = (ScaleImageDrawableRenderer)this.getDrawableRenderer();
        int n = bufferImageArray[0].getWidth();
        int n2 = bufferImageArray[0].getHeight();
        int n3 = 0;
        while (++n3 < bufferImageArray.length && bufferImageArray[n3] != null && n == bufferImageArray[n3].getWidth() && n2 == bufferImageArray[n3].getHeight()) {
        }
        TextureAtlas textureAtlas = scaleImageDrawableRenderer.getTextureAtlas();
        boolean bl = this.hasFiltering();
        TextureAtlas$SubTexture[] textureAtlas$SubTextureArray = new TextureAtlas$SubTexture[n3];
        for (int i2 = 0; i2 < textureAtlas$SubTextureArray.length; ++i2) {
            textureAtlas$SubTextureArray[i2] = textureAtlas.getSubTexture(bufferImageArray[i2], bl);
        }
        MeshHeap meshHeap = scaleImageDrawableRenderer.getMeshHeap();
        MeshHeap$SubMesh meshHeap$SubMesh = meshHeap.getSubMesh(l = ScaleImageDrawableRenderer$SharedScaleImageDrawable.calculateMeshKey(textureAtlas$SubTextureArray, 0, 0, n, n2, 0, 0, this.width, this.height, this.scaleImage));
        if (meshHeap$SubMesh == null) {
            int n4;
            int n5;
            int n6;
            boolean bl2;
            int n7;
            boolean bl3;
            LogMessage logMessage;
            int n8;
            Texture[] textureArray2 = new Texture[n3];
            Dimension[] dimensionArray = new Dimension[n3];
            Rectangle[] rectangleArray = new Rectangle[n3];
            for (int i3 = 0; i3 < textureAtlas$SubTextureArray.length; ++i3) {
                textureArray2[i3] = textureAtlas$SubTextureArray[i3].getTexture();
                dimensionArray[i3] = textureArray2[i3].getSize();
                rectangleArray[i3] = textureAtlas$SubTextureArray[i3].getRectangle();
            }
            MeshBuilder meshBuilder = scaleImageDrawableRenderer.getMeshBuilder();
            Insets insets = this.scaleImage.getInsets();
            if (insets.left < 0 || insets.right < 0 || insets.top < 0 || insets.bottom < 0) {
                LogMessage logMessage2 = logger.error(512);
                logMessage2.append(super.getClass().getName());
                logMessage2.append(".update() image(s) ");
                for (n8 = 0; n8 < bufferImageArray.length; ++n8) {
                    logMessage2.append("[").append(n8).append("]").append(bufferImageArray[0]).append(n8 == bufferImageArray.length - 1 ? "" : ", ");
                }
                logMessage2.append(": insets ").append(insets);
                logMessage2.append(" negative - clamping to zero").log();
            }
            int n9 = Math.max(0, insets.left);
            n8 = Math.max(0, insets.right);
            int n10 = Math.max(0, insets.top);
            int n11 = Math.max(0, insets.bottom);
            if (n < n9 + n8) {
                logMessage = logger.error(512);
                logMessage.append(super.getClass().getName());
                logMessage.append(".update() image ").append(bufferImageArray[0]).append(": imageWidth ").append(n);
                logMessage.append(" < insets ").append(insets).append(" - clamping insets to zero").log();
                n9 = 0;
                n8 = 0;
            }
            if (n2 < n10 + n11) {
                logMessage = logger.error(512);
                logMessage.append(super.getClass().getName());
                logMessage.append(".update() image ").append(bufferImageArray[0]).append(": imageHeight ").append(n2);
                logMessage.append(" < insets ").append(insets).append(" - clamping insets to zero").log();
                n10 = 0;
                n11 = 0;
            }
            int n12 = n9 + n8;
            int n13 = n10 + n11;
            int n14 = Math.max(this.width, n12);
            int n15 = Math.max(this.height, n13);
            int n16 = n - n12;
            int n17 = n2 - n13;
            int n18 = n14 - n12;
            int n19 = n15 - n13;
            this.setSourceX(0);
            this.setSourceY(0);
            this.setSourceWidth(n16);
            this.setSourceHeight(n17);
            this.setDestinationX(0);
            this.setDestinationY(0);
            this.setDestinationWidth(n18);
            this.setDestinationHeight(n19);
            boolean bl4 = bl3 = this.scaleImage.getScaleMode() == 3;
            int n20 = bl3 && n16 > 0 ? (n18 > n16 ? (n18 + n16 - 1) / n16 * 2 : 2) : (n7 = 0);
            int n21 = bl3 && n17 > 0 ? (n19 > n17 ? (n19 + n17 - 1) / n17 * 2 : 2) : 0;
            int n22 = n16 > 0 ? n18 % n16 : n18;
            int n23 = n17 > 0 ? n19 % n17 : n18;
            int n24 = 2 + n7 + (n9 > 0 ? 1 : 0) + (n8 > 0 ? 1 : 0);
            int n25 = 2 + n21 + (n10 > 0 ? 1 : 0) + (n11 > 0 ? 1 : 0);
            int n26 = n24 * n25;
            int n27 = (n25 - 1) * (2 + 2 * n24);
            int n28 = 5;
            meshHeap$SubMesh = meshHeap.insertSubMesh(l, 5, n26, n27);
            boolean bl5 = bl2 = logger.isTraceEnabled(512) && logger.isTraceEnabled(64);
            if (bl2) {
                LogMessage logMessage3 = logger.trace(512);
                logMessage3.append(super.getClass().getName());
                logMessage3.append(".update() updated scaleImage=").append(this.scaleImage);
                for (n6 = 0; n6 < bufferImageArray.length; ++n6) {
                    logMessage3.append(" image").append("[").append(n6).append("]").append(bufferImageArray[n6]);
                }
                logMessage3.append(" dimension=").append(n14).append("x").append(n15).append(" insets=").append(n12).append(",").append(n13).append(" vertexCount=").append(n26).append(" indexCount=").append(n27).append(" col/rows=").append(n24).append("x").append(n25).append(" repeatCol/Rows=").append(n7).append("x").append(n21).append(" source=").append(n16).append("x").append(n17).append(" dest=").append(n18).append("x").append(n19).append(" last=").append(n22).append("x").append(n23).log();
            }
            meshBuilder.beginGeometry(5, meshHeap$SubMesh.getMinVertex(), meshHeap$SubMesh.getStartIndex());
            int n29 = this.getSourceY();
            n6 = this.getDestinationY();
            int n30 = 1;
            int n31 = 0;
            for (n5 = 0; n5 < n25; ++n5) {
                int n32;
                n4 = this.getSourceX();
                int n33 = this.getDestinationX();
                if (n5 == 0) {
                    n29 = 0;
                    n6 = 0;
                } else if (n5 == 1 && n10 > 0) {
                    n29 += n10;
                    n6 += n10;
                } else if (n5 == n25 - 1 && n11 > 0) {
                    n29 += n11;
                    n6 += n11;
                } else if (bl3) {
                    if (n11 > 0 && n5 == n25 - 2) {
                        n29 = n10 + n17;
                        n6 = n10 + n19;
                    } else {
                        n32 = n30 % 2 == 0 ? (n6 - n10 + n17 <= n19 ? n17 : n23) : 0;
                        n29 = n10 + n32;
                        n6 += n32;
                    }
                    ++n30;
                } else {
                    n29 += n17;
                    n6 += n19;
                }
                n32 = 1;
                for (int i4 = 0; i4 < n24; ++i4) {
                    if (i4 == 0) {
                        n4 = 0;
                        n33 = 0;
                        if (bl2 && n5 == 0) {
                            LogMessage logMessage4 = logger.trace(512);
                            logMessage4.append("#").append(n31).append(" INITIAL ").append(i4).append(",").append(n5).append(" source=").append(n4).append(",").append(n29).append(" dest=").append(n33).append(",").append(n6).log();
                        }
                    } else if (i4 == 1 && n9 > 0) {
                        n4 += n9;
                        n33 += n9;
                        if (bl2 && n5 == 0) {
                            LogMessage logMessage5 = logger.trace(512);
                            logMessage5.append("#").append(n31).append(" LEFT ").append(i4).append(",").append(n5).append(" source=").append(n4).append(",").append(n29).append(" dest=").append(n33).append(",").append(n6).log();
                        }
                    } else if (i4 == n24 - 1 && n8 > 0) {
                        n4 += n8;
                        n33 += n8;
                        if (bl2 && n5 == 0) {
                            LogMessage logMessage6 = logger.trace(512);
                            logMessage6.append("#").append(n31).append(" RIGHT ").append(i4).append(",").append(n5).append(" source=").append(n4).append(",").append(n29).append(" dest=").append(n33).append(",").append(n6).log();
                        }
                    } else if (bl3) {
                        if (n8 > 0 && i4 == n24 - 2) {
                            n4 = n9 + n16;
                            n33 = n9 + n18;
                            if (bl2 && n5 == 0) {
                                LogMessage logMessage7 = logger.trace(512);
                                logMessage7.append("#").append(n31).append(" REPEAT ").append(i4).append(",").append(n5).append(" source=").append(n4).append(",").append(n29).append(" dest=").append(n33).append(",").append(n6).append(" repeatColumn=").append(n32).log();
                            }
                        } else {
                            int n34 = n32 % 2 == 0 ? (n33 - n9 + n16 <= n18 ? n16 : n22) : 0;
                            n4 = n9 + n34;
                            n33 += n34;
                            if (bl2 && n5 == 0) {
                                LogMessage logMessage8 = logger.trace(512);
                                logMessage8.append("#").append(n31).append(" REPEAT ").append(i4).append(",").append(n5).append(" source=").append(n4).append(",").append(n29).append(" dest=").append(n33).append(",").append(n6).append(" repeatColumn=").append(n32).append(" stepX=").append(n34).log();
                            }
                        }
                        ++n32;
                    } else {
                        n4 += n16;
                        n33 += n18;
                        if (bl2 && n5 == 0) {
                            LogMessage logMessage9 = logger.trace(512);
                            logMessage9.append("#").append(n31).append(" STRETCH ").append(i4).append(",").append(n5).append(" source=").append(n4).append(",").append(n29).append(" dest=").append(n33).append(",").append(n6).log();
                        }
                    }
                    ++n31;
                    float f2 = n33;
                    float f3 = n6;
                    float f4 = (float)(rectangleArray[0].x + n4) / (float)dimensionArray[0].width;
                    float f5 = (float)(rectangleArray[0].y + n29) / (float)dimensionArray[0].height;
                    meshBuilder.beginVertex();
                    meshBuilder.setVertexPosition(f2, f3);
                    meshBuilder.setVertexTextureCoordinate(0, f4, f5);
                    if (this.enableGenericTexcoords) {
                        meshBuilder.setVertexTextureCoordinate(1, (float)n33 / (float)n14, (float)n6 / (float)n15);
                    } else if (n3 > 1) {
                        float f6 = (float)(rectangleArray[1].x + n4) / (float)dimensionArray[1].width;
                        float f7 = (float)(rectangleArray[1].y + n29) / (float)dimensionArray[1].height;
                        meshBuilder.setVertexTextureCoordinate(1, f6, f7);
                    }
                    meshBuilder.endVertex();
                }
            }
            for (n5 = 0; n5 < n25 - 1; ++n5) {
                meshBuilder.addIndex((short)(n5 * n24));
                for (n4 = 0; n4 < n24; ++n4) {
                    meshBuilder.addIndex((short)(n5 * n24 + n4));
                    meshBuilder.addIndex((short)((n5 + 1) * n24 + n4));
                }
                meshBuilder.addIndex((short)((n5 + 1) * n24 + (n24 - 1)));
            }
            meshBuilder.endGeometry();
            meshHeap$SubMesh.setVertexData(meshBuilder.getVertexArray());
            meshHeap$SubMesh.setIndexData(meshBuilder.getIndexArray());
        }
        for (int i5 = 0; i5 < textureAtlas$SubTextureArray.length; ++i5) {
            textureArray[i5] = textureAtlas$SubTextureArray[i5].getTexture();
            list.add(textureAtlas$SubTextureArray[i5]);
        }
        return meshHeap$SubMesh;
    }
}

