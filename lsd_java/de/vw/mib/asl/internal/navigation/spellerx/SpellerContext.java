/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.spellerx;

import de.vw.mib.asl.api.navigation.locationinput.ISpellerContext;
import de.vw.mib.asl.api.navigation.locationinput.SpellerHandler;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.asl.AbstractReflectionContext;
import de.vw.mib.asl.internal.navigation.spellerx.SpellerField;
import de.vw.mib.asl.internal.navigation.spellerx.XSpellerTarget;
import de.vw.mib.genericevents.Target;
import org.dsi.ifc.global.NavLocation;

public class SpellerContext
extends AbstractReflectionContext
implements ISpellerContext {
    static IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "SpellerContext");
    private NavLocation location;
    private XSpellerTarget target;
    public static int ACTIVE_STATE = 0;
    public static SpellerField activeField;
    public static int ACTIVE_HISTORY_MODE;
    public static boolean useShortLiValueList;
    public static boolean useShortLiValueListHnr;
    public static boolean cancelFlag;
    public static boolean isPointLocation;
    public static boolean hwrEnabled;
    public static NavLocation originalLocation;
    public static int listSizeLimit;
    public static boolean clearAllCalled;
    public static NavLocation extInterfaceLocation;
    private static int activeExtInterfaceField;

    @Override
    public void setHandler(SpellerHandler spellerHandler) {
        if (spellerHandler == null) {
            this.remove("spellerHandler");
        } else {
            this.put("spellerHandler", spellerHandler);
        }
    }

    @Override
    public SpellerHandler getHandler() {
        return (SpellerHandler)this.get("spellerHandler");
    }

    public SpellerContext(XSpellerTarget xSpellerTarget) {
        this.target = xSpellerTarget;
    }

    @Override
    public void setLocation(NavLocation navLocation) {
        this.location = navLocation;
        SpellerHandler spellerHandler = this.getHandler();
        if (this.target.getLogger().isTraceEnabled()) {
            this.target.getLogger().makeTrace().append(" Speller Context: Setting SpellerContext Location: ").append(this.location).log();
        }
        if (spellerHandler != null && navLocation != null) {
            spellerHandler.onContext(this);
        }
    }

    @Override
    public NavLocation getLocation() {
        if (this.target.getLogger().isTraceEnabled()) {
            this.target.getLogger().makeTrace().append(" Speller Context: Getting SpellerContext Location: ").append(this.location).log();
        }
        return this.location;
    }

    @Override
    public void setState(int n) {
        ACTIVE_STATE = n;
        switch (n) {
            case 1: {
                activeField = this.target.countryField;
                break;
            }
            case 9: {
                activeField = this.target.stateField;
                break;
            }
            case 8: {
                activeField = this.target.provinceField;
                break;
            }
            case 2: {
                activeField = this.target.cityField;
                break;
            }
            case 3: {
                activeField = this.target.streetField;
                break;
            }
            case 4: {
                activeField = this.target.housenumberField;
                break;
            }
            case 5: {
                activeField = this.target.crossingField;
                break;
            }
            case 7: {
                activeField = this.target.streetDisambiguationField;
                break;
            }
            case 10: {
                activeField = this.target.streetWithBasenamesField;
                break;
            }
            case 6: {
                activeField = this.target.postalcodeField;
                break;
            }
            case 11: {
                activeField = this.target.chomeField;
                break;
            }
            case 12: {
                activeField = this.target.placeField;
                break;
            }
            case 13: {
                activeField = this.target.wardField;
                break;
            }
            case 14: {
                activeField = this.target.phoneNumberField;
                break;
            }
            case 15: {
                activeField = this.target.mapcodeField;
                break;
            }
        }
        if (this.target.getLogger().isTraceEnabled()) {
            this.target.getLogger().makeTrace().append(" Speller Context: Active field is now: ").append(activeField.getName()).log();
        }
    }

    @Override
    public int getActiveState() {
        return ACTIVE_STATE;
    }

    public SpellerField getActiveField() {
        return activeField;
    }

    public static void setActiveSpellerField(SpellerField spellerField) {
        activeField = spellerField;
    }

    @Override
    public Target getTarget() {
        return this.target;
    }

    public static void setOriginalLocation(NavLocation navLocation, XSpellerTarget xSpellerTarget) {
        if (logger.isTraceEnabled()) {
            logger.makeTrace().append(" Speller Context: Setting ORIGINAL_LOCATION to: ").append(navLocation).log();
        }
        originalLocation = navLocation;
    }

    public static void setExtInterfaceLocation(NavLocation navLocation) {
        if (logger.isTraceEnabled()) {
            logger.makeTrace().append(" Speller Context: setExtInterfaceLocation to: ").append(navLocation).log();
        }
        extInterfaceLocation = navLocation;
    }

    public NavLocation getExtInterfaceLocation() {
        return extInterfaceLocation;
    }

    public static void setActiveExtInterfaceField(int n) {
        if (logger.isTraceEnabled()) {
            logger.makeTrace().append(" Speller Context: Setting activeExtInterfaceField=").append(n).log();
        }
        activeExtInterfaceField = n;
    }

    public static int getActiveExtInterfaceField() {
        return activeExtInterfaceField;
    }

    static {
        ACTIVE_HISTORY_MODE = 10000;
        useShortLiValueList = false;
        useShortLiValueListHnr = false;
        cancelFlag = false;
        isPointLocation = false;
        hwrEnabled = false;
        listSizeLimit = 5;
        clearAllCalled = false;
        activeExtInterfaceField = 0;
    }
}

