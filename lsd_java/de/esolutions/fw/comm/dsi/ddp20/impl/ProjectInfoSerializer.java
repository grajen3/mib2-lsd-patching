/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.ddp20.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.ddp20.ProjectInfo;

public class ProjectInfoSerializer {
    public static void putOptionalProjectInfo(ISerializer iSerializer, ProjectInfo projectInfo) {
        boolean bl = projectInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = projectInfo.getBrand();
            iSerializer.putInt32(n);
            int n2 = projectInfo.getClassification();
            iSerializer.putInt32(n2);
            int n3 = projectInfo.getGeneration();
            iSerializer.putInt32(n3);
            int n4 = projectInfo.getDerivate();
            iSerializer.putInt32(n4);
            int n5 = projectInfo.getAddition();
            iSerializer.putInt32(n5);
        }
    }

    public static void putOptionalProjectInfoVarArray(ISerializer iSerializer, ProjectInfo[] projectInfoArray) {
        boolean bl = projectInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(projectInfoArray.length);
            for (int i2 = 0; i2 < projectInfoArray.length; ++i2) {
                ProjectInfoSerializer.putOptionalProjectInfo(iSerializer, projectInfoArray[i2]);
            }
        }
    }

    public static ProjectInfo getOptionalProjectInfo(IDeserializer iDeserializer) {
        ProjectInfo projectInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            projectInfo = new ProjectInfo();
            projectInfo.brand = n5 = iDeserializer.getInt32();
            projectInfo.classification = n4 = iDeserializer.getInt32();
            projectInfo.generation = n3 = iDeserializer.getInt32();
            projectInfo.derivate = n2 = iDeserializer.getInt32();
            projectInfo.addition = n = iDeserializer.getInt32();
        }
        return projectInfo;
    }

    public static ProjectInfo[] getOptionalProjectInfoVarArray(IDeserializer iDeserializer) {
        ProjectInfo[] projectInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            projectInfoArray = new ProjectInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                projectInfoArray[i2] = ProjectInfoSerializer.getOptionalProjectInfo(iDeserializer);
            }
        }
        return projectInfoArray;
    }
}

