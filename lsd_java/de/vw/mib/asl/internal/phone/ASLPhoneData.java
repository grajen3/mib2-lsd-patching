/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone;

import de.vw.mib.asl.api.media.AlphabeticalScrollBarInfo;
import de.vw.mib.asl.api.phone.PhonePersistence;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.phone.api.model.SpecialNumbersImpl;
import de.vw.mib.asl.internal.phone.call.CallInformations;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AdbViewSize;
import org.dsi.ifc.organizer.DataSet;
import org.dsi.ifc.telephoneng.ActivationStateStruct;
import org.dsi.ifc.telephoneng.EmergencyNumbers;
import org.dsi.ifc.telephoneng.ServiceNumbers;

public final class ASLPhoneData {
    public static final char WIDGET_MARKER_START;
    public static final char WIDGET_MARKER_END;
    public static final int CALLSTATE_IDLE;
    public static final int[] EMPTY_NOTIFICATION;
    public static final int MAX_PROFILE_CONTACTS;
    public static final int WINDOW_SIZE;
    public static PhonePersistence persistence;
    public int deviceTypeSearchFilter = 0;
    public int deviceTypePairedDevicesFilter = 0;
    public int selectedDSIService = -1;
    public String selectedDeviceMAC = null;
    public String selectedDeviceName = null;
    public IntObjectOptHashMap connectedBTDevicesASL = null;
    public HashMap trustedBTDevices = new HashMap();
    public ArrayList trustedBTDevicesAddresses = new ArrayList();
    public boolean connected = false;
    public boolean adrdlConnected = false;
    public boolean btPhoneConnected = false;
    public boolean internalSIMConnected = false;
    public String SIMName = "";
    public int internalPrimarySIMProfileNum = -1;
    public EmergencyNumbers emergencyNumbers = new EmergencyNumbers("", new String[0]);
    public ServiceNumbers serviceNumbers = null;
    public String mailboxNumber = "";
    public SpecialNumbersImpl specialNumbers = new SpecialNumbersImpl();
    public boolean roaming = false;
    public final CallInformations callInformationCollectors = new CallInformations();
    public int micMuteState = 1;
    public AdbEntry adbEntryCallstacksCached;
    public AdbEntry adbEntryContactsCached;
    public DataSet dataSetContactsCached;
    public int telFeatures = 0;
    public int telFeaturesAssociated = 0;
    public int telMode = 4;
    public int telModeNad = 4;
    public int telModeAssociated = 4;
    public boolean callStackDownloadSupported = false;
    public int supportedProfiles;
    public boolean phoneReminderSetting = true;
    public static AdbViewSize viewSizeContacts;
    public boolean isCallsAvailable = false;
    public int phoneContactsSize = 0;
    public int phoneShortDialMatchingSize = 0;
    public boolean isCallstacksInverted = false;
    public String addressOfOngoingConnectionRequest = "";
    public int nadEnabledPhone = -1;
    public int nadEnabledIndependent = -1;
    public boolean a2DPEnabled = false;
    public int contactsSortedByCriteria = 0;
    public boolean newContactsSortOrderInitiated = false;
    public boolean isMultiPartySplitAvailable = false;
    public boolean isAddressbookConnecting = false;
    public boolean isDisconnectRequested = false;
    public boolean isConnectRequested = false;
    public int requestedService = 1;
    public boolean isClampSOn = false;
    public boolean standbyActive = false;
    public boolean isConferenceOnHold = false;
    public ArrayList incomingOrOutgoingCallIDs = new ArrayList();
    public boolean downloadInProgress = false;
    public String localizedMailboxCall = "";
    public String localizedUnknownCall = "";
    public String localizedEmergencyCall = "";
    public String localizedInfoCall = "";
    public String localizedServiceCall = "";
    public boolean isWaitingForPasskeyResponse = false;
    public int addressbookSortOrder;
    public final int PHONE_RELEASE_PHONE_CONNECTION_TIMER_INTERVAL;
    public boolean isOtherSIMAvailable = false;
    public String currentPIN = "";
    public String alternativePIN = "";
    public int lockState = 2;
    public int nadLockState = 0;
    public boolean isAutomaticPinEntryPending = false;
    public boolean isAutomaticPinEntryCancelled = false;
    public boolean isSimUnlockedByUserAfterInserting = false;
    public int usedCallLines = 0;
    public int maxCallLines = 0;
    public boolean isCallRespHold = false;
    public boolean isToggleOtherPINrequested = false;
    public int activePhoneAudioConnection = 0;
    public int nadMode = 0;
    public boolean isPukUnlockRequested = false;
    public boolean isBTSwitchOffRequested = false;
    public boolean isBTFactoryResetRequested = false;
    public boolean isDTMFWithoutActiveCall = false;
    public boolean isThreewaySettingEnabled = false;
    public boolean defaultSimCardModeVoice = false;
    public ActivationStateStruct activationStateNad;
    public boolean carPlayCallActive = false;
    public int numberOfCallBoxes = 0;
    public final AlphabeticalScrollBarInfo defaultCharacterInfo;
    public AlphabeticalScrollBarInfo characterInfos = this.defaultCharacterInfo = new AlphabeticalScrollBarInfo();
    public int btState = -1;
    public int nadState;
    public boolean androidAutoShown;
    public boolean nadPrimary;
    public boolean nadSecondary;
    public boolean carPlayConnected;
    public boolean lastDeviceConnectedPrimary;
    public boolean rSapConnected;
    public boolean androidAutoConnected;
    public boolean conferenceCallMaxedOut;
    private static ASLPhoneData instance;

    public int getCurrentCallsTelFeat() {
        return this.callInformationCollectors.isCurrentCallPrimary() ? this.telFeatures : this.telFeaturesAssociated;
    }

    public int getCurrentCallsTelMode() {
        return this.callInformationCollectors.isCurrentCallPrimary() ? this.telMode : this.telModeAssociated;
    }

    private ASLPhoneData() {
        this.PHONE_RELEASE_PHONE_CONNECTION_TIMER_INTERVAL = 100;
    }

    public static ASLPhoneData getInstance() {
        if (instance == null) {
            instance = new ASLPhoneData();
        }
        return instance;
    }

    static {
        EMPTY_NOTIFICATION = new int[0];
        MAX_PROFILE_CONTACTS = ServiceManager.configManagerDiag.getPhoneNumberOfAddressbookEntries();
        persistence = PhonePersistence.getInstance();
        instance = null;
    }
}

