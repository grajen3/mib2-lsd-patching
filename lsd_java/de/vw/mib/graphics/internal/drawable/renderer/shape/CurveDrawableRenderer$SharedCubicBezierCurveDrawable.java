/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.shape;

import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.shape.CubicBezierCurveDrawable;
import de.vw.mib.graphics.effect.Effect;
import de.vw.mib.graphics.effect.image.ImageEffect;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.internal.InsufficientSpaceException;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractSharedDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.image.AbstractImageDrawableRenderer$AbstractSharedImageDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.shape.CurveDrawableRenderer;
import de.vw.mib.graphics.internal.mesh.MeshBuilder;
import de.vw.mib.graphics.internal.mesh.MeshHeap;
import de.vw.mib.graphics.internal.mesh.MeshHeap$SubMesh;
import de.vw.mib.graphics.internal.texture.TextureAtlas$SubTexture;
import de.vw.mib.graphics.math.algebra.Vector2f;
import de.vw.mib.graphics.math.function.curve.bezier.CubicBezierCurve2f;
import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.graphics.texture.Texture;
import de.vw.mib.graphics.texture.Texture2D;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.ObjectPool;
import de.vw.mib.util.StringBuilder;
import java.util.ArrayList;
import java.util.List;

final class CurveDrawableRenderer$SharedCubicBezierCurveDrawable
extends AbstractImageDrawableRenderer$AbstractSharedImageDrawable
implements CubicBezierCurveDrawable {
    private static final int CURVE_POINTS_LIST_INITIAL_CAPACITY;
    private static List curvePoints;
    private final Rectangle bounds;
    private final Point2f p0;
    private final Point2f p1;
    private final Point2f p2;
    private final Point2f p3;
    private float strokeWidth;

    public CurveDrawableRenderer$SharedCubicBezierCurveDrawable(AbstractSharedDrawableRenderer abstractSharedDrawableRenderer, ObjectPool objectPool) {
        super(abstractSharedDrawableRenderer, objectPool);
        if (curvePoints == null) {
            curvePoints = new ArrayList(100);
        }
        this.bounds = new Rectangle();
        this.p0 = new Point2f();
        this.p1 = new Point2f();
        this.p2 = new Point2f();
        this.p3 = new Point2f();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append(",bounds=").append(this.bounds);
        stringBuilder.append(",p0=").append(this.p0);
        stringBuilder.append(",p1=").append(this.p1);
        stringBuilder.append(",p2=").append(this.p2);
        stringBuilder.append(",p3=").append(this.p3);
        stringBuilder.append(",strokeWidth=").append(this.strokeWidth);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void getBounds(Rectangle rectangle) {
        rectangle.setBounds(this.bounds);
    }

    @Override
    public void setBounds(Rectangle rectangle) {
        if (!this.bounds.equals(rectangle)) {
            this.bounds.setBounds(rectangle);
            this.invalidateGeometry();
        }
    }

    @Override
    public void dispose() {
        this.bounds.setBounds(0, 0, 0, 0);
        this.p0.setZero();
        this.p1.setZero();
        this.p2.setZero();
        this.p3.setZero();
        this.strokeWidth = 0.0f;
        super.dispose();
    }

    @Override
    protected void updateAllocationStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics, boolean bl) {
        drawablePerformanceMetrics.allocatedCubicBezierCurves = drawablePerformanceMetrics.allocatedCubicBezierCurves + (bl ? 1 : -1);
    }

    @Override
    protected Effect createEffect(Graphics3D graphics3D) {
        return graphics3D.getEffectManager().getImageEffect();
    }

    @Override
    public void getP0(Point2f point2f) {
        point2f.set(this.p0);
    }

    @Override
    public void setP0(Point2f point2f) {
        if (!this.p0.equals(point2f)) {
            this.p0.set(point2f);
            this.invalidateGeometry();
        }
    }

    @Override
    public void getP1(Point2f point2f) {
        point2f.set(this.p1);
    }

    @Override
    public void setP1(Point2f point2f) {
        if (!this.p1.equals(point2f)) {
            this.p1.set(point2f);
            this.invalidateGeometry();
        }
    }

    @Override
    public void getP2(Point2f point2f) {
        point2f.set(this.p2);
    }

    @Override
    public void setP2(Point2f point2f) {
        if (!this.p2.equals(point2f)) {
            this.p2.set(point2f);
            this.invalidateGeometry();
        }
    }

    @Override
    public void getP3(Point2f point2f) {
        point2f.set(this.p3);
    }

    @Override
    public void setP3(Point2f point2f) {
        if (!this.p3.equals(point2f)) {
            this.p3.set(point2f);
            this.invalidateGeometry();
        }
    }

    @Override
    public float getStrokeWidth() {
        return this.strokeWidth;
    }

    @Override
    public void setStrokeWidth(float f2) {
        if (this.strokeWidth != f2) {
            this.strokeWidth = f2;
            this.invalidateGeometry();
        }
    }

    @Override
    protected void updateEffect(Effect effect) {
        ImageEffect imageEffect = (ImageEffect)effect;
        this.updateTransformationEffect(imageEffect);
        this.updateColorEffect(imageEffect);
        this.updateImageEffect(imageEffect);
    }

    @Override
    protected void updateDrawingStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics) {
        ++drawablePerformanceMetrics.drawnCubicBezierCurves;
    }

    @Override
    protected MeshHeap$SubMesh updateMesh(Texture[] textureArray, List list) {
        long l;
        Logger logger = this.getLogger();
        CurveDrawableRenderer curveDrawableRenderer = (CurveDrawableRenderer)this.getDrawableRenderer();
        BufferImage bufferImage = this.getImage();
        TextureAtlas$SubTexture textureAtlas$SubTexture = bufferImage != null ? curveDrawableRenderer.getTextureAtlas().getSubTexture(bufferImage, this.hasFiltering()) : null;
        MeshHeap meshHeap = curveDrawableRenderer.getMeshHeap();
        MeshHeap$SubMesh meshHeap$SubMesh = meshHeap.getSubMesh(l = CurveDrawableRenderer$SharedCubicBezierCurveDrawable.calculateMeshKey(this.bounds, this.p0, this.p1, this.p2, this.p3, this.strokeWidth, textureAtlas$SubTexture));
        if (meshHeap$SubMesh == null) {
            MeshBuilder meshBuilder = curveDrawableRenderer.getMeshBuilder();
            float f2 = 0.0f;
            float f3 = 0.0f;
            float f4 = 0.0f;
            float f5 = 0.0f;
            if (textureAtlas$SubTexture != null) {
                Texture2D texture2D = textureAtlas$SubTexture.getTexture();
                Dimension dimension = texture2D.getSize();
                Rectangle rectangle = textureAtlas$SubTexture.getRectangle();
                f2 = ((float)rectangle.x + (float)rectangle.width / 2.0f + AbstractSharedDrawableRenderer.TEXEL_CENTER_OFFSET) / (float)dimension.width;
                f3 = ((float)rectangle.y + AbstractSharedDrawableRenderer.TEXEL_CENTER_OFFSET) / (float)dimension.height;
                f4 = ((float)rectangle.x + (float)rectangle.width / 2.0f - AbstractSharedDrawableRenderer.TEXEL_CENTER_OFFSET) / (float)dimension.width;
                f5 = ((float)(rectangle.y + rectangle.height) - AbstractSharedDrawableRenderer.TEXEL_CENTER_OFFSET) / (float)dimension.height;
            }
            curvePoints.clear();
            int n = 10;
            float f6 = 1.0f;
            CubicBezierCurve2f.subdivide(this.bounds, this.p0.x, this.p0.y, this.p1.x, this.p1.y, this.p2.x, this.p2.y, this.p3.x, this.p3.y, 10, 1.0f, curvePoints);
            int n2 = curvePoints.size();
            if (n2 < 2) {
                return null;
            }
            if (n2 > meshBuilder.getMaxVertices()) {
                throw new InsufficientSpaceException(n2, meshBuilder.getVertexSize());
            }
            meshBuilder.beginGeometry(5, 0);
            Vector2f vector2f = new Vector2f();
            Vector2f vector2f2 = new Vector2f();
            Point2f point2f = new Point2f();
            Point2f point2f2 = new Point2f();
            float f7 = this.strokeWidth / 2.0f;
            for (int i2 = 0; i2 < n2; i2 += 2) {
                Point2f point2f3 = (Point2f)curvePoints.get(i2 + 0);
                Point2f point2f4 = (Point2f)curvePoints.get(i2 + 1);
                if (f7 > 63) {
                    if (i2 == 0) {
                        this.p1.sub(this.p0, vector2f);
                    } else {
                        point2f4.sub(point2f3, vector2f);
                    }
                    vector2f.normalize();
                    vector2f2.set(-vector2f.y, vector2f.x);
                    vector2f2.scaleAdd(f7, point2f3, point2f);
                    vector2f2.set(vector2f.y, -vector2f.x);
                    vector2f2.scaleAdd(f7, point2f3, point2f2);
                } else {
                    point2f.set(point2f3);
                    point2f2.set(point2f3);
                }
                meshBuilder.beginVertex();
                meshBuilder.setVertexPosition(point2f.x, point2f.y);
                meshBuilder.setVertexTextureCoordinate(0, f2, f3);
                meshBuilder.endVertex();
                meshBuilder.beginVertex();
                meshBuilder.setVertexPosition(point2f2.x, point2f2.y);
                meshBuilder.setVertexTextureCoordinate(0, f4, f5);
                meshBuilder.endVertex();
                if (i2 + 2 < n2 || !(f7 > 63)) continue;
                this.p3.sub(this.p2, vector2f);
                vector2f.normalize();
                vector2f2.set(-vector2f.y, vector2f.x);
                vector2f2.scaleAdd(f7, point2f4, point2f);
                vector2f2.set(vector2f.y, -vector2f.x);
                vector2f2.scaleAdd(f7, point2f4, point2f2);
                meshBuilder.beginVertex();
                meshBuilder.setVertexPosition(point2f.x, point2f.y);
                meshBuilder.setVertexTextureCoordinate(0, f2, f3);
                meshBuilder.endVertex();
                meshBuilder.beginVertex();
                meshBuilder.setVertexPosition(point2f2.x, point2f2.y);
                meshBuilder.setVertexTextureCoordinate(0, f4, f5);
                meshBuilder.endVertex();
            }
            meshBuilder.endGeometry();
            int n3 = meshBuilder.getVertexCount();
            meshHeap$SubMesh = meshHeap.insertSubMesh(l, 5, n3);
            meshHeap$SubMesh.setVertexData(meshBuilder.getVertexArray());
        }
        if (textureAtlas$SubTexture != null) {
            textureArray[0] = textureAtlas$SubTexture.getTexture();
            list.add(textureAtlas$SubTexture);
        }
        return meshHeap$SubMesh;
    }

    protected static long calculateMeshKey(Rectangle rectangle, Point2f point2f, Point2f point2f2, Point2f point2f3, Point2f point2f4, float f2, TextureAtlas$SubTexture textureAtlas$SubTexture) {
        hcb.reset();
        hcb.append(rectangle);
        hcb.append(point2f);
        hcb.append(point2f2);
        hcb.append(point2f3);
        hcb.append(point2f4);
        hcb.append(f2);
        hcb.append(textureAtlas$SubTexture.getId());
        return hcb.longHashCode();
    }
}

