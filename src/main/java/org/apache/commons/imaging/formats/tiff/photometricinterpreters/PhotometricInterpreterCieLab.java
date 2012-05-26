/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.imaging.formats.tiff.photometricinterpreters;

import java.io.IOException;

import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.color.ColorConversions;
import org.apache.commons.imaging.common.ImageBuilder;

public class PhotometricInterpreterCieLab extends PhotometricInterpreter {
    public PhotometricInterpreterCieLab(int fSamplesPerPixel,
            int fBitsPerSample[], int Predictor, int width, int height) {
        super(fSamplesPerPixel, fBitsPerSample, Predictor, width, height);
    }

    @Override
    public void dumpstats() throws ImageReadException, IOException {
    }

    @Override
    public void interpretPixel(ImageBuilder imageBuilder, int samples[], int x,
            int y) throws ImageReadException, IOException {
        int cieL = samples[0];
        int cieA = (byte) samples[1];
        int cieB = (byte) samples[2];

        int rgb = ColorConversions.convertCIELabtoARGBTest(cieL, cieA, cieB);
        imageBuilder.setRGB(x, y, rgb);
    }

}
