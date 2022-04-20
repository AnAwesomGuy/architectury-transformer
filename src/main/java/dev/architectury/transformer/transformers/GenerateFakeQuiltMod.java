/*
 * This file is licensed under the MIT License, part of architectury-transformer.
 * Copyright (c) 2020, 2021 architectury
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package dev.architectury.transformer.transformers;

import dev.architectury.transformer.input.FileAccess;
import dev.architectury.transformer.transformers.base.edit.TransformerContext;

/**
 * Generates a fake quilt mod.
 */
public class GenerateFakeQuiltMod extends AbstractFakeMod {
    @Override
    public void doEdit(TransformerContext context, FileAccess output) throws Exception {
        String fakeModId = generateModId();
        output.addFile("quilt.mod.json",
                "{\n" +
                "  \"schema_version\": 1,\n" +
                "  \"quilt_loader\": {\n" +
                "    \"group\": \"architectury." + fakeModId + "\",\n" +
                "    \"id\": \"" + fakeModId + "\",\n" +
                "    \"version\": \"1.0.0\",\n" +
                "    \"metadata\": {\n" +
                "      \"name\": \"Generated Mod (Please Ignore)\"\n" +
                "    }\n" +
                "  }\n" +
                "}\n");
    }
}