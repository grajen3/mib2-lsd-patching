/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.RotationEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Point;
import de.vw.mib.widgets.controller.AbstractButtonController;
import de.vw.mib.widgets.controller.ColorChooserController;
import de.vw.mib.widgets.controller.DefaultColorChooserController$ButtonListener;
import de.vw.mib.widgets.event.OutEventListener;
import de.vw.mib.widgets.models.ColorChooserModel;
import de.vw.mib.widgets.models.WidgetModel;
import edu.emory.mathcs.backport.java.util.Arrays;

public class DefaultColorChooserController
extends AbstractButtonController
implements ColorChooserController {
    private int DEFAULT_ROTATION_TICKS = 1;
    private int rotationTick;
    protected int touchX;
    protected int touchY;
    private DefaultColorChooserController$ButtonListener[] buttonListeners;
    protected int updatedColorIndex;
    protected int colorIndexRequested;

    @Override
    protected void reset() {
        super.reset();
        this.touchX = -1;
        this.touchY = -1;
    }

    @Override
    public void init() {
        super.init();
        this.rotationTick = this.DEFAULT_ROTATION_TICKS;
        this.colorIndexRequested = ((ColorChooserModel)this.getWidget()).get_colorIndex();
    }

    @Override
    public void deInit() {
        this.deInitOutEventlisteners();
        super.deInit();
    }

    @Override
    public boolean consumeHMIEvent(HMIEvent hMIEvent, String string) {
        boolean bl = false;
        this.rotationTick = hMIEvent != null && hMIEvent.getType() == 16 ? ((RotationEvent)hMIEvent).getTicks() : this.DEFAULT_ROTATION_TICKS;
        if ("previousColor" == string) {
            this.fire_previousColor();
            bl = true;
        } else if ("nextColor" == string) {
            this.fire_nextColor();
            bl = true;
        }
        return bl;
    }

    @Override
    public boolean consumeTouchEvent(TouchEvent touchEvent) {
        ColorChooserModel colorChooserModel = (ColorChooserModel)this.getWidget();
        boolean bl = false;
        if (colorChooserModel.is_interactive()) {
            this.touchX = touchEvent.getX();
            this.touchY = touchEvent.getY();
            switch (touchEvent.getType()) {
                case 1: {
                    colorChooserModel.setPressed(true);
                    this.fire_press();
                    bl = true;
                    break;
                }
                case 11: {
                    colorChooserModel.setPressed(false);
                    this.fire_cancelled();
                    bl = true;
                    break;
                }
                case 0: 
                case 2: {
                    this.fire_release();
                    colorChooserModel.setPressed(false);
                    bl = true;
                    break;
                }
                case 3: 
                case 4: {
                    this.fire_drag();
                    bl = true;
                    break;
                }
            }
        }
        return bl;
    }

    @Override
    public void fire_press() {
        ColorChooserModel colorChooserModel = (ColorChooserModel)this.getWidget();
        boolean bl = colorChooserModel.setPositionOnIndicator(this.touchX, this.touchY);
        if (!bl) {
            int n = colorChooserModel.calculateColorIndexByPosition(this.touchX, this.touchY);
            colorChooserModel.updateIndicatorPosition(new Point(this.touchX, this.touchY));
            if (this.colorIndexRequested != n) {
                this.updatedColorIndex = n;
                this.fire_colorChanged();
            }
        }
        super.fire_press();
    }

    @Override
    public void fire_drag() {
        ColorChooserModel colorChooserModel = (ColorChooserModel)this.getWidget();
        int n = colorChooserModel.calculateColorIndexByPosition(this.touchX, this.touchY);
        colorChooserModel.updateIndicatorPosition(new Point(this.touchX, this.touchY));
        if (this.colorIndexRequested != n) {
            this.updatedColorIndex = n;
            this.fire_colorChanged();
        }
    }

    @Override
    public void fire_release() {
        ColorChooserModel colorChooserModel = (ColorChooserModel)this.getWidget();
        int n = colorChooserModel.calculateColorIndexByPosition(this.touchX, this.touchY);
        if (colorChooserModel.is_snap()) {
            colorChooserModel.updateIndicatorPosition(n);
        } else {
            colorChooserModel.updateIndicatorPosition(new Point(this.touchX, this.touchY));
        }
        if (this.colorIndexRequested != n) {
            this.updatedColorIndex = n;
            this.fire_colorChanged();
        }
        super.fire_release();
    }

    @Override
    public void fire_cancelled() {
        ColorChooserModel colorChooserModel = (ColorChooserModel)this.getWidget();
        colorChooserModel.updateIndicatorPosition();
        super.fire_cancelled();
    }

    public void fire_previousColor() {
        ColorChooserModel colorChooserModel = (ColorChooserModel)this.getWidget();
        if (colorChooserModel.is_snap()) {
            int n = this.colorIndexRequested;
            boolean bl = false;
            int n2 = colorChooserModel.get_colorBasePoints().length - 1;
            int n3 = 0;
            n3 = colorChooserModel.is_wrapFlag() ? (n - this.rotationTick) % n2 : Math.max(0, n - this.rotationTick);
            if (n != n3) {
                this.updatedColorIndex = n3;
                this.fire_colorChanged();
            }
        }
    }

    public void fire_nextColor() {
        ColorChooserModel colorChooserModel = (ColorChooserModel)this.getWidget();
        if (colorChooserModel.is_snap()) {
            int n = this.colorIndexRequested;
            int n2 = colorChooserModel.get_colorBasePoints().length - 1;
            int n3 = 0;
            n3 = colorChooserModel.is_wrapFlag() ? (n + this.rotationTick) % n2 : Math.min(n2, n + this.rotationTick);
            if (n != n3) {
                this.updatedColorIndex = n3;
                this.fire_colorChanged();
            }
        }
    }

    @Override
    public void fire_colorChanged() {
        ColorChooserModel colorChooserModel = (ColorChooserModel)this.getWidget();
        this.colorIndexRequested = this.updatedColorIndex;
        int n = colorChooserModel.getColorForIndex(this.colorIndexRequested);
        this.fireIntegerEvent("colorChanged", n);
        if (LOGGER.isTraceEnabled(512)) {
            Color4f color4f = new Color4f(n);
            int n2 = 255;
            String string = new StringBuffer().append("[base color, r: ").append((int)(color4f.getRed() * 32579)).append(", g: ").append((int)(color4f.getGreen() * 32579)).append(", b: ").append((int)(color4f.getBlue() * 32579)).append("]").toString();
            this.trace(new StringBuffer().append(".fire_colorChanged();; colorIndexRequested: ").append(this.colorIndexRequested).append(": color: ").append(n).append(", ").append(string).append(", colorList: ").append(Arrays.toString(colorChooserModel.get_colorBasePoints())).toString());
        }
    }

    @Override
    public OutEventListener[] createButtonListeners(WidgetModel[] widgetModelArray) {
        if (widgetModelArray != null) {
            this.buttonListeners = new DefaultColorChooserController$ButtonListener[widgetModelArray.length];
            for (int i2 = 0; i2 < widgetModelArray.length; ++i2) {
                if (widgetModelArray[i2] == null) continue;
                this.buttonListeners[i2] = new DefaultColorChooserController$ButtonListener(this, i2, widgetModelArray[i2].getController());
            }
        }
        return this.buttonListeners;
    }

    @Override
    public final void deInitOutEventlisteners() {
        if (this.buttonListeners != null) {
            for (int i2 = 0; i2 < this.buttonListeners.length; ++i2) {
                if (this.buttonListeners[i2] == null) continue;
                this.buttonListeners[i2].deInit();
            }
        }
        this.buttonListeners = null;
    }

    protected void trace(String string) {
        if (LOGGER.isTraceEnabled(512)) {
            String string2 = this.getWidget().getQualifiedName();
            String string3 = new StringBuffer().append(string2).append(" - Controller").toString();
            LOGGER.trace(512).append(string3).append(string).log();
        }
    }
}

