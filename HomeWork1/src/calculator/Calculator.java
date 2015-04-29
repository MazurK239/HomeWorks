package calculator;

public class Calculator {

	// TODO
	//  java Calculator 10 plus 20 plus 100 minus 30 get
	
	
	abstract class Command {
		public void execute() {
			realExecute();
			System.out.println(total);
		}

		abstract void realExecute();
	}
	
	public class Plus extends Command {
		
		int _value;

		Plus(final int value) {
			_value = value;
		}
		
		@Override
		void realExecute() {
			total += _value;
		}
	}
	
	public class Minus extends Plus {
		Minus(final int value) {
			super(-value);
		}
	}
	
	public class Clear extends Command {

		@Override
		void realExecute() {
			total = 0;
		}
		
	}
	
	public class Get extends Command {

		@Override
		void realExecute() {
			// do nothing
		}

	}
	
	int total = 0;
	
	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
		
		int i = 0;
		while (i < args.length) {
			switch (args[i]) {
			case "plus":
				Command plus = calc.new Plus(Integer.valueOf(args[++i]));
				plus.execute();
				break;
			case "minus":
				Command minus = calc.new Minus(Integer.valueOf(args[++i]));
				minus.execute();
				break;
			case "get":
				Command get = calc.new Get();
				get.execute();
				break;
			default:
				calc.total = Integer.valueOf(args[i]);
				break;
			} 
			i++;
		}
		
	}
		

}
