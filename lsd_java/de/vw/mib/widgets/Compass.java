/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.widgets.AbstractImage;
import de.vw.mib.widgets.Compass$CompassHeadingAnimation;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.CompassModel;
import de.vw.mib.widgets.models.ViewModel;

public class Compass
extends AbstractImage
implements CompassModel {
    private Image roseImage;
    private int distance;
    private int rotation;
    private int heading;
    private float headingToDraw;
    private Compass$CompassHeadingAnimation headingAnimation;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$CompassUI;

    @Override
    protected void reset() {
        super.reset();
    }

    public void init(boolean bl, int n, boolean bl2, Color color, int n2, Color color2, boolean bl3, int n3, EasingParams[] easingParamsArray, boolean bl4, int n4, int n5, boolean bl5, boolean bl6, String string, Image image, int n6, int n7, Insets insets, boolean bl7, int n8, int n9, int n10) {
        super.init(bl, n, bl2, color, n2, color2, bl3, easingParamsArray, bl4, n5, bl6, string, n7, insets, bl7, n8, n9, n10);
        this.heading = n4;
        this.distance = n3;
        this.roseImage = image;
        this.rotation = n6;
        this.setInternalStateFlag(9, bl5);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.get_roseImage());
        this.validateHeading();
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$CompassUI == null ? (class$de$vw$mib$widgets$ui$CompassUI = Compass.class$("de.vw.mib.widgets.ui.CompassUI")) : class$de$vw$mib$widgets$ui$CompassUI};
    }

    @Override
    public final int get_heading() {
        return this.heading;
    }

    @Override
    public final void set_heading(int n) {
        int n2 = this.heading;
        if (n2 != n) {
            this.heading = n;
            this.headingChanged(n2);
            this.propertyChanged(20);
        }
    }

    @Override
    public final boolean is_invertHeading() {
        return this.getInternalStateFlag(9);
    }

    @Override
    public final void set_invertHeading(boolean bl) {
        boolean bl2 = this.is_invertHeading();
        if (bl2 != bl) {
            this.setInternalStateFlag(9, bl);
            this.invertHeadingChanged(bl2);
            this.propertyChanged(24);
        }
    }

    @Override
    public final int get_rotation() {
        return this.rotation;
    }

    @Override
    public final void set_rotation(int n) {
        int n2 = this.rotation;
        if (n2 != n) {
            this.rotation = n;
            this.rotationChanged(n2);
            this.propertyChanged(23);
        }
    }

    @Override
    public final int get_distance() {
        return this.distance;
    }

    @Override
    public final void set_distance(int n) {
        int n2 = this.distance;
        if (n2 != n) {
            this.distance = n;
            this.distanceChanged(n2);
            this.propertyChanged(22);
        }
    }

    @Override
    public final Image get_roseImage() {
        return this.roseImage;
    }

    @Override
    public final void set_roseImage(Image image) {
        Image image2 = this.roseImage;
        if (image2 == null || !image2.equals(image)) {
            this.roseImage = image;
            this.roseImageChanged(image2);
            this.propertyChanged(21);
        }
    }

    @Override
    public float getHeadingToDraw() {
        return this.headingToDraw;
    }

    protected void setHeadingToDraw(float f2) {
        this.headingToDraw = f2;
        this.repaint();
    }

    protected void headingChanged(int n) {
        this.validateHeading();
    }

    protected void invertHeadingChanged(boolean bl) {
        this.validateHeading();
    }

    protected void roseImageChanged(Image image) {
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.get_roseImage());
        this.repaint();
    }

    protected void rotationChanged(int n) {
        this.repaint();
    }

    protected void distanceChanged(int n) {
        this.repaint();
    }

    @Override
    protected void widthChanged(int n) {
        super.widthChanged(n);
        this.repaint();
    }

    @Override
    protected void heightChanged(int n) {
        super.heightChanged(n);
        this.repaint();
    }

    private void validateHeading() {
        int n = (int)Compass.wrap(this.heading);
        if (!this.is_invertHeading()) {
            n *= -1;
        }
        if (!this.startHeadingAnimation(this.headingToDraw, n)) {
            this.headingToDraw = n;
            this.repaint();
        }
    }

    private static float wrap(float f2) {
        while (f2 < 0.0f) {
            f2 += 46147;
        }
        while (f2 > 46147) {
            f2 -= 46147;
        }
        return f2;
    }

    private boolean startHeadingAnimation(float f2, float f3) {
        this.stopHeadingAnimation();
        EasingParams easingParams = null;
        if (easingParams == null || easingParams.getEasingClass() == 0) {
            return false;
        }
        float f4 = f3;
        if (Math.abs(f3 - f2) > 13379) {
            f4 += f3 > f2 ? 46275 : 46147;
        }
        this.headingAnimation = new Compass$CompassHeadingAnimation(this, this, easingParams, f2, f4 - f2);
        return this.startInternalAnimation(this.headingAnimation);
    }

    private void stopHeadingAnimation() {
        if (this.headingAnimation != null) {
            this.stopInternalAnimation(this.headingAnimation);
            this.headingAnimation = null;
        }
    }

    @Override
    public void stopInternalAnimations() {
        super.stopInternalAnimations();
        this.stopHeadingAnimation();
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

