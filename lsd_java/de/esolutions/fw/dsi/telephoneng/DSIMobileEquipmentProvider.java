/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.telephoneng;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.telephoneng.DSIMobileEquipmentReply;
import de.esolutions.fw.comm.dsi.telephoneng.impl.DSIMobileEquipmentProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.telephoneng.CFRequestData;
import org.dsi.ifc.telephoneng.DSIMobileEquipment;
import org.dsi.ifc.telephoneng.Favorite;
import org.dsi.ifc.telephoneng.MailboxDialingNumber;
import org.osgi.framework.BundleContext;

public class DSIMobileEquipmentProvider
extends AbstractProvider
implements DSIMobileEquipment {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54};
    private DSIMobileEquipmentProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$DSIMobileEquipment;

    public DSIMobileEquipmentProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$telephoneng$DSIMobileEquipment == null ? (class$org$dsi$ifc$telephoneng$DSIMobileEquipment = DSIMobileEquipmentProvider.class$("org.dsi.ifc.telephoneng.DSIMobileEquipment")) : class$org$dsi$ifc$telephoneng$DSIMobileEquipment).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIMobileEquipmentProxy(this.instance, (DSIMobileEquipmentReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void acceptCall(int n) {
        try {
            this.proxy.acceptCall(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void hangupCall(int n) {
        try {
            this.proxy.hangupCall(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void swapCalls() {
        try {
            this.proxy.swapCalls();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void splitCall(short s) {
        try {
            this.proxy.splitCall(s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void joinCalls() {
        try {
            this.proxy.joinCalls();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void dialNumber(String string) {
        try {
            this.proxy.dialNumber(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void dialOperator(int n, String string) {
        try {
            this.proxy.dialOperator(n, string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void dialNumberFromDBEntry(String string, long l, String string2, short s, short s2, ResourceLocator resourceLocator, int n, int n2) {
        try {
            this.proxy.dialNumberFromDBEntry(string, l, string2, s, s2, resourceLocator, n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void sendDTMF(String string) {
        try {
            this.proxy.sendDTMF(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestNetworkRegistration(String string, int n) {
        try {
            this.proxy.requestNetworkRegistration(string, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestAbortNetworkRegistration() {
        try {
            this.proxy.requestAbortNetworkRegistration();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestNetworkSearch() {
        try {
            this.proxy.requestNetworkSearch();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestAbortNetworkSearch() {
        try {
            this.proxy.requestAbortNetworkSearch();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestCallForward(CFRequestData[] cFRequestDataArray) {
        try {
            this.proxy.requestCallForward(cFRequestDataArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestCallWaiting(int n) {
        try {
            this.proxy.requestCallWaiting(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestCLIR(int n) {
        try {
            this.proxy.requestCLIR(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestServiceCodeAbort() {
        try {
            this.proxy.requestServiceCodeAbort();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSetAutomaticPinEntryActive(boolean bl) {
        try {
            this.proxy.requestSetAutomaticPinEntryActive(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSetAutomaticRedialActive(boolean bl) {
        try {
            this.proxy.requestSetAutomaticRedialActive(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSetCDMAThreeWayCallingSetting(boolean bl) {
        try {
            this.proxy.requestSetCDMAThreeWayCallingSetting(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSetAutomaticEmergencyCallActive(boolean bl) {
        try {
            this.proxy.requestSetAutomaticEmergencyCallActive(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSetEnhancedPrivacyMode(boolean bl) {
        try {
            this.proxy.requestSetEnhancedPrivacyMode(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSetMailboxContent(MailboxDialingNumber[] mailboxDialingNumberArray) {
        try {
            this.proxy.requestSetMailboxContent(mailboxDialingNumberArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSetPrivacyMode(boolean bl) {
        try {
            this.proxy.requestSetPrivacyMode(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestTelPower(int n) {
        try {
            this.proxy.requestTelPower(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestUnlockSIM(int n, String string, String string2) {
        try {
            this.proxy.requestUnlockSIM(n, string, string2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestCheckSIMPINCode(String string) {
        try {
            this.proxy.requestCheckSIMPINCode(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestChangeSIMCode(int n, String string, String string2) {
        try {
            this.proxy.requestChangeSIMCode(n, string, string2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSetHandsFreeMode(int n) {
        try {
            this.proxy.requestSetHandsFreeMode(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSetMICMuteState(int n) {
        try {
            this.proxy.requestSetMICMuteState(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSetLanguage(String string) {
        try {
            this.proxy.requestSetLanguage(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSIMPINRequired(String string, boolean bl) {
        try {
            this.proxy.requestSIMPINRequired(string, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void restoreFactorySettings() {
        try {
            this.proxy.restoreFactorySettings();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSetMicGainLevel(int n) {
        try {
            this.proxy.requestSetMicGainLevel(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestDecreaseMicGainLevel(short s) {
        try {
            this.proxy.requestDecreaseMicGainLevel(s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestIncreaseMicGainLevel(short s) {
        try {
            this.proxy.requestIncreaseMicGainLevel(s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSetOptimizationMode(int n) {
        try {
            this.proxy.requestSetOptimizationMode(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestUnlockOtherSIM(int n, String string) {
        try {
            this.proxy.requestUnlockOtherSIM(n, string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSetSIMAliases(String string, String string2) {
        try {
            this.proxy.requestSetSIMAliases(string, string2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSetNADMode(int n) {
        try {
            this.proxy.requestSetNADMode(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestRemoveOtherSIM() {
        try {
            this.proxy.requestRemoveOtherSIM();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSetPhoneReminderSetting(boolean bl) {
        try {
            this.proxy.requestSetPhoneReminderSetting(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSetPrefixActivated(boolean bl) {
        try {
            this.proxy.requestSetPrefixActivated(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSetPrefixContent(String string) {
        try {
            this.proxy.requestSetPrefixContent(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSetPhoneRingtone(int n, String string) {
        try {
            this.proxy.requestSetPhoneRingtone(n, string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSetFavorites(Favorite[] favoriteArray) {
        try {
            this.proxy.requestSetFavorites(favoriteArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSetSIMName(String string) {
        try {
            this.proxy.requestSetSIMName(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSetESIMActive(boolean bl) {
        try {
            this.proxy.requestSetESIMActive(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void deleteCallstacksAll(int n) {
        try {
            this.proxy.deleteCallstacksAll(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void deleteCallstacksEntry(int n, int n2) {
        try {
            this.proxy.deleteCallstacksEntry(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void resetMissedCallIndicator() {
        try {
            this.proxy.resetMissedCallIndicator();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void revertCallstacks(boolean bl) {
        try {
            this.proxy.revertCallstacks(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestStartSpeechRecognition() {
        try {
            this.proxy.requestStartSpeechRecognition();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestStopSpeechRecognition() {
        try {
            this.proxy.requestStopSpeechRecognition();
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

