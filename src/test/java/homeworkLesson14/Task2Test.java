package homeworkLesson14;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


class Task2Test {
    private Task2 task2;

    @BeforeAll
    public static void init(){
        System.out.println("MAIN START!");
    }

    @BeforeEach
    void startUp(){
        System.out.println("Test start");
        task2 = new Task2();
    }

    @AfterEach
    void shutDown(){
        System.out.println("Test ended");
    }

    @AfterAll
    public static void testEnd(){
        System.out.println("MAIN END");
    }


    @DisplayName("Parametrized Test")
    @ParameterizedTest
    @MethodSource("data")
    void paramTest(boolean parA, int[] arrB){
        Assertions.assertEquals(parA, task2.arrCheck(arrB) );
    }


    static Stream<Arguments> data(){
        return Stream.of(
                Arguments.arguments( true, new int[]{1, 4, 1, 4, 4, 1, 1} ),
                Arguments.arguments(true, new int[]{4, 4, 4, 4, 1, 4, 4, 4} ),
                Arguments.arguments(false, new int[]{1, 1, 1, 1, 1, 1, 1} ),
                Arguments.arguments(false, new int[]{4, 4, 4, 4, 4, 4} ),
                Arguments.arguments(false, new int[]{1, 1, 1, 4, 1, 4, 5, 1, 4} ),
                Arguments.arguments(false, new int[]{2, 3, 4, 5, 2, 4, 1, 6, 7} )
        );
    }


}