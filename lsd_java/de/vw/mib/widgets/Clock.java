/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.widgets.AbstractImage;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.ClockModel;
import de.vw.mib.widgets.models.ViewModel;

public class Clock
extends AbstractImage
implements ClockModel {
    private int hour;
    private int minute;
    private int second;
    private boolean showSeconds;
    private Image clockBackgroundImage;
    private Color clockBackgroundColor;
    private Image clockForegroundImage;
    private Color clockForegroundColor;
    private Image clockHourImage;
    private Color clockHourColor;
    private Image clockMinuteImage;
    private Color clockMinuteColor;
    private Image clockSecondImage;
    private Color clockSecondColor;
    private float centerPositionX;
    private float centerPositionY;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$ClockUI;

    @Override
    protected void reset() {
        super.reset();
    }

    public void init(boolean bl, int n, boolean bl2, Color color, int n2, Color color2, Image image, Color color3, Image image2, Color color4, Image image3, Color color5, Image image4, Color color6, Image image5, Color color7, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, int n3, int n4, boolean bl5, int n5, String string, int n6, boolean bl6, int n7, Insets insets, boolean bl7, int n8, int n9, int n10) {
        super.init(bl, n, bl2, color, n2, color7, bl3, easingParamsArray, bl4, n3, bl5, string, n7, insets, bl7, n8, n9, n10);
        this.hour = n4;
        this.minute = n5;
        this.second = n6;
        this.showSeconds = bl6;
        this.clockBackgroundImage = image;
        this.clockBackgroundColor = color2;
        this.clockForegroundImage = image2;
        this.clockForegroundColor = color3;
        this.clockHourImage = image3;
        this.clockHourColor = color4;
        this.clockMinuteImage = image4;
        this.clockMinuteColor = color5;
        this.clockSecondImage = image5;
        this.clockSecondColor = color6;
    }

    public void init(boolean bl, int n, boolean bl2, Color color, int n2, Image image, Image image2, Image image3, Image image4, Image image5, Color color2, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, int n3, int n4, boolean bl5, int n5, String string, int n6, boolean bl6, int n7, Insets insets, boolean bl7, int n8, int n9, int n10) {
        this.init(bl, n, bl2, color, n2, Color.WHITE, image, Color.WHITE, image2, Color.WHITE, image3, Color.WHITE, image4, Color.WHITE, image5, color2, bl3, easingParamsArray, bl4, n3, n4, bl5, n5, string, n6, bl6, n7, insets, bl7, n8, n9, n10);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.get_clockHourImage());
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.get_clockMinuteImage());
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.get_clockSecondImage());
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.get_clockBackgroundImage());
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.get_clockForegroundImage());
        this.updateClockCenterPoint();
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$ClockUI == null ? (class$de$vw$mib$widgets$ui$ClockUI = Clock.class$("de.vw.mib.widgets.ui.ClockUI")) : class$de$vw$mib$widgets$ui$ClockUI};
    }

    @Override
    public final Image get_clockBackgroundImage() {
        return this.clockBackgroundImage;
    }

    @Override
    public final void set_clockBackgroundImage(Image image) {
        Image image2 = this.clockBackgroundImage;
        if (image2 == null || !image2.equals(image)) {
            this.clockBackgroundImage = image;
            this.clockBackgroundImageChanged(image2);
            this.propertyChanged(24);
        }
    }

    @Override
    public Color get_clockBackgroundColor() {
        return this.clockBackgroundColor;
    }

    @Override
    public void set_clockBackgroundColor(Color color) {
        Color color2 = this.clockBackgroundColor;
        if (color2 == null || !color2.equals(color)) {
            this.clockBackgroundColor = color;
            this.clockBackgroundColorChanged(color2);
            this.propertyChanged(25);
        }
    }

    @Override
    public final Image get_clockForegroundImage() {
        return this.clockForegroundImage;
    }

    @Override
    public final void set_clockForegroundImage(Image image) {
        Image image2 = this.clockForegroundImage;
        if (image2 == null || !image2.equals(image)) {
            this.clockForegroundImage = image;
            this.clockForegroundImageChanged(image2);
            this.propertyChanged(26);
        }
    }

    @Override
    public Color get_clockForegroundColor() {
        return this.clockForegroundColor;
    }

    @Override
    public void set_clockForegroundColor(Color color) {
        Color color2 = this.clockForegroundColor;
        if (color2 == null || !color2.equals(color)) {
            this.clockForegroundColor = color;
            this.clockForegroundColorChanged(color2);
            this.propertyChanged(27);
        }
    }

    @Override
    public final Image get_clockHourImage() {
        return this.clockHourImage;
    }

    @Override
    public final void set_clockHourImage(Image image) {
        Image image2 = this.clockHourImage;
        if (image2 == null || !image2.equals(image)) {
            this.clockHourImage = image;
            this.clockHourImageChanged(image2);
            this.propertyChanged(28);
        }
    }

    @Override
    public Color get_clockHourColor() {
        return this.clockHourColor;
    }

    @Override
    public void set_clockHourColor(Color color) {
        Color color2 = this.clockHourColor;
        if (color2 == null || !color2.equals(color)) {
            this.clockHourColor = color;
            this.clockHourColorChanged(color2);
            this.propertyChanged(29);
        }
    }

    @Override
    public final Image get_clockMinuteImage() {
        return this.clockMinuteImage;
    }

    @Override
    public final void set_clockMinuteImage(Image image) {
        Image image2 = this.clockMinuteImage;
        if (image2 == null || !image2.equals(image)) {
            this.clockMinuteImage = image;
            this.clockMinuteImageChanged(image2);
            this.propertyChanged(30);
        }
    }

    @Override
    public Color get_clockMinuteColor() {
        return this.clockMinuteColor;
    }

    @Override
    public void set_clockMinuteColor(Color color) {
        Color color2 = this.clockMinuteColor;
        if (color2 == null || !color2.equals(color)) {
            this.clockMinuteColor = color;
            this.clockMinuteColorChanged(color2);
            this.propertyChanged(31);
        }
    }

    @Override
    public final Image get_clockSecondImage() {
        return this.clockSecondImage;
    }

    @Override
    public final void set_clockSecondImage(Image image) {
        Image image2 = this.clockSecondImage;
        if (image2 == null || !image2.equals(image)) {
            this.clockSecondImage = image;
            this.clockSecondImageChanged(image2);
            this.propertyChanged(32);
        }
    }

    @Override
    public Color get_clockSecondColor() {
        return this.clockSecondColor;
    }

    @Override
    public void set_clockSecondColor(Color color) {
        Color color2 = this.clockSecondColor;
        if (color2 == null || !color2.equals(color)) {
            this.clockSecondColor = color;
            this.clockSecondColorChanged(color2);
            this.propertyChanged(33);
        }
    }

    @Override
    public final int get_hour() {
        return this.hour;
    }

    @Override
    public final void set_hour(int n) {
        int n2 = this.hour;
        if (n2 != n) {
            this.hour = n;
            this.hourChanged(n2);
            this.propertyChanged(20);
        }
    }

    @Override
    public final int get_minute() {
        return this.minute;
    }

    @Override
    public final void set_minute(int n) {
        int n2 = this.minute;
        if (n2 != n) {
            this.minute = n;
            this.minuteChanged(n2);
            this.propertyChanged(21);
        }
    }

    @Override
    public final int get_second() {
        return this.second;
    }

    @Override
    public final void set_second(int n) {
        int n2 = this.second;
        if (n2 != n) {
            this.second = n;
            this.secondChanged(n2);
            this.propertyChanged(22);
        }
    }

    @Override
    public final boolean is_showSeconds() {
        return this.showSeconds;
    }

    @Override
    public final void set_showSeconds(boolean bl) {
        boolean bl2 = this.showSeconds;
        if (bl2 != bl) {
            this.showSeconds = bl;
            this.showSecondsChanged(bl2);
            this.propertyChanged(23);
        }
    }

    @Override
    protected void widthChanged(int n) {
        super.widthChanged(n);
        this.updateClockCenterPoint();
    }

    @Override
    protected void heightChanged(int n) {
        super.heightChanged(n);
        this.updateClockCenterPoint();
    }

    protected void hourChanged(int n) {
        this.repaint();
    }

    protected void minuteChanged(int n) {
        this.repaint();
    }

    protected void secondChanged(int n) {
        this.repaint();
    }

    protected void showSecondsChanged(boolean bl) {
        this.repaint();
    }

    protected void clockHourImageChanged(Image image) {
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.get_clockHourImage());
        this.repaint();
    }

    protected void clockHourColorChanged(Color color) {
        this.repaint();
    }

    protected void clockMinuteImageChanged(Image image) {
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.get_clockMinuteImage());
        this.repaint();
    }

    protected void clockMinuteColorChanged(Color color) {
        this.repaint();
    }

    protected void clockSecondImageChanged(Image image) {
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.get_clockSecondImage());
        this.repaint();
    }

    protected void clockSecondColorChanged(Color color) {
        this.repaint();
    }

    protected void clockBackgroundImageChanged(Image image) {
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.get_clockBackgroundImage());
        this.repaint();
    }

    protected void clockBackgroundColorChanged(Color color) {
        this.repaint();
    }

    protected void clockForegroundImageChanged(Image image) {
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.get_clockForegroundImage());
        this.repaint();
    }

    protected void clockForegroundColorChanged(Color color) {
        this.repaint();
    }

    private void updateClockCenterPoint() {
        this.centerPositionX = (float)this.get_width() / 2.0f;
        this.centerPositionY = (float)this.get_height() / 2.0f;
    }

    @Override
    public float getCenterPositionX() {
        return this.centerPositionX;
    }

    @Override
    public float getCenterPositionY() {
        return this.centerPositionY;
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

