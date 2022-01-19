package fr.oinkoink.neurchi.survie.utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.OfflinePlayer;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFactory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;
public class ItemBuilder
        {
      private final ItemStack itemStack;
      public ItemBuilder() { this(Material.AIR); }
            public ItemBuilder(Material material) { this.itemStack = new ItemStack(material); }
            public ItemBuilder(ItemStack other) { this.itemStack = new ItemStack(other); }
            private ItemBuilder applyMeta(Consumer<ItemMeta> metaConsumer) {
          ItemMeta itemMeta = this.itemStack.getItemMeta();
          if (itemMeta == null) {
              ItemFactory itemFactory = Bukkit.getItemFactory();
              Material type = this.itemStack.getType();
              itemMeta = itemFactory.getItemMeta(type);
                }
          metaConsumer.accept(itemMeta);
          this.itemStack.setItemMeta(itemMeta);
          return this;
      }
      public ItemBuilder withType(Material material) {
          this.itemStack.setType(material);
          return this;
      }
      public ItemBuilder withAmount(int amount) {
          this.itemStack.setAmount(amount);
          return this;
      }
      public ItemBuilder withName(String name) {
          return applyMeta(itemMeta -> itemMeta.setDisplayName(name));
      }
      public ItemBuilder withLocalizedName(String name) {
          return applyMeta(itemMeta -> itemMeta.setLocalizedName(name));
      }
      public ItemBuilder withFlags(ItemFlag... flags) {
          return applyMeta(itemMeta -> itemMeta.addItemFlags(flags));
      }
      public <T> ItemBuilder withTag(NamespacedKey key, PersistentDataType<T, String> type) {
          return withTag(key, type, key.getKey());
      }
      public <T, Z> ItemBuilder withTag(NamespacedKey key, PersistentDataType<T, Z> type, Z value) {
          return applyMeta(itemMeta -> {
              PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();
              persistentDataContainer.set(key, type, value);
          });
      }
      public ItemBuilder withAttributeModifier(Attribute attribute, AttributeModifier modifier) {
          return applyMeta(itemMeta -> {
                                });
      }
      public ItemBuilder withLore(String... lines) {
          return applyMeta(itemMeta -> {
              if (lines!= null) {
                  List<String> lore = itemMeta.getLore();
                  if (lore == null)
                      lore = new ArrayList<>();
                  Collections.addAll(lore, lines);
                  itemMeta.setLore(lore);
              } else {
                  itemMeta.setLore(null);
              }
          });
      }
      public ItemBuilder clearLore() { return withLore(null); }
            public ItemBuilder withEnchantment(Enchantment enchantment) { return withEnchantment(enchantment, 1, true); }
            public ItemBuilder withEnchantment(Enchantment enchantment, int level) { return withEnchantment(enchantment, level, true); }
              public ItemBuilder withEnchantment(Enchantment enchantment, int level, boolean ignoreLevelRestriction) {
          return applyMeta(itemMeta -> {

          });
      } public ItemBuilder withDamage(int damage) {
          return applyMeta(itemMeta -> {
              if (itemMeta instanceof Damageable)
                  ((Damageable)itemMeta).setDamage(damage);
          });
      }
      public ItemBuilder withColor(Color color) {
        return applyMeta(itemMeta -> {
            if (itemMeta instanceof LeatherArmorMeta) {
                ((LeatherArmorMeta)itemMeta).setColor(color);
            } else if (itemMeta instanceof PotionMeta) {
                ((PotionMeta)itemMeta).setColor(color);
            } else if (itemMeta instanceof MapMeta) {
                ((MapMeta)itemMeta).setColor(color);
            }
        });
      }
      public ItemBuilder clearColor() {
          return withColor(null);
      }
      public ItemBuilder withSkullOwner(OfflinePlayer offlinePlayer) {
          return applyMeta(itemMeta -> {
              if (itemMeta instanceof SkullMeta)
                  ((SkullMeta)itemMeta).setOwningPlayer(offlinePlayer);
          });
      }
      public ItemBuilder withPotionType(PotionType potionType) {
          return applyMeta(itemMeta -> {
              if (itemMeta instanceof PotionMeta) {
                  ((PotionMeta)itemMeta).setBasePotionData(new PotionData(potionType));
              }
          });
      }
      public ItemStack build() { return this.itemStack.clone(); }
    }