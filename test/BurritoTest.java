import betterburrito.ObservableBurrito;
import org.junit.Before;
import org.junit.Test;

import betterburrito.Burrito;
import betterburrito.CustomBurrito;
import betterburrito.PortionSize;
import betterburrito.Protein;
import betterburrito.Size;
import betterburrito.Topping;
import betterburrito.VeggieBurrito;

import static org.junit.Assert.assertEquals;

/**
 * This is the test class for burritos.
 */
public class BurritoTest {
  private ObservableBurrito alacarteBurrito;
  private ObservableBurrito veggieBurritoJumboSize;
  private ObservableBurrito veggieBurritoLessCheese;


  @Before
  public void setup() {

    // using builder pattern
    alacarteBurrito = new CustomBurrito.CustomBurritoBuilder()
            .size(Size.Normal)
            .addProtein(Protein.Tofu, PortionSize.Normal)
            .addTopping(Topping.Cheese, PortionSize.Normal)
            .addTopping(Topping.MediumSalsa,PortionSize.Less)
            .addTopping(Topping.SourCream,PortionSize.Extra)
            .build();

    veggieBurritoJumboSize = new VeggieBurrito.VeggieBurritoBuilder().size(Size.Jumbo).build();
  }

  @Test
  public void testCost() {
    assertEquals(5.9,alacarteBurrito.cost(),0.01);
    assertEquals(7.2, veggieBurritoJumboSize.cost(),0.01);
    assertEquals(6.9,veggieBurritoLessCheese.cost(),0.01);

  }
}