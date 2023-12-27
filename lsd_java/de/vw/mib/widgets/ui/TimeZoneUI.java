/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.image.ScaleImageDrawable;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.models.TimeZoneModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.AbstractWidgetUI;
import java.io.IOException;

public final class TimeZoneUI
extends AbstractWidgetUI {
    private ScaleImageDrawable backgroundDrawable;
    private ScaleImageDrawable zoneDrawable;

    @Override
    public void deInit() {
        TimeZoneUI.disposeDrawable(this.backgroundDrawable);
        this.backgroundDrawable = null;
        TimeZoneUI.disposeDrawable(this.zoneDrawable);
        this.zoneDrawable = null;
        super.deInit();
    }

    @Override
    public void paint(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        TimeZoneModel timeZoneModel = (TimeZoneModel)widgetModel;
        this.drawBackground(graphics3D, timeZoneModel);
        this.drawTimeZone(graphics3D, timeZoneModel);
    }

    private void drawBackground(Graphics3D graphics3D, TimeZoneModel timeZoneModel) {
        try {
            this.updateBackgroundDrawable(graphics3D, timeZoneModel);
            if (this.backgroundDrawable != null) {
                this.backgroundDrawable.draw();
            }
        }
        catch (IOException iOException) {
            this.logErrorMessage(iOException, timeZoneModel.getQualifiedName());
        }
    }

    private void drawTimeZone(Graphics3D graphics3D, TimeZoneModel timeZoneModel) {
        try {
            this.updateZoneDrawable(graphics3D, timeZoneModel);
            if (this.zoneDrawable != null) {
                this.zoneDrawable.draw();
            }
        }
        catch (IOException iOException) {
            this.logErrorMessage(iOException, timeZoneModel.getQualifiedName());
        }
    }

    private void updateBackgroundDrawable(Graphics3D graphics3D, TimeZoneModel timeZoneModel) {
        this.backgroundDrawable = TimeZoneUI.updateScaleImageDrawable(graphics3D, timeZoneModel, this.backgroundDrawable, timeZoneModel.get_backgroundImage());
    }

    private void updateZoneDrawable(Graphics3D graphics3D, TimeZoneModel timeZoneModel) {
        Image[] imageArray = timeZoneModel.get_zoneImages();
        int n = timeZoneModel.get_activeTimezone();
        if (n < 0 || n >= imageArray.length) {
            TimeZoneUI.disposeDrawable(this.zoneDrawable);
            this.zoneDrawable = null;
            throw new IOException(new StringBuffer().append("Could not load time zone image for activeTimeZone=").append(n).toString());
        }
        Image image = imageArray[n];
        this.zoneDrawable = TimeZoneUI.updateScaleImageDrawable(graphics3D, timeZoneModel, this.zoneDrawable, image);
    }

    private void logErrorMessage(Exception exception, String string) {
        LogMessage logMessage = LOGGER.error(512);
        logMessage.append("TimeZoneUI '").append(string).append("': Unable to load image. '").append(exception).log();
    }
}

