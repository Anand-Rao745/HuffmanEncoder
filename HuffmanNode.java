import java.lang.Comparable;

/**
 * A class to represent the Huffman Node.
 * @author  Anand Rao
 */ 
public class HuffmanNode implements Comparable<HuffmanNode>{
  /*Stores the character of the node.*/
  public Character inChar;
  /*Stores the frequency of the character .*/
  public int frequency;
  /*Reference to the left child of the node.*/
  HuffmanNode left;
  /*Reference to the right child of the node.*/
  HuffmanNode right;
  
  /**
   * The constructor.
   * @param the Character of the HuffmanNode.
   * @param the frequency of the Character.
   * @param the left child of the HuffmanNode.
   * @param the right child of the HuffmanNode.
   */
  public HuffmanNode(Character inChar, int frequency, HuffmanNode left, HuffmanNode right){
    this.inChar=inChar;
    this.frequency=frequency;
    this.left=left;
    this.right=right;
  }
  
  /**
   * Compares two HuffmanNodes by their frequencies.
   * @param the HuffmanNode that will be used in the comparison.
   * @return -1, 0, or 1 if the HuffmanNode is less than, equal to, or greater than the HuffmanNode object.
   */
  public int compareTo(HuffmanNode a){
    if(this.frequency<a.frequency){
      return -1;
    }
    else{
      if(this.frequency==a.frequency){
        return 0;
      }
      else{
        return 1;
      }
    }
  }
  
  /**
   * Provides access to the character of a Huffman Node.
   * @return the character of a Huffman Node.
   */
  public Character getInChar(){
    return this.inChar;
  }
  
}