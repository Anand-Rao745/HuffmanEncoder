import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.PriorityQueue;
import java.io.BufferedReader;
import java.util.Collections;
import java.io.PrintStream;
import java.io.File;
import java.util.HashMap;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

/**
 * A program to compress files using Huffman Encoding.
 * @author  Anand Rao
 */ 
public class Huffman{
  

  public static ArrayList scan(String inputFileName) throws FileNotFoundException, IOException{
    ArrayList<HuffmanNode>table= new ArrayList<HuffmanNode>();
    HashMap<Character,Integer> t= new HashMap<Character,Integer>();
    BufferedReader b= new BufferedReader(new FileReader(inputFileName));
    int c;
    for(int i=0;(c=b.read())!=-1;i++){
      if(!(t.containsKey((char)c))){
        t.put((char)c,1);
      }
      else{
        t.put((char)c,t.get((char)c)+1);
      }
    }
    Set<Character>setofchars= t.keySet();
    for(Character d:setofchars){
      table.add(new HuffmanNode(d, t.get(d), null, null));
    }
    Collections.sort(table);
    return table;
  }
  

  public static HuffmanNode merge(HuffmanNode a, HuffmanNode b){
    int sum=(a.frequency+b.frequency);
    HuffmanNode c= new HuffmanNode(null, sum, a, b);
    return c;
  }
  

  public static HuffmanNode buildTree(String inputFileName)throws FileNotFoundException, IOException{
    PriorityQueue<HuffmanNode> queue = new PriorityQueue<HuffmanNode>();
    HuffmanNode root=null;
    ArrayList list=scan(inputFileName);
    for(int i=0;i<list.size();i++){
      queue.add((HuffmanNode)list.get(i));
    }
    for(int i=0;queue.size()>1;i++){
      HuffmanNode least1 = queue.poll();
      HuffmanNode least2 = queue.poll();
      HuffmanNode combined=merge(least1,least2);
      queue.add(combined);
      root=combined;
    }
    return root;
  }
  

  public static void output(HuffmanNode root, String binary){
    if (root!=null){   
      if (root.left!=null){
        output(root.left, binary+"0");
      }
      if (root.right!=null){   
        output(root.right, binary+"1");
      }
      if (root.left==null && root.right==null){
        System.out.println(root.inChar+":"+ root.frequency +":" +binary);   
      }
    }       
  }
  

  public static void createFile(String inputFileName)throws IOException, FileNotFoundException{
    PrintStream p1 = new PrintStream(new File("table.txt"));
    System.setOut(p1);
    Huffman.output(Huffman.buildTree(inputFileName), ""); //prints table to file
    BufferedReader b1= new BufferedReader(new FileReader("table.txt"));
    PrintStream p2= new PrintStream(new File("output.txt"));
    System.setOut(p2);
    for(int i=0;b1.read()!=-1;i++){
      String s=b1.readLine();
      String s2=s.substring(s.lastIndexOf(":")+1,s.length()).trim();
      System.out.print(s2);//prints encoding to file
    }
  }
  
   
  public static void main(String[] args) throws FileNotFoundException, IOException{
    try{
      createFile(args[0]);
    }
    catch(FileNotFoundException f){
      JFrame frame= new JFrame();
      JOptionPane.showMessageDialog(frame, "File not found."); 
      System.exit(0);
    }
    catch(IOException e){
      JFrame frame= new JFrame();
      JOptionPane.showMessageDialog(frame, "Unable to read file."); 
      System.exit(0);
    }
  }
}

