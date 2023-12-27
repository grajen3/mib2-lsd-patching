/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.telephone;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.telephone.ActivationStateStruct;
import org.dsi.ifc.telephone.CFRequestData;
import org.dsi.ifc.telephone.CFResponseData;
import org.dsi.ifc.telephone.CallDuration;
import org.dsi.ifc.telephone.CallInformation;
import org.dsi.ifc.telephone.CallInformationExt;
import org.dsi.ifc.telephone.CallStackEntry;
import org.dsi.ifc.telephone.DisconnectReason;
import org.dsi.ifc.telephone.EmergencyCallSetting;
import org.dsi.ifc.telephone.EmergencyNumbers;
import org.dsi.ifc.telephone.FACResponseData;
import org.dsi.ifc.telephone.Favorite;
import org.dsi.ifc.telephone.LockStateStruct;
import org.dsi.ifc.telephone.MailboxDialingNumber;
import org.dsi.ifc.telephone.MissedCallIndicator;
import org.dsi.ifc.telephone.NADTemperatureStruct;
import org.dsi.ifc.telephone.NetworkProvider;
import org.dsi.ifc.telephone.NetworkProviderName;
import org.dsi.ifc.telephone.PhoneInformation;
import org.dsi.ifc.telephone.RegisterStateStruct;
import org.dsi.ifc.telephone.SIMAliasInformation;
import org.dsi.ifc.telephone.ServiceCodeTypeStruct;
import org.dsi.ifc.telephone.ServiceNumbers;
import org.dsi.ifc.telephone.ServiceProvider;
import org.dsi.ifc.telephone.SuppServiceResponseStruct;

