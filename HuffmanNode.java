import java.lang.Comparable;

/**
 * A class to represent the Huffman Node.
 * @author  Anand Rao
 */ 
public class HuffmanNode implements Comparable<HuffmanNode>{

  public Character inChar;

  public int frequency;
 
  HuffmanNode left;

  HuffmanNode right;
  

  public HuffmanNode(Character inChar, int frequency, HuffmanNode left, HuffmanNode right){
    this.inChar=inChar;
    this.frequency=frequency;
    this.left=left;
    this.right=right;
  }
  

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
  

  public Character getInChar(){
    return this.inChar;
  }
  
}
