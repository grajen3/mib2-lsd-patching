/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.widgets.interfaces.Adjustable;
import de.vw.mib.widgets.models.WidgetModel;

public interface GuidanceModel
extends WidgetModel {
    public static final int PID_BASE;
    public static final int PID_MAIN_ELEMENT_IMAGES;
    public static final int PID_MAIN_ELEMENT_IMAGES_POSITIONS;
    public static final int PID_SIDE_STREET_IMAGES;
    public static final int PID_SIDE_STREET_IMAGES_POSITIONS;
    public static final int PID_DISTANCE_IMAGES;
    public static final int PID_DISTANCE_IMAGES_POSITIONS;
    public static final int PID_Z_LEVEL_IMAGES;
    public static final int PID_Z_LEVEL_IMAGES_POSITION;
    public static final int PID_MAIN_ELEMENT;
    public static final int PID_DIRECTION;
    public static final int PID_SIDE_ROADS;
    public static final int PID_Z_LEVEL;
    public static final int PID_DISTANCE_WIDGET_REFS;
    public static final int PID_DISTANCE_VISIBLE;
    public static final int PID_CURRENT_DISTANCE_PERCENT;
    public static final int PID_MAIN_ELEMENT_COLOR;
    public static final int PID_COUNT_GUIDANCE;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_COUNT_GUIDANCE;
    public static final int SIDESTREET_MAX;
    public static final int MAIN_ELEMENT_NO_SYMBOL;
    public static final int MAIN_ELEMENT_NO_INFO;
    public static final int MAIN_ELEMENT_NO_DIRECTION_TO_DESTINATION;
    public static final int MAIN_ELEMENT_ARRIVED;
    public static final int MAIN_ELEMENT_NEAR_DESTINATION;
    public static final int MAIN_ELEMENT_ARRIVED_DESTINATION_OFFMAP;
    public static final int MAIN_ELEMENT_OFFROAD;
    public static final int MAIN_ELEMENT_OFFMAP;
    public static final int MAIN_ELEMENT_NO_ROUTE;
    public static final int MAIN_ELEMENT_CALC_ROUTE;
    public static final int MAIN_ELEMENT_RECALC_ROUTE;
    public static final int MAIN_ELEMENT_FOLLOW_STREET;
    public static final int MAIN_ELEMENT_CHANGE_LANE;
    public static final int MAIN_ELEMENT_TURN;
    public static final int MAIN_ELEMENT_TURN_ON_MAIN_ROAD;
    public static final int MAIN_ELEMENT_EXIT_RIGHT;
    public static final int MAIN_ELEMENT_EXIT_LEFT;
    public static final int MAIN_ELEMENT_SERVICE_ROAD_RIGHT;
    public static final int MAIN_ELEMENT_SERVICE_ROAD_LEFT;
    public static final int MAIN_ELEMENT_FORK_2;
    public static final int MAIN_ELEMENT_FORK_3;
    public static final int MAIN_ELEMENT_ROUNDABOUT_TRS_RIGHT;
    public static final int MAIN_ELEMENT_ROUNDABOUT_TRS_LEFT;
    public static final int MAIN_ELEMENT_SQUARE_TRS_RIGHT;
    public static final int MAIN_ELEMENT_SQUARE_TRS_LEFT;
    public static final int MAIN_ELEMENT_U_TURN;
    public static final int MAIN_ELEMENT_EXIT_ROUNDABOUT_TRS_RIGHT;
    public static final int MAIN_ELEMENT_EXIT_ROUNDABOUT_TRS_LEFT;
    public static final int MAIN_ELEMENT_PREPARE_TURN;
    public static final int MAIN_ELEMENT_PREPARE_ROUNDABOUT;
    public static final int MAIN_ELEMENT_PREPARE_SQUARE;
    public static final int MAIN_ELEMENT_PREPARE_U_TURN;
    public static final int MAIN_ELEMENT_EXIT_RIGHT_RAMP;
    public static final int MAIN_ELEMENT_EXIT_LEFT_RAMP;
    public static final int MAIN_ELEMENT_MICHIGAN_TURN;
    public static final int MAIN_ELEMENT_DOUBLE_TURN;
    public static final int MAIN_ELEMENT_DIRECTION_TO_WAYPOINT;
    public static final int MAIN_ELEMENT_BORDER_CROSSING;
    public static final int DIRECTION_FORWARD;
    public static final int DIRECTION_LFF;
    public static final int DIRECTION_LF;
    public static final int DIRECTION_LLF;
    public static final int DIRECTION_LEFT;
    public static final int DIRECTION_LEFT_41;
    public static final int DIRECTION_LLB;
    public static final int DIRECTION_LB;
    public static final int DIRECTION_LBB;
    public static final int DIRECTION_BACK;
    public static final int DIRECTION_RBB;
    public static final int DIRECTION_RB;
    public static final int DIRECTION_RRB;
    public static final int DIRECTION_RIGHT;
    public static final int DIRECTION_RIGHT_C1;
    public static final int DIRECTION_RRF;
    public static final int DIRECTION_RF;
    public static final int DIRECTION_RFF;
    public static final int Z_LEVEL_NO;
    public static final int Z_LEVEL_UP;
    public static final int Z_LEVEL_DOWN;
    public static final int MAIN_NONE;
    public static final int MAIN_COUNT;
    public static final int MAIN_NO_MAIN_DEFINED;
    public static final int MAIN_ARRIVED;
    public static final int MAIN_ARRIVED_LEFT;
    public static final int MAIN_ARRIVED_RIGHT;
    public static final int MAIN_CHANGELANE_LEFT;
    public static final int MAIN_CHANGELANE_RIGHT;
    public static final int MAIN_DESTINATION_FORWARD;
    public static final int MAIN_DESTINATION_LFF;
    public static final int MAIN_DESTINATION_LF;
    public static final int MAIN_DESTINATION_LLF;
    public static final int MAIN_DESTINATION_LEFT;
    public static final int MAIN_DESTINATION_LLB;
    public static final int MAIN_DESTINATION_LB;
    public static final int MAIN_DESTINATION_LBB;
    public static final int MAIN_DESTINATION_BACK;
    public static final int MAIN_DESTINATION_RBB;
    public static final int MAIN_DESTINATION_RB;
    public static final int MAIN_DESTINATION_RRB;
    public static final int MAIN_DESTINATION_RIGHT;
    public static final int MAIN_DESTINATION_RRF;
    public static final int MAIN_DESTINATION_RF;
    public static final int MAIN_DESTINATION_RFF;
    public static final int MAIN_DOUBLETURN_LEFT;
    public static final int MAIN_DOUBLETURN_RIGHT;
    public static final int MAIN_EXIT_ROUNDABOUT_LEFT;
    public static final int MAIN_EXIT_ROUNDABOUT_RIGHT;
    public static final int MAIN_EXIT_LEFT_PARALLEL;
    public static final int MAIN_EXIT_LEFT_PARALLEL_EXIT;
    public static final int MAIN_EXIT_LEFT_EXIT;
    public static final int MAIN_EXIT_LEFT_RAMP_PARALLEL;
    public static final int MAIN_EXIT_LEFT_RAMP_PARALLEL_EXIT;
    public static final int MAIN_EXIT_LEFT_RAMP_EXIT;
    public static final int MAIN_EXIT_RIGHT_PARALLEL;
    public static final int MAIN_EXIT_RIGHT_PARALLEL_EXIT;
    public static final int MAIN_EXIT_RIGHT_EXIT;
    public static final int MAIN_EXIT_RIGHT_PARALLEL_EXIT_E0;
    public static final int MAIN_EXIT_RIGHT_RAMP_PARALLEL;
    public static final int MAIN_EXIT_RIGHT_RAMP_EXIT;
    public static final int MAIN_EXIT_RIGHT_RAMP_PARALLEL_EXIT;
    public static final int MAIN_FOLLOW;
    public static final int MAIN_FORK2_LEFT;
    public static final int MAIN_FORK2_RIGHT;
    public static final int MAIN_FORK3_STRAIGHT;
    public static final int MAIN_FORK3_LEFT;
    public static final int MAIN_FORK3_RIGHT;
    public static final int MAIN_MICHIGAN_LEFT;
    public static final int MAIN_MICHIGAN_RIGHT;
    public static final int MAIN_PREPARE_ROUNDABOUT;
    public static final int MAIN_PREPARE_SQUARE;
    public static final int MAIN_PREPARE_TURN_STRAIGHT;
    public static final int MAIN_PREPARE_TURN_LEFT;
    public static final int MAIN_PREPARE_TURN_RIGHT;
    public static final int MAIN_PREPARE_UTURN_LEFT;
    public static final int MAIN_PREPARE_UTURN_RIGHT;
    public static final int MAIN_ROUNDABOUT_LH_FORWARD;
    public static final int MAIN_ROUNDABOUT_LH_LFF;
    public static final int MAIN_ROUNDABOUT_LH_LF;
    public static final int MAIN_ROUNDABOUT_LH_LLF;
    public static final int MAIN_ROUNDABOUT_LH_LEFT;
    public static final int MAIN_ROUNDABOUT_LH_LLB;
    public static final int MAIN_ROUNDABOUT_LH_LB;
    public static final int MAIN_ROUNDABOUT_LH_LBB;
    public static final int MAIN_ROUNDABOUT_LH_BACK;
    public static final int MAIN_ROUNDABOUT_LH_RBB;
    public static final int MAIN_ROUNDABOUT_LH_RB;
    public static final int MAIN_ROUNDABOUT_LH_RRB;
    public static final int MAIN_ROUNDABOUT_LH_RIGHT;
    public static final int MAIN_ROUNDABOUT_LH_RRF;
    public static final int MAIN_ROUNDABOUT_LH_RF;
    public static final int MAIN_ROUNDABOUT_LH_RFF;
    public static final int MAIN_ROUNDABOUT_RH_FORWARD;
    public static final int MAIN_ROUNDABOUT_RH_LFF;
    public static final int MAIN_ROUNDABOUT_RH_LF;
    public static final int MAIN_ROUNDABOUT_RH_LLF;
    public static final int MAIN_ROUNDABOUT_RH_LEFT;
    public static final int MAIN_ROUNDABOUT_RH_LLB;
    public static final int MAIN_ROUNDABOUT_RH_LB;
    public static final int MAIN_ROUNDABOUT_RH_LBB;
    public static final int MAIN_ROUNDABOUT_RH_BACK;
    public static final int MAIN_ROUNDABOUT_RH_RBB;
    public static final int MAIN_ROUNDABOUT_RH_RB;
    public static final int MAIN_ROUNDABOUT_RH_RRB;
    public static final int MAIN_ROUNDABOUT_RH_RIGHT;
    public static final int MAIN_ROUNDABOUT_RH_RRF;
    public static final int MAIN_ROUNDABOUT_RH_RF;
    public static final int MAIN_ROUNDABOUT_RH_RFF;
    public static final int MAIN_SERVICEMAIN_LEFT;
    public static final int MAIN_SERVICEMAIN_RIGHT;
    public static final int MAIN_SQUARE_LH_FORWARD;
    public static final int MAIN_SQUARE_LH_LFF;
    public static final int MAIN_SQUARE_LH_LF;
    public static final int MAIN_SQUARE_LH_LLF;
    public static final int MAIN_SQUARE_LH_LEFT;
    public static final int MAIN_SQUARE_LH_LLB;
    public static final int MAIN_SQUARE_LH_LB;
    public static final int MAIN_SQUARE_LH_LBB;
    public static final int MAIN_SQUARE_LH_BACK;
    public static final int MAIN_SQUARE_LH_RBB;
    public static final int MAIN_SQUARE_LH_RB;
    public static final int MAIN_SQUARE_LH_RRB;
    public static final int MAIN_SQUARE_LH_RIGHT;
    public static final int MAIN_SQUARE_LH_RRF;
    public static final int MAIN_SQUARE_LH_RF;
    public static final int MAIN_SQUARE_LH_RFF;
    public static final int MAIN_SQUARE_RH_FORWARD;
    public static final int MAIN_SQUARE_RH_LFF;
    public static final int MAIN_SQUARE_RH_LF;
    public static final int MAIN_SQUARE_RH_LLF;
    public static final int MAIN_SQUARE_RH_LEFT;
    public static final int MAIN_SQUARE_RH_LLB;
    public static final int MAIN_SQUARE_RH_LB;
    public static final int MAIN_SQUARE_RH_LBB;
    public static final int MAIN_SQUARE_RH_BACK;
    public static final int MAIN_SQUARE_RH_RBB;
    public static final int MAIN_SQUARE_RH_RB;
    public static final int MAIN_SQUARE_RH_RRB;
    public static final int MAIN_SQUARE_RH_RIGHT;
    public static final int MAIN_SQUARE_RH_RRF;
    public static final int MAIN_SQUARE_RH_RF;
    public static final int MAIN_SQUARE_RH_RFF;
    public static final int MAIN_TURN_FORWARD;
    public static final int MAIN_TURN_LF;
    public static final int MAIN_TURN_LEFT;
    public static final int MAIN_TURN_LB;
    public static final int MAIN_TURN_RB;
    public static final int MAIN_TURN_RIGHT;
    public static final int MAIN_TURN_RF;
    public static final int MAIN_UTURN_LEFT;
    public static final int MAIN_UTURN_RIGHT;
    public static final int MAIN_BORDER_CROSSING;
    public static final int SIDE_STREET_COUNT;
    public static final int SIDE_STREET_FORWARD_EXIT_LEFT;
    public static final int SIDE_STREET_FORWARD_EXIT_RIGHT;
    public static final int SIDE_STREET_FORWARD_ROUNDABOUT;
    public static final int SIDE_STREET_FORWARD_SQUARE;
    public static final int SIDE_STREET_FORWARD_TURN;
    public static final int SIDE_STREET_LFF_ROUNDABOUT;
    public static final int SIDE_STREET_LFF_SQUARE;
    public static final int SIDE_STREET_LF_EXIT_LEFT;
    public static final int SIDE_STREET_LF_ROUNDABOUT;
    public static final int SIDE_STREET_LF_SQUARE;
    public static final int SIDE_STREET_LF_TURN;
    public static final int SIDE_STREET_LLF_FOLLOW;
    public static final int SIDE_STREET_LLF_ROUNDABOUT;
    public static final int SIDE_STREET_LLF_SQUARE;
    public static final int SIDE_STREET_LEFT_EXIT_LEFT;
    public static final int SIDE_STREET_LEFT_FOLLOW;
    public static final int SIDE_STREET_LEFT_ROUNDABOUT;
    public static final int SIDE_STREET_LEFT_SQUARE;
    public static final int SIDE_STREET_LEFT_TURN;
    public static final int SIDE_STREET_LEFT_TURN_41;
    public static final int SIDE_STREET_LLB_FOLLOW;
    public static final int SIDE_STREET_LLB_ROUNDABOUT;
    public static final int SIDE_STREET_LLB_SQUARE;
    public static final int SIDE_STREET_LB_EXIT_LEFT;
    public static final int SIDE_STREET_LB_ROUNDABOUT;
    public static final int SIDE_STREET_LB_SQUARE;
    public static final int SIDE_STREET_LB_TURN;
    public static final int SIDE_STREET_LBB_ROUNDABOUT;
    public static final int SIDE_STREET_LBB_SQUARE;
    public static final int SIDE_STREET_RBB_ROUNDABOUT;
    public static final int SIDE_STREET_RBB_SQUARE;
    public static final int SIDE_STREET_RB_EXIT_RIGHT;
    public static final int SIDE_STREET_RB_ROUNDABOUT;
    public static final int SIDE_STREET_RB_SQUARE;
    public static final int SIDE_STREET_RB_TURN;
    public static final int SIDE_STREET_RRB_FOLLOW;
    public static final int SIDE_STREET_RRB_ROUNDABOUT;
    public static final int SIDE_STREET_RRB_SQUARE;
    public static final int SIDE_STREET_RIGHT_EXIT_RIGHT;
    public static final int SIDE_STREET_RIGHT_FOLLOW;
    public static final int SIDE_STREET_RIGHT_ROUNDABOUT;
    public static final int SIDE_STREET_RIGHT_SQUARE;
    public static final int SIDE_STREET_RIGHT_TURN;
    public static final int SIDE_STREET_RIGHT_TURN_C1;
    public static final int SIDE_STREET_RRF_FOLLOW;
    public static final int SIDE_STREET_RRF_ROUNDABOUT;
    public static final int SIDE_STREET_RRF_SQUARE;
    public static final int SIDE_STREET_RF_EXIT_RIGHT;
    public static final int SIDE_STREET_RF_ROUNDABOUT;
    public static final int SIDE_STREET_RF_SQUARE;
    public static final int SIDE_STREET_RF_TURN;
    public static final int SIDE_STREET_RFF_ROUNDABOUT;
    public static final int SIDE_STREET_RFF_SQUARE;
    public static final int SIDE_STREET_BASE_EXIT;
    public static final int SIDE_STREET_BASE_EXIT_FOLLOW;
    public static final int SIDE_STREET_BASE_ROUNDABOUT;
    public static final int SIDE_STREET_BASE_SQUARE;
    public static final int SIDE_STREET_BASE_TURN;
    public static final int Z_LEVEL_INDICATOR_NONE;
    public static final int Z_LEVEL_INDICATOR_UP;
    public static final int Z_LEVEL_INDICATOR_DOWN;
    public static final int Z_LEVEL_INDICATOR_COUNT;
    public static final int DISTANCE_NONE;
    public static final int DISTANCE_BARGRAPH_1;
    public static final int DISTANCE_BARGRAPH_2;
    public static final int DISTANCE_BARGRAPH_3;
    public static final int DISTANCE_BARGRAPH_4;
    public static final int DISTANCE_BASE_1;
    public static final int DISTANCE_BASE_2;
    public static final int DISTANCE_BASE_3;
    public static final int DISTANCE_BASE_4;
    public static final int DISTANCE_BARGRAPH_FILLING_1;
    public static final int DISTANCE_BARGRAPH_FILLING_2;
    public static final int DISTANCE_BARGRAPH_FILLING_3;
    public static final int DISTANCE_BARGRAPH_FILLING_4;
    public static final int DISTANCE_COUNT;

    default public Image[] get_mainElementImages() {
    }

    default public void set_mainElementImages(Image[] imageArray) {
    }

    default public Point[] get_mainElementImagesPositions() {
    }

    default public void set_mainElementImagesPositions(Point[] pointArray) {
    }

    default public Image[] get_sideStreetImages() {
    }

    default public void set_sideStreetImages(Image[] imageArray) {
    }

    default public Point[] get_sideStreetImagesPositions() {
    }

    default public void set_sideStreetImagesPositions(Point[] pointArray) {
    }

    default public Image[] get_distanceImages() {
    }

    default public void set_distanceImages(Image[] imageArray) {
    }

    default public Point[] get_distanceImagesPositions() {
    }

    default public void set_distanceImagesPositions(Point[] pointArray) {
    }

    default public void set_mainElement(int n) {
    }

    default public int get_mainElement() {
    }

    default public void set_direction(int n) {
    }

    default public int get_direction() {
    }

    default public void set_zLevel(int n) {
    }

    default public int get_zLevel() {
    }

    default public void set_zLevelImages(Image[] imageArray) {
    }

    default public Image[] get_zLevelImages() {
    }

    default public void set_zLevelImagesPosition(Point point) {
    }

    default public Point get_zLevelImagesPosition() {
    }

    default public void set_sideRoads(String string) {
    }

    default public String get_sideRoads() {
    }

    default public Adjustable[] get_distanceWidgetRefs() {
    }

    default public void set_distanceWidgetRefs(Adjustable[] adjustableArray) {
    }

    default public int get_currentDistancePercent() {
    }

    default public void set_currentDistancePercent(int n) {
    }

    default public boolean is_distanceVisible() {
    }

    default public void set_distanceVisible(boolean bl) {
    }

    default public Color get_mainElementColor() {
    }

    default public void set_mainElementColor(Color color) {
    }

    default public int getMainElementImageIndex() {
    }

    default public IntSet getSideStreetImageIndices() {
    }

    default public int getDistanceImageIndex() {
    }

    default public int getBarGraphFillingIndex() {
    }

    default public int getZLevelImageIndex() {
    }

    default public Color4b getMainElementColor() {
    }

    default public void validateManeuver() {
    }
}