public final class DSITelephoneTracer
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
    private static final int ID_FACRESPONSEDATA;
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
    static /* synthetic */ Class class$org$dsi$ifc$telephone$ActivationStateStruct;
    static /* synthetic */ Class class$org$dsi$ifc$telephone$CFRequestData;
    static /* synthetic */ Class class$org$dsi$ifc$telephone$CFResponseData;
    static /* synthetic */ Class class$org$dsi$ifc$telephone$CallDuration;
    static /* synthetic */ Class class$org$dsi$ifc$telephone$CallInformation;
    static /* synthetic */ Class class$org$dsi$ifc$telephone$CallInformationExt;
    static /* synthetic */ Class class$org$dsi$ifc$telephone$CallStackEntry;
    static /* synthetic */ Class class$org$dsi$ifc$telephone$DisconnectReason;
    static /* synthetic */ Class class$org$dsi$ifc$telephone$EmergencyCallSetting;
    static /* synthetic */ Class class$org$dsi$ifc$telephone$EmergencyNumbers;
    static /* synthetic */ Class class$org$dsi$ifc$telephone$FACResponseData;
    static /* synthetic */ Class class$org$dsi$ifc$telephone$Favorite;
    static /* synthetic */ Class class$org$dsi$ifc$telephone$LockStateStruct;
    static /* synthetic */ Class class$org$dsi$ifc$telephone$MailboxDialingNumber;
    static /* synthetic */ Class class$org$dsi$ifc$telephone$MissedCallIndicator;
    static /* synthetic */ Class class$org$dsi$ifc$telephone$NADTemperatureStruct;
    static /* synthetic */ Class class$org$dsi$ifc$telephone$NetworkProvider;
    static /* synthetic */ Class class$org$dsi$ifc$telephone$NetworkProviderName;
    static /* synthetic */ Class class$org$dsi$ifc$telephone$PhoneInformation;
    static /* synthetic */ Class class$org$dsi$ifc$telephone$RegisterStateStruct;
    static /* synthetic */ Class class$org$dsi$ifc$telephone$SIMAliasInformation;
    static /* synthetic */ Class class$org$dsi$ifc$telephone$ServiceCodeTypeStruct;
    static /* synthetic */ Class class$org$dsi$ifc$telephone$ServiceNumbers;
    static /* synthetic */ Class class$org$dsi$ifc$telephone$ServiceProvider;
    static /* synthetic */ Class class$org$dsi$ifc$telephone$SuppServiceResponseStruct;

    public DSITelephoneTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephone$ActivationStateStruct == null ? (class$org$dsi$ifc$telephone$ActivationStateStruct = DSITelephoneTracer.class$("org.dsi.ifc.telephone.ActivationStateStruct")) : class$org$dsi$ifc$telephone$ActivationStateStruct, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephone$CFRequestData == null ? (class$org$dsi$ifc$telephone$CFRequestData = DSITelephoneTracer.class$("org.dsi.ifc.telephone.CFRequestData")) : class$org$dsi$ifc$telephone$CFRequestData, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephone$CFResponseData == null ? (class$org$dsi$ifc$telephone$CFResponseData = DSITelephoneTracer.class$("org.dsi.ifc.telephone.CFResponseData")) : class$org$dsi$ifc$telephone$CFResponseData, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephone$CallDuration == null ? (class$org$dsi$ifc$telephone$CallDuration = DSITelephoneTracer.class$("org.dsi.ifc.telephone.CallDuration")) : class$org$dsi$ifc$telephone$CallDuration, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephone$CallInformation == null ? (class$org$dsi$ifc$telephone$CallInformation = DSITelephoneTracer.class$("org.dsi.ifc.telephone.CallInformation")) : class$org$dsi$ifc$telephone$CallInformation, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephone$CallInformationExt == null ? (class$org$dsi$ifc$telephone$CallInformationExt = DSITelephoneTracer.class$("org.dsi.ifc.telephone.CallInformationExt")) : class$org$dsi$ifc$telephone$CallInformationExt, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephone$CallStackEntry == null ? (class$org$dsi$ifc$telephone$CallStackEntry = DSITelephoneTracer.class$("org.dsi.ifc.telephone.CallStackEntry")) : class$org$dsi$ifc$telephone$CallStackEntry, 7);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephone$DisconnectReason == null ? (class$org$dsi$ifc$telephone$DisconnectReason = DSITelephoneTracer.class$("org.dsi.ifc.telephone.DisconnectReason")) : class$org$dsi$ifc$telephone$DisconnectReason, 8);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephone$EmergencyCallSetting == null ? (class$org$dsi$ifc$telephone$EmergencyCallSetting = DSITelephoneTracer.class$("org.dsi.ifc.telephone.EmergencyCallSetting")) : class$org$dsi$ifc$telephone$EmergencyCallSetting, 9);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephone$EmergencyNumbers == null ? (class$org$dsi$ifc$telephone$EmergencyNumbers = DSITelephoneTracer.class$("org.dsi.ifc.telephone.EmergencyNumbers")) : class$org$dsi$ifc$telephone$EmergencyNumbers, 10);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephone$FACResponseData == null ? (class$org$dsi$ifc$telephone$FACResponseData = DSITelephoneTracer.class$("org.dsi.ifc.telephone.FACResponseData")) : class$org$dsi$ifc$telephone$FACResponseData, 11);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephone$Favorite == null ? (class$org$dsi$ifc$telephone$Favorite = DSITelephoneTracer.class$("org.dsi.ifc.telephone.Favorite")) : class$org$dsi$ifc$telephone$Favorite, 12);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephone$LockStateStruct == null ? (class$org$dsi$ifc$telephone$LockStateStruct = DSITelephoneTracer.class$("org.dsi.ifc.telephone.LockStateStruct")) : class$org$dsi$ifc$telephone$LockStateStruct, 13);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephone$MailboxDialingNumber == null ? (class$org$dsi$ifc$telephone$MailboxDialingNumber = DSITelephoneTracer.class$("org.dsi.ifc.telephone.MailboxDialingNumber")) : class$org$dsi$ifc$telephone$MailboxDialingNumber, 14);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephone$MissedCallIndicator == null ? (class$org$dsi$ifc$telephone$MissedCallIndicator = DSITelephoneTracer.class$("org.dsi.ifc.telephone.MissedCallIndicator")) : class$org$dsi$ifc$telephone$MissedCallIndicator, 15);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephone$NADTemperatureStruct == null ? (class$org$dsi$ifc$telephone$NADTemperatureStruct = DSITelephoneTracer.class$("org.dsi.ifc.telephone.NADTemperatureStruct")) : class$org$dsi$ifc$telephone$NADTemperatureStruct, 16);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephone$NetworkProvider == null ? (class$org$dsi$ifc$telephone$NetworkProvider = DSITelephoneTracer.class$("org.dsi.ifc.telephone.NetworkProvider")) : class$org$dsi$ifc$telephone$NetworkProvider, 17);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephone$NetworkProviderName == null ? (class$org$dsi$ifc$telephone$NetworkProviderName = DSITelephoneTracer.class$("org.dsi.ifc.telephone.NetworkProviderName")) : class$org$dsi$ifc$telephone$NetworkProviderName, 18);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephone$PhoneInformation == null ? (class$org$dsi$ifc$telephone$PhoneInformation = DSITelephoneTracer.class$("org.dsi.ifc.telephone.PhoneInformation")) : class$org$dsi$ifc$telephone$PhoneInformation, 19);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephone$RegisterStateStruct == null ? (class$org$dsi$ifc$telephone$RegisterStateStruct = DSITelephoneTracer.class$("org.dsi.ifc.telephone.RegisterStateStruct")) : class$org$dsi$ifc$telephone$RegisterStateStruct, 20);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephone$SIMAliasInformation == null ? (class$org$dsi$ifc$telephone$SIMAliasInformation = DSITelephoneTracer.class$("org.dsi.ifc.telephone.SIMAliasInformation")) : class$org$dsi$ifc$telephone$SIMAliasInformation, 21);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephone$ServiceCodeTypeStruct == null ? (class$org$dsi$ifc$telephone$ServiceCodeTypeStruct = DSITelephoneTracer.class$("org.dsi.ifc.telephone.ServiceCodeTypeStruct")) : class$org$dsi$ifc$telephone$ServiceCodeTypeStruct, 22);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephone$ServiceNumbers == null ? (class$org$dsi$ifc$telephone$ServiceNumbers = DSITelephoneTracer.class$("org.dsi.ifc.telephone.ServiceNumbers")) : class$org$dsi$ifc$telephone$ServiceNumbers, 23);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephone$ServiceProvider == null ? (class$org$dsi$ifc$telephone$ServiceProvider = DSITelephoneTracer.class$("org.dsi.ifc.telephone.ServiceProvider")) : class$org$dsi$ifc$telephone$ServiceProvider, 24);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$telephone$SuppServiceResponseStruct == null ? (class$org$dsi$ifc$telephone$SuppServiceResponseStruct = DSITelephoneTracer.class$("org.dsi.ifc.telephone.SuppServiceResponseStruct")) : class$org$dsi$ifc$telephone$SuppServiceResponseStruct, 25);
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
                this.traceFACResponseData(printWriter, (FACResponseData)object);
                break;
            }
            case 12: {
                this.traceFavorite(printWriter, (Favorite)object);
                break;
            }
            case 13: {
                this.traceLockStateStruct(printWriter, (LockStateStruct)object);
                break;
            }
            case 14: {
                this.traceMailboxDialingNumber(printWriter, (MailboxDialingNumber)object);
                break;
            }
            case 15: {
                this.traceMissedCallIndicator(printWriter, (MissedCallIndicator)object);
                break;
            }
            case 16: {
                this.traceNADTemperatureStruct(printWriter, (NADTemperatureStruct)object);
                break;
            }
            case 17: {
                this.traceNetworkProvider(printWriter, (NetworkProvider)object);
                break;
            }
            case 18: {
                this.traceNetworkProviderName(printWriter, (NetworkProviderName)object);
                break;
            }
            case 19: {
                this.tracePhoneInformation(printWriter, (PhoneInformation)object);
                break;
            }
            case 20: {
                this.traceRegisterStateStruct(printWriter, (RegisterStateStruct)object);
                break;
            }
            case 21: {
                this.traceSIMAliasInformation(printWriter, (SIMAliasInformation)object);
                break;
            }
            case 22: {
                this.traceServiceCodeTypeStruct(printWriter, (ServiceCodeTypeStruct)object);
                break;
            }
            case 23: {
                this.traceServiceNumbers(printWriter, (ServiceNumbers)object);
                break;
            }
            case 24: {
                this.traceServiceProvider(printWriter, (ServiceProvider)object);
                break;
            }
            case 25: {
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

    private void traceFACResponseData(PrintWriter printWriter, FACResponseData fACResponseData) {
        if (fACResponseData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(fACResponseData.telFACStatus);
        printWriter.print(fACResponseData.telFacility);
        printWriter.print(fACResponseData.telClass);
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

