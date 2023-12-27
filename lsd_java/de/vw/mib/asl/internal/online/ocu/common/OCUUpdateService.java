/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.ocu.common;

import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.util.Util;

public class OCUUpdateService {
    private String _updateID;
    private int _updateState;
    private int _updateProgress;
    private int _hashProcedureVersion;
    private String _description;
    private long _downloadSize;
    private int _estimatedDuration;
    private boolean _serviceInfoChanged;
    private String _mainUser;
    private String _vin;
    private String _sPinNum;
    private String _langauge;
    private IntObjectOptHashMap _challengeData;

    private IntObjectOptHashMap getChallengeDataList() {
        if (this._challengeData == null) {
            this._challengeData = new IntObjectOptHashMap();
        }
        return this._challengeData;
    }

    public String getUpdateID() {
        return this._updateID;
    }

    public void setUpdateID(String string) {
        this._updateID = string;
    }

    public String getLanguage() {
        return this._langauge;
    }

    public void setLanguage(String string) {
        this._langauge = string;
    }

    public int getUpdateState() {
        return this._updateState;
    }

    public void setUpdateState(int n) {
        this.setServiceInfoChanged(this._updateState != n);
        this._updateState = n;
    }

    public int getUpdateProgress() {
        return this._updateProgress;
    }

    public void setUpdateProgress(int n) {
        this._updateProgress = n;
    }

    public int getHashProcedureVersion() {
        return this._hashProcedureVersion;
    }

    public void setHashProcedureVersion(int n) {
        this._hashProcedureVersion = n;
    }

    public String getDescription() {
        return Util.isNullOrEmpty(this._description) ? "" : this._description;
    }

    public void setDescription(String string) {
        this._description = string;
    }

    public long getDownloadSize() {
        return this._downloadSize;
    }

    public void setDownloadSize(long l) {
        this._downloadSize = l;
    }

    public int getEstimatedDuration() {
        return this._estimatedDuration;
    }

    public void setEstimatedDuration(int n) {
        this._estimatedDuration = n;
    }

    public boolean isServiceInfoChanged() {
        return this._serviceInfoChanged;
    }

    public void setServiceInfoChanged(boolean bl) {
        this._serviceInfoChanged = bl;
    }

    public void setUserName(String string) {
        this._mainUser = string;
    }

    public String getUserName() {
        return this._mainUser;
    }

    public void setVINNumber(String string) {
        this._vin = string;
    }

    public String getVINNumber() {
        return this._vin;
    }

    public void setSPinNumeric(String string) {
        this._sPinNum = string;
    }

    public String getSPinNumeric() {
        return this._sPinNum;
    }

    public void addChallengeData(int n, String string) {
        this.getChallengeDataList().put(n, string);
    }

    public void removeChallengeData(int n) {
        if (this.getChallengeDataList().containsKey(n)) {
            this.getChallengeDataList().remove(n);
        }
    }

    public String getChallengeDataWithType(int n) {
        if (this.getChallengeDataList().containsKey(n)) {
            return (String)this.getChallengeDataList().get(n);
        }
        return "";
    }

    public void clearAll() {
        this.getChallengeDataList().clear();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("OCUUpdateService");
        stringBuffer.append('(');
        stringBuffer.append("UpdateID");
        stringBuffer.append('=');
        stringBuffer.append(!Util.isNullOrEmpty(this._updateID) ? this._updateID : "");
        stringBuffer.append(',');
        stringBuffer.append("UpdateState");
        stringBuffer.append('=');
        stringBuffer.append(this._updateState);
        stringBuffer.append(',');
        stringBuffer.append("UpdateProgress");
        stringBuffer.append('=');
        stringBuffer.append(this._updateProgress);
        stringBuffer.append(',');
        stringBuffer.append("HashProcedureVersion");
        stringBuffer.append('=');
        stringBuffer.append(this._hashProcedureVersion);
        stringBuffer.append(',');
        stringBuffer.append("DownloadSize");
        stringBuffer.append('=');
        stringBuffer.append(this._downloadSize);
        stringBuffer.append(',');
        stringBuffer.append("EstimatedDuration");
        stringBuffer.append('=');
        stringBuffer.append(this._estimatedDuration);
        stringBuffer.append(',');
        stringBuffer.append("ServiceInfoChanged");
        stringBuffer.append('=');
        stringBuffer.append(this._serviceInfoChanged);
        stringBuffer.append(',');
        stringBuffer.append("MainUser");
        stringBuffer.append('=');
        stringBuffer.append(!Util.isNullOrEmpty(this._mainUser) ? this._mainUser : "");
        stringBuffer.append(',');
        stringBuffer.append("VIN");
        stringBuffer.append('=');
        stringBuffer.append(!Util.isNullOrEmpty(this._vin) ? this._vin : "");
        stringBuffer.append(',');
        stringBuffer.append("SPIN");
        stringBuffer.append('=');
        stringBuffer.append(!Util.isNullOrEmpty(this._sPinNum) ? this._sPinNum : "");
        stringBuffer.append(',');
        stringBuffer.append("Langauge");
        stringBuffer.append('=');
        stringBuffer.append(!Util.isNullOrEmpty(this._langauge) ? this._langauge : "");
        stringBuffer.append(',');
        stringBuffer.append("ChallengeData");
        stringBuffer.append('=');
        stringBuffer.append(this.getChallengeDataList().isEmpty() ? 0 : this.getChallengeDataList().size());
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

