
package com.game.asteroids.entity.components;

import com.badlogic.ashley.core.Component;

/**
 * This components hold the stats used by the system to calculate
 * the movements.
 *
 * @paramater baseRotationSpeed: the base rotation speed before any modification
 * @paramater baseVelX: the base velX speed before any modification
 * @paramater baseVelY: the base velY speed before any modification
 * @paramater rotationSpeed: the  rotation speed used to calculate the player rotation
 * @paramater velX: the speed used to calculate the player position
 * @paramater velY: the speed used to calculate the player position
 */
public class MovementStatsComponent implements Component {
    public float baseRotationSpeed = 0.0f;
    public float baseVelX = 0.0f;
    public float baseVelY = 0.0f;
    public float rotationSpeed = 0.0f;
    public float velX = 0.0f;
    public float velY = 0.0f;
    
}
