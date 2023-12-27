/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.personal;

import de.vw.mib.asl.api.car.logger.CarLogger;
import de.vw.mib.asl.internal.car.framework.arrays.BapArrayFactory;
import de.vw.mib.asl.internal.car.personal.DriverListElement;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.asg.ASGArrayListDelegate;
import de.vw.mib.bap.array.logger.Logger;
import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.requests.BAPSetGetArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import org.dsi.ifc.carcomfort.DSICarComfort;
import org.dsi.ifc.carcomfort.DoorLockingUserListRA1;
import org.dsi.ifc.carcomfort.DoorLockingUserListUpdateInfo;

public class DriverListDSIDelegater
implements ASGArrayListDelegate,
Logger {
    private static final int DEFAULT_DRIVER_PROFILE_LIST_SIZE;
    private DSICarComfort dsiCarComfort;
    private CarLogger logger;
    private int maximalRequestableElementsRA1;
    private int totalElementsRAF;

    public DriverListDSIDelegater(DSICarComfort dSICarComfort, CarLogger carLogger) {
        this.dsiCarComfort = dSICarComfort;
        this.logger = carLogger;
    }

    @Override
    public boolean continueLoading(ASGArrayList aSGArrayList) {
        return true;
    }

    @Override
    public int getDefaultRecordAddress(ASGArrayList aSGArrayList) {
        return 1;
    }

    @Override
    public Logger getLogger(ASGArrayList aSGArrayList) {
        return this;
    }

    private CarLogger getContextLogger() {
        return this.logger;
    }

    @Override
    public int getMaxRequestableElements(ASGArrayList aSGArrayList, int n) {
        switch (n) {
            case 1: {
                return this.maximalRequestableElementsRA1;
            }
            case 15: {
                return this.totalElementsRAF;
            }
        }
        return 4;
    }

    @Override
    public void requestGetArray(ASGArrayList aSGArrayList, BAPGetArray bAPGetArray) {
        this.dsiCarComfort.requestDoorLockingUserList(DriverListDSIDelegater.toDoorLockingArrayHeader(bAPGetArray));
    }

    @Override
    public void requestSetGetArray(ASGArrayList aSGArrayList, BAPSetGetArray bAPSetGetArray) {
        BAPArrayElement[] bAPArrayElementArray = bAPSetGetArray.getArrayData().toArray();
        DoorLockingUserListRA1[] doorLockingUserListRA1Array = new DoorLockingUserListRA1[bAPArrayElementArray.length];
        for (int i2 = 0; i2 < doorLockingUserListRA1Array.length; ++i2) {
            DriverListElement driverListElement = (DriverListElement)bAPArrayElementArray[i2];
            doorLockingUserListRA1Array[i2] = new DoorLockingUserListRA1(driverListElement.getPos(), driverListElement.userType, driverListElement.userProfileName);
        }
        this.dsiCarComfort.setDoorLockingUserListRA1(DriverListDSIDelegater.toDoorLockingArrayHeader(bAPSetGetArray), doorLockingUserListRA1Array);
    }

    @Override
    public void requestTimeout(ASGArrayList aSGArrayList, int n, boolean bl) {
    }

    private static DoorLockingUserListUpdateInfo toDoorLockingArrayHeader(BAPGetArray bAPGetArray) {
        int n = BapArrayFactory.getInstance().getBAPArrayConverter().toArrayContent(bAPGetArray);
        ArrayHeader arrayHeader = bAPGetArray.getArrayHeader();
        return new DoorLockingUserListUpdateInfo(n, arrayHeader.getRecordAddress(), bAPGetArray.getTransactionId(), arrayHeader.start, arrayHeader.elements, bAPGetArray.getAsgId());
    }

    @Override
    public void log(ASGArrayList aSGArrayList, int n, String string) {
        String string2 = new StringBuffer().append("Personalization: ").append(string).toString();
        switch (n) {
            case 1: {
                this.getContextLogger().fatal(string2);
                break;
            }
            case 2: {
                this.getContextLogger().error(string2);
                break;
            }
            case 4: {
                this.getContextLogger().warn(string2);
                break;
            }
            case 8: {
                this.getContextLogger().info(string2);
                break;
            }
            case 12: {
                this.getContextLogger().normal(string2);
                break;
            }
            case 16: {
                if (!this.getContextLogger().isTraceEnabled()) break;
                this.getContextLogger().trace(string2);
                break;
            }
            default: {
                this.getContextLogger().error("Personalization: Unknown log message called");
            }
        }
    }

    void setTotalNumerOfElements(int n) {
        this.maximalRequestableElementsRA1 = n;
    }

    void setTotalNumerOfElementsRAF(int n) {
        this.totalElementsRAF = n;
    }
}

