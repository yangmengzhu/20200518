/*
 * @program: 2020516
 * @description
 * 二叉树遍历
 * @author: mrs.yang
 * @create: 2020 -05 -16 14 :06
 */
/*class Node{
    public char value;
    public Node left;
    public Node right;
    public Node(char value){
        this.value=value;
    }
}
   public class BinaryTree {
    //创建二叉树
       public Node build(){
           Node A=new Node('A');
           Node B=new Node('B');
           Node C=new Node('C');
           Node D=new Node('D');
           Node E=new Node('E');
           Node F=new Node('F');
           Node G=new Node('G');
           Node H=new Node('H');
           A.left=B;
           A.right=C;
           B.left=D;
           B.right=E;
           E.right=H;
           C.left=F;
           C.right=G;
           return A;
       }
       //前序遍历 根=》左=》右
     public void preOrderTravelsal(Node root){
           if(root==null){
               return;
           }
         System.out.print(root.value+" ");
         preOrderTravelsal(root.left);
         preOrderTravelsal(root.right);
     }
     //中序遍历  左=》根=》右
       public void inOrderTravelsal(Node root){
           if(root==null){
               return;
           }
           inOrderTravelsal(root.left);
           System.out.print(root.value+" ");
           inOrderTravelsal(root.right);
       }
       //后序遍历二叉树 左=》右=》根
       public void postOrderTravelsal(Node root){
           if(root==null){
               return;
           }
           postOrderTravelsal(root.left);
           postOrderTravelsal(root.right);
           System.out.print(root.value+" ");
       }
       //遍历思路 求节点个数
       static int size=0;
       public int Number(Node root){
           if(root==null){
               return 0;
           }else{
               Number(root.left);
               Number(root.right);
               size++;
           }
           return size;
       }
       //子问题思路求节点个数 左树+右树+1（根）
       public int Number1(Node root){
           if(root==null){
               return 0;
           }
           return Number1(root.left)+Number1(root.right)+1;
       }
       //求叶子节点个数
       int Leafsize=0;
       public int getLeafsize(Node root){
           if(root==null){
               return 0;
           }
           if(root.left==null&&root.right==null){
               Leafsize++;
           }else{
               getLeafsize(root.left);
               getLeafsize(root.right);
           }
          return Leafsize;
       }
       //子问题思路求叶子节点个数，左树的叶子个数和右树叶子个数之和
       public int getLeafsize1(Node root){
           if(root==null){
               return 0;
           }
           if(root.right==null&&root.left==null){
               return 1;
           }else{
               return getLeafsize1(root.left)+getLeafsize1(root.right);
           }
       }
       //子问题求二叉树高度，左树和右树种最大值+1
       public int getHeight(Node root){
           //递归终止条件
           if(root==null){
               return 0;
           }
           return Math.max(getHeight(root.left),getHeight(root.right))+1;
       }
       //查找val
       public Node find(Node root,char val){
           //递归的终止返回条件
           if(root==null){
               return null;
           }
           //判断根节点是否为val
           if(root.value==val){
               return root;
           }
           //左边查找，判断返回值是否为空，还是不为空
           Node left=find(root.left,val);
           if(left!=null){
               return left;
           }
           //右边查找，不为空返回
           Node right=find(root.right,val);
           if(right!=null){
               return right;
           }
           return null;
       }
       //判断两棵树是否相同
       public boolean isSameTree(Node p,Node q){
           //有一个不为空就不相同
           if((p==null&&q!=null)||(p!=null&&q==null)){
               return false;
           }

           if(p==null && q==null){
               return true;
           }
           //判断根节点是否相同
           if(p.value==q.value){
               return false;
           }
           return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
       }
       //判断t是否是S的子树
       public boolean isSubTree(Node s,Node t){
           if(t==null||s==null){
               return false;
           }
           //1.判断t是不是s本身
           if(isSameTree(t,s)){
               return true;
           }
           //2.判断t是不是S的左树的子树
           if(isSubTree(t,s.left)){
               return true;
           }
           //3.判断t是不是s右树的子树
           if(isSubTree(t,s.right)){
               return true;
           }
           return false;
       }
       //判断一棵树是否是平衡树
       public boolean banlanceTree(Node root){
           //树为空
           if(root==null){
               return true;
           }
           //1.判断根节点的左右两边高度差是否《=
           if(Math.abs(getHeight(root.left)-getHeight(root.right))<=1){
               return true;
           }
           //2.递归=》判断左子树是否平衡
           //3.递归判断右子树是否平衡
           return banlanceTree(root.left)&&banlanceTree(root.right);
       }
       //判断是不是对称树
       public Boolean isSymmetric(Node root){
           //1.判断根节点左右，如果有一个为空，就不满足
           if((root.left!=null&&root.right==null)
                   ||((root.right!=null&&root.left==null)){
               return false;
           }
           //2.如果根节点左右都为空，对称
           if(root.left==null&&root.right==null){
               return true;
           }
           return isSymmetricChild(root.left,root.right);
       }
       public Boolean isSymmetricChild(Node leftTree,Node rightTree){
           //1.判断值是不是相同
           if(leftTree.value!=rightTree.value){
               return false;
           }
           //2.判断它的左子树的左和右子树的右是否对称
           //3.判断它的左子树的右和右子树的左是否对称
           return isSymmetricChild(leftTree.left,rightTree.right)
                   &&isSymmetricChild(rightTree.left,leftTree.right);
       }
       public static void main(String[] args) {
           BinaryTree binaryTree=new BinaryTree();
           Node root=binaryTree.build();
           binaryTree.inOrderTravelsal(root);
           System.out.println();
           System.out.println(binaryTree.Number(root));
           System.out.println(binaryTree.Number1(root));
           System.out.println(binaryTree.getLeafsize(root));
           System.out.println(binaryTree.getLeafsize1(root));
           System.out.println(binaryTree.getHeight(root));
           System.out.println(binaryTree.find(root, 'F'));
           System.out.println(binaryTree.getHeight(root));
       }
   }*/
