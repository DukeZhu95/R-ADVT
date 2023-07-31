package Entity;

import Main.GamePanel;
import Main.KeyboardHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity{
    GamePanel gp;
    KeyboardHandler KeyboardHandler;

    public Player (GamePanel gp, KeyboardHandler KeyboardHandler) {
        this.gp = gp;
        this.KeyboardHandler = KeyboardHandler;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Male_back_left.png")));
            up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Male_stand.png")));
            up3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Male_back_right.png")));
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Male_forward_left.png")));
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Male_stand.png")));
            down3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Male_forward_right.png")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Male_left_handforward.png")));
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Male_left_stand.png")));
            left3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Male_left_handback.png")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Male_right_handback.png")));
            right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Male_right_stand.png")));
            right3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/Male_right_handforward.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (KeyboardHandler.upPressed) {
            direction = "up";
            y -= speed;
        }
        if (KeyboardHandler.downPressed) {
            direction = "down";
            y += speed;
        }
        if (KeyboardHandler.leftPressed) {
            direction = "left";
            x -= speed;
        }
        if (KeyboardHandler.rightPressed) {
            direction = "right";
            x += speed;
        }
    }

    public void draw(Graphics2D g2) {
//        g2.setColor(Color.WHITE);
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = switch (direction) {
            case "up" -> up2;
            case "down" -> down2;
            case "left" -> left2;
            case "right" -> right2;
            default -> null;
        };

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }

}
