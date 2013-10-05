package java5.bridge;

public class Bridge implements B {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		B bridge = new Bridge();
		bridge.m("sdlfjsd");
		((A<String>) bridge).m("fgre");
	}

	@Override
	public void m(String s) {
		System.out.println(s);
		
	}

}
