/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.ddp20;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.ddp20.DSIDDP20Reply;
import de.esolutions.fw.comm.dsi.ddp20.impl.DSIDDP20Proxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.ddp20.DSIDDP20;
import org.dsi.ifc.ddp20.DisplayRequest;
import org.dsi.ifc.ddp20.UpdateRequest;
import org.osgi.framework.BundleContext;

public class DSIDDP20Provider
extends AbstractProvider
implements DSIDDP20 {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4};
    private DSIDDP20Proxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$ddp20$DSIDDP20;

    public DSIDDP20Provider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$ddp20$DSIDDP20 == null ? (class$org$dsi$ifc$ddp20$DSIDDP20 = DSIDDP20Provider.class$("org.dsi.ifc.ddp20.DSIDDP20")) : class$org$dsi$ifc$ddp20$DSIDDP20).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIDDP20Proxy(this.instance, (DSIDDP20Reply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void getDisplayStatus() {
        try {
            this.proxy.getDisplayStatus();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setHMIState(int n, int n2, int n3) {
        try {
            this.proxy.setHMIState(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNaviState(int n, int n2) {
        try {
            this.proxy.setNaviState(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMediaState(int n) {
        try {
            this.proxy.setMediaState(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPhoneState(int n, int n2, int n3) {
        try {
            this.proxy.setPhoneState(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setFrameStatus(DisplayRequest displayRequest) {
        try {
            this.proxy.setFrameStatus(displayRequest);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setFrameUpdate(UpdateRequest updateRequest) {
        try {
            this.proxy.setFrameUpdate(updateRequest);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setManeuver(int n, short[] sArray, boolean bl) {
        try {
            this.proxy.setManeuver(n, sArray, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setCompass(int n, short[] sArray, boolean bl) {
        try {
            this.proxy.setCompass(n, sArray, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDistanceBar(int n, int n2, boolean bl, boolean bl2) {
        try {
            this.proxy.setDistanceBar(n, n2, bl, bl2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDeviationBar(int n, int n2, boolean bl, boolean bl2) {
        try {
            this.proxy.setDeviationBar(n, n2, bl, bl2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setText(int n, int n2, String string, int n3, boolean bl) {
        try {
            this.proxy.setText(n, n2, string, n3, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setTextStyle(int n, int n2, int n3, int n4, boolean bl) {
        try {
            this.proxy.setTextStyle(n, n2, n3, n4, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setColor(int n, int n2, int[] nArray, boolean bl) {
        try {
            this.proxy.setColor(n, n2, nArray, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setCursor(int n, int n2, int n3, int n4, int n5, boolean bl) {
        try {
            this.proxy.setCursor(n, n2, n3, n4, n5, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setTrafficSign(int n, int n2, int n3, int n4, boolean bl) {
        try {
            this.proxy.setTrafficSign(n, n2, n3, n4, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setLaneGuidanceHeader(int n, int n2, int n3, int n4, int n5, boolean bl) {
        try {
            this.proxy.setLaneGuidanceHeader(n, n2, n3, n4, n5, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setLaneGuidanceData(int n, int n2, int n3, int n4, short[] sArray, boolean bl) {
        try {
            this.proxy.setLaneGuidanceData(n, n2, n3, n4, sArray, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setCodePage(int n) {
        try {
            this.proxy.setCodePage(n);
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

