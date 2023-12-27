/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.comm.dsi.online.DSIOnlineServiceRegistrationReply;
import de.esolutions.fw.comm.dsi.online.impl.OSRApplicationSerializer;
import de.esolutions.fw.comm.dsi.online.impl.OSRDeviceSerializer;
import de.esolutions.fw.comm.dsi.online.impl.OSRLicenseSerializer;
import de.esolutions.fw.comm.dsi.online.impl.OSRNotifyPropertiesSLSerializer;
import de.esolutions.fw.comm.dsi.online.impl.OSRNotifyPropertiesSerializer;
import de.esolutions.fw.comm.dsi.online.impl.OSRServiceListEntrySerializer;
import de.esolutions.fw.comm.dsi.online.impl.OSRServiceRegistrationSerializer;
import de.esolutions.fw.comm.dsi.online.impl.OSRServiceStateSerializer;
import de.esolutions.fw.comm.dsi.online.impl.OSRUserSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.online.OSRApplication;
import org.dsi.ifc.online.OSRDevice;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRNotifyProperties;
import org.dsi.ifc.online.OSRNotifyPropertiesSL;
import org.dsi.ifc.online.OSRServiceListEntry;
import org.dsi.ifc.online.OSRServiceRegistration;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.OSRUser;

public class DSIOnlineServiceRegistrationReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.online.DSIOnlineServiceRegistration");
    private static int dynamicHandle = 0;
    private DSIOnlineServiceRegistrationReply p_DSIOnlineServiceRegistrationReply;

    public DSIOnlineServiceRegistrationReplyService(DSIOnlineServiceRegistrationReply dSIOnlineServiceRegistrationReply) {
        super(new ServiceInstanceID("ceacf065-fc29-5dbb-a102-cb462ad790ed", DSIOnlineServiceRegistrationReplyService.nextDynamicHandle(), "64105737-fd86-5dee-835d-34e9cf4b373f", "dsi.online.DSIOnlineServiceRegistration"));
        this.p_DSIOnlineServiceRegistrationReply = dSIOnlineServiceRegistrationReply;
    }

    private static synchronized int nextDynamicHandle() {
        int n = ++dynamicHandle;
        return n;
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 121: {
                    OSRApplication[] oSRApplicationArray = OSRApplicationSerializer.getOptionalOSRApplicationVarArray(iDeserializer);
                    this.p_DSIOnlineServiceRegistrationReply.getOnlineApplicationListResponse(oSRApplicationArray);
                    break;
                }
                case 122: {
                    OSRApplication oSRApplication = OSRApplicationSerializer.getOptionalOSRApplication(iDeserializer);
                    this.p_DSIOnlineServiceRegistrationReply.getOnlineApplicationResponse(oSRApplication);
                    break;
                }
                case 118: {
                    OSRLicense oSRLicense = OSRLicenseSerializer.getOptionalOSRLicense(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIOnlineServiceRegistrationReply.activateLicenseResponse(oSRLicense, n);
                    break;
                }
                case 24: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSIOnlineServiceRegistrationReply.setCredentialResponse(string, n);
                    break;
                }
                case 214: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    String string3 = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSIOnlineServiceRegistrationReply.downloadResponse(string, string2, string3, n);
                    break;
                }
                case 213: {
                    String string = iDeserializer.getOptionalString();
                    String string4 = iDeserializer.getOptionalString();
                    String string5 = iDeserializer.getOptionalString();
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIOnlineServiceRegistrationReply.downloadRawResponse(string, string4, string5, resourceLocator, n);
                    break;
                }
                case 36: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIOnlineServiceRegistrationReply.validateOwnerResponse(n);
                    break;
                }
                case 34: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIOnlineServiceRegistrationReply.checkOwnersVerificationResponse(n);
                    break;
                }
                case 149: {
                    String string = iDeserializer.getOptionalString();
                    OSRUser oSRUser = OSRUserSerializer.getOptionalOSRUser(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIOnlineServiceRegistrationReply.createUserWithPairingCodeResponse(string, oSRUser, n);
                    break;
                }
                case 150: {
                    String string = iDeserializer.getOptionalString();
                    OSRUser oSRUser = OSRUserSerializer.getOptionalOSRUser(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIOnlineServiceRegistrationReply.createUserWithUserPasswordResponse(string, oSRUser, n);
                    break;
                }
                case 148: {
                    OSRUser oSRUser = OSRUserSerializer.getOptionalOSRUser(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIOnlineServiceRegistrationReply.checkPasswordResponse(oSRUser, n);
                    break;
                }
                case 146: {
                    OSRUser oSRUser = OSRUserSerializer.getOptionalOSRUser(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIOnlineServiceRegistrationReply.checkPairingCodeResponse(oSRUser, n);
                    break;
                }
                case 170: {
                    OSRUser oSRUser = OSRUserSerializer.getOptionalOSRUser(iDeserializer);
                    this.p_DSIOnlineServiceRegistrationReply.setPrivacyFlagsResponse(oSRUser);
                    break;
                }
                case 168: {
                    OSRUser oSRUser = OSRUserSerializer.getOptionalOSRUser(iDeserializer);
                    OSRDevice[] oSRDeviceArray = OSRDeviceSerializer.getOptionalOSRDeviceVarArray(iDeserializer);
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    this.p_DSIOnlineServiceRegistrationReply.setAutoLoginResponse(oSRUser, oSRDeviceArray, nArray);
                    break;
                }
                case 155: {
                    OSRUser oSRUser = OSRUserSerializer.getOptionalOSRUser(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIOnlineServiceRegistrationReply.loginResponse(oSRUser, n);
                    break;
                }
                case 158: {
                    OSRUser oSRUser = OSRUserSerializer.getOptionalOSRUser(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIOnlineServiceRegistrationReply.logoutResponse(oSRUser, n);
                    break;
                }
                case 157: {
                    String string = iDeserializer.getOptionalString();
                    OSRUser[] oSRUserArray = OSRUserSerializer.getOptionalOSRUserVarArray(iDeserializer);
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    this.p_DSIOnlineServiceRegistrationReply.logoutAuthSchemeResult(string, oSRUserArray, nArray);
                    break;
                }
                case 153: {
                    OSRUser[] oSRUserArray = OSRUserSerializer.getOptionalOSRUserVarArray(iDeserializer);
                    this.p_DSIOnlineServiceRegistrationReply.getUsersResponse(oSRUserArray);
                    break;
                }
                case 166: {
                    OSRUser oSRUser = OSRUserSerializer.getOptionalOSRUser(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIOnlineServiceRegistrationReply.removeUserResponse(oSRUser, n);
                    break;
                }
                case 44: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSIOnlineServiceRegistrationReply.performPortalRegistrationResponse(string, n);
                    break;
                }
                case 183: {
                    String string = iDeserializer.getOptionalString();
                    OSRServiceState oSRServiceState = OSRServiceStateSerializer.getOptionalOSRServiceState(iDeserializer);
                    this.p_DSIOnlineServiceRegistrationReply.precheckOnlineServiceServiceIDResponse(string, oSRServiceState);
                    break;
                }
                case 184: {
                    String string = iDeserializer.getOptionalString();
                    OSRServiceState oSRServiceState = OSRServiceStateSerializer.getOptionalOSRServiceState(iDeserializer);
                    this.p_DSIOnlineServiceRegistrationReply.precheckOnlineServiceSymbolicNameResponse(string, oSRServiceState);
                    break;
                }
                case 182: {
                    String string = iDeserializer.getOptionalString();
                    OSRServiceState[] oSRServiceStateArray = OSRServiceStateSerializer.getOptionalOSRServiceStateVarArray(iDeserializer);
                    this.p_DSIOnlineServiceRegistrationReply.precheckOnlineServiceResponse(string, oSRServiceStateArray);
                    break;
                }
                case 119: {
                    int n = iDeserializer.getInt32();
                    OSRLicense oSRLicense = OSRLicenseSerializer.getOptionalOSRLicense(iDeserializer);
                    this.p_DSIOnlineServiceRegistrationReply.getLicenseResponse(n, oSRLicense);
                    break;
                }
                case 120: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    boolean bl2 = iDeserializer.getBool();
                    OSRLicense[] oSRLicenseArray = OSRLicenseSerializer.getOptionalOSRLicenseVarArray(iDeserializer);
                    this.p_DSIOnlineServiceRegistrationReply.getLicensesResponse(n, bl, bl2, oSRLicenseArray);
                    break;
                }
                case 152: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    OSRUser oSRUser = OSRUserSerializer.getOptionalOSRUser(iDeserializer);
                    String string6 = iDeserializer.getOptionalString();
                    this.p_DSIOnlineServiceRegistrationReply.getProfileFolderResponse(n, string, oSRUser, string6);
                    break;
                }
                case 91: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    String string7 = iDeserializer.getOptionalString();
                    String string8 = iDeserializer.getOptionalString();
                    this.p_DSIOnlineServiceRegistrationReply.getCredentialsFromHeaderResponse(n, n2, n3, string, string7, string8);
                    break;
                }
                case 89: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    String string9 = iDeserializer.getOptionalString();
                    String string10 = iDeserializer.getOptionalString();
                    this.p_DSIOnlineServiceRegistrationReply.getCredentialsFromAuthSchemeResponse(n, n4, string, string9, string10);
                    break;
                }
                case 93: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    String string11 = iDeserializer.getOptionalString();
                    this.p_DSIOnlineServiceRegistrationReply.getServiceURLResponse(n, string, string11);
                    break;
                }
                case 31: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSIOnlineServiceRegistrationReply.resetToFactorySettingsResponse(string, n);
                    break;
                }
                case 25: {
                    OSRNotifyProperties[] oSRNotifyPropertiesArray = OSRNotifyPropertiesSerializer.getOptionalOSRNotifyPropertiesVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIOnlineServiceRegistrationReply.updateApplicationState(oSRNotifyPropertiesArray, n);
                    break;
                }
                case 210: {
                    OSRNotifyPropertiesSL[] oSRNotifyPropertiesSLArray = OSRNotifyPropertiesSLSerializer.getOptionalOSRNotifyPropertiesSLVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIOnlineServiceRegistrationReply.updateServices(oSRNotifyPropertiesSLArray, n);
                    break;
                }
                case 171: {
                    OSRUser oSRUser = OSRUserSerializer.getOptionalOSRUser(iDeserializer);
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIOnlineServiceRegistrationReply.updateCoreProfileInfo(oSRUser, n, n5);
                    break;
                }
                case 172: {
                    String string = iDeserializer.getOptionalString();
                    OSRUser oSRUser = OSRUserSerializer.getOptionalOSRUser(iDeserializer);
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSIOnlineServiceRegistrationReply.updateExternalProfileInfo(string, oSRUser, n, n6);
                    break;
                }
                case 85: {
                    OSRDevice oSRDevice = OSRDeviceSerializer.getOptionalOSRDevice(iDeserializer);
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSIOnlineServiceRegistrationReply.updateDeviceEnumerator(oSRDevice, n, n7);
                    break;
                }
                case 173: {
                    int n = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSIOnlineServiceRegistrationReply.updateServiceState(n, n8);
                    break;
                }
                case 208: {
                    OSRServiceListEntry[] oSRServiceListEntryArray = OSRServiceListEntrySerializer.getOptionalOSRServiceListEntryVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIOnlineServiceRegistrationReply.updateServiceList(oSRServiceListEntryArray, n);
                    break;
                }
                case 209: {
                    String string = iDeserializer.getOptionalString();
                    OSRServiceRegistration oSRServiceRegistration = OSRServiceRegistrationSerializer.getOptionalOSRServiceRegistration(iDeserializer);
                    int n = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    this.p_DSIOnlineServiceRegistrationReply.updateServiceRegistration(string, oSRServiceRegistration, n, n9);
                    break;
                }
                case 202: {
                    OSRServiceState oSRServiceState = OSRServiceStateSerializer.getOptionalOSRServiceState(iDeserializer);
                    this.p_DSIOnlineServiceRegistrationReply.setServiceStateResponse(oSRServiceState);
                    break;
                }
                case 196: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSIOnlineServiceRegistrationReply.setDemandStateServiceIDResponse(string, n);
                    break;
                }
                case 204: {
                    OSRServiceState oSRServiceState = OSRServiceStateSerializer.getOptionalOSRServiceState(iDeserializer);
                    this.p_DSIOnlineServiceRegistrationReply.setServiceStateSymbolicNameResponse(oSRServiceState);
                    break;
                }
                case 194: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIOnlineServiceRegistrationReply.setActivePrivacyCategoryMaskResponse(n);
                    break;
                }
                case 206: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIOnlineServiceRegistrationReply.submitServiceStateChangesToBackendResponse(n);
                    break;
                }
                case 207: {
                    int n = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    this.p_DSIOnlineServiceRegistrationReply.updateProfileState(n, n10, n11);
                    break;
                }
                case 186: {
                    int n = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    this.p_DSIOnlineServiceRegistrationReply.profileChanged(n, n12);
                    break;
                }
                case 187: {
                    int n = iDeserializer.getInt32();
                    int n13 = iDeserializer.getInt32();
                    int n14 = iDeserializer.getInt32();
                    this.p_DSIOnlineServiceRegistrationReply.profileCopied(n, n13, n14);
                    break;
                }
                case 190: {
                    int n = iDeserializer.getInt32();
                    int n15 = iDeserializer.getInt32();
                    this.p_DSIOnlineServiceRegistrationReply.profileReset(n, n15);
                    break;
                }
                case 192: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIOnlineServiceRegistrationReply.profileResetAll(n);
                    break;
                }
                case 198: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIOnlineServiceRegistrationReply.setGPSUseModeResponse(n);
                    break;
                }
                case 200: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIOnlineServiceRegistrationReply.setInventoryFinishedResponse(n);
                    break;
                }
                case 219: {
                    String string = iDeserializer.getOptionalString();
                    String string12 = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSIOnlineServiceRegistrationReply.updateSPINRequired(string, string12, n);
                    break;
                }
                case 218: {
                    String string = iDeserializer.getOptionalString();
                    String string13 = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    int n16 = iDeserializer.getInt32();
                    this.p_DSIOnlineServiceRegistrationReply.setSPINResponse(string, string13, n, n16);
                    break;
                }
                case 216: {
                    String string = iDeserializer.getOptionalString();
                    String string14 = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    String string15 = iDeserializer.getOptionalString();
                    String string16 = iDeserializer.getOptionalString();
                    int n17 = iDeserializer.getInt32();
                    this.p_DSIOnlineServiceRegistrationReply.getSPINHashResult(string, string14, n, string15, string16, n17);
                    break;
                }
                case 19: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n18 = iDeserializer.getInt32();
                    this.p_DSIOnlineServiceRegistrationReply.asyncException(n, string, n18);
                    break;
                }
                case 27: {
                    String string = iDeserializer.getOptionalString();
                    String string17 = iDeserializer.getOptionalString();
                    this.p_DSIOnlineServiceRegistrationReply.yyIndication(string, string17);
                    break;
                }
                default: {
                    throw new MethodException(new StringBuffer().append("Invalid Method Id ").append(s).toString());
                }
            }
        }
        catch (SerializerException serializerException) {
            throw new MethodException(new StringBuffer().append("Deserialization failed: method=").append(s).append(", error=").append(serializerException.getMessage()).toString());
        }
    }
}

