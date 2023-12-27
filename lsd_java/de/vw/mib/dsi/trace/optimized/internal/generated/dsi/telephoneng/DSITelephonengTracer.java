/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.telephoneng;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.telephoneng.ActivationStateStruct;
import org.dsi.ifc.telephoneng.CFRequestData;
import org.dsi.ifc.telephoneng.CFResponseData;
import org.dsi.ifc.telephoneng.CallDuration;
import org.dsi.ifc.telephoneng.CallInformation;
import org.dsi.ifc.telephoneng.CallInformationExt;
import org.dsi.ifc.telephoneng.CallStackEntry;
import org.dsi.ifc.telephoneng.DisconnectReason;
import org.dsi.ifc.telephoneng.EmergencyCallSetting;
import org.dsi.ifc.telephoneng.EmergencyNumbers;
import org.dsi.ifc.telephoneng.Favorite;
import org.dsi.ifc.telephoneng.LockStateStruct;
import org.dsi.ifc.telephoneng.MailboxDialingNumber;
import org.dsi.ifc.telephoneng.MissedCallIndicator;
import org.dsi.ifc.telephoneng.NADTemperatureStruct;
import org.dsi.ifc.telephoneng.NetworkProvider;
import org.dsi.ifc.telephoneng.NetworkProviderName;
import org.dsi.ifc.telephoneng.PhoneInformation;
import org.dsi.ifc.telephoneng.RegisterStateStruct;
import org.dsi.ifc.telephoneng.SIMAliasInformation;
import org.dsi.ifc.telephoneng.ServiceCodeTypeStruct;
import org.dsi.ifc.telephoneng.ServiceNumbers;
import org.dsi.ifc.telephoneng.ServiceProvider;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

