package betterburrito;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a veggie burrito. A veggie burrito has black beans,
 * medium salsa, cheese, lettuce, and guacamole, all in the regular portions.
 */
public class VeggieBurrito extends CustomBurrito {

  /**
   * Create a veggie burrito using the specified size.
   * @param size the size of this burrito
   */
  private static final Map<Protein, PortionSize> defaultProteins;
  private static final Map<Topping, PortionSize> defaultToppings;

  static {
    defaultProteins = new HashMap<>();
    defaultProteins.put(Protein.BlackBeans, PortionSize.Normal);

    defaultToppings = new HashMap<>();
    defaultToppings.put(Topping.MediumSalsa, PortionSize.Normal);
    defaultToppings.put(Topping.Cheese, PortionSize.Normal);
    defaultToppings.put(Topping.Lettuce, PortionSize.Normal);
    defaultToppings.put(Topping.Guacamole, PortionSize.Normal);
  }

  public VeggieBurrito(Size size) {
    super(size, defaultProteins, defaultToppings);

  }

  public static class VeggieBurritoBuilder extends BurritoBuilder{

    private Size size;

    @Override
    public BurritoBuilder size(Size size) {
      this.size = size;
      return this;
    }

    @Override
    public ObservableBurrito build() {
      return new VeggieBurrito(this.size);

    }


  }
}
