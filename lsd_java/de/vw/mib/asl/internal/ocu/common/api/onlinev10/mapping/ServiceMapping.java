/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api.onlinev10.mapping;

import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkServiceListEntry;
import de.vw.mib.asl.internal.ocu.common.api.onlinev10.enums.OnlineNetworkListState;
import de.vw.mib.asl.internal.ocu.common.api.onlinev10.enums.OperationResult;
import de.vw.mib.asl.internal.ocu.common.api.onlinev10.enums.OperationStatus;
import de.vw.mib.asl.internal.ocu.common.api.onlinev10.enums.OperationType;
import de.vw.mib.asl.internal.ocu.common.api.onlinev10.enums.ServiceLicenseState;
import de.vw.mib.asl.internal.ocu.common.api.onlinev10.enums.ServiceListSynchronisationState;
import de.vw.mib.asl.internal.ocu.common.api.onlinev10.enums.UserType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServiceMapping {
    private static final String SERVICE_LIST_DATE_FORMAT;
    private static final String SERVICE_LIST_DATE_TIME_ZONE;
    private static final String SERVICE_LIST_DATE_TIME_ZONE_REPLACEMENT;

    public static OperationResult mapEniOperationResult(int n) {
        OperationResult operationResult;
        switch (n) {
            case 1: {
                operationResult = OperationResult.ENUM_NOT_SUCCESSFUL;
                break;
            }
            case 2: {
                operationResult = OperationResult.ENUM_NOT_SUCCESSFUL_SERVICE_BUSY;
                break;
            }
            case 0: {
                operationResult = OperationResult.ENUM_SUCCESSFUL;
                break;
            }
            case 3: {
                operationResult = OperationResult.ENUM_TERMINATED_BY_USER;
                break;
            }
            case 7: {
                operationResult = OperationResult.ENUM_NO_NETWORK_CONNECTION;
                break;
            }
            case 9: {
                operationResult = OperationResult.ENUM_BACKEND_SERVICE_UNAVAILABLE;
                break;
            }
            case 10: {
                operationResult = OperationResult.ENUM_MISC_BACKEND_ERROR;
                break;
            }
            case 11: {
                operationResult = OperationResult.ENUM_TIMEOUT;
                break;
            }
            case 5: 
            case 14: {
                operationResult = OperationResult.ENUM_WRONG_REGISTRATION_CODE;
                break;
            }
            case 6: {
                operationResult = OperationResult.ENUM_WRONG_REGISTRATION_CODE_PIN_EXPIRED;
                break;
            }
            case 8: 
            case 13: {
                operationResult = OperationResult.ENUM_WRONG_REGISTRATION_CODE_NO_PIN_CREATED_UNPAIRED;
                break;
            }
            default: {
                throw new UnsupportedOperationException(new StringBuffer().append("Wrong operationResult mapping value given: operationResult=").append(n).toString());
            }
        }
        return operationResult;
    }

    public static OperationStatus mapEniOperationStatus(int n) {
        OperationStatus operationStatus;
        switch (n) {
            case 0: {
                operationStatus = OperationStatus.ENUM_NO_INFORMATION;
                break;
            }
            case 1: {
                operationStatus = OperationStatus.ENUM_NO_REQUEST_ACTIVE;
                break;
            }
            case 2: {
                operationStatus = OperationStatus.ENUM_IN_PROGRESS;
                break;
            }
            case 3: {
                operationStatus = OperationStatus.ENUM_SEARCHING_FOR_NETWORK;
                break;
            }
            case 4: {
                operationStatus = OperationStatus.ENUM_CONNECTING_TO_SERVER;
                break;
            }
            case 5: {
                operationStatus = OperationStatus.ENUM_WAITING_FOR_AUTHENTICATION;
                break;
            }
            case 6: {
                operationStatus = OperationStatus.ENUM_DATA_TRANSMISSION;
                break;
            }
            default: {
                throw new UnsupportedOperationException(new StringBuffer().append("Wrong operationStatus mapping value given: operationStatus=").append(n).toString());
            }
        }
        return operationStatus;
    }

    public static OperationType mapEniOperationType(int n) {
        OperationType operationType;
        switch (n) {
            case 0: {
                operationType = OperationType.ENUM_PAIR_MAIN_USER;
                break;
            }
            case 1: {
                operationType = OperationType.ENUM_RESTORE_FACTORY_SETTINGS;
                break;
            }
            case 2: {
                operationType = OperationType.ENUM_CONFIRM_SERVICE_EXPIRY_WARNING;
                break;
            }
            case 3: {
                operationType = OperationType.ENUM_CONFIRM_ALL_SERVICE_EXPIRY_WARNINGS;
                break;
            }
            case 4: {
                operationType = OperationType.ENUM_SYNCHRONIZE_SERVICE_LIST_WITH_BACKEND;
                break;
            }
            case 14: {
                operationType = OperationType.ENUM_SET_PRIVACY_MODE;
                break;
            }
            default: {
                throw new UnsupportedOperationException(new StringBuffer().append("Wrong operationType mapping value given: operationType=").append(n).toString());
            }
        }
        return operationType;
    }

    public static UserType mapBapUserType(int n) {
        UserType userType;
        switch (n) {
            case 0: {
                userType = UserType.ENUM_MAIN_USER;
                break;
            }
            case 1: {
                userType = UserType.ENUM_SUB_USER;
                break;
            }
            default: {
                throw new UnsupportedOperationException(new StringBuffer().append("Wrong bapUserType mapping value given: bapUserType=").append(n).toString());
            }
        }
        return userType;
    }

    public static ServiceLicenseState mapBapLicenseState(int n) {
        ServiceLicenseState serviceLicenseState;
        switch (n) {
            case 0: {
                serviceLicenseState = ServiceLicenseState.ENUM_NOT_LICENSED;
                break;
            }
            case 1: {
                serviceLicenseState = ServiceLicenseState.ENUM_NOT_ACTIVATED;
                break;
            }
            case 2: {
                serviceLicenseState = ServiceLicenseState.ENUM_ACTIVATED;
                break;
            }
            case 3: {
                serviceLicenseState = ServiceLicenseState.ENUM_EXPIRED;
                break;
            }
            case 4: {
                serviceLicenseState = ServiceLicenseState.ENUM_TEPORARY_OFFER;
                break;
            }
            case 5: {
                serviceLicenseState = ServiceLicenseState.ENUM_LICENSE_ERROR;
                break;
            }
            default: {
                throw new UnsupportedOperationException(new StringBuffer().append("Wrong bapServiceLicenseState mapping value given: bapServiceLicenseState=").append(n).toString());
            }
        }
        return serviceLicenseState;
    }

    public static Date mapBapEniServiceDate(String string) {
        Date date;
        if (string.length() == 0) {
            date = OnlineNetworkServiceListEntry.SERVICE_DATE_INVALID;
        } else {
            if (string.endsWith("Z")) {
                string = string.substring(0, string.length() - "Z".length()).concat("+0000");
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmZ");
            try {
                date = simpleDateFormat.parse(string);
            }
            catch (ParseException parseException) {
                date = OnlineNetworkServiceListEntry.SERVICE_DATE_INVALID;
            }
        }
        return date;
    }

    public static OnlineNetworkListState mapEniUserListState(int n) {
        OnlineNetworkListState onlineNetworkListState;
        switch (n) {
            case 3: {
                onlineNetworkListState = OnlineNetworkListState.ENUM_LOADED;
                break;
            }
            case 2: {
                onlineNetworkListState = OnlineNetworkListState.ENUM_LOADING;
                break;
            }
            case 4: {
                onlineNetworkListState = OnlineNetworkListState.ENUM_ERROR;
                break;
            }
            case 1: {
                onlineNetworkListState = OnlineNetworkListState.ENUM_NOT_AVAILABLE;
                break;
            }
            default: {
                throw new UnsupportedOperationException(new StringBuffer().append("Wrong userListState mapping value given: userListState=").append(n).toString());
            }
        }
        return onlineNetworkListState;
    }

    public static ServiceListSynchronisationState mapEniConnectionState(int n) {
        ServiceListSynchronisationState serviceListSynchronisationState;
        switch (n) {
            case 0: {
                serviceListSynchronisationState = ServiceListSynchronisationState.ENUM_UNKNOWN;
                break;
            }
            case 1: {
                serviceListSynchronisationState = ServiceListSynchronisationState.ENUM_NOT_AVAILABLE;
                break;
            }
            case 2: {
                serviceListSynchronisationState = ServiceListSynchronisationState.ENUM_NOT_SYNCHRONISED;
                break;
            }
            case 3: {
                serviceListSynchronisationState = ServiceListSynchronisationState.ENUM_SYNCHRONISED;
                break;
            }
            default: {
                throw new UnsupportedOperationException(new StringBuffer().append("Wrong connection state mapping value given: connectionState=").append(n).toString());
            }
        }
        return serviceListSynchronisationState;
    }

    public static OnlineNetworkListState mapEniServiceListState(int n) {
        OnlineNetworkListState onlineNetworkListState;
        switch (n) {
            case 3: {
                onlineNetworkListState = OnlineNetworkListState.ENUM_LOADED;
                break;
            }
            case 2: {
                onlineNetworkListState = OnlineNetworkListState.ENUM_LOADING;
                break;
            }
            case 4: {
                onlineNetworkListState = OnlineNetworkListState.ENUM_ERROR;
                break;
            }
            case 1: {
                onlineNetworkListState = OnlineNetworkListState.ENUM_NOT_AVAILABLE;
                break;
            }
            default: {
                throw new UnsupportedOperationException(new StringBuffer().append("Wrong serviceListState mapping value given: serviceListState=").append(n).toString());
            }
        }
        return onlineNetworkListState;
    }
}

