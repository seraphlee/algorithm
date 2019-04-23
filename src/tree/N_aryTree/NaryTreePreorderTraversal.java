package tree.N_aryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

/**
 * N叉树的前序遍历
 */
public class NaryTreePreorderTraversal {
    /* 递归方法
    List<Integer> li = new ArrayList<Integer>();
    public List<Integer> preorder(Node root) {
        if(root != null) {
            li.add(Integer.valueOf(root.val));
            if(root.children.size()>0){
                for(Node node : root.children){
                    preorder(node);
                }
            }
        }
        return li;
    }
    */
    //迭代方法
    public List<Integer> preorder(Node root) {
        List<Integer> li = new ArrayList<Integer>();
        if(root != null){
            //借助栈的先进后出特点，反向push root的孩子节点
            Stack<Node> s = new Stack<Node>();
            s.push(root);
            while(!s.empty()){
                Node n = s.pop();
                li.add(Integer.valueOf(n.val));
                List<Node> children = n.children;
                if(children.size()>0){
                    //指定ListIterator指向最后一个元素
                    ListIterator lIterator = children.listIterator(children.size());
                    while(lIterator.hasPrevious()){
                        s.push((Node)lIterator.previous());//previous 返回泛型E，这里要强制转换
                    }
                }
            }
        }
        return li;
    }
}
