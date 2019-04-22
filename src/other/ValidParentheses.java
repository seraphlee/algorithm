package other;

import java.util.Stack;

/**
 * 利用栈来进行组合消除
 * 1.满足条件的字符串中肯定有一对组合是紧挨着，即（）这种形式
 * 2.满足条件的字符串最后的栈肯定为空
 * 3.满足条件的字符串的栈中肯定不会存储右侧的符号，因为这代表着该字符永远不会被消除
 */
public class ValidParentheses {
    public static void main(String[] args){
        String str = "()([])[]()";
        char[] array = str.toCharArray();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < array.length; i++) {
            if(!stack.empty()){
                char temp = stack.pop();
                switch (temp){
                    case '(':
                        if(array[i] != ')') {
                            stack.push(temp);
                            stack.push(array[i]);
                        }
                        break;
                    case '{':
                        if(array[i] != '}') {
                            stack.push(temp);
                            stack.push(array[i]);
                        }
                        break;
                    case '[':
                        if(array[i] != ']') {
                            stack.push(temp);
                            stack.push(array[i]);
                        }
                        break;
                    default:
                        System.out.println("false");
                        return;
                }
            }else {
                stack.push(array[i]);
            }
        }

        if(stack.empty())
            System.out.println("true");
        else
            System.out.println("false");
    }
}
