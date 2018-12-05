import com.codecool.Streams;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class StreamsTest {

    String[] a1 = {"one", "two", "three"};
    Integer [] c1 = {1,2,4,8,16,32};
    Integer [] d1 = {0, 1, 1, 2, 3, 5,8,13,21,34};
    Streams streams = new Streams();
    Stream.Builder<String> b1 = Stream.<String>builder().add("one").add("two").add("three");

    @Test
    public void shoudCreateStream() {

        assertEquals(Arrays.asList(a1), streams.createStreamFromArray(a1).collect(Collectors.toList()));
    }

    @Test
    public void shoudCreateStreamFromStrings() {

        assertEquals(Arrays.asList(a1), streams.createStreamFromStrings("one", "two", "three").collect(Collectors.toList()));
    }

    @Test
    public void shoudCreateStreamFromStringBuilder() {

        assertEquals(Arrays.asList(a1), streams.createStreamFromStringBuilder(b1).collect(Collectors.toList()));
    }

    @Test
    public void shoudCreateStreamFromPowersOfTwo() {

        assertEquals(Arrays.asList(c1), streams.createStreamOfPowersOfTwo().limit(6).collect(Collectors.toList()));
    }

    @Test
    public void shoudGenerateFibonacci() {
        assertEquals(Arrays.asList(d1), streams.generateFibonacci().limit(10).collect(Collectors.toList()));
    }

}