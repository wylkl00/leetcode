package question;

/**
 * Description:
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 *
 *
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 *  
 *
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wangyang
 * @since 2022/3/5
 */

public class LeetCode206E {

    public ListNode reverseList(ListNode head) {
        ListNode listNode = null;
        while (head != null){
            listNode = new ListNode(head.val,listNode);
            head = head.next;
        }

        return listNode;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode206E().reverseList(new ListNode(1, 2, 3, 4, 5)));

    }

}