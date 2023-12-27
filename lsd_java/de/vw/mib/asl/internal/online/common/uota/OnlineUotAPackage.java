/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.common.uota;

import org.dsi.ifc.uota.PackageInfo;

public class OnlineUotAPackage
extends PackageInfo {
    private String _serverName;
    private boolean _packageEnabled;
    private int _packageState;
    private int _progressState;
    private int _selectedState;
    private int _downloadState;
    private int _index;
    private boolean _hasSubPackages;
    private int _selectionType;
    private int _packetType;
    public static final int PACKET_TYPE_NONE;
    public static final int PACKET_TYPE_PPOI;
    public static final int PACKET_TYPE_NAVDATA;

    public OnlineUotAPackage(PackageInfo packageInfo, int n) {
        super(packageInfo.symbolicName, packageInfo.category, packageInfo.version, packageInfo.hierarchyInfo, packageInfo.priority, packageInfo.label, packageInfo.size, packageInfo.type, packageInfo.extras);
        this.setServerName("");
        this.setPackageEnabled(true);
        this.setPackageState(0);
        this.setProgressState(0);
        this._selectedState = n;
        this._downloadState = -1;
        this._hasSubPackages = false;
        this.setSelectionType(0);
        this._packetType = 0;
        this._index = -1;
    }

    public OnlineUotAPackage(PackageInfo packageInfo, String string, int n) {
        super(packageInfo.symbolicName, packageInfo.category, packageInfo.version, packageInfo.hierarchyInfo, packageInfo.priority, packageInfo.label, packageInfo.size, packageInfo.type, packageInfo.extras);
        this.setServerName(string);
        this.setPackageEnabled(true);
        this.setPackageState(0);
        this.setProgressState(0);
        this._selectedState = n;
        this._downloadState = -1;
        this._hasSubPackages = false;
        this.setSelectionType(0);
        this._packetType = 0;
        this._index = -1;
    }

    public String getServerName() {
        return this._serverName;
    }

    public void setServerName(String string) {
        this._serverName = string;
    }

    public int getIndex() {
        return this._index;
    }

    public void setIndex(int n) {
        this._index = n;
    }

    public boolean isPackageEnabled() {
        return this._packageEnabled;
    }

    public void setPackageEnabled(boolean bl) {
        this._packageEnabled = bl;
    }

    public int getPackageState() {
        return this._packageState;
    }

    public void setPackageState(int n) {
        this._packageState = n;
    }

    public int getProgressState() {
        return this._progressState;
    }

    public void setProgressState(int n) {
        this._progressState = n;
    }

    public int getSelectedState() {
        return this._selectedState;
    }

    public void setSelectedState(int n) {
        this._selectedState = n;
    }

    public int getDownloadState() {
        return this._downloadState;
    }

    public void setDownloadState(int n) {
        this._downloadState = n;
    }

    public boolean hasSubPackages() {
        return this._hasSubPackages;
    }

    public void setHasSubPackages(boolean bl) {
        this._hasSubPackages = bl;
    }

    public int getSelectionType() {
        return this._selectionType;
    }

    public void setSelectionType(int n) {
        this._selectionType = n;
    }

    public int getPacketType() {
        return this._packetType;
    }

    public void setPacketType(int n) {
        this._packetType = n;
    }

    public void reset() {
        this.setPackageEnabled(true);
        this.setPackageState(0);
        this.setProgressState(0);
        this._selectedState = 0;
        this._downloadState = -1;
        this._hasSubPackages = false;
        this._selectionType = 0;
        this._index = -1;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(450);
        stringBuffer.append("OnlineUotAPackage");
        stringBuffer.append('(');
        stringBuffer.append("symbolicName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.symbolicName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("category");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.category);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("priority");
        stringBuffer.append('=');
        stringBuffer.append(this.priority);
        stringBuffer.append(',');
        stringBuffer.append("label");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.label);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("size");
        stringBuffer.append('=');
        stringBuffer.append(this.size);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("index");
        stringBuffer.append('=');
        stringBuffer.append(this._index);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("extras");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.extras);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("serverName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this._serverName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("packageEnabled");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this._packageEnabled);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("packageState");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this._packageState);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("progressState");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this._progressState);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("selectedState");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this._selectedState);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("downloadState");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this._downloadState);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

