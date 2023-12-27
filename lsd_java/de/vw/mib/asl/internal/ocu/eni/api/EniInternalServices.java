/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.eni.api;

import de.vw.mib.asl.internal.ocu.common.api.OCUService;
import de.vw.mib.asl.internal.ocu.common.api.services.ServiceListenerNotifier;

public interface EniInternalServices
extends OCUService,
ServiceListenerNotifier {
    public static final int PRIVATE;
    public static final int FCT_PAIR_MAIN_USER;
    public static final int FCT_CONFIRM_SERVICE_EXPIRY_WARNING;
    public static final int FCT_CONFIRM_SERVICE_EXPIRY_WARNINGS;
    public static final int FCT_RESTORE_FACTORY_SETTINGS;
    public static final int FCT_SEND_LOCAL_SERVICE_STATE_LIST_REQUEST;
    public static final int FCT_POSTPONE_ONLINE_DOWNLOAD;
    public static final int FCT_AUTHENTICATE_ONLINE_DOWNLOAD;
    public static final int FCT_POSTPONE_UPDATE_INSTALLATION;
    public static final int FCT_CONFIRM_UPDATE_INSTALLATION;
    public static final int FCT_CONFIRM_INSTALLATION_FINISHED;
    public static final int FCT_CONFIRM_UPDATE_WITHDRAWN;
    public static final int FCT_CONFIRM_UPDATE_ERROR;
    public static final int FCT_CONFIRM_DOWNLOAD_ERROR;
    public static final int FCT_INVOKE_SERVICE;
    public static final int FCT_INVOKE_SERVICE_LISTENER;
    public static final int FCT_REQUEST_NEW_LANGUAGE;
    public static final int FCT_GET_CHALLENGE;
    public static final int FCT_SET_PRIVACY_MODE;
    public static final int PARAM_INVOKE_SERVICE_METHOD;
    public static final int PARAM_INVOKE_SERVICE_ARGS;
    public static final int PARAM_INVOKE_SERVICE_LISTENER_METHOD;
    public static final int PARAM_INVOKE_SERVICE_LISTENER_ARGS;
    public static final int FCT_BLOCK_SERVICE;
    public static final int FCT_BLOCK_SERVICES;
    public static final int FCT_BLOCK_ALL_SERVICES;
}