public final class DSITelephonengTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_ACTIVATIONSTATESTRUCT;
    private static final int ID_CFREQUESTDATA;
    private static final int ID_CFRESPONSEDATA;
    private static final int ID_CALLDURATION;
    private static final int ID_CALLINFORMATION;
    private static final int ID_CALLINFORMATIONEXT;
    private static final int ID_CALLSTACKENTRY;
    private static final int ID_DISCONNECTREASON;
    private static final int ID_EMERGENCYCALLSETTING;
    private static final int ID_EMERGENCYNUMBERS;
    private static final int ID_FAVORITE;
    private static final int ID_LOCKSTATESTRUCT;
    private static final int ID_MAILBOXDIALINGNUMBER;
    private static final int ID_MISSEDCALLINDICATOR;
    private static final int ID_NADTEMPERATURESTRUCT;
    private static final int ID_NETWORKPROVIDER;
    private static final int ID_NETWORKPROVIDERNAME;
    private static final int ID_PHONEINFORMATION;
    private static final int ID_REGISTERSTATESTRUCT;
    private static final int ID_SIMALIASINFORMATION;
    private static final int ID_SERVICECODETYPESTRUCT;
    private static final int ID_SERVICENUMBERS;
    private static final int ID_SERVICEPROVIDER;
    private static final int ID_SUPPSERVICERESPONSESTRUCT;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$ActivationStateStruct;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$CFRequestData;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$CFResponseData;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$CallDuration;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$CallInformation;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$CallInformationExt;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$CallStackEntry;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$DisconnectReason;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$EmergencyCallSetting;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$EmergencyNumbers;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$Favorite;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$LockStateStruct;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$MailboxDialingNumber;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$MissedCallIndicator;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$NADTemperatureStruct;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$NetworkProvider;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$NetworkProviderName;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$PhoneInformation;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$RegisterStateStruct;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$SIMAliasInformation;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$ServiceCodeTypeStruct;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$ServiceNumbers;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$ServiceProvider;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$SuppServiceResponseStruct;

    public DSITelephonengTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephoneng$ActivationStateStruct == null ? (class$org$dsi$ifc$telephoneng$ActivationStateStruct = DSITelephonengTracer.class$("org.dsi.ifc.telephoneng.ActivationStateStruct")) : class$org$dsi$ifc$telephoneng$ActivationStateStruct, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephoneng$CFRequestData == null ? (class$org$dsi$ifc$telephoneng$CFRequestData = DSITelephonengTracer.class$("org.dsi.ifc.telephoneng.CFRequestData")) : class$org$dsi$ifc$telephoneng$CFRequestData, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephoneng$CFResponseData == null ? (class$org$dsi$ifc$telephoneng$CFResponseData = DSITelephonengTracer.class$("org.dsi.ifc.telephoneng.CFResponseData")) : class$org$dsi$ifc$telephoneng$CFResponseData, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephoneng$CallDuration == null ? (class$org$dsi$ifc$telephoneng$CallDuration = DSITelephonengTracer.class$("org.dsi.ifc.telephoneng.CallDuration")) : class$org$dsi$ifc$telephoneng$CallDuration, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephoneng$CallInformation == null ? (class$org$dsi$ifc$telephoneng$CallInformation = DSITelephonengTracer.class$("org.dsi.ifc.telephoneng.CallInformation")) : class$org$dsi$ifc$telephoneng$CallInformation, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephoneng$CallInformationExt == null ? (class$org$dsi$ifc$telephoneng$CallInformationExt = DSITelephonengTracer.class$("org.dsi.ifc.telephoneng.CallInformationExt")) : class$org$dsi$ifc$telephoneng$CallInformationExt, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephoneng$CallStackEntry == null ? (class$org$dsi$ifc$telephoneng$CallStackEntry = DSITelephonengTracer.class$("org.dsi.ifc.telephoneng.CallStackEntry")) : class$org$dsi$ifc$telephoneng$CallStackEntry, 7);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephoneng$DisconnectReason == null ? (class$org$dsi$ifc$telephoneng$DisconnectReason = DSITelephonengTracer.class$("org.dsi.ifc.telephoneng.DisconnectReason")) : class$org$dsi$ifc$telephoneng$DisconnectReason, 8);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephoneng$EmergencyCallSetting == null ? (class$org$dsi$ifc$telephoneng$EmergencyCallSetting = DSITelephonengTracer.class$("org.dsi.ifc.telephoneng.EmergencyCallSetting")) : class$org$dsi$ifc$telephoneng$EmergencyCallSetting, 9);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephoneng$EmergencyNumbers == null ? (class$org$dsi$ifc$telephoneng$EmergencyNumbers = DSITelephonengTracer.class$("org.dsi.ifc.telephoneng.EmergencyNumbers")) : class$org$dsi$ifc$telephoneng$EmergencyNumbers, 10);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephoneng$Favorite == null ? (class$org$dsi$ifc$telephoneng$Favorite = DSITelephonengTracer.class$("org.dsi.ifc.telephoneng.Favorite")) : class$org$dsi$ifc$telephoneng$Favorite, 11);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephoneng$LockStateStruct == null ? (class$org$dsi$ifc$telephoneng$LockStateStruct = DSITelephonengTracer.class$("org.dsi.ifc.telephoneng.LockStateStruct")) : class$org$dsi$ifc$telephoneng$LockStateStruct, 12);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephoneng$MailboxDialingNumber == null ? (class$org$dsi$ifc$telephoneng$MailboxDialingNumber = DSITelephonengTracer.class$("org.dsi.ifc.telephoneng.MailboxDialingNumber")) : class$org$dsi$ifc$telephoneng$MailboxDialingNumber, 13);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephoneng$MissedCallIndicator == null ? (class$org$dsi$ifc$telephoneng$MissedCallIndicator = DSITelephonengTracer.class$("org.dsi.ifc.telephoneng.MissedCallIndicator")) : class$org$dsi$ifc$telephoneng$MissedCallIndicator, 14);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephoneng$NADTemperatureStruct == null ? (class$org$dsi$ifc$telephoneng$NADTemperatureStruct = DSITelephonengTracer.class$("org.dsi.ifc.telephoneng.NADTemperatureStruct")) : class$org$dsi$ifc$telephoneng$NADTemperatureStruct, 15);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephoneng$NetworkProvider == null ? (class$org$dsi$ifc$telephoneng$NetworkProvider = DSITelephonengTracer.class$("org.dsi.ifc.telephoneng.NetworkProvider")) : class$org$dsi$ifc$telephoneng$NetworkProvider, 16);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephoneng$NetworkProviderName == null ? (class$org$dsi$ifc$telephoneng$NetworkProviderName = DSITelephonengTracer.class$("org.dsi.ifc.telephoneng.NetworkProviderName")) : class$org$dsi$ifc$telephoneng$NetworkProviderName, 17);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephoneng$PhoneInformation == null ? (class$org$dsi$ifc$telephoneng$PhoneInformation = DSITelephonengTracer.class$("org.dsi.ifc.telephoneng.PhoneInformation")) : class$org$dsi$ifc$telephoneng$PhoneInformation, 18);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephoneng$RegisterStateStruct == null ? (class$org$dsi$ifc$telephoneng$RegisterStateStruct = DSITelephonengTracer.class$("org.dsi.ifc.telephoneng.RegisterStateStruct")) : class$org$dsi$ifc$telephoneng$RegisterStateStruct, 19);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephoneng$SIMAliasInformation == null ? (class$org$dsi$ifc$telephoneng$SIMAliasInformation = DSITelephonengTracer.class$("org.dsi.ifc.telephoneng.SIMAliasInformation")) : class$org$dsi$ifc$telephoneng$SIMAliasInformation, 20);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephoneng$ServiceCodeTypeStruct == null ? (class$org$dsi$ifc$telephoneng$ServiceCodeTypeStruct = DSITelephonengTracer.class$("org.dsi.ifc.telephoneng.ServiceCodeTypeStruct")) : class$org$dsi$ifc$telephoneng$ServiceCodeTypeStruct, 21);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephoneng$ServiceNumbers == null ? (class$org$dsi$ifc$telephoneng$ServiceNumbers = DSITelephonengTracer.class$("org.dsi.ifc.telephoneng.ServiceNumbers")) : class$org$dsi$ifc$telephoneng$ServiceNumbers, 22);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephoneng$ServiceProvider == null ? (class$org$dsi$ifc$telephoneng$ServiceProvider = DSITelephonengTracer.class$("org.dsi.ifc.telephoneng.ServiceProvider")) : class$org$dsi$ifc$telephoneng$ServiceProvider, 23);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephoneng$SuppServiceResponseStruct == null ? (class$org$dsi$ifc$telephoneng$SuppServiceResponseStruct = DSITelephonengTracer.class$("org.dsi.ifc.telephoneng.SuppServiceResponseStruct")) : class$org$dsi$ifc$telephoneng$SuppServiceResponseStruct, 24);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceActivationStateStruct(printWriter, (ActivationStateStruct)object);
                break;
            }
            case 2: {
                this.traceCFRequestData(printWriter, (CFRequestData)object);
                break;
            }
            case 3: {
                this.traceCFResponseData(printWriter, (CFResponseData)object);
                break;
            }
            case 4: {
                this.traceCallDuration(printWriter, (CallDuration)object);
                break;
            }
            case 5: {
                this.traceCallInformation(printWriter, (CallInformation)object);
                break;
            }
            case 6: {
                this.traceCallInformationExt(printWriter, (CallInformationExt)object);
                break;
            }
            case 7: {
                this.traceCallStackEntry(printWriter, (CallStackEntry)object);
                break;
            }
            case 8: {
                this.traceDisconnectReason(printWriter, (DisconnectReason)object);
                break;
            }
            case 9: {
                this.traceEmergencyCallSetting(printWriter, (EmergencyCallSetting)object);
                break;
            }
            case 10: {
                this.traceEmergencyNumbers(printWriter, (EmergencyNumbers)object);
                break;
            }
            case 11: {
                this.traceFavorite(printWriter, (Favorite)object);
                break;
            }
            case 12: {
                this.traceLockStateStruct(printWriter, (LockStateStruct)object);
                break;
            }
            case 13: {
                this.traceMailboxDialingNumber(printWriter, (MailboxDialingNumber)object);
                break;
            }
            case 14: {
                this.traceMissedCallIndicator(printWriter, (MissedCallIndicator)object);
                break;
            }
            case 15: {
                this.traceNADTemperatureStruct(printWriter, (NADTemperatureStruct)object);
                break;
            }
            case 16: {
                this.traceNetworkProvider(printWriter, (NetworkProvider)object);
                break;
            }
            case 17: {
                this.traceNetworkProviderName(printWriter, (NetworkProviderName)object);
                break;
            }
            case 18: {
                this.tracePhoneInformation(printWriter, (PhoneInformation)object);
                break;
            }
            case 19: {
                this.traceRegisterStateStruct(printWriter, (RegisterStateStruct)object);
                break;
            }
            case 20: {
                this.traceSIMAliasInformation(printWriter, (SIMAliasInformation)object);
                break;
            }
            case 21: {
                this.traceServiceCodeTypeStruct(printWriter, (ServiceCodeTypeStruct)object);
                break;
            }
            case 22: {
                this.traceServiceNumbers(printWriter, (ServiceNumbers)object);
                break;
            }
            case 23: {
                this.traceServiceProvider(printWriter, (ServiceProvider)object);
                break;
            }
            case 24: {
                this.traceSuppServiceResponseStruct(printWriter, (SuppServiceResponseStruct)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceActivationStateStruct(PrintWriter printWriter, ActivationStateStruct activationStateStruct) {
        if (activationStateStruct == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(activationStateStruct.telActivationState);
        printWriter.print(activationStateStruct.telPhoneModuleState);
        printWriter.print(activationStateStruct.telMode);
        printWriter.print(activationStateStruct.telFeat);
        printWriter.print(activationStateStruct.telHFPVersion);
    }

    private void traceCFRequestData(PrintWriter printWriter, CFRequestData cFRequestData) {
        if (cFRequestData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(cFRequestData.telCFMode);
        printWriter.print(cFRequestData.telCFCondition);
        printWriter.print(cFRequestData.telCFNumber);
        printWriter.print(cFRequestData.telClass);
        printWriter.print(cFRequestData.telCFTime);
    }

    private void traceCFResponseData(PrintWriter printWriter, CFResponseData cFResponseData) {
        if (cFResponseData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(cFResponseData.telCFStatus);
        printWriter.print(cFResponseData.telCFCondition);
        printWriter.print(cFResponseData.telCFNumber);
        printWriter.print(cFResponseData.telClass);
        printWriter.print(cFResponseData.telNumType);
        printWriter.print(cFResponseData.telCFTime);
        printWriter.print(cFResponseData.result);
    }

    private void traceCallDuration(PrintWriter printWriter, CallDuration callDuration) {
        if (callDuration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(callDuration.telCallID);
        printWriter.print(callDuration.telElapsedTime);
    }

    private void traceCallInformation(PrintWriter printWriter, CallInformation callInformation) {
        if (callInformation == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(callInformation.telCallID);
        printWriter.print(callInformation.telCallState);
        printWriter.print(callInformation.telMpty);
        printWriter.print(callInformation.telRemName);
        printWriter.print(callInformation.telRemLastName);
        printWriter.print(callInformation.telRemFirstName);
        printWriter.print(callInformation.telRemOrganization);
        printWriter.print(callInformation.telRemNumber);
        this.trace(printWriter, callInformation.telRemPictureId);
        printWriter.print(callInformation.telNumType);
        printWriter.print(callInformation.telCallType);
        printWriter.print(callInformation.telRemEntryId);
        printWriter.print(callInformation.telRemNumberType);
        printWriter.print(callInformation.telCallStartingTime);
        this.trace(printWriter, callInformation.extendedCallInformation);
        printWriter.print(callInformation.telCallCarrier);
    }

    private void traceCallInformationExt(PrintWriter printWriter, CallInformationExt callInformationExt) {
        if (callInformationExt == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(callInformationExt.telEntryType);
        printWriter.print(callInformationExt.telDBPhoneNumberIndex);
        printWriter.print(callInformationExt.adbPhoneDataCount);
    }

    private void traceCallStackEntry(PrintWriter printWriter, CallStackEntry callStackEntry) {
        if (callStackEntry == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(callStackEntry.clEntryID);
        printWriter.print(callStackEntry.clNumber);
        printWriter.print(callStackEntry.clName);
        printWriter.print(callStackEntry.lastName);
        printWriter.print(callStackEntry.firstName);
        printWriter.print(callStackEntry.organization);
        printWriter.print(callStackEntry.clEntryOrigin);
        printWriter.print(callStackEntry.clEntryType);
        printWriter.print(callStackEntry.clYear);
        printWriter.print(callStackEntry.clMonth);
        printWriter.print(callStackEntry.clDay);
        printWriter.print(callStackEntry.clHour);
        printWriter.print(callStackEntry.clMinute);
        printWriter.print(callStackEntry.clSecond);
        this.trace(printWriter, callStackEntry.adbPictureID);
        printWriter.print(callStackEntry.adbEntryID);
        printWriter.print(callStackEntry.adbPhoneDataIndex);
        printWriter.print(callStackEntry.adbPhoneDataCount);
        printWriter.print(callStackEntry.newMissedCallAttempts);
        printWriter.print(callStackEntry.adbNumberType);
    }

    private void traceDisconnectReason(PrintWriter printWriter, DisconnectReason disconnectReason) {
        if (disconnectReason == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(disconnectReason.disconnectReason);
        printWriter.print(disconnectReason.callId);
    }

    private void traceEmergencyCallSetting(PrintWriter printWriter, EmergencyCallSetting emergencyCallSetting) {
        if (emergencyCallSetting == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(emergencyCallSetting.value);
        printWriter.print(emergencyCallSetting.changeable);
    }

    private void traceEmergencyNumbers(PrintWriter printWriter, EmergencyNumbers emergencyNumbers) {
        if (emergencyNumbers == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(emergencyNumbers.mainEmergencyNumber);
        if (emergencyNumbers.additionalEmergencyNumber == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = emergencyNumbers.additionalEmergencyNumber.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                printWriter.print(emergencyNumbers.additionalEmergencyNumber[i2]);
            }
        }
    }

    private void traceFavorite(PrintWriter printWriter, Favorite favorite) {
        if (favorite == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(favorite.name);
        printWriter.print(favorite.number);
    }

    private void traceLockStateStruct(PrintWriter printWriter, LockStateStruct lockStateStruct) {
        if (lockStateStruct == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(lockStateStruct.telLockState);
        printWriter.print(lockStateStruct.telRetryCounter);
    }

    private void traceMailboxDialingNumber(PrintWriter printWriter, MailboxDialingNumber mailboxDialingNumber) {
        if (mailboxDialingNumber == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(mailboxDialingNumber.mailboxIdentifier);
        printWriter.print(mailboxDialingNumber.mailboxNumber);
        printWriter.print(mailboxDialingNumber.tonNpiValid);
        printWriter.print(mailboxDialingNumber.tonNpi);
        printWriter.print(mailboxDialingNumber.alphaIdentifierValid);
        printWriter.print(mailboxDialingNumber.alphaIdentifier);
        printWriter.print(mailboxDialingNumber.extConfCapValid);
        printWriter.print(mailboxDialingNumber.extConfCap);
        printWriter.print(mailboxDialingNumber.extInfoValid);
        printWriter.print(mailboxDialingNumber.extInfo);
    }

    private void traceMissedCallIndicator(PrintWriter printWriter, MissedCallIndicator missedCallIndicator) {
        if (missedCallIndicator == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(missedCallIndicator.missedCall);
        printWriter.print(missedCallIndicator.missedCallCount);
    }

    private void traceNADTemperatureStruct(PrintWriter printWriter, NADTemperatureStruct nADTemperatureStruct) {
        if (nADTemperatureStruct == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(nADTemperatureStruct.telNADTemperature);
        printWriter.print(nADTemperatureStruct.telNADTemperatureLevel);
    }

    private void traceNetworkProvider(PrintWriter printWriter, NetworkProvider networkProvider) {
        if (networkProvider == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(networkProvider.telLongProviderName);
        printWriter.print(networkProvider.telNumProviderName);
        printWriter.print(networkProvider.telProviderState);
    }

    private void traceNetworkProviderName(PrintWriter printWriter, NetworkProviderName networkProviderName) {
        if (networkProviderName == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(networkProviderName.telLongProviderName);
        printWriter.print(networkProviderName.telNumProviderName);
        printWriter.print(networkProviderName.telRegMode);
    }

    private void tracePhoneInformation(PrintWriter printWriter, PhoneInformation phoneInformation) {
        if (phoneInformation == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(phoneInformation.imsi);
        printWriter.print(phoneInformation.simId);
        printWriter.print(phoneInformation.nadIMEI);
        printWriter.print(phoneInformation.meIMEI);
        printWriter.print(phoneInformation.meBtAddress);
        printWriter.print(phoneInformation.meFriendlyName);
        printWriter.print(phoneInformation.telNetIdAvailIMSI);
        printWriter.print(phoneInformation.telNetIdAvailSimId);
        printWriter.print(phoneInformation.telNetIdAvailNadIMEI);
        printWriter.print(phoneInformation.telNetIdAvailMeIMEI);
        printWriter.print(phoneInformation.telNetIdAvailMeBtAddress);
        printWriter.print(phoneInformation.telNetIdAvailMeFriendlyName);
        printWriter.print(phoneInformation.simName);
    }

    private void traceRegisterStateStruct(PrintWriter printWriter, RegisterStateStruct registerStateStruct) {
        if (registerStateStruct == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(registerStateStruct.telRegisterState);
        printWriter.print(registerStateStruct.telLongProviderName);
        printWriter.print(registerStateStruct.telNumProviderName);
        printWriter.print(registerStateStruct.telRegMode);
    }

    private void traceSIMAliasInformation(PrintWriter printWriter, SIMAliasInformation sIMAliasInformation) {
        if (sIMAliasInformation == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(sIMAliasInformation.btAddress);
        printWriter.print(sIMAliasInformation.imsi);
        printWriter.print(sIMAliasInformation.activeName);
        printWriter.print(sIMAliasInformation.inactiveName);
    }

    private void traceServiceCodeTypeStruct(PrintWriter printWriter, ServiceCodeTypeStruct serviceCodeTypeStruct) {
        if (serviceCodeTypeStruct == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(serviceCodeTypeStruct.telDialNumberType);
        printWriter.print(serviceCodeTypeStruct.telServiceCode);
        printWriter.print(serviceCodeTypeStruct.telServiceCodeRequestType);
    }

    private void traceServiceNumbers(PrintWriter printWriter, ServiceNumbers serviceNumbers) {
        if (serviceNumbers == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(serviceNumbers.infonumber);
        printWriter.print(serviceNumbers.infonumberRoaming);
        printWriter.print(serviceNumbers.breakdownNumber);
        printWriter.print(serviceNumbers.breakdownNumberRoaming);
    }

    private void traceServiceProvider(PrintWriter printWriter, ServiceProvider serviceProvider) {
        if (serviceProvider == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(serviceProvider.displayConditionProviderName);
        printWriter.print(serviceProvider.displayConditionServiceProviderName);
        printWriter.print(serviceProvider.telServiceProviderName);
    }

    private void traceSuppServiceResponseStruct(PrintWriter printWriter, SuppServiceResponseStruct suppServiceResponseStruct) {
        if (suppServiceResponseStruct == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(suppServiceResponseStruct.telCWStatus);
        if (suppServiceResponseStruct.telCFResponseData == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = suppServiceResponseStruct.telCFResponseData.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, suppServiceResponseStruct.telCFResponseData[i2]);
            }
        }
        printWriter.print(suppServiceResponseStruct.simPINRequired);
        printWriter.print(suppServiceResponseStruct.telCLIRState);
        printWriter.print(suppServiceResponseStruct.telCLIRNWState);
        printWriter.print(suppServiceResponseStruct.telServiceState);
        printWriter.print(suppServiceResponseStruct.telResponseText);
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

