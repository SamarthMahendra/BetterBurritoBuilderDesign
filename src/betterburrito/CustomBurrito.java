package betterburrito;

import betterburrito.Burrito;
import betterburrito.PortionSize;
import betterburrito.Protein;
import betterburrito.Size;
import betterburrito.Topping;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a custom burrito that can have an arbitrary number
 * of proteins and toppings, both of arbitrary portion sizes.
 */
public class CustomBurrito implements ObservableBurrito {
  protected Size size;
  protected final Map<Protein, PortionSize> proteins;
  protected final Map<Topping,PortionSize> toppings;

  /**
   * Create a custom burrito of the specified size.
   * @param size the size of this burrito
   */
  protected CustomBurrito(Size size, Map<Protein, PortionSize> proteins, Map<Topping, PortionSize> toppings) {
    this.size = size;
    this.proteins = proteins;
    this.toppings = toppings;
  }


  @Override
  public PortionSize hasTopping(Topping name) {
    return this.toppings.getOrDefault(name,null);
  }

  @Override
  public PortionSize hasProtein(Protein name) {
    return this.proteins.getOrDefault(name,null);
  }

  @Override
  public double cost() {
    double cost = 0.0;
    for (Map.Entry<Protein, PortionSize> item : this.proteins.entrySet()) {
      cost += item.getKey().getCost() * item.getValue().getCostMultipler();
    }

    for (Map.Entry<Topping, PortionSize> item : this.toppings.entrySet()) {
      cost += item.getKey().getCost() * item.getValue().getCostMultipler();
    }
    return cost + this.size.getBaseCost();
  }

  public static class CustomBurritoBuilder extends BurritoBuilder{
    private Size size;
    private final Map<Protein, PortionSize> proteins = new HashMap<>();
    private final Map<Topping, PortionSize> toppings = new HashMap<>();

    public CustomBurritoBuilder size(Size size) {
      this.size = size;
      return this;
    }

    public CustomBurritoBuilder addProtein(Protein protein, PortionSize portionSize) {
      this.proteins.put(protein, portionSize);
      return this;
    }

    public CustomBurritoBuilder addTopping(Topping topping, PortionSize portionSize) {
      this.toppings.put(topping, portionSize);
      return this;
    }

    public ObservableBurrito build() {
      return new CustomBurrito(size, proteins, toppings);
    }

  }


}
