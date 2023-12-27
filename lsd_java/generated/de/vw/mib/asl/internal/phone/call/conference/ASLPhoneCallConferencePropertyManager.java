/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone.call.conference;

import org.dsi.ifc.global.ResourceLocator;

public interface ASLPhoneCallConferencePropertyManager {
    public static final int CONFERENCE_CALL_INFORMATIONS__CALL_ID;
    public static final int CONFERENCE_CALL_INFORMATIONS__CALL_ID__DEFAULT_VALUE;
    public static final int CONFERENCE_CALL_INFORMATIONS__CALL_ID__MIN_VALUE;
    public static final int CONFERENCE_CALL_INFORMATIONS__DISCONNECTION_REASON;
    public static final int CONFERENCE_CALL_INFORMATIONS__DISCONNECTION_REASON__DEFAULT_VALUE;
    public static final int CONFERENCE_CALL_INFORMATIONS__DISCONNECTION_REASON__C0_NOT_AVAILABLE;
    public static final int CONFERENCE_CALL_INFORMATIONS__DISCONNECTION_REASON__C1_HANGED_UP;
    public static final int CONFERENCE_CALL_INFORMATIONS__DISCONNECTION_REASON__C2_NOLINE;
    public static final int CONFERENCE_CALL_INFORMATIONS__DISCONNECTION_REASON__C3_SYSTEM_BUSY;
    public static final int CONFERENCE_CALL_INFORMATIONS__DISCONNECTION_REASON__C4_REMOTE_BUSY;
    public static final int CONFERENCE_CALL_INFORMATIONS__DISCONNECTION_REASON__C5_NUMBER_NOT_ASSIGNED;
    public static final int CONFERENCE_CALL_INFORMATIONS__DISCONNECTION_REASON__C6_NUMBER_NOT_REACHABLE;
    public static final int CONFERENCE_CALL_INFORMATIONS__DISCONNECTION_REASON__C7_NETWORK_ERROR;
    public static final int CONFERENCE_CALL_INFORMATIONS__DISCONNECTION_REASON__C8_NUMBER_BLOCKED_OR_CALL_BARRING;
    public static final int CONFERENCE_CALL_INFORMATIONS__DISCONNECTION_REASON__C9_CALL_REJECTED;
    public static final int CONFERENCE_CALL_INFORMATIONS__DISCONNECTION_REASON__C10_REMOTE_NOT_ANSWERING;
    public static final int CONFERENCE_CALL_INFORMATIONS__DISCONNECTION_REASON__C11_NUMBER_CHANGED;
    public static final int CONFERENCE_CALL_INFORMATIONS__DISCONNECTION_REASON__C12_NUMBER_NOT_VALID;
    public static final int CONFERENCE_CALL_INFORMATIONS__DISCONNECTION_REASON__C13_SERVICE_NOT_AVAILABLE;
    public static final int CONFERENCE_CALL_INFORMATIONS__DISCONNECTION_REASON__C14_INFO_NOT_AVAILABLE;
    public static final int CONFERENCE_CALL_INFORMATIONS__DISCONNECTION_REASON__C15_NUMBER_TEMP_FORBIDDEN;
    public static final int CONFERENCE_CALL_INFORMATIONS__DURATION;
    public static final int CONFERENCE_CALL_INFORMATIONS__DURATION__DEFAULT_VALUE;
    public static final int CONFERENCE_CALL_INFORMATIONS__DURATION__MIN_VALUE;
    public static final int CONFERENCE_CALL_INFORMATIONS__NAME;
    public static final String CONFERENCE_CALL_INFORMATIONS__NAME__DEFAULT_VALUE;
    public static final int CONFERENCE_CALL_INFORMATIONS__NUMBER;
    public static final String CONFERENCE_CALL_INFORMATIONS__NUMBER__DEFAULT_VALUE;
    public static final int CONFERENCE_CALL_INFORMATIONS__NUMBER_TYPE;
    public static final int CONFERENCE_CALL_INFORMATIONS__NUMBER_TYPE__DEFAULT_VALUE;
    public static final int CONFERENCE_CALL_INFORMATIONS__NUMBER_TYPE__C0_UNKNOWN;
    public static final int CONFERENCE_CALL_INFORMATIONS__NUMBER_TYPE__C1_PREF;
    public static final int CONFERENCE_CALL_INFORMATIONS__NUMBER_TYPE__C2_WORK;
    public static final int CONFERENCE_CALL_INFORMATIONS__NUMBER_TYPE__C3_PREF_WORK;
    public static final int CONFERENCE_CALL_INFORMATIONS__NUMBER_TYPE__C4_HOME;
    public static final int CONFERENCE_CALL_INFORMATIONS__NUMBER_TYPE__C5_PREF_HOME;
    public static final int CONFERENCE_CALL_INFORMATIONS__NUMBER_TYPE__C6_VOICE;
    public static final int CONFERENCE_CALL_INFORMATIONS__NUMBER_TYPE__C7_FAX;
    public static final int CONFERENCE_CALL_INFORMATIONS__NUMBER_TYPE__C8_FAX_WORK;
    public static final int CONFERENCE_CALL_INFORMATIONS__NUMBER_TYPE__C9_FAX_HOME;
    public static final int CONFERENCE_CALL_INFORMATIONS__NUMBER_TYPE__C10_MSG;
    public static final int CONFERENCE_CALL_INFORMATIONS__NUMBER_TYPE__C11_CELL;
    public static final int CONFERENCE_CALL_INFORMATIONS__NUMBER_TYPE__C12_CELL_WORK;
    public static final int CONFERENCE_CALL_INFORMATIONS__NUMBER_TYPE__C13_CELL_HOME;
    public static final int CONFERENCE_CALL_INFORMATIONS__NUMBER_TYPE__C14_PAGER;
    public static final int CONFERENCE_CALL_INFORMATIONS__NUMBER_TYPE__C15_BBS;
    public static final int CONFERENCE_CALL_INFORMATIONS__NUMBER_TYPE__C16_MODEM;
    public static final int CONFERENCE_CALL_INFORMATIONS__NUMBER_TYPE__C17_CAR;
    public static final int CONFERENCE_CALL_INFORMATIONS__NUMBER_TYPE__C18_ISDN;
    public static final int CONFERENCE_CALL_INFORMATIONS__NUMBER_TYPE__C19_VIDEO;
    public static final int CONFERENCE_CALL_INFORMATIONS__PICTURE;
    public static final ResourceLocator CONFERENCE_CALL_INFORMATIONS__PICTURE__DEFAULT_VALUE;
    public static final int CONFERENCE_CALL_INFORMATIONS__STATE;
    public static final int CONFERENCE_CALL_INFORMATIONS__STATE__DEFAULT_VALUE;
    public static final int CONFERENCE_CALL_INFORMATIONS__STATE__C0_CALLSTATE_IDLE;
    public static final int CONFERENCE_CALL_INFORMATIONS__STATE__C1_CALLSTATE_DIALING;
    public static final int CONFERENCE_CALL_INFORMATIONS__STATE__C2_CALLSTATE_ALERTING;
    public static final int CONFERENCE_CALL_INFORMATIONS__STATE__C3_CALLSTATE_INCOMING;
    public static final int CONFERENCE_CALL_INFORMATIONS__STATE__C4_CALLSTATE_INCOMING_ON_HOLD;
    public static final int CONFERENCE_CALL_INFORMATIONS__STATE__C5_CALLSTATE_ACTIVE;
    public static final int CONFERENCE_CALL_INFORMATIONS__STATE__C6_CALLSTATE_DISCONNECTING;
    public static final int CONFERENCE_CALL_INFORMATIONS__STATE__C7_CALLSTATE_HOLD;
    public static final int CONFERENCE_CALL_INFORMATIONS__TIME_STAMP;
    public static final int CONFERENCE_CALL_INFORMATIONS__TIME_STAMP__DEFAULT_VALUE;
    public static final int CONFERENCE_CALL_INFORMATIONS__TIME_STAMP__MIN_VALUE;
    public static final int CONFERENCE_CALL_INFORMATIONS__TYPE;
    public static final int CONFERENCE_CALL_INFORMATIONS__TYPE__DEFAULT_VALUE;
    public static final int CONFERENCE_CALL_INFORMATIONS__TYPE__C0_CALLTYPE_VOICE;
    public static final int CONFERENCE_CALL_INFORMATIONS__TYPE__C1_CALLTYPE_DATA;
    public static final int CONFERENCE_CALL_INFORMATIONS__TYPE__C2_CALLTYPE_FAX;
    public static final int CONFERENCE_CALL_INFORMATIONS__TYPE__C3_CALLTYPE_EMERGENCY;
    public static final int CONFERENCE_CALL_INFORMATIONS__TYPE__C4_CALLTYPE_SERVICE;
    public static final int CONFERENCE_CALL_INFORMATIONS__TYPE__C5_CALLTYPE_INFO;
    public static final int CONFERENCE_CALL_INFORMATIONS__TYPE__C6_CALLTYPE_MAILBOX;
    public static final int CONFERENCE_CALL_INFORMATIONS__CONTACT;
    public static final boolean CONFERENCE_CALL_INFORMATIONS__CONTACT__DEFAULT_VALUE;
    public static final boolean CONFERENCE_CALL_INFORMATIONS__CONTACT__C0_NO_CONTACT_EXIST;
    public static final boolean CONFERENCE_CALL_INFORMATIONS__CONTACT__C1_CONTACT_EXIST;
    public static final int CONFERENCE_CALL_INFORMATIONS__REMOVE_AVAILABLE;
    public static final boolean CONFERENCE_CALL_INFORMATIONS__REMOVE_AVAILABLE__DEFAULT_VALUE;
    public static final boolean CONFERENCE_CALL_INFORMATIONS__REMOVE_AVAILABLE__C0_NOT_AVAILABLE;
    public static final boolean CONFERENCE_CALL_INFORMATIONS__REMOVE_AVAILABLE__C1_AVAILABLE;
    public static final int CONFERENCE_CALL_INFORMATIONS__SPLIT_AVAILABLE;
    public static final boolean CONFERENCE_CALL_INFORMATIONS__SPLIT_AVAILABLE__DEFAULT_VALUE;
    public static final boolean CONFERENCE_CALL_INFORMATIONS__SPLIT_AVAILABLE__C0_NOT_AVAILABLE;
    public static final boolean CONFERENCE_CALL_INFORMATIONS__SPLIT_AVAILABLE__C1_AVAILABLE;

    static {
        CONFERENCE_CALL_INFORMATIONS__PICTURE__DEFAULT_VALUE = null;
    }
}

