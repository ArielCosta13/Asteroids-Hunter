
package com.game.asteroids.utils;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Utility {

    public static void queueAddImages(AssetManager manager){
        System.out.println("Loading atlas");
     
        System.out.println("Finish Loading atlas");
    }

    /**
     *Trim the value of rotation when in over 360
     *
     * @param rotation
     * @return 
     */
    public static float trimRotationValue(float rotation) {
        if (rotation > 360){
            rotation = rotation -360;
        }
        if (rotation < -360){
            rotation = rotation + 360;
        }
        return rotation;
    }

    public static Vector2 transpolateAttachPointOffset(float AttachmentPointX, float AttachmentPointY,
                                                       float centerX, float centerY,
                                                       float pivotPointX, float pivotPointY,
                                                       float rotation){
        float centeredX = AttachmentPointX - pivotPointX;
        float centeredY = AttachmentPointY - pivotPointY;
        float x =  (float) (centeredX * Math.cos(Math.toRadians((double)rotation))) -
                (float) (centeredY * Math.sin(Math.toRadians((double)rotation)));
        float y =  (float) (centeredX * Math.sin(Math.toRadians((double)rotation))) +
                (float) (centeredY * Math.cos(Math.toRadians((double)rotation)));
         x = x + pivotPointX - centerX;
         y = y + pivotPointY - centerY;
         return new Vector2(x,y);
    }

    public static float calculateVectorialX(float a,float angle){
        return (float) (a * Math.sin(-Math.toRadians(angle)));
    }

    public static float calculateVectorialY(float a,float angle){
        return (float) (a * Math.cos(-Math.toRadians(angle)));
    }

    public static Vector3 calculateVector(float a, float angle){
        Vector3 vector = new Vector3();
        vector.x = calculateVectorialX(a,angle);
        vector.y = calculateVectorialY(a,angle);
        vector.z = 0;
        return vector;

    }

    public static Texture combineTextures(Texture texture1, Texture texture2) {
        texture1.getTextureData().prepare();
        Pixmap pixmap1 = texture1.getTextureData().consumePixmap();
        texture2.getTextureData().prepare();
        Pixmap pixmap2 = texture2.getTextureData().consumePixmap();
        pixmap1.drawPixmap(pixmap2, 0, 0);
        Texture textureResult = new Texture(pixmap1);
        pixmap1.dispose();
        pixmap2.dispose();
        return textureResult;
    }



}
