package components;

public class Test1 {

	int test = 0;
	
	public  Test1() {
	}

	public int getTest() {
		return test;
	}

	public void setTest(int test) {
		this.test = test;
	}
	
	
	public static void main(String[] args) {
		Test1 test1 = new Test1();
		Test1 test2 = new Test1();
		
		test1.setTest(1);
		test2.setTest(2);
		
		System.out.println(test1.test);
		System.out.println(test2.test);
		System.out.println(test1.test);
		
	}
}
