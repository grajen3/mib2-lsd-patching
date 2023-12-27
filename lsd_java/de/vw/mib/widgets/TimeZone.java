/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.TimeZoneModel;
import de.vw.mib.widgets.models.ViewModel;
import java.util.Arrays;

public class TimeZone
extends AbstractWidget
implements TimeZoneModel {
    private Image backgroundImage;
    private Image[] zoneImages;
    private int activeTimezone;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$TimeZoneUI;

    @Override
    protected void reset() {
        super.reset();
    }

    public void init(boolean bl, int n, int n2, boolean bl2, Image image, EasingParams[] easingParamsArray, boolean bl3, int n3, boolean bl4, String string, int n4, Insets insets, boolean bl5, int n5, int n6, int n7, Image[] imageArray) {
        super.init(bl, n2, bl2, easingParamsArray, bl3, n3, bl4, string, n4, insets, bl5, n5, n6, n7);
        this.activeTimezone = n;
        this.backgroundImage = image;
        this.zoneImages = imageArray;
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.get_backgroundImage());
        ServiceManager.imageManager.preloadImagesFromCurrentSkin(this.get_zoneImages());
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$TimeZoneUI == null ? (class$de$vw$mib$widgets$ui$TimeZoneUI = TimeZone.class$("de.vw.mib.widgets.ui.TimeZoneUI")) : class$de$vw$mib$widgets$ui$TimeZoneUI};
    }

    @Override
    public final int get_activeTimezone() {
        return this.activeTimezone;
    }

    @Override
    public final void set_activeTimezone(int n) {
        int n2 = this.activeTimezone;
        if (n2 != n) {
            this.activeTimezone = n;
            this.activeTimezoneChanged(n2);
            this.propertyChanged(15);
        }
    }

    @Override
    public final Image get_backgroundImage() {
        return this.backgroundImage;
    }

    @Override
    public final void set_backgroundImage(Image image) {
        Image image2 = this.backgroundImage;
        if (image2 == null || !image2.equals(image)) {
            this.backgroundImage = image;
            this.backgroundImageChanged(image2);
            this.propertyChanged(16);
        }
    }

    @Override
    public final Image[] get_zoneImages() {
        return this.zoneImages;
    }

    @Override
    public final void set_zoneImages(Image[] imageArray) {
        Object[] objectArray = this.zoneImages;
        if (!Arrays.equals(objectArray, imageArray)) {
            this.zoneImages = imageArray;
            this.zoneImagesChanged((Image[])objectArray);
            this.propertyChanged(16);
        }
    }

    private void activeTimezoneChanged(int n) {
        this.repaint();
    }

    private void backgroundImageChanged(Image image) {
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.get_backgroundImage());
    }

    private void zoneImagesChanged(Image[] imageArray) {
        ServiceManager.imageManager.preloadImagesFromCurrentSkin(this.get_zoneImages());
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

