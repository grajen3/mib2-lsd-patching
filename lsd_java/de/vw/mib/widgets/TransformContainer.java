/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.animations.KeyframeAnimation;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.algebra.Matrix3f;
import de.vw.mib.properties.values.LayoutAttribs;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.AbstractWidget$PublicPropertyAnimation;
import de.vw.mib.widgets.Container;
import de.vw.mib.widgets.TransformContainer$1;
import de.vw.mib.widgets.TransformContainer$2;
import de.vw.mib.widgets.TransformContainer$3;
import de.vw.mib.widgets.TransformContainer$4;
import de.vw.mib.widgets.TransformContainer$5;
import de.vw.mib.widgets.TransformContainer$6;
import de.vw.mib.widgets.TransformContainer$7;
import de.vw.mib.widgets.TransformContainer$8;
import de.vw.mib.widgets.models.TransformContainerModel;
import de.vw.mib.widgets.models.ViewModel;

public class TransformContainer
extends Container
implements TransformContainerModel {
    int z;
    private int depth;
    float rotationX;
    float rotationY;
    float rotationZ;
    private float pivotX;
    private float pivotY;
    private float pivotZ;
    float scalingX;
    float scalingY;
    float scalingZ;
    private float projectionNear;
    private float projectionFar;
    private float projectionFOV;
    private float alphaImageRotation;
    private int projectionType;
    private int decoration;
    private float projectionDistance;
    private AbstractWidget$PublicPropertyAnimation translateZAnimation;
    private AbstractWidget$PublicPropertyAnimation rotationXAnimation;
    private AbstractWidget$PublicPropertyAnimation rotationYAnimation;
    private AbstractWidget$PublicPropertyAnimation rotationZAnimation;
    private AbstractWidget$PublicPropertyAnimation scalingXAnimation;
    private AbstractWidget$PublicPropertyAnimation scalingYAnimation;
    private AbstractWidget$PublicPropertyAnimation scalingZAnimation;
    private AbstractWidget$PublicPropertyAnimation alphaImageRotationAnimation;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$TransformContainerUI;

    @Override
    protected void reset() {
        super.reset();
        this.scalingXAnimation = null;
        this.scalingYAnimation = null;
        this.scalingZAnimation = null;
        this.rotationXAnimation = null;
        this.rotationYAnimation = null;
        this.rotationZAnimation = null;
        this.translateZAnimation = null;
    }

    public void init(boolean bl, int n, Image image, boolean bl2, float f2, boolean bl3, int n2, int n3, EasingParams[] easingParamsArray, boolean bl4, int n4, KeyframeAnimation[] keyframeAnimationArray, boolean bl5, LayoutAttribs layoutAttribs, String string, float f3, float f4, float f5, float f6, float f7, float f8, int n5, int n6, Image image2, int n7, boolean bl6, float f9, float f10, float f11, float f12, float f13, float f14, int n8, Insets insets, boolean bl7, int n9, int n10, int n11, int n12) {
        super.init(bl, n, image, bl2, bl3, easingParamsArray, bl4, n4, keyframeAnimationArray, bl5, layoutAttribs, string, n6, image2, n7, bl6, n8, insets, bl7, n9, n10, n11);
        this.z = n12;
        this.depth = n3;
        this.decoration = n2;
        this.rotationX = f9;
        this.rotationY = f10;
        this.rotationZ = f11;
        this.pivotX = f3;
        this.pivotY = f4;
        this.pivotZ = f5;
        this.scalingX = f12;
        this.scalingY = f13;
        this.scalingZ = f14;
        this.projectionNear = f8;
        this.projectionFar = f6;
        this.projectionFOV = f7;
        this.projectionType = n5;
        this.alphaImageRotation = f2;
    }

    public void init(boolean bl, int n, Image image, boolean bl2, boolean bl3, int n2, int n3, EasingParams[] easingParamsArray, boolean bl4, int n4, KeyframeAnimation[] keyframeAnimationArray, boolean bl5, LayoutAttribs layoutAttribs, String string, float f2, float f3, float f4, float f5, float f6, float f7, int n5, int n6, Image image2, int n7, boolean bl6, float f8, float f9, float f10, float f11, float f12, float f13, int n8, Insets insets, boolean bl7, int n9, int n10, int n11, int n12) {
        this.init(bl, n, image, bl2, 0.0f, bl3, n2, n3, easingParamsArray, bl4, n4, keyframeAnimationArray, bl5, layoutAttribs, string, f2, f3, f4, f5, f6, f7, n5, n6, image2, n7, bl6, f8, f9, f10, f11, f12, f13, n8, insets, bl7, n9, n10, n11, n12);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        this.updateProjectionDistance();
    }

    @Override
    public void deInit() {
        this.scalingXAnimation = null;
        this.scalingYAnimation = null;
        this.scalingZAnimation = null;
        this.rotationXAnimation = null;
        this.rotationYAnimation = null;
        this.rotationZAnimation = null;
        this.translateZAnimation = null;
        super.deInit();
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$TransformContainerUI == null ? (class$de$vw$mib$widgets$ui$TransformContainerUI = TransformContainer.class$("de.vw.mib.widgets.ui.TransformContainerUI")) : class$de$vw$mib$widgets$ui$TransformContainerUI};
    }

    @Override
    public final int get_z() {
        return this.z;
    }

    @Override
    public final void set_z(int n) {
        int n2 = this.z;
        if (!this.startTranslateZAnimation(n) && n != n2) {
            this.z = n;
            this.zChanged(n2);
            this.propertyChanged(23);
        }
    }

    @Override
    public final int get_depth() {
        return this.depth;
    }

    @Override
    public final void set_depth(int n) {
        int n2 = this.depth;
        if (n2 != n) {
            this.depth = n;
            this.depthChanged(n2);
            this.propertyChanged(24);
        }
    }

    @Override
    public final float get_rotationX() {
        return this.rotationX;
    }

    @Override
    public final void set_rotationX(float f2) {
        float f3 = this.rotationX;
        if (!this.startRotationXAnimation(f2) && f2 != f3) {
            this.rotationX = f2;
            this.rotationXChanged(f3);
            this.propertyChanged(25);
        }
    }

    @Override
    public final float get_rotationY() {
        return this.rotationY;
    }

    @Override
    public final void set_rotationY(float f2) {
        float f3 = this.rotationY;
        if (!this.startRotationYAnimation(f2) && f2 != f3) {
            this.rotationY = f2;
            this.rotationYChanged(f3);
            this.propertyChanged(26);
        }
    }

    @Override
    public final float get_rotationZ() {
        return this.rotationZ;
    }

    @Override
    public final void set_rotationZ(float f2) {
        float f3 = this.rotationZ;
        if (!this.startRotationZAnimation(f2) && f2 != f3) {
            this.rotationZ = f2;
            this.rotationZChanged(f3);
            this.propertyChanged(27);
        }
    }

    @Override
    public final float get_pivotX() {
        return this.pivotX;
    }

    @Override
    public final void set_pivotX(float f2) {
        float f3 = this.pivotX;
        if (f3 != f2) {
            this.pivotX = f2;
            this.rotationPivotXChanged(f3);
            this.propertyChanged(28);
        }
    }

    @Override
    public final float get_pivotY() {
        return this.pivotY;
    }

    @Override
    public final void set_pivotY(float f2) {
        float f3 = this.pivotY;
        if (f3 != f2) {
            this.pivotY = f2;
            this.rotationPivotYChanged(f3);
            this.propertyChanged(29);
        }
    }

    @Override
    public final float get_pivotZ() {
        return this.pivotZ;
    }

    @Override
    public final void set_pivotZ(float f2) {
        float f3 = this.pivotZ;
        if (f3 != f2) {
            this.pivotZ = f2;
            this.rotationPivotZChanged(f3);
            this.propertyChanged(30);
        }
    }

    @Override
    public final float get_scalingX() {
        return this.scalingX;
    }

    @Override
    public final void set_scalingX(float f2) {
        float f3 = this.scalingX;
        if (!this.startScalingXAnimation(f2) && f2 != f3) {
            this.scalingX = f2;
            this.scaleXChanged(f3);
            this.propertyChanged(31);
        }
    }

    @Override
    public final float get_scalingY() {
        return this.scalingY;
    }

    @Override
    public final void set_scalingY(float f2) {
        float f3 = this.scalingY;
        if (!this.startScalingYAnimation(f2) && f2 != f3) {
            this.scalingY = f2;
            this.scaleYChanged(f3);
            this.propertyChanged(32);
        }
    }

    @Override
    public final float get_scalingZ() {
        return this.scalingZ;
    }

    @Override
    public final void set_scalingZ(float f2) {
        float f3 = this.scalingZ;
        if (!this.startScalingZAnimation(f2) && f2 != f3) {
            this.scalingZ = f2;
            this.scaleZChanged(f3);
            this.propertyChanged(33);
        }
    }

    @Override
    public final float get_projectionNear() {
        return this.projectionNear;
    }

    @Override
    public final void set_projectionNear(float f2) {
        float f3 = this.projectionNear;
        if (f3 != f2) {
            this.projectionNear = f2;
            this.projectionPlaneNearChanged(f3);
            this.propertyChanged(34);
        }
    }

    @Override
    public final float get_projectionFar() {
        return this.projectionFar;
    }

    @Override
    public final void set_projectionFar(float f2) {
        float f3 = this.projectionFar;
        if (f3 != f2) {
            this.projectionFar = f2;
            this.projectionPlaneFarChanged(f3);
            this.propertyChanged(35);
        }
    }

    @Override
    public final float get_projectionFOV() {
        return this.projectionFOV;
    }

    @Override
    public final void set_projectionFOV(float f2) {
        float f3 = this.projectionFOV;
        if (f3 != f2) {
            this.projectionFOV = f2;
            this.projectionPerspectiveFOVChanged(f3);
            this.propertyChanged(36);
        }
    }

    @Override
    public int get_projectionType() {
        return this.projectionType;
    }

    @Override
    public final void set_projectionType(int n) {
        int n2 = this.projectionType;
        if (n2 != n) {
            this.projectionType = n;
            this.projectionTypeChanged(n2);
            this.propertyChanged(37);
        }
    }

    @Override
    public int get_decoration() {
        return this.decoration;
    }

    @Override
    public void set_decoration(int n) {
        int n2 = this.decoration;
        if (n2 != n) {
            this.decoration = n;
            this.decorationChanged(n2);
            this.propertyChanged(38);
        }
    }

    @Override
    public float get_alphaImageRotation() {
        return this.alphaImageRotation;
    }

    @Override
    public void set_alphaImageRotation(float f2) {
        float f3 = this.alphaImageRotation;
        if (!this.startAlphaImageRotationAnimation(f2) && !Util.equalsEpsilon(f3, f2)) {
            this.alphaImageRotation = f2;
            this.alphaImageRotationChanged(f3);
            this.propertyChanged(39);
        }
    }

    @Override
    public float getProjectionDistance() {
        return this.projectionDistance;
    }

    private void updateProjectionDistance() {
        this.projectionDistance = this.get_projectionType() == 2 && this.getView() != null ? Util.calculateOptimalDistanceByFOV(this.get_projectionFOV(), this.getView().get_height()) : (this.get_projectionType() == 3 ? Util.calculateOptimalDistanceByFOV(this.get_projectionFOV(), this.get_height()) : 0.0f);
    }

    @Override
    public int getDecoration() {
        return this.get_decoration();
    }

    @Override
    public float getAlphaImageRotation() {
        return this.alphaImageRotation;
    }

    protected void zChanged(int n) {
        this.invalidateLocalTransform();
        this.repaintParent();
    }

    protected void depthChanged(int n) {
        this.repaint();
    }

    protected void rotationXChanged(float f2) {
        this.invalidateLocalTransform();
        this.repaintParent();
    }

    protected void alphaImageRotationChanged(float f2) {
        this.repaint();
    }

    protected void rotationYChanged(float f2) {
        this.invalidateLocalTransform();
        this.repaintParent();
    }

    protected void rotationZChanged(float f2) {
        this.invalidateLocalTransform();
        this.repaintParent();
    }

    protected void rotationPivotXChanged(float f2) {
        this.invalidateLocalTransform();
        this.repaintParent();
    }

    protected void rotationPivotYChanged(float f2) {
        this.invalidateLocalTransform();
        this.repaintParent();
    }

    protected void rotationPivotZChanged(float f2) {
        this.invalidateLocalTransform();
        this.repaintParent();
    }

    protected void scaleXChanged(float f2) {
        this.invalidateLocalTransform();
        this.repaintParent();
    }

    protected void scaleYChanged(float f2) {
        this.invalidateLocalTransform();
        this.repaintParent();
    }

    protected void scaleZChanged(float f2) {
        this.invalidateLocalTransform();
        this.repaintParent();
    }

    protected void projectionPlaneNearChanged(float f2) {
        this.repaint();
    }

    protected void projectionPlaneFarChanged(float f2) {
        this.repaint();
    }

    protected void projectionPerspectiveFOVChanged(float f2) {
        this.updateProjectionDistance();
        this.repaint();
    }

    protected void projectionTypeChanged(int n) {
        this.updateProjectionDistance();
        this.repaint();
    }

    protected void decorationChanged(int n) {
        this.repaint();
    }

    @Override
    protected void heightChanged(int n) {
        super.heightChanged(n);
        this.updateProjectionDistance();
    }

    @Override
    public boolean isRenderOffscreen() {
        return super.isRenderOffscreen() || this.decoration != 0 || this.isTransformationRequired();
    }

    @Override
    public boolean isTransformationRequired() {
        return this.z != 0 || this.isRotationActive() || this.isScalingActive();
    }

    private boolean isScalingActive() {
        return !Util.equalsEpsilon(this.scalingX, 1.0f) || !Util.equalsEpsilon(this.scalingY, 1.0f) || !Util.equalsEpsilon(this.scalingZ, 1.0f);
    }

    private boolean isRotationActive() {
        return !Util.equalsEpsilon(this.rotationX, 0.0f) || !Util.equalsEpsilon(this.rotationY, 0.0f) || !Util.equalsEpsilon(this.rotationZ, 0.0f);
    }

    /*
     * Handled unverifiable bytecode (illegal stack merge).
     */
    @Override
    protected void updateLocalTransform() {
        this.localTransform.setScale(1.0f);
        this.localTransform.setTranslation(this.get_x(), this.get_y(), this.getParent() != null ? 0.0f : (float)4201669);
        if (this.isRotationActive()) {
            Matrix3f matrix3f = new Matrix3f(true);
            matrix3f.setRotationAboutXYZ(Util.toRadians(this.get_rotationX()), Util.toRadians(this.get_rotationY()), Util.toRadians(this.get_rotationZ()));
            this.localTransform.setRotation(matrix3f);
        }
    }

    @Override
    public final int getAbsZ() {
        return (this.getParent() != null ? this.getParent().getAbsZ() : 0) + (this.isRenderOffscreen() ? 0 : this.get_z());
    }

    @Override
    public void stopInternalAnimations() {
        super.stopInternalAnimations();
        this.stopInternalAnimation(this.rotationXAnimation);
        this.stopInternalAnimation(this.rotationYAnimation);
        this.stopInternalAnimation(this.rotationZAnimation);
        this.stopInternalAnimation(this.scalingXAnimation);
        this.stopInternalAnimation(this.scalingYAnimation);
        this.stopInternalAnimation(this.scalingZAnimation);
        this.stopInternalAnimation(this.translateZAnimation);
    }

    private boolean startTranslateZAnimation(int n) {
        if (this.translateZAnimation == null && this.isEasingAvailable(8)) {
            this.translateZAnimation = new AbstractWidget$PublicPropertyAnimation((AbstractWidget)this, 8, 23, new TransformContainer$1(this));
        }
        return this.startPropertyAnimation(this.translateZAnimation, n);
    }

    private boolean startRotationXAnimation(float f2) {
        if (this.rotationXAnimation == null && this.isEasingAvailable(9)) {
            this.rotationXAnimation = new AbstractWidget$PublicPropertyAnimation((AbstractWidget)this, 9, 25, new TransformContainer$2(this));
        }
        return this.startPropertyAnimation(this.rotationXAnimation, f2);
    }

    private boolean startRotationYAnimation(float f2) {
        if (this.rotationYAnimation == null && this.isEasingAvailable(10)) {
            this.rotationYAnimation = new AbstractWidget$PublicPropertyAnimation((AbstractWidget)this, 10, 26, new TransformContainer$3(this));
        }
        return this.startPropertyAnimation(this.rotationYAnimation, f2);
    }

    private boolean startRotationZAnimation(float f2) {
        if (this.rotationZAnimation == null && this.isEasingAvailable(11)) {
            this.rotationZAnimation = new AbstractWidget$PublicPropertyAnimation((AbstractWidget)this, 11, 27, new TransformContainer$4(this));
        }
        return this.startPropertyAnimation(this.rotationZAnimation, f2);
    }

    private boolean startScalingXAnimation(float f2) {
        if (this.scalingXAnimation == null && this.isEasingAvailable(12)) {
            this.scalingXAnimation = new AbstractWidget$PublicPropertyAnimation((AbstractWidget)this, 12, 31, new TransformContainer$5(this));
        }
        return this.startPropertyAnimation(this.scalingXAnimation, f2);
    }

    private boolean startScalingYAnimation(float f2) {
        if (this.scalingYAnimation == null && this.isEasingAvailable(13)) {
            this.scalingYAnimation = new AbstractWidget$PublicPropertyAnimation((AbstractWidget)this, 13, 32, new TransformContainer$6(this));
        }
        return this.startPropertyAnimation(this.scalingYAnimation, f2);
    }

    private boolean startScalingZAnimation(float f2) {
        if (this.scalingZAnimation == null && this.isEasingAvailable(14)) {
            this.scalingZAnimation = new AbstractWidget$PublicPropertyAnimation((AbstractWidget)this, 14, 33, new TransformContainer$7(this));
        }
        return this.startPropertyAnimation(this.scalingZAnimation, f2);
    }

    private boolean startAlphaImageRotationAnimation(float f2) {
        if (this.alphaImageRotationAnimation == null && this.isEasingAvailable(7)) {
            this.alphaImageRotationAnimation = new AbstractWidget$PublicPropertyAnimation((AbstractWidget)this, 7, 39, new TransformContainer$8(this));
        }
        return this.startPropertyAnimation(this.alphaImageRotationAnimation, f2);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ float access$002(TransformContainer transformContainer, float f2) {
        transformContainer.alphaImageRotation = f2;
        return transformContainer.alphaImageRotation;
    }

    static /* synthetic */ float access$000(TransformContainer transformContainer) {
        return transformContainer.alphaImageRotation;
    }
}

