/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.cardrivingcharacteristics;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.DSICarDrivingCharacteristicsReply;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.DSICarDrivingCharacteristicsProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.cardrivingcharacteristics.CharismaListUpdateInfo;
import org.dsi.ifc.cardrivingcharacteristics.CharismaProgButton;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics;
import org.dsi.ifc.cardrivingcharacteristics.TADMaxMinAngleReset;
import org.osgi.framework.BundleContext;

public class DSICarDrivingCharacteristicsProvider
extends AbstractProvider
implements DSICarDrivingCharacteristics {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 46, 47, 48, 49, 50, 51, 52, 12, 13, 14, 15, 16, 17, 18, 45, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44};
    private DSICarDrivingCharacteristicsProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics;

    public DSICarDrivingCharacteristicsProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics == null ? (class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics = DSICarDrivingCharacteristicsProvider.class$("org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics")) : class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSICarDrivingCharacteristicsProxy(this.instance, (DSICarDrivingCharacteristicsReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void setSuspensionControlLiftMode(boolean bl) {
        try {
            this.proxy.setSuspensionControlLiftMode(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSuspensionControlCarJackMode(boolean bl) {
        try {
            this.proxy.setSuspensionControlCarJackMode(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSuspensionControlTrailerMode(boolean bl) {
        try {
            this.proxy.setSuspensionControlTrailerMode(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSuspensionControlLoadingMode(boolean bl) {
        try {
            this.proxy.setSuspensionControlLoadingMode(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSuspensionControlActiveProfile(int n) {
        try {
            this.proxy.setSuspensionControlActiveProfile(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSuspensionControlSnowChainMode(boolean bl) {
        try {
            this.proxy.setSuspensionControlSnowChainMode(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSuspensionControlActiveMode(int n) {
        try {
            this.proxy.setSuspensionControlActiveMode(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void seteABCEasyEntry(boolean bl) {
        try {
            this.proxy.seteABCEasyEntry(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void seteABCPitchControl(boolean bl) {
        try {
            this.proxy.seteABCPitchControl(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void seteABCSpecialPosition(boolean bl) {
        try {
            this.proxy.seteABCSpecialPosition(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void seteABCPreview(int n) {
        try {
            this.proxy.seteABCPreview(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setCharismaActiveProfile(int n) {
        try {
            this.proxy.setCharismaActiveProfile(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setCharismaActiveOperationMode(int n) {
        try {
            this.proxy.setCharismaActiveOperationMode(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setCharismaTrailerSetting(boolean bl) {
        try {
            this.proxy.setCharismaTrailerSetting(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setCharismaProgButton(CharismaProgButton charismaProgButton) {
        try {
            this.proxy.setCharismaProgButton(charismaProgButton);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestCharismaProfileFunction(int n, CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray) {
        try {
            this.proxy.requestCharismaProfileFunction(n, charismaSetupTableWithoutOptionMaskArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestCharismaList(CharismaListUpdateInfo charismaListUpdateInfo) {
        try {
            this.proxy.requestCharismaList(charismaListUpdateInfo);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void showCharismaPopup(int n, int n2) {
        try {
            this.proxy.showCharismaPopup(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void cancelCharismaPopup(int n, int n2) {
        try {
            this.proxy.cancelCharismaPopup(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setCharismaSetFactoryDefault() {
        try {
            this.proxy.setCharismaSetFactoryDefault();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setCharismaSound(boolean bl) {
        try {
            this.proxy.setCharismaSound(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void showTADPopup(int n, int n2) {
        try {
            this.proxy.showTADPopup(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void cancelTADPopup(int n, int n2) {
        try {
            this.proxy.cancelTADPopup(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setTADSetFactoryDefault() {
        try {
            this.proxy.setTADSetFactoryDefault();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setTADMaxMinAngleReset(TADMaxMinAngleReset tADMaxMinAngleReset) {
        try {
            this.proxy.setTADMaxMinAngleReset(tADMaxMinAngleReset);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setHMIIsReady(boolean bl) {
        try {
            this.proxy.setHMIIsReady(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSpoilerSetFactoryDefault() {
        try {
            this.proxy.setSpoilerSetFactoryDefault();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSpoilerPositionSelection(int n) {
        try {
            this.proxy.setSpoilerPositionSelection(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSpoilerActuation(boolean bl) {
        try {
            this.proxy.setSpoilerActuation(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSpoilerSystemOnOff(boolean bl) {
        try {
            this.proxy.setSpoilerSystemOnOff(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSoundSetFactoryDefault() {
        try {
            this.proxy.setSoundSetFactoryDefault();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSoundStyle(int n) {
        try {
            this.proxy.setSoundStyle(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSoundSystemOnOff(boolean bl) {
        try {
            this.proxy.setSoundSystemOnOff(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSoundOnOff(boolean bl) {
        try {
            this.proxy.setSoundOnOff(bl);
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

