/*
 * Copyright 2011 Benjamin Glatzel <benjamin.glatzel@me.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terasology.mods.miniions.rendering.gui.components;

import org.lwjgl.opengl.Display;
import org.terasology.logic.manager.AssetManager;
import org.terasology.rendering.gui.framework.UIDisplayContainer;
import org.terasology.rendering.gui.framework.UIGraphicsElement;

import javax.vecmath.Vector2f;

/**
 * A small toolbar placed at the right of the screen.
 *
 * @author Overdhose copied from toolbar
 */
public class UIMinionbar extends UIDisplayContainer {
    private final UIGraphicsElement backgroundTexture;
    private final UIMinionbarCell[] cells;

    public UIMinionbar() {
        setSize(new Vector2f(44f, 364f));

        backgroundTexture = new UIGraphicsElement(AssetManager.loadTexture("engine:guiMinion"));
        backgroundTexture.setVisible(true);
        backgroundTexture.getTextureSize().set(new Vector2f(22f / 256f, 182f / 256f));
        backgroundTexture.getTextureOrigin().set(new Vector2f(0.0f, 0.0f));
        backgroundTexture.setSize(getSize());

        addDisplayElement(backgroundTexture);

        cells = new UIMinionbarCell[9];

        // Create the toolbar cells
        for (int i = 0; i < 9; i++) {
            cells[i] = new UIMinionbarCell(i);
            cells[i].setVisible(true);
            addDisplayElement(cells[i]);
        }
    }

    @Override
    public void update() {
        super.update();

        centerVertically();
        getPosition().x = Display.getWidth() - getSize().x;
    }
}
