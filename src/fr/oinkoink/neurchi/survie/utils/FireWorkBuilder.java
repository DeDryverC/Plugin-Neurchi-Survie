package fr.oinkoink.neurchi.survie.utils;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.Random;

public class FireWorkBuilder {


    public FireWorkBuilder(LivingEntity entity, Location entityLoc, Integer power) {

        Firework fw = (Firework) entity.getWorld().spawnEntity(entityLoc, EntityType.FIREWORK);
        FireworkMeta fwm = fw.getFireworkMeta();
        //Our random generator
        Random r = new Random();
        int rt = r.nextInt(4) + 1;
        FireworkEffect.Type type = FireworkEffect.Type.BALL;
        if (rt == 1) type = FireworkEffect.Type.BALL;
        if (rt == 2) type = FireworkEffect.Type.BALL_LARGE;
        if (rt == 3) type = FireworkEffect.Type.BURST;
        if (rt == 4) type = FireworkEffect.Type.CREEPER;
        if (rt == 5) type = FireworkEffect.Type.STAR;

        //Get our random colours
        int r1i = r.nextInt(17) + 1;
        int r2i = r.nextInt(17) + 1;
        Color c1 = getColor(r1i);
        Color c2 = getColor(r2i);

        //Create our effect with this
        FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withFade(c2).with(type).trail(r.nextBoolean()).build();

        //Then apply the effect to the meta
        fwm.addEffect(effect);

        //Generate some random power and set it
        fwm.setPower(power);

        //Then apply this to our rocket
        fw.setFireworkMeta(fwm);
        fw.detonate();
    }

    private Color getColor(int i) {
        Color c = null;
        switch(i){
            case 1: c=Color.AQUA; break;
            case 2: c=Color.BLACK; break;
            case 3: c=Color.BLUE; break;
            case 4: c=Color.FUCHSIA; break;
            case 5: c=Color.GRAY; break;
            case 6: c=Color.GREEN; break;
            case 7: c=Color.LIME; break;
            case 8: c=Color.MAROON; break;
            case 9: c=Color.NAVY; break;
            case 10: c=Color.OLIVE; break;
            case 11: c=Color.ORANGE; break;
            case 12: c=Color.PURPLE; break;
            case 13: c=Color.RED; break;
            case 14: c=Color.SILVER; break;
            case 15: c=Color.TEAL; break;
            case 16: c=Color.WHITE; break;
            case 17: c=Color.YELLOW; break;
            default: c=Color.PURPLE; break;
        }
        return c;
    }
}

