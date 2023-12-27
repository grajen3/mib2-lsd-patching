/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.online;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.online.DSIOnlineServiceRegistrationReply;
import de.esolutions.fw.comm.dsi.online.impl.DSIOnlineServiceRegistrationProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.online.DSIOnlineServiceRegistration;
import org.dsi.ifc.online.OSRApplicationProperties;
import org.dsi.ifc.online.OSRDevice;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRUser;
import org.osgi.framework.BundleContext;

public class DSIOnlineServiceRegistrationProvider
extends AbstractProvider
implements DSIOnlineServiceRegistration {
    private static final int[] attributeIDs = new int[]{1, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    private DSIOnlineServiceRegistrationProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIOnlineServiceRegistration;

    public DSIOnlineServiceRegistrationProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$online$DSIOnlineServiceRegistration == null ? (class$org$dsi$ifc$online$DSIOnlineServiceRegistration = DSIOnlineServiceRegistrationProvider.class$("org.dsi.ifc.online.DSIOnlineServiceRegistration")) : class$org$dsi$ifc$online$DSIOnlineServiceRegistration).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIOnlineServiceRegistrationProxy(this.instance, (DSIOnlineServiceRegistrationReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void getOnlineApplicationList() {
        try {
            this.proxy.getOnlineApplicationList();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getOnlineApplication(String string) {
        try {
            this.proxy.getOnlineApplication(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setOnlineApplicationState(String string, int n) {
        try {
            this.proxy.setOnlineApplicationState(string, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void activateLicense(OSRLicense oSRLicense) {
        try {
            this.proxy.activateLicense(oSRLicense);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDemandState(String string, boolean bl) {
        try {
            this.proxy.setDemandState(string, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDemandStateServiceID(String string, boolean bl) {
        try {
            this.proxy.setDemandStateServiceID(string, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setApplicationProperties(String string, OSRApplicationProperties[] oSRApplicationPropertiesArray) {
        try {
            this.proxy.setApplicationProperties(string, oSRApplicationPropertiesArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void addOrUpdateApplicationProperty(String string, OSRApplicationProperties oSRApplicationProperties) {
        try {
            this.proxy.addOrUpdateApplicationProperty(string, oSRApplicationProperties);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setCredential(String string, String string2, String string3) {
        try {
            this.proxy.setCredential(string, string2, string3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void download(String string, String string2, String string3, long l, long l2) {
        try {
            this.proxy.download(string, string2, string3, l, l2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void downloadRaw(String string, String string2, String string3, long l, long l2) {
        try {
            this.proxy.downloadRaw(string, string2, string3, l, l2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void validateOwner(String string) {
        try {
            this.proxy.validateOwner(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void validateOwnerForce(boolean bl) {
        try {
            this.proxy.validateOwnerForce(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void checkOwnersVerification() {
        try {
            this.proxy.checkOwnersVerification();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void createUserWithPairingCode(String string, String string2) {
        try {
            this.proxy.createUserWithPairingCode(string, string2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void createUserWithUserPassword(String string, String string2, String string3) {
        try {
            this.proxy.createUserWithUserPassword(string, string2, string3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void checkPassword(OSRUser oSRUser, String string, boolean bl) {
        try {
            this.proxy.checkPassword(oSRUser, string, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void checkPairingCode(OSRUser oSRUser, String string, boolean bl) {
        try {
            this.proxy.checkPairingCode(oSRUser, string, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPrivacyFlags(OSRUser oSRUser, int n) {
        try {
            this.proxy.setPrivacyFlags(oSRUser, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAutoLogin(OSRUser oSRUser, OSRDevice[] oSRDeviceArray) {
        try {
            this.proxy.setAutoLogin(oSRUser, oSRDeviceArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void login(OSRUser oSRUser) {
        try {
            this.proxy.login(oSRUser);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void logout(OSRUser oSRUser) {
        try {
            this.proxy.logout(oSRUser);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void logoutAuthScheme(String string) {
        try {
            this.proxy.logoutAuthScheme(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getUsers(String string) {
        try {
            this.proxy.getUsers(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void removeUser(OSRUser oSRUser) {
        try {
            this.proxy.removeUser(oSRUser);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void performPortalRegistration(String string) {
        try {
            this.proxy.performPortalRegistration(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getLicense(String string) {
        try {
            this.proxy.getLicense(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getLicenses(boolean bl, boolean bl2) {
        try {
            this.proxy.getLicenses(bl, bl2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void precheckOnlineServiceServiceID(String string, String string2) {
        try {
            this.proxy.precheckOnlineServiceServiceID(string, string2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void precheckOnlineServiceSymbolicName(String string, String string2) {
        try {
            this.proxy.precheckOnlineServiceSymbolicName(string, string2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void precheckOnlineService(String string) {
        try {
            this.proxy.precheckOnlineService(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getProfileFolder(OSRUser oSRUser, String string) {
        try {
            this.proxy.getProfileFolder(oSRUser, string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getCredentialsFromHeader(int n, String[] stringArray) {
        try {
            this.proxy.getCredentialsFromHeader(n, stringArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getCredentialsFromAuthScheme(int n) {
        try {
            this.proxy.getCredentialsFromAuthScheme(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getServiceURL(String string) {
        try {
            this.proxy.getServiceURL(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void resetToFactorySettings(String string) {
        try {
            this.proxy.resetToFactorySettings(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setLanguage(String string) {
        try {
            this.proxy.setLanguage(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setServiceState(String string, int n) {
        try {
            this.proxy.setServiceState(string, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setServiceStateSymbolicName(String string, int n) {
        try {
            this.proxy.setServiceStateSymbolicName(string, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setActivePrivacyCategoryMask(int n) {
        try {
            this.proxy.setActivePrivacyCategoryMask(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void submitServiceStateChangesToBackend() {
        try {
            this.proxy.submitServiceStateChangesToBackend();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void profileChange(int n) {
        try {
            this.proxy.profileChange(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void profileCopy(int n, int n2) {
        try {
            this.proxy.profileCopy(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void profileReset(int n) {
        try {
            this.proxy.profileReset(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void profileResetAll() {
        try {
            this.proxy.profileResetAll();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setGPSUseMode(int n) {
        try {
            this.proxy.setGPSUseMode(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setInventoryFinished(boolean bl) {
        try {
            this.proxy.setInventoryFinished(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSPIN(String string, String string2, String string3) {
        try {
            this.proxy.setSPIN(string, string2, string3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getSPINHash(String string, String string2, int n, String string3) {
        try {
            this.proxy.getSPINHash(string, string2, n, string3);
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

