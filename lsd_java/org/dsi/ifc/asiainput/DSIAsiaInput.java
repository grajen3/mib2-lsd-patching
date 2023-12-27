/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.asiainput;

import org.dsi.ifc.asiainput.UserDefinedEntry;
import org.dsi.ifc.asiainput.WordDatabase;
import org.dsi.ifc.base.DSIBase;

public interface DSIAsiaInput
extends DSIBase {
    public static final String VERSION;
    public static final int IN_INDICATEERRORSTATUS;
    public static final int IN_INDICATEDATAINVALIDATED;
    public static final int RP_INITIALIZED;
    public static final int RP_GETVERSIONINFO;
    public static final int RP_BUILTCANDIDATES;
    public static final int RP_GETSPELLING;
    public static final int RP_GETCANDIDATES;
    public static final int RP_GETINTPARAMETER;
    public static final int RP_GETBOOLEANPARAMETER;
    public static final int RP_SETBOOLEANPARAMETERRESULT;
    public static final int RP_SETINTPARAMETERRESULT;
    public static final int RP_SETSTRINGPARAMETERRESULT;
    public static final int RP_GETSTRINGPARAMETER;
    public static final int RP_SELECTEDCANDIDATE;
    public static final int RP_SETADDITIONALWORDDATABASESRESULT;
    public static final int RP_SETUSERDATABASESTATERESULT;
    public static final int RP_RESETTOFACTORYSETTINGSRESULT;
    public static final int RP_GETSEGMENTATION;
    public static final int RP_RESPONSESEGMENTATIONFORTRUFFLES;
    public static final int RT_INITIALIZE;
    public static final int RT_ADDSYMBOL;
    public static final int RT_ADDSYMBOLS;
    public static final int RT_REMOVESYMBOL;
    public static final int RT_REMOVEALLSYMBOLS;
    public static final int RT_CLEAR;
    public static final int RT_BUILDCANDIDATES;
    public static final int RT_GETSPELLING;
    public static final int RT_GETCANDIDATES;
    public static final int RT_SELECTCANDIDATE;
    public static final int RT_SETBOOLEANPARAMETER;
    public static final int RT_SETINTPARAMETER;
    public static final int RT_GETBOOLEANPARAMETER;
    public static final int RT_GETINTPARAMETER;
    public static final int RT_GETVERSIONINFO;
    public static final int RT_SETSTRINGPARAMETER;
    public static final int RT_GETSTRINGPARAMETER;
    public static final int RT_SETPREDICTIONCONTEXT;
    public static final int RT_CLEARPREDICTIONCONTEXT;
    public static final int RT_SETADDITIONALWORDDATABASES;
    public static final int RT_ADDUSERDEFINEDENTRY;
    public static final int RT_SETUSERDATABASESTATE;
    public static final int RT_RESETTOFACTORYSETTINGS;
    public static final int RT_GETSEGMENTATION;
    public static final int RT_REQUESTSEGMENTATIONFORTRUFFLES;

    default public void initialize(int n) {
    }

    default public void addSymbol(char c2) {
    }

    default public void addSymbols(String string) {
    }

    default public void removeSymbol() {
    }

    default public void removeAllSymbols() {
    }

    default public void clear() {
    }

    default public void buildCandidates() {
    }

    default public void getSpelling() {
    }

    default public void getCandidates(int n) {
    }

    default public void selectCandidate(int n) {
    }

    default public void setBooleanParameter(int n, boolean bl) {
    }

    default public void setIntParameter(int n, int n2) {
    }

    default public void getBooleanParameter(int n) {
    }

    default public void getIntParameter(int n) {
    }

    default public void getVersionInfo() {
    }

    default public void setStringParameter(int n, String string) {
    }

    default public void getStringParameter(int n) {
    }

    default public void setPredictionContext(String string) {
    }

    default public void clearPredictionContext() {
    }

    default public void addUserDefinedEntry(UserDefinedEntry userDefinedEntry) {
    }

    default public void setAdditionalWordDatabases(WordDatabase[] wordDatabaseArray) {
    }

    default public void setUserDatabaseState(int n, int n2) {
    }

    default public void resetToFactorySettings() {
    }

    default public void getSegmentation(String string) {
    }

    default public void requestSegmentationForTruffles(String string) {
    }
}

