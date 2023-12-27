/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephone;

import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.telephone.CFRequestData;
import org.dsi.ifc.telephone.Favorite;
import org.dsi.ifc.telephone.MailboxDialingNumber;

public interface DSITelephoneC {
    default public void acceptCall(int n) {
    }

    default public void hangupCall(int n) {
    }

    default public void swapCalls() {
    }

    default public void splitCall(short s) {
    }

    default public void joinCalls() {
    }

    default public void dialNumber(String string) {
    }

    default public void dialOperator(int n, String string) {
    }

    default public void dialNumberFromDBEntry(String string, long l, String string2, short s, short s2, ResourceLocator resourceLocator, int n, int n2) {
    }

    default public void sendDTMF(String string) {
    }

    default public void requestNetworkRegistration(String string, int n) {
    }

    default public void requestAbortNetworkRegistration() {
    }

    default public void requestNetworkSearch() {
    }

    default public void requestAbortNetworkSearch() {
    }

    default public void requestCallForward(CFRequestData[] cFRequestDataArray) {
    }

    default public void requestCallWaiting(int n) {
    }

    default public void requestCLIR(int n) {
    }

    default public void requestServiceCodeAbort() {
    }

    default public void requestSetAutomaticPinEntryActive(boolean bl) {
    }

    default public void requestSetAutomaticRedialActive(boolean bl) {
    }

    default public void requestSetCDMAThreeWayCallingSetting(boolean bl) {
    }

    default public void requestSetAutomaticEmergencyCallActive(boolean bl) {
    }

    default public void requestSetEnhancedPrivacyMode(boolean bl) {
    }

    default public void requestSetMailboxContent(MailboxDialingNumber[] mailboxDialingNumberArray) {
    }

    default public void requestSetPrivacyMode(boolean bl) {
    }

    default public void requestTelPower(int n) {
    }

    default public void requestUnlockSIM(int n, String string, String string2) {
    }

    default public void requestCheckSIMPINCode(String string) {
    }

    default public void requestChangeSIMCode(int n, String string, String string2) {
    }

    default public void requestSetHandsFreeMode(int n) {
    }

    default public void requestSetMICMuteState(int n) {
    }

    default public void requestSetLanguage(String string) {
    }

    default public void requestSIMPINRequired(String string, boolean bl) {
    }

    default public void restoreFactorySettings() {
    }

    default public void requestSetMicGainLevel(int n) {
    }

    default public void requestDecreaseMicGainLevel(short s) {
    }

    default public void requestIncreaseMicGainLevel(short s) {
    }

    default public void requestSetOptimizationMode(int n) {
    }

    default public void requestUnlockOtherSIM(int n, String string) {
    }

    default public void requestSetSIMAliases(String string, String string2) {
    }

    default public void requestSetNADMode(int n) {
    }

    default public void requestRemoveOtherSIM() {
    }

    default public void requestAbortAlternatePhoneActivity() {
    }

    default public void requestTogglePrioritizedPhoneDevice() {
    }

    default public void requestSetPhoneReminderSetting(boolean bl) {
    }

    default public void requestSetPrefixActivated(boolean bl) {
    }

    default public void requestSetPrefixContent(String string) {
    }

    default public void requestSetPhoneRingtone(int n, String string) {
    }

    default public void requestSetFavorites(Favorite[] favoriteArray) {
    }

    default public void requestSetSIMName(String string) {
    }

    default public void requestSetESIMActive(boolean bl) {
    }

    default public void setNotification(int[] nArray) {
    }

    default public void setNotification(int n) {
    }

    default public void setNotification() {
    }

    default public void clearNotification(int[] nArray) {
    }

    default public void clearNotification(int n) {
    }

    default public void clearNotification() {
    }

    default public void yySet(String string, String string2) {
    }
}

