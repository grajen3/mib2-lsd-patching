/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.input;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.internal.system.AslTargetSystemKeyPanelHandling;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.TouchScreenFeatureSetter;
import de.vw.mib.asl.internal.system.input.AbstractInputDevice;
import de.vw.mib.asl.internal.system.input.TouchInputDeviceImpl$1;
import de.vw.mib.asl.internal.system.util.SystemLogger;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.input.devices.TouchInputDevice;
import de.vw.mib.input.devices.TouchInputDeviceListener;
import java.util.Iterator;
import org.dsi.ifc.keypanel.DSIKeyPanelListener;

public class TouchInputDeviceImpl
extends AbstractInputDevice
implements TouchInputDevice {
    static final int UPDATE_GESTURE2_TIME_SCALE_FACTOR = AslTargetSystemKeyPanelHandling.UPDATE_GESTURE2_TIME_SCALE_FACTOR;
    private static final String PROPERTY_SCALE_X;
    private static final String PROPERTY_SCALE_Y;
    private final TouchScreenFeatureSetter touchScreenFeatureSetter;
    private final float scaleX = this.retrieveScaleValue("de.vw.mib.asl.keypanel.touch.scaleX");
    private final float scaleY = this.retrieveScaleValue("de.vw.mib.asl.keypanel.touch.scaleY");
    private DSIProxy dsiProxy;
    private ConfigurationManager configManager;
    private final SystemLogger systemLogger;
    static /* synthetic */ Class class$de$vw$mib$input$devices$TouchInputDeviceListener;

    public TouchInputDeviceImpl(DSIProxy dSIProxy, ConfigurationManager configurationManager, SystemServices systemServices) {
        super(dSIProxy, configurationManager);
        this.dsiProxy = dSIProxy;
        this.configManager = configurationManager;
        this.systemLogger = new SystemLogger(systemServices.getAsl1Logger(), super.getClass());
        this.touchScreenFeatureSetter = this.createTouchscreenFeatureSetter();
    }

    @Override
    public int getType() {
        return 0;
    }

    public void setRawGesturesActive(boolean bl) {
        this.touchScreenFeatureSetter.activateRawGestures(bl);
    }

    public void setRotateStep(int n) {
        this.dsiKeyPanel.setGenericSetting(13, 106, n);
    }

    public void setZoomStep(int n) {
        this.dsiKeyPanel.setGenericSetting(13, 108, n);
    }

    public void setDragStep(int n) {
        this.dsiKeyPanel.setGenericSetting(13, 102, n);
    }

    @Override
    protected DSIKeyPanelListener createKeyPanelListener() {
        return new TouchInputDeviceImpl$1(this);
    }

    @Override
    protected int[] getDsiAttributes() {
        return new int[]{20, 25};
    }

    @Override
    protected Class getListenerClass() {
        return class$de$vw$mib$input$devices$TouchInputDeviceListener == null ? (class$de$vw$mib$input$devices$TouchInputDeviceListener = TouchInputDeviceImpl.class$("de.vw.mib.input.devices.TouchInputDeviceListener")) : class$de$vw$mib$input$devices$TouchInputDeviceListener;
    }

    float getScaleX() {
        return this.scaleX;
    }

    float getScaleY() {
        return this.scaleY;
    }

    int scaleParameterForTwoFingerGesture(int n, int n2) {
        if (this.checkIsTwoFingerGesture(n)) {
            return (int)((float)n2 * this.retrieveScaleValue("de.vw.mib.asl.keypanel.touch.scaleX"));
        }
        return n2;
    }

    void updateTouchInput(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        Iterator iterator = this.getListeners().iterator();
        while (iterator.hasNext()) {
            TouchInputDeviceListener touchInputDeviceListener = (TouchInputDeviceListener)iterator.next();
            touchInputDeviceListener.updateTouchInput(n, n2, n3, n4, n5, n6, n7);
        }
    }

    private TouchScreenFeatureSetter createTouchscreenFeatureSetter() {
        return new TouchScreenFeatureSetter(this.dsiProxy, this.configManager);
    }

    private boolean checkIsTwoFingerGesture(int n) {
        switch (n) {
            case 8: {
                return true;
            }
            case 9: {
                return true;
            }
            case 10: {
                return true;
            }
            case 11: {
                return true;
            }
            case 7: {
                return true;
            }
            case 14: {
                return true;
            }
            case 15: {
                return true;
            }
        }
        return false;
    }

    private float retrieveScaleValue(String string) {
        float f2 = 1.0f;
        if (System.getProperty(string) != null) {
            try {
                f2 = Float.parseFloat(System.getProperty(string));
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
        }
        return f2;
    }

    static /* synthetic */ SystemLogger access$000(TouchInputDeviceImpl touchInputDeviceImpl) {
        return touchInputDeviceImpl.systemLogger;
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

