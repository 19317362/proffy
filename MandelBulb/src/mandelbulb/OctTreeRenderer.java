/*
    Copyright (C) 2009  Paul Richards.

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package mandelbulb;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public final class OctTreeRenderer
{
    private OctTreeRenderer()
    {
    }

    public static void render(
            final OctTree segmentation,
            final Graphics g,
            final double size)
    {
        final long startTime = System.currentTimeMillis();

        final double theta = System.currentTimeMillis() * 0.0005;

        final Rectangle bounds = g.getClipBounds();
        for (int iy = bounds.y; iy < (bounds.y + bounds.height); iy++) {
            for (int ix = bounds.x; ix < (bounds.x + bounds.width); ix++) {
                final double tx = 0.0;
                final double ty = 0.0;
                final double tz = -2.0;
                final double tdx = (ix - size) / size;
                final double tdy = (iy - size) / size;
                final double tdz = 1.0;

                final double x = Math.cos(theta) * tx - Math.sin(theta) * tz;
                final double y = ty;
                final double z = Math.sin(theta) * tx + Math.cos(theta) * tz;
                double dx = Math.cos(theta) * tdx - Math.sin(theta) * tdz;
                double dy = tdy;
                double dz = Math.sin(theta) * tdx + Math.cos(theta) * tdz;

                final double mag = Math.sqrt(dx * dx + dy * dy + dz * dz);
                dx /= mag;
                dy /= mag;
                dz /= mag;
                final double result = segmentation.firstHit(x, y, z, dx, dy, dz);
                g.setColor(Double.isNaN(result) ? Color.BLACK : Color.WHITE);
                g.fillRect(ix, iy, 1, 1);
            }
        }

        final long endTime = System.currentTimeMillis();

        System.out.println("Render took: " + (endTime - startTime) + "ms");
    }
}