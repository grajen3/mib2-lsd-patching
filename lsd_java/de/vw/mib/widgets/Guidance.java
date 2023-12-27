/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.interfaces.Adjustable;
import de.vw.mib.widgets.models.GuidanceModel;
import de.vw.mib.widgets.models.ViewModel;
import java.util.Arrays;

public class Guidance
extends AbstractWidget
implements GuidanceModel {
    private Image[] mainElementImages;
    private Point[] mainElementImagesPositions;
    private Image[] sideStreetImages;
    private Point[] sideStreetImagesPositions;
    private Image[] distanceImages;
    private Point[] distanceImagesPositions;
    private Image[] zLevelImages;
    private Point zLevelImagesPosition;
    private int mainElement;
    private int direction;
    private int zLevel;
    private String sideRoads;
    private Adjustable[] distanceWidgetRefs;
    private int currentDistancePercent;
    private boolean distanceVisible;
    private Color mainElementColor;
    private int mainElementImageIndex;
    private int distanceImageIndex;
    private int zLevelImageIndex;
    private IntSet sideStreetImageIndices;
    private boolean maneuverInvalid;
    private int bargraphFillingIndex;
    private Color4b mainElementColor4b;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$GuidanceUI;

    @Override
    protected void reset() {
        super.reset();
        this.sideStreetImageIndices = new IntOptHashSet();
        this.sideStreetImages = null;
        this.sideStreetImagesPositions = null;
        this.mainElementImages = null;
        this.zLevelImages = null;
        this.zLevelImagesPosition = null;
        this.sideRoads = null;
        this.distanceWidgetRefs = null;
        this.mainElementColor = null;
        this.mainElementColor4b = Color4b.WHITE;
    }

    public void init(boolean bl, int n, boolean bl2, int n2, int n3, Image[] imageArray, Point[] pointArray, boolean bl3, Adjustable[] adjustableArray, EasingParams[] easingParamsArray, boolean bl4, int n4, boolean bl5, int n5, Color color, Image[] imageArray2, Point[] pointArray2, String string, String string2, Image[] imageArray3, Point[] pointArray3, int n6, Insets insets, boolean bl6, int n7, int n8, int n9, int n10, Image[] imageArray4, Point point) {
        super.init(bl, n, bl2, easingParamsArray, bl4, n4, bl5, string, n6, insets, bl6, n7, n8, n9);
        this.mainElementImages = imageArray2;
        this.mainElementImagesPositions = pointArray2;
        this.sideStreetImages = imageArray3;
        this.sideStreetImagesPositions = pointArray3;
        this.distanceImages = imageArray;
        this.distanceImagesPositions = pointArray;
        this.direction = n3;
        this.mainElement = n5;
        this.sideRoads = string2;
        this.zLevel = n10;
        this.zLevelImages = imageArray4;
        this.zLevelImagesPosition = point;
        this.distanceWidgetRefs = adjustableArray;
        this.currentDistancePercent = n2;
        this.distanceVisible = bl3;
        this.mainElementColor = color;
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        this.updateManeuver();
    }

    @Override
    public void deInit() {
        super.deInit();
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$GuidanceUI == null ? (class$de$vw$mib$widgets$ui$GuidanceUI = Guidance.class$("de.vw.mib.widgets.ui.GuidanceUI")) : class$de$vw$mib$widgets$ui$GuidanceUI};
    }

    @Override
    public final Image[] get_mainElementImages() {
        return this.mainElementImages;
    }

    @Override
    public final void set_mainElementImages(Image[] imageArray) {
        Object[] objectArray = this.mainElementImages;
        if (!Arrays.equals(objectArray, imageArray)) {
            this.mainElementImages = imageArray;
            this.mainElementImagesChanged((Image[])objectArray);
            this.propertyChanged(15);
        }
    }

    @Override
    public final Point[] get_mainElementImagesPositions() {
        return this.mainElementImagesPositions;
    }

    @Override
    public final void set_mainElementImagesPositions(Point[] pointArray) {
        Object[] objectArray = this.mainElementImagesPositions;
        if (!Arrays.equals(objectArray, pointArray)) {
            this.mainElementImagesPositions = pointArray;
            this.mainElementImagesPositionsChanged((Point[])objectArray);
            this.propertyChanged(16);
        }
    }

    @Override
    public final Image[] get_sideStreetImages() {
        return this.sideStreetImages;
    }

    @Override
    public final void set_sideStreetImages(Image[] imageArray) {
        Object[] objectArray = this.sideStreetImages;
        if (!Arrays.equals(objectArray, imageArray)) {
            this.sideStreetImages = imageArray;
            this.sideStreetImagesChanged((Image[])objectArray);
            this.propertyChanged(17);
        }
    }

    @Override
    public Point[] get_sideStreetImagesPositions() {
        return this.sideStreetImagesPositions;
    }

    @Override
    public final void set_sideStreetImagesPositions(Point[] pointArray) {
        Object[] objectArray = this.sideStreetImagesPositions;
        if (!Arrays.equals(objectArray, pointArray)) {
            this.sideStreetImagesPositions = pointArray;
            this.sideStreetImagesPositionsChanged((Point[])objectArray);
            this.propertyChanged(18);
        }
    }

    @Override
    public final Image[] get_distanceImages() {
        return this.distanceImages;
    }

    @Override
    public final void set_distanceImages(Image[] imageArray) {
        Object[] objectArray = this.distanceImages;
        if (!Arrays.equals(objectArray, imageArray)) {
            this.distanceImages = imageArray;
            this.distanceImagesChanged((Image[])objectArray);
            this.propertyChanged(19);
        }
    }

    @Override
    public final Point[] get_distanceImagesPositions() {
        return this.distanceImagesPositions;
    }

    @Override
    public final void set_distanceImagesPositions(Point[] pointArray) {
        Object[] objectArray = this.distanceImagesPositions;
        if (!Arrays.equals(objectArray, pointArray)) {
            this.distanceImagesPositions = pointArray;
            this.distanceImagesPositionsChanged((Point[])objectArray);
            this.propertyChanged(20);
        }
    }

    @Override
    public final void set_mainElement(int n) {
        int n2 = this.mainElement;
        if (n2 != n) {
            this.mainElement = n;
            this.mainElementChanged(n2);
            this.propertyChanged(23);
        }
    }

    @Override
    public final int get_mainElement() {
        return this.mainElement;
    }

    @Override
    public final void set_direction(int n) {
        int n2 = this.direction;
        if (n2 != n) {
            this.direction = n;
            this.directionChanged(n2);
            this.propertyChanged(24);
        }
    }

    @Override
    public final int get_direction() {
        return this.direction;
    }

    @Override
    public final void set_zLevel(int n) {
        int n2 = this.zLevel;
        if (n2 != n) {
            this.zLevel = n;
            this.zLevelChanged(n2);
            this.propertyChanged(26);
        }
    }

    @Override
    public final int get_zLevel() {
        return this.zLevel;
    }

    @Override
    public final void set_zLevelImages(Image[] imageArray) {
        Object[] objectArray = this.zLevelImages;
        if (!Arrays.equals(objectArray, imageArray)) {
            this.zLevelImages = imageArray;
            this.zLevelImagesChanged((Image[])objectArray);
            this.propertyChanged(21);
        }
    }

    @Override
    public final Image[] get_zLevelImages() {
        return this.zLevelImages;
    }

    @Override
    public final void set_zLevelImagesPosition(Point point) {
        Point point2 = this.zLevelImagesPosition;
        if (point2 == null || !point2.equals(point)) {
            this.zLevelImagesPosition = point;
            this.zLevelImagesPositionChanged(point2);
            this.propertyChanged(22);
        }
    }

    @Override
    public final Point get_zLevelImagesPosition() {
        return this.zLevelImagesPosition;
    }

    @Override
    public final void set_sideRoads(String string) {
        String string2 = this.sideRoads;
        if (this.sideRoads == null || !string2.equals(string)) {
            this.sideRoads = string;
            this.sideRoadsChanged(string2);
            this.propertyChanged(25);
        }
    }

    @Override
    public final String get_sideRoads() {
        return this.sideRoads;
    }

    @Override
    public int getMainElementImageIndex() {
        return this.mainElementImageIndex;
    }

    @Override
    public int getZLevelImageIndex() {
        return this.zLevelImageIndex;
    }

    @Override
    public IntSet getSideStreetImageIndices() {
        return this.sideStreetImageIndices;
    }

    @Override
    public int getDistanceImageIndex() {
        return this.distanceImageIndex;
    }

    @Override
    public int getBarGraphFillingIndex() {
        return this.bargraphFillingIndex;
    }

    @Override
    public final Adjustable[] get_distanceWidgetRefs() {
        return this.distanceWidgetRefs;
    }

    @Override
    public final void set_distanceWidgetRefs(Adjustable[] adjustableArray) {
        Adjustable[] adjustableArray2 = this.distanceWidgetRefs;
        if (adjustableArray2 != adjustableArray) {
            this.distanceWidgetRefs = adjustableArray;
            this.distanceWidgetRefsChanged(adjustableArray2);
            this.propertyChanged(27);
        }
    }

    @Override
    public final int get_currentDistancePercent() {
        return this.currentDistancePercent;
    }

    @Override
    public final void set_currentDistancePercent(int n) {
        int n2 = this.currentDistancePercent;
        if (n2 != n) {
            this.currentDistancePercent = n;
            this.currentDistancePercentChanged(n2);
            this.propertyChanged(29);
        }
    }

    @Override
    public final boolean is_distanceVisible() {
        return this.distanceVisible;
    }

    @Override
    public final void set_distanceVisible(boolean bl) {
        boolean bl2 = this.distanceVisible;
        if (bl2 != bl) {
            this.distanceVisible = bl;
            this.distanceVisibleChanged(bl2);
            this.propertyChanged(28);
        }
    }

    @Override
    public final Color get_mainElementColor() {
        return this.mainElementColor;
    }

    @Override
    public final void set_mainElementColor(Color color) {
        Color color2 = this.mainElementColor;
        if (color2 == null || !color2.equals(color)) {
            this.mainElementColor = color;
            this.mainElementColorChanged(color2);
            this.propertyChanged(30);
        }
    }

    @Override
    public final Color4b getMainElementColor() {
        return this.mainElementColor4b;
    }

    protected void mainElementChanged(int n) {
        this.updateManeuver();
    }

    protected void directionChanged(int n) {
        this.updateManeuver();
    }

    protected void zLevelChanged(int n) {
        this.updateManeuver();
    }

    protected void zLevelImagesChanged(Image[] imageArray) {
        this.updateManeuver();
    }

    protected void zLevelImagesPositionChanged(Point point) {
        this.updateManeuver();
    }

    protected void sideRoadsChanged(String string) {
        this.updateManeuver();
    }

    protected void mainElementImagesChanged(Image[] imageArray) {
        this.updateManeuver();
    }

    protected void mainElementImagesPositionsChanged(Point[] pointArray) {
        this.updateManeuver();
    }

    protected void sideStreetImagesChanged(Image[] imageArray) {
        this.updateManeuver();
    }

    protected void sideStreetImagesPositionsChanged(Point[] pointArray) {
        this.updateManeuver();
    }

    protected void distanceWidgetRefsChanged(Adjustable[] adjustableArray) {
        this.updateManeuver();
    }

    protected void currentDistancePercentChanged(int n) {
        this.updateManeuver();
    }

    protected void distanceVisibleChanged(boolean bl) {
        this.updateManeuver();
    }

    protected void distanceImagesPositionsChanged(Point[] pointArray) {
        this.updateManeuver();
    }

    protected void distanceImagesChanged(Image[] imageArray) {
        this.updateManeuver();
    }

    private void mainElementColorChanged(Color color) {
        this.mainElementColor4b = this.mainElementColor != null ? new Color4b(this.mainElementColor.getCurrentColor().getRGBA()) : Color4b.WHITE;
    }

    private void updateManeuver() {
        this.maneuverInvalid = true;
        this.repaint();
    }

    @Override
    public void validateManeuver() {
        if (this.maneuverInvalid) {
            this.resetAllImageIndices();
            this.updateMainElement();
            this.updateSideStreets();
            this.updateDistance();
            this.updateZLevel();
            this.maneuverInvalid = false;
        }
    }

    private void updateMainElement() {
        switch (this.mainElement) {
            case 0: {
                this.doNoSymbol();
                break;
            }
            case 1: {
                this.doNoInfo();
                break;
            }
            case 2: {
                this.doNoDirectionToDestination();
                break;
            }
            case 3: {
                this.doArrived();
                break;
            }
            case 4: {
                this.doNearDestination();
                break;
            }
            case 5: {
                this.doArrivedDestinationOffmap();
                break;
            }
            case 6: {
                this.doOffroad();
                break;
            }
            case 7: {
                this.doOffmap();
                break;
            }
            case 8: {
                this.doNoRoute();
                break;
            }
            case 9: {
                this.doCalcRoute();
                break;
            }
            case 10: {
                this.doRecalcRoute();
                break;
            }
            case 11: {
                this.doFollowStreet();
                break;
            }
            case 12: {
                this.doChangeLane();
                break;
            }
            case 13: {
                this.doTurn();
                break;
            }
            case 14: {
                this.doTurnOnMainRoad();
                break;
            }
            case 15: {
                this.doExitRight();
                break;
            }
            case 16: {
                this.doExitLeft();
                break;
            }
            case 17: {
                this.doServiceRoadRight();
                break;
            }
            case 18: {
                this.doServiceRoadLeft();
                break;
            }
            case 19: {
                this.doFork2();
                break;
            }
            case 20: {
                this.doFork3();
                break;
            }
            case 21: {
                this.doRoundaboutTrsRight();
                break;
            }
            case 22: {
                this.doRoundaboutTrsLeft();
                break;
            }
            case 23: {
                this.doSquareTrsRight();
                break;
            }
            case 24: {
                this.doSquareTrsLeft();
                break;
            }
            case 25: {
                this.doUTurn();
                break;
            }
            case 26: {
                this.doExitRoundaboutTrsRight();
                break;
            }
            case 27: {
                this.doExitRoundaboutTrsLeft();
                break;
            }
            case 28: {
                this.doPrepareTurn();
                break;
            }
            case 29: {
                this.doPrepareRoundabout();
                break;
            }
            case 30: {
                this.doPrepareSquare();
                break;
            }
            case 31: {
                this.doPrepareUTurn();
                break;
            }
            case 36: {
                this.doDirectionToWaypoint();
                break;
            }
            case 32: {
                this.doExitRightRamp();
                break;
            }
            case 33: {
                this.doExitLeftRamp();
                break;
            }
            case 34: {
                this.doMichiganTurn();
                break;
            }
            case 35: {
                this.doDoubleTurn();
                break;
            }
            case 136: {
                this.doBorderCrossing();
                break;
            }
            default: {
                this.logUnsupportedCombination();
            }
        }
    }

    private void updateSideStreets() {
        if (this.sideRoads != null && !this.sideRoads.equals("")) {
            char[] cArray = this.sideRoads.toCharArray();
            switch (this.mainElement) {
                case 21: 
                case 22: {
                    this.doSideStreetsRoundabout(cArray);
                    break;
                }
                case 23: 
                case 24: {
                    this.doSideStreetsSquare(cArray);
                    break;
                }
                case 11: {
                    this.doSideStreetsFollow(cArray);
                    break;
                }
                case 13: 
                case 14: {
                    this.doSideStreetsTurn(cArray);
                    break;
                }
                case 16: 
                case 33: {
                    this.doSideStreetsExitLeft(cArray);
                    break;
                }
                case 15: 
                case 32: {
                    this.doSideStreetsExitRight(cArray);
                    break;
                }
                default: {
                    this.logUnsupportedSideStreet();
                }
            }
        }
    }

    private void updateDistance() {
        boolean bl;
        boolean bl2 = this.distanceImages != null && this.distanceImages.length > 0;
        boolean bl3 = bl = this.distanceImagesPositions != null && this.distanceImagesPositions.length > 0;
        if (bl2 && bl) {
            switch (this.mainElementImageIndex) {
                case 0: 
                case 1: 
                case 2: 
                case 3: 
                case 4: 
                case 21: 
                case 22: 
                case 25: 
                case 26: 
                case 27: 
                case 28: 
                case 29: 
                case 30: 
                case 31: 
                case 32: 
                case 33: 
                case 34: 
                case 35: 
                case 36: 
                case 37: 
                case 39: 
                case 40: 
                case 41: 
                case 42: 
                case 43: 
                case 44: 
                case 45: 
                case 48: 
                case 85: 
                case 86: 
                case 119: 
                case 120: 
                case 121: 
                case 124: 
                case 125: 
                case 126: 
                case 127: {
                    this.distanceImageIndex = this.distanceVisible ? 0 : 4;
                    this.bargraphFillingIndex = this.distanceVisible ? 8 : -1;
                    break;
                }
                case 46: 
                case 47: 
                case 49: 
                case 50: 
                case 51: 
                case 52: 
                case 53: 
                case 54: 
                case 55: 
                case 56: 
                case 57: 
                case 58: 
                case 59: 
                case 60: 
                case 61: 
                case 62: 
                case 63: 
                case 64: 
                case 65: 
                case 66: 
                case 67: 
                case 68: 
                case 69: 
                case 70: 
                case 71: 
                case 72: 
                case 73: 
                case 74: 
                case 75: 
                case 76: 
                case 77: 
                case 78: 
                case 79: 
                case 80: 
                case 81: 
                case 82: 
                case 83: 
                case 84: 
                case 87: 
                case 88: 
                case 89: 
                case 90: 
                case 91: 
                case 92: 
                case 93: 
                case 94: 
                case 95: 
                case 96: 
                case 97: 
                case 98: 
                case 99: 
                case 100: 
                case 101: 
                case 102: 
                case 103: 
                case 104: 
                case 105: 
                case 106: 
                case 107: 
                case 108: 
                case 109: 
                case 110: 
                case 111: 
                case 112: 
                case 113: 
                case 114: 
                case 115: 
                case 116: 
                case 117: 
                case 118: 
                case 122: 
                case 123: {
                    this.distanceImageIndex = this.distanceVisible ? 1 : 5;
                    this.bargraphFillingIndex = this.distanceVisible ? 9 : -1;
                    break;
                }
                case 23: {
                    this.distanceImageIndex = this.distanceVisible ? 2 : 6;
                    this.bargraphFillingIndex = this.distanceVisible ? 10 : -1;
                    break;
                }
                case 24: {
                    this.distanceImageIndex = this.distanceVisible ? 3 : 7;
                    this.bargraphFillingIndex = this.distanceVisible ? 11 : -1;
                    break;
                }
                default: {
                    this.distanceImageIndex = -1;
                    this.bargraphFillingIndex = -1;
                }
            }
        }
    }

    private void updateZLevel() {
        switch (this.mainElement) {
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: 
            case 26: 
            case 27: 
            case 28: 
            case 29: 
            case 30: 
            case 31: {
                if (this.zLevel == 0) {
                    this.zLevelImageIndex = -1;
                    break;
                }
                this.zLevelImageIndex = this.zLevel == 1 ? 0 : 1;
                break;
            }
            default: {
                this.zLevelImageIndex = -1;
            }
        }
    }

    private void doSideStreetsExitLeft(char[] cArray) {
        this.sideStreetImageIndices.add(53);
        this.sideStreetImageIndices.add(54);
        block6: for (int i2 = 0; i2 < cArray.length; ++i2) {
            switch (cArray[i2]) {
                case '\u0000': {
                    this.sideStreetImageIndices.add(0);
                    continue block6;
                }
                case ' ': {
                    this.sideStreetImageIndices.add(7);
                    continue block6;
                }
                case '@': {
                    this.sideStreetImageIndices.add(14);
                    continue block6;
                }
                case '`': {
                    this.sideStreetImageIndices.add(23);
                    continue block6;
                }
            }
        }
    }

    private void doSideStreetsExitRight(char[] cArray) {
        this.sideStreetImageIndices.add(53);
        this.sideStreetImageIndices.add(54);
        block6: for (int i2 = 0; i2 < cArray.length; ++i2) {
            switch (cArray[i2]) {
                case '\u0000': {
                    this.sideStreetImageIndices.add(1);
                    continue block6;
                }
                case '\u00a0': {
                    this.sideStreetImageIndices.add(31);
                    continue block6;
                }
                case '\u00c0': {
                    this.sideStreetImageIndices.add(38);
                    continue block6;
                }
                case '\u00e0': {
                    this.sideStreetImageIndices.add(47);
                    continue block6;
                }
            }
        }
    }

    private void doSideStreetsRoundabout(char[] cArray) {
        this.sideStreetImageIndices.add(55);
        block17: for (int i2 = 0; i2 < cArray.length; ++i2) {
            switch (cArray[i2]) {
                case '\u0000': {
                    this.sideStreetImageIndices.add(2);
                    continue block17;
                }
                case '\u0010': {
                    this.sideStreetImageIndices.add(5);
                    continue block17;
                }
                case ' ': {
                    this.sideStreetImageIndices.add(8);
                    continue block17;
                }
                case '0': {
                    this.sideStreetImageIndices.add(12);
                    continue block17;
                }
                case '@': {
                    this.sideStreetImageIndices.add(16);
                    continue block17;
                }
                case 'P': {
                    this.sideStreetImageIndices.add(21);
                    continue block17;
                }
                case '`': {
                    this.sideStreetImageIndices.add(24);
                    continue block17;
                }
                case 'p': {
                    this.sideStreetImageIndices.add(27);
                    continue block17;
                }
                case '\u0090': {
                    this.sideStreetImageIndices.add(29);
                    continue block17;
                }
                case '\u00a0': {
                    this.sideStreetImageIndices.add(32);
                    continue block17;
                }
                case '\u00b0': {
                    this.sideStreetImageIndices.add(36);
                    continue block17;
                }
                case '\u00c0': {
                    this.sideStreetImageIndices.add(40);
                    continue block17;
                }
                case '\u00d0': {
                    this.sideStreetImageIndices.add(45);
                    continue block17;
                }
                case '\u00e0': {
                    this.sideStreetImageIndices.add(48);
                    continue block17;
                }
                case '\u00f0': {
                    this.sideStreetImageIndices.add(51);
                    continue block17;
                }
            }
        }
    }

    private void doSideStreetsSquare(char[] cArray) {
        this.sideStreetImageIndices.add(56);
        block17: for (int i2 = 0; i2 < cArray.length; ++i2) {
            switch (cArray[i2]) {
                case '\u0000': {
                    this.sideStreetImageIndices.add(3);
                    continue block17;
                }
                case '\u0010': {
                    this.sideStreetImageIndices.add(6);
                    continue block17;
                }
                case ' ': {
                    this.sideStreetImageIndices.add(9);
                    continue block17;
                }
                case '0': {
                    this.sideStreetImageIndices.add(13);
                    continue block17;
                }
                case '@': {
                    this.sideStreetImageIndices.add(17);
                    continue block17;
                }
                case 'P': {
                    this.sideStreetImageIndices.add(22);
                    continue block17;
                }
                case '`': {
                    this.sideStreetImageIndices.add(25);
                    continue block17;
                }
                case 'p': {
                    this.sideStreetImageIndices.add(28);
                    continue block17;
                }
                case '\u0090': {
                    this.sideStreetImageIndices.add(30);
                    continue block17;
                }
                case '\u00a0': {
                    this.sideStreetImageIndices.add(33);
                    continue block17;
                }
                case '\u00b0': {
                    this.sideStreetImageIndices.add(37);
                    continue block17;
                }
                case '\u00c0': {
                    this.sideStreetImageIndices.add(41);
                    continue block17;
                }
                case '\u00d0': {
                    this.sideStreetImageIndices.add(46);
                    continue block17;
                }
                case '\u00e0': {
                    this.sideStreetImageIndices.add(49);
                    continue block17;
                }
                case '\u00f0': {
                    this.sideStreetImageIndices.add(52);
                    continue block17;
                }
            }
        }
    }

    private void doSideStreetsFollow(char[] cArray) {
        block8: for (int i2 = 0; i2 < cArray.length; ++i2) {
            switch (cArray[i2]) {
                case '0': {
                    this.sideStreetImageIndices.add(11);
                    continue block8;
                }
                case '@': {
                    this.sideStreetImageIndices.add(15);
                    continue block8;
                }
                case 'P': {
                    this.sideStreetImageIndices.add(20);
                    continue block8;
                }
                case '\u00b0': {
                    this.sideStreetImageIndices.add(35);
                    continue block8;
                }
                case '\u00c0': {
                    this.sideStreetImageIndices.add(39);
                    continue block8;
                }
                case '\u00d0': {
                    this.sideStreetImageIndices.add(44);
                    continue block8;
                }
            }
        }
    }

    private void doSideStreetsTurn(char[] cArray) {
        this.sideStreetImageIndices.add(57);
        block11: for (int i2 = 0; i2 < cArray.length; ++i2) {
            switch (cArray[i2]) {
                case '\u0000': {
                    this.sideStreetImageIndices.add(4);
                    continue block11;
                }
                case ' ': {
                    this.sideStreetImageIndices.add(10);
                    continue block11;
                }
                case '@': {
                    this.sideStreetImageIndices.add(18);
                    continue block11;
                }
                case 'A': {
                    this.sideStreetImageIndices.add(19);
                    continue block11;
                }
                case '`': {
                    this.sideStreetImageIndices.add(26);
                    continue block11;
                }
                case '\u00a0': {
                    this.sideStreetImageIndices.add(34);
                    continue block11;
                }
                case '\u00c0': {
                    this.sideStreetImageIndices.add(42);
                    continue block11;
                }
                case '\u00c1': {
                    this.sideStreetImageIndices.add(43);
                    continue block11;
                }
                case '\u00e0': {
                    this.sideStreetImageIndices.add(50);
                    continue block11;
                }
            }
        }
    }

    private void doDoubleTurn() {
        switch (this.direction) {
            case 64: {
                this.mainElementImageIndex = 21;
                break;
            }
            case 192: {
                this.mainElementImageIndex = 22;
                break;
            }
            default: {
                this.logUnsupportedCombination();
            }
        }
    }

    private void doMichiganTurn() {
        switch (this.direction) {
            case 64: {
                this.mainElementImageIndex = 44;
                break;
            }
            case 192: {
                this.mainElementImageIndex = 45;
                break;
            }
            default: {
                this.logUnsupportedCombination();
            }
        }
    }

    private void doExitLeftRamp() {
        switch (this.direction) {
            case 0: {
                this.mainElementImageIndex = 28;
                break;
            }
            case 32: {
                this.mainElementImageIndex = 29;
                break;
            }
            case 64: {
                this.mainElementImageIndex = 30;
                break;
            }
            default: {
                this.logUnsupportedCombination();
            }
        }
    }

    private void doExitRightRamp() {
        switch (this.direction) {
            case 0: {
                this.mainElementImageIndex = 35;
                break;
            }
            case 224: {
                this.mainElementImageIndex = 37;
                break;
            }
            case 192: {
                this.mainElementImageIndex = 36;
                break;
            }
            default: {
                this.logUnsupportedCombination();
            }
        }
    }

    private void doDirectionToWaypoint() {
        switch (this.direction) {
            case 0: {
                this.mainElementImageIndex = 5;
                break;
            }
            case 16: {
                this.mainElementImageIndex = 6;
                break;
            }
            case 32: {
                this.mainElementImageIndex = 7;
                break;
            }
            case 48: {
                this.mainElementImageIndex = 8;
                break;
            }
            case 64: {
                this.mainElementImageIndex = 9;
                break;
            }
            case 80: {
                this.mainElementImageIndex = 10;
                break;
            }
            case 96: {
                this.mainElementImageIndex = 11;
                break;
            }
            case 112: {
                this.mainElementImageIndex = 12;
                break;
            }
            case 128: {
                this.mainElementImageIndex = 13;
                break;
            }
            case 144: {
                this.mainElementImageIndex = 14;
                break;
            }
            case 160: {
                this.mainElementImageIndex = 15;
                break;
            }
            case 176: {
                this.mainElementImageIndex = 16;
                break;
            }
            case 192: {
                this.mainElementImageIndex = 17;
                break;
            }
            case 208: {
                this.mainElementImageIndex = 18;
                break;
            }
            case 224: {
                this.mainElementImageIndex = 19;
                break;
            }
            case 240: {
                this.mainElementImageIndex = 20;
                break;
            }
            default: {
                this.logUnsupportedCombination();
            }
        }
    }

    private void doPrepareUTurn() {
        switch (this.direction) {
            case 64: {
                this.mainElementImageIndex = 51;
                break;
            }
            case 192: {
                this.mainElementImageIndex = 52;
                break;
            }
            default: {
                this.logUnsupportedCombination();
            }
        }
    }

    private void doPrepareSquare() {
        this.mainElementImageIndex = 47;
    }

    private void doPrepareRoundabout() {
        this.mainElementImageIndex = 46;
    }

    private void doPrepareTurn() {
        switch (this.direction) {
            case 0: {
                this.mainElementImageIndex = 48;
                break;
            }
            case 64: {
                this.mainElementImageIndex = 49;
                break;
            }
            case 192: {
                this.mainElementImageIndex = 50;
                break;
            }
            default: {
                this.logUnsupportedCombination();
            }
        }
    }

    private void doExitRoundaboutTrsLeft() {
        this.mainElementImageIndex = 23;
    }

    private void doExitRoundaboutTrsRight() {
        this.mainElementImageIndex = 24;
    }

    private void doUTurn() {
        switch (this.direction) {
            case 64: {
                this.mainElementImageIndex = 126;
                break;
            }
            case 192: {
                this.mainElementImageIndex = 127;
                break;
            }
            default: {
                this.logUnsupportedCombination();
            }
        }
    }

    private void doSquareTrsLeft() {
        switch (this.direction) {
            case 0: {
                this.mainElementImageIndex = 87;
                break;
            }
            case 16: {
                this.mainElementImageIndex = 88;
                break;
            }
            case 32: {
                this.mainElementImageIndex = 89;
                break;
            }
            case 48: {
                this.mainElementImageIndex = 90;
                break;
            }
            case 64: {
                this.mainElementImageIndex = 91;
                break;
            }
            case 80: {
                this.mainElementImageIndex = 92;
                break;
            }
            case 96: {
                this.mainElementImageIndex = 93;
                break;
            }
            case 112: {
                this.mainElementImageIndex = 94;
                break;
            }
            case 128: {
                this.mainElementImageIndex = 95;
                break;
            }
            case 144: {
                this.mainElementImageIndex = 96;
                break;
            }
            case 160: {
                this.mainElementImageIndex = 97;
                break;
            }
            case 176: {
                this.mainElementImageIndex = 98;
                break;
            }
            case 192: {
                this.mainElementImageIndex = 99;
                break;
            }
            case 208: {
                this.mainElementImageIndex = 100;
                break;
            }
            case 224: {
                this.mainElementImageIndex = 101;
                break;
            }
            case 240: {
                this.mainElementImageIndex = 102;
                break;
            }
            default: {
                this.logUnsupportedCombination();
            }
        }
    }

    private void doSquareTrsRight() {
        switch (this.direction) {
            case 0: {
                this.mainElementImageIndex = 103;
                break;
            }
            case 16: {
                this.mainElementImageIndex = 104;
                break;
            }
            case 32: {
                this.mainElementImageIndex = 105;
                break;
            }
            case 48: {
                this.mainElementImageIndex = 106;
                break;
            }
            case 64: {
                this.mainElementImageIndex = 107;
                break;
            }
            case 80: {
                this.mainElementImageIndex = 108;
                break;
            }
            case 96: {
                this.mainElementImageIndex = 109;
                break;
            }
            case 112: {
                this.mainElementImageIndex = 110;
                break;
            }
            case 128: {
                this.mainElementImageIndex = 111;
                break;
            }
            case 144: {
                this.mainElementImageIndex = 112;
                break;
            }
            case 160: {
                this.mainElementImageIndex = 113;
                break;
            }
            case 176: {
                this.mainElementImageIndex = 114;
                break;
            }
            case 192: {
                this.mainElementImageIndex = 115;
                break;
            }
            case 208: {
                this.mainElementImageIndex = 116;
                break;
            }
            case 224: {
                this.mainElementImageIndex = 117;
                break;
            }
            case 240: {
                this.mainElementImageIndex = 118;
                break;
            }
            default: {
                this.logUnsupportedCombination();
            }
        }
    }

    private void doRoundaboutTrsRight() {
        switch (this.direction) {
            case 0: {
                this.mainElementImageIndex = 69;
                break;
            }
            case 16: {
                this.mainElementImageIndex = 70;
                break;
            }
            case 32: {
                this.mainElementImageIndex = 71;
                break;
            }
            case 48: {
                this.mainElementImageIndex = 72;
                break;
            }
            case 64: {
                this.mainElementImageIndex = 73;
                break;
            }
            case 80: {
                this.mainElementImageIndex = 74;
                break;
            }
            case 96: {
                this.mainElementImageIndex = 75;
                break;
            }
            case 112: {
                this.mainElementImageIndex = 76;
                break;
            }
            case 128: {
                this.mainElementImageIndex = 77;
                break;
            }
            case 144: {
                this.mainElementImageIndex = 78;
                break;
            }
            case 160: {
                this.mainElementImageIndex = 79;
                break;
            }
            case 176: {
                this.mainElementImageIndex = 80;
                break;
            }
            case 192: {
                this.mainElementImageIndex = 81;
                break;
            }
            case 208: {
                this.mainElementImageIndex = 82;
                break;
            }
            case 224: {
                this.mainElementImageIndex = 83;
                break;
            }
            case 240: {
                this.mainElementImageIndex = 84;
                break;
            }
            default: {
                this.logUnsupportedCombination();
            }
        }
    }

    private void doRoundaboutTrsLeft() {
        switch (this.direction) {
            case 0: {
                this.mainElementImageIndex = 53;
                break;
            }
            case 16: {
                this.mainElementImageIndex = 54;
                break;
            }
            case 32: {
                this.mainElementImageIndex = 55;
                break;
            }
            case 48: {
                this.mainElementImageIndex = 56;
                break;
            }
            case 64: {
                this.mainElementImageIndex = 57;
                break;
            }
            case 80: {
                this.mainElementImageIndex = 58;
                break;
            }
            case 96: {
                this.mainElementImageIndex = 59;
                break;
            }
            case 112: {
                this.mainElementImageIndex = 60;
                break;
            }
            case 128: {
                this.mainElementImageIndex = 61;
                break;
            }
            case 144: {
                this.mainElementImageIndex = 62;
                break;
            }
            case 160: {
                this.mainElementImageIndex = 63;
                break;
            }
            case 176: {
                this.mainElementImageIndex = 64;
                break;
            }
            case 192: {
                this.mainElementImageIndex = 65;
                break;
            }
            case 208: {
                this.mainElementImageIndex = 66;
                break;
            }
            case 224: {
                this.mainElementImageIndex = 67;
                break;
            }
            case 240: {
                this.mainElementImageIndex = 68;
                break;
            }
            default: {
                this.logUnsupportedCombination();
            }
        }
    }

    private void doFork3() {
        switch (this.direction) {
            case 0: {
                this.mainElementImageIndex = 41;
                break;
            }
            case 64: {
                this.mainElementImageIndex = 42;
                break;
            }
            case 192: {
                this.mainElementImageIndex = 43;
                break;
            }
            default: {
                this.logUnsupportedCombination();
            }
        }
    }

    private void doFork2() {
        switch (this.direction) {
            case 64: {
                this.mainElementImageIndex = 39;
                break;
            }
            case 192: {
                this.mainElementImageIndex = 40;
                break;
            }
            default: {
                this.logUnsupportedCombination();
            }
        }
    }

    private void doServiceRoadLeft() {
        this.mainElementImageIndex = 85;
    }

    private void doServiceRoadRight() {
        this.mainElementImageIndex = 86;
    }

    private void doExitLeft() {
        switch (this.direction) {
            case 0: {
                this.mainElementImageIndex = 25;
                break;
            }
            case 32: {
                this.mainElementImageIndex = 26;
                break;
            }
            case 64: {
                this.mainElementImageIndex = 27;
                break;
            }
            default: {
                this.logUnsupportedCombination();
            }
        }
    }

    private void doExitRight() {
        switch (this.direction) {
            case 0: {
                this.mainElementImageIndex = 31;
                break;
            }
            case 224: {
                this.mainElementImageIndex = 32;
                break;
            }
            case 192: {
                this.mainElementImageIndex = 33;
                break;
            }
            default: {
                this.logUnsupportedCombination();
            }
        }
    }

    private void doTurnOnMainRoad() {
        this.doTurn();
    }

    private void doTurn() {
        switch (this.direction) {
            case 0: {
                this.mainElementImageIndex = 119;
                break;
            }
            case 64: {
                this.mainElementImageIndex = 121;
                break;
            }
            case 192: {
                this.mainElementImageIndex = 124;
                break;
            }
            case 32: {
                this.mainElementImageIndex = 120;
                break;
            }
            case 224: {
                this.mainElementImageIndex = 125;
                break;
            }
            case 96: {
                this.mainElementImageIndex = 122;
                break;
            }
            case 160: {
                this.mainElementImageIndex = 123;
                break;
            }
            default: {
                this.logUnsupportedCombination();
            }
        }
    }

    private void doChangeLane() {
        switch (this.direction) {
            case 64: {
                this.mainElementImageIndex = 3;
                break;
            }
            case 192: {
                this.mainElementImageIndex = 4;
                break;
            }
            default: {
                this.logUnsupportedCombination();
            }
        }
    }

    private void doFollowStreet() {
        this.mainElementImageIndex = 38;
    }

    private void doArrived() {
        switch (this.direction) {
            case 64: {
                this.mainElementImageIndex = 1;
                break;
            }
            case 192: {
                this.mainElementImageIndex = 2;
                break;
            }
            default: {
                this.mainElementImageIndex = 0;
            }
        }
    }

    private void doOffroad() {
        switch (this.direction) {
            case 0: {
                this.mainElementImageIndex = 5;
                break;
            }
            case 16: {
                this.mainElementImageIndex = 6;
                break;
            }
            case 32: {
                this.mainElementImageIndex = 7;
                break;
            }
            case 48: {
                this.mainElementImageIndex = 8;
                break;
            }
            case 64: {
                this.mainElementImageIndex = 9;
                break;
            }
            case 80: {
                this.mainElementImageIndex = 10;
                break;
            }
            case 96: {
                this.mainElementImageIndex = 11;
                break;
            }
            case 112: {
                this.mainElementImageIndex = 12;
                break;
            }
            case 128: {
                this.mainElementImageIndex = 13;
                break;
            }
            case 144: {
                this.mainElementImageIndex = 14;
                break;
            }
            case 160: {
                this.mainElementImageIndex = 15;
                break;
            }
            case 176: {
                this.mainElementImageIndex = 16;
                break;
            }
            case 192: {
                this.mainElementImageIndex = 17;
                break;
            }
            case 208: {
                this.mainElementImageIndex = 18;
                break;
            }
            case 224: {
                this.mainElementImageIndex = 19;
                break;
            }
            case 240: {
                this.mainElementImageIndex = 20;
                break;
            }
            default: {
                this.logUnsupportedCombination();
            }
        }
    }

    private void doNoDirectionToDestination() {
        this.doOffroad();
    }

    private void doNoInfo() {
    }

    private void doNoSymbol() {
    }

    private void doRecalcRoute() {
        this.doOffroad();
    }

    private void doCalcRoute() {
        this.doOffroad();
    }

    private void doNoRoute() {
        this.doOffroad();
    }

    private void doOffmap() {
        this.doOffroad();
    }

    private void doArrivedDestinationOffmap() {
        this.doArrived();
    }

    private void doNearDestination() {
        this.doArrived();
    }

    private void doBorderCrossing() {
        this.mainElementImageIndex = 128;
    }

    private void logUnsupportedCombination() {
        this.resetAllImageIndices();
        LogMessage logMessage = LOGGER.warn(256);
        logMessage.append("Widget '").append(this.getQualifiedName()).append("': Unsupported mainelement/direction/zLevel combination: ").append(this.mainElement).append(" / ").append(this.direction).append(" / ").append(this.zLevel).log();
    }

    private void logUnsupportedSideStreet() {
        LogMessage logMessage = LOGGER.warn(256);
        logMessage.append("Widget '").append(this.getQualifiedName()).append("': Unsupported side street for mainelement: ").append(this.mainElement);
    }

    private void resetAllImageIndices() {
        this.mainElementImageIndex = -1;
        this.distanceImageIndex = -1;
        this.bargraphFillingIndex = -1;
        this.zLevelImageIndex = -1;
        this.sideStreetImageIndices.clear();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

