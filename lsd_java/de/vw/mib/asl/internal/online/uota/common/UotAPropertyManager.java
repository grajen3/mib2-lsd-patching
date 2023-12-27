/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.uota.common;

import de.vw.mib.asl.api.online.ASLOnlineFactory;
import de.vw.mib.asl.internal.online.common.uota.OnlineUotAPackage;
import de.vw.mib.asl.internal.online.uota.sequence.UotASequence;
import de.vw.mib.util.Util;

public class UotAPropertyManager {
    private boolean _serviceReady = false;
    private String _currentLanguage;
    private boolean _SWDLActive;
    private OnlineUotAPackage _currentPacket;
    private UotASequence _currentSequence;
    private int _downloadState = 0;
    private int _kind = 0;
    private int _progress = 0;
    private String _info;
    private int _packetCount = 0;
    private String[] _serverList;
    private int _togglePacketIndex;
    private boolean _configuredPPOI;
    private boolean _configuredNavDB;
    private boolean _configuredUOTAPPOI;
    private int[] _toggleArrayIndices;
    private int _packetCategory = 0;

    public boolean isUotAServiceReady() {
        return this._serviceReady;
    }

    public void setUotAServiceReady(boolean bl) {
        this._serviceReady = bl;
    }

    public boolean isDownloadForLater() {
        return ASLOnlineFactory.getOnlineCoreServices().getSetCustomerDownloadIndicationStatus(false, 2, false);
    }

    public void setDownloadForLater(boolean bl) {
        ASLOnlineFactory.getOnlineCoreServices().getSetCustomerDownloadIndicationStatus(bl, 2, true);
    }

    public boolean isDownloadTillNextRevision() {
        return ASLOnlineFactory.getOnlineCoreServices().getSetCustomerDownloadIndicationStatus(false, 1, false);
    }

    public void setDownloadTillNextRevision(boolean bl) {
        ASLOnlineFactory.getOnlineCoreServices().getSetCustomerDownloadIndicationStatus(bl, 1, true);
    }

    public boolean isNaviDestinationsTillNextRevision() {
        return ASLOnlineFactory.getOnlineCoreServices().getSetCustomerDownloadIndicationStatus(false, 3, false);
    }

    public void setNaviDestinationsTillNextRevision(boolean bl) {
        ASLOnlineFactory.getOnlineCoreServices().getSetCustomerDownloadIndicationStatus(bl, 3, true);
    }

    public boolean isNaviDestinationsSetForLater() {
        return ASLOnlineFactory.getOnlineCoreServices().getSetCustomerDownloadIndicationStatus(false, 4, false);
    }

    public void setNaviDestinationsForLater(boolean bl) {
        ASLOnlineFactory.getOnlineCoreServices().getSetCustomerDownloadIndicationStatus(bl, 4, true);
    }

    public String getCurrentLanguage() {
        return this._currentLanguage;
    }

    public void setCurrentLanguage(String string) {
        this._currentLanguage = string;
    }

    public boolean isSWDLActive() {
        return this._SWDLActive;
    }

    public void setSWDLActive(boolean bl) {
        this._SWDLActive = bl;
    }

    public OnlineUotAPackage getCurrentPacket() {
        return this._currentPacket;
    }

    public void setCurrentPacket(OnlineUotAPackage onlineUotAPackage) {
        this._currentPacket = onlineUotAPackage;
    }

    public UotASequence getCurrentSequence() {
        return this._currentSequence;
    }

    public void setCurrentSequence(UotASequence uotASequence) {
        this._currentSequence = uotASequence;
    }

    public int getDownloadState() {
        return this._downloadState;
    }

    public void setDownloadState(int n) {
        this._downloadState = n;
    }

    public void setProgress(int n, int n2, String string) {
        this._kind = n;
        this._progress = n2;
        this._info = string;
    }

    public int getDownloadKind() {
        return this._kind;
    }

    public int getDownloadProgress() {
        return this._progress;
    }

    public String getDownloadInfo() {
        return this._info;
    }

    public void setPacketCount(int n) {
        this._packetCount = n;
    }

    public int getPacketCount() {
        return this._packetCount;
    }

    public void setServerList(String[] stringArray) {
        if (!Util.isNullOrEmpty(stringArray)) {
            if (Util.isNullOrEmpty(this._serverList)) {
                this._serverList = stringArray;
            }
            System.arraycopy((Object)stringArray, 0, (Object)this._serverList, 0, stringArray.length);
        }
    }

    public String[] getServerList() {
        return this._serverList;
    }

    public void setTogglePacketIndex(int n) {
        this._togglePacketIndex = n;
    }

    public int getTogglePacketIndex() {
        return this._togglePacketIndex;
    }

    public void setTogglePacketArray(int[] nArray) {
        this._toggleArrayIndices = nArray;
    }

    public int[] getTogglePacketArray() {
        return this._toggleArrayIndices;
    }

    public void setPPOIConfigurationOnly(boolean bl) {
        this._configuredPPOI = bl;
    }

    public boolean isPPOIConfigurationOnly() {
        return this._configuredPPOI;
    }

    public void setNavDBConfigurationOnly(boolean bl) {
        this._configuredNavDB = bl;
    }

    public boolean isNavDBConfigurationOnly() {
        return this._configuredNavDB;
    }

    public void setUOTAPPOIConfigurationOnly(boolean bl) {
        this._configuredUOTAPPOI = bl;
    }

    public boolean isUOTAPPOIConfigurationOnly() {
        return this._configuredUOTAPPOI;
    }

    public void setPacketCategory(int n) {
        this._packetCategory = n;
    }

    public int getPacketCategory() {
        return this._packetCategory;
    }

    public int getCurrentConfiguration() {
        if (this.isNavDBConfigurationOnly() && this.isUOTAPPOIConfigurationOnly()) {
            return 3;
        }
        if (this.isNavDBConfigurationOnly()) {
            return 2;
        }
        if (this.isUOTAPPOIConfigurationOnly()) {
            return 1;
        }
        return 0;
    }
}

