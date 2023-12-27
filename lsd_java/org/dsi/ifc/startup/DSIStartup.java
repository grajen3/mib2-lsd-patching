/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.startup;

import org.dsi.ifc.base.DSIBase;

public interface DSIStartup
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_DOMAINSTATUSROOT;
    public static final int ATTR_DOMAINSTATUSTUNER;
    public static final int ATTR_DOMAINSTATUSMEDIA;
    public static final int ATTR_DOMAINSTATUSADDRESSBOOK;
    public static final int ATTR_DOMAINSTATUSPHONE;
    public static final int ATTR_DOMAINSTATUSNAV;
    public static final int ATTR_DOMAINSTATUSINFO;
    public static final int ATTR_DOMAINSTATUSCAR;
    public static final int ATTR_DOMAINSTATUSAUDIO;
    public static final int ATTR_DOMAINSTATUSSDS;
    public static final int ATTR_DOMAINSTATUSSWDL;
    public static final int ATTR_DOMAINSTATUSEARLYAPPS;
    public static final int ATTR_DOMAINSTATUSPOSTSTARTUP;
    public static final int ATTR_DOMAINSTATUSCOMMUNICATION;
    public static final int ATTR_DOMAINSTATUSIPSERVICES;
    public static final int ATTR_DOMAINSTATUSGEMMI;
    public static final int ATTR_DOMAINSTATUSBAPKOMBI;
    public static final int ATTR_DOMAINSTATUSBLUETOOTH;
    public static final int ATTR_DOMAINSTATUSBROWSER;
    public static final int ATTR_DOMAINSTATUSEXPLORER;
    public static final int ATTR_DOMAINSTATUSCALENDAR;
    public static final int ATTR_DOMAINSTATUSPICTURESTORE;
    public static final int ATTR_DOMAINSTATUSSTREETVIEW;
    public static final int ATTR_DOMAINSTATUSMOBILITYHORIZON;
    public static final int ATTR_DOMAINSTATUSEXBOXM;
    public static final int ATTR_DOMAINSTATUSMIRRORLINK;
    public static final int ATTR_DOMAINSTATUSSFA;
    public static final int ATTR_DOMAINSTATUSSEARCH;
    public static final int ATTR_DOMAINSTATUSDIAGNOSIS;
    public static final int ATTR_DOMAINSTATUSASIALANGUAGESUPPORT;
    public static final int ATTR_DOMAINSTATUSEXLAP;
    public static final int ATTR_DOMAINSTATUSTVTUNER;
    public static final int ATTR_DOMAINSTATUSMEDIAONLINE;
    public static final int ATTR_DOMAINSTATUSMEDIAROUTER;
    public static final int ATTR_DOMAINSTATUSRADIODATASERVER;
    public static final int ATTR_DOMAINSTATUSSMARTPHONEINTEGRATION;
    public static final int ATTR_DOMAINSTATUSWIRELESSCHARGER;
    public static final int RT_STARTDOMAIN;
    public static final int RT_HMICOMPLETELYSTARTED;
    public static final int RP_STARTDOMAIN;
    public static final int DOMAINID_STARTUP_DOMAIN_UNKNOWN;
    public static final int DOMAINID_STARTUP_DOMAIN_ROOT;
    public static final int DOMAINID_STARTUP_DOMAIN_TUNER;
    public static final int DOMAINID_STARTUP_DOMAIN_MEDIA;
    public static final int DOMAINID_STARTUP_DOMAIN_ADDRESSBOOK;
    public static final int DOMAINID_STARTUP_DOMAIN_PHONE;
    public static final int DOMAINID_STARTUP_DOMAIN_NAV;
    public static final int DOMAINID_STARTUP_DOMAIN_INFO;
    public static final int DOMAINID_STARTUP_DOMAIN_CAR;
    public static final int DOMAINID_STARTUP_DOMAIN_AUDIO;
    public static final int DOMAINID_STARTUP_DOMAIN_SDS;
    public static final int DOMAINID_STARTUP_DOMAIN_SWDL;
    public static final int DOMAINID_STARTUP_DOMAIN_EARLY_APPS;
    public static final int DOMAINID_STARTUP_DOMAIN_POST;
    public static final int DOMAINID_STARTUP_DOMAIN_COMMUNICATION;
    public static final int DOMAINID_STARTUP_DOMAIN_IPSERVICES;
    public static final int DOMAINID_STARTUP_DOMAIN_GEMMI;
    public static final int DOMAINID_STARTUP_DOMAIN_BAPKOMBI;
    public static final int DOMAINID_STARTUP_DOMAIN_BLUETOOTH;
    public static final int DOMAINID_STARTUP_DOMAIN_BROWSER;
    public static final int DOMAINID_STARTUP_DOMAIN_EXPLORER;
    public static final int DOMAINID_STARTUP_DOMAIN_CALENDAR;
    public static final int DOMAINID_STARTUP_DOMAIN_PICTURESTORE;
    public static final int DOMAINID_STARTUP_DOMAIN_STREETVIEW;
    public static final int DOMAINID_STARTUP_DOMAIN_MOBILITYHORIZON;
    public static final int DOMAINID_STARTUP_DOMAIN_EXBOXM;
    public static final int DOMAINID_STARTUP_DOMAIN_MIRRORLINK;
    public static final int DOMAINID_STARTUP_DOMAIN_SFA;
    public static final int DOMAINID_STARTUP_DOMAIN_SEARCH;
    public static final int DOMAINID_STARTUP_DOMAIN_DIAGNOSIS;
    public static final int DOMAINID_STARTUP_DOMAIN_ASIA_LANGUAGE_SUPPORT;
    public static final int DOMAINID_STARTUP_DOMAIN_EXLAP;
    public static final int DOMAINID_STARTUP_DOMAIN_TVTUNER;
    public static final int DOMAINID_STARTUP_DOMAIN_MEDIA_ONLINE;
    public static final int DOMAINID_STARTUP_DOMAIN_MEDIA_ROUTER;
    public static final int DOMAINID_STARTUP_DOMAIN_RADIODATA_SERVER;
    public static final int DOMAINID_STARTUP_DOMAIN_SMARTPHONE_INTEGRATION;
    public static final int DOMAINID_STARTUP_DOMAIN_WIRELESS_CHARGER;
    public static final int DOMAINSTATE_STARTUP_DOMAIN_STATE_NOT_INIT;
    public static final int DOMAINSTATE_STARTUP_DOMAIN_STATE_NOT_STARTED;
    public static final int DOMAINSTATE_STARTUP_DOMAIN_STATE_AUDIBLE;
    public static final int DOMAINSTATE_STARTUP_DOMAIN_STATE_OPERABLE;
    public static final int DOMAINSTATE_STARTUP_DOMAIN_STATE_FULLY_OPERABLE;
    public static final int DOMAINSTATE_STARTUP_DOMAIN_STATE_ERROR;
    public static final int DOMAINSTATE_STARTUP_DOMAIN_STATE_ERROR_INDICATION_UNRECOVERABLE;
    public static final int DOMAINSTATE_STARTUP_DOMAIN_STATE_ERROR_INDICATION_NOT_AVAILABLE;

    default public void startDomain(int n, int n2) {
    }

    default public void hmiCompletelyStarted() {
    }
}

