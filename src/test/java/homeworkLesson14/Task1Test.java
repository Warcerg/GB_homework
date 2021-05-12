package homeworkLesson14;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;



class Task1Test {
    private Task1 task1;

    @BeforeAll
    public static void init(){
        System.out.println("MAIN START!");
    }

    @BeforeEach
    void startUp(){
        System.out.println("Test start");
        task1 = new Task1();
    }

    @AfterEach
    void shutDown(){
        System.out.println("Test ended");
    }

    @AfterAll
    public static void testEnd(){
        System.out.println("MAIN END");
    }

    @DisplayName("Exception Test")
    @Test
    void exceptionTest(){
        Assertions.assertThrows(RuntimeException.class, () ->{
            Assertions.assertArrayEquals(new int[]{3}, task1.arrConversion(new int[]{8,7,3,5}));
        });
    }

    @DisplayName("Parametrized Test")
    @ParameterizedTest
    @MethodSource("data")
    void paramTest(int[] arrA, int[] arrB){
        Assertions.assertArrayEquals(arrA, task1.arrConversion(arrB) );
    }


    static Stream<Arguments> data(){
        return Stream.of(
                Arguments.arguments(new int[]{1,2,3}, new int[]{4,1,2,3} ),
                Arguments.arguments(new int[]{3}, new int[]{2, 7, 5, 4, 1,4,3} ),
                Arguments.arguments(new int[]{3, 8, 1, 2}, new int[]{1, 2, 3, 2, 5, 4, 3, 8, 1, 2} ),
                Arguments.arguments(new int[]{9,7}, new int[]{4, 4, 4, 6, 8, 2, 4, 0, 4, 9, 7} )
        );
    }
}