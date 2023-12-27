/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.carseat;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carseat.DSICarSeatReply;
import de.esolutions.fw.comm.dsi.carseat.impl.DSICarSeatProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.carseat.DSICarSeat;
import org.dsi.ifc.carseat.MassageData;
import org.dsi.ifc.carseat.SeatAdjustment;
import org.dsi.ifc.carseat.SeatContent;
import org.dsi.ifc.carseat.SeatPneumaticContent;
import org.dsi.ifc.carseat.SeatSpecialPosition;
import org.dsi.ifc.carseat.SwitcherDataBackForward;
import org.dsi.ifc.carseat.SwitcherDataUpDown;
import org.osgi.framework.BundleContext;

public class DSICarSeatProvider
extends AbstractProvider
implements DSICarSeat {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68};
    private DSICarSeatProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$carseat$DSICarSeat;

    public DSICarSeatProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$carseat$DSICarSeat == null ? (class$org$dsi$ifc$carseat$DSICarSeat = DSICarSeatProvider.class$("org.dsi.ifc.carseat.DSICarSeat")) : class$org$dsi$ifc$carseat$DSICarSeat).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSICarSeatProxy(this.instance, (DSICarSeatReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void setSeatRadioKeyAutomatic(boolean bl) {
        try {
            this.proxy.setSeatRadioKeyAutomatic(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSeatCodriverSettingsFromRear(boolean bl) {
        try {
            this.proxy.setSeatCodriverSettingsFromRear(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSeatCodriverSettingsFromDriver(boolean bl) {
        try {
            this.proxy.setSeatCodriverSettingsFromDriver(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSeatEasyEntryFrontLeft(boolean bl) {
        try {
            this.proxy.setSeatEasyEntryFrontLeft(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSeatEasyEntryFrontRight(boolean bl) {
        try {
            this.proxy.setSeatEasyEntryFrontRight(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSeatEasyEntryRearLeft(boolean bl) {
        try {
            this.proxy.setSeatEasyEntryRearLeft(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSeatEasyEntryRearRight(boolean bl) {
        try {
            this.proxy.setSeatEasyEntryRearRight(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSeatSpecialPosition(SeatSpecialPosition seatSpecialPosition) {
        try {
            this.proxy.setSeatSpecialPosition(seatSpecialPosition);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSeatSpecialPositionRearCoDriver(SeatSpecialPosition seatSpecialPosition) {
        try {
            this.proxy.setSeatSpecialPositionRearCoDriver(seatSpecialPosition);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void showSeatPopup(SeatContent seatContent) {
        try {
            this.proxy.showSeatPopup(seatContent);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void cancelSeatPopup(SeatContent seatContent, int n) {
        try {
            this.proxy.cancelSeatPopup(seatContent, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSeatHMIIsReady(boolean bl) {
        try {
            this.proxy.setSeatHMIIsReady(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSeatPneumaticCodriverSettingsFromDriver(boolean bl) {
        try {
            this.proxy.setSeatPneumaticCodriverSettingsFromDriver(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void showSeatPneumaticPopup(SeatPneumaticContent seatPneumaticContent) {
        try {
            this.proxy.showSeatPneumaticPopup(seatPneumaticContent);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void cancelSeatPneumaticPopup(SeatPneumaticContent seatPneumaticContent, int n) {
        try {
            this.proxy.cancelSeatPneumaticPopup(seatPneumaticContent, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSeatSetFactoryDefault() {
        try {
            this.proxy.setSeatSetFactoryDefault();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSeatPneumaticSetFactoryDefault() {
        try {
            this.proxy.setSeatPneumaticSetFactoryDefault();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void startSeatMoveRearSeatDisplay() {
        try {
            this.proxy.startSeatMoveRearSeatDisplay();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void abortSeatMoveRearSeatDisplay() {
        try {
            this.proxy.abortSeatMoveRearSeatDisplay();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSeatMassageData(int n, MassageData massageData) {
        try {
            this.proxy.setSeatMassageData(n, massageData);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSeatSwitcherDataUp(int n, SwitcherDataUpDown switcherDataUpDown) {
        try {
            this.proxy.setSeatSwitcherDataUp(n, switcherDataUpDown);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSeatSwitcherDataDown(int n, SwitcherDataUpDown switcherDataUpDown) {
        try {
            this.proxy.setSeatSwitcherDataDown(n, switcherDataUpDown);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSeatSwitcherDataForward(int n, SwitcherDataBackForward switcherDataBackForward) {
        try {
            this.proxy.setSeatSwitcherDataForward(n, switcherDataBackForward);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSeatSwitcherDataBack(int n, SwitcherDataBackForward switcherDataBackForward) {
        try {
            this.proxy.setSeatSwitcherDataBack(n, switcherDataBackForward);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSeatAdjustment(int n, SeatAdjustment seatAdjustment) {
        try {
            this.proxy.setSeatAdjustment(n, seatAdjustment);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void startSeatDeleteSpecialPosition(boolean bl, boolean bl2) {
        try {
            this.proxy.startSeatDeleteSpecialPosition(bl, bl2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSeatCoDriverSettingsFromRearActivation(boolean bl) {
        try {
            this.proxy.setSeatCoDriverSettingsFromRearActivation(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSeatFoldHeadRestRearDriver(boolean bl) {
        try {
            this.proxy.setSeatFoldHeadRestRearDriver(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSeatFoldHeadRestRearCoDriver(boolean bl) {
        try {
            this.proxy.setSeatFoldHeadRestRearCoDriver(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSeatStopButton(int n, boolean bl) {
        try {
            this.proxy.setSeatStopButton(n, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSeatPremiumMassageData(int n, MassageData massageData) {
        try {
            this.proxy.setSeatPremiumMassageData(n, massageData);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSeatPremiumMassageSwitcher(int n, boolean bl) {
        try {
            this.proxy.setSeatPremiumMassageSwitcher(n, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSeatMassageSwitcher(int n, boolean bl) {
        try {
            this.proxy.setSeatMassageSwitcher(n, bl);
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

