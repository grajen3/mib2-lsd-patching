/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.drawable;

import de.vw.mib.graphics.performance.PerformanceMetrics;
import de.vw.mib.util.StringBuilder;

public final class DrawablePerformanceMetrics
implements PerformanceMetrics {
    public int allocatedArcs;
    public int allocatedCircularSectors;
    public int allocatedCircleGraphs;
    public int allocatedCubicBezierCurves;
    public int allocatedEllipses;
    public int allocatedPolyLines;
    public int allocatedRectangles;
    public int allocatedRectangleGradients;
    public int allocatedImages;
    public int allocatedCompositeImages;
    public int allocatedScaleImages;
    public int allocatedScaleImageGradients;
    public int allocatedColorConversions;
    public int allocatedColorGradients;
    public int allocatedParticles;
    public int allocatedParticleClouds;
    public int allocatedParticleGrids;
    public int allocatedParticleSpheres;
    public int allocatedParticleHeightMaps;
    public int allocatedTexts;
    public int allocatedOffscreens;
    public int allocatedScenes;
    public int drawnArcs;
    public int drawnEllipses;
    public int drawnCircularSectors;
    public int drawnCircleGraphs;
    public int drawnCubicBezierCurves;
    public int drawnPolyLines;
    public int drawnRectangles;
    public int drawnRectangleGradients;
    public int drawnImages;
    public int drawnCompositeImages;
    public int drawnScaleImages;
    public int drawnScaleImageGradients;
    public int drawnColorConversions;
    public int drawnColorGradients;
    public int drawnParticles;
    public int drawnParticleClouds;
    public int drawnParticleGrids;
    public int drawnParticleSpheres;
    public int drawnParticleHeightMaps;
    public int drawnTexts;
    public int drawnOffscreens;
    public int drawnScenes;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[allocatedArcs=").append(this.allocatedArcs);
        stringBuilder.append(",allocatedCircularSectors=").append(this.allocatedCircularSectors);
        stringBuilder.append(",allocatedCircleGraphs=").append(this.allocatedCircleGraphs);
        stringBuilder.append(",allocatedCubicBezierCurves=").append(this.allocatedCubicBezierCurves);
        stringBuilder.append(",allocatedEllipses=").append(this.allocatedEllipses);
        stringBuilder.append(",allocatedPolyLines=").append(this.allocatedPolyLines);
        stringBuilder.append(",allocatedRectangles=").append(this.allocatedRectangles);
        stringBuilder.append(",allocatedRectangleGradients=").append(this.allocatedRectangleGradients);
        stringBuilder.append(",allocatedImages=").append(this.allocatedImages);
        stringBuilder.append(",allocatedCompositeImages=").append(this.allocatedCompositeImages);
        stringBuilder.append(",allocatedScaleImages=").append(this.allocatedScaleImages);
        stringBuilder.append(",allocatedScaleImageGradients=").append(this.allocatedScaleImageGradients);
        stringBuilder.append(",allocatedColorConversions=").append(this.allocatedColorConversions);
        stringBuilder.append(",allocatedColorGradients=").append(this.allocatedColorGradients);
        stringBuilder.append(",allocatedParticles=").append(this.allocatedParticles);
        stringBuilder.append(",allocatedParticleClouds=").append(this.allocatedParticleClouds);
        stringBuilder.append(",allocatedParticleGrids=").append(this.allocatedParticleGrids);
        stringBuilder.append(",allocatedParticleSpheres=").append(this.allocatedParticleSpheres);
        stringBuilder.append(",allocatedParticleHeightMaps=").append(this.allocatedParticleHeightMaps);
        stringBuilder.append(",allocatedTexts=").append(this.allocatedTexts);
        stringBuilder.append(",allocatedOffscreens=").append(this.allocatedOffscreens);
        stringBuilder.append(",drawnArcs=").append(this.drawnArcs);
        stringBuilder.append(",drawnCircularSectors=").append(this.drawnCircularSectors);
        stringBuilder.append(",drawnCircleGraphs=").append(this.drawnCircleGraphs);
        stringBuilder.append(",drawnCubicBezierCurves=").append(this.drawnCubicBezierCurves);
        stringBuilder.append(",drawnEllipses=").append(this.drawnEllipses);
        stringBuilder.append(",drawnPolyLines=").append(this.drawnPolyLines);
        stringBuilder.append(",drawnRectangles=").append(this.drawnRectangles);
        stringBuilder.append(",drawnRectangleGradients=").append(this.drawnRectangleGradients);
        stringBuilder.append(",drawnImages=").append(this.drawnImages);
        stringBuilder.append(",drawnCompositeImages=").append(this.drawnCompositeImages);
        stringBuilder.append(",drawnScaleImages=").append(this.drawnScaleImages);
        stringBuilder.append(",drawnScaleImageGradients=").append(this.drawnScaleImageGradients);
        stringBuilder.append(",drawnColorConversions=").append(this.drawnColorConversions);
        stringBuilder.append(",drawnColorGradients=").append(this.drawnColorGradients);
        stringBuilder.append(",drawnParticles=").append(this.drawnParticles);
        stringBuilder.append(",drawnParticleClouds=").append(this.drawnParticleClouds);
        stringBuilder.append(",drawnParticleGrids=").append(this.drawnParticleGrids);
        stringBuilder.append(",drawnParticleSpheres=").append(this.drawnParticleSpheres);
        stringBuilder.append(",drawnParticleHeightMaps=").append(this.drawnParticleHeightMaps);
        stringBuilder.append(",drawnTexts=").append(this.drawnTexts);
        stringBuilder.append(",drawnOffscreens=").append(this.drawnOffscreens);
        stringBuilder.append(",drawnScenes=").append(this.drawnScenes);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void clear() {
        this.drawnArcs = 0;
        this.drawnCircularSectors = 0;
        this.drawnCircleGraphs = 0;
        this.drawnCubicBezierCurves = 0;
        this.drawnEllipses = 0;
        this.drawnPolyLines = 0;
        this.drawnRectangles = 0;
        this.drawnRectangleGradients = 0;
        this.drawnImages = 0;
        this.drawnCompositeImages = 0;
        this.drawnScaleImages = 0;
        this.drawnScaleImageGradients = 0;
        this.drawnColorConversions = 0;
        this.drawnColorGradients = 0;
        this.drawnParticles = 0;
        this.drawnParticleClouds = 0;
        this.drawnParticleGrids = 0;
        this.drawnParticleSpheres = 0;
        this.drawnParticleHeightMaps = 0;
        this.drawnTexts = 0;
        this.drawnOffscreens = 0;
        this.drawnScenes = 0;
    }
}

