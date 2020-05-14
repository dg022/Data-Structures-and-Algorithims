
// Author: David George
// Student ID: 251004930 



import java.io.IOException;
import java.util.Stack;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;


public class RoadMap {

	
	// These are all private instance varibles: 
	
	private int Budget;
	private int toll;
	private int gain;
    private int start;
    private int end;
    private int width;
    private int length;
 
    private Graph map;


    // This holds nodes during depth first search 
    private Stack nodeStack = new Stack<Node>();

    public RoadMap(String inputFile) throws MapException {
        try {
            BufferedReader in = new BufferedReader(new FileReader(inputFile));
            String output = in.readLine();
            output = in.readLine();

            int count = 1;

            // Iterates through first 8 lines of final, assigns values 
            if (output != null) {
                do {

                    if (count == 1) {

                        this.start = Integer.parseInt(output);
                    } else if (count == 2) {

                        this.end = Integer.parseInt(output);
                    } else if (count == 3) {

                        this.width = Integer.parseInt(output);

                    } else if (count == 4) {

                        this.length = Integer.parseInt(output);

                    } else if (count == 5) {

                        this.Budget = Integer.parseInt(output);

                    } else if (count == 6) {

                        this.toll = Integer.parseInt(output);

                    } else if (count == 7) {

                        this.gain = Integer.parseInt(output);
                        break;

                    }

                    count++;
                    output = in.readLine();

                } while (output != null);
            }

            map = new Graph(length * width);

            int Node_Counter = 0;

            // Scan the code two lines at a time, interpret the paths in this manner

            String Current = in.readLine();
            String Next = in.readLine();

            boolean continual = true;


            while (continual) {

                // Break out of loop once both lines are null, ie end of file 
                if (Current == null && Next == null) {
                    in.close();
                    break;
                }

                int i = 0;

                if (i < Current.length()) {
                    do {

                        char symbol;
                        symbol = Current.charAt(i);

                        // This logic establishes the connections within the graph

                        if (symbol != '+') {
                            if (symbol == 'F')
                                map.insertEdge(map.getNode(Node_Counter - 1), map.getNode(Node_Counter), 0);

                            else if (symbol == 'T') {
                                map.insertEdge(map.getNode(Node_Counter - 1), map.getNode(Node_Counter), 1);

                            } else if (symbol == 'C') {
                                map.insertEdge(map.getNode(Node_Counter - 1), map.getNode(Node_Counter), -1);

                            }
                        } else {

                            if (Next != null) {

                            	
                            	//This logic looks to the next line to set the conencitosn

                                if (Next.charAt(i) == 'F') {
                                    map.insertEdge(map.getNode(Node_Counter), map.getNode(Node_Counter + width), 0);

                                } else if (Next.charAt(i) == 'T')
                                    map.insertEdge(map.getNode(Node_Counter), map.getNode(Node_Counter + width), 1);
                                else if (Next.charAt(i) == 'c') {
                                    map.insertEdge(map.getNode(Node_Counter), map.getNode(Node_Counter + width), -1);

                                }

                            }
                            Node_Counter++;

                        }

                        i++;

                    } while (i < Current.length());
                }

                // Iterate to the next lines in the file
                Current = in.readLine();
                Next = in.readLine();

            }
        }

        // If any of the files are not found, throw an error

        catch (FileNotFoundException e) {
            throw new MapException();
        } catch (GraphException e) {
            throw new MapException();
        } catch (IOException e) {
            throw new MapException();
        }
    }

    public Graph getGraph() throws MapException {
        if (map == null) {
            throw new MapException();
        } else if(map!=null) {
            return this.map;
        }
        
        return null; 
    }

    
    public int getInitialMoney() {
        return Budget;
    }
    public int getStartingNode() {
        return start;
    }

    public int getDestinationNode() {
        return end;
    }

   

    public Iterator findPath(int start, int destination, int initialMoney) {
        try {
            if (DepthFirstRecurison(start, destination, initialMoney) && nodeStack.size() != 0)
                return nodeStack.iterator();

            return null;
        } catch (MapException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    private Iterator get_Map(Graph map, int starting) {

        try {
            Iterator<Edge> itreation = map.incidentEdges(map.getNode(starting));
            return itreation;
        } catch (GraphException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    private boolean DepthFirstRecurison(int starting, int ending, int money) throws MapException {
        try {

            map.getNode(starting).setMark(true);
            nodeStack.push(map.getNode(starting));

            if (starting == ending)
                return true;
            else {

                Iterator<Edge> itreation = get_Map(map, starting);

                while (itreation.hasNext()) {

                    Edge current = itreation.next();

                    Node first_node = current.firstEndpoint();
                    Node second_node = current.secondEndpoint();

                    Node nodeDirection = null;

                    if (starting == first_node.getName()) {
                        nodeDirection = second_node;
                    } else if (starting != first_node.getName() ){
                        nodeDirection = first_node;
                    }

                    if (!nodeDirection.getMark()) {

                        int new_money = money;

                        if (current.getType() == 1) {

                            new_money = new_money - toll;

                        }

                        else if (current.getType() == -1) {

                            new_money = new_money + gain;

                        }

                        if (new_money >= 0 && DepthFirstRecurison(nodeDirection.getName(), ending, new_money)) {
                            return true;
                        }
                    }
                }

                map.getNode(starting).setMark(false);
                nodeStack.pop();
                return false;

            }

        } catch (Exception p) {
            throw new MapException();
        }

    }

}
