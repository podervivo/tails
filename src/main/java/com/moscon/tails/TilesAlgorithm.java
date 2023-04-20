package com.moscon.tails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TilesAlgorithm {

    public static void main(String[] args) {

        // forman un punto
        // declarar una variable:
        // {tipo} {nombre};
        // e.g. int x;
        // e.g. Persona p;
        // instancializar una variable:
        // {tipo} {nombre} = new {consructor({params});
        // e.g. int x = 5;
        // e.g. Persona p = new Persona("Emiliano");

        Punto a = new Punto(-34.889537703047935, -57.99701409010045);
        Punto b = new Punto(-34.890171329087536, -57.91513161886505);
        Punto c = new Punto(-34.95006211036865, -57.996241613956705);
        Punto d = new Punto(-34.949780704829024, -57.913929989308144);
        List<Tile> tilelList = new ArrayList<Tile>();
        for (int zoom = 19; zoom <= 0; zoom--) {

            Tile t1 = getTileNumber(a, zoom);
            Tile t2 = getTileNumber(b, zoom);
            Tile t3 = getTileNumber(c, zoom);
            Tile t4 = getTileNumber(d, zoom);

            List<Tile> tiles = Arrays.asList(t1, t2, t3, t4);
            Tile minXTile = tiles.stream().min((tile1, tile2) -> tile1.getX().compareTo(tile2.getX())).get();

            // realiza un loop por cada tile entre los tiles de las esquinas y los guarda en
            // un array list.
            for (int x = t1.getX(); x <= t3.getX(); x++) {
                for (int y = t2.getY(); y <= t4.getY(); y++) {
                    tilelList.add(new Tile(x, y, zoom));
                }
            }
        }
    }

    public static Tile getTileNumber(Punto p, final int zoom) {
        int xtile = (int) Math.floor((p.getLongitude() + 180) / 360 * (1 << zoom));
        int ytile = (int) Math
                .floor((1 - Math
                        .log(Math.tan(Math.toRadians(p.getLatitude())) + 1 / Math.cos(Math.toRadians(p.getLatitude())))
                        / Math.PI)
                        / 2 * (1 << zoom));
        if (xtile < 0)
            xtile = 0;
        if (xtile >= (1 << zoom))
            xtile = ((1 << zoom) - 1);
        if (ytile < 0)
            ytile = 0;
        if (ytile >= (1 << zoom))
            ytile = ((1 << zoom) - 1);
        // return ("" + zoom + "/" + xtile + "/" + ytile);
        return new Tile(xtile, ytile, zoom);
    }

}
