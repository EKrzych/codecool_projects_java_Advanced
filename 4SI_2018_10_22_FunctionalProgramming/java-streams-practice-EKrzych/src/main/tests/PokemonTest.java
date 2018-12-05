import com.codecool.Pokemon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PokemonTest {
    Pokemon pokemon = new Pokemon();
    @Test
    public void shouldReturnpOkEmOn() {
        String string = "pokemon pokemon";
       assertEquals("pOkEmOn pOkEmOn", pokemon.pOkEmOnCase(string));
    }


}