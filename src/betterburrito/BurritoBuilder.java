package betterburrito;

import betterburrito.CustomBurrito.CustomBurritoBuilder;
import betterburrito.Burrito;
import betterburrito.Size;

public abstract class BurritoBuilder {

  public abstract BurritoBuilder size(Size size);

  public abstract ObservableBurrito build();

}
