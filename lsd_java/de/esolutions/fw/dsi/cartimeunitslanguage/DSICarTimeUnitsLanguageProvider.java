/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.cartimeunitslanguage;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.cartimeunitslanguage.DSICarTimeUnitsLanguageReply;
import de.esolutions.fw.comm.dsi.cartimeunitslanguage.impl.DSICarTimeUnitsLanguageProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockGPSSyncData;
import org.dsi.ifc.cartimeunitslanguage.ClockSummerTimeData;
import org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage;
import org.osgi.framework.BundleContext;

public class DSICarTimeUnitsLanguageProvider
extends AbstractProvider
implements DSICarTimeUnitsLanguage {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
    private DSICarTimeUnitsLanguageProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage;

    public DSICarTimeUnitsLanguageProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage == null ? (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage = DSICarTimeUnitsLanguageProvider.class$("org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage")) : class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSICarTimeUnitsLanguageProxy(this.instance, (DSICarTimeUnitsLanguageReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void setMenuLanguage(int n) {
        try {
            this.proxy.setMenuLanguage(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPressureUnit(int n) {
        try {
            this.proxy.setPressureUnit(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setVolumeUnit(int n) {
        try {
            this.proxy.setVolumeUnit(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setTemperatureUnit(int n) {
        try {
            this.proxy.setTemperatureUnit(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDistanceUnit(int n) {
        try {
            this.proxy.setDistanceUnit(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSpeedUnit(int n) {
        try {
            this.proxy.setSpeedUnit(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setConsumptionPetrolUnit(int n) {
        try {
            this.proxy.setConsumptionPetrolUnit(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setConsumptionGasUnit(int n) {
        try {
            this.proxy.setConsumptionGasUnit(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setConsumptionElectricUnit(int n) {
        try {
            this.proxy.setConsumptionElectricUnit(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setClockFormat(int n) {
        try {
            this.proxy.setClockFormat(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDateFormat(int n) {
        try {
            this.proxy.setDateFormat(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setClockDate(ClockDate clockDate) {
        try {
            this.proxy.setClockDate(clockDate);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setClockTime(byte by, byte by2, byte by3) {
        try {
            this.proxy.setClockTime(by, by2, by3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setClockSource(int n) {
        try {
            this.proxy.setClockSource(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setClockDayLightSaving(boolean bl) {
        try {
            this.proxy.setClockDayLightSaving(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setClockTimeZoneOffset(float f2) {
        try {
            this.proxy.setClockTimeZoneOffset(f2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setClockGPSSyncData(ClockGPSSyncData clockGPSSyncData) {
        try {
            this.proxy.setClockGPSSyncData(clockGPSSyncData);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setClockSummerTimeData(ClockSummerTimeData clockSummerTimeData) {
        try {
            this.proxy.setClockSummerTimeData(clockSummerTimeData);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setUmSetFactoryDefault() {
        try {
            this.proxy.setUmSetFactoryDefault();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSkin(int n) {
        try {
            this.proxy.setSkin(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setWeightUnit(int n) {
        try {
            this.proxy.setWeightUnit(n);
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

