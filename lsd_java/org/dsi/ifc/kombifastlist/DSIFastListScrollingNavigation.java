/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombifastlist;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.kombifastlist.DataAddress;
import org.dsi.ifc.kombifastlist.DataInitials;

public interface DSIFastListScrollingNavigation
extends DSIBase {
    public static final String VERSION;
    public static final int IN_INDICATIONNAVBOOK;
    public static final int IN_INDICATIONGETINITIALSNAVIGATION;
    public static final int IN_INDICATIONNOTIFYLASTDESTLISTPUSH;
    public static final int IN_INDICATIONNOTIFYFAVORITEDESTLISTPUSH;
    public static final int IN_INDICATIONNOTIFYCURRENTLISTSIZENAVIGATION;
    public static final int IN_INDICATIONNAVBOOKJOBS;
    public static final int RT_PUSHFUNCTIONAVAILABILITYNAVIGATION;
    public static final int RT_PUSHMOSTOPERATIONSTATENAVIGATION;
    public static final int RT_RESPONSENAVBOOK;
    public static final int RT_RESPONSENAVBOOKARRAY;
    public static final int RT_RESPONSEGETINITIALSNAVIGATION;
    public static final int RT_PUSHLASTDESTLIST;
    public static final int RT_PUSHUPDATEFAVORITEDESTLIST;
    public static final int RT_PUSHCURRENTLISTSIZENAVIGATION;
    public static final int RT_RESPONSENAVBOOKJOBS;
    public static final int RT_RESPONSENOTIFYCURRENTLISTSIZESNAVIGATION;
    public static final int RT_RESPONSENOTIFYFAVORITEDESTLIST;
    public static final int RT_RESPONSENOTIFYLASTDESTLIST;
    public static final int FUNCTIONAVAILABILITY_NAVBOOK;
    public static final int FUNCTIONAVAILABILITY_GETINITIALS;
    public static final int FUNCTIONAVAILABILITY_LANEGUIDANCE_PUSH;
    public static final int FUNCTIONAVAILABILITY_FAVORITEDESTLIST_PUSH;
    public static final int FUNCTIONAVAILABILITY_NAVBOOKJOBS;
    public static final int OPSTATE_NORMAL;
    public static final int OPSTATE_OFFSTBY;
    public static final int OPSTATE_INITIALISING;
    public static final int OPSTATE_DEFECTIVE;
    public static final int ASGID_DEFAULT;
    public static final int ASGID_INSTRUMENTCLUSTER;
    public static final int ASGID_HEADUPDISPLAY;
    public static final int RECORDADDRESSNAME_FULL;
    public static final int RECORDADDRESSNAME_LASTNAME;
    public static final int RECORDADDRESSNAME_FIRSTNAME;
    public static final int RECORDADDRESSNAME_POS;
    public static final int JOBMODIFICATION_NEW;
    public static final int JOBMODIFICATION_CHANGE;
    public static final int JOBMODIFICATION_CANCEL;
    public static final int POITYPE_NOPOI;
    public static final int POITYPE_ACCOMODATION;
    public static final int POITYPE_AIRPORT;
    public static final int POITYPE_ALLRESTAURANTS;
    public static final int POITYPE_AMUSEMENTPARK;
    public static final int POITYPE_APPAREL;
    public static final int POITYPE_ATMCASHPOINT;
    public static final int POITYPE_ATTRACTION;
    public static final int POITYPE_AUTOMOBILECLUB;
    public static final int POITYPE_BANKINGANDSHOPPING;
    public static final int POITYPE_BANKING;
    public static final int POITYPE_BANQUETHALLS;
    public static final int POITYPE_BARSANDLOUNGE;
    public static final int POITYPE_BOATING;
    public static final int POITYPE_BOOKSTORE;
    public static final int POITYPE_BORDERCROSS;
    public static final int POITYPE_BOWLING;
    public static final int POITYPE_BROADCASTING;
    public static final int POITYPE_BUSINESSANDSERVICE;
    public static final int POITYPE_BUSINESS;
    public static final int POITYPE_BUSSTATION;
    public static final int POITYPE_CAMPING;
    public static final int POITYPE_CARANDTRAVEL;
    public static final int POITYPE_CARTRACK;
    public static final int POITYPE_CARTRAIN;
    public static final int POITYPE_CARSERVICE;
    public static final int POITYPE_CARWASH;
    public static final int POITYPE_CASINO;
    public static final int POITYPE_CEMETRY;
    public static final int POITYPE_CITYHALL;
    public static final int POITYPE_COFFEE;
    public static final int POITYPE_COMMUTERRAILSTATION;
    public static final int POITYPE_CLEANINGLAUNCH;
    public static final int POITYPE_CLOTHINGSTORE;
    public static final int POITYPE_COMMUNICATION;
    public static final int POITYPE_COMMUNITYCENTER;
    public static final int POITYPE_COMPUTERHARDWARESOFTWARE;
    public static final int POITYPE_CONVENIENCESTORE;
    public static final int POITYPE_CONVENTIONCENTER;
    public static final int POITYPE_CORPORATIONS;
    public static final int POITYPE_CORPORATIONPUBLICPLACES;
    public static final int POITYPE_CULTUREFACILITY;
    public static final int POITYPE_COURT;
    public static final int POITYPE_DEPARTMENTSTORE;
    public static final int POITYPE_DININGANDENTERTAINMENT;
    public static final int POITYPE_DINNINGSHOPPING;
    public static final int POITYPE_DISCOUNTSTORE;
    public static final int POITYPE_EDUCATION;
    public static final int POITYPE_ELECTRONICS;
    public static final int POITYPE_EMBASSY;
    public static final int POITYPE_EMERGENCY;
    public static final int POITYPE_EMERGENCYANDPUBLIC;
    public static final int POITYPE_ENTERTAINMENT;
    public static final int POITYPE_FASTFOOD;
    public static final int POITYPE_FERRY;
    public static final int POITYPE_FIREDEPARTMENT;
    public static final int POITYPE_FLOORINGANDCARPETING;
    public static final int POITYPE_FLOWERANDJEWELRY;
    public static final int POITYPE_FOODANDBEAVERAGE;
    public static final int POITYPE_FUNTERALDIRECTOR;
    public static final int POITYPE_FURNITURE;
    public static final int POITYPE_GAMESMUSICANDVIDEO;
    public static final int POITYPE_GARDENANDOTHER;
    public static final int POITYPE_GASSTATION;
    public static final int POITYPE_GASSTATIONDIESELGASSTATIONLPG;
    public static final int POITYPE_GENERAL;
    public static final int POITYPE_GIFTSANDLEISURE;
    public static final int POITYPE_GIFTSANTIQUESANDARTS;
    public static final int POITYPE_GLASSANDWINDOW;
    public static final int POITYPE_GOLFING;
    public static final int POITYPE_GOVERMENT;
    public static final int POITYPE_GROCERYSTORES;
    public static final int POITYPE_GUESTHOUSE;
    public static final int POITYPE_HAIRANDBEAUTY;
    public static final int POITYPE_HARBOR;
    public static final int POITYPE_HARDWAREANDLUMBER;
    public static final int POITYPE_HEALTHANDFITNESS;
    public static final int POITYPE_HEALTHCARE;
    public static final int POITYPE_HIGHRISEBLDG;
    public static final int POITYPE_HOMEANDIMPROVEMENT;
    public static final int POITYPE_HOMECENTER;
    public static final int POITYPE_HOMESERVICE;
    public static final int POITYPE_HOSPITAL;
    public static final int POITYPE_HOTELMOTEL;
    public static final int POITYPE_ICESKATING;
    public static final int POITYPE_INSURANCE;
    public static final int POITYPE_KARAOKAY;
    public static final int POITYPE_LIBRARY;
    public static final int POITYPE_LIQGASSTATION;
    public static final int POITYPE_MAJORAPPLIANCE;
    public static final int POITYPE_MENSAPPAREL;
    public static final int POITYPE_MONUMENT;
    public static final int POITYPE_MOTORWAYEXIT;
    public static final int POITYPE_MOTORWAYCROSS;
    public static final int POITYPE_MOTORWAYSERVIE;
    public static final int POITYPE_MOVIETHEATER;
    public static final int POITYPE_MOVINGANDSTORAGE;
    public static final int POITYPE_MUSEUM;
    public static final int POITYPE_NIGHTCLUBS;
    public static final int POITYPE_OPTICAL;
    public static final int POITYPE_RESTAURANT;
    public static final int POITYPE_PARKANDFITNESS;
    public static final int POITYPE_PARKANDRIDE;
    public static final int POITYPE_PARKING;
    public static final int POITYPE_PARKINGGARAGE;
    public static final int POITYPE_PARKS;
    public static final int POITYPE_PERFORMINGARTS;
    public static final int POITYPE_PERSONALSERVICE;
    public static final int POITYPE_PHARMACIES;
    public static final int POITYPE_PHOTOGRAPHER;
    public static final int POITYPE_PLACEORWORKSHIP;
    public static final int POITYPE_POLICESTATION;
    public static final int POITYPE_POSTOFFICE;
    public static final int POITYPE_PUBLICPLACES;
    public static final int POITYPE_PUBLISHER;
    public static final int POITYPE_RAILWAYSTATION;
    public static final int POITYPE_RECREATION;
    public static final int POITYPE_RENTALSERVICE;
    public static final int POITYPE_REPAIR;
    public static final int POITYPE_RESTAREA;
    public static final int POITYPE_RETIREMENTNURSING;
    public static final int POITYPE_SEARCH;
    public static final int POITYPE_SERVICE;
    public static final int POITYPE_SHOESTORES;
    public static final int POITYPE_SHOPPINGCENTER;
    public static final int POITYPE_SKIING;
    public static final int POITYPE_SOCIALSERVICE;
    public static final int POITYPE_SPECIALITYCLOTHING;
    public static final int POITYPE_SPECIALITYSTORE;
    public static final int POITYPE_SPECIALITYFOOD;
    public static final int POITYPE_SPORTGOODS;
    public static final int POITYPE_SPORTS;
    public static final int POITYPE_SPORTAIRPORT;
    public static final int POITYPE_SPORTSCOMPLEX;
    public static final int POITYPE_TAILOR;
    public static final int POITYPE_TAXSERVICE;
    public static final int POITYPE_TOOLBOOTH;
    public static final int POITYPE_TOURISTATTRACTION;
    public static final int POITYPE_TOURISTINFORMATION;
    public static final int POITYPE_TRAINSTATION;
    public static final int POITYPE_TRANSPORTATION;
    public static final int POITYPE_TRAVEL;
    public static final int POITYPE_TRAVELAGENT;
    public static final int POITYPE_UNIVERSITY;
    public static final int POITYPE_UTILITIES;
    public static final int POITYPE_VARIETYSTORE;
    public static final int POITYPE_WINEANDLIQUOR;
    public static final int POITYPE_WOMENSAPPAREL;
    public static final int POITYPE_WINERY;
    public static final int POITYPE_CARREPAIRSHOPVW;
    public static final int POITYPE_CARREPAIRSHOPAUDI;
    public static final int POITYPE_CARREPAIRSHOPSEAT;
    public static final int POITYPE_CARREPAIRSHOPSKODA;
    public static final int POITYPE_CARREPAIRSHOPVWNUTZFAHRZEUGE;
    public static final int POITYPE_CARREPAIRSHOPBENTLEY;
    public static final int POITYPE_CARREPAIRSHOPBUGATTI;
    public static final int POITYPE_CARREPAIRSHOPLAMBORGHINI;
    public static final int POITYPE_CARREPAIRSHOPSCANIA;
    public static final int POITYPE_CARREPAIRSHOPMAN;
    public static final int POITYPE_CARREPAIRSHOPPORSCHE;
    public static final int POITYPE_ELECTRICALSERVICESTATION;
    public static final int POITYPE_DIESELFUELSTATION;
    public static final int POITYPE_CNGFUELSTATION;
    public static final int POITYPE_RESTAREA2;
    public static final int POITYPE_RESTAREAWITHWC;
    public static final int POITYPE_MOTORWAYSERVICEAREA;
    public static final int POITYPE_UNKNOWN;
    public static final int ADDRESSTYPE_PRIVATE;
    public static final int ADDRESSTYPE_BUSINESS;
    public static final int ADDRESSTYPE_BUSINESSPARCELADDRESS;
    public static final int REQUESTEDLIST_ADDRESSLIST;
    public static final int REQUESTEDLIST_FAVORITEDESTLIST;
    public static final int REQUESTEDLIST_LASTDESTLIST;
    public static final int REQUESTEDLIST_NAVBOOK;
    public static final int REQUESTEDLIST_POILIST;
    public static final int MODE_SHIFT;
    public static final int MODE_ARRAYDIRECTION;
    public static final int MODE_ARRAYPOSTRANSMITTED;
    public static final int MODE_INDEXSIZE;
    public static final int MODE_CENTERPOSITION;
    public static final int MODE_INDEXSIZE64BIT;
    public static final int SENDREASON_REQUESTED;
    public static final int SENDREASON_CHANGEDARRAY;
    public static final int SENDREASON_JOBLIST;
    public static final int JOBSRESULT_JOBEXECUTEDSUCCESSFULLY;
    public static final int JOBSRESULT_JOBCANCELLEDDUETOERRORSINREQUEST;
    public static final int JOBSRESULT_JOBCANCELLEDBYFSG;
    public static final int JOBSRESULT_JOBCANCELLEDSUCCESSFULLYBYASG;
    public static final int JOBSRESULT_JOBCANCELLEDUNSUCCESSFULLYALREADYINEXECUTION;
    public static final int JOBSRESULT_ALLJOBSEXECUTEDSUCCESSFULLY;
    public static final int JOBSRESULT_ALLJOBSCANCELLED;

    default public void pushFunctionAvailabilityNavigation(int n) {
    }

    default public void pushMOSTOperationStateNavigation(int n) {
    }

    default public void responseNavBook(int n, int n2, int n3, int n4, int n5, long l, int n6, int n7, int n8, int n9, int n10, int n11, int n12) {
    }

    default public void responseNavBookArray(int n, int n2, DataAddress[] dataAddressArray) {
    }

    default public void responseGetInitialsNavigation(int n, int n2, int n3, int n4, DataInitials[] dataInitialsArray) {
    }

    default public void pushLastDestList(int n, int n2, DataAddress[] dataAddressArray) {
    }

    default public void pushUpdateFavoriteDestList(int n, int n2, DataAddress[] dataAddressArray) {
    }

    default public void pushCurrentListSizeNavigation(int n, int n2, int n3) {
    }

    default public void responseNavBookJobs(int n, int n2, int n3) {
    }

    default public void responseNotifyCurrentListSizesNavigation(boolean bl) {
    }

    default public void responseNotifyFavoriteDestList(boolean bl) {
    }

    default public void responseNotifyLastDestList(boolean bl) {
    }
}

