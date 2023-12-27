/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api.onlineupdatev10.data;

import de.vw.mib.asl.internal.ocu.generated.eni.serializer.ChallengeData_Data;

public class OnlineUpdateChallengeData
implements de.vw.mib.asl.api.ocu.onlineupdatev10.data.OnlineUpdateChallengeData {
    private final int challengeType;
    private final String challenge;

    public OnlineUpdateChallengeData(ChallengeData_Data challengeData_Data) {
        this.challengeType = challengeData_Data.challengeType;
        this.challenge = OnlineUpdateChallengeData.convertCharArrayToHexString(challengeData_Data.challenge.toString().toCharArray());
    }

    @Override
    public String getChallenge() {
        return this.challenge;
    }

    @Override
    public int getChallengeType() {
        return this.challengeType;
    }

    public int hashCode() {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + (this.challenge == null ? 0 : this.challenge.hashCode());
        n2 = 31 * n2 + this.challengeType;
        return n2;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        OnlineUpdateChallengeData onlineUpdateChallengeData = (OnlineUpdateChallengeData)object;
        if (this.challenge == null ? onlineUpdateChallengeData.challenge != null : !this.challenge.equals(onlineUpdateChallengeData.challenge)) {
            return false;
        }
        return this.challengeType == onlineUpdateChallengeData.challengeType;
    }

    public static String convertCharArrayToHexString(char[] cArray) {
        char[] cArray2 = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] cArray3 = new char[cArray.length * 2];
        for (int i2 = 0; i2 < cArray.length; ++i2) {
            int n = cArray[i2] & 0xFF;
            cArray3[i2 * 2] = cArray2[n >>> 4];
            cArray3[i2 * 2 + 1] = cArray2[n & 0xF];
        }
        return new String(cArray3);
    }
}

