/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.ext;

import de.vw.mib.asl.api.navigation.INavigationPosPosition;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.INavigationPosPositionHelper;
import org.dsi.ifc.navigation.PosPosition;

public class INavigationPosPositionImpl
implements INavigationPosPosition,
INavigationPosPositionHelper {
    private PosPosition currentPosition = null;
    private static final String SEPERATOR;
    private double[] latMinSec = null;
    private double[] lonMinSec = null;

    public INavigationPosPositionImpl(PosPosition posPosition) {
        this.currentPosition = posPosition;
        this.latMinSec = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().dsiToDegMinSec(this.currentPosition.getLatitude());
        this.lonMinSec = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().dsiToDegMinSec(this.currentPosition.getLongitude());
    }

    @Override
    public PosPosition getCurrentPosition() {
        return this.currentPosition;
    }

    public String toString() {
        if (this.currentPosition != null) {
            return this.currentPosition.toString();
        }
        return super.toString();
    }

    @Override
    public int getNorthDirection() {
        if (this.currentPosition != null) {
            return this.currentPosition.getDirectionAngle();
        }
        return 0;
    }

    @Override
    public int getAltitude() {
        if (this.currentPosition != null) {
            return this.currentPosition.getHeight();
        }
        return 0;
    }

    @Override
    public int getGPSStatus() {
        if (this.currentPosition != null) {
            return this.currentPosition.getState();
        }
        return 0;
    }

    @Override
    public String getHdopVdop() {
        if (this.currentPosition != null) {
            return new StringBuffer().append(this.currentPosition.getHdop()).append("/").append(this.currentPosition.getVdop()).toString();
        }
        return null;
    }

    @Override
    public int getSatellites() {
        if (this.currentPosition != null) {
            return this.currentPosition.getVisibleSatellites();
        }
        return 0;
    }

    @Override
    public int getTrackedSatellites() {
        if (this.currentPosition != null) {
            return this.currentPosition.getVisibleSatellites();
        }
        return 0;
    }

    @Override
    public int getUsedSatellites() {
        if (this.currentPosition != null) {
            return this.currentPosition.getUsedSatellites();
        }
        return 0;
    }

    @Override
    public int getVisibleSatellites() {
        if (this.currentPosition != null) {
            return this.currentPosition.getVisibleSatellites();
        }
        return 0;
    }

    @Override
    public int getLatDegree() {
        if (this.latMinSec != null) {
            return (int)this.latMinSec[0];
        }
        return 0;
    }

    @Override
    public int getLatMinutes() {
        if (this.latMinSec != null) {
            return (int)this.latMinSec[1];
        }
        return 0;
    }

    @Override
    public int getLatSeconds() {
        if (this.latMinSec != null) {
            return (int)(10.0 * this.latMinSec[2]);
        }
        return 0;
    }

    @Override
    public int getLonDegree() {
        if (this.lonMinSec != null) {
            return (int)this.lonMinSec[0];
        }
        return 0;
    }

    @Override
    public int getLonMinutes() {
        if (this.lonMinSec != null) {
            return (int)this.lonMinSec[1];
        }
        return 0;
    }

    @Override
    public int getLonSeconds() {
        if (this.lonMinSec != null) {
            return (int)(10.0 * this.lonMinSec[2]);
        }
        return 0;
    }

    @Override
    public int getCompassDegree() {
        if (this.currentPosition != null) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().calculateHeadingValue(this.currentPosition.directionAngle, 11.25);
        }
        return 0;
    }

    @Override
    public double getLatitude() {
        return ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().dsiToDecimal(this.currentPosition.latitude);
    }

    @Override
    public double getLongitude() {
        return ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().dsiToDecimal(this.currentPosition.longitude);
    }

    @Override
    public int getLatitudeDsi() {
        return this.currentPosition.latitude;
    }

    @Override
    public int getLongitudeDsi() {
        return this.currentPosition.longitude;
    }
}

