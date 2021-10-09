package university.week6;

interface Stack {
    boolean isEmpty();
    void push(char data);
    char pop();
    void delete();
    char peek();
}

class Node {
    public char data;
    public Node link;
}

class LinkedStack implements Stack {
    private Node top;

    public LinkedStack() {
        this.top = null;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public void push(char data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.link = top;
        top = newNode;
    }

    @Override
    public char pop() {
        if (top == null) {
            return 0;
        } else {
            char result = top.data;
            top = top.link;
            return result;
        }
    }

    @Override
    public void delete() {
        if (isEmpty()) {
            System.out.println("해당 스택은 비어있습니다.");
        } else {
            top = top.link;
        }
    }

    @Override
    public char peek() {
        if (isEmpty()) {
            System.out.println("해당 스택은 비어있습니다.");
            return 0;
        } else {
            return top.data;
        }
    }

    public void printStack() {
        if(isEmpty())
            System.out.println("해당 스택은 비어있습니다.");
        else{
            Node temp = top;
            System.out.println("Linked Stack>> ");
            while(temp != null){
                System.out.printf("\t %c \n", temp.data);
                temp = temp.link;
            }
            System.out.println();
        }
    }
}

public class StackExample {
    public static void main(String[] args) {
        String test = "(3 * 5) - * (6 - 2)";
        String openedStr = "({[";
        String closedStr = ")}]";
        char compare_chr;
        boolean result = false;
        LinkedStack linkedStack = new LinkedStack();

        for (int i=0; i < test.length(); i++) {
            if (openedStr.contains(Character.toString(test.charAt(i)))) {
                linkedStack.push(test.charAt(i));
            } else if (closedStr.contains(Character.toString(test.charAt(i)))) {
                compare_chr = linkedStack.pop();
                if(compare_chr == '(' && test.charAt(i) != ')' ||
                compare_chr == '{' && test.charAt(i) != '}' ||
                compare_chr == '[' && test.charAt(i) != ']' ||
                compare_chr == 0) {
                    linkedStack.push(compare_chr);
                    break;
                }
            }
        }
        if (linkedStack.isEmpty()) {
            result = true;
        } 
        
        if (result) {
            System.out.println(test + " <- 이 수식은 맞습니다.");
        } else {
            System.out.println(test + " <- 이 수식은 틀렸습니다.");
        }
    }
}
