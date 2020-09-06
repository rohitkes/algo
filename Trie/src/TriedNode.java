import java.util.HashMap;
import java.util.Map;

public class TriedNode {
    Map<Character, TriedNode> children = new HashMap<>();
    boolean endOfWord;
}
