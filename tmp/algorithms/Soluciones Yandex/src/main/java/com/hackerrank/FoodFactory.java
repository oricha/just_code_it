/**
 * You share the idea with a friend who is a programmer. In order to make it
 * fun, he immediately gives you a code snippet and asks you to modify it so
 * that it prints the following lines: My name is: Fastfood My name is: Fruits
 * Our superclass is: Food I'm serving Fastfood I'm serving Fruits Can you
 * complete the challenge? Read the code in the editor and complete it so that
 * it prints the desired output.
 * 
 * @author Zion
 *
 */
public class FoodFactory {

	public Food getFood(String string) {
		if (string.equalsIgnoreCase("Fastfood")) {
			return new Fastfood(string);
		} else if (string.equalsIgnoreCase("Fruits")) {
			return new Fruits(string);
		}
		return null;
	}

	class Fastfood extends Food {
		public Fastfood(String string) {
			super(string);
		}

		@Override
		public String getName() {
			return name;
		}
	}

	class Fruits extends Food {
		public Fruits(String string) {
			super(string);
		}

		@Override
		public String getName() {
			return name;
		}
	}

	class Food {
		protected String name;

		public Food(String string) {
			name = string;
		}

		public String getName() {
			return null;
		}

		public void serveFood() {
			System.out.println("I'm serving " + name);
		}
	}

}
