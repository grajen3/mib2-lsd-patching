/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.carlight;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carlight.DSICarLightReply;
import de.esolutions.fw.comm.dsi.carlight.impl.DSICarLightProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.carlight.DSICarLight;
import org.dsi.ifc.carlight.IntLightBrightness;
import org.dsi.ifc.carlight.IntLightRGBColorListUpdateInfo;
import org.dsi.ifc.carlight.IntLightRGBValues;
import org.dsi.ifc.carlight.MotorwayBlinkingSettings;
import org.dsi.ifc.carlight.TimeState;
import org.osgi.framework.BundleContext;

public class DSICarLightProvider
extends AbstractProvider
implements DSICarLight {
    private static final int[] attributeIDs = new int[]{1, 7, 8, 9, 10, 11, 27, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 52, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 51, 28, 53, 54};
    private DSICarLightProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$carlight$DSICarLight;

    public DSICarLightProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$carlight$DSICarLight == null ? (class$org$dsi$ifc$carlight$DSICarLight = DSICarLightProvider.class$("org.dsi.ifc.carlight.DSICarLight")) : class$org$dsi$ifc$carlight$DSICarLight).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSICarLightProxy(this.instance, (DSICarLightReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void setExtLightComingHome(TimeState timeState) {
        try {
            this.proxy.setExtLightComingHome(timeState);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setExtLightLeavingHome(TimeState timeState) {
        try {
            this.proxy.setExtLightLeavingHome(timeState);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setExtLightSwitchOnSensitivity(int n) {
        try {
            this.proxy.setExtLightSwitchOnSensitivity(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setExtLightDayLight(boolean bl) {
        try {
            this.proxy.setExtLightDayLight(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setExtLightHeadLightSystem(boolean bl) {
        try {
            this.proxy.setExtLightHeadLightSystem(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setExtLightGlidingLightSystem(boolean bl) {
        try {
            this.proxy.setExtLightGlidingLightSystem(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setExtLightAdaptive(boolean bl) {
        try {
            this.proxy.setExtLightAdaptive(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setExtLightTourist(boolean bl) {
        try {
            this.proxy.setExtLightTourist(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setExtLightMotorwayBlinking(MotorwayBlinkingSettings motorwayBlinkingSettings) {
        try {
            this.proxy.setExtLightMotorwayBlinking(motorwayBlinkingSettings);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setExtLightMaskedHighBeam(boolean bl) {
        try {
            this.proxy.setExtLightMaskedHighBeam(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setExtLightAutomaticLight(boolean bl, boolean bl2) {
        try {
            this.proxy.setExtLightAutomaticLight(bl, bl2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setExtLightSetFactoryDefault() {
        try {
            this.proxy.setExtLightSetFactoryDefault();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setExtLightLaserLight(boolean bl) {
        try {
            this.proxy.setExtLightLaserLight(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setExtLightSignatureLight(boolean bl) {
        try {
            this.proxy.setExtLightSignatureLight(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setExtLightHeadlightRange(int n) {
        try {
            this.proxy.setExtLightHeadlightRange(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setIntLightIlluminationSet(int n, int n2) {
        try {
            this.proxy.setIntLightIlluminationSet(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setIntLightColour(int n) {
        try {
            this.proxy.setIntLightColour(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setIntLightState(int n) {
        try {
            this.proxy.setIntLightState(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setIntLightEnvironment(boolean bl) {
        try {
            this.proxy.setIntLightEnvironment(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setIntLightSpeed(boolean bl) {
        try {
            this.proxy.setIntLightSpeed(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setIntLightTemperature(boolean bl) {
        try {
            this.proxy.setIntLightTemperature(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setIntLightBrightness(IntLightBrightness intLightBrightness) {
        try {
            this.proxy.setIntLightBrightness(intLightBrightness);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setIntLightSetFactoryDefault() {
        try {
            this.proxy.setIntLightSetFactoryDefault();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setIntLightIlluminationProfile(int n, int n2) {
        try {
            this.proxy.setIntLightIlluminationProfile(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setIntLightActiveProfile(int n) {
        try {
            this.proxy.setIntLightActiveProfile(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setIntLightAmbientLightColor(IntLightRGBValues intLightRGBValues) {
        try {
            this.proxy.setIntLightAmbientLightColor(intLightRGBValues);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setIntLightContourLightColor(IntLightRGBValues intLightRGBValues) {
        try {
            this.proxy.setIntLightContourLightColor(intLightRGBValues);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setIntLightFollowUpTime(int n) {
        try {
            this.proxy.setIntLightFollowUpTime(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setIntLightDoorContact(boolean bl) {
        try {
            this.proxy.setIntLightDoorContact(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestIntLightRGBColorList(IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo) {
        try {
            this.proxy.requestIntLightRGBColorList(intLightRGBColorListUpdateInfo);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNotification(int[] nArray) {
        try {
            this.proxy.setNotification(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNotification(int n) {
        try {
            this.proxy.setNotification(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNotification() {
        try {
            this.proxy.setNotification();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearNotification(int[] nArray) {
        try {
            this.proxy.clearNotification(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearNotification(int n) {
        try {
            this.proxy.clearNotification(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearNotification() {
        try {
            this.proxy.clearNotification();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void yySet(String string, String string2) {
        try {
            this.proxy.yySet(string, string2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
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

