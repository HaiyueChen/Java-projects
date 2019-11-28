import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Huffman
 */
public class Huffman {

    public static HuffmanNode textToTree(String text){

        HashMap<Character, Integer> frequencyCount = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            Character character = text.charAt(i);
            if (frequencyCount.containsKey(character)) {
                frequencyCount.put(character, frequencyCount.get(character) + 1);
            }
            else{
                frequencyCount.put(character, 1);
            }
        }

        PriorityQueue<HuffmanNode> ranked = new PriorityQueue<>(
            new Comparator<HuffmanNode>() {
                @Override
                public int compare(HuffmanNode h1, HuffmanNode h2){
                    return Integer.compare(h1.getFrequency(), h2.getFrequency());
                }
            }
        );

        for (Character character : frequencyCount.keySet()) {
            System.out.printf("Char: %s : %d \n", character, frequencyCount.get(character));
            ranked.add(new HuffmanNode(
                        String.valueOf(character), 
                        frequencyCount.get(character))
                        );
        }

        while (ranked.size() > 1) {
            HuffmanNode h1 = ranked.poll();
            HuffmanNode h2 = ranked.poll();

            String newValue = h1.getValue().concat(h2.getValue());
            int newFrequency = h1.getFrequency() + h2.getFrequency();
            HuffmanNode newRoot = new HuffmanNode(newValue, newFrequency);
            newRoot.setLeft(h1);
            newRoot.setRight(h2);
            ranked.add(newRoot);
        }

        HuffmanNode root = ranked.poll();        
        System.out.printf("Value: %s | frequency: %s\n", root.getValue(), root.getFrequency());
        return root;
    }

    public static String encode(HuffmanNode root, String text){
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            builder.append(getCode(root, String.valueOf(text.charAt(i))));
        }
        return builder.toString();
    }

    private static String getCode(HuffmanNode root, String character){
        HuffmanNode iter = root;
        StringBuilder builder = new StringBuilder();
        while (iter != null) {
            if (iter.getValue().equals(character)) {
                return builder.toString();
            }
            if(iter.getLeft() != null && iter.getLeft().getValue().contains(character)){
                builder.append("0");
                iter = iter.getLeft();
            }
            else if(iter.getRight() != null && iter.getRight().getValue().contains(character)){
                builder.append("1");
                iter = iter.getRight();
            }
            else{
                break;
            }
        }
        return "Something wrong";
    }

    public static String decode(HuffmanNode root, String code){
        if (root == null) return "";

        StringBuilder builder = new StringBuilder();

        HuffmanNode iter = root;
        for (int i = 0; i < code.length(); i++) {
            String stringAtI = String.valueOf(code.charAt(i));

            if (iter.getLeft() == null && iter.getRight() == null) {
                iter = root;
            }

            if (stringAtI.equals("0")) {
                iter = iter.getLeft();
                if (iter.getLeft() == null && iter.getRight() == null) {
                    builder.append(iter.getValue());
                    iter = root;
                }   
            }
            else if (stringAtI.equals("1")) {
                iter = iter.getRight();
                if (iter.getLeft() == null && iter.getRight() == null) {
                    builder.append(iter.getValue());
                    iter = root;
                }   
            }
            else{
                System.out.println("Code corrupted at: " + i);
                System.out.println(code);
                return "";
            }
        }
        return builder.toString();
    }
}

/**
 * HuffmanNode
 */
class HuffmanNode {
    private String value;
    private int frequency;
    private HuffmanNode left = null;
    private HuffmanNode right = null;

    HuffmanNode(String value, int frequency){
        this.value = value;
        this.frequency = frequency;
    }

    public String getValue(){
        return this.value;
    }

    public int getFrequency(){
        return this.frequency;
    }

    public HuffmanNode getLeft(){
        return this.left;
    }

    public HuffmanNode getRight(){
        return this.right;
    }

    public void setValue(String value){
        this.value = value;
    }

    public void setFrequency(int frequency){
        this.frequency = frequency;
    }

    public void setLeft(HuffmanNode left){
        this.left = left;
    }
    
    public void setRight(HuffmanNode right){
        this.right = right;
    }

}