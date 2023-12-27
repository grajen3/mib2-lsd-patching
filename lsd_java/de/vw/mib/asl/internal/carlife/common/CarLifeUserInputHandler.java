/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.carlife.common;

import de.vw.mib.asl.internal.carlife.CarlifeHSMTarget;
import de.vw.mib.asl.internal.carlife.common.CarLifeGlobalProperties;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.carlife.TouchEvent;

public class CarLifeUserInputHandler {
    private final String classname;
    private final CarlifeHSMTarget target;
    private final CarLifeGlobalProperties properties;

    public CarLifeUserInputHandler(CarlifeHSMTarget carlifeHSMTarget, CarLifeGlobalProperties carLifeGlobalProperties) {
        this.classname = "CarLifeUserInputHandler";
        Preconditions.checkNotNull(carlifeHSMTarget, "CarlifeHSMTarget must not be null!");
        Preconditions.checkNotNull(carLifeGlobalProperties, "CarlifeGlobalProperties must not be null!");
        this.target = carlifeHSMTarget;
        this.properties = carLifeGlobalProperties;
    }

    public void processTouchEventGesture(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        int n2 = eventGeneric.getInt(1);
        int n3 = eventGeneric.getInt(6);
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append("CarLifeUserInputHandler").append(".handleHmiTouchEventGesture (x,y)=(").append(n).append(",").append(n2).append(")").log();
        }
        int n4 = 0;
        switch (n3) {
            case 0: 
            case 2: {
                n4 = 1;
                break;
            }
            case 1: {
                n4 = 3;
                break;
            }
            case 3: 
            case 4: {
                n4 = 2;
                break;
            }
        }
        if (this.properties.isConnected() && this.properties.isDSIRegistered()) {
            TouchEvent[] touchEventArray = new TouchEvent[]{new TouchEvent(n, n2, n4)};
            this.target.getDSICarLife().postTouchEvent(1, touchEventArray, n4);
        }
    }

    public void processSimpleTouchEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        int n2 = eventGeneric.getInt(1);
        int n3 = eventGeneric.getInt(2);
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append("CarLifeUserInputHandler").append(".handleHmiSimpleTouchEvent (x,y)=(").append(n).append(",").append(n2).append(")").log();
        }
        int n4 = 0;
        switch (n3) {
            case 0: {
                n4 = 1;
                break;
            }
            case 1: {
                n4 = 3;
                break;
            }
            case 2: {
                n4 = 2;
                break;
            }
        }
        if (this.properties.isConnected() && this.properties.isDSIRegistered()) {
            TouchEvent[] touchEventArray = new TouchEvent[]{new TouchEvent(n, n2, n4)};
            this.target.getDSICarLife().postTouchEvent(1, touchEventArray, n4);
        }
    }

    public void processRotaryEvent(EventGeneric eventGeneric) {
        if (this.properties.isConnected() && this.properties.isDSIRegistered()) {
            int n = eventGeneric.getInt(0);
            if (n == 0) {
                this.target.getDSICarLife().postRotaryEvent(-1);
            } else if (n == 1) {
                this.target.getDSICarLife().postRotaryEvent(1);
            } else if (n == 2) {
                this.target.getDSICarLife().postButtonEvent(1, 0);
            } else if (n == 4) {
                this.target.getDSICarLife().postButtonEvent(1, 1);
            }
        }
    }

    public void processMflEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append("CarLifeUserInputHandler").append(".handleHmiMflEvent(gesture=").append(n).log();
        }
        if (this.properties.isConnected() && this.properties.isDSIRegistered()) {
            switch (n) {
                case 0: {
                    this.target.getDSICarLife().postButtonEvent(13, 0);
                    this.target.getDSICarLife().postButtonEvent(13, 1);
                    break;
                }
                case 1: {
                    this.target.getDSICarLife().postButtonEvent(15, 0);
                    break;
                }
                case 2: {
                    this.target.getDSICarLife().postButtonEvent(14, 0);
                    this.target.getDSICarLife().postButtonEvent(14, 1);
                    break;
                }
                case 3: {
                    this.target.getDSICarLife().postButtonEvent(16, 1);
                    break;
                }
                case 4: {
                    this.target.getDSICarLife().postButtonEvent(15, 1);
                    break;
                }
                case 5: {
                    this.target.getDSICarLife().postButtonEvent(16, 0);
                    break;
                }
                case 6: {
                    break;
                }
                case 7: {
                    break;
                }
                case 8: {
                    break;
                }
                case 9: 
                case 10: {
                    break;
                }
                case 11: {
                    this.target.getDSICarLife().postButtonEvent(17, 0);
                    break;
                }
                case 12: {
                    this.target.getDSICarLife().postButtonEvent(17, 1);
                    break;
                }
            }
        }
    }
}

