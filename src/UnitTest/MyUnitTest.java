package UnitTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import Extension.TestDurationReportExtension;

public class MyUnitTest {

	@BeforeAll
	static void initialSetup() {
		System.out.println("Set up once");
	}
	
	@BeforeEach
	void setup() {
		System.out.println("Always set up before each test");
	}
	
	@Test
	void test() {
		System.out.println("Unit test");
	}
	
	@DisplayName("Test Method with Condition")
	@Test
	void HelloGreetings() {
		System.out.println("Hello Peeps!");
	}
	
	@Test
	@Disabled("Implementation Pending")
	void disabledMethod() {
		System.out.println("Disabled testcase");
	}
	
	@AfterEach
	void tearDown() {
		System.out.println("After executing every test");
	}
	
	@AfterAll
	static void finalTearDown() {
		System.out.println("Final");
	}
	
	@Nested
	class nest {
		@BeforeEach
		void initial() {
			System.out.println("Before each test method, this will run first");
		}
		
		@AfterEach
		void tear() {
			System.out.println("After each test method, this will run after");
		}
		
		@Test
		void testInNest() {
			System.out.println("Unit test in nested class");
		}
	}
	
	@Test
	@Tag("UnitTesting")
	void isUnitTestCase() {
		System.out.println("This is a test case tagged for unit testing");
	}
	
	@ExtendWith(TestDurationReportExtension.class)
	@Test
	void extendTest() {
		double result = Math.pow(20,22); // to increase execution time of this test case
		System.out.println("This test case has an extension that checks the execution time, "
				+ "Math.pow output: " + result);
	}

}
