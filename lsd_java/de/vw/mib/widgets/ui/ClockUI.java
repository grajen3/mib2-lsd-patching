/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.Drawable;
import de.vw.mib.graphics.drawable.image.ScaleImageDrawable;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.models.ClockModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.AbstractImageUI;
import java.io.IOException;

public final class ClockUI
extends AbstractImageUI {
    private ScaleImageDrawable backgroundImageDrawable;
    private ScaleImageDrawable foregroundImageDrawable;
    private ScaleImageDrawable hourImageDrawable;
    private ScaleImageDrawable minuteImageDrawable;
    private ScaleImageDrawable secondImageDrawable;

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void deInit() {
        this.disposeDrawableAndLog(this.backgroundImageDrawable, "background drawable");
        this.backgroundImageDrawable = null;
        this.disposeDrawableAndLog(this.foregroundImageDrawable, "foreground drawable");
        this.foregroundImageDrawable = null;
        this.disposeDrawableAndLog(this.hourImageDrawable, "hour drawable");
        this.hourImageDrawable = null;
        this.disposeDrawableAndLog(this.minuteImageDrawable, "minute drawable");
        this.minuteImageDrawable = null;
        this.disposeDrawableAndLog(this.secondImageDrawable, "second drawable");
        this.secondImageDrawable = null;
        super.deInit();
    }

    private void disposeDrawableAndLog(Drawable drawable, String string) {
        if (drawable != null) {
            drawable.dispose();
            if (LOGGER.isTraceEnabled(128)) {
                LogMessage logMessage = LOGGER.trace(128);
                logMessage.append("ClockUI '").append(this.getWidget().getQualifiedName()).append("'': Disposed ").append(string).log();
            }
        }
    }

    @Override
    public void paintImage(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, Color4b color4b, float f2) {
        ClockModel clockModel = (ClockModel)widgetModel;
        try {
            this.updateBackgroundDrawable(graphics3D, clockModel);
            this.updateForegroundDrawable(graphics3D, clockModel);
            this.updateHourDrawable(graphics3D, clockModel);
            this.updateMinuteDrawable(graphics3D, clockModel);
            this.updateSecondDrawable(graphics3D, clockModel);
        }
        catch (IOException iOException) {
            LogMessage logMessage = LOGGER.error(512);
            logMessage.append("Widget '").append(clockModel.getQualifiedName()).append("': Unable to load image: ").append(iOException).log();
            return;
        }
        this.paintClockBody(this.backgroundImageDrawable, graphics3D, clockModel, clockModel.get_clockBackgroundColor().getCurrentColor(), f2);
        this.paintClockHands(this.minuteImageDrawable, graphics3D, clockModel, 6 * clockModel.get_minute(), clockModel.get_clockMinuteColor().getCurrentColor(), f2);
        this.paintClockHands(this.hourImageDrawable, graphics3D, clockModel, ClockUI.getHourAngle(clockModel.get_hour(), clockModel.get_minute()), clockModel.get_clockHourColor().getCurrentColor(), f2);
        if (clockModel.is_showSeconds()) {
            this.paintClockHands(this.secondImageDrawable, graphics3D, clockModel, 6 * clockModel.get_second(), clockModel.get_clockSecondColor().getCurrentColor(), f2);
        }
        this.paintClockBody(this.foregroundImageDrawable, graphics3D, clockModel, clockModel.get_clockForegroundColor().getCurrentColor(), f2);
    }

    private void paintClockBody(ScaleImageDrawable scaleImageDrawable, Graphics3D graphics3D, ClockModel clockModel, Color4b color4b, float f2) {
        if (scaleImageDrawable != null) {
            float f3 = clockModel.getCenterPositionX() - (float)scaleImageDrawable.getWidth() / 2.0f;
            float f4 = clockModel.getCenterPositionY() - (float)scaleImageDrawable.getHeight() / 2.0f;
            scaleImageDrawable.setColor(color4b);
            scaleImageDrawable.setAlpha(f2);
            scaleImageDrawable.draw(f3, f4);
        }
    }

    private void paintClockHands(ScaleImageDrawable scaleImageDrawable, Graphics3D graphics3D, ClockModel clockModel, float f2, Color4b color4b, float f3) {
        if (scaleImageDrawable != null) {
            graphics3D.pushMatrix(0);
            int n = scaleImageDrawable.getWidth();
            int n2 = scaleImageDrawable.getHeight();
            float f4 = clockModel.getCenterPositionX();
            float f5 = clockModel.getCenterPositionY();
            graphics3D.translateMatrix(0, f4, f5, 0.0f);
            graphics3D.rotateMatrix(0, f2, 0.0f, 0.0f, 1.0f);
            graphics3D.translateMatrix(0, 0.0f - (float)n / 2.0f, 0.0f - (float)n2 / 2.0f, 0.0f);
            scaleImageDrawable.setColor(color4b);
            scaleImageDrawable.setAlpha(f3);
            scaleImageDrawable.draw();
            graphics3D.popMatrix(0);
        }
    }

    private static float getHourAngle(int n, int n2) {
        int n3 = 61505 * (float)n;
        int n4 = 28738 / (float)n2;
        return n3 + 61505 / n4;
    }

    private void updateBackgroundDrawable(Graphics3D graphics3D, ClockModel clockModel) {
        this.backgroundImageDrawable = ClockUI.updateScaleImageDrawable(graphics3D, clockModel, this.backgroundImageDrawable, clockModel.get_clockBackgroundImage());
    }

    private void updateForegroundDrawable(Graphics3D graphics3D, ClockModel clockModel) {
        this.foregroundImageDrawable = ClockUI.updateScaleImageDrawable(graphics3D, clockModel, this.foregroundImageDrawable, clockModel.get_clockForegroundImage());
    }

    private void updateHourDrawable(Graphics3D graphics3D, ClockModel clockModel) {
        this.hourImageDrawable = ClockUI.updateScaleImageDrawable(graphics3D, clockModel, this.hourImageDrawable, clockModel.get_clockHourImage(), true);
    }

    private void updateMinuteDrawable(Graphics3D graphics3D, ClockModel clockModel) {
        this.minuteImageDrawable = ClockUI.updateScaleImageDrawable(graphics3D, clockModel, this.minuteImageDrawable, clockModel.get_clockMinuteImage(), true);
    }

    private void updateSecondDrawable(Graphics3D graphics3D, ClockModel clockModel) {
        this.secondImageDrawable = ClockUI.updateScaleImageDrawable(graphics3D, clockModel, this.secondImageDrawable, clockModel.get_clockSecondImage(), true);
    }
}

