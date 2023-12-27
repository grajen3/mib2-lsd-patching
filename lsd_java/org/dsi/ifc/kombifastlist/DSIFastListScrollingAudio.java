/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombifastlist;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.kombifastlist.DataCommonList;
import org.dsi.ifc.kombifastlist.DataMediaBrowser;
import org.dsi.ifc.kombifastlist.DataReceptionList;

public interface DSIFastListScrollingAudio
extends DSIBase {
    public static final String VERSION;
    public static final int IN_INDICATIONMEDIABROWSER;
    public static final int IN_INDICATIONNOTIFYCOMMONLISTPUSH;
    public static final int IN_INDICATIONNOTIFYRECEPTIONLISTPUSH;
    public static final int IN_INDICATIONNOTIFYCURRENTLISTSIZEAUDIO;
    public static final int IN_INDICATIONMEDIABROWSERJOBS;
    public static final int RT_PUSHFUNCTIONAVAILABILITYAUDIO;
    public static final int RT_PUSHMOSTOPERATIONSTATEAUDIO;
    public static final int RT_RESPONSEMEDIABROWSER;
    public static final int RT_RESPONSEMEDIABROWSERARRAY;
    public static final int RT_PUSHCOMMONLIST;
    public static final int RT_PUSHRECEPTIONLIST;
    public static final int RT_PUSHCURRENTLISTSIZEAUDIO;
    public static final int RT_RESPONSEMEDIABROWSERJOBS;
    public static final int RT_RESPONSENOTIFYCOMMONLISTPUSH;
    public static final int RT_RESPONSENOTIFYCURRENTLISTSIZEAUDIO;
    public static final int RT_RESPONSENOTIFYRECEPTIONLIST;
    public static final int FUNCTIONAVAILABILITY_MEDIABROWSER;
    public static final int FUNCTIONAVAILABILITY_RECEPTIONLISTPUSH;
    public static final int FUNCTIONAVAILABILITY_COMMONLISTPUSH;
    public static final int FUNCTIONAVAILABILITY_MEDIABROWSERJOBS;
    public static final int OPSTATE_NORMAL;
    public static final int OPSTATE_OFFSTBY;
    public static final int OPSTATE_INITIALISING;
    public static final int OPSTATE_DEFECTIVE;
    public static final int ASGID_DEFAULT;
    public static final int ASGID_INSTRUMENTCLUSTER;
    public static final int ASGID_HEADUPDISPLAY;
    public static final int RECORDADDRESSMEDIABROWSER_FULL;
    public static final int RECORDADDRESSMEDIABROWSER_TYPSTATE;
    public static final int RECORDADDRESSMEDIABROWSER_NAME;
    public static final int RECORDADDRESSMEDIABROWSER_POSS;
    public static final int JOBMODIFICATION_NEW;
    public static final int JOBMODIFICATION_CHANGE;
    public static final int JOBMODIFICATION_CANCEL;
    public static final int SENDREASON_REQUESTED;
    public static final int SENDREASON_CHANGEDARRAY;
    public static final int SENDREASON_JOBLIST;
    public static final int MODE_SHIFT;
    public static final int MODE_ARRAYDIRECTION;
    public static final int MODE_ARRAYPOSTRANSMITTED;
    public static final int MODE_INDEXSIZE;
    public static final int MODE_CENTERPOSITION;
    public static final int MODE_INDEXSIZE64BIT;
    public static final int ELEMENTTYPE_ENSEMLBLES;
    public static final int ELEMENTTYPE_PRIMARYSERVICES;
    public static final int ELEMENTTYPE_SECONDARYPRIMARYSERVICES;
    public static final int ELEMENTTYPE_FLATLISTFULL;
    public static final int ELEMENTTYPE_FLATLISTSERVICES;
    public static final int ELEMENTTYPE_FLATLISTPRIMARY;
    public static final int JOBSRESULT_JOBEXECUTEDSUCCESSFULLY;
    public static final int JOBSRESULT_JOBCANCELLEDDUETOERRORSINREQUEST;
    public static final int JOBSRESULT_JOBCANCELLEDBYFSG;
    public static final int JOBSRESULT_JOBCANCELLEDSUCCESSFULLYBYASG;
    public static final int JOBSRESULT_JOBCANCELLEDUNSUCCESSFULLYALREADYINEXECUTION;
    public static final int JOBSRESULT_ALLJOBSEXECUTEDSUCCESSFULLY;
    public static final int JOBSRESULT_ALLJOBSCANCELLED;
    public static final int FILETYPE_ANYTYPEUNKNOWN;
    public static final int FILETYPE_DIRECTORYFOLDER;
    public static final int FILETYPE_ITEMTRACK;
    public static final int FILETYPE_PLAYLIST;
    public static final int FILETYPE_PLAYLISTFOLDER;
    public static final int FILETYPE_UNKNOWNCATEGORY;
    public static final int FILETYPE_AUDIOFILE;
    public static final int FILETYPE_VIDEOFILE;
    public static final int FILETYPE_CDAUDIOTRACK;
    public static final int FILETYPE_CDAUDIOTRACKCDTEXT;
    public static final int FILETYPE_VOICEMEMOFILE;
    public static final int FILETYPE_IMAGEFILE;
    public static final int FILETYPE_AUDIOFOLDER;
    public static final int FILETYPE_VIDEOFOLDER;
    public static final int FILETYPE_IMAGEFOLDER;
    public static final int FILETYPE_VOICEMEMOFOLDER;
    public static final int FILETYPE_CATEGORYGENRES;
    public static final int FILETYPE_CATEGORYUNKNOWNGENRE;
    public static final int FILETYPE_CATEGORYUNKNOWNGENRES;
    public static final int FILETYPE_CATEGORYARTIST;
    public static final int FILETYPE_CATEGORYARTISTS;
    public static final int FILETYPE_CATEGORYUNKNOWNARTIST;
    public static final int FILETYPE_CATEGORYUNKNOWNARTISTS;
    public static final int FILETYPE_CATEGORYCOMPOSER;
    public static final int FILETYPE_CATEGORYCOMPOSERS;
    public static final int FILETYPE_CATEGORYUNKNOWNCOMPOSER;
    public static final int FILETYPE_CATEGORYUNKNOWNCOMPOSERS;
    public static final int FILETYPE_CATEGORYYEAR;
    public static final int FILETYPE_CATEGORYUNKNOWNYEAR;
    public static final int FILETYPE_CATEGORYCOMMENT;
    public static final int FILETYPE_CATEGORYUNKNOWNCOMMENT;
    public static final int FILETYPE_CATEGORYALBUM;
    public static final int FILETYPE_CATEGORYALBUMS;
    public static final int FILETYPE_CATEGORYUNKNOWNALBUM;
    public static final int FILETYPE_CATEGORYUNKNOWNALBUMS;
    public static final int FILETYPE_CATEGORYSONG;
    public static final int FILETYPE_CATEGORYSONGS;
    public static final int FILETYPE_CATEGORYUNKNOWNSONG;
    public static final int FILETYPE_CATEGORYUNKNOWNSONGS;
    public static final int FILETYPE_CATEGORYAUDIOBOOK;
    public static final int FILETYPE_CATEGORYAUDIOBOOKS;
    public static final int FILETYPE_CATEGORYALL;
    public static final int FILETYPE_CATEGORYPODCAST;
    public static final int FILETYPE_CATEGORYPODCASTS;
    public static final int FILETYPE_CATEGORYDYNAMICPLAYLISTNOTRATED;
    public static final int FILETYPE_CATEGORYDYNAMICPLAYLIST1STAR;
    public static final int FILETYPE_CATEGORYDYNAMICPLAYLIST2STAR;
    public static final int FILETYPE_CATEGORYDYNAMICPLAYLIST3STAR;
    public static final int FILETYPE_CATEGORYDYNAMICPLAYLIST4STAR;
    public static final int FILETYPE_CATEGORYDYNAMICPLAYLIST5STAR;
    public static final int FILETYPE_CATEGORYDYNAMICPLAYLISTMOSTPLAYED;
    public static final int FILETYPE_CATEGORYDYNAMICPLAYLISTLASTPLAYED;
    public static final int FILETYPE_CATEGORYDYNAMICPLAYLISTONTHEGO;
    public static final int FILETYPE_CATEGORYDYNAMICPLAYLISTS;
    public static final int FILETYPE_CATEGORYMOVIES;
    public static final int FILETYPE_CATEGORYMUSICVIDEOS;
    public static final int FILETYPE_CATEGORYVIDEOPODCASTS;
    public static final int FILETYPE_CATEGORYBORROWEDVIDEOS;
    public static final int FILETYPE_CATEGORYLASTCOPIEDFILES;
    public static final int FILETYPE_CATEGORYFAVORITES;
    public static final int FILETYPE_CATEGORYUNKNOWNPODCAST;
    public static final int FILETYPE_CATEGORYUNKNOWNPODCASTS;
    public static final int FILETYPE_CATEGORYVARIOUSARTISTS;
    public static final int FILETYPE_DVDMAINMENUE;
    public static final int FILETYPE_DVDCHAPTER;
    public static final int FILETYPE_DVDTITLE;
    public static final int FILETYPE_CATEGORYUNKNOWNAUDIOBOOK;
    public static final int FILETYPE_CATEGORYUNKNOWNAUDIOBOOKS;
    public static final int FILETYPE_CATEGORYMOOD;
    public static final int FILETYPE_CATEGORYUNKNOWNMOOD;
    public static final int FILETYPE_NOTSUPPORTED;
    public static final int FILESTATE_EMPTYFOLDER;
    public static final int FILESTATE_DRMPROTECTED;
    public static final int FILESTATE_CORRUPTFILEFOLDER;
    public static final int FILESTATE_DEADLINK;
    public static final int FILESTATE_IMPORTRUNNING;
    public static final int FILESTATE_IMPORTPENDING;
    public static final int FILESTATE_IMPORTNOTPLAYABLE;

    default public void pushFunctionAvailabilityAudio(int n) {
    }

    default public void pushMOSTOperationStateAudio(int n) {
    }

    default public void responseMediaBrowser(int n, int n2, int n3, int n4, int n5, int n6, int n7, long l, int n8, long l2, long l3, int n9, int n10, int n11) {
    }

    default public void responseMediaBrowserArray(long l, int n, DataMediaBrowser[] dataMediaBrowserArray) {
    }

    default public void pushCommonList(long l, int n, DataCommonList[] dataCommonListArray) {
    }

    default public void pushReceptionList(long l, int n, DataReceptionList[] dataReceptionListArray) {
    }

    default public void pushCurrentListSizeAudio(int n, int n2, int n3) {
    }

    default public void responseMediaBrowserJobs(long l, int n, int n2) {
    }

    default public void responseNotifyCommonListPush(boolean bl) {
    }

    default public void responseNotifyCurrentListSizeAudio(boolean bl) {
    }

    default public void responseNotifyReceptionList(boolean bl) {
    }
}

